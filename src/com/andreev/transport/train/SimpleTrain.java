package com.andreev.transport.train;

import java.util.LinkedList;
import java.util.List;

import com.andreev.transport.carriage.BaseCarriage;

public class SimpleTrain {

	private List<BaseCarriage> train = new LinkedList<>();
	
	public List<BaseCarriage> getTrain() {
		return train;
	}

}
