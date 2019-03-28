package com.hackathon.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInputDTO {
	public String eventName;
	public String grouopName;
	public String displayInformation;
	public String logoPath;
	public String hostName;
	public String eventDuration;
	public String iconPath;

	public UserInputDTO() {
		super();
	}

	public UserInputDTO(String eventName, String grouopName, String displayInformation, String logoPath, String hostName,
			String eventDuration, String iconPath) {
		super();
		this.eventName = eventName;
		this.grouopName = grouopName;
		this.displayInformation = displayInformation;
		this.logoPath = logoPath;
		this.hostName = hostName;
		this.eventDuration = eventDuration;
		this.iconPath = iconPath;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getGrouopName() {
		return grouopName;
	}

	public void setGrouopName(String grouopName) {
		this.grouopName = grouopName;
	}

	public String isDisplayInformation() {
		return displayInformation;
	}

	public void setDisplayInformation(String displayInformation) {
		this.displayInformation = displayInformation;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(String eventDuration) {
		this.eventDuration = eventDuration;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	@Override
	public String toString() {
		return "UserInput [eventName=" + eventName + ", grouopName=" + grouopName + ", displayInformation="
				+ displayInformation + ", logoPath=" + logoPath + ", hostName=" + hostName + ", eventDuration="
				+ eventDuration + ", iconPath=" + iconPath + "]";
	}

	public String toCsvData() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		return "\n"+sdf.format(new Date()) + "," + eventName + "," + grouopName + "," + displayInformation + "," + logoPath
				+ "," + hostName + "," + eventDuration + "," + iconPath;
	}

}
