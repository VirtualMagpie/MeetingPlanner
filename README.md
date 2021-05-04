# MeetingPlanner

Gestionnaire des salles de réunion d'une PME (test technique pour entretien Canal+)

### Techno

- Java 11
- Spring Boot 2.4.5
- PostgreSQL 11.4
- Docker (requis pour les tests d'intégration du backend -> requiert l'image postgres:11.4)

### Creation base de donnees PostgreSQL

Via pgAdmin :

- création d'un nouvel utilisateur 'meeting_planner'
- création d'une nouvelle db 'meeting-planner' avec comme owner l'utilisateur 'meeting_planner'

### Next steps

- Création d'un frontal (en React ?) qui exploite cette API
- Implémenter l'authentification/autorisation sur ce backend :
  - utiliser un id provider (Keycloak ?) pour identifier les utilisateurs
  - sécuriser les routes (avec Spring Security) pour qu'elles ne soient utilisables que par un utilisateur connecté
  - définir les autorisations de chaque route (par exemple, l'attribut "idReservateur" associé à une réservation a justement été créé à cette fin - si on souhaite plus tard définir une route pour modifier ou supprimer une réservation, une telle action serait par exemple accessible uniquement à l'utilisateur ayant créé la réservation (ou un utilisateur admin))
- Ajouter plus de routes selon les besoins détectés dans le front (par exemple pour afficher dans le front la liste des matériels existants, pour afficher une recherche des réservations selon certains critères, ou encore pour permettre à un administrateur de modifier le contenu des autres tables)
- Gérer la concurrence : des réservations incompatbles mais effectuées en même temps sont actuellement possible. Il faut ajouter un lock sur la table des réservations.
- Optimiser l'algorithme de choix des salles. Pour l'instant seule une version 1 basique a été implémentée (qui arrive à 90% de réussite sur la séquence de réservation proposée dans l'énoncé). Il faudrait faire un état de l'art des algorithmes d'optimisation pour ce type de problème. Attention : il faut prendre en compte que les réservations arrivent au fil de l'eau, il n'est donc pas possible de choisir un algorithme qui optimise l'ensemble des réservations passées et futurs.
