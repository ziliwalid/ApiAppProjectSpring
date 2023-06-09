package com.example.apiapp.Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "t_Games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String GameName;
    private String Genre;
    private int yearOfProduction;
    private String Story;
}
