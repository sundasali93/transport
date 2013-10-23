package com.andreev.transport.train;

import java.util.LinkedList;
import java.util.List;

import com.andreev.exeption.OutOfRangeExeption;
import com.andreev.transport.carriage.BaseCarriage;

public class SimpleTrain {
	
	private int id;
	private int number;
	private List<BaseCarriage> trainList = new LinkedList<>();
	
	public SimpleTrain(int id, int number) throws OutOfRangeExeption {
		setId(id);
		setNumber(number);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SimpleTrain [ID = " + getId() + 
					", Number = " + getNumber() + "]: {\n");
		for(BaseCarriage bc : getTrainList()){
			sb.append("  " + bc + "\n");
		}
		sb.append("}\n");
		return sb.toString();
	}
	
	public List<BaseCarriage> getTrainList() {
		return trainList;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) throws OutOfRangeExeption {
		if(id > 0)
			this.id = id;
		else
			throw new OutOfRangeExeption("Id is under zero");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) throws OutOfRangeExeption {
		if(number > 0)
			this.number = number;
		else
			throw new OutOfRangeExeption("Id is under zero");
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
