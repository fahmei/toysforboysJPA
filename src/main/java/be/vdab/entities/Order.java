package be.vdab.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.vdab.enums.Status;
import be.vdab.valueobjects.OrderDetails;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Temporal(TemporalType.DATE) //TODO veranderen naar DateTime voor de equals en hashcodes
	Date orderDate;
	
	@Temporal(TemporalType.DATE)
	Date requiredDate;
	
	@Temporal(TemporalType.DATE)
	Date shippedDate;
	
	private String comments;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	@ElementCollection
	@CollectionTable(name = "orderdetails", joinColumns = @JoinColumn(name = "orderId"))
	private Set<OrderDetails> orderDetails;
	
	//CONSTRUCTORS
	public Order() {}

	//GETTERS
	public long getId() {
		return id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public String getComments() {
		return comments;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Status getStatus() {
		return status;
	}

	
	//OVERRIDES
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Order)){
			return false;
		}
		
		Order order = (Order) obj;
			
		return (this.customer.equals(order.getCustomer()))
				&& (this.orderDate.equals(order.getOrderDate()));
	}

	
	
	
	
}
