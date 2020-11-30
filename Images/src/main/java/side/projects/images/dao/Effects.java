package side.projects.images.dao;

import java.io.File;  
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import side.projects.images.app.Grayscale;
import side.projects.images.app.Negative;
import side.projects.images.app.Sepia;
import side.projects.images.app.WaterMark;
import side.projects.images.dao.EffectsDAO;

@Component
public class Effects implements EffectsDAO {

	private Grayscale grayscale;
	private Negative negative;
	private WaterMark waterMark;
	private Sepia sepia;
	private File temp =new File("src/main/resources/temp.jpg");
	

	public Effects(Grayscale grayscale, Negative negative, WaterMark waterMark, Sepia sepia) {

		this.grayscale = grayscale;
		this.negative = negative;
		this.waterMark = waterMark;
		this.sepia = sepia;
	}

	@Override
	public File greyscale(MultipartFile file) {
		
			try {
				temp = grayscale.applyEffect(convert(file));
			} catch (IOException e) {
			
				e.printStackTrace();
			}
	
		return temp;

	}

	@Override
	public File negative(MultipartFile file) {
		try {
			temp = negative.applyEffect(convert(file));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public File sepia(MultipartFile file) {
		try {
			temp = sepia.applyEffect(convert(file));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public File waterMark(MultipartFile file,String wtrMark) {
		try {
			temp = waterMark.applyEffect(convert(file), wtrMark);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return temp;
	}
	
	@Override
	public File noSelection(MultipartFile file) {
		File f = null;
		try {
			f= convert(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return f;
	}
	
	

	private  File convert(MultipartFile file) throws IOException {

		FileOutputStream fos = new FileOutputStream(temp);
		fos.write(file.getBytes());
		fos.close();
		return temp;
	}

}
