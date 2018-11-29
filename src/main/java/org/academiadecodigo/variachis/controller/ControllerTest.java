package org.academiadecodigo.variachis.controller;

import org.academiadecodigo.variachis.persistence.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ControllerTest {

    private ServiceTest serviceTest;

    @Autowired
    public void setServiceTest(ServiceTest serviceTest) {
        this.serviceTest = serviceTest;
    }

    public Client show(Integer id) {
        return serviceTest.show(id);
    }
}
