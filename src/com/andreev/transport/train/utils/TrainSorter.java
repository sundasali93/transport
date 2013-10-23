package com.andreev.transport.train.utils;

import java.util.Collections;
import java.util.Comparator;

import com.andreev.transport.carriage.BaseCarriage;
import com.andreev.transport.carriage.BaseFreightCarriage;
import com.andreev.transport.carriage.BaseLocomotive;
import com.andreev.transport.carriage.BasePassengerCarriage;
import com.andreev.transport.train.SimpleTrain;

public class TrainSorter {
	
	public static void sort(SimpleTrain train, Comparator<BaseCarriage> comparator) {
		Collections.sort(train.getTrain(), comparator);
	}
	
	public static Comparator<BaseCarriage> TypeComparator = new Comparator<BaseCarriage>() {
		@Override
		public int compare(BaseCarriage bc1, BaseCarriage bc2) {
			if (bc1 instanceof BasePassengerCarriage) {
				if (bc2 instanceof BasePassengerCarriage) {
					return compareType(
							((BasePassengerCarriage) bc1).getComfortType(),
							((BasePassengerCarriage) bc2).getComfortType());
				} else if (bc2 instanceof BaseFreightCarriage) {
					return 1;
				} else if (bc2 instanceof BaseLocomotive) {
					return -1;
				}
			} else if (bc1 instanceof BaseFreightCarriage){
				if(bc2 instanceof BaseFreightCarriage)
					return 0;
				else
					return 1;
			} else {
				if(bc2 instanceof BaseLocomotive)
					return 0;
				else
					return -1;
			}
			return 0;
		}

		private int compareType(int t1, int t2) {
			return (t1 < t2) ? 1 : (t1 == t2) ? 0 : -1;
		}

	};

}
