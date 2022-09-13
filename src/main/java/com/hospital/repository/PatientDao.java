package com.hospital.repository;

import java.util.List;

import com.hospital.entity.Patient;

public interface PatientDao {

	List<Patient> findAll();
	Patient findById(int patientId);
	int deletById(int patientId);
	int save(Patient p);
	int update(Patient p,int patientId);
}
