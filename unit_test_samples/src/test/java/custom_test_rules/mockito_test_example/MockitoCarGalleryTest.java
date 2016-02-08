package custom_test_rules.mockito_test_example;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


public class MockitoCarGalleryTest {


    private static CarGallery carGallery;
    private static Car car1, car2, car3;


    @Rule
    public Timeout timeout = new Timeout(1000);

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @BeforeClass
    public static void setUp() throws Exception {
        carGallery = mock(CarGallery.class);
        car1 = new Car("sahin", 2000);
        car2 = new Car("dogan", 2002);
        car3 = new Car("kartal", 2005);

        when(carGallery.getCars()).thenReturn(Arrays.asList(car1, car2, car3));
        when(carGallery.getOldestCar()).thenReturn(car1);
        when(carGallery.addCarToGallery(car1)).thenReturn(car1.model + " is added to gallery");
        when(carGallery.addCarToGallery(car2)).thenReturn("tamamdır");
        when(carGallery.getOldestCar()).thenReturn(car1);
    }

    @Test
    public void testGetAllCars() throws Exception {
        List<Car> cars = carGallery.getCars();
        assertNotNull(cars.get(0));
        assertEquals(3, cars.size());
    }


    @Test
    public void testGetCar() throws Exception {
        Car c = carGallery.getCars().get(0);
        Car c2 = carGallery.getCars().get(1);
        assertEquals(carGallery.addCarToGallery(c), c.model + " is added to gallery");
        assertEquals(carGallery.addCarToGallery(c2), "tamamdır");

    }


    @Test(expected = IOException.class)
    public void testForIOException() throws IOException {

        // create an configure mock
        OutputStream mockStream = mock(OutputStream.class);
        doThrow(new IOException()).when(mockStream).close();


        // use mock
        OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream); //while closing the stream it should throw IO Exception
        streamWriter.close();
        verify(mockStream).close();


    }


}
