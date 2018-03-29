package com.mbugajski.timingcollections;

import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;

public abstract class SetsTiming extends ATestingEnviorement {
	Random randomseed = new Random();
	long seed = randomseed.nextLong();
	protected Book existingSetEntry;
	protected Book nonExistingSetEntry;
	protected Book nonExistingSetEntry1 = new Book("1", "-1");

	public SetsTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
	}

	public void populate(Consumer<Book> consumer) {
		Random random = new Random();
		int existingSetEntryID = random.nextInt(collectionSize);
		long begin = System.nanoTime();
		for (int i = 0; i < collectionSize; i++) {
			Integer author = i;
			Integer title = random.nextInt(collectionSize);
			Book book = new Book(author.toString(), title.toString());
			consumer.accept(book);
			if (i == existingSetEntryID) {this.existingSetEntry = book;	}
		}
		long end = System.nanoTime();
		System.out.println("Populating:" + (end - begin) + "ns");
	}
	
	
	public long[] measure(Set<Book> set, Consumer<Set<Book>> consumer) {
		Random random = new Random();
		random.setSeed(seed);

		long totalSetTiming = 0;
		long longestSetTiming = 0;
		for (int i = 0; i < testSize; i++) {
			Set<Book> tempTimedSet = set;
			Integer author = random.nextInt(collectionSize);
			Integer title = -random.nextInt(collectionSize);
			nonExistingSetEntry = new Book (author.toString(), title.toString());
//			nonExistingSetEntry1 = new Book("1", "-1");
			long begin = System.nanoTime();
			consumer.accept(tempTimedSet);
			long end = System.nanoTime();
			totalSetTiming += (end - begin);
			if ((end - begin) > longestSetTiming) {
				longestSetTiming = (end - begin);
			}
		}
		long averageMapTiming = (totalSetTiming / testSize);
		return new long[] { averageMapTiming, longestSetTiming };
	}
}
