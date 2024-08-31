package com.demo.ms.infraestructure.adapter.output.repository;

import com.demo.ms.infraestructure.adapter.output.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepositoryAdapter extends JpaRepository<CardEntity, String> {

    void deleteByHashCode (String hashCode);
    Optional<CardEntity> findByHashCode (String hashCode);

}