package com.hackathon.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hackathon.dto.IDCardDTO;

public class CardPrintingUtils {


	private static final Logger logger = LoggerFactory.getLogger(CardPrintingUtils.class);

	
	public static void printCards(List<IDCardDTO> cards , String tenplatePath, String outputFilePath)
	{
		logger.info("filePath = "+outputFilePath);
		
		/*  first, get and initialize an engine  */
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        /*  next, get the Template  */
        Template t = ve.getTemplate("src/main/resources/template.vm" );
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        
        context.put("cards", cards);
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        /* show the World */
        //System.out.println( writer.toString() );   
        String outputContent = writer.toString();
        
        BufferedWriter bufferedWriter = null;
        try {
            File myFile = new File("C:/Temp/cards.html");
            // check if file exist, otherwise create the file before writing
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            Writer writer1 = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer1);
            bufferedWriter.write(outputContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(bufferedWriter != null) bufferedWriter.close();
            } catch(Exception ex){
                 
            }
        }
        
        System.out.println("-------------------------");
        System.out.println("Cards File has been saved at C:\\Temp\\cards.html");
        System.out.println("-------------------------");
                try
                {
                	for(IDCardDTO card : cards)
                	{
                		/*
                		System.out.println("----------------------------------");
                		System.out.println("Event Name :"  + card.eventName);
                		System.out.println("Host Logo  :"  + card.logoPath);
                		System.out.println("Host Inst. Name  :"  + card.hostName);
                		System.out.println("Event Duration :"  + card.eventDuration);
                		System.out.println("Passport Photo :"  + card.personPhoto);
                		System.out.println("Full Name :"  + card.personFullName);
                		System.out.println("Affilliation :"  + card.personAffilliation);
                		System.out.println("Place :"  + card.personPlace);
                		System.out.println("Country :"  + card.personCountry);
                		System.out.println("Visitor Area :");
                		System.out.println("Endorsement :");
                		System.out.println("Group Name :"  + card.grouopName);
                		System.out.println("Icon Path :"  + card.iconPath);
                		System.out.println("Barcode Path :"  + card.barcodePath);
                		*/
                	}
                }
                catch (Exception e) {
					e.printStackTrace();
				}
	}
	
}
