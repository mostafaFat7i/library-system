package com.mostafa.librarysystem.controllers;


import com.mostafa.librarysystem.dto.ResponseStatus;
import com.mostafa.librarysystem.dto.patron.*;
import com.mostafa.librarysystem.services.PatronService;
import com.mostafa.librarysystem.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatronController {
    @Autowired
    private PatronService patronService;
    ResponseStatus status;

    @GetMapping("/patrons")
    public ResponseEntity<GetAllPatronsResponseDTO> getAllPatrons(){
        GetAllPatronsResponseDTO response;

        List<PatronDTO> data = patronService.getAllPatrons();
        if (data !=null){
            status=ResponseStatus.builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).build();
            response=new GetAllPatronsResponseDTO(status,data);
        }
        else {
            status=ResponseStatus.builder().code(Constants.ERROR_CODE).message(Constants.ERROR_MESSAGE).build();
            response=new GetAllPatronsResponseDTO(status,null);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/patrons/{id}")
    public ResponseEntity<GetPatronByIdResponseDTO> getPatronById(@PathVariable Long id) {
        GetPatronByIdResponseDTO response;

        PatronDTO data = patronService.getPatronById(id);
        if (data !=null){
            status=ResponseStatus.builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).build();
            response=new GetPatronByIdResponseDTO(status,data);
        }
        else {
            status=ResponseStatus.builder().code(Constants.ERROR_CODE).message(Constants.ERROR_MESSAGE).build();
            response=new GetPatronByIdResponseDTO(status,null);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/patrons")
    public ResponseEntity<CreatePatronResponseDTO> addPatron(@RequestBody CreatePatronRequestDTO requestDTO) {
        CreatePatronResponseDTO response;
        PatronDTO data = patronService.addPatron(requestDTO);
        if (data !=null){
            status=ResponseStatus.builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).build();
            response=new CreatePatronResponseDTO(status,data);
        }
        else {
            status=ResponseStatus.builder().code(Constants.ERROR_CODE).message(Constants.ERROR_MESSAGE).build();
            response=new CreatePatronResponseDTO(status,null);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/patrons/{id}")
    public ResponseEntity<UpdatePatronResponseDTO> updatePatron(@PathVariable Long id, @RequestBody UpdatePatronRequestDTO requestDTO) {
        UpdatePatronResponseDTO response;
        PatronDTO updatedPatron = patronService.updatePatron(id, requestDTO);
        if (updatedPatron != null) {
            status=ResponseStatus.builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).build();
            response=new UpdatePatronResponseDTO(status,updatedPatron);
        } else {
            status=ResponseStatus.builder().code(Constants.ERROR_CODE).message(Constants.ERROR_MESSAGE).build();
            response=new UpdatePatronResponseDTO(status,null);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/patrons/{id}")
    public ResponseEntity<DeletedPatronResponseDTO> deletePatron(@PathVariable Long id) {
        DeletedPatronResponseDTO response;
        boolean deleted = patronService.deletePatron(id);
        if (deleted) {
            status=ResponseStatus.builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_DELETE_MESSAGE).build();
            response=new DeletedPatronResponseDTO(status);
        } else {
            status=ResponseStatus.builder().code(Constants.ERROR_Deleted_CODE).message(Constants.SUCCESS_DELETE_MESSAGE).build();
            response=new DeletedPatronResponseDTO(status);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
