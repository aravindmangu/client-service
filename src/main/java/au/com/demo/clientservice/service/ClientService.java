package au.com.demo.clientservice.service;

import au.com.demo.clientservice.client.v1.model.Client;

public interface ClientService {
    boolean updatePassword(Client client);
}
