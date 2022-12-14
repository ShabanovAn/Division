package com.example.division.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DivisionDTO {

    private Integer id;

    private String name;

    private LocalDateTime dt_from;

    @Nullable
    private LocalDateTime dt_till;

    private int sort_priority;

    private boolean in_system;

    private LocalDateTime creation_date;

    @Nullable
    private LocalDateTime correction_date;

    private List<DivisionDTO> children = new ArrayList<>();
}
