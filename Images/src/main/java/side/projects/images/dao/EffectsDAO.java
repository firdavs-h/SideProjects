package side.projects.images.dao;

import java.io.File;

public interface EffectsDAO {
	
	File greyscale(File file);
	File negative(File file);
	File sepia(File file);
	File waterMark(File file, String str);
	
}
