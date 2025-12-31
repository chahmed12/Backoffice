# Backoffice Dentiste - Gestion Clinique Dentaire

## Description du Projet

**Backoffice** est une application web d'administration et de gestion pour une clinique dentaire. Elle permet de gérer les patients, les dentistes, les rendez-vous, les actes médicaux et les services fournis par la clinique.

## Caractéristiques Principales

- 📋 **Gestion des patients** : Création, modification, suppression et consultation des dossiers patients
- 👨‍⚕️ **Gestion des dentistes** : Administration du personnel médical
- 📅 **Gestion des rendez-vous** : Planification et suivi des consultations
- 🏥 **Actes médicaux** : Enregistrement et historique des actes effectués
- 🔧 **Services médicaux** : Gestion du catalogue des services proposés
- 📢 **Publications** : Partage d'actualités et d'informations
- 🔐 **Authentification** : Système d'authentification des utilisateurs

## Architecture du Projet

### Structure Technique

```
src/main/java/com/dentist/
├── entity/                 # Entités JPA (modèles de données)
│   ├── ActeMedical.java
│   ├── Dentiste.java
│   ├── Patient.java
│   ├── Publication.java
│   ├── Rendezvous.java
│   └── ServiceMedical.java
├── dao/                    # Couche d'accès aux données
│   ├── impl/              # Implémentations DAO
│   │   ├── ActeMedicalDAOImpl.java
│   │   ├── DentisteDAOImpl.java
│   │   ├── PatientDAOImpl.java
│   │   ├── PublicationDAOImpl.java
│   │   ├── RendezvousDAOImpl.java
│   │   └── ServiceMedicalDAOImpl.java
│   └── interfaces/        # Interfaces locales (EJB)
│       ├── IActeMedicalLocal.java
│       ├── IDentisteLocal.java
│       ├── IPatientLocal.java
│       ├── IPublicationLocal.java
│       ├── IRendezvousLocal.java
│       └── IServiceMedicalLocal.java
└── rest/                  # API REST
    └── ressources/
        ├── ActeMedicalResource.java
        ├── AuthResource.java
        ├── DentisteResource.java
        ├── PatientResource.java
        ├── PublicationRessource.java
        ├── RendezvousResource.java
        ├── RestConfig.java
        └── ServiceMedicalResource.java
```

### Modèle Architectural

**Pattern utilisé** : MVC (Model-View-Controller) avec séparation en couches
- **Model** : Entités JPA (`com.dentist.entity`)
- **DAO** : Couche métier et accès données (`com.dentist.dao`)
- **View/Controller** : API REST (`com.dentist.rest.ressources`)

## Technologies Utilisées

| Composant | Technologie | Version |
|-----------|-------------|---------|
| Framework | Jakarta EE / GlassFish | 5.0+ |
| ORM | Hibernate | JPA 3.0 |
| Persistance | MySQL | 8.0+ |
| API | Jakarta REST (JAX-RS) | 3.0+ |
| Architecture | EJB (Enterprise JavaBeans) | 4.0+ |
| Build | Maven / Eclipse Project | - |

## Base de Données

### Connexion
- **Source JNDI** : `java:/MySqlDS`
- **Dialecte Hibernate** : `MySQL8Dialect`
- **Génération de schéma** : Automatique (mode "update")

### Entités Principales

| Entité | Description |
|--------|-------------|
| `Patient` | Patients inscrits à la clinique |
| `Dentiste` | Professionnels de santé |
| `Rendezvous` | Consultations planifiées |
| `ActeMedical` | Interventions effectuées |
| `ServiceMedical` | Services offerts par la clinique |
| `Publication` | Actualités et communications |

## Points d'Accès API

- **URL de base** : `/api`
- **Endpoints disponibles** :
  - `/api/patients` - Gestion des patients
  - `/api/dentistes` - Gestion des dentistes
  - `/api/rendezvous` - Gestion des rendez-vous
  - `/api/actes-medicaux` - Gestion des actes
  - `/api/services-medicaux` - Gestion des services
  - `/api/publications` - Gestion des publications
  - `/api/auth` - Authentification

## Configuration Requise

### Prérequis
- **JDK** : Java 11 ou supérieur
- **Serveur d'application** : GlassFish / Jakarta EE compatible
- **Base de données** : MySQL 8.0+
- **Gestionnaire de dépendances** : Maven

### Installation de l'Environnement

```bash
# [À compléter avec les étapes d'installation]
1. Cloner le repository
2. Configurer la source de données MySQL
3. Configurer le fichier persistence.xml
4. Builder le projet (Maven)
5. Déployer sur le serveur d'application
```

## Fichiers de Configuration

- **`web.xml`** : Configuration web (serveur d'application)
- **`persistence.xml`** : Configuration JPA/Hibernate
- **`.classpath`** : Classpath du projet Eclipse
- **`.project`** : Configuration du projet Eclipse

## Dépendances Maven

```xml
<!-- À lister dans pom.xml -->
- Jakarta EE APIs
- Hibernate ORM
- Jakarta REST (JAX-RS)
- MySQL JDBC Driver
```

## Authentification & Sécurité

- **Classe responsable** : `AuthResource.java`
- **Données sensibles** : Mot de passe patient (`mdpP`) stocké en base
- **À implémenter** : [À détailler selon votre stratégie]

## Guide d'Utilisation

### Pour les Développeurs

```bash
# Compiler le projet
mvn clean compile

# Builder l'application
mvn clean package

# Déployer sur GlassFish
# [Ajouter les commandes de déploiement]
```

### Pour les Administrateurs

- Accéder au backoffice via [URL à définir]
- Gérer les utilisateurs et patients
- Consulter les statistiques
- Configurer les services médicaux

## Maintenance & Support

### Logs
- **Localisation** : `build/classes/`
- **Format** : Hibernate SQL logging activé (voir `persistence.xml`)

### Sauvegarde
- Base de données MySQL : Sauvegarde recommandée [périodicité à définir]

### Mises à Jour
- Procédure de mise à jour : [À documenter]
- Version actuelle : [À définir]

## Roadmap & Améliorations Futures

- [ ] Intégration d'un système de paiement
- [ ] Notifications par email/SMS
- [ ] Interface de gestion avancée
- [ ] Rapports et statistiques
- [ ] Système de documents médicaux
- [ ] [Autres fonctionnalités planifiées]

## Contribution

### Standards de Code
- Convention de nommage Java standard
- Architecture en couches respectée
- Commentaires JavaDoc pour les méthodes publiques

### Procédure de Contribution
1. Créer une branche feature
2. Implémenter les modifications
3. Tester localement
4. Créer une pull request

## Licence

[À spécifier : MIT, Apache 2.0, etc.]

## Auteur(s) & Contact

- **Développeur** : [À compléter]
- **Responsable du projet** : [À compléter]
- **Email de support** : [À compléter]
- **Repository** : https://github.com/chahmed12/Backoffice

## Notes Additionnelles

- Le projet utilise Jakarta EE 5.0 (dernière génération)
- Hibernate est configuré pour afficher les requêtes SQL (utile en développement)
- [Ajouter d'autres notes importantes]

---

**Date de création du README** : 31 décembre 2025  
**Dernière mise à jour** : [À compléter lors de modifications]
