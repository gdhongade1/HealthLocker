package com.email.repository;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.entity.EmailData;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Repository
public interface EmailDataRepository extends CrudRepository<EmailData,Long> {
	  List<EmailData> findByStatus(String status);
	  @Query("select a from EmailData a where a.user_id=?1 and a.status='New'")
	  List<EmailData> findByUserId(Long user_id);
}
