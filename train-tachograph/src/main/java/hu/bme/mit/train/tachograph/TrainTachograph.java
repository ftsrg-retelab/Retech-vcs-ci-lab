package hu.bme.mit.train.tachograph;

import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

public class TrainTachograph {

	private Table<Integer, Float, Double> tacho = HashBasedTable.create();

	public int getLength()
	{
		return tacho.size();
	}


}
