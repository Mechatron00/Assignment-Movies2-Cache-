package com.ProjectAssignment.Movies2;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
//for second level cache we add @cache and @cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class MoviesCache 
{ @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int srno;
	String name;
	int age;
	String email;
	String favouriteMovie;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFavouriteMovie() {
		return favouriteMovie;
	}
	public void setFavouriteMovie(String favouriteMovie) {
		this.favouriteMovie = favouriteMovie;
	}
	@Override
	public String toString() {
		return "MoviesCache [srno=" + srno + ", name=" + name + ", age=" + age + ", email=" + email
				+ ", favouriteMovie=" + favouriteMovie + "]";
	}
	
	
}
