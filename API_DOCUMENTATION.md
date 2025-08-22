# Smart Internship Portal - API Documentation

## Base URL
`http://localhost:8081/api`

## User Management APIs

### 1. Register User
- **POST** `/users/register`
- **Body**: 
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123",
  "role": "STUDENT"
}
```
- **Roles**: STUDENT, COMPANY, FACULTY, ADMIN

### 2. Login User
- **POST** `/users/login`
- **Body**:
```json
{
  "email": "john@example.com",
  "password": "password123"
}
```

### 3. Get All Users
- **GET** `/users`

### 4. Get Users by Role
- **GET** `/users/role/{role}`

### 5. Get User by ID
- **GET** `/users/{id}`

### 6. Update User
- **PUT** `/users/{id}`

### 7. Delete User
- **DELETE** `/users/{id}`

## Internship Management APIs

### 1. Create Internship (Company)
- **POST** `/internships`
- **Body**:
```json
{
  "title": "Software Developer Intern",
  "description": "Full stack development internship",
  "company": "Tech Corp",
  "location": "New York",
  "startDate": "2024-06-01",
  "endDate": "2024-08-31",
  "requirements": "Java, Spring Boot, React",
  "companyUser": {
    "id": 1
  }
}
```

### 2. Get All Approved Internships
- **GET** `/internships`

### 3. Filter Internships
- **POST** `/internships/filter`
- **Body**:
```json
{
  "title": "developer",
  "company": "tech",
  "location": "new york",
  "startDate": "2024-06-01",
  "endDate": "2024-12-31"
}
```

### 4. Get Pending Internships (Admin/Faculty)
- **GET** `/internships/pending`

### 5. Get Company Internships
- **GET** `/internships/company/{companyId}`

### 6. Get Internship by ID
- **GET** `/internships/{id}`

### 7. Approve Internship (Admin)
- **PUT** `/internships/{id}/approve`

### 8. Reject Internship (Admin)
- **PUT** `/internships/{id}/reject`

### 9. Delete Internship
- **DELETE** `/internships/{id}`

## Application Management APIs

### 1. Apply for Internship
- **POST** `/applications`
- **Body**:
```json
{
  "studentId": 1,
  "internshipId": 1,
  "coverLetter": "I am interested in this position...",
  "resumePath": "uploads/resumes/1234567890_resume.pdf"
}
```

### 2. Upload Resume
- **POST** `/applications/upload-resume`
- **Form Data**: file (multipart/form-data)
- **Response**:
```json
{
  "filePath": "uploads/resumes/1234567890_resume.pdf"
}
```

### 3. Get Student Applications
- **GET** `/applications/student/{studentId}`

### 4. Get Internship Applications
- **GET** `/applications/internship/{internshipId}`

### 5. Get Applications by Status
- **GET** `/applications/status/{status}`
- **Status Values**: APPLIED, UNDER_REVIEW, SHORTLISTED, SELECTED, REJECTED

### 6. Get Application by ID
- **GET** `/applications/{id}`

### 7. Update Application Status
- **PUT** `/applications/{id}/status?status=SELECTED`

### 8. Delete Application
- **DELETE** `/applications/{id}`

## Dashboard APIs

### 1. Get Dashboard Statistics
- **GET** `/dashboard/stats`
- **Response**:
```json
{
  "totalInternships": 25,
  "totalApplications": 150,
  "pendingApprovals": 5,
  "selectedStudents": 12
}
```

## File Access
- **GET** `/uploads/resumes/{filename}` - Access uploaded resume files

## Database Console (Development)
- **URL**: `http://localhost:8081/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (empty)

## Key Features Implemented
1. **Internship Filtering** - Advanced filtering by title, company, location, dates
2. **Resume Upload** - File upload with proper storage and access
3. **Status Tracking** - Complete application lifecycle tracking
4. **Admin Approvals** - Internship approval/rejection workflow
5. **Role-based Access** - Different APIs for different user roles
6. **Dashboard Analytics** - Statistics for faculty and admin tracking