package com.demo.ms;

import com.demo.ms.infraestructure.adapter.output.entity.CardEntity;
import com.demo.ms.infraestructure.adapter.output.repository.CardRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class MetroCardApplication implements CommandLineRunner {

    private final CardRepositoryAdapter cardRepositoryAdapter;

    public static void main(String[] args) {
        SpringApplication.run(MetroCardApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<CardEntity> list = Arrays.asList(
                new CardEntity(null, UUID.randomUUID().toString(),
                        "Andrew",
                        "Hernandez",
                        "Venezuela - Av Andres Bello",
                        100.0),
                new CardEntity(null, UUID.randomUUID().toString(),
                        "Cesar",
                        "cg",
                        "Peru - Av Andres Bello",
                        110.0),
                new CardEntity(null, UUID.randomUUID().toString(),
                        "Juan",
                        "Jose",
                        "Peru - Av Andres Bello",
                        120.0),
                new CardEntity(null, UUID.randomUUID().toString(),
                        "José",
                        "Rivas",
                        "Peru - Av Andres Bello",
                        130.0),
                new CardEntity(null, UUID.randomUUID().toString(),
                        "German",
                        "Gomez",
                        "Peru - Av Andres Bello",
                        140.0),
                new CardEntity(null, UUID.randomUUID().toString(),
                        "Juan",
                        "José",
                        "Peru - Av Andres Bello",
                        150.0)
        );
        cardRepositoryAdapter.saveAll(list);
    }
}
