package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class OrderDetails implements Serializable{
	private static final long serialVersionUID = 1L;

	private long orderId;
	private long productId;
	private long quantityOrdered;
	private BigDecimal priceEach;
	
	
	public long getOrderId() {
		return orderId;
	}
	public long getProductId() {
		return productId;
	}
	public long getQuantityOrdered() {
		return quantityOrdered;
	}
	public BigDecimal getPriceEach() {
		return priceEach;
	}
	
	
}
