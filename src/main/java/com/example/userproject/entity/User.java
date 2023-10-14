package com.example.userproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TEST")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String surname;
    String email;
}
