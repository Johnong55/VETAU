package com.PBL4.test.Service;

import com.PBL4.test.repository.Ticket_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ticket_Service {
    @Autowired
    Ticket_Repository ticket_repository;

}
