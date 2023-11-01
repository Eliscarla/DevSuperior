package com.dessafiocrud.Desafio.dto;

import com.dessafiocrud.Desafio.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDto {
    private String cpf;

    @NotBlank(message = "Campo name é requerido!")
    private String name;
    private Double income;

    @PastOrPresent(message = "Data precisa ser igual ou anterior a data atual")
    @NotNull(message = "Campo birthDate não pode ser nulo")
    private LocalDate birthDate;
    private Integer children;

    public ClientDto(Client client) {
        this.cpf = client.getCpf();
        this.name = client.getName();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();
    }
    public ClientDto(String cpf, String name, Double income, LocalDate birthDate, Integer children) {
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
