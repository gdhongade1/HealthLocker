package com.email.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.entity.ApprovedEmail;
import com.email.entity.ApprovedEmailAttachment;
import com.email.entity.Attachment;
import com.email.entity.EmailData;
import com.email.entity.EmailRemark;
import com.email.entity.EmailSpecification;
import com.email.entity.EmailSubject;
import com.email.entity.Remark;
import com.email.entity.Specification;
import com.email.entity.Subject;
import com.email.service.ApprovedEmailAttachmentService;
import com.email.service.ApprovedEmailService;
import com.email.service.EmailDataService;
import com.email.service.EmailRemarkService;
import com.email.service.EmailSpecificationService;
import com.email.service.EmailSubjectService;

@RestController
@RequestMapping({"/approvedEmail"})
public class ApprovedEmailController {
	
	@Autowired
	ApprovedEmailService service;
	
	@Autowired
	EmailSubjectService emailSubjectService;
	
	@Autowired
	EmailSpecificationService emailSpecificationService;
	
	@Autowired
	EmailRemarkService emailRemarkService;
	
	@Autowired
	ApprovedEmailAttachmentService approvedEmailAttachmentService;
	
	
	@PostMapping
	public ResponseEntity<ApprovedEmail> create(@RequestBody ApprovedEmail email,Principal principal){
		ApprovedEmail appEmail=null;
		//if(principal!=null) {
			List<Subject> subjectList =email.getSub();
			List<Subject> newSubjectList =new ArrayList<Subject>();
			
			List<Remark> remarkList =email.getRemark();
			List<Remark> newRemarkList =new ArrayList<Remark>();
			
			List<Specification> specificationList =email.getSpec();
			List<Specification> newSpecificationList =new ArrayList<Specification>();
			
			List<Attachment> attachmentList =email.getAttachment();
			List<Attachment> newAttachmentList =new ArrayList<Attachment>();
			
			List<EmailSubject> emailSubjectList= new ArrayList<EmailSubject>();
			List<EmailSpecification> emailSpecificationList= new ArrayList<EmailSpecification>();
			List<EmailRemark> emailRemarkList= new ArrayList<EmailRemark>();
			List<ApprovedEmailAttachment> approvedEmailAttachmentList= new ArrayList<ApprovedEmailAttachment>();
			
			if(subjectList!=null && subjectList.size()!=0) {
				for(Subject subject : subjectList) {
					if(subject.getSubjectId()==0) {
						newSubjectList.add(subject);
					}else {
						EmailSubject emailSubject= new EmailSubject();
						emailSubject.setSubjectId(subject.getSubjectId());
						emailSubjectList.add(emailSubject);
					}
			}
			}
			if(attachmentList!=null && attachmentList.size()!=0) {
				for(Attachment attachment : attachmentList) {
					
						ApprovedEmailAttachment approvedEmailAttachment= new ApprovedEmailAttachment();
						approvedEmailAttachment.setFileId(attachment.getFileId());
						approvedEmailAttachmentList.add(approvedEmailAttachment);
			}
			}
			if(specificationList!=null && specificationList.size()!=0) {
				for(Specification specification : specificationList) {
					if(specification.getSpecificationId()==0) {
						newSpecificationList.add(specification);
					}else {
						EmailSpecification emailSpecification= new EmailSpecification();
						emailSpecification.setSpecificationId(specification.getSpecificationId());
						emailSpecificationList.add(emailSpecification);
					}
				}
			}
			if(remarkList!=null && remarkList.size()!=0) {
				for(Remark remark : remarkList) {
					if(remark.getRemarkId()==0) {
						newRemarkList.add(remark);
					}else {
						EmailRemark emailRemark= new EmailRemark();
						emailRemark.setRemarkId(remark.getRemarkId());
						emailRemarkList.add(emailRemark);
					}
			}
			}
			
			
			if(newSubjectList.size()!=0) {
				email.setSub(newSubjectList);
			}else {
				email.setSub(null);
			}
			if(newRemarkList.size()!=0) {
				email.setRemark(newRemarkList);
			}else {
				email.setRemark(null);
			}
			if(newSpecificationList.size()!=0) {
				email.setSpec(newSpecificationList);;
			}else {
				email.setSpec(null);
			}
			
			email.setAttachment(null);
			
			appEmail=service.save(email);
			
			if(emailSubjectList.size()>0) {
				for(EmailSubject emailSubject:emailSubjectList)
					emailSubject.setAppEmailId(appEmail.getAppEmailId());
				
				emailSubjectService.saveAll(emailSubjectList);
			}
			if(emailRemarkList.size()>0) {
				for(EmailRemark emailRemark:emailRemarkList)
					emailRemark.setAppEmailId(appEmail.getAppEmailId());
				
				emailRemarkService.saveAll(emailRemarkList);
			}
			if(emailSpecificationList.size()>0) {
				for(EmailSpecification emailSpecification:emailSpecificationList)
					emailSpecification.setAppEmailId(appEmail.getAppEmailId());
				
				emailSpecificationService.saveAll(emailSpecificationList);
			}
			if(approvedEmailAttachmentList.size()>0) {
				for(ApprovedEmailAttachment approvedEmailAttachment:approvedEmailAttachmentList)
					approvedEmailAttachment.setAppEmailId(appEmail.getAppEmailId());
				
				approvedEmailAttachmentService.saveAll(approvedEmailAttachmentList);
			}
			
			
			return new ResponseEntity<ApprovedEmail>(appEmail,HttpStatus.OK);
		//}
		//return new ResponseEntity<ApprovedEmail>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping
	public ResponseEntity<List<ApprovedEmail>> findAll(Principal principal){
		List<ApprovedEmail> appEmail=null;
		//if(principal!=null) {
			appEmail= service.findAll();
			return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.OK);
		//}
		//return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/approved")
	public ResponseEntity<List<ApprovedEmail>> findByIsDeleted(Principal principal){
		List<ApprovedEmail> appEmail=null;
		//if(principal!=null) {
			appEmail= service.findByIsDeleted();
			return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.OK);
		//}
		//return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ApprovedEmail> updateById(@PathVariable Long id, @RequestBody ApprovedEmail email,Principal principal) {

		ApprovedEmail appEmail=null;
		//if(principal!=null) {
			List<Subject> subjectList =email.getSub();
			List<Subject> newSubjectList =new ArrayList<Subject>();
			
			List<Remark> remarkList =email.getRemark();
			List<Remark> newRemarkList =new ArrayList<Remark>();
			
			List<Specification> specificationList =email.getSpec();
			List<Specification> newSpecificationList =new ArrayList<Specification>();
			
			List<Attachment> attachmentList =email.getAttachment();
			List<Attachment> newAttachmentList =new ArrayList<Attachment>();
			
			List<EmailSubject> emailSubjectList= new ArrayList<EmailSubject>();
			List<EmailSpecification> emailSpecificationList= new ArrayList<EmailSpecification>();
			List<EmailRemark> emailRemarkList= new ArrayList<EmailRemark>();
			List<ApprovedEmailAttachment> approvedEmailAttachmentList= new ArrayList<ApprovedEmailAttachment>();
			
			if(subjectList!=null && subjectList.size()!=0) {
				for(Subject subject : subjectList) {
					if(subject.getSubjectId()==0) {
						newSubjectList.add(subject);
					}else {
						EmailSubject emailSubject= new EmailSubject();
						emailSubject.setSubjectId(subject.getSubjectId());
						emailSubjectList.add(emailSubject);
					}
			}
			}
			if(attachmentList!=null && attachmentList.size()!=0) {
				for(Attachment attachment : attachmentList) {
					
						ApprovedEmailAttachment approvedEmailAttachment= new ApprovedEmailAttachment();
						approvedEmailAttachment.setFileId(attachment.getFileId());
						approvedEmailAttachmentList.add(approvedEmailAttachment);
			}
			}
			if(specificationList!=null && specificationList.size()!=0) {
				for(Specification specification : specificationList) {
					if(specification.getSpecificationId()==0) {
						newSpecificationList.add(specification);
					}else {
						EmailSpecification emailSpecification= new EmailSpecification();
						emailSpecification.setSpecificationId(specification.getSpecificationId());
						emailSpecificationList.add(emailSpecification);
					}
				}
			}
			if(remarkList!=null && remarkList.size()!=0) {
				for(Remark remark : remarkList) {
					if(remark.getRemarkId()==0) {
						newRemarkList.add(remark);
					}else {
						EmailRemark emailRemark= new EmailRemark();
						emailRemark.setRemarkId(remark.getRemarkId());
						emailRemarkList.add(emailRemark);
					}
			}
			}
			
			
			if(newSubjectList.size()!=0) {
				email.setSub(newSubjectList);
			}else {
				email.setSub(null);
			}
			if(newRemarkList.size()!=0) {
				email.setRemark(newRemarkList);
			}else {
				email.setRemark(null);
			}
			if(newSpecificationList.size()!=0) {
				email.setSpec(newSpecificationList);;
			}else {
				email.setSpec(null);
			}
			
			email.setAttachment(null);
			
			appEmail=service.save(email);
			
			if(emailSubjectList.size()>0) {
				for(EmailSubject emailSubject:emailSubjectList)
					emailSubject.setAppEmailId(appEmail.getAppEmailId());
				
				emailSubjectService.saveAll(emailSubjectList);
			}
			if(emailRemarkList.size()>0) {
				for(EmailRemark emailRemark:emailRemarkList)
					emailRemark.setAppEmailId(appEmail.getAppEmailId());
				
				emailRemarkService.saveAll(emailRemarkList);
			}
			if(emailSpecificationList.size()>0) {
				for(EmailSpecification emailSpecification:emailSpecificationList)
					emailSpecification.setAppEmailId(appEmail.getAppEmailId());
				
				emailSpecificationService.saveAll(emailSpecificationList);
			}
			if(approvedEmailAttachmentList.size()>0) {
				for(ApprovedEmailAttachment approvedEmailAttachment:approvedEmailAttachmentList)
					approvedEmailAttachment.setAppEmailId(appEmail.getAppEmailId());
				
				approvedEmailAttachmentService.saveAll(approvedEmailAttachmentList);
			}
			
			
			return new ResponseEntity<ApprovedEmail>(appEmail,HttpStatus.OK);
		//}
		//return new ResponseEntity<ApprovedEmail>(appEmail,HttpStatus.UNAUTHORIZED);
	
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<String> deleteById(@PathVariable Long id,Principal principal) {
		//if(principal!=null) {
			ApprovedEmail apEmail= service.findById(id);
			apEmail.setDeleted(true);
			service.save(apEmail);
			return new ResponseEntity<String>("success..",HttpStatus.OK);
		//}
		//return new ResponseEntity<String>("Failed..",HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/getHidden")
	public ResponseEntity<List<ApprovedEmail>> findByHide(Principal principal){
		List<ApprovedEmail> appEmail=null;
		//if(principal!=null) {
			appEmail= service.findByHide();
			return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.OK);
		//}
		//return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	@GetMapping("/getStar")
	public ResponseEntity<List<ApprovedEmail>> findByStar(Principal principal){
		List<ApprovedEmail> appEmail=null;
		//if(principal!=null) {
			appEmail= service.findByStar();
			return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.OK);
		//}
		//return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/hideUnhide/{id}/{status}")
	public ResponseEntity<String> hideUnhideEmail(@PathVariable Long id,@PathVariable boolean status, Principal principal){
		List<ApprovedEmail> appEmail=null;
		//if(principal!=null) {
			 service.hideUnhideEmail(status,id);
			 return new ResponseEntity<String>("success..",HttpStatus.OK);
		//}
		//return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.UNAUTHORIZED);
	}

}
