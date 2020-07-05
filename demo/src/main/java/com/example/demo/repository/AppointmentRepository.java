package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Appointment;

//@Transactional
//@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	@org.springframework.data.jpa.repository.Query("from Appointment a where a.appointmentTime.appointmentDate >= CURRENT_DATE")
	List<Appointment> findAllValid(Pageable pageable);
	
	List<Appointment> findAppointmentByPhoneNumberOrderByIdDesc(int phoneNumber, Pageable pageable);
	
	List<Appointment> findByAppointmentTimeAppointmentDate(Date appointmentDate);

	 
	 
	 // Komentarisao sam kod jer mi je potreban pagination pa sam koristio Spring Data ovde
	 
	 
	/*
	@PersistenceContext
	EntityManager em;
	
	public List<Appointment> findAllWithAppointmentDate(Date appointmentDate) {
		Query query = em.createQuery("from Appointment a where a.appointmentTime.appointmentDate = :appointmentDate");
		query.setParameter("appointmentDate", appointmentDate);
		return query.getResultList();
	}
	
	public void save(Appointment appointment) {
		em.persist(appointment); 

	}
	
	public void delete(Appointment appointment) {
		em.remove(appointment);
	}
	
	public Appointment getLatestAppointmentByPhoneNumber(int phoneNumber) {
		Query query = em.createQuery("from Appointment a where a.phoneNumber = :phoneNumber order by a.id");
		query.setParameter("phoneNumber", phoneNumber);
		query.setMaxResults(1);
		
		Appointment appointment = (Appointment) query.getSingleResult();
		
		return appointment;
	}
	 */

}