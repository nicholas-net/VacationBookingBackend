package com.nicholasnet.vacationbookingbackend.bootstrap;

import com.nicholasnet.vacationbookingbackend.dao.CustomerRepository;
import com.nicholasnet.vacationbookingbackend.dao.DivisionRepository;
import com.nicholasnet.vacationbookingbackend.entity.Customer;
import com.nicholasnet.vacationbookingbackend.entity.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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


        if (customerRepository.count() < 6 && divisionRepository.count() >= 5) {

            List<Division> divisions = divisionRepository.findAll();

            customerRepository.save(new Customer("Lebron", "James", "123 Easy Street", "08256", "5555555555", divisions.get(0)));
            customerRepository.save(new Customer("Clem", "Clue", "341 Rough Street", "77777", "7777777777", divisions.get(1)));
            customerRepository.save(new Customer("Michael", "Vick", "456 Hard Street", "99999", "9999999999", divisions.get(2)));
            customerRepository.save(new Customer("Brandon", "Gallipoli", "789 Salty Street", "22222", "2222222222", divisions.get(3)));
            customerRepository.save(new Customer("Blake", "Bortles", "444 Faith Street", "33333", "3333333333", divisions.get(4)));

            System.out.println("Added 5 sample customers");
        }
    }



}

