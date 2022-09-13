package com.hospital.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.hospital.entity.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//Read
	@Override
	public List<Patient> findAll() {
		return jdbcTemplate.query("select * from Patient", new BeanPropertyRowMapper<Patient>(Patient.class));
	}
	//Read
	@Override
	public Patient findById(int patientId) {
		return jdbcTemplate.queryForObject("Select *from Patient where patientId=?", new BeanPropertyRowMapper<Patient>(Patient.class),patientId);
	}
	//Delete
	@Override
	public int deletById(int patientId) {
		return jdbcTemplate.update("delete from Patient where patientId=?",patientId);
	}
	//Create
	@Override
	public int save(Patient p) {
		return jdbcTemplate.update("insert into Patient(patientId,patientName,age,disease) values(?,?,?,?)", 
				new Object[] {p.getPatientId(),p.getPatientName(),p.getAge(),p.getDisease()});
	}
	//Update
	@Override
	public int update(Patient p, int patientId) {
		return jdbcTemplate.update("update Patient set disease=? where patientId=?",
				new Object[] {p.getDisease(),patientId});
	}

}
