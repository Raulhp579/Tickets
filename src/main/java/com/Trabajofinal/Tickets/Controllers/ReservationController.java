package com.Trabajofinal.Tickets.Controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Trabajofinal.Tickets.Entities.Reservation;
import com.Trabajofinal.Tickets.Entities.Seat;
import com.Trabajofinal.Tickets.Services.ReservationService;
import com.Trabajofinal.Tickets.Services.SeatService;


@RestController
@RequestMapping("/seats")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private SeatService seatService;

    @GetMapping("/{zoneId}")
    public List<Seat> obtenerAsientosZona(@PathVariable("zoneId") Long idZone) {
        return seatService.ObtenerAsientosPorZonas(idZone);
    }

    @PostMapping("/reserve")
    public ResponseEntity<String> reservar(@RequestBody HashMap<String, Object> request) {// usamos un mapa para recivir
                                                                                          // del JSON ya que da
                                                                                          // problemas sin un DTO {
        Long seatId = Long.valueOf(request.get("seatId").toString());
        String email = request.get("userEmail").toString();

        Seat seat = seatService.obtenerPorId(seatId);

        if (seat == null || seat.isReserved()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Asiento no disponible");
        }

        seat.setReserved(true);
        seatService.guardar(seat);
        Reservation reservation = new Reservation(email, seat);

        reservationService.guardarReserva(reservation);

        return ResponseEntity.ok("Reserva realizada con éxito");
    }

}
