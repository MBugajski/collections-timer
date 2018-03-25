package com.MBugajski.timingCollections;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class ListLinkedTiming extends ListsTiming {
	List<Book> timedLinkedList = new LinkedList<>();

	public ListLinkedTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
	}

//	public void populate() {
//		Random random = new Random();
//		for (int i = 0; i < collectionSize; i++) {
//			Integer title = random.nextInt(1000) + 999000;
//			Integer author = random.nextInt(1000) + 100000;
//			Book book = new Book(title.toString(), author.toString());
//			timedLinkedList.add(book);
//		}
//	}
	
//	public void populate(Consumer<Book> consumer) {
//		Random random = new Random();
//		for (int i = 0; i < collectionSize; i++) {
//			Integer title = random.nextInt(1000) + 999000;
//			Integer author = random.nextInt(1000) + 100000;
//			Book book = new Book(title.toString(), author.toString());
//			consumer.accept(book);
//		}
//	}

	Consumer<Book> populateList = a -> timedLinkedList.add(a);
	
	public void timeLinkList() {
		System.out.println("Returning the first element from the list has taken: " + measure(readFirst) + "ns");
		System.out.println("Returning the last element from the list has taken: " + measure(readLast) + "ns\n");
		System.out.println("Removing the first element from the list has taken: " + measure(removeFirst) + "ns");
		System.out.println("Removing the last element from the list has taken: " + measure(removeLast) + "ns\n");
		System.out.println("Adding an element at the beginning of the list has taken: " + measure(addFirst) + "ns");
		System.out.println("Adding an element at the end of the list has taken: " + measure(addLast) + "ns\n");
	}

	public long measure(Runnable runnable) {
		long begin = System.nanoTime();
		runnable.run();
		long end = System.nanoTime();
		return (end - begin);
	}
	public long measure(Consumer<List<Book>> consumer) {
		List<Book> aList = timedLinkedList;
		long begin = System.nanoTime();
		consumer.accept(aList);
		long end = System.nanoTime();
		return (end - begin);
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
