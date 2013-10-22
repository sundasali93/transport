package com.andreev.transport.carriage;

import java.util.Date;

public abstract class BaseCarriage {

	private int id;
	private int carriageWeight;
	private String carriageNumber;
	private Date productionDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0)
			this.id = id;
		else
			throw new IllegalArgumentException("Id is under zero");
	}

	public int getCarriageWeight() {
		return carriageWeight;
	}

	public void setCarriageWeight(int carriageWeight) {
		if (carriageWeight > 0)
			this.carriageWeight = carriageWeight;
		else
			throw new IllegalArgumentException("Carriage weight is under zero");
	}

	public String getCarriageNumber() {
		return carriageNumber;
	}

	public void setCarriageNumber(String carriageNumber) {
		if (carriageNumber != null) {
			this.carriageNumber = carriageNumber;
		} else
			throw new NullPointerException("Carriage number is null");
	}

	public Date getProductionDate() {
		return productionDate;
	}

	protected void setProductionDate(Date productionDate) {
		if (productionDate != null) {
			this.productionDate = productionDate;
		} else
			throw new NullPointerException("Product date is null");
	}

}
