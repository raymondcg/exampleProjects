package org.sample.model;

public class Customer {

	private int id;
	private boolean reinstated = false;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isReinstated() {
		return reinstated;
	}
	public void setReinstated(boolean reinstated) {
		this.reinstated = reinstated;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", reinstated=" + reinstated + "]";
	}

}
