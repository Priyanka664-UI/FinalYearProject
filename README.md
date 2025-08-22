# Smart Internship Portal - Backend

A comprehensive Spring Boot backend for managing college internship programs where companies post internships, students apply, and faculty can track selections.

## Features

- **User Management**: Registration and authentication for Students, Companies, Faculty, and Admin
- **Internship Management**: Companies can post internships, admins can approve/reject
- **Advanced Filtering**: Filter internships by title, company, location, and dates
- **Application System**: Students can apply with resume upload and cover letters
- **Status Tracking**: Complete application lifecycle from applied to selected/rejected
- **Admin Dashboard**: Statistics and analytics for faculty and admin users
- **File Upload**: Resume upload with proper storage and access
- **Role-based Access**: Different functionalities for different user roles

## Technology Stack

- **Framework**: Spring Boot 3.5.4
- **Database**: H2 (In-memory for development)
- **ORM**: Spring Data JPA
- **Build Tool**: Maven
- **Java Version**: 17

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. **Clone and Navigate**
   ```bash
   cd demo
   ```

2. **Build the Project**
   ```bash
   mvn clean install
   ```

3. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the Application**
   - API Base URL: `http://localhost:8081/api`
   - H2 Console: `http://localhost:8081/h2-console`

### Database Configuration

The application uses H2 in-memory database with the following settings:
- **URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (empty)

### Sample Data

The application automatically initializes with sample data:
- **Admin**: admin@college.edu / admin123
- **Faculty**: faculty@college.edu / faculty123
- **Company**: hr@techcorp.com / company123
- **Student**: john@student.edu / student123

## API Endpoints

### User Management
- `POST /api/users/register` - Register new user
- `POST /api/users/login` - User login
- `GET /api/users` - Get all users
- `GET /api/users/role/{role}` - Get users by role

### Internship Management
- `POST /api/internships` - Create internship (Company)
- `GET /api/internships` - Get approved internships
- `POST /api/internships/filter` - Filter internships
- `GET /api/internships/pending` - Get pending approvals (Admin)
- `PUT /api/internships/{id}/approve` - Approve internship (Admin)

### Application Management
- `POST /api/applications` - Apply for internship
- `POST /api/applications/upload-resume` - Upload resume
- `GET /api/applications/student/{id}` - Get student applications
- `PUT /api/applications/{id}/status` - Update application status

### Dashboard
- `GET /api/dashboard/stats` - Get dashboard statistics

## File Structure

```
src/main/java/com/example/demo/
├── config/
│   ├── DataInitializer.java
│   └── WebConfig.java
├── controller/
│   ├── ApplicationController.java
│   ├── DashboardController.java
│   ├── InternshipController.java
│   └── UserController.java
├── dto/
│   ├── ApplicationDTO.java
│   ├── DashboardDTO.java
│   └── InternshipFilterDTO.java
├── entity/
│   ├── Application.java
│   ├── ApplicationStatus.java
│   ├── Internship.java
│   ├── Role.java
│   ├── Status.java
│   └── User.java
├── repository/
│   ├── ApplicationRepository.java
│   ├── InternshipRepository.java
│   └── UserRepository.java
├── service/
│   ├── DashboardService.java
│   └── InternshipService.java
└── DemoApplication.java
```

## Key Features Implementation

### 1. Internship Filtering
Advanced filtering system allowing search by:
- Title (partial match)
- Company name (partial match)
- Location (partial match)
- Start and end dates

### 2. Resume Upload
- Secure file upload to `uploads/resumes/` directory
- Unique filename generation to prevent conflicts
- File access via REST endpoint

### 3. Status Tracking
Complete application lifecycle:
- APPLIED → UNDER_REVIEW → SHORTLISTED → SELECTED/REJECTED

### 4. Admin Approvals
Internship approval workflow:
- Companies post internships (PENDING status)
- Admin/Faculty review and approve/reject
- Only approved internships visible to students

### 5. Role-based Access
- **STUDENT**: Apply for internships, view applications
- **COMPANY**: Post internships, view applications for their internships
- **FACULTY**: Track student progress, view statistics
- **ADMIN**: Approve internships, manage all data

## Development Notes

- CORS is enabled for all origins (configure for production)
- File uploads limited to 10MB
- H2 console enabled for development
- Auto-DDL creates tables on startup
- Sample data loaded automatically

## Production Considerations

1. Replace H2 with production database (MySQL/PostgreSQL)
2. Configure proper CORS origins
3. Add authentication/authorization (JWT)
4. Implement proper file storage (cloud storage)
5. Add input validation and error handling
6. Configure logging and monitoring