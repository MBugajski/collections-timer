package com.MBugajski.timingCollections;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class ListLinkedTiming extends ListsTiming {
	List<Book> timedLinkedList = new LinkedList<>();

	public ListLinkedTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
	}

	Consumer<Book> populateLinkedList = a -> timedLinkedList.add(a);

	public void timeLinkList() {
		System.out.println("Returning the first element from the list has taken: " + measure(timedLinkedList, readFirst) + "ns");
		System.out.println("Returning the last element from the list has taken: " + measure(timedLinkedList, readLast) + "ns\n");
		System.out.println("Removing the first element from the list has taken: " + measure(timedLinkedList, removeFirst) + "ns");
		System.out.println("Removing the last element from the list has taken: " + measure(timedLinkedList, removeLast) + "ns\n");
		System.out.println("Adding an element at the beginning of the list has taken: " + measure(timedLinkedList, addFirst) + "ns");
		System.out.println("Adding an element at the end of the list has taken: " + measure(timedLinkedList, addLast) + "ns\n");
	}

//	Runnable readFirst = () -> timedLinkedList.get(0);
//	Runnable readLast = () -> timedLinkedList.get(timedLinkedList.size() - 1);
//	Runnable removeFirst = () -> timedLinkedList.remove(0);
//	Runnable removeLast = () -> timedLinkedList.remove(timedLinkedList.size() - 1);
//	Runnable addFirst = () -> timedLinkedList.add(0, new Book("1234567", "7654321"));
//	Runnable addLast = () -> timedLinkedList.add(timedLinkedList.size() - 1, new Book("1234567", "7654321"));

	 Consumer<List<Book>> readFirst = a -> a.get(0);
	 Consumer<List<Book>> readLast = a -> a.get(a.size() - 1);
	 Consumer<List<Book>> removeFirst = a -> a.remove(0);
	 Consumer<List<Book>> removeLast = a -> a.remove(a.size() - 1);
	 Consumer<List<Book>> addFirst = a -> a.add(0, new Book("1234567", "7654321"));
	 Consumer<List<Book>> addLast = a -> a.add(a.size() - 1, new Book("1234567", "7654321"));

}
