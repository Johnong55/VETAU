package com.PBL4.test.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Customer")
public class Customer extends Account {
	
}
