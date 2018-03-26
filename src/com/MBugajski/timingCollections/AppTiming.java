package com.MBugajski.timingCollections;

public class AppTiming {

	public static void main(String[] args) {

		ATestingEnviorement timingEnviorement = new ATestingEnviorement(2000000, 500000);
//		timingEnviorement.testLinkedList();
//		timingEnviorement.testHashMap();
		timingEnviorement.testHashSet();

	}
}
