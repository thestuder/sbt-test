package com.studer.test;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.not;

/**
 * Unit test for simple App.
 */
//@RunWith(Parameterized.class)
public class AppTest
//    extends TestCase
    extends Assert
{
 public Operation operation;

    public AppTest(Operation operation) {
        this.operation = operation;
    }

//    @Parameterized.Parameters
    public static Collection<Operation> getTestData(){
        Arithmetic load = new Arithmetic("test-cases.txt");
        return load.getOperations();
    }

    /**
     * Rigourous Test :-)
     */
//    @org.junit.Test
    public void testApp() {
        boolean b = operation.checkOperation();
        assertTrue( ""+operation.getOperator1()+" " +operation.getOperation() + " "+ operation.getOperator2() + " = "+operation.getResult(),b );
//        assertTrue("Result not equals to 4", 2 * 2 != 4);
//        assertThat("hren", 2 * 2, not(4));
    }

    public void testApp1()
    {
//        @org.junit.
        assertTrue( true );
//        assertTrue("Result not equals to 4", 2 * 2 != 4);
    }

    /**
     * Rigourous Test :-)
     */
    public void firstSimpleTest() {
        assertTrue("Result not equals to 4", 2 * 2 != 4);
    }
}
