package com.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hackathon.dao.AppDAO;
import com.hackathon.dto.IDCardDTO;
import com.hackathon.dto.PersonDTO;
import com.hackathon.dto.UserInputDTO;
import com.hackathon.utils.ApplicationConstants;
import com.hackathon.utils.BarcodeUtils;
import com.hackathon.utils.CardPrintingUtils;

@Service
public class AppService implements ApplicationConstants {
	

	private static final Logger logger = LoggerFactory.getLogger(AppService.class);

	
	@Autowired
    private AppDAO dao;
	
	@Value("${dataLocation:unknown}")
	private String dataLocation;
	
	@Value("${inputData:unknown}")
	private String inputDataFile;

	public void doProcess(UserInputDTO data) {
		logger.info("in doProcess");
		dao.saveInput(data);
		
		
		List<PersonDTO> list = dao.readCSVData(data.getGrouopName());
		
		
		logger.info("Personal Data Size : " + list.size());
		for(PersonDTO obj : list)
		{
			BarcodeUtils.generateBarcode(obj.personUID, obj.barcodePath);
		}
		
		List<IDCardDTO> cardList = new ArrayList<IDCardDTO>();
		
		for(PersonDTO p : list)
		{
			IDCardDTO card = new IDCardDTO();
			
			card.eventName = data.eventName;
			card.logoPath = data.logoPath;
			card.hostName = data.hostName;
			card.eventDuration = data.eventDuration;
			
			card.personPhoto = p.personPhoto;
			card.personFullName = p.personFullName;
			card.personAffilliation = p.personAffilliation;
			card.personPlace = p.personPlace;
			card.personCountry = p.personCountry;
			
			// card.visitingArea =
			// card.endorsement =
			
			if(data.displayInformation.equalsIgnoreCase("Y"))
			{
				card.grouopName = p.groupName;
			}
			else
			{
				card.grouopName = "";
			}
			card.barcodePath = p.barcodePath;
			card.iconPath = data.iconPath;
			
			if(p.groupName.equalsIgnoreCase("Volunteer"))
			{
				card.iconPath = data.iconPath;
			}
			else
			{
				card.iconPath = "";
			}
			
			cardList.add(card);
		}
		
		CardPrintingUtils.printCards(cardList, "template.txt",  "C:\\Temp\\cards.html");
		
	}
}
