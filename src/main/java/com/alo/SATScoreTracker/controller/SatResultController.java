package com.alo.SATScoreTracker.controller;

import com.alo.SATScoreTracker.coverter.ResponseConverter;
import com.alo.SATScoreTracker.dto.SatResultDTO;
import com.alo.SATScoreTracker.entity.SatResult;
import com.alo.SATScoreTracker.service.SatResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sat-results")
@CrossOrigin(origins = "*")
public class SatResultController {

    private final SatResultService satResultService;

    private final ResponseConverter responseConverter;

    @Autowired
    public SatResultController(SatResultService satResultService, ResponseConverter responseConverter) {
        this.satResultService = satResultService;
        this.responseConverter = responseConverter;
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertData(@RequestBody SatResultDTO satResultDTO) {
        SatResult satResult = responseConverter.convertToEntity(satResultDTO);
        satResultService.insertData(satResult);
        return new ResponseEntity<>("Data inserted successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<SatResultDTO> getByName(@PathVariable String name){
        SatResult data = satResultService.getByName(name);
        SatResultDTO satResultDTO = responseConverter.convertToDTO(data);
        return new ResponseEntity<SatResultDTO>(satResultDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SatResultDTO>> viewAllData() {
        List<SatResult> satResults = satResultService.getAllData();
        List<SatResultDTO> satResultDTOs = new ArrayList<>();
        for (SatResult satResult : satResults) {
            SatResultDTO satResultDTO = responseConverter.convertToDTO(satResult);
            satResultDTOs.add(satResultDTO);
        }
        return new ResponseEntity<>(satResultDTOs, HttpStatus.OK);
    }

    @GetMapping("/get-rank/{name}")
    public ResponseEntity<String> getRank(@PathVariable String name) {
        String rank = satResultService.getRank(name);
        return new ResponseEntity<>(rank, HttpStatus.OK);
    }

    @GetMapping("/get-all-by-rank")
    public ResponseEntity<List<SatResultDTO>> getAllByRank() {
        List<SatResult> satResults = satResultService.getAllDataByRank();
        List<SatResultDTO> satResultDTOs = new ArrayList<>();
        for (SatResult satResult : satResults) {
            SatResultDTO satResultDTO = responseConverter.convertToDTO(satResult);
            satResultDTOs.add(satResultDTO);
        }
        return new ResponseEntity<>(satResultDTOs, HttpStatus.OK);
    }


    @PutMapping("/update-score/{name}")
    public ResponseEntity<String> updateScore(@PathVariable String name, @RequestParam Integer newScore) {
        String result = satResultService.updateScore(name, newScore);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteRecord(@PathVariable String name) {
        String result = satResultService.deleteRecord(name);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

