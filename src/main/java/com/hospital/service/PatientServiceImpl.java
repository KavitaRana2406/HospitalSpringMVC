package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Patient;
import com.hospital.repository.PatientDao;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao pDao;
	
	@Override
	public List<Patient> findAll() {
		return pDao.findAll();
	}

	@Override
	public Patient findById(int patientId) {
		return pDao.findById(patientId);
	}

	@Override
	public int deletById(int patientId) {
		return pDao.deletById(patientId);
	}

	@Override
	public int save(Patient p) {
		return pDao.save(p);
	}

	@Override
	public int update(Patient p, int patientId) {
		return pDao.update(p, patientId);
	}

}
