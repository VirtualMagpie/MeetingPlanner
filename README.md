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
