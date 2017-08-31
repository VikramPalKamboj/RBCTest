package curd.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="item")
public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	
	@Id
	private int id;
	
	private String name;
	private String city;
	@ManyToOne
	private Section section;
	
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date dateCreated;
		
	public Item(){}

	public Item(int id, String name, String city, Date dateCreated) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.dateCreated = dateCreated;
	}


	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", city=" + city
				+ ", dateCreated=" + dateCreated + "]";
	}	

}
