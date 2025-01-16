package com.brent.Bursary.consumer;

import com.brent.Bursary.config.RabbitMQConfig;
import com.brent.Bursary.dto.BursaryResponseBody;
import com.brent.Bursary.entity.BursaryEntity;
import com.brent.Bursary.repository.BursaryRepo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    BursaryRepo bursaryRepo;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void comsume(BursaryResponseBody bursaryResponseBody) {
        System.out.println(" consumer is able to consume message from the queues " + bursaryResponseBody);

        // Extract the EmployeeEntity from BursaryResponseBody
        BursaryEntity bursaryEntity = bursaryResponseBody.getBursary();

        // Save the EmployeeEntity to the database
        bursaryRepo.save(bursaryEntity);

        System.out.println("\nSaved employee entity to the database: " + bursaryEntity);
    }
}
