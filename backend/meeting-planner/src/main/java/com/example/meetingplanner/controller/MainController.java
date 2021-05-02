package com.example.meetingplanner.controller;

import com.example.meetingplanner.model.Reservation;
import com.example.meetingplanner.model.request.ReservationCreateRequest;
import com.example.meetingplanner.service.MainBookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping
public class MainController {

    private final MainBookingService mainBookingService;

    @GetMapping("/reservation/list")
    public Set<Reservation> getReservationList() {
        // TODO: to implement
        return Collections.emptySet();
    }

    // TODO: ajouter récupération des types de réunion
    // TODO: ajouter récupération des types de matériel ?

    @PostMapping("/reservation/create")
    public Reservation postReservationCreate(@RequestBody ReservationCreateRequest body) {
        // TODO: get idReservateur from http header instead
        String idReservateur = "foobar";
        return mainBookingService.findAndBook(
                body.getIdTypeReunion(),
                body.getNombrePersonne(),
                body.getDebut(),
                body.getFin(),
                idReservateur
        );
    }
}
