package com.example.sa03.view;

import com.example.sa03.controller.Controller;
import com.example.sa03.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ClientView {

    @Autowired
    Controller controller;

    @GetMapping("/cliente")
    public Client findClient(@PathParam("name") String name){
        return controller.findClient(name);
    }

    @PostMapping("/cliente")
    public Client addClient(@PathParam("name") String name, @PathParam("address") String address, @PathParam("modality") String modality){
        return controller.addClient(name, address, modality );
    }

    @PutMapping("/cliente")
    public Client editCLient(@PathParam("name") String name, @PathParam("address") String address, @PathParam("modality") String modality){
        return controller.editCLient(name, address, modality);
    }


    @DeleteMapping("/cliente")
    public String removeClient(@PathParam("name") String name){
        controller.removeClient(name);
        return "Cliente com o nome " + name + " foi excluido.";
    }

    @GetMapping("/all")
    public List<Client> listAll() {
        return controller.listAll();
    }
}


