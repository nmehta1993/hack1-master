package com.hackathon;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hackathon.provider.AppProvider;
import com.itextpdf.text.DocumentException;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootConsoleApplication.class);
	
	@Autowired
    private AppProvider inputProvider;
    
	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		inputProvider.doProcess();
	}
	
	
}
