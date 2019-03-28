package com.hackathon.provider;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.dto.UserInputDTO;
import com.hackathon.service.AppService;
import com.hackathon.utils.ApplicationConstants;

@Service
public class AppProvider implements ApplicationConstants {

	@Autowired
	private AppService service;
	
	private static final Logger logger = LoggerFactory.getLogger(AppProvider.class);
	
	private static final String[] groups = new String[] { "Coordinator", "Organizer", "Participant", "Volunteer",
			"All" };

	public void doProcess() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Name of Event: ");
		String eventName = scanner.next();
		System.out.println(DASHLINE);
		System.out.println(
				"Select the group (Enter Number): \n 1. Coordinator\n 2. Organizer\n 3. Participants\n 4. Volunteer\n 5. All");
		int grouopName = scanner.nextInt();
		System.out.println(DASHLINE);
		System.out.println("Do you want to disaply all information? (Y/N): ");
		String displayInformation = scanner.next();
		System.out.println(DASHLINE);
		System.out.println("Path of logo of host institute: ");
		String logoPath = scanner.next();
		System.out.println(DASHLINE);
		System.out.println("Name of host institute: ");
		String hostName = scanner.next();
		System.out.println(DASHLINE);
		System.out.println("Event Duration in hours: ");
		String eventDuration = scanner.next();
		eventDuration = eventDuration + " Hours";
		System.out.println(DASHLINE);
		System.out.println("Path of icon of volunteer: ");
		String iconPath = scanner.next();
		System.out.println(DASHLINE);
		System.out.println("Thank You Thanks all we need: ");

		UserInputDTO data = new UserInputDTO();
		data.setEventName(eventName);
		data.setGrouopName(groups[grouopName - 1]);
		data.setDisplayInformation(displayInformation.toUpperCase());
		data.setLogoPath(logoPath);
		data.setHostName(hostName);
		data.setEventDuration(eventDuration);
		data.setIconPath(iconPath);
		scanner.close();
		
		service.doProcess(data);
	}

}
