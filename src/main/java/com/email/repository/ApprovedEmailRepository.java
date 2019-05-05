package com.email.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.entity.ApprovedEmail;
import com.email.entity.EmailData;

@Repository
public interface ApprovedEmailRepository extends CrudRepository<ApprovedEmail,Long> {
	 @Query(value= "select * from ApprovedEmail a where a.deleted=false and a.hide=false",nativeQuery=true)
	 List<ApprovedEmail> findByDeleted(boolean isDeleted);
	 List<ApprovedEmail> findByHide(boolean isHidden);
	 List<ApprovedEmail> findByStar(boolean isStar);
	 
	 @Transactional
	 @Modifying
	 @Query("update ApprovedEmail a set a.hide=?1 where a.appEmailId=?2")
	 void  hideUnhideEmail(boolean status,Long id);
	 
	 @Transactional
	 @Modifying
	 @Query("update ApprovedEmail a set a.star=?1 where a.appEmailId=?2")
	 void  starUnstar(boolean status,Long id);
	 
	 @Query("select a from ApprovedEmail a where a.user_id=?1")
	  List<ApprovedEmail> findByUserId(Long user_id);
}
