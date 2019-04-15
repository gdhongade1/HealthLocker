package com.email.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.entity.ApprovedEmail;
import com.email.entity.EmailData;

@Repository
public interface ApprovedEmailRepository extends CrudRepository<ApprovedEmail,Long> {
	 List<ApprovedEmail> findByDeleted(boolean isDeleted);
}
