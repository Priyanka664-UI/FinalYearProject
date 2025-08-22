package com.example.demo.service;

import com.example.demo.dto.DashboardDTO;
import com.example.demo.entity.ApplicationStatus;
import com.example.demo.entity.Status;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    
    @Autowired
    private InternshipRepository internshipRepository;
    
    @Autowired
    private ApplicationRepository applicationRepository;
    
    public DashboardDTO getDashboardStats() {
        long totalInternships = internshipRepository.count();
        long totalApplications = applicationRepository.count();
        long pendingApprovals = internshipRepository.findByStatus(Status.PENDING).size();
        long selectedStudents = applicationRepository.findByStatus(ApplicationStatus.SELECTED).size();
        
        return new DashboardDTO(totalInternships, totalApplications, pendingApprovals, selectedStudents);
    }
}