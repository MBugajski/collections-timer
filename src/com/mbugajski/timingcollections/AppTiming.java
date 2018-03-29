package com.mbugajski.timingcollections;

public class AppTiming {

	public static void main(String[] args) {

		ATestingEnviorement timingEnviorement = new ATestingEnviorement(2000000, 1000000);
//		timingEnviorement.testLinkedList();
//		timingEnviorement.testHashMap();
		timingEnviorement.testHashSet();
		timingEnviorement.testLinkedHashSet();
//		timingEnviorement.testTreeSet();

	}
}
