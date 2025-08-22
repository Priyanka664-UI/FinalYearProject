package com.example.demo.config;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private InternshipRepository internshipRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Create sample users
        User admin = new User("Admin User", "admin@college.edu", "admin123", Role.ADMIN);
        User faculty1 = new User("Dr. Smith", "faculty@college.edu", "faculty123", Role.FACULTY);
        User faculty2 = new User("Prof. Johnson", "johnson@college.edu", "faculty456", Role.FACULTY);
        
        User company1 = new User("Tech Corp HR", "hr@techcorp.com", "company123", Role.COMPANY);
        User company2 = new User("Google Recruiter", "jobs@google.com", "google123", Role.COMPANY);
        User company3 = new User("Microsoft HR", "careers@microsoft.com", "ms123", Role.COMPANY);
        User company4 = new User("Amazon Talent", "talent@amazon.com", "amazon123", Role.COMPANY);
        
        User student1 = new User("John Doe", "john@student.edu", "student123", Role.STUDENT);
        User student2 = new User("Jane Smith", "jane@student.edu", "jane123", Role.STUDENT);
        User student3 = new User("Mike Wilson", "mike@student.edu", "mike123", Role.STUDENT);
        User student4 = new User("Sarah Davis", "sarah@student.edu", "sarah123", Role.STUDENT);
        User student5 = new User("Alex Brown", "alex@student.edu", "alex123", Role.STUDENT);
        
        userRepository.save(admin);
        userRepository.save(faculty1);
        userRepository.save(faculty2);
        userRepository.save(company1);
        userRepository.save(company2);
        userRepository.save(company3);
        userRepository.save(company4);
        userRepository.save(student1);
        userRepository.save(student2);
        userRepository.save(student3);
        userRepository.save(student4);
        userRepository.save(student5);
        
        // Create sample internships
        Internship internship1 = new Internship();
        internship1.setTitle("Software Developer Intern");
        internship1.setDescription("Full stack development internship with modern technologies. Work on real projects with experienced developers.");
        internship1.setCompany("Tech Corp");
        internship1.setLocation("New York");
        internship1.setStartDate(LocalDate.of(2024, 6, 1));
        internship1.setEndDate(LocalDate.of(2024, 8, 31));
        internship1.setRequirements("Java, Spring Boot, React, MySQL");
        internship1.setStatus(Status.APPROVED);
        internship1.setCompanyUser(company1);
        
        Internship internship2 = new Internship();
        internship2.setTitle("Data Science Intern");
        internship2.setDescription("Machine learning and data analysis internship. Build predictive models and analyze large datasets.");
        internship2.setCompany("Google");
        internship2.setLocation("Mountain View");
        internship2.setStartDate(LocalDate.of(2024, 7, 1));
        internship2.setEndDate(LocalDate.of(2024, 9, 30));
        internship2.setRequirements("Python, Pandas, Scikit-learn, SQL, TensorFlow");
        internship2.setStatus(Status.APPROVED);
        internship2.setCompanyUser(company2);
        
        Internship internship3 = new Internship();
        internship3.setTitle("Cloud Engineering Intern");
        internship3.setDescription("Work with Azure cloud services, DevOps, and infrastructure automation.");
        internship3.setCompany("Microsoft");
        internship3.setLocation("Seattle");
        internship3.setStartDate(LocalDate.of(2024, 6, 15));
        internship3.setEndDate(LocalDate.of(2024, 8, 15));
        internship3.setRequirements("Azure, Docker, Kubernetes, CI/CD, Python");
        internship3.setStatus(Status.APPROVED);
        internship3.setCompanyUser(company3);
        
        Internship internship4 = new Internship();
        internship4.setTitle("Mobile App Developer Intern");
        internship4.setDescription("Develop mobile applications for iOS and Android platforms using React Native.");
        internship4.setCompany("Tech Corp");
        internship4.setLocation("Austin");
        internship4.setStartDate(LocalDate.of(2024, 7, 15));
        internship4.setEndDate(LocalDate.of(2024, 10, 15));
        internship4.setRequirements("React Native, JavaScript, iOS, Android");
        internship4.setStatus(Status.APPROVED);
        internship4.setCompanyUser(company1);
        
        Internship internship5 = new Internship();
        internship5.setTitle("AWS Solutions Architect Intern");
        internship5.setDescription("Design and implement scalable cloud solutions using AWS services.");
        internship5.setCompany("Amazon");
        internship5.setLocation("Seattle");
        internship5.setStartDate(LocalDate.of(2024, 8, 1));
        internship5.setEndDate(LocalDate.of(2024, 11, 1));
        internship5.setRequirements("AWS, Lambda, EC2, S3, CloudFormation");
        internship5.setStatus(Status.APPROVED);
        internship5.setCompanyUser(company4);
        
        Internship internship6 = new Internship();
        internship6.setTitle("Frontend Developer Intern");
        internship6.setDescription("Create responsive web applications using modern frontend frameworks.");
        internship6.setCompany("Google");
        internship6.setLocation("San Francisco");
        internship6.setStartDate(LocalDate.of(2024, 9, 1));
        internship6.setEndDate(LocalDate.of(2024, 12, 1));
        internship6.setRequirements("Angular, TypeScript, HTML5, CSS3, JavaScript");
        internship6.setStatus(Status.PENDING);
        internship6.setCompanyUser(company2);
        
        Internship internship7 = new Internship();
        internship7.setTitle("Cybersecurity Intern");
        internship7.setDescription("Learn about network security, threat analysis, and security protocols.");
        internship7.setCompany("Microsoft");
        internship7.setLocation("Redmond");
        internship7.setStartDate(LocalDate.of(2024, 6, 1));
        internship7.setEndDate(LocalDate.of(2024, 8, 31));
        internship7.setRequirements("Network Security, Ethical Hacking, Python, Linux");
        internship7.setStatus(Status.PENDING);
        internship7.setCompanyUser(company3);
        
        internshipRepository.save(internship1);
        internshipRepository.save(internship2);
        internshipRepository.save(internship3);
        internshipRepository.save(internship4);
        internshipRepository.save(internship5);
        internshipRepository.save(internship6);
        internshipRepository.save(internship7);
        
        System.out.println("Sample data initialized successfully!");
        System.out.println("Sample Login Credentials:");
        System.out.println("Admin: admin@college.edu / admin123");
        System.out.println("Faculty: faculty@college.edu / faculty123");
        System.out.println("Company: hr@techcorp.com / company123");
        System.out.println("Student: john@student.edu / student123");
        System.out.println("More students: jane@student.edu/jane123, mike@student.edu/mike123");
    }
}