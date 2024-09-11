# Centralisation et Suivi des Demandes de Formation

## Description

Une application web intuitive conçue pour centraliser et gérer efficacement les demandes de formation au sein de votre entreprise. Elle permet aux collaborateurs de soumettre des demandes de formation, de suivre leur état, et d'évaluer les sessions suivies. Les responsables et le service RH peuvent valider les demandes, gérer les formations, consulter les suggestions des collaborateurs, et analyser les feedbacks pour améliorer les offres de formation.

### Cas d'utilisation par rôle

1. **Responsable de pôle** :
   - Gestion des formations : Créer, modifier, supprimer des formations, assigner des formateurs, et planifier des sessions.
   - Gestion des demandes des collaborateurs : Consulter, approuver ou rejeter les demandes de formation soumises par les collaborateurs.
   - Consultation des suggestions de formation : Consulter les suggestions de nouvelles formations soumises par les collaborateurs et décider de leur mise en œuvre.

2. **RH** :
   - Gestion des formations : Créer, modifier, supprimer des formations, assigner des formateurs, et planifier des sessions.
   - Gestion des demandes des collaborateurs : Consulter, approuver ou rejeter les demandes de formation soumises par les collaborateurs.
   - Créer des feedbacks par formation : Solliciter et centraliser les retours des collaborateurs sur les formations suivies pour évaluation.
   - Consultation des suggestions de formation : Consulter les suggestions de nouvelles formations soumises par les collaborateurs et décider de leur pertinence pour les objectifs de l'entreprise.

3. **Collaborateur** :
   - Créer une demande pour rejoindre une formation : Rechercher et soumettre une demande pour participer à une formation.
   - Suivre l'historique des formations : Consulter les formations suivies avec les détails de chaque session.
   - Suivre l'historique des demandes : Suivre l’état de ses demandes de formation (en attente, validée, refusée).
   - Évaluer les formations suivies : Donner une note et un retour sur chaque formation suivie.
   - Créer des suggestions de formation : Proposer de nouvelles formations que le collaborateur aimerait suivre ou qu'il juge bénéfiques pour l'équipe.

4. **Chef de projet** :
   - Validation des demandes : Approuver ou rejeter les demandes de formation soumises par les membres de l'équipe.
   - Consultation de l'historique des demandes : Suivre les demandes de formation de son équipe.

## Fonctionnalités

- **Authentification et autorisation** : Inscription des utilisateurs, connexion avec JWT, gestion des rôles.
- **Gestion des formations** : Création, modification, suppression, et consultation des formations et sessions.
- **Gestion des demandes** : Soumission, suivi, et évaluation des demandes de formation.
- **Feedback et suggestions** : Collecte des retours sur les formations et propositions de nouvelles formations.

## Prérequis

- Java 17+
- MySQL
- Maven
- Spring Boot 3.3.3

## Installation

1. **Clonez le dépôt :**

   ```bash
   git clone https://github.com/mariembsd/Training
   ```
   
2. **Accédez au répertoire du projet :**
   ```bash
   cd Training
   ```
3. **Configurez votre base de données :**

  - Assurez-vous que MySQL est installé et en cours d'exécution.
  - Créez une base de données nommée training_db.
  - Modifiez le fichier src/main/resources/application.properties pour configurer la connexion à votre base de données.

4. **Installez les dépendances :**
  ```bash
  mvn install
  ```

5. **Démarrez l'application :**

  ```bash
  mvn spring-boot:run
```
## API Documentation
Swagger UI : Accédez à http://localhost:8080/swagger-ui.html pour la documentation interactive de l'API.
