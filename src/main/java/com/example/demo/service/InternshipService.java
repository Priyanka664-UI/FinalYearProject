package com.example.demo.service;

import com.example.demo.dto.InternshipFilterDTO;
import com.example.demo.entity.Internship;
import com.example.demo.entity.Status;
import com.example.demo.repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InternshipService {
    
    @Autowired
    private InternshipRepository internshipRepository;
    
    public List<Internship> filterInternships(InternshipFilterDTO filter) {
        List<Internship> internships = internshipRepository.findByStatus(Status.APPROVED);
        
        return internships.stream()
            .filter(i -> filter.getTitle() == null || i.getTitle().toLowerCase().contains(filter.getTitle().toLowerCase()))
            .filter(i -> filter.getCompany() == null || i.getCompany().toLowerCase().contains(filter.getCompany().toLowerCase()))
            .filter(i -> filter.getLocation() == null || i.getLocation().toLowerCase().contains(filter.getLocation().toLowerCase()))
            .filter(i -> filter.getStartDate() == null || !i.getStartDate().isBefore(filter.getStartDate()))
            .filter(i -> filter.getEndDate() == null || !i.getEndDate().isAfter(filter.getEndDate()))
            .collect(Collectors.toList());
    }
    
    public List<Internship> getPendingInternships() {
        return internshipRepository.findByStatus(Status.PENDING);
    }
}