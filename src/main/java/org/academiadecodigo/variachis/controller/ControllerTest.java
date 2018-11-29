package org.academiadecodigo.variachis.controller;

import org.academiadecodigo.variachis.converters.ClientToDTO;
import org.academiadecodigo.variachis.converters.DTOtoClient;
import org.academiadecodigo.variachis.persistence.model.Client;
import org.academiadecodigo.variachis.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/client")
public class ControllerTest {

    private ClientService clientService;
    private DTOtoClient dtOtoClient;
    private ClientToDTO clientToDTO;

    @Autowired
    public void setClientToDTO(ClientToDTO clientToDTO) {
        this.clientToDTO = clientToDTO;
    }

    @Autowired
    public void setDtOtoClient(DTOtoClient dtOtoClient) {
        this.dtOtoClient = dtOtoClient;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showClient(@PathVariable Integer id, Model model) {
        Client client = clientService.get(id);

        model.addAttribute("client", clientToDTO.convert(client));

        return "client/show";

    }

}
