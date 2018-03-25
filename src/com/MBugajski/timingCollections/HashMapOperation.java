package com.MBugajski.timingCollections;

import java.util.Map;

@FunctionalInterface
public interface HashMapOperation {
	public void invoke(Map<Integer, Book> map, int i);
}
