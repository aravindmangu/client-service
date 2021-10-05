package au.com.demo.clientservice.entity.mapper;

import au.com.demo.clientservice.client.v1.model.Client;
import au.com.demo.clientservice.entity.ClientEntity;

public class ClientMapper {

    private ClientMapper(){}

    public static ClientEntity toEntity(Client client) {
        ClientEntity ce = new ClientEntity();
        ce.setPassword(client.getNewPassword());
        ce.setEmail(client.getEmail());
        return ce;
    }

    public static Client toModel(ClientEntity clientEntity) {
        Client cl = new Client();
        cl.setEmail(clientEntity.getEmail());
        return cl;
    }
}
