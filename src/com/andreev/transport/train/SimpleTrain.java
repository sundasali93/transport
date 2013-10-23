package com.andreev.transport.train;

import java.util.ArrayList;
import java.util.List;

import com.andreev.exception.OutOfRangeException;
import com.andreev.transport.carriage.AbstractCarriage;

public class SimpleTrain {
	
	private int id;
	private int number;
	private List<AbstractCarriage> trainList = new ArrayList<>();
	
	public SimpleTrain(int id, int number) throws OutOfRangeException {
		setId(id);
		setNumber(number);
	}
	
	public List<AbstractCarriage> getTrainList() {
		return trainList;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) throws OutOfRangeException {
		if(id > 0)
			this.id = id;
		else
			throw new OutOfRangeException("Id is under zero");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) throws OutOfRangeException {
		if(number > 0)
			this.number = number;
		else
			throw new OutOfRangeException("Id is under zero");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SimpleTrain [ID = " + getId() + 
					", Number = " + getNumber() + "]: {\n");
		for(AbstractCarriage ac : getTrainList()){
			sb.append("  " + ac + "\n");
		}
		sb.append("}\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + number;
		result = prime * result
				+ ((trainList == null) ? 0 : trainList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SimpleTrain))
			return false;
		SimpleTrain other = (SimpleTrain) obj;
		if (id != other.id)
			return false;
		if (number != other.number)
			return false;
		if (trainList == null) {
			if (other.trainList != null)
				return false;
		} else if (!trainList.equals(other.trainList))
			return false;
		return true;
	}
	
}
