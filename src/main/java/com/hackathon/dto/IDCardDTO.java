package com.hackathon.dto;

public class IDCardDTO {
	public String eventName;
	public String logoPath;
	public String hostName;
	public String eventDuration;
	
	public String personPhoto;
	public String personFullName;
	public String personAffilliation;
	public String personPlace;
	public String personCountry;
	
	public String visitingArea;
	public String endorsement;
	
	public String grouopName;
	public String barcodePath;
	
	public String iconPath;

	public IDCardDTO() {
		super();
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
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

	public String getPersonPhoto() {
		return personPhoto;
	}

	public void setPersonPhoto(String personPhoto) {
		this.personPhoto = personPhoto;
	}

	public String getPersonFullName() {
		return personFullName;
	}

	public void setPersonFullName(String personFullName) {
		this.personFullName = personFullName;
	}

	public String getPersonAffilliation() {
		return personAffilliation;
	}

	public void setPersonAffilliation(String personAffilliation) {
		this.personAffilliation = personAffilliation;
	}

	public String getPersonPlace() {
		return personPlace;
	}

	public void setPersonPlace(String personPlace) {
		this.personPlace = personPlace;
	}

	public String getPersonCountry() {
		return personCountry;
	}

	public void setPersonCountry(String personCountry) {
		this.personCountry = personCountry;
	}

	public String getVisitingArea() {
		return visitingArea;
	}

	public void setVisitingArea(String visitingArea) {
		this.visitingArea = visitingArea;
	}

	public String getEndorsement() {
		return endorsement;
	}

	public void setEndorsement(String endorsement) {
		this.endorsement = endorsement;
	}

	public String getGrouopName() {
		return grouopName;
	}

	public void setGrouopName(String grouopName) {
		this.grouopName = grouopName;
	}

	public String getBarcodePath() {
		return barcodePath;
	}

	public void setBarcodePath(String barcodePath) {
		this.barcodePath = barcodePath;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	@Override
	public String toString() {
		return "IDCardDTO [eventName=" + eventName + ", logoPath=" + logoPath + ", hostName=" + hostName
				+ ", eventDuration=" + eventDuration + ", personPhoto=" + personPhoto + ", personFullName="
				+ personFullName + ", personAffilliation=" + personAffilliation + ", personPlace=" + personPlace
				+ ", personCountry=" + personCountry + ", visitingArea=" + visitingArea + ", endorsement=" + endorsement
				+ ", grouopName=" + grouopName + ", barcodePath=" + barcodePath + ", iconPath=" + iconPath + "]";
	}
	
}
