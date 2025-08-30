package com.nicholasnet.vacationbookingbackend.bootstrap;

import com.nicholasnet.vacationbookingbackend.dao.CustomerRepository;
import com.nicholasnet.vacationbookingbackend.dao.DivisionRepository;
import com.nicholasnet.vacationbookingbackend.entity.Customer;
import com.nicholasnet.vacationbookingbackend.entity.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count() == 0 && divisionRepository.count() > 0) {

            Division division = divisionRepository.findAll().iterator().next();

            customerRepository.save(new Customer("Jane", "Doe", "123 Easy Street", "08256", "5555555555", division));
            customerRepository.save(new Customer("Jack", "Smith", "341 Rough Street", "77777", "7777777777", division));
            customerRepository.save(new Customer("Jill", "Johnson", "456 Hard Street", "99999", "9999999999", division));
            customerRepository.save(new Customer("James", "Brown", "789 Salty Street", "22222", "2222222222", division));
            customerRepository.save(new Customer("Brock", "Wilson", "444 Faith Street", "33333", "3333333333", division));

            System.out.println("Added 5 sample customers");
        }
    }



}

