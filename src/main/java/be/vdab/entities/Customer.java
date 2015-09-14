package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@NamedEntityGraph(name ="Customer.withCountry", attributeNodes = @NamedAttributeNode("country"))
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	private String name;
	private String streetAndNumber;
	private String city;
	private String state;
	private String postalCode;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "countryId")
	private Country country;

	@OneToMany(mappedBy = "customer")
	private Set<Order> orders;
	
	
	
	// CONSTRUCTORS
	public Customer() {
	}

	
	// GETTERS
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStreetAndNumber() {
		return streetAndNumber;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public Country getCountry() {
		return country;
	}
	
	public Set<Order> getOrders() {
		return Collections.unmodifiableSet(orders);
	}


	// OVERRIDES
	@Override
	public int hashCode() {

		return (getName() + getStreetAndNumber() + getPostalCode() + country.getName()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Customer)) {
			return false;
		}

		Customer customer = (Customer) obj;

		return (this.name.equals(customer.getName())) && (this.streetAndNumber.equals(customer.getStreetAndNumber()))
				&& (this.postalCode.equals(customer.getPostalCode())) && (this.country.equals(customer.getCountry()));
	}

}
