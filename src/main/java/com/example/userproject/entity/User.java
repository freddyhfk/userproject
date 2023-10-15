package com.example.userproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TEST")
public class User {

    @Id
    private Long id;
    private String name;
    private String surname;
    private String email;
}
