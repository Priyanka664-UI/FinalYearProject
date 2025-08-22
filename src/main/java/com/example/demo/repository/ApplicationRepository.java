package com.example.demo.repository;

import com.example.demo.entity.Application;
import com.example.demo.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByStudentId(Long studentId);
    List<Application> findByInternshipId(Long internshipId);
    List<Application> findByStatus(ApplicationStatus status);
}