package com.MBugajski.timingCollections;

import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;

public abstract class MapsTiming extends ATestingEnviorement {
	Random randomseed = new Random();
	long seed = randomseed.nextLong();
	
	protected MapsTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
	}
	
	
	public void populate(BiConsumer<Integer, Book> consumer) {
		Random random = new Random();
		for (Integer i = 0; i < collectionSize; i++) {
			Integer author = random.nextInt(1000000) + i;
			Book book = new Book(i.toString(), author.toString());
			consumer.accept(i, book);
		}
	}
	
	public long[] measure(Map<Integer, Book> map, HashMapOperation function) {
		Random random = new Random();
		random.setSeed(seed);
		long totalMapTiming = 0;
		long longestMapTiming = 0;
		for (int i = 0; i < testSize; i++) {
			Map<Integer, Book> tempTimedMap = map;
			int randomLongTestKey = random.nextInt(map.size() + 1);
			long begin = System.nanoTime();
			function.invoke(tempTimedMap, randomLongTestKey);
			long end = System.nanoTime();
			totalMapTiming += (end - begin);
			if ((end - begin) > longestMapTiming) {
				longestMapTiming = (end - begin);
			}
		}
		long averageMapTiming = (totalMapTiming / testSize);
		return new long[] { averageMapTiming, longestMapTiming };
	}
}
