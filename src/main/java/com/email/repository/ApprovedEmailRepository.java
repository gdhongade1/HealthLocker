package com.email.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.entity.ApprovedEmail;

@Repository
public interface ApprovedEmailRepository extends CrudRepository<ApprovedEmail,Long> {}
