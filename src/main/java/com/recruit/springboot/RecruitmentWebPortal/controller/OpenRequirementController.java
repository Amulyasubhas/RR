package com.recruit.springboot.RecruitmentWebPortal.controller;

import com.recruit.springboot.RecruitmentWebPortal.DTO.OpenRequirementDTO;
import com.recruit.springboot.RecruitmentWebPortal.service.OpenRequirementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/open-requirements")
@CrossOrigin(origins = "*")
public class OpenRequirementController {

    private final OpenRequirementService service;

    public OpenRequirementController(OpenRequirementService service) {
        this.service = service;
    }

    @PostMapping
    public OpenRequirementDTO create(@RequestBody OpenRequirementDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public OpenRequirementDTO update(@PathVariable Long id, @RequestBody OpenRequirementDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/{id}")
    public OpenRequirementDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping
    public List<OpenRequirementDTO> getAll() {
        return service.getAll();
    }
}
