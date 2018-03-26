package com.MBugajski.timingCollections;
public class ATestingEnviorement {
	protected int collectionSize;
	protected int testSize;
	
	public ATestingEnviorement(int collectionSize, int testSize) {
		super();
		this.collectionSize = collectionSize;
		this.testSize = testSize;
	}
	
	public void testLinkedList() {
		ListLinkedTiming testLinkedList = new ListLinkedTiming(collectionSize, testSize);
		testLinkedList.populate(testLinkedList.populateLinkedList);
		testLinkedList.timeLinkList();
	}
	
	public void testHashMap() {
		MapHashTiming testHashMap = new MapHashTiming(collectionSize, testSize);
		testHashMap.populate(testHashMap.populateHashMap);
		testHashMap.timeHashMap();
	}
	
	public void testHashSet() {
		SetHashTiming testHashSet = new SetHashTiming(collectionSize, testSize);
		testHashSet.populate(testHashSet.populateHashSet);
		testHashSet.timeHashSet();
	}
	public void testTreeSet() {
		SetTreeTiming testTreeSet = new SetTreeTiming(collectionSize, testSize);
		testTreeSet.populate(testTreeSet.populateTreeSet);
		testTreeSet.timeTreeSet();
	}

	
}
