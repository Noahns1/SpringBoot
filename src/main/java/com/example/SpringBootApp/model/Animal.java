package com.example.SpringBootApp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Animals")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String species;

    private String name;


}
