package com.nicholasnet.vacationbookingbackend.dao;

import com.nicholasnet.vacationbookingbackend.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface VacationRepository extends JpaRepository<Vacation, Long> {


}
