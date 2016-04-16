package de.girlsday.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.mysql.fabric.xmlrpc.base.Data;


@Entity
public class TimelineItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	public Long getId() {
		return id;
	}
	@Column(unique = true)
	String message;
	
	String pictureUID;
	@OneToOne
	User user;
	
	public TimelineItem(){
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPictureUID() {
		return pictureUID;
	}

	public void setPictureUID(String pictureUID) {
		this.pictureUID = pictureUID;
	}

	public String getName() {
		return message;
	}

	public void setName(String name) {
		this.message = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: ["+id+"]"+ " Name: ["+message+"]";
	}
	


}