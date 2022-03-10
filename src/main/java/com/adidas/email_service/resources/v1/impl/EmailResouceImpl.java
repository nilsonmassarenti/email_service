package com.adidas.email_service.resources.v1.impl;

import com.adidas.email_service.models.v1.SendEmailRequestDTO;
import com.adidas.email_service.resources.v1.EmailResource;
import com.adidas.email_service.services.v1.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/emails")
public class EmailResouceImpl implements EmailResource {

    @Autowired
    EmailService emailService;

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE                         )
    public ResponseEntity<?> sendEmail(@RequestBody SendEmailRequestDTO sendEmailRequestDTO) {
        this.emailService.addItemToProcess(sendEmailRequestDTO);                                                                 
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
