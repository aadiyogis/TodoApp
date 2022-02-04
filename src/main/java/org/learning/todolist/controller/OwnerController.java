package org.learning.todolist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.learning.todolist.dto.OwnerDto;
import org.learning.todolist.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/owner")
public class OwnerController {
    private final OwnerService ownerService;

    @PostMapping("/")
    public OwnerDto createOwner(@RequestBody OwnerDto ownerDto) {
        log.info("OwnerController -- createOwner -- started");
        return ownerService.createOwner(ownerDto);
    }

    @GetMapping("/all")
    public List<OwnerDto> getAllOwners() {
        log.info("OwnerController -- getAllOwners -- started");
        return ownerService.getAll();
    }

    @GetMapping("/{id}")
    public OwnerDto getOwnerById(@PathVariable Long id) {
        log.info("OwnerController -- getOwnerById -- started");
        log.info("id {}", id);
        return ownerService.getOwner(id);
    }
}
