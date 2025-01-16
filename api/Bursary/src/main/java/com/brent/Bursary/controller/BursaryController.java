package com.brent.Bursary.controller;

import com.brent.Bursary.config.RabbitMQConfig;
import com.brent.Bursary.dto.BursaryResponseBody;
import com.brent.Bursary.entity.BursaryEntity;
import com.brent.Bursary.repository.BursaryRepo;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BursaryController {

    @Autowired
    BursaryRepo bursaryRepo;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/post-application")
    public BursaryResponseBody postBursaryDetails(@RequestBody @Valid BursaryEntity bursaryEntity){
        System.out.println(bursaryEntity);

        BursaryResponseBody bursaryResponseBody = new BursaryResponseBody(bursaryEntity, "Application submitted", "Your application has been summited!!!");

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, bursaryResponseBody);
        System.out.println("bursaryResponseBody" + bursaryResponseBody);
        return bursaryResponseBody;



    }



    @GetMapping("/get-all-applications")
    public List<BursaryEntity> getAllApplications(){

        return bursaryRepo.findAll();
    }

}
