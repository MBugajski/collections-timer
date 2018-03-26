package com.MBugajski.timingCollections;

import java.util.Random;
import java.util.function.Consumer;

public abstract class SetsTiming extends ATestingEnviorement {

	public SetsTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
	}

	public void populate(Consumer<Book> consumer) {
		Random random = new Random();
		for (int i = 0; i < collectionSize; i++) {
			Integer author = i;
			Integer title = random.nextInt(collectionSize);
			Book book = new Book(author.toString(), title.toString());
			consumer.accept(book);
		}
	}

}
