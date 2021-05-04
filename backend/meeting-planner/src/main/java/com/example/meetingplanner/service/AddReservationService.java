package com.example.meetingplanner.service;

import com.example.meetingplanner.model.EntitiesToBook;
import com.example.meetingplanner.model.Reservation;
import com.example.meetingplanner.model.TypeReunion;
import com.example.meetingplanner.service.db.ReservationDbService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

/** Service servant à effectuer une réservation sur des entités choisies */
@AllArgsConstructor
@Service
public class AddReservationService {

  private final ReservationDbService reservationDbService;

  public Reservation addReservation(
      EntitiesToBook entitiesToBook,
      String idReservateur,
      Integer idTypeReunion,
      Instant debut,
      Instant fin) {

    // TODO: penser à vérifier que les entités n'ont pas été réservées entre temps (et à ouvrir une
    //  transaction pour être sûr qu'elles ne le sont pas également pendant cette sauvegarde)

    return reservationDbService.save(
        Reservation.builder()
            .idReservateur(idReservateur)
            .typeReunion(TypeReunion.builder().id(idTypeReunion).build())
            .salle(entitiesToBook.getSalle())
            .materielsMobiles(entitiesToBook.getMaterielsMobiles())
            .debut(debut)
            .fin(fin)
            .build());
  }
}
