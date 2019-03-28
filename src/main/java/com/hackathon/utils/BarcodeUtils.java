package com.hackathon.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BarcodeUtils {


	private static final Logger logger = LoggerFactory.getLogger(BarcodeUtils.class);

	
	public static void generateBarcode(String personUID, String filePath)
	{
		//logger.info("personUID = "+personUID + ", filePath = "+filePath);
                try
                {
                	Code128Bean code128 = new Code128Bean();
                	code128.setHeight(15f);
                	code128.setModuleWidth(0.3);
                	code128.setQuietZone(10);
                	code128.doQuietZone(true);

                	ByteArrayOutputStream baos = new ByteArrayOutputStream();
                	BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
                	code128.generateBarcode(canvas, personUID);
                	canvas.finish();
                	
                	//write to png file
                	FileOutputStream fos = new FileOutputStream(filePath);
                	fos.write(baos.toByteArray());
                	fos.flush();
                	fos.close();
                	
                }
                catch (Exception e) {
					e.printStackTrace();
				}
	}
	
}
