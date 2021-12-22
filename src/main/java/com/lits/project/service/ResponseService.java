package com.lits.project.service;

import com.lits.project.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResponseService {

    public List<ResponseDTO> getAllResponses();

    ResponseDTO addResponse(ResponseDTO responseDTO);

    public ResponseDTO getResponseById(Long id);

    public ResponseDTO deleteResponse(Long id);

    public ResponseDTO updateResponse(ResponseDTO responseDTO, Long id);

}
