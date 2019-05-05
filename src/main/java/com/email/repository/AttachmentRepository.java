package com.email.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.entity.Attachment;

@Repository
public interface AttachmentRepository extends CrudRepository<Attachment,Long>{
	@Query("select a from Attachment a where a.user_id=?1")
	  List<Attachment> findByUserId(Long user_id);
}

