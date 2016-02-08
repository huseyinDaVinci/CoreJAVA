import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class RuleTest {

    MyClass test;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Rule
    public Timeout timeout=new Timeout(1000);  //in ms..

    @Rule
    public TemporaryFolder temporaryFolder=new TemporaryFolder();


    @Before
    public void initialize() {
        test = new MyClass();
    }

    @Test
    public void shouldThrowIllegalExceptionIfNegative() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Could not be negative number");
        test.getNumber(-8); //pass test because we are sending negative number and excepting illegalArgumentexception with this message

        //test.getNumber(8);    //fail test
    }

    @Test
    public void shouldBeTested(){
        assertEquals(test.testLoop(),5);

    }

    @Test
    public void testIcon() throws Exception {

        File file=temporaryFolder.newFile("icon.png");

        //test your file here....



    }









    private class MyClass {
        public void getNumber(int num) {
            if (num < 0) {
                throw new IllegalArgumentException("Could not be negative number");
            }
        }

        public int  testLoop(){

            for(int i=1000;i-->0;){
                ;
            }
            return 5;
        }
    }
}
