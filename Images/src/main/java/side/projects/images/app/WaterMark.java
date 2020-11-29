package side.projects.images.app;

import java.awt.Color;

//For setting font of the watermark text 
import java.awt.Font;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

@Component
public class WaterMark {

	private BufferedImage img;
	File f;

	public File applyEffect(File file, String waterMark) {

		// read image
		try {
			f = file;
			img = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println(e);
		}

		// create BufferedImage object of same width and
		// height as of input image
		BufferedImage temp = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

		// Create graphics object and add original
		// image to it
		Graphics graphics = temp.getGraphics();
		graphics.drawImage(img, 0, 0, null);

		// Set font for the watermark text
		graphics.setFont(new Font("Arial", Font.PLAIN, 60));
		graphics.setColor(new Color(255, 255, 255, 90));


		// Add the watermark text at
		// location
	
		for (int i = img.getHeight() / 6; i < img.getHeight(); i+=75) {
			int x = 2;

			if (i % 2 == 0) {
				x = 8;
			}
			graphics.drawString(waterMark, img.getWidth() / x, i);
		
		}

		// releases any system resources that it is using
		graphics.dispose();

		
		try {
			ImageIO.write(temp, "jpg", f);
		} catch (IOException e) {
			System.out.println(e);
		}
		return f;
	}
}
