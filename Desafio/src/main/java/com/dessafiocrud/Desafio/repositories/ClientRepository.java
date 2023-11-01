package com.dessafiocrud.Desafio.repositories;

import com.dessafiocrud.Desafio.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
