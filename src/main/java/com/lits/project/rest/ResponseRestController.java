package com.lits.project.rest;

import com.lits.project.dto.ResponseDTO;
import com.lits.project.service.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/responses")
public class ResponseRestController {

    @Autowired
    private ResponseService responseService;

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> getAll(){
        List<ResponseDTO> responseDTO = responseService.getAllResponses();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/response/{id}")
    public ResponseDTO getById(@PathVariable Long id) {
        return responseService.getResponseById(id);
    }

    @PostMapping("/response")
    public ResponseEntity<ResponseDTO> addMovie(@Validated @RequestBody ResponseDTO responseDTO){
        return new ResponseEntity<>(responseService.addResponse(responseDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/response/{id}")
    public ResponseDTO delete(@PathVariable Long id) {
        return responseService.deleteResponse(id);
    }

    @PutMapping("/response/{id}")
    public ResponseDTO updateMovie(@PathVariable("id") Long id,@Validated @RequestBody ResponseDTO responseDTO) {
        return responseService.updateResponse(responseDTO, id);
    }
}
