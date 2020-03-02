package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainControllerTest {
    public int bela;
    @Before
    public void before() {
        bela = 5;
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        assert (bela == 5);
    }
}
