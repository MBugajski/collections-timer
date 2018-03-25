package com.MBugajski.timingCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;

public class MapHashTiming extends MapsTiming {
	Map<Integer, Book> timedHashMap = new HashMap<>();

	public MapHashTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
	}

//	public void populate() {
//		Random random = new Random();
//		for (int i = 0; i < collectionSize; i++) {
//			Integer title = random.nextInt(1000) + 999000;
//			Integer author = random.nextInt(1000) + 100000;
//			Book book = new Book(title.toString(), author.toString());
//			timedHashMap.put(i, book);
//		}
//	}


	BiConsumer<Integer, Book> populateMap = (a, b) -> timedHashMap.put(a, b);
	
	public void timeHashMap() {
		System.out.println(readRandomPrint());
		System.out.println(removeRandomPrint());
		System.out.println(addRandomPrint());
	}

//	public long[] measure(HashMapOperation function) {
//		Map<Integer, Book> tempTimedMap = new HashMap<>();
//		Random random = new Random();
//		random.setSeed(seed);
//		long totalMapTiming = 0;
//		long longestMapTiming = 0;
//		for (int i = 0; i < testSize; i++) {
//			tempTimedMap = timedHashMap;
//			int randomLongTestKey = random.nextInt(timedHashMap.size() + 1);
//			long begin = System.nanoTime();
//			function.invoke(tempTimedMap, randomLongTestKey);
//			long end = System.nanoTime();
//			totalMapTiming += (end - begin);
//			if ((end - begin) > longestMapTiming) {
//				longestMapTiming = (end - begin);
//			}
//		}
//		long averageMapTiming = (totalMapTiming / testSize);
//		return new long[] { averageMapTiming, longestMapTiming };
//	}

	HashMapOperation readRandom = (a, b) -> a.get(b);

	HashMapOperation removeRandom = (a, b) -> a.remove(b);

	HashMapOperation addRandom = (a, b) -> a.put(b, new Book("1234567", "7654321"));

	public String readRandomPrint() {
		long[] results = measure(timedHashMap, readRandom);
		return "Retrieving an random element from the map has taken on average: " + results[0] + "ns\n"
				+ "Retrieving an random element from the map has taken at most: " + results[1] + "ns\n";

	}

	public String removeRandomPrint() {
		long[] results = measure(timedHashMap, removeRandom);
		return "Removing a random element from the map has taken on average: " + results[0] + "ns\n"
				+ "Removing a random element from the map has taken at most: " + results[1] + "ns\n";

	}

	public String addRandomPrint() {
		long[] results = measure(timedHashMap, addRandom);
		return "Adding a random element to the map has taken on average: " + results[0] + "ns\n"
				+ "Adding a random element to the map has taken at most: " + results[1] + "ns\n";
	}

}