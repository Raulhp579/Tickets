package com.Trabajofinal.Tickets.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Trabajofinal.Tickets.Entities.Zone;
import com.Trabajofinal.Tickets.Repository.ZoneRepository;

@RestController
@RequestMapping("/zones")
@CrossOrigin(origins = "http://localhost:3000") 
public class ZoneController {

    @Autowired
    private ZoneRepository zoneRepo;

    @GetMapping("/{id}")
    public List<Zone> getZonesByMatch(@PathVariable("id") Integer matchId) {
        return this.zoneRepo.obtenerZona(matchId);
    }
}
