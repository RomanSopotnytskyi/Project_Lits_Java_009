package com.lits.project.rest;

import com.lits.project.dto.SeassionDTO;
import com.lits.project.service.SeassionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/seassions")
public class SeassionRestController {

    @Autowired
    private SeassionService seassionService;

    @GetMapping
    public ResponseEntity<List<SeassionDTO>> getAll(){
        List<SeassionDTO> seassionDTO = seassionService.getAllSeassions();
        return new ResponseEntity<>(seassionDTO, HttpStatus.OK);
    }

    @PostMapping("/seassion")
    public ResponseEntity<SeassionDTO> addUser(@Validated @RequestBody SeassionDTO seassionDTO){
        return new ResponseEntity<>(seassionService.addSeassion(seassionDTO), HttpStatus.CREATED);
    }

    @GetMapping("/seassion/{id}")
    public SeassionDTO getById(@PathVariable Long id) {
        return seassionService.getSeassionById(id);
    }

    @DeleteMapping("/seassion/{id}")
    public SeassionDTO delete(@PathVariable Long id) {
        return seassionService.deleteSeassion(id);
    }

    @PutMapping("/seassion/{id}")
    public SeassionDTO updateSeassion(@PathVariable("id") Long id,@Validated @RequestBody SeassionDTO seassionDTO) {
        return seassionService.updateSeassion(id, seassionDTO);
    }
}
