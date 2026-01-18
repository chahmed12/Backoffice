# 🦷 Backoffice - Dental Clinic Management System

## Overview

**Backoffice** is a comprehensive RESTful web application for managing a dental clinic. It provides backend services for patient management, appointments scheduling, dentist profiles, medical services, and patient publications.

## 📋 Features

- **Patient Management**: Create, read, update, and delete patient records
- **Appointment Scheduling**: Manage dental appointments (rendez-vous)
- **Dentist Profiles**: Maintain dentist information and credentials
- **Medical Services**: Define and manage dental services offered
- **Medical Acts**: Track medical procedures performed on patients
- **Publications**: Share clinic news and updates
- **Authentication**: Secure API endpoints with authentication
- **RESTful API**: Complete REST API for all operations

## 🏗️ Project Structure

```
Backoffice/
├── src/main/java/com/dentist/
│   ├── dao/                          # Data Access Layer
│   │   ├── impl/                     # DAO Implementations
│   │   │   ├── ActeMedicalDAOImpl.java
│   │   │   ├── DentisteDAOImpl.java
│   │   │   ├── PatientDAOImpl.java
│   │   │   ├── PublicationDAOImpl.java
│   │   │   ├── RendezvousDAOImpl.java
│   │   │   └── ServiceMedicalDAOImpl.java
│   │   └── interfaces/               # DAO Interfaces (Local EJBs)
│   │       ├── IActeMedicalLocal.java
│   │       ├── IDentisteLocal.java
│   │       ├── IPatientLocal.java
│   │       ├── IPublicationLocal.java
│   │       ├── IRendezvousLocal.java
│   │       └── IServiceMedicalLocal.java
│   ├── entity/                       # JPA Entity Classes
│   │   ├── ActeMedical.java          # Medical procedures
│   │   ├── Dentiste.java             # Dentist profile
│   │   ├── Patient.java              # Patient information
│   │   ├── Publication.java          # Clinic news/updates
│   │   ├── Rendezvous.java           # Appointments
│   │   └── ServiceMedical.java       # Dental services
│   └── rest/                         # REST Layer
│       └── ressources/               # REST Endpoints
│           ├── ActeMedicalResource.java
│           ├── AuthResource.java
│           ├── DentisteResource.java
│           ├── PatientResource.java
│           ├── PublicationRessource.java
│           ├── RendezvousResource.java
│           ├── RestConfig.java       # REST Configuration
│           └── ServiceMedicalResource.java
├── src/main/webapp/
│   └── WEB-INF/
│       ├── web.xml                   # Web Application Descriptor
│       ├── persistence.xml           # JPA Configuration
│       └── lib/                      # Dependencies
├── build/                            # Compiled classes
└── README.md                         # This file
```

## 🛠️ Technologies Used

- **Java Enterprise Edition (Jakarta EE)**
- **Jakarta REST (JAX-RS)** - RESTful Web Services
- **Jakarta Persistence (JPA)** - Object-Relational Mapping
- **Enterprise JavaBeans (EJB)** - Session Beans for business logic
- **Jakarta JSON-B** - JSON serialization/deserialization

## 🔌 API Endpoints

### Base URL
```
/api
```

### Endpoints

| Resource | Method | Endpoint | Description |
|----------|--------|----------|-------------|
| **Patient** | GET | `/patients` | Get all patients |
| | POST | `/patients` | Create a new patient |
| | GET | `/patients/{id}` | Get patient by ID |
| | PUT | `/patients/{id}` | Update patient |
| | DELETE | `/patients/{id}` | Delete patient |
| **Dentist** | GET | `/dentistes` | Get all dentists |
| | POST | `/dentistes` | Create a new dentist |
| | GET | `/dentistes/{id}` | Get dentist by ID |
| **Appointment** | GET | `/rendezvous` | Get all appointments |
| | POST | `/rendezvous` | Create new appointment |
| | GET | `/rendezvous/{id}` | Get appointment by ID |
| **Service** | GET | `/services` | Get all medical services |
| | POST | `/services` | Add medical service |
| **Medical Act** | GET | `/actes` | Get all medical acts |
| | POST | `/actes` | Record medical act |
| **Publication** | GET | `/publications` | Get clinic publications |
| | POST | `/publications` | Create publication |
| **Auth** | POST | `/auth/login` | User authentication |

## 📦 Dependencies

Key dependencies include (from web.xml library):
- Jakarta EE libraries
- Database driver (configured in persistence.xml)
- ORM framework (JPA)

## 🗄️ Database Configuration

Database configuration is defined in `META-INF/persistence.xml`:
- **Location**: `src/main/resources/META-INF/persistence.xml`
- **Configuration**: JPA persistence unit settings
- **Database**: Configured through persistence.xml

## 🚀 Getting Started

### Prerequisites
- Java JDK 11 or higher
- Application Server (GlassFish, WildFly, Tomcat, etc.)
- Maven or Gradle (if building from source)
- Database (MySQL, PostgreSQL, etc.)

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Backoffice
   ```

2. **Configure Database**
   - Update `src/main/resources/META-INF/persistence.xml` with your database credentials
   - Ensure your database is running

3. **Build the Project**
   ```bash
   mvn clean install
   ```
   or
   ```bash
   gradle build
   ```

4. **Deploy**
   - Deploy the WAR file to your application server
   - Or use your IDE's deployment mechanism (Eclipse, IntelliJ, etc.)

5. **Test the API**
   ```bash
   curl http://localhost:8080/Backoffice/api/patients
   ```

## 🔐 Authentication

Authentication is handled through the `AuthResource` endpoint:
- Endpoint: `/api/auth/login`
- Method: POST
- Body: User credentials (username, password)
- Returns: Authentication token

## 📝 Entity Relationships

### Patient
- **Relations**: One-to-Many with Rendez-vous and Acte Medical

### Dentist (Dentiste)
- **Relations**: One-to-Many with Rendez-vous and Service Medical

### Appointment (Rendez-vous)
- **Relations**: Many-to-One with Patient and Dentist
- **Fields**: Date, time, status, notes

### Medical Act (Acte Medical)
- **Relations**: Many-to-One with Patient
- **Fields**: Description, date, cost

### Medical Service (Service Medical)
- **Relations**: Managed by Dentist
- **Fields**: Name, description, cost

### Publication
- **Fields**: Title, content, date, author

## 🧪 Testing

### Manual Testing
Use tools like Postman or cURL to test endpoints:
```bash
# Get all patients
curl -X GET http://localhost:8080/Backoffice/api/patients

# Create a patient
curl -X POST http://localhost:8080/Backoffice/api/patients \
  -H "Content-Type: application/json" \
  -d '{"nomP":"Dupont","prenomP":"Jean","emailP":"jean@example.com"}'
```

## 📊 Build Output

- **Location**: `build/classes/com/dentist/`
- **Compiled Classes**: DAO implementations, entities, and REST resources

## 🔍 File Organization

- **DAO Layer**: Implements CRUD operations and business logic
- **Entity Layer**: JPA-annotated domain models
- **REST Layer**: HTTP endpoint handlers

## ⚙️ Configuration Files

- **web.xml**: Web application configuration
- **persistence.xml**: JPA persistence unit configuration
- **RestConfig.java**: REST framework configuration

## 🐛 Troubleshooting

### Common Issues

1. **Database Connection Failed**
   - Verify database is running
   - Check persistence.xml credentials
   - Verify database driver is in classpath

2. **REST Endpoint Not Found**
   - Ensure REST resource classes are properly annotated
   - Verify base path in RestConfig matches deployment

3. **Entity Mapping Issues**
   - Check @Entity and @Table annotations
   - Verify column names match database schema

## 📄 License

[Add your license here]

## 👥 Contributors

- [Your Name/Team]

## 📞 Support

For issues or questions, please contact: [contact information]

---

**Last Updated**: January 18, 2026
