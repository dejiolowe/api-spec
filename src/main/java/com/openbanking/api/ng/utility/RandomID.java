package com.openbanking.api.ng.utility;

import java.util.Random;

public class RandomID {

	private static Long getLongID() {
		Random random = new Random();
		Long rand = Math.abs(random.nextLong());
		return (System.currentTimeMillis() + rand);
	}

	public static Long getID() {
		return getLongID();
	}

	public static String getStringID() {
		return RandomID.getLongID().toString();
	}
}
