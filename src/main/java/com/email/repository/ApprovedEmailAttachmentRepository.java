package com.email.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.entity.ApprovedEmailAttachment;

@Repository
public interface ApprovedEmailAttachmentRepository extends CrudRepository<ApprovedEmailAttachment,Long> {
	

}
