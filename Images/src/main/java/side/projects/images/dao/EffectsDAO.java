package side.projects.images.dao;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface EffectsDAO {
	
	File greyscale(MultipartFile file);
	File negative(MultipartFile file);
	File sepia(MultipartFile file);
	File waterMark(MultipartFile file, String str);
	File noSelection(MultipartFile file);
	
}
