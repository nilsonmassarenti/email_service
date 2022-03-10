package com.adidas.email_service.resources.v1;

import com.adidas.email_service.models.v1.SendEmailRequestDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmailResource {
    
    public ResponseEntity<?> sendEmail(@RequestBody SendEmailRequestDTO sendEmailRequestDTO);
    
}
