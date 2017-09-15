/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedbag;

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
public class LinkedBagTest {
    
    public LinkedBagTest() {
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
        LinkedBag<Integer> instance = new LinkedBag<Integer>();
        int expResult = 0;
        int result = instance.getCurrentSize();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        System.out.println("isEmpty");
        LinkedBag<Integer> instance = new LinkedBag<Integer>();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmptyWhenNotEmpty() {
        System.out.println("isEmpty");
        LinkedBag<Integer> instance = new LinkedBag<Integer>();
        instance.add(new Integer(42));
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddWhenNotFull() {
        System.out.println("add");
        Object item = null;
        LinkedBag<Integer> instance = new LinkedBag<Integer>();
        
        boolean expResult = true;
        boolean result = instance.add(new Integer(42));
        assertEquals(expResult, result); 
    }

    @Test
    public void testRemove_0args_whenNotEmpty() {
        System.out.println("remove");
        LinkedBag<Integer> instance = new LinkedBag<Integer>();
        instance.add(new Integer(42));
        Integer expResult = new Integer(42);
        Integer result = instance.remove();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemove_0args_whenEmpty() {
        System.out.println("remove");
        LinkedBag<Integer> instance = new LinkedBag<Integer>();
        Integer expResult = null;
        Integer result = instance.remove();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemove_GenericType_WhenNotInBag() {
        System.out.println("remove");
        Integer item = new Integer(42);
        LinkedBag<Integer> instance = new LinkedBag<Integer>();
        boolean expResult = false;
        boolean result = instance.remove(item);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemove_GenericType_WhenInBag() {
        System.out.println("remove");
        Integer item = new Integer(42);
        LinkedBag<Integer> instance = new LinkedBag<Integer>();
        instance.add(item);
        boolean expResult = true;
        boolean result = instance.remove(item);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFrequencyOf_notPresent() {
        System.out.println("getFrequencyOf");
        String item = "something";
        LinkedBag<String> instance = new LinkedBag<String>();
        int expResult = 0;
        
        int result = instance.getFrequencyOf(item);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetFrequencyOf_isPresent() {
        System.out.println("getFrequencyOf");
        String item = "something";
        LinkedBag<String> instance = new LinkedBag<String>();
        instance.add(item);
        instance.add(item);
        int expResult = 2;
        
        int result = instance.getFrequencyOf(item);
        
        assertEquals(expResult, result);
    }

    @Test
    public void testContains_doesNotContain() {
        System.out.println("contains");
        String item = "contains";
        boolean expResult = false;
        
        LinkedBag<String> instance = new LinkedBag<String>();
        boolean result = instance.contains(item);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testContains_doesContain() {
        System.out.println("contains");
        String item = "contains";
        boolean expResult = true;
        
        LinkedBag<String> instance = new LinkedBag<String>();
        instance.add(item);
        boolean result = instance.contains(item);
        
        assertEquals(expResult, result);
    }
   
}
