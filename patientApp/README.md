# Patient Application System Documentation


1.Overview

The Patient Appointment System is a web-based application designed to streamline patient registration, appointment booking, and medication management. It allows patients to register, schedule appointments with doctors, and view prescribed medications. The system is built with a modern web stack to ensure responsiveness and scalability.

2.Features

    Patient Registration:
        New patients can register by providing their name, email, phone number, and medical history.

    Appointment Booking:
    Patients can book appointments with doctors.

        Calendar Integration: A calendar-based date and time picker simplifies appointment scheduling.
        Duplicate Prevention: The system checks for duplicate appointments (same patient, doctor, and date/time) before saving a new booking.
    Medication Management:
    Manage and view medications prescribed to patients.

        Add Medication: Users can add medications by selecting a patient from a dropdown list, along with dosage and instructions.
        List Medications: Existing medications are displayed in a tabular format.


4.Technologies Used

    Backend:
        Spring Boot
        Spring Data MongoDB
        Spring MVC
    Frontend:
        Thymeleaf
        HTML5, CSS3, JavaScript
        Bootstrap 5
    Database:
        MongoDB
    Build Tool:
        Maven
    Testing:
        JUnit 5


5.System Components

    1. Patient Module
        * Registration Form:
        Allows patients to register by submitting personal and medical history details.
        * Patient Repository:
        Handles CRUD operations for patient data.

    2. Appointment Module
            Appointment Form:
                Users can book appointments using a form that includes a calendar-based datetime picker.
            Duplicate Check:
                Prevents duplicate appointments by checking for existing appointments with the same patient, doctor, and date/time.
            Appointment Repository:
                Provides database operations for appointments.
    
    3. Medication Module
            Medication Form:
                Enables adding medications by selecting a patient from a dropdown (populated from existing patient records).
            Medication Repository:
                Manages CRUD operations for medication records.

    4. User Interface
            Index Page:
                A home page that links to registration, appointments, and medication management pages.
            Responsive Design:
                Built with Bootstrap for responsive layouts and navigation.

6.Installation and Setup

    Prerequisites

        * Java Development Kit (JDK) 17 or higher
        * Maven
        * MongoDB (Ensure MongoDB is installed and running on your system)
        * Git (optional, for version control)

    Clone the Repository:
        git clone https://github.com/yourusername/patientApplication.git
        cd patientApplication

    Configure MongoDB Connection:
        spring.data.mongodb.uri=mongodb://localhost:27017/patientdb
    
    Build the project
        mvn clean install

    Run the Application
        mvn spring-boot:run



7.Usage

    Accessing the Application
    Open your web browser and navigate to http://localhost:8080.

8.API Endpoints

    Patient Endpoints:
    
    POST /api/patients: Create a new patient.
    GET /api/patients: List all patients.
    Appointment Endpoints:
    
    POST /api/appointments: Book a new appointment.
    GET /api/appointments: List all appointments.
    Medication Endpoints:
    
    POST /api/medications: Add a new medication.
    GET /api/medications: List all medications.

9.Testing

    mvn test


