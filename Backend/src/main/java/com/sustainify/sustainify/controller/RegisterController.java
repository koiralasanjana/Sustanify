package com.sustainify.sustainify.controller;

import com.sustainify.sustainify.Model.Reporter;
import com.sustainify.sustainify.Service.ReporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")  // Replace with your frontend URL
@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    private ReporterService reporterService;

    @PostMapping("/register")
    public ResponseEntity<String> registerReporter(@RequestBody Reporter reporter) {
        try {
            reporterService.registerReporter(reporter);
            return ResponseEntity.ok("User registered successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
}
