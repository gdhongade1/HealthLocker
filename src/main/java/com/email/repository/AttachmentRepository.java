package com.email.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.entity.Attachment;

@Repository
public interface AttachmentRepository extends CrudRepository<Attachment,Long>{}
