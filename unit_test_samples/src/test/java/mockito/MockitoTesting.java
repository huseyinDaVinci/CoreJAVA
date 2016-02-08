package mockito;


import org.junit.Test;
import org.mockito.Mockito;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class MyClass{

    public int  getUniqueId(){
        return 0;
    }



}

public class MockitoTesting {

    @Test
    public void test1()  {
        //  create mock
        MyClass test = Mockito.mock(MyClass.class);

        // define return value for method getUniqueId()
        when(test.getUniqueId()).thenReturn(43);

        // use mock in test....
        assertEquals(test.getUniqueId(), 43);
    }



    // Demonstrates the return of multiple values
    @Test
    public void testMoreThanOneReturnValue()  {
        Iterator i= mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result=i.next()+" "+i.next();
        //assert
        assertEquals("Mockito rocks", result);
    }

    // this test demonstrates how to return values based on the input
    @Test
    public void testReturnValueDependentOnMethodParameter()  {
        Comparable c= mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(1,c.compareTo("Mockito"));
    }

}
