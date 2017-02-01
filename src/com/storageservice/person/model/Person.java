package com.storageservice.person.model;


import org.joda.time.LocalDate;
import org.joda.time.Years;



public class Person  {


	private int idPerson;

	
	private String lastname;

	
	private String firstname;

	
	private String birthdate;
	private String password;
	
	private String email;
	
	private String genre;
	
	private String lifeStyle;
	private double weight;
	
	private double height;
	
	// references
	
	private int nTotalGoal;
	private String level;
	private int idLevel;
	private int idLifeStyle;
	private int nGoalAchieved;
	private String description;

	public Person() {
	}

	// getter annd setter methods

	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	public int getIdLevel() {
		return this.idLevel;
	}

	public void setIdLevel(int idLevel) {
		this.idLevel= idLevel;
	}
	public int getIdLifeStyle() {
		return this.idLifeStyle;
	}

	public void setIdLifeStyle(int idLifeStyle) {
		this.idLifeStyle= idLifeStyle;
	}
	public String getfirstname() {
		return this.firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;

	}
	public String getLifeStyle() {
		return this.lifeStyle;
	}

	public void setLifeStyle(String lifeStyle) {
		this.lifeStyle = lifeStyle;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getNGoalAchieved() {
		return this.nGoalAchieved;
	}

	public void setNGoalAchieved(int nGoalAchieved) {
		this.nGoalAchieved = nGoalAchieved;
	}

	public int getNTotalGoal() {
		return this.nTotalGoal;
	}

	public void setNTotalGoal(int nTotalGoal) {
		this.nTotalGoal = nTotalGoal;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level= level;
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description= description;
	}
	
	public int ageCalculator(String birthdate){
		String[] parts = birthdate.split("-");
		int year = Integer.parseInt(parts[2]);
		int month = Integer.parseInt(parts[1]);
		int day=Integer.parseInt(parts[0]);
		System.out.println("anno"+year);
		System.out.println("mese"+month);
		System.out.println("day"+day);
		LocalDate dbirthdate = new LocalDate (year, month, day);
		LocalDate now = new LocalDate();
		String age = Years.yearsBetween(dbirthdate, now).toString();
		String sub= age.substring(1, age.length()-1);
		System.out.println(sub);
		return Integer.parseInt(sub.toString());
	}

	

}
