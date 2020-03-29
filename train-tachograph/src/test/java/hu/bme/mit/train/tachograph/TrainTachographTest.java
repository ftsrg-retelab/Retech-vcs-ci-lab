package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.tachograph.TrainTachograph;

public class TrainTachographTest {

	@Test
	public void test() {
		TrainTachograph tt = new TrainTachograph();
		Assert.assertEquals(0, tt.getLength());
	}

	
}
