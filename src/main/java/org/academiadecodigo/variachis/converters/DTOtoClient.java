package org.academiadecodigo.variachis.converters;

import org.academiadecodigo.variachis.command.ClientDto;
import org.academiadecodigo.variachis.persistence.model.Client;
import org.academiadecodigo.variachis.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOtoClient {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public Client convert(ClientDto clientDto) {

        Client client = (clientDto.getId() != null ? clientService.get(clientDto.getId()) : new Client());

        client.setAge(clientDto.getAge());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setHearthBeats(clientDto.getHeartBeats());
        client.setHeight(clientDto.getHeight());
        client.setWeight(clientDto.getWeight());

        return client;

    }
}
