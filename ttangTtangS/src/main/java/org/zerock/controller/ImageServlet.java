package org.zerock.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageServlet {
	private static final Logger logger = LoggerFactory.getLogger(ImageServlet.class);
	 
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public void uploadForm(@RequestParam("imageFile") List<MultipartFile> files, Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		PrintWriter pw = res.getWriter();
		int index = 0;
		
		for (MultipartFile file : files) {
			logger.info("originalName: " + file.getOriginalFilename());
		    logger.info("size: " + file.getSize());
		    logger.info("contentType: " + file.getContentType());
	
		    String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), req);
	
		    model.addAttribute("savedName", savedName);
			
		    if(index != 0) {
		    	pw.print(",");
		    }
		    pw.print(savedName);
		    index++;
		}
	}
	
	private String uploadFile(String originalName, byte[] fileData, HttpServletRequest req) throws Exception {
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		UUID uid = UUID.randomUUID();
	    String savedName = uid.toString() + ".jpg";
	    File target = new File(path, savedName);
	    FileCopyUtils.copy(fileData, target);

	    return savedName;
	}
	
}

