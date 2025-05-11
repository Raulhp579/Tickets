package com.Trabajofinal.Tickets.Entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String userEmail;

    private LocalDateTime reservationTime = LocalDateTime.now();

    
    @ManyToOne
    @JoinColumn(name = "seat_id")
    @NonNull
    private Seat seat;
}

