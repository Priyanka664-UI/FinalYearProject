package com.example.demo.repository;

import com.example.demo.entity.Internship;
import com.example.demo.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface InternshipRepository extends JpaRepository<Internship, Long> {
    List<Internship> findByStatus(Status status);
    List<Internship> findByLocationContaining(String location);
    List<Internship> findByTitleContaining(String title);
    List<Internship> findByCompanyContaining(String company);
    List<Internship> findByStartDateAfter(LocalDate date);
    List<Internship> findByEndDateBefore(LocalDate date);
    List<Internship> findByCompanyUserId(Long companyId);
}