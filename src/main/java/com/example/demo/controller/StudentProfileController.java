package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin(origins = "*")
public class StudentProfileController {
    
    @Autowired
    private StudentProfileRepository profileRepository;
    
    @GetMapping("/student/{userId}")
    public StudentProfile getProfile(@PathVariable Long userId) {
        return profileRepository.findByUserId(userId).orElse(new StudentProfile());
    }
    
    @PostMapping
    public StudentProfile saveProfile(@RequestBody StudentProfile profile) {
        return profileRepository.save(profile);
    }
}