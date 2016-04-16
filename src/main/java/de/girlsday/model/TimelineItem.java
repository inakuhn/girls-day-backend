package de.girlsday.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.mysql.fabric.xmlrpc.base.Data;


@Entity
public class TimelineItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	public Long getId() {
		return id;
	}
	String message;
	
	String pictureUID;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: ["+id+"]"+ " Name: ["+message+"]";
	}
	


}