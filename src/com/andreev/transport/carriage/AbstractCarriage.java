package com.andreev.transport.carriage;

import java.util.Date;

import com.andreev.exception.OutOfRangeException;

public abstract class AbstractCarriage {

	private int id;
	private int carriageWeight;
	private String carriageNumber;
	private Date productionDate;

	public int getId() {
		return id;
	}

	public void setId(int id) throws OutOfRangeException {
		if (id >= 0)
			this.id = id;
		else
			throw new OutOfRangeException("Id is under zero");
	}

	public int getCarriageWeight() {
		return carriageWeight;
	}

	public void setCarriageWeight(int carriageWeight) throws OutOfRangeException {
		if (carriageWeight > 0)
			this.carriageWeight = carriageWeight;
		else
			throw new OutOfRangeException("Carriage weight is under zero");
	}

	public String getCarriageNumber() {
		return carriageNumber;
	}

	public void setCarriageNumber(String carriageNumber) {
		if (carriageNumber != null) {
			this.carriageNumber = carriageNumber;
		} else
			throw new IllegalArgumentException("Carriage number is null");
	}

	public Date getProductionDate() {
		return productionDate;
	}

	protected void setProductionDate(Date productionDate) {
		if (productionDate != null) {
			this.productionDate = productionDate;
		} else
			throw new IllegalArgumentException("Product date is null");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((carriageNumber == null) ? 0 : carriageNumber.hashCode());
		result = prime * result + carriageWeight;
		result = prime * result + id;
		result = prime * result
				+ ((productionDate == null) ? 0 : productionDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractCarriage))
			return false;
		AbstractCarriage other = (AbstractCarriage) obj;
		if (carriageNumber == null) {
			if (other.carriageNumber != null)
				return false;
		} else if (!carriageNumber.equals(other.carriageNumber))
			return false;
		if (carriageWeight != other.carriageWeight)
			return false;
		if (id != other.id)
			return false;
		if (productionDate == null) {
			if (other.productionDate != null)
				return false;
		} else if (!productionDate.equals(other.productionDate))
			return false;
		return true;
	}

}