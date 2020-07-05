package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Appointment;
import com.example.demo.model.Type;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.TypeRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/types")
public class TypeController {

	@Autowired
	TypeRepository tr;

	@GetMapping()
	public List<Type> getAllTypes() {
		return tr.findAll();
	}
	
}
