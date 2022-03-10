package com.adidas.email_service.services.v1;

import com.adidas.email_service.models.v1.SendEmailRequestDTO;

public interface EmailService {

    public void sendEmail();
    public void addItemToProcess(SendEmailRequestDTO emailRequestDTO);
    
}
