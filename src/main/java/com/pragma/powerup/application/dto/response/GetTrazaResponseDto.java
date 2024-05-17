package com.pragma.powerup.application.dto.response;

import com.pragma.powerup.domain.model.Traza;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetTrazaResponseDto {
    List<Traza> traza = new ArrayList<>();
}
