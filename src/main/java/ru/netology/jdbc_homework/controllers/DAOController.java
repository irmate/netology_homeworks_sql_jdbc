package ru.netology.jdbc_homework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbc_homework.services.DAOService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/")
public class DAOController {
    DAOService daoService;

    public DAOController(DAOService daoService) {
        this.daoService = daoService;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@PathParam("name") String name) {
        return daoService.getProductName(name);
    }
}