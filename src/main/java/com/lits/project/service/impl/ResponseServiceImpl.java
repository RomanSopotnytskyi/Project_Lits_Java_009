package com.lits.project.service.impl;

import com.lits.project.dto.ResponseDTO;
import com.lits.project.exception.ResponseNotFoundException;
import com.lits.project.models.Response;
import com.lits.project.repository.ResponseRepository;
import com.lits.project.service.ResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ResponseDTO> getAllResponses() {
         List<Response> responses = StreamSupport.stream(responseRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return responses.stream().map(response -> modelMapper.map(response, ResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ResponseDTO addResponse(ResponseDTO responseDTO) {
        Response response = responseRepository.save(modelMapper.map(responseDTO, Response.class));
        return modelMapper.map(response, ResponseDTO.class);
    }

    @Override
    public ResponseDTO getResponseById(Long id) {
        return modelMapper.map(responseRepository.findById(id).orElseThrow(()->new ResponseNotFoundException(id)), ResponseDTO.class);
    }

    @Override
    public ResponseDTO deleteResponse(Long id){
        ResponseDTO responseDTO = getResponseById(id);
        responseRepository.delete(modelMapper.map(responseDTO, Response.class));
        return responseDTO;
    }

    @Override
    public ResponseDTO updateResponse(ResponseDTO responseDTO, Long id) {
        return responseRepository.findById(id).map(responseToEdit -> {
            responseToEdit.setFeedback(responseDTO.getFeedback());
            responseToEdit.setRating(responseDTO.getRating());
            responseRepository.save(responseToEdit);
            return modelMapper.map(responseToEdit, ResponseDTO.class);
        }).orElseThrow(() -> new ResponseNotFoundException(id));
    }
}
