package side.projects.images.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import side.projects.images.dao.EffectsDAO;

@RestController
public class EffectsController {
	
	private EffectsDAO effectsDAO;

	public EffectsController(EffectsDAO effectsDAO) {
	
		this.effectsDAO = effectsDAO;
	}
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/up", method = RequestMethod.POST)
	public File greyscale(@RequestParam ("file") MultipartFile file) throws IOException {
		File tempFile = File.createTempFile("temp", ".jpg");

		tempFile.deleteOnExit();

		file.transferTo(tempFile);
		

		return effectsDAO.greyscale(tempFile);
	}
	
	

}
