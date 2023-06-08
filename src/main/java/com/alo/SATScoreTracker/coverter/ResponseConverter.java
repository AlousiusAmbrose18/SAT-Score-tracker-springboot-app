package com.alo.SATScoreTracker.coverter;

import com.alo.SATScoreTracker.dto.SatResultDTO;
import com.alo.SATScoreTracker.entity.SatResult;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {

    public SatResult convertToEntity(SatResultDTO satResultDTO) {
        SatResult satResult = new SatResult();
        satResult.setName(satResultDTO.getName());
        satResult.setAddress(satResultDTO.getAddress());
        satResult.setCity(satResultDTO.getCity());
        satResult.setCountry(satResultDTO.getCountry());
        satResult.setPinCode(satResultDTO.getPinCode());
        satResult.setSatScore(satResultDTO.getSatScore());
        satResult.setPassed(satResultDTO.getSatScore() > 30);
        return satResult;
    }

    public SatResultDTO convertToDTO(SatResult satResult) {
        SatResultDTO satResultDTO = new SatResultDTO();
        satResultDTO.setName(satResult.getName());
        satResultDTO.setAddress(satResult.getAddress());
        satResultDTO.setCity(satResult.getCity());
        satResultDTO.setCountry(satResult.getCountry());
        satResultDTO.setPinCode(satResult.getPinCode());
        satResultDTO.setSatScore(satResult.getSatScore());
        satResultDTO.setPassed(satResult.getPassed());
        return satResultDTO;
    }
}
