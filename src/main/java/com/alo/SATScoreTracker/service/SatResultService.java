package com.alo.SATScoreTracker.service;

import com.alo.SATScoreTracker.dto.SatResultDTO;
import com.alo.SATScoreTracker.entity.SatResult;
import com.alo.SATScoreTracker.repository.SatResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SatResultService {

    private final SatResultRepository satResultRepository;

    @Autowired
    public SatResultService(SatResultRepository satResultRepository) {
        this.satResultRepository = satResultRepository;
    }

    public void insertData(SatResult satResult) {
        satResult.setPassed(satResult.getSatScore() > 30);
        satResultRepository.save(satResult);
    }

    public List<SatResult> getAllData() {
        return satResultRepository.findAll();
    }

    public String getRank(String name) {
        SatResult currentResult = satResultRepository.findByName(name);
        if (currentResult != null) {
            int rank = 1;
            for (SatResult satResult : satResultRepository.findAll()) {
                if (satResult.getSatScore() > currentResult.getSatScore()) {
                    rank++;
                }
            }
            return String.valueOf(rank);
        }
        return "Name not found !!!";
    }

    public List<SatResult> getAllDataByRank() {
        List<SatResult> satResults = satResultRepository.findAll();
        satResults.sort(Comparator.comparingInt(SatResult::getSatScore).reversed());
        return satResults;
    }



    public String updateScore(String name, Integer newScore) {
        SatResult satResult = satResultRepository.findByName(name);
        if (satResult != null) {
            satResult.setSatScore(newScore);
            satResult.setPassed(newScore > 30);
            satResultRepository.save(satResult);
            return "Score updated successfully";
        }
        return "Name not found";
    }

    public String deleteRecord(String name) {
        SatResult satResult = satResultRepository.findByName(name);
        if (satResult != null) {
            satResultRepository.delete(satResult);
            return "Record deleted successfully";
        }
        return "Name not found";
    }

    public SatResult getByName(String name) {
        return satResultRepository.findByName(name);
    }
}

