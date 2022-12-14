package com.example.division.controller;

import com.example.division.service.DivisionsService;
import com.example.division.dto.DivisionDTO;
import com.example.division.entity.Divisions;
import com.example.division.mapper.DivisionMapper;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DivisionsController {

    private final DivisionMapper divisionMapper;

    private final DivisionsService divisionsService;

    @GetMapping("id/{id}")
    public DivisionDTO getId(@PathVariable("id") Integer id) {
        Divisions divisions = divisionsService.findById(id);
        return divisionMapper.toDTO(divisions);
    }

    @GetMapping("date/{date}")
    public List<Divisions> getDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime date) {
        return divisionsService.getCreationDate(date);
    }

    @PostMapping("/save")
    public void saveDivision(@RequestBody Divisions divisions) {
        divisionsService.saveDivisions(divisions);
    }


    @PostMapping("/update/{id}")
    public void saveOrUpdate(@PathVariable("id") Integer id, @RequestBody DivisionDTO divisionDTO) {
        divisionsService.updateDivision(id, divisionMapper.toEntity(divisionDTO));
    }


    @DeleteMapping("/{id}")
    public void deleteDivision(@PathVariable("id") Integer id) {
        divisionsService.deleteDivision(id);

    }
}
