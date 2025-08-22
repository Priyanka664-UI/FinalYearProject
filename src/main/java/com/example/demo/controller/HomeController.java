package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    
    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "<h1>Smart Internship Portal</h1>" +
               "<p>Backend is running successfully!</p>" +
               "<h3>Available APIs:</h3>" +
               "<ul>" +
               "<li><a href='/api/users'>/api/users</a> - User Management</li>" +
               "<li><a href='/api/internships'>/api/internships</a> - Internships</li>" +
               "<li><a href='/api/applications/status/APPLIED'>/api/applications</a> - Applications</li>" +
               "<li><a href='/api/dashboard/stats'>/api/dashboard/stats</a> - Dashboard</li>" +
               "<li><a href='/h2-console'>/h2-console</a> - Database Console</li>" +
               "</ul>";
    }
}