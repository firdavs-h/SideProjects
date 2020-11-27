package side.projects.images;

//Java code for watermarking an image 
//For setting color of the watermark text 
import java.awt.Color;

//For setting font of the watermark text 
import java.awt.Font;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WaterMark {
	public static void main(String[] args) {
		BufferedImage img = null;
		File f = null;

		// Read image
		try {
			f = new File("monalisa.jpg");
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
		graphics.setFont(new Font("Arial", Font.PLAIN, 90));
		graphics.setColor(new Color(255, 255, 255, 90));

		// Setting watermark text
		String watermark = "MONA LISA";

		// Add the watermark text at 
		// location
		int y = img.getHeight() / 5;
		for (int i = 1; i < 10; i++) {
			int x =2;
			
			if(i%2==0) {
				x=8;
			}
			graphics.drawString(watermark, img.getWidth()/x , y );
			y+=100;
		}
		

		// releases any system resources that it is using
		graphics.dispose();

		f = new File("output.jpg");
		try {
			ImageIO.write(temp, "jpg", f);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
