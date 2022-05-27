import java.util.*;
import java.io.*;
//linkedlist code used from DSA practical 4
public class LinkedList implements Iterable, Serializable {
	//Serialization code taken from lecture 4 DSA
	private class ListNode implements Serializable {
		private Object data;
		private ListNode next; // listnode inner class fields
		private ListNode prev;

		private ListNode(Object data, ListNode next, ListNode prev) {
			this.data = data;
			this.next = next;
			this.prev = prev; // constructor
		}

	}

	private ListNode head = null;
	private ListNode tail = null;
	private int size; // class fields for doubly linked list

	public LinkedList() {
		size = 0;
	}

	public Iterator iterator() {
		return new LinkedListIterator(this);
	}

	private class LinkedListIterator implements Iterator { // iterator methods
		private ListNode iterNext;

		public LinkedListIterator(LinkedList theList) {  //iterator code taken from LinkedList lecture, curtin university
			iterNext = theList.head;
		}

		public boolean hasNext() {
			return (iterNext != null);
		}

		public Object next() {
			Object value;
			if (iterNext == null) {
				value = null;
			} else {
				value = iterNext.data;
				iterNext = iterNext.next;
			}
			return value;
		}

		public void remove() {
			throw new UnsupportedOperationException("Not supported");
		}
	}
	
	//Imports:Object to insert at head of list
	public void insertFirst(Object newValue) {
		size++;
		ListNode newNode = new ListNode(newValue, head, null); // inserts node into first node position
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		if (tail == null) {
			tail = newNode;

		}

	}

	//Imports:Object to insert at tail of list
	public void insertLast(Object newValue) {
		size++;
		ListNode newNode = new ListNode(newValue, null, tail);
		if (tail != null) { // inserts node into last node position
			tail.next = newNode;
		}
		tail = newNode;
		if (head == null) {
			head = newNode;
		}

	}
	
	//Exports:Boolean value to check if list is empty
	public boolean isEmpty() {
		boolean empty;
		if (head == null) {
			empty = true;
		} else {
			empty = false; // checks to see if list is empty
		}
		return empty;
	}
	
	//Exports: Returns object at head of list
	public Object peekFirst() {
		Object nodeValue;

		if (head == null) {
			throw new IllegalArgumentException("Nothing to peek");
		}
		// checks first value in linkedlist and returns it
		else {
			nodeValue = head.data;
		}
		return nodeValue;
	}

	//Exports:Returns size of list as int
	public int getSize() {
		return size;
	}
	
	//Exports: Returns object at tail of list
	public Object peekLast() {
		Object nodeValue;
		ListNode currNode;
		if (head == null) {
			throw new IllegalArgumentException("Nothing to peek"); // gets last node in linkedlist and returns it
		} else {
			currNode = head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			nodeValue = currNode.data;
		}
		return nodeValue;
	}
	
	//Exports:Removes object at head of list and returns it
	public Object removeFirst() {
		if (size == 0) {
			throw new IllegalArgumentException("Nothing to remove"); // removes first node in linkedlist and returns it
		} else {
			ListNode newNode = head;
			if (head != tail) {
				head = head.next;
				head.prev = null;
				size--;
			} else {
				head = tail = null;
				size--;
			}

			return newNode.data;
		}
	}
	
	//Exports:Removes specific object and returns it
	public Object remove(Object name) {
		int count = 0;
		ListNode curNode = head;
		if (size == 0) {
			throw new IllegalArgumentException("Nothing to remove"); // removes specific node from linkedlist using
																		// imported object
		}

		while (curNode.data != name && count < size - 1) {
			curNode = curNode.next;
			count++;

		}

		if (curNode.data != name) {
			throw new IllegalArgumentException("Not Found");
		}

		if (curNode.data == head.data) {
			head = curNode.next;

		} else if (curNode.next == null) {
			curNode.prev.next = null;

		} else {
			curNode.prev.next = curNode.next;
			curNode.next.prev = curNode.prev;
		}
		size--;
		return curNode.data;
	}
	
	//Exports:Removes object at tail of list and returns it
	public Object removeLast() {
		if (size == 0) {
			throw new IllegalArgumentException("Nothing to remove"); // removes last node from linkedlist and returns it
		} else {

			ListNode nodeValue = tail;
			if (head != tail) {

				tail = tail.prev;
				tail.next = null;
				size--;
			} else {
				head = tail = null;
				size--;
			}
			return nodeValue.data;
		}
	}

}
