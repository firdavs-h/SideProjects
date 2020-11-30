package side.projects.images.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import side.projects.images.dao.EffectsDAO;

@CrossOrigin(origins = { "http://localhost:5502", "http://127.0.0.1:5502" })

@RestController
public class EffectsController {

	private EffectsDAO effectsDAO;
	private File temp;

	public EffectsController(EffectsDAO effectsDAO) {

		this.effectsDAO = effectsDAO;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

	public ResponseEntity<byte[]> greyscale(@RequestParam("file") MultipartFile file,
			@RequestParam(value = "effect-type", defaultValue = "") String type,
			@RequestParam(value = "watermark", defaultValue = "no text provided", required = false) String str)
			throws IOException {

		switch (type) {
		case "grayscale":
			temp = effectsDAO.greyscale(file);
			break;
		case "sepia":
			temp = effectsDAO.sepia(file);
			break;
		case "negative":
			temp = effectsDAO.negative(file);
			break;
		case "water":
			temp = effectsDAO.waterMark(file, str);
			break;

		case "":
			temp = effectsDAO.noSelection(file);
			break;
		}

		return getImage(temp);
	}

	private ResponseEntity<byte[]> getImage(File file) throws IOException {
		InputStream targetStream = new FileInputStream(file);
		byte[] bytes = StreamUtils.copyToByteArray(targetStream);

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}

}
