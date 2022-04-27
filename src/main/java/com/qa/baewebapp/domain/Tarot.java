package com.qa.baewebapp.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarot {
	
	// Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long id;
	
	// Set column names
	@Column(name = "Card No")
	private int number;
	@Column(name = "Card", nullable = false) 	// This column cannot be null
	private String card;
	@Column(name = "UprightMeaning")
	private String upright;
	@Column(name = "ReversedMeaning")
	private String reversed;
	@Column(name = "ZodiacSign")
	private String zodiac;
	
	
	// Default Constructor
	public Tarot() {}
	
	// Constructor with values set - used for creating/inserting
	public Tarot(int number, String card, String upright, String reversed, String zodiac) {
		super();
		this.number = number;
		this.card = card;
		this.upright = upright;
		this.reversed = reversed;
		this.zodiac = zodiac;
	}
	
	// Used for reading/selecting (and testing)
	public Tarot(long id, int number, String card, String upright, String reversed, String zodiac) {
		super();
		this.id = id;
		this.number = number;
		this.card = card;
		this.upright = upright;
		this.reversed = reversed;
		this.zodiac = zodiac;
	}
	
	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getUpright() {
		return upright;
	}
	public void setUpright(String upright) {
		this.upright = upright;
	}
	public String getReversed() {
		return reversed;
	}
	public void setReversed(String reversed) {
		this.reversed = reversed;
	}
	public String getZodiac() {
		return zodiac;
	}
	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}


	@Override
	public String toString() {
		return "Tarot [id=" + id + ", number=" + number + ", card=" + card + ", upright=" + upright + ", reversed="
				+ reversed + ", zodiac=" + zodiac + "]";
	}

	// 
	@Override
	public int hashCode() {
		return Objects.hash(card, id, number, reversed, upright, zodiac);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarot other = (Tarot) obj;
		return Objects.equals(card, other.card) && id == other.id && number == other.number
				&& Objects.equals(reversed, other.reversed) && Objects.equals(upright, other.upright)
				&& Objects.equals(zodiac, other.zodiac);
	}
	
	
}
