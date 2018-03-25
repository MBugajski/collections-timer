package com.MBugajski.timingCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapHashTiming extends MapsTiming {
	Map<Integer, Book> timedHashMap = new HashMap<>();

	public MapHashTiming(int collectionSize, int testSize) {
		super(collectionSize, testSize);
	}

	BiConsumer<Integer, Book> populateHashMap = (a, b) -> timedHashMap.put(a, b);

	public void timeHashMap() {
		System.out.println(readRandomPrint());
		System.out.println(removeRandomPrint());
		System.out.println(addRandomPrint());
	}

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