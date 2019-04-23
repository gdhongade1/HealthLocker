package com.email.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.entity.Attachment;
import com.email.service.AttachmentService;

@RestController
@RequestMapping("/file")
public class FileDownloadController {
	
	@Autowired
	AttachmentService attachmentService;
	
	 @Autowired
	 private ServletContext servletContext;
	
	@GetMapping("/{id}")
	 public  ResponseEntity<InputStreamResource> downloadDocument(@PathVariable Long id) throws IOException{
		 
		 Attachment attachment = attachmentService.findById(id);
		 String filePath=attachment.getFilePath();
		 MediaType mediaType = getMediaTypeForFileName(this.servletContext, filePath.substring(filePath.lastIndexOf("\\")+1, filePath.length()));
		 
		 File file = new File(filePath);
	        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	        
	        return ResponseEntity.ok()
	                // Content-Disposition
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
	                // Content-Type
	                .contentType(mediaType)
	                // Contet-Length
	                .contentLength(file.length()) //
	                .body(resource);

		 
	 }
	
	public  MediaType getMediaTypeForFileName(ServletContext servletContext, String fileName) {
        String mineType = servletContext.getMimeType(fileName);
        try {
            MediaType mediaType = MediaType.parseMediaType(mineType);
            return mediaType;
        } catch (Exception e) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }

}
