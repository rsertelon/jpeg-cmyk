package ch.randelshofer.media;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

/**
 * This is a simple helper that wraps the call to ImageIO.read
 * 
 * @author Romain Sertelon
 */
public final class CMYKReader {
	
	public static BufferedImage read(File imageFile) throws FileNotFoundException, IOException {
		return read(new FileImageInputStream(imageFile));
	}
	
	public static BufferedImage read(ImageInputStream iis) {
		BufferedImage img = null;
		try {
			Iterator<ImageReader> i = ImageIO.getImageReaders(iis);
		    for(; img == null && i.hasNext(); ) {
		        ImageReader r = i.next();
		        try {
		            r.setInput(iis);
		            img = r.read(0);
		        } catch (IOException e) {}
		    }
		} finally {
		    try { if(iis != null) iis.close(); } catch (IOException e) {}
		}
		return img;
	}
	
	public static BufferedImage read(InputStream is) throws IOException {
		return read(ImageIO.createImageInputStream(is));
	}
	
}
