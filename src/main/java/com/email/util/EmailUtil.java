package com.email.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;

import com.email.entity.Attachment;
import com.email.entity.EmailData;
import com.email.entity.UserRegistration;
import com.email.repository.EmailDataRepository;
import com.email.repository.UserRegistrationRepository;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmailUtil {
	
	@Autowired
	UserRegistrationRepository userDao;
	
	@Autowired
	EmailDataRepository emailDao;
	
	public void sendOtpMessage(String otp,Long userId) {
			
		UserRegistration user=userDao.findOne(userId);
	   //   String to = user.getEmailAddress();
	      //System.out.println("Sending email to : "+to);
	      
	      
	      Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   try {
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("dhongade.ganesh23@gmail.com", "achievers8523");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("dhongade.ganesh23@gmail.com", false));

		  // msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		   msg.setSubject("One time password...");
		   msg.setContent("OTP isss : "+otp, "text/html");
/*
		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("My otpppp :"+ otp, "text/html");

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);*/
		  /* MimeBodyPart attachPart = new MimeBodyPart();

		   attachPart.attachFile("/var/tmp/image19.png");
		   multipart.addBodyPart(attachPart);
		   msg.setContent(multipart);*/
		   Transport.send(msg);   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
	     
	}
	

	 public ArrayList<EmailData> downloadEmails(String host, String port,
	            String userName, String password,UserRegistrationRepository userDao) {
		 
	        Properties properties = new Properties();
	        ArrayList<EmailData> emailList = new ArrayList<EmailData>();
	        ArrayList<Attachment> attachList = new ArrayList<Attachment>();
	       
	        // server setting
	        properties.put("mail.pop3.host", host);
	        properties.put("mail.pop3.port", port);
	 
	        // SSL setting
	        properties.setProperty("mail.pop3.socketFactory.class",
	                "javax.net.ssl.SSLSocketFactory");
	        properties.setProperty("mail.pop3.socketFactory.fallback", "false");
	        properties.setProperty("mail.pop3.socketFactory.port",
	                String.valueOf(port));
	 
	        Session session = Session.getDefaultInstance(properties);
	 
	        try {
	            // connects to the message store
	            Store store = session.getStore("pop3");
	            store.connect(userName, password);
	 
	            // opens the inbox folder
	            Folder folderInbox = store.getFolder("INBOX");
	            folderInbox.open(Folder.READ_ONLY);
	 
	            // fetches new messages from server
	            Message[] arrayMessages = folderInbox.getMessages();
	 
	            for (int i = 0; i < arrayMessages.length; i++) {
	                Message message = arrayMessages[i];
	                Address[] fromAddress = message.getFrom();
	                String from = fromAddress[0].toString();
	                String sender= parseAddresses(message.getFrom());
	                String subject = message.getSubject();
	                String toList = parseAddresses(message.getRecipients(Message.RecipientType.TO));
	                String ccList = parseAddresses(message.getRecipients(Message.RecipientType.CC));
	                String bccList = parseAddresses(message.getRecipients(Message.RecipientType.BCC));
	                String sentDate = message.getSentDate().toString();
	 
	                String contentType = message.getContentType();
	                String messageContent = "";
	                
	                EmailData email= new EmailData();
		                email.setBody(messageContent);
		                email.setCcId(ccList);
		                email.setCreatedOn(sentDate); //TODO -change to current date
		                email.setDateTime(sentDate);
		                email.setSenderId(sender);
		                email.setStatus("New");
		                email.setSubject(subject);
		                email.setToId(toList);
		                email.setUpdatedOn(sentDate);//TODO -change to current date
	                
	                UserRegistration user = userDao.findByEmailAddressIgnoreCase(toList);
	                long userID;
	                if(user!=null) {
	                	userID=user.getUser_reg_id();
	                	 email.setUser_id(userID);
	                }else {
	                	UserRegistration u = new UserRegistration();
	                	int toIndex= from.indexOf("<");
	                	String nameArr[]=from.split("<");
	                	String nameString=from.substring(0, toIndex);
	                	String nameAr[]=nameString.split(" ");
	                	String fName=nameAr[0];
	                	String lName=nameAr[1];
	                	
	                	u.setFirstName(fName);
	                	u.setLastName(lName);
	                	u.setEmailAddress(toList);
	                	u.setMobileNumber(toList.substring(0, 9));
	                	UserRegistration addedUser=userDao.save(u);
	                	userID=addedUser.getUser_reg_id();
	                	 email.setUser_id(userID);
	                }
	 
	                // store attachment file name, separated by comma
	                String attachFiles = "";
	 
	                if (contentType.contains("multipart")) {
	                    // content may contain attachments
	                    Multipart multiPart = (Multipart) message.getContent();
	                    MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
	                    messageContent = getTextFromMimeMultipart(mimeMultipart);
	                    int numberOfParts = multiPart.getCount();
	                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
	                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
	                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
	                        	Attachment attach= new Attachment();
	                            // this part is attachment
	                            String fileName = part.getFileName();
	                            String fileType= fileName.substring(fileName.lastIndexOf(".")+1);
	                            attachFiles += fileName + ", ";
	                            long currentTime= new Date().getTime();
	                            String filePath="C:/Attachment" + File.separator + fileName.substring(0,fileName.lastIndexOf("."))+"_"+currentTime+"."+fileType;
	                            attach.setFileType(fileType);
	                            attach.setFileSize( part.getSize());
	                            attach.setFilePath(filePath);
	                            attach.setUser_id(userID);
	                            attachList.add(attach);
	                            email.setAttachment(attachList);
	                            String newFileName=fileName.substring(0,fileName.lastIndexOf("."))+"_"+currentTime+"."+fileType;
	                            part.saveFile("C:/Attachment" + File.separator + newFileName);
	                        } else {
	                            // this part may be the message content
	                            //messageContent = part.getContent().toString();
	                        	/*Object content = message.getContent();
	    	                    if (content != null) {
	    	                        messageContent = content.toString();
	    	                    }*/

	                        }
	                    }
	 
	                    if (attachFiles.length() > 1) {
	                        attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
	                    }
	                } else if (contentType.contains("text/plain")
	                        || contentType.contains("text/html")) {
	                    Object content = message.getContent();
	                    if (content != null) {
	                        messageContent = content.toString();
	                    }
	                }
	 
	                // print out details of each message
	                System.out.println("Message #" + (i + 1) + ":");
	                emailList.add(email);
	                
	                
	                
	                System.out.println("\t From: " + from);
	                System.out.println("\t To : " + toList);
	                System.out.println("\t CC : " + ccList);
	                System.out.println("\t BCC : " + bccList);
	                System.out.println("\t Subject: " + subject);
	                System.out.println("\t Sent Date: " + sentDate);
	                System.out.println("\t Message: " + messageContent);
	                System.out.println("\t Attachments: " + attachFiles);
	            }
	 
	            // disconnect
	            folderInbox.close(false);
	            store.close();
	           
	        } catch (NoSuchProviderException ex) {
	            System.out.println("No provider for pop3.");
	            ex.printStackTrace();
	        } catch (MessagingException ex) {
	            System.out.println("Could not connect to the message store");
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return emailList;
	    }
	
	 private String getTextFromMimeMultipart(
		        MimeMultipart mimeMultipart)  throws MessagingException, IOException{
		    String result = "";
		    int count = mimeMultipart.getCount();
		    for (int i = 0; i < count; i++) {
		        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
		        if (bodyPart.isMimeType("text/plain")) {
		            result = result + "\n" + bodyPart.getContent();
		            break; // without break same text appears twice in my tests
		        } else if (bodyPart.isMimeType("text/html")) {
		            String html = (String) bodyPart.getContent();
		            result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
		        } else if (bodyPart.getContent() instanceof MimeMultipart){
		            result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
		        }
		    }
		    return result;
		}
	 
	 private String parseAddresses(Address[] address) {
	        String listAddress = "";
	 
	        if (address != null) {
	            for (int i = 0; i < address.length; i++) {
	                listAddress += address[i].toString() + ", ";
	            }
	        }
	        if (listAddress.length() > 1) {
	            listAddress = listAddress.substring(0, listAddress.length() - 2);
	        }
	 
	        return listAddress;
	    }
	 

}
