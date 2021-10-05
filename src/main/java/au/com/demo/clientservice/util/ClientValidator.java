package au.com.demo.clientservice.util;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import au.com.demo.clientservice.client.v1.model.Client;
import au.com.demo.clientservice.client.v1.model.ValidationError;
import au.com.demo.clientservice.client.v1.model.ValidationErrorResponse;
import au.com.demo.clientservice.exceptions.ValidationException;

@Service
public class ClientValidator {
    private static final String ERROR = "error";
    private static final String VALIDATION_FAILED = "validation_failed";
    private static final String VALUE_NOT_ALLOWED = "value_not_allowed";

    public void validate(Client client) {
        Set<ValidationError> validationErrors = new HashSet<>();

        if(StringUtils.isNotEmpty(client.getNewPassword()) && StringUtils.isNotEmpty(client.getConfirmNewPassword())) {
            if(!client.getNewPassword().equals(client.getConfirmNewPassword())) {
                validationErrors.add(createValidationError(
                        VALUE_NOT_ALLOWED,
                        VALIDATION_FAILED,
                        ERROR,
                        "New password and Confirm password should match.",
                        "new_password"));
            }
        }

        throwValidationException(validationErrors);
    }

    private ValidationError createValidationError(String code, String category, String severity, String desc, String field) {
        ValidationError errorsItem = new ValidationError();
        return errorsItem.code(code)
                .category(category)
                .severity(severity)
                .description(desc)
                .field(field);
    }

    private void throwValidationException(Set<ValidationError> validationErrors) {
        if(null != validationErrors && !validationErrors.isEmpty()) {
            ValidationErrorResponse resp = new ValidationErrorResponse();
            for (ValidationError ve : validationErrors) {
                resp.addErrorsItem(ve);
            }
            throw new ValidationException().response(resp);
        }
    }
}
