package com.email.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.entity.EmailDataAttachment;

@Repository
public interface EmailDataAttachmentRepository extends CrudRepository<EmailDataAttachment,Long> {

}
