package ru.netology.jdbc_homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.jdbc_homework.entity.Customer;
import ru.netology.jdbc_homework.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class CommandLineApp implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Random random = new Random();

        var customers = Stream.of("Alexey", "Maxim", "Oleg", "Nadezda")
                .map(v -> Customer.builder()
                        .name(v)
                        .age(random.nextInt(40))
                        .phoneNumber(String.valueOf(random.nextInt(100000000)))
                        .build())
                .collect(Collectors.toUnmodifiableList());

        for (Customer entity : customers) {
            entityManager.persist(entity);
        }

        var productNames = List.of("toys", "vegetables", "tools", "cakes");
        IntStream.range(0, 30)
                .forEach(v -> {
                            var order = Order.builder()
                                    .date(String.valueOf(LocalDateTime.now()))
                                    .productName(productNames.get(random.nextInt(productNames.size())))
                                    .amount(String.valueOf(random.nextInt(10000)))
                                    .customer(customers.get(random.nextInt(customers.size())))
                                    .build();
                            entityManager.persist(order);
                        }
                );
    }
}