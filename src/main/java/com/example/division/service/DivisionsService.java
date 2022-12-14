package com.example.division.service;

import com.example.division.entity.Divisions;
import com.example.division.repository.DivisionsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DivisionsService {

    private final DivisionsRepository divisionsRepository;

    public DivisionsService(DivisionsRepository divisionsRepository) {
        this.divisionsRepository = divisionsRepository;
    }

    public List<Divisions> findAll() {
        return divisionsRepository.findAll();
    }

    public Divisions findById(Integer id) {
        return divisionsRepository.findById(id).orElse(new Divisions());
    }

    public List<Divisions> getCreationDate(LocalDateTime date) {
        return divisionsRepository.findAllByCreation_date(date);
    }

    public void saveDivisions(Divisions divisions) {
        divisionsRepository.save(divisions);
    }

    public void updateDivision(Integer id, Divisions divisionsNew) {
        Divisions divisions = divisionsRepository.findById(id).orElse(new Divisions());
        divisions.setDt_till(LocalDateTime.now());
        divisionsRepository.save(divisions);
        divisionsRepository.save(divisionsNew);
    }

    public void deleteDivision(Integer id) {
        divisionsRepository.findById(id).ifPresent(o -> {
            if (o.getChildren().isEmpty()) {
                divisionsRepository.delete(o);
            }
        });
    }
}
