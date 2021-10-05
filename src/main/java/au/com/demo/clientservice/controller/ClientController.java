package au.com.demo.clientservice.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.demo.clientservice.client.v1.api.ClientApi;
import au.com.demo.clientservice.client.v1.model.Client;
import au.com.demo.clientservice.service.ClientService;
import au.com.demo.clientservice.service.NotificationService;
import au.com.demo.clientservice.util.ClientValidator;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Validated
@RequestMapping("/client")
@RequiredArgsConstructor
@Log4j2
@Api(value = "/client", tags = { "Client Management API" })
public class ClientController extends AbstractController implements ClientApi {

    private final ClientService clientService;
    private final NotificationService notificationService;
    private final ClientValidator clientValidator;

    @Override
    @RequestMapping(value = "/client/updatePassword",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<String> updatePassword(@Valid @RequestBody Client client) {
        clientValidator.validate(client);

        boolean updated = clientService.updatePassword(client);

        if(updated) {
            notificationService.sendNotification("Successfully updated Password for email "+ client.getEmail());
            return new ResponseEntity<>(writeToResponse("Successfully updated Password."));
        }
        return new ResponseEntity<>(writeToResponse("Failed to update Password."));
    }
}
