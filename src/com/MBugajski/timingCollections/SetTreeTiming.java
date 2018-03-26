package com.MBugajski.timingCollections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class SetTreeTiming extends SetsTiming{
	Comparator<Book> compAuthor = (Book b1, Book b2) -> (b1.getAuthor().compareTo(b2.getAuthor()));
	Comparator<Book> compTitle = (Book b1, Book b2) -> (b1.getTitle().compareTo(b2.getTitle()));
	Set<Book> timedTreeSet = new TreeSet<Book>(compAuthor);
	
	public SetTreeTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
	}
	
	Consumer<Book> populateTreeSet = a -> timedTreeSet.add(a);

	public void timeTreeSet() {
		long[] results = measure(timedTreeSet, readExisting);
		System.out.println("Contains(existingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedTreeSet, readNonExisting);
		System.out.println("Contains(random nonExistingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedTreeSet, readNonExisting0);
		System.out.println("Contains(same nonExistingSetEntry created in function): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedTreeSet, readNonExisting1);
		System.out.println("Contains(same nonExistingSetEntry as argument): " + results[0] + ", " + results[1] + "ns\n");
		
		results = measure(timedTreeSet, addExisting);
		System.out.println("Add(existingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedTreeSet, addNonExisting);
		System.out.println("Add(random nonExistingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedTreeSet, addNonExisting0);
		System.out.println("Add(same nonExistingSetEntry created in function): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedTreeSet, addNonExisting1);
		System.out.println("Add(same nonExistingSetEntry as argument)" + results[0] + ", " + results[1] + "ns\n");
		
		results = measure(timedTreeSet, removeExisting);
		System.out.println("Remove(existingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedTreeSet, removeNonExisting);
		System.out.println("Remove(random nonExistingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedTreeSet, removeNonExisting0);
		System.out.println("Remove(same nonExistingSetEntry created in function): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedTreeSet, removeNonExisting1);
		System.out.println("Remove(same nonExistingSetEntry as argument): " + results[0] + ", " + results[1] + "ns\n");
	}

	Consumer<Set<Book>> readExisting = a -> a.contains(existingSetEntry);
	Consumer<Set<Book>> readNonExisting = a -> a.contains(nonExistingSetEntry);
	Consumer<Set<Book>> readNonExisting0 = a -> a.contains(new Book ("1", "-1"));
	Consumer<Set<Book>> readNonExisting1 = a -> a.contains(nonExistingSetEntry1);
	
	Consumer<Set<Book>> addExisting = a -> a.add(existingSetEntry);
	Consumer<Set<Book>> addNonExisting = a -> a.add(nonExistingSetEntry);
	Consumer<Set<Book>> addNonExisting0 = a -> a.add(new Book ("1", "-1"));
	Consumer<Set<Book>> addNonExisting1 = a -> a.add(nonExistingSetEntry1);
	
	Consumer<Set<Book>> removeExisting = a -> a.remove(existingSetEntry);
	Consumer<Set<Book>> removeNonExisting = a -> a.remove(nonExistingSetEntry);
	Consumer<Set<Book>> removeNonExisting0 = a -> a.remove(new Book ("1", "-1"));
	Consumer<Set<Book>> removeNonExisting1 = a -> a.remove(nonExistingSetEntry1);


}
