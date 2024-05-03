package com.mostafa.librarysystem.services;

import com.mostafa.librarysystem.dto.patron.CreatePatronRequestDTO;
import com.mostafa.librarysystem.dto.patron.PatronDTO;
import com.mostafa.librarysystem.dto.patron.UpdatePatronRequestDTO;
import com.mostafa.librarysystem.entities.Patron;
import com.mostafa.librarysystem.repo.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatronService {
    @Autowired
    private PatronRepository patronRepository;

    @Transactional(readOnly = true)
    public List<PatronDTO> getAllPatrons(){
        return patronRepository.findAll().stream().map(this::convertToResponseDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PatronDTO getPatronById(Long id) {
        return patronRepository.findById(id)
                .map(this::convertToResponseDto)
                .orElse(null);
    }

    @Transactional
    public PatronDTO addPatron(CreatePatronRequestDTO requestDTO) {
        Patron patron = new Patron();
        patron.setName(requestDTO.getName());
        patron.setContactInformation(requestDTO.getContactInformation());
        Patron savedpatron = patronRepository.save(patron);
        return convertToResponseDto(savedpatron);
    }

    @Transactional
    public PatronDTO updatePatron(Long id, UpdatePatronRequestDTO requestDTO) {
        Optional<Patron> optionalPatron = patronRepository.findById(id);
        if (optionalPatron.isPresent()) {
            Patron patron = optionalPatron.get();
            patron.setName(requestDTO.getName());
            patron.setContactInformation(requestDTO.getContactInformation());

            Patron updatedPatron = patronRepository.save(patron);
            return convertToResponseDto(updatedPatron);
        } else {
            return null;
        }
    }

    @Transactional
    public boolean deletePatron(Long id) {
        if (patronRepository.existsById(id)) {
            patronRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    private PatronDTO convertToResponseDto(Patron patron) {
        PatronDTO dto = new PatronDTO();
        dto.setId(patron.getId());
        dto.setName(patron.getName());
        dto.setContactInformation(patron.getContactInformation());
        return dto;
    }

}
