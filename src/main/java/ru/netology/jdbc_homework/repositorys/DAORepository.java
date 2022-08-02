package ru.netology.jdbc_homework.repositorys;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DAORepository {
    @PersistenceContext
    EntityManager entityManager;

    String script;

    public DAORepository() {
        script = read("select.sql");
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List getProductName(String name) {
        return (List) entityManager
                .createQuery(script)
                .setParameter("name", name)
                .getResultStream()
                .distinct()
                .collect(Collectors.toList());
    }
}