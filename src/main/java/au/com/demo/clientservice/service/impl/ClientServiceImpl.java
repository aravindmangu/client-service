package au.com.demo.clientservice.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import au.com.demo.clientservice.client.v1.model.Client;
import au.com.demo.clientservice.entity.ClientEntity;
import au.com.demo.clientservice.exceptions.PasswordMismatchException;
import au.com.demo.clientservice.exceptions.RecordNotFoundException;
import au.com.demo.clientservice.repository.ClientRepository;
import au.com.demo.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean updatePassword(Client client) {
        Optional<ClientEntity> optionalRecord = repo.findByEmail(client.getEmail());

        if(!optionalRecord.isPresent()) {
            log.error("Client with email " + client.getEmail() + " does not exist.");
            throw new RecordNotFoundException("Client with email " + client.getEmail() + " does not exist.");
        }

        ClientEntity ce = optionalRecord.get();
        if(!passwordEncoder.matches(client.getOldPassword(), ce.getPassword())) {
            log.error("Old Password doesn't match with the current password.");
            throw new PasswordMismatchException("Old Password doesn't match with the current password.");
        }

        ce.setPassword(passwordEncoder.encode(client.getNewPassword()));

        ClientEntity ce1 = repo.save(ce);
        log.info("Updated password for client with email "+ ce1.getEmail());
        return true;
    }

}
