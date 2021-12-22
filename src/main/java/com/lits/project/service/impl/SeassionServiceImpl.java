package com.lits.project.service.impl;

import com.lits.project.dto.SeassionDTO;
import com.lits.project.exception.SeassionNotFoundException;
import com.lits.project.models.Seassion;
import com.lits.project.repository.SeassionRepository;
import com.lits.project.service.SeassionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SeassionServiceImpl implements SeassionService {

    @Autowired
    private SeassionRepository seassionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SeassionDTO> getAllSeassions() {
        List<Seassion> seassions = StreamSupport.stream(seassionRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return seassions.stream().map(seassion -> modelMapper.map(seassion, SeassionDTO.class)).collect(Collectors.toList());
    }

    @Override
    public SeassionDTO addSeassion(SeassionDTO seassionDTO) {
        Seassion seassion = seassionRepository.save(modelMapper.map(seassionDTO, Seassion.class));
        return modelMapper.map(seassion, SeassionDTO.class);
    }

    @Override
    public SeassionDTO getSeassionById(Long id) {
        return modelMapper.map(seassionRepository.findById(id).orElseThrow(()->new SeassionNotFoundException(id)), SeassionDTO.class);
    }

    @Override
    public SeassionDTO deleteSeassion(Long id){
        SeassionDTO seassionDTO = getSeassionById(id);
        seassionRepository.delete(modelMapper.map(seassionDTO, Seassion.class));
        return seassionDTO;
    }

    @Override
    public SeassionDTO updateSeassion(Long id, SeassionDTO seassionDTO) {
        return seassionRepository.findById(id).map(seassionToEdit -> {
            seassionToEdit.setDate(seassionDTO.getDate());
            seassionToEdit.setSeassionStartTime(seassionDTO.getSeassionStartTime());
            seassionRepository.save(seassionToEdit);
            return modelMapper.map(seassionToEdit, SeassionDTO.class);
        }).orElseThrow(() -> new SeassionNotFoundException(id));
    }
}
