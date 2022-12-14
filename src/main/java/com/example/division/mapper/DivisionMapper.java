package com.example.division.mapper;

import com.example.division.dto.DivisionDTO;
import com.example.division.entity.Divisions;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DivisionMapper{

    DivisionDTO toDTO(Divisions divisions);

    Divisions toEntity(DivisionDTO divisionDTO);

}
