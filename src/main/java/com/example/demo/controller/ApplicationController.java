package com.example.demo.controller;

import com.example.demo.dto.ApplicationDTO;
import com.example.demo.entity.Application;
import com.example.demo.entity.ApplicationStatus;
import com.example.demo.entity.Internship;
import com.example.demo.entity.User;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.InternshipRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {
    
    @Autowired
    private ApplicationRepository applicationRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private InternshipRepository internshipRepository;
    
    @PostMapping
    public Application applyForInternship(@RequestBody ApplicationDTO applicationDTO) {
        User student = userRepository.findById(applicationDTO.getStudentId()).orElseThrow();
        Internship internship = internshipRepository.findById(applicationDTO.getInternshipId()).orElseThrow();
        
        Application application = new Application();
        application.setStudent(student);
        application.setInternship(internship);
        application.setCoverLetter(applicationDTO.getCoverLetter());
        application.setResumePath(applicationDTO.getResumePath());
        application.setAppliedAt(LocalDateTime.now());
        application.setStatus(ApplicationStatus.APPLIED);
        
        return applicationRepository.save(application);
    }
    
    @PostMapping("/upload-resume")
    public ResponseEntity<Map<String, String>> uploadResume(@RequestParam("file") MultipartFile file) throws IOException {
        String uploadDir = "uploads/resumes/";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);
        
        return ResponseEntity.ok(Map.of("filePath", uploadDir + fileName));
    }
    
    @GetMapping("/student/{studentId}")
    public List<Application> getStudentApplications(@PathVariable Long studentId) {
        return applicationRepository.findByStudentId(studentId);
    }
    
    @GetMapping("/internship/{internshipId}")
    public List<Application> getInternshipApplications(@PathVariable Long internshipId) {
        return applicationRepository.findByInternshipId(internshipId);
    }
    
    @GetMapping("/status/{status}")
    public List<Application> getApplicationsByStatus(@PathVariable ApplicationStatus status) {
        return applicationRepository.findByStatus(status);
    }
    
    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id) {
        return applicationRepository.findById(id).orElseThrow();
    }
    
    @PutMapping("/{id}/status")
    public Application updateApplicationStatus(@PathVariable Long id, 
                                             @RequestParam ApplicationStatus status) {
        Application application = applicationRepository.findById(id).orElseThrow();
        application.setStatus(status);
        return applicationRepository.save(application);
    }
    
    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applicationRepository.deleteById(id);
    }
}