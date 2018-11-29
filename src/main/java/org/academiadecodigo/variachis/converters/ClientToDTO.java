package org.academiadecodigo.variachis.converters;

import org.academiadecodigo.variachis.command.ClientDto;
import org.academiadecodigo.variachis.persistence.model.Client;
import org.academiadecodigo.variachis.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientToDTO {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public ClientDto convert(Client client) {

        ClientDto clientDto = new ClientDto();

        clientDto.setAge(client.getAge());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setHeartBeats(client.getHeartBeats());
        clientDto.setHeight(client.getHeight());
        clientDto.setWeight(client.getWeight());

        return clientDto;

    }

}
