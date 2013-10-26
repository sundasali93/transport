package com.andreev.transport.train.utils;

import java.util.Collections;
import java.util.Comparator;

import com.andreev.transport.carriage.AbstractCarriage;
import com.andreev.transport.carriage.AbstractFreightCarriage;
import com.andreev.transport.carriage.AbstractLocomotive;
import com.andreev.transport.carriage.AbstractPassengerCarriage;
import com.andreev.transport.train.SimpleTrain;

public class SimpleTrainSorter {

	public static void sort(SimpleTrain train,
			Comparator<AbstractCarriage> comparator) {
		Collections.sort(train, comparator);
	}

	public static Comparator<AbstractCarriage> TypeComparator = new Comparator<AbstractCarriage>() {
		@Override
		public int compare(AbstractCarriage ac1, AbstractCarriage ac2) {
			if (ac1 instanceof AbstractPassengerCarriage) {
				if (ac2 instanceof AbstractPassengerCarriage) {
					return compareType(
							((AbstractPassengerCarriage) ac1).getComfortType().getId(),
							((AbstractPassengerCarriage) ac2).getComfortType().getId());
				} else if (ac2 instanceof AbstractFreightCarriage) {
					return 1;
				} else if (ac2 instanceof AbstractLocomotive) {
					return -1;
				}
			} else if (ac1 instanceof AbstractFreightCarriage) {
				if (ac2 instanceof AbstractFreightCarriage)
					return 0;
				else
					return 1;
			} else {
				if (ac2 instanceof AbstractLocomotive)
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
