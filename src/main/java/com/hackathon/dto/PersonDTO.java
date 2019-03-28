package com.hackathon.dto;

public class PersonDTO {
	public  String personUID;
	public  String personFullName;
	public  String personAffilliation;
	public  String personPlace;
	public  String personPhoto;
	public  String personMobile;
	public  String personCountry;
	public  String barcodePath;
	public  String groupName;
	
	public String getPersonUID() {
		return personUID;
	}
	public void setPersonUID(String personUID) {
		this.personUID = personUID;
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
	public String getPersonPhoto() {
		return personPhoto;
	}
	public void setPersonPhoto(String personPhoto) {
		this.personPhoto = personPhoto;
	}
	public String getPersonMobile() {
		return personMobile;
	}
	public void setPersonMobile(String personMobile) {
		this.personMobile = personMobile;
	}
	public String getPersonCountry() {
		return personCountry;
	}
	public void setPersonCountry(String personCountry) {
		this.personCountry = personCountry;
	}
	public String getBarcodePath() {
		return barcodePath;
	}
	public void setBarcodePath(String barcodePath) {
		this.barcodePath = barcodePath;
	}
	
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	public String toString() {
		return "PersonDTO [personUID=" + personUID + ", personFullName=" + personFullName + ", personAffilliation="
				+ personAffilliation + ", personPlace=" + personPlace + ", personPhoto=" + personPhoto
				+ ", personMobile=" + personMobile + ", personCountry=" + personCountry + ", barcodePath=" + barcodePath
				+ "]";
	}
	
}
