package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table(name = "countries")
public class Country implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy = "country")
	@OrderBy("name")
	private Set<Customer> customers;

	//CONTRUCTORS
	public Country() {}

	
	//GETTERS
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Customer> getCustomers() {
		return Collections.unmodifiableSet(customers);
	}
	
	
}
