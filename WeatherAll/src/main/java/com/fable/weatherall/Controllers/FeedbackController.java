package com.fable.weatherall.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fable.weatherall.Responses.Feedback;
import com.fable.weatherall.Services.EmailService;

@RestController
public class FeedbackController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit-feedback")
    public Map<String, Object> submitFeedback(@RequestBody Feedback feedback) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Send email with feedback suggestion
            emailService.sendFeedbackEmail("weatherfable@gmail.com", "Feedback Suggestion", feedback.getSuggestion());

            // Optionally, you can perform additional actions here (e.g., save feedback to a database)

            response.put("success", true);
            response.put("message", "Feedback submitted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "Error submitting feedback");
        }

        return response;
    }
}