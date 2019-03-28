package com.hackathon.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hackathon.dto.PersonDTO;
import com.hackathon.dto.UserInputDTO;
import com.hackathon.utils.ApplicationConstants;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class AppDAO implements ApplicationConstants {

	private static final Logger logger = LoggerFactory.getLogger(AppDAO.class);

	
	@Value("${dataLocation:unknown}")
	private String dataLocation;
	

	@Value("${inputData:unknown}")
	private String inputDataFile;
	
	private static final String[] groups = new String[] { "Coordinator", "Organizer", "Participant", "Volunteer" };
	

	public void doProcess(UserInputDTO data) {
		saveInput(data);
	}

	public void saveInput(UserInputDTO data) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			System.out.println("in saveInput........");
			File file = new File(dataLocation+File.separator+inputDataFile);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(data.toCsvData());
			logger.info("Data : " + data.toCsvData());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public List<PersonDTO> readCSVData(String group) {
		List<PersonDTO> personList = new ArrayList<PersonDTO>();
		List<String> groupList = new ArrayList<>();
		
		
		if(group.equalsIgnoreCase("all"))
		{
			groupList = new LinkedList<>(Arrays.asList(groups));
		}
		else
		{
			groupList.add(group);
		}
		
		for(String groupName: groupList)
		{
			try { 
		        // Create an object of file reader 
		        // class with CSV file as a parameter. 
		        FileReader filereader = new FileReader(dataLocation + File.separator + groupName +".csv");
		  
		        // create csvReader object and skip first Line 
		        CSVReader csvReader = new CSVReaderBuilder(filereader) 
		                                  .withSkipLines(1) 
		                                  .build(); 
		        List<String[]> allData = csvReader.readAll(); 
		  
		        // print Data 
		        for (String[] row : allData) { 
		        	
		        	PersonDTO dto = new PersonDTO();
		        	int idx=0;
		        	
		        	dto.personUID = row[idx++];
		        	dto.personFullName = row[idx++];
		        	dto.personAffilliation = row[idx++];
		        	dto.personPlace = row[idx++]; 
		        	dto.personPhoto = row[idx++]; 
		        	dto.personPhoto = dto.personPhoto + File.separator + dto.personUID.replace(" ", "-") + ".jpg";
		        	dto.personMobile = row[idx++]; 
		        	dto.personCountry = row[idx++];
		        	dto.barcodePath = dto.personPhoto.replace("photos", "barcodes");
		        	dto.groupName = groupName;
		        	personList.add(dto);
		        } 
		    } 
		    catch (Exception e) { 
		        e.printStackTrace(); 
		    } 
		}
		
		return personList;
	}
}
