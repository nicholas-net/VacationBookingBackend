package com.nicholasnet.vacationbookingbackend.bootstrap;

import com.nicholasnet.vacationbookingbackend.dao.CustomerRepository;
import com.nicholasnet.vacationbookingbackend.dao.DivisionRepository;
import com.nicholasnet.vacationbookingbackend.entity.Customer;
import com.nicholasnet.vacationbookingbackend.entity.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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

        ArrayList<Division> divisions = new ArrayList<>();

        if (customerRepository.count() < 6 && divisionRepository.count() > 0) {

            while (divisionRepository.findAll().iterator().hasNext()) {
               Division division = divisionRepository.findAll().iterator().next();
               divisions.add(division);
            }

            customerRepository.save(new Customer("John", "Doe", "123 Easy Street", "08256", "5555555555", divisions.get(0)));
            customerRepository.save(new Customer("Jack", "Smith", "341 Rough Street", "77777", "7777777777", divisions.get(1)));
            customerRepository.save(new Customer("Jill", "Johnson", "456 Hard Street", "99999", "9999999999", divisions.get(2)));
            customerRepository.save(new Customer("James", "Brown", "789 Salty Street", "22222", "2222222222", divisions.get(3)));
            customerRepository.save(new Customer("Brock", "Wilson", "444 Faith Street", "33333", "3333333333", divisions.get(4)));

            System.out.println("Added 5 sample customers");
        }
    }



}

