package com.email.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.entity.EmailData;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Repository
public interface EmailDataRepository extends CrudRepository<EmailData,Long> {}
