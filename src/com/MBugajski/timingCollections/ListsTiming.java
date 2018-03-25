package com.MBugajski.timingCollections;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public abstract class ListsTiming extends ATestingEnviorement{

	public ListsTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
		// TODO Auto-generated constructor stub
	}
	
	public void populate(Consumer<Book> consumer) {
		Random random = new Random();
		for (int i = 0; i < collectionSize; i++) {
			Integer title = random.nextInt(1000) + 999000;
			Integer author = random.nextInt(1000) + 100000;
			Book book = new Book(title.toString(), author.toString());
			consumer.accept(book);
		}
	}
	
//	public long measure(Runnable runnable) {
//		long begin = System.nanoTime();
//		runnable.run();
//		long end = System.nanoTime();
//		return (end - begin);
//	}
	
	public long measure(List list, Consumer<List<Book>> consumer) {
		List<Book> aList = list;
		long begin = System.nanoTime();
		consumer.accept(aList);
		long end = System.nanoTime();
		return (end - begin);
	}


}
