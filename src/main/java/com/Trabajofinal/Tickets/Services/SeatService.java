package com.Trabajofinal.Tickets.Services;

import com.Trabajofinal.Tickets.Entities.Seat;
import com.Trabajofinal.Tickets.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> ObtenerAsientosPorZonas(Long zoneId) {
        return seatRepository.findByZoneId(zoneId);
    }

    public Seat obtenerPorId(Long id) {
        return seatRepository.findSeatById(id);
    }

    public Seat guardar(Seat seat) {
        return seatRepository.save(seat);
    }
}
