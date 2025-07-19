package com.recruit.springboot.RecruitmentWebPortal.controller;

import com.recruit.springboot.RecruitmentWebPortal.DTO.CandidateDetailsAndStatusTrackerDTO;
import com.recruit.springboot.RecruitmentWebPortal.service.CandidateDetailsAndStatusTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateDetailsAndStatusTrackerController {

    @Autowired
    private CandidateDetailsAndStatusTrackerService service;

    @PostMapping
    public CandidateDetailsAndStatusTrackerDTO create(@RequestBody CandidateDetailsAndStatusTrackerDTO dto,
                                                      @AuthenticationPrincipal UserDetails user) {
        return service.create(dto, user.getUsername());
    }

    @GetMapping
    public List<CandidateDetailsAndStatusTrackerDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public CandidateDetailsAndStatusTrackerDTO update(@PathVariable Long id,
                                                      @RequestBody CandidateDetailsAndStatusTrackerDTO dto,
                                                      @AuthenticationPrincipal UserDetails user) {
        return service.update(id, dto, user.getUsername());
    }
}
