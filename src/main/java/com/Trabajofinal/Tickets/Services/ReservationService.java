package com.Trabajofinal.Tickets.Services;

import com.Trabajofinal.Tickets.Entities.Reservation;
import com.Trabajofinal.Tickets.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation guardarReserva(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getUsuarioPorEmail(String email) {
        return reservationRepository.findByUserEmail(email);
    }
}
