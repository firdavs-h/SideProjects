package side.projects.images;

import java.io.File;

import org.springframework.stereotype.Component;

import side.projects.images.dao.EffectsDAO;

@Component
public class Effects implements EffectsDAO {
	
	private Grayscale grayscale;
	private Negative negative;
	private WaterMark waterMark;
	private Sepia sepia;
	
	
public Effects(Grayscale grayscale, Negative negative, WaterMark waterMark, Sepia sepia) {
		
		this.grayscale = grayscale;
		this.negative = negative;
		this.waterMark = waterMark;
		this.sepia = sepia;
	}




@Override
public File greyscale(File file) {
	return grayscale.applyEffect(file);
	
}


@Override
public File negative(File file) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public File sepia(File file) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public File waterMark(File file, String str) {
	// TODO Auto-generated method stub
	return null;
}
 
	
}
