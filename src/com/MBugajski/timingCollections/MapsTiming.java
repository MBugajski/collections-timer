package com.MBugajski.timingCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;

public class MapsTiming extends ATestingEnviorement {
	Random randomseed = new Random();
	long seed = randomseed.nextLong();
	
	protected MapsTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
		// TODO Auto-generated constructor stub
	}
	
	
	public void populate(BiConsumer<Integer, Book> consumer) {
		Random random = new Random();
		for (Integer i = 0; i < collectionSize; i++) {
//			Integer title = random.nextInt(1000) + 999000;
			Integer author = random.nextInt(1000000) + i;
			Book book = new Book(i.toString(), author.toString());
			consumer.accept(i, book);
		}
	}
	
	public long[] measure(Map map, HashMapOperation function) {
		Map<Integer, Book> tempTimedMap = new HashMap<>();
		Random random = new Random();
		random.setSeed(seed);
		long totalMapTiming = 0;
		long longestMapTiming = 0;
		for (int i = 0; i < testSize; i++) {
			tempTimedMap = map;
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
