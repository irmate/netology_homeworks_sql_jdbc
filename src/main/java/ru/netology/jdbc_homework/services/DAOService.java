package ru.netology.jdbc_homework.services;

import org.springframework.stereotype.Service;
import ru.netology.jdbc_homework.repositorys.DAORepository;

import java.util.List;

@Service
public class DAOService {
    DAORepository daoRepository;

    public DAOService(DAORepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    public List<String> getProductName(String name) {
        return daoRepository.getProductName(name);
    }
}