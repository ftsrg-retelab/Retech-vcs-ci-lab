package hu.bme.mit.train.sensor;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import hu.bme.mit.train.interfaces.*;

import org.junit.Assert;

import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class TrainSensorTest {
    
    private final int firstSpeed;
    private final boolean alarmAfterFirst;
    private final int sercondSpeed;
    private final boolean alarmAfterSecond;
    private final TrainController trainController; 
    private final TrainUser trainUser; 

    public TrainSensorTest(
        int firstSpeed,
        boolean alarmAfterFirst,
        int sercondSpeed,
        boolean alarmAfterSecond) {
            this.firstSpeed = firstSpeed;
            this.alarmAfterFirst = alarmAfterFirst;
            this.sercondSpeed = sercondSpeed;
            this.alarmAfterSecond = alarmAfterSecond;
            this.trainController = mock(TrainController.class);
            this.trainUser = mock(TrainUser.class);

    }

    
    @Parameters()
    public static Iterable<Object[]> data() {
        return Arrays.asList(
            new Object[]{  -1, true,   -1, true  },
            new Object[]{ 501, true,  501, true  },
            new Object[]{ 150, false,  50, true  },
            new Object[]{ 150, false,  75, false }
        );
    }

    @Test
    public void test() {
        TrainSensor trainSensor = new TrainSensorImpl(trainController, trainUser);

        trainSensor.overrideSpeedLimit(firstSpeed);
        Assert.assertEquals(firstSpeed, trainSensor.getSpeedLimit());
        if(alarmAfterFirst) verify(trainUser).setAlarmState(true);
        else {
            trainSensor.overrideSpeedLimit(sercondSpeed);
            Assert.assertEquals(sercondSpeed, trainSensor.getSpeedLimit());
            if(alarmAfterSecond) verify(trainUser).setAlarmState(true);
        }
    }
}