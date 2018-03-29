package com.mbugajski.timingcollections;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class SetHashTiming extends SetsTiming {
	Set<Book> timedHashSet = new HashSet<>();

	public SetHashTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
	}

	Consumer<Book> populateHashSet = a -> timedHashSet.add(a);

	public void timeHashSet() {
		long[] results = measure(timedHashSet, readExisting);
		System.out.println("Contains(existingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedHashSet, readNonExisting);
		System.out.println("Contains(random nonExistingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedHashSet, readNonExisting0);
		System.out.println("Contains(same nonExistingSetEntry created in function): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedHashSet, readNonExisting1);
		System.out.println("Contains(same nonExistingSetEntry as argument): " + results[0] + ", " + results[1] + "ns\n");
		
		results = measure(timedHashSet, addExisting);
		System.out.println("Add(existingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedHashSet, addNonExisting);
		System.out.println("Add(random nonExistingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedHashSet, addNonExisting0);
		System.out.println("Add(same nonExistingSetEntry created in function): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedHashSet, addNonExisting1);
		System.out.println("Add(same nonExistingSetEntry as argument)" + results[0] + ", " + results[1] + "ns\n");
		
		results = measure(timedHashSet, removeExisting);
		System.out.println("Remove(existingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedHashSet, removeNonExisting);
		System.out.println("Remove(random nonExistingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedHashSet, removeNonExisting0);
		System.out.println("Remove(same nonExistingSetEntry created in function): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedHashSet, removeNonExisting1);
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
