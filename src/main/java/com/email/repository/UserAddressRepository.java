package com.email.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.entity.UserAddress;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Repository
public interface UserAddressRepository extends CrudRepository<UserAddress,Long>{
	@Query("select a from UserAddress a where a.user_id=?1")
	  List<UserAddress> findByUserId(Long user_id);
}
