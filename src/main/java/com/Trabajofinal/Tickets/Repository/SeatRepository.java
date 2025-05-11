package com.Trabajofinal.Tickets.Repository;

import com.Trabajofinal.Tickets.Entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByZoneId(Long zoneId);

    @Query("SELECT s FROM Seat s WHERE s.zone.id = :zoneId AND s.reserved = false")
    List<Seat> findAvailableSeatsByZoneId(Long zoneId);

    Seat findSeatById(Long id);
}
