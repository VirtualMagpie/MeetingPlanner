package com.example.meetingplanner;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties("meetingplanner.restrictions")
public class RestrictionsCovidProperties {
  // TODO: valider au lancement les valeurs (non null, positives, 0 < ration <= 1)

  /** Nombre de minutes avant la réunion, pendant lesquelles la salle doit être libre. */
  private Integer minuteLibreAvant;

  /**
   * Ratio de la capacité initiale d'une salle, pour en déterminer la capacité effective.
   *
   * <p>Ex : salle de capacité initiale 10, ratio de 0.7 => 7 personnes max dans la salle
   */
  private Float ratioCapacite;
}
