package com.adidas.email_service.services.v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.adidas.email_service.models.v1.SendEmailRequestDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{

    private static Logger logger = LoggerFactory.getLogger(EmailService.class);

    private List<SendEmailRequestDTO> list = Collections.synchronizedList(new ArrayList<SendEmailRequestDTO>());
    @Scheduled(initialDelay=1000, fixedRate=5000)
    @Override
    public void sendEmail() {
        List<SendEmailRequestDTO> newList = new ArrayList<>();
        synchronized(this.list) {
            newList = List.copyOf(this.list);
            this.list.clear();
        }
        logger.info("Processing " + newList.size() + " emails");
        newList.parallelStream().forEach(obj -> {
            logger.info("Sending email for: " + obj.getEmail());
        });
    }
    @Override
    public void addItemToProcess(SendEmailRequestDTO emailRequestDTO) {
        this.list.add(emailRequestDTO);
    }
    
    
}
