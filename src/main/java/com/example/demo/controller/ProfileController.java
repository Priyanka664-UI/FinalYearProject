package com.example.demo.controller;

import com.example.demo.entity.Profile;
import com.example.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "*")
public class ProfileController {
    
    @Autowired
    private ProfileRepository profileRepository;
    
    @GetMapping("/{email}")
    public ResponseEntity<Profile> getProfile(@PathVariable String email) {
        return profileRepository.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile) {
        Profile existingProfile = profileRepository.findByEmail(profile.getEmail()).orElse(null);
        if (existingProfile != null) {
            existingProfile.setName(profile.getName());
            existingProfile.setPhone(profile.getPhone());
            existingProfile.setUniversity(profile.getUniversity());
            existingProfile.setMajor(profile.getMajor());
            existingProfile.setYear(profile.getYear());
            existingProfile.setGpa(profile.getGpa());
            existingProfile.setSkills(profile.getSkills());
            existingProfile.setExperience(profile.getExperience());
            existingProfile.setAddress(profile.getAddress());
            return ResponseEntity.ok(profileRepository.save(existingProfile));
        } else {
            return ResponseEntity.ok(profileRepository.save(profile));
        }
    }
}