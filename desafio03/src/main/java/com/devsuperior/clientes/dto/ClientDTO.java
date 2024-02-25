package com.devsuperior.clientes.dto;

import com.devsuperior.clientes.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;

    @NotBlank(message = "O nome do cliente precisa ser informado.")
    private String name;
    private String cpf;
    private Double income;

    @PastOrPresent(message = "A data de nascimento não pode ser superior a hoje.")
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client entityClient) {
        id = entityClient.getId();
        name = entityClient.getName();
        cpf = entityClient.getCpf();
        income = entityClient.getIncome();
        birthDate = entityClient.getBirthDate();
        children = entityClient.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
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
