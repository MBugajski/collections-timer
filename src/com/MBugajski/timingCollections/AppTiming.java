package com.MBugajski.timingCollections;

public class AppTiming {

	public static void main(String[] args) {

		ATestingEnviorement timingEnviorement = new ATestingEnviorement(2000000, 5000000);
		timingEnviorement.testLinkedList();
		timingEnviorement.testHashMap();

	}
}
