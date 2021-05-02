package com.example.meetingplanner.service;

import com.example.meetingplanner.model.EntitiesToBook;
import com.example.meetingplanner.model.Reservation;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * Service servant à effectuer une réservation sur des entités choisies
 */
@Service
public class AddReservationService {

    public Reservation addReservation(
            EntitiesToBook entitiesToBook,
            String idReservateur,
            Integer idTypeReunion,
            Instant debut,
            Instant fin
    ) {
        // TODO: to implement
        return Reservation.builder().build();
    }

    // TODO: penser à vérifier que les entités n'ont pas été réservées entre temps (et à ouvrir une transaction pour
    //  être sûr qu'elle ne le sont pas également pendant cette sauvegarde)
}
