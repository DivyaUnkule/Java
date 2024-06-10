package com.app.storingapp;

public class Order {
	private int orderId;
	private int petId;
	private int quantity;
	private Status status;
	private static int idGenerator;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, int petId, int quantity, Status status) {
		super();
		this.orderId = orderId;
		this.petId = petId;
		this.quantity = quantity;
		this.status = status;
		idGenerator=Math.max(idGenerator, orderId);
	}
	
	public Order(int petId, int quantity) {
		super();
		this.orderId = idGenerator++;
		this.petId = petId;
		this.quantity = quantity;
		this.status = Status.valueOf("PLACED");
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Order)
		{
			Order p=(Order)obj;
			return this.orderId==p.orderId;
		}
		return false;
	}

}
