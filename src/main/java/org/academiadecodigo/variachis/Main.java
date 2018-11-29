package org.academiadecodigo.variachis;

import org.academiadecodigo.variachis.controller.ControllerTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-config.xml");

        ControllerTest controllerTest = context.getBean("controllerTest", ControllerTest.class);

        controllerTest.show(1);

    }
}
