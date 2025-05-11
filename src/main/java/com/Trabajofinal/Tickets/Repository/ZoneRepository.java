package com.Trabajofinal.Tickets.Repository;

import com.Trabajofinal.Tickets.Entities.Zone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ZoneRepository extends JpaRepository<Zone, Long> {

   @Query("SELECT a FROM Zone a WHERE a.match_id = :id")
   List<Zone> obtenerZona(@Param("id")Integer id);

}
