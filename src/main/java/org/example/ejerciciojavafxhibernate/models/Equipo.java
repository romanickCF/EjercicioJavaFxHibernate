package org.example.ejerciciojavafxhibernate.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String nombre;
    private String categoria;
    private Boolean disponible;
}
