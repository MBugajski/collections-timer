package com.mbugajski.timingcollections;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;

public class SetLinkedHashTiming extends SetsTiming {
	Set<Book> timedLinkedHashSet = new LinkedHashSet<Book>();

	public SetLinkedHashTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
	}

	Consumer<Book> populateLinkedHashSet = a -> timedLinkedHashSet.add(a);

	public void timeLinkedHashSet() {
		long[] results = measure(timedLinkedHashSet, readExisting);
		System.out.println("Contains(existingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedLinkedHashSet, readNonExisting);
		System.out.println("Contains(random nonExistingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedLinkedHashSet, readNonExisting0);
		System.out.println("Contains(same nonExistingSetEntry created in function): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedLinkedHashSet, readNonExisting1);
		System.out.println("Contains(same nonExistingSetEntry as argument): " + results[0] + ", " + results[1] + "ns\n");

		results = measure(timedLinkedHashSet, addExisting);
		System.out.println("Add(existingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedLinkedHashSet, addNonExisting);
		System.out.println("Add(random nonExistingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedLinkedHashSet, addNonExisting0);
		System.out.println("Add(same nonExistingSetEntry created in function): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedLinkedHashSet, addNonExisting1);
		System.out.println("Add(same nonExistingSetEntry as argument)" + results[0] + ", " + results[1] + "ns\n");

		results = measure(timedLinkedHashSet, removeExisting);
		System.out.println("Remove(existingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedLinkedHashSet, removeNonExisting);
		System.out.println("Remove(random nonExistingSetEntry): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedLinkedHashSet, removeNonExisting0);
		System.out.println("Remove(same nonExistingSetEntry created in function): " + results[0] + ", " + results[1] + "ns");
		results = measure(timedLinkedHashSet, removeNonExisting1);
		System.out.println("Remove(same nonExistingSetEntry as argument): " + results[0] + ", " + results[1] + "ns\n");
	}

	Consumer<Set<Book>> readExisting = a -> a.contains(existingSetEntry);
	Consumer<Set<Book>> readNonExisting = a -> a.contains(nonExistingSetEntry);
	Consumer<Set<Book>> readNonExisting0 = a -> a.contains(new Book("1", "-1"));
	Consumer<Set<Book>> readNonExisting1 = a -> a.contains(nonExistingSetEntry1);

	Consumer<Set<Book>> addExisting = a -> a.add(existingSetEntry);
	Consumer<Set<Book>> addNonExisting = a -> a.add(nonExistingSetEntry);
	Consumer<Set<Book>> addNonExisting0 = a -> a.add(new Book("1", "-1"));
	Consumer<Set<Book>> addNonExisting1 = a -> a.add(nonExistingSetEntry1);

	Consumer<Set<Book>> removeExisting = a -> a.remove(existingSetEntry);
	Consumer<Set<Book>> removeNonExisting = a -> a.remove(nonExistingSetEntry);
	Consumer<Set<Book>> removeNonExisting0 = a -> a.remove(new Book("1", "-1"));
	Consumer<Set<Book>> removeNonExisting1 = a -> a.remove(nonExistingSetEntry1);
}
