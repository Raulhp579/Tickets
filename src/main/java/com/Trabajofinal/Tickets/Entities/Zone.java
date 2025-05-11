package com.Trabajofinal.Tickets.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Double precio;

    @NonNull
    private Double x;

    @NonNull
    private Double y;

    @NonNull
    private Double ancho;

    @NonNull
    private Double alto;

    @NonNull
    private Boolean disponible;

    @NonNull
    private Integer match_id;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "zone")
    private List<Seat> seats;
}
