package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void addItem(OrderItem item) {
		orderItem.add(item);
	}

	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}
	public Double Total() {
		Double soma = 0.0;
		for(OrderItem c: orderItem) {
		soma += c.subTotal();
		}
		return soma;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: "+sdf.format(moment) + "\n");
		sb.append("Order Status: " +status + "\n");
		sb.append("Client: "+client.getName()+" "+sdf.format(client.getBirthDate())+" "+client.getEmail()+"\n");
		sb.append("Order items:\n");
		return sb.toString();
	}
	
}
