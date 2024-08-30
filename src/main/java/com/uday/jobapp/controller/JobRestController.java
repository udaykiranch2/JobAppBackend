package com.uday.jobapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import com.uday.jobapp.model.JobPost;
import com.uday.jobapp.service.JobService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/jobPost/{postId}")
    public JobPost job(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @PostMapping("/jobPost")
    public String addJob(@RequestBody JobPost jobPost) {
        // TODO: process POST request
        service.addJob(jobPost);

        return "added post";
    }

    @PutMapping("/jobPost")
    public String updateJob(@RequestBody JobPost jobPost) {
        // TODO: process PUT request
        service.updateJob(jobPost);
        return "updated job";
    }

    @DeleteMapping("/jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
        return "delete a jobpost";
    }

    @GetMapping("/jobPosts/load")
    public String loadData() {
        service.load();
        return "loaded data into Database";
    }

    @GetMapping("/jobPosts/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {

        return service.search(keyword);
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
