package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.model.Appointment;

public interface AppointmentService {

	Appointment save(Appointment appointment);
	
	List<Appointment> findAllWithAppointmentDate(Date appointmentDate);

	boolean deleteByPhoneNumber(int phoneNumber);
	
	List<Appointment> findAllValid(Pageable pageable);

}
