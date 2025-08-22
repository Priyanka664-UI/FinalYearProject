package com.example.demo.controller;

import com.example.demo.dto.InternshipFilterDTO;
import com.example.demo.entity.Internship;
import com.example.demo.entity.Status;
import com.example.demo.repository.InternshipRepository;
import com.example.demo.service.InternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/internships")
@CrossOrigin(origins = "*")
public class InternshipController {
    
    @Autowired
    private InternshipRepository internshipRepository;
    
    @Autowired
    private InternshipService internshipService;
    
    @PostMapping
    public Internship createInternship(@RequestBody Internship internship) {
        internship.setStatus(Status.PENDING);
        return internshipRepository.save(internship);
    }
    
    @GetMapping
    public List<Internship> getAllInternships() {
        return internshipRepository.findByStatus(Status.APPROVED);
    }
    
    @PostMapping("/filter")
    public List<Internship> filterInternships(@RequestBody InternshipFilterDTO filter) {
        return internshipService.filterInternships(filter);
    }
    
    @GetMapping("/pending")
    public List<Internship> getPendingInternships() {
        return internshipService.getPendingInternships();
    }
    
    @GetMapping("/company/{companyId}")
    public List<Internship> getCompanyInternships(@PathVariable Long companyId) {
        return internshipRepository.findAll().stream()
            .filter(i -> i.getCompanyUser() != null && i.getCompanyUser().getId().equals(companyId))
            .toList();
    }
    
    @GetMapping("/{id}")
    public Internship getInternshipById(@PathVariable Long id) {
        return internshipRepository.findById(id).orElseThrow();
    }
    
    @PutMapping("/{id}/approve")
    public Internship approveInternship(@PathVariable Long id) {
        Internship internship = internshipRepository.findById(id).orElseThrow();
        internship.setStatus(Status.APPROVED);
        return internshipRepository.save(internship);
    }
    
    @PutMapping("/{id}/reject")
    public Internship rejectInternship(@PathVariable Long id) {
        Internship internship = internshipRepository.findById(id).orElseThrow();
        internship.setStatus(Status.REJECTED);
        return internshipRepository.save(internship);
    }
    
    @DeleteMapping("/{id}")
    public void deleteInternship(@PathVariable Long id) {
        internshipRepository.deleteById(id);
    }
}