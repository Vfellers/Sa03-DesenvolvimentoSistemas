package com.example.sa03.controller;

import com.example.sa03.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Controller {
    @Autowired
    private ClientRepository clientRepository;

    private List<Client> clients = new ArrayList<>();

    private int id =0;

    public Client findClient(String name){
        List<Client> clients = (List<Client>) clientRepository.findAll();
        for(Client c : clients){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public Client addClient(String name, String address, String modality){
        Client c = new Client();
        c.setName(name);
        c.setAddress(address);
        c.setModality(modality);
        id++;
        c.setId(id);
        clientRepository.save(c);
        return c;
    }

    public Client editCLient(String name, String address, String modality){
        Client c = findClient(name);
        c.setName(name);
        c.setAddress(address);
        c.setModality(modality);
        clientRepository.save(c);
        return c;
    }

    public void removeClient(String name){
        Client c = findClient(name);
        clientRepository.delete(c);
    }

    public List<Client> listAll() {
        return (List<Client>) clientRepository.findAll();
    }
}
