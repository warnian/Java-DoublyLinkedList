/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// basic setup provided by class
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//this test was given in class
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		//assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.remove(42);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		try {
			list1.add(null);
			fail("null pointer check");
		}
		catch(NullPointerException e) {
		}
		list1.add(8);
		
		assertEquals("testAddEnd: Check Added value is on the end",(Integer)8, list1.get(3));
       
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("testSize: Shortlist should be 2",2,shortList.size());
		assertEquals("testSize: longerList should be 10",10,longerList.size());
		assertEquals("testSize: list1 should be 3",3,list1.size());
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		//should throw error for two below
		try {
			list1.add(-1,-111);
			fail("Check out of bounds");
		}
		
		catch (IndexOutOfBoundsException e) {
				
		}
		try {
			list1.add(987,987);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
			list1.add(null);
			fail("null pointer check");
		}
		catch(NullPointerException e) {
		}
		
		//testing edge and middle;
		list1.add(0,888);
        list1.add(2,222);
        list1.add(4,444);
        
        assertEquals("Check element at index 0 ",(Integer)888,list1.get(0));
        assertEquals("Check element at index 2 ",(Integer)222,list1.get(2));
        assertEquals("Check element at index 4 ",(Integer)444,list1.get(4));
        
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		try {
			list1.set(-1,-111);
			fail("Check out of bounds");
		}
		
		catch (IndexOutOfBoundsException e) {
				
		}
		try {
			list1.set(987,987);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		//testing edge and middle;
		list1.set(0,888);
        list1.set(1,111);
        list1.set(2,222);
        
        assertEquals("Check element at index 0 ",(Integer)888,list1.get(0));
        assertEquals("Check element at index 1 ",(Integer)111,list1.get(1));
        assertEquals("Check element at index 2 ",(Integer)222,list1.get(2));
	    
	}
	
	
	
}
