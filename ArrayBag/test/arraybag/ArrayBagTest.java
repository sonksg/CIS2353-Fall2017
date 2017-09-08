/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraybag;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author etcharn1
 */
public class ArrayBagTest {
    
    public ArrayBagTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetCurrentSize() {
        System.out.println("getCurrentSize");
        ArrayBag<Integer> instance = new ArrayBag<Integer>();
        int expResult = 0;
        int result = instance.getCurrentSize();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        System.out.println("isEmpty");
        ArrayBag<Integer> instance = new ArrayBag<Integer>();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmptyWhenNotEmpty() {
        System.out.println("isEmpty");
        ArrayBag<Integer> instance = new ArrayBag<Integer>();
        instance.add(new Integer(42));
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddWhenNotFull() {
        System.out.println("add");
        Object item = null;
        ArrayBag<Integer> instance = new ArrayBag<Integer>();
        
        boolean expResult = true;
        boolean result = instance.add(new Integer(42));
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testAddWhenFull() {
        System.out.println("add");
        Object item = null;
        ArrayBag<Integer> instance = new ArrayBag<Integer>(1);
        
        boolean result = instance.add(new Integer(42));
        assertEquals(true, result); 
        
        result = instance.add(new Integer(42));
        assertEquals(false, result); 
    }

    @Test
    public void testRemove_0args_whenNotEmpty() {
        System.out.println("remove");
        ArrayBag<Integer> instance = new ArrayBag<Integer>(1);
        instance.add(new Integer(42));
        Integer expResult = new Integer(42);
        Integer result = instance.remove();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemove_0args_whenEmpty() {
        System.out.println("remove");
        ArrayBag<Integer> instance = new ArrayBag<Integer>(1);
        Integer expResult = null;
        Integer result = instance.remove();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemove_GenericType_WhenNotInBag() {
        System.out.println("remove");
        Integer item = new Integer(42);
        ArrayBag<Integer> instance = new ArrayBag<Integer>(1);
        boolean expResult = false;
        boolean result = instance.remove(item);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemove_GenericType_WhenInBag() {
        System.out.println("remove");
        Integer item = new Integer(42);
        ArrayBag<Integer> instance = new ArrayBag<Integer>(1);
        instance.add(item);
        boolean expResult = true;
        boolean result = instance.remove(item);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFrequencyOf() {
        System.out.println("getFrequencyOf");
        Object item = null;
        ArrayBag instance = new ArrayBag();
        int expResult = 0;
        int result = instance.getFrequencyOf(item);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testContains() {
        System.out.println("contains");
        Object item = null;
        ArrayBag instance = new ArrayBag();
        boolean expResult = false;
        boolean result = instance.contains(item);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToArray() {
        System.out.println("toArray");
        ArrayBag instance = new ArrayBag();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
