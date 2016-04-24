package com.epam.spring.movie.mvc;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.Events;
import com.epam.spring.movie.bean.FileBucket;
import com.epam.spring.movie.service.EventService;
import com.epam.spring.movie.validator.FileValidator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FileUploadController {
	
	private static String UPLOAD_LOCATION="c:/temp/";
	
	@Autowired
	FileValidator fileValidator;
	
	@Autowired
	EventService eventService;
	
	@InitBinder("fileBucket")
	protected void initBinderFileBucket(WebDataBinder binder) {
		binder.setValidator(fileValidator);
	}
	
	@RequestMapping(value = {"/admin-upload-events", "/admin-upload-users"}, method = RequestMethod.GET)
	public String getUploadPage(ModelMap model) {
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
		return "file-uploader";
	}

	@RequestMapping(value = {"/admin-upload-events", "/admin-upload-users"}, method = RequestMethod.POST)
	public String fileUpload(@Valid FileBucket fileBucket,
			BindingResult result, ModelMap model, HttpServletRequest request) throws IOException {
		
		String restOfTheUrl = (String) request.getAttribute(
		        HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
		System.out.println(restOfTheUrl);

		if (result.hasErrors()) {
			return "file-uploader";
		} else {
			MultipartFile multipartFile = fileBucket.getFile();

			File file = new File(UPLOAD_LOCATION + fileBucket.getFile().getOriginalFilename());
			FileCopyUtils.copy(fileBucket.getFile().getBytes(), file);
			String fileName = multipartFile.getOriginalFilename();
			
			ObjectMapper mapper = new ObjectMapper();
			Events events = null;
			try {
				events = (Events) mapper.readValue(file, Events.class);
			} catch (JsonParseException e) {
				result.rejectValue("file", "invalid.file");
				return "file-uploader";
			}

			for(Event event: events) {
				eventService.create(event);		
			}
			
			model.addAttribute("fileName", fileName);
			return "success-upload";
		}
	}
	

}
