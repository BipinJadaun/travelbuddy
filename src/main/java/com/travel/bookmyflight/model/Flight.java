package com.travel.bookmyflight.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collation = "flights")
public class Flight {

    @Id
    Integer flightNo;
    String fromAirport;
    String toAirport;
    Date startTime;
    Date endTime;

}
