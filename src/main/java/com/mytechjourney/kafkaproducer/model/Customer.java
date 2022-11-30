package com.mytechjourney.kafkaproducer.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Customer {
    String name;
    Date dob;
    String address;
    Long mobileNumber;
}
