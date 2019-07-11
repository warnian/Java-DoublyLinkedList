package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * double linked list for UCSD Java Data Structures class
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if (element == null) {
			throw new NullPointerException("null elements not allowed");
		}
		
		LLNode<E> cur_node = head;
		LLNode<E> add_node = new LLNode<E>(element);
		add_node.next=tail;
		tail.prev = add_node;
		
		//while loop goes to end of list
		while (cur_node.next.data != null) {
			cur_node=cur_node.next; 
			
		}
		
		cur_node.next = add_node;
		add_node.prev = cur_node;
		//testerblock method seems to be correct
		/*
		System.out.println("head location: "+head+" head.next: "+head.next+" tail location: "+tail+" tail.prev: "+tail.prev);
		System.out.println("add location: "+add_node+" add data: "+add_node.data+" add.next: "+add_node.next+" add.prev: "+add_node.prev);
		System.out.println("cur location: "+cur_node+" cur data: "+cur_node.data+" cur.next: "+cur_node.next+" cur.prev: "+cur_node.prev);
		
		*/
		size += 1;
		
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		
		LLNode<E> get_node = head;
		int count = 0;
		if (index+1>this.size) {
			throw new IndexOutOfBoundsException("index larger than list");
		}
		if (index<0) {
			throw new IndexOutOfBoundsException("index cannot be negative");
		}
		
		
		while (get_node.next.data != null) {
			get_node = get_node.next;
			if (count==index) {
				return get_node.data;
				
			}
			count+=1;
			
		}
		if (get_node.next.data == null) {
			
			return get_node.data;
			
		}
		else {
			return null;
		}
		
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (element == null) {
			throw new NullPointerException("null elements not allowed");
		}
		if (index+1>this.size && index!=0) {
			throw new IndexOutOfBoundsException("index larger than list schmist");
		}
		if (index<0) {
			throw new IndexOutOfBoundsException("index cannot be negative");
		}
		
		LLNode<E> add_node = new LLNode<E>(element);
		LLNode<E> cur_node = head;
		int count = 0;
		if (index == 0) {
			cur_node.next.prev=add_node; 
			add_node.prev=cur_node; //inserted node previous is the current node
			add_node.next=cur_node.next;
			cur_node.next=add_node;
			
		}
		while (cur_node.next !=null) {
			cur_node = cur_node.next;
			if (count == index-1) {
				cur_node.next.prev=add_node; 
				add_node.prev=cur_node; //inserted node previous is the current node
				add_node.next=cur_node.next;
				cur_node.next=add_node;
				
				
			}
			
			count+=1;
			
		}
		
		size+=1;
		
	}

	/** Return the size of the list */
	public int size() 
	{
		return this.size;
		
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (this.size == 0) {
			throw new IndexOutOfBoundsException("Nothing to remove");
		}
		if (index+1>this.size) {
			throw new IndexOutOfBoundsException("index larger than list");
		}
		if (index<0) {
			throw new IndexOutOfBoundsException("index cannot be negative");
		}
		LLNode<E> cur_node = head;
		int count = 0;
		
		while (cur_node.next !=null) {
			cur_node = cur_node.next;
			if (count==index) {
				cur_node.next.prev = cur_node.prev;
				cur_node.prev.next = cur_node.next;
				size-=1;
				return cur_node.data;
				
			}
			
			count+=1;
		}
		
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (element == null) {
			throw new NullPointerException("null elements not allowed");
		}
		if (index+1>this.size) {
			throw new IndexOutOfBoundsException("index larger than list");
		}
		if (index<0) {
			throw new IndexOutOfBoundsException("index cannot be negative");
		}
		
		LLNode<E> cur_node = head;
		int count = 0;
		if (index == 0) {
			cur_node.next.data = element;
			return cur_node.data;
		}
		while (cur_node.next !=null) {
			cur_node = cur_node.next;
			
			if (count == index) {
				cur_node.data = element;
				return cur_node.data;
			}
			
			count+=1;
			
		}
		// TODO: Implement this method
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode(E e) 
	{
		
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
