package com.lits.project.service;

import com.lits.project.dto.SeassionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeassionService {

    public List<SeassionDTO> getAllSeassions();

    SeassionDTO addSeassion(SeassionDTO seassionDTO);

    SeassionDTO getSeassionById(Long id);

    SeassionDTO deleteSeassion(Long id);

    SeassionDTO updateSeassion(Long id, SeassionDTO seassionDTO);
}
