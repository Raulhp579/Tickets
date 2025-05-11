package com.Trabajofinal.Tickets.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "fila")
    private Integer rowNumber;

    @NonNull
    @Column(name = "columna")
    private Integer columnNumber;

    private boolean reserved = false;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    @JsonBackReference
    @NonNull
    private Zone zone;
}