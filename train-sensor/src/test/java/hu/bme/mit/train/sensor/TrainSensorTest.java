package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController mockTC;
    TrainUser mockTU;
    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTC,mockTU);
    }

    @Test
    public void AbsoluteMarginMaximum(){
        trainSensor.overrideSpeedLimit(1000);
        verify(mockTU, times(1)).setAlarmState(true);
    }
    @Test
    public void AbsoluteMarginMinimum(){
        trainSensor.overrideSpeedLimit(-15);
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void AbsoluteMarginBetween(){
        trainSensor.overrideSpeedLimit(60);
        verify(mockTU, times(0)).setAlarmState(true);
    }

    @Test
    public void RelativeMargin(){
        trainSensor.overrideSpeedLimit(1);
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitCheck(){
        assertEquals(5, trainSensor.getSpeedLimit());
    }
}
