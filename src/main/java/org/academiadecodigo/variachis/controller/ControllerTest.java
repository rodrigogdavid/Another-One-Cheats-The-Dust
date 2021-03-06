package org.academiadecodigo.variachis.controller;

import org.academiadecodigo.variachis.command.ClientDto;
import org.academiadecodigo.variachis.converters.ClientToDTO;
import org.academiadecodigo.variachis.converters.DTOtoClient;
import org.academiadecodigo.variachis.persistence.model.Client;
import org.academiadecodigo.variachis.persistence.model.Habit;
import org.academiadecodigo.variachis.services.ClientService;
import org.academiadecodigo.variachis.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/client")
public class ControllerTest {

    private ClientService clientService;
    private HabitService habitService;
    private DTOtoClient dtOtoClient;
    private ClientToDTO clientToDTO;


    @Autowired
    public void setHabitService(HabitService habitService) {
        this.habitService = habitService;
    }

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

    @RequestMapping(method = RequestMethod.GET, path = {"", "/"})
    public String mainView() {
        return "main-view";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String loginView(Model model) {
        ClientDto clientDto = new ClientDto();

        model.addAttribute("client", clientDto);

        return "client/loginForm";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/newClient")
    public String formView(Model model) {
        ClientDto clientDto = new ClientDto();

        model.addAttribute("client", clientDto);

        return "client/client-form";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showClient(@PathVariable Integer id, Model model) {
        Client client = clientService.get(id);
        Habit habit = habitService.get(id);

        model.addAttribute("client", clientToDTO.convert(client, habit));

        return "client/status-view";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/loginDone")
    public String loginView(@Valid @ModelAttribute("client") ClientDto clientDto, Model model, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return "client/loginForm";
        }

        Client client = clientService.findByName(clientDto.getFirstName(), clientDto.getLastName());

        if (client == null) {
            return "redirect:/client/loginForm";

        }

        clientDto = clientToDTO.convert(client, client.getHabit());

        model.addAttribute("client", clientDto);

        return "redirect:/client/" + clientDto.getId();

    }

    @RequestMapping(method = RequestMethod.POST, path = "/newClient")
    public String newClient(@Valid @ModelAttribute("client") ClientDto clientDto, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return "client/loginForm";
        }

        Client client = dtOtoClient.convert(clientDto);

        System.out.println("DTO TO CLIENT " + client);

        if (client == null) {
            return "client/loginForm";

        }

        client = clientService.save(client);

        System.out.println("SAVED CLIENT " + client);

        clientDto = clientToDTO.convert(client, client.getHabit());

        return "redirect:/client/" + clientDto.getId();

    }

    @RequestMapping(method = RequestMethod.GET, path = "/health/{id}")
    public String healthView(@PathVariable Integer id, Model model) {
        Client client = clientService.get(id);
        Habit habit = habitService.get(id);

        if(client.getScore() > 65){
            return "client/critical-view";
        }

        if(client.getScore() > 45 && client.getScore() <= 65){
            return "client/advice-view";
        }



        model.addAttribute("client", clientToDTO.convert(client, habit));

        return "client/healthy-view";
    }

}
