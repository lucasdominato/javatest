package com.lucas.project;

public class ExerciseOne {

	public final static String VISUAL = "Visual";
	public final static String NUTS = "Nuts";
	public final static String VISUAL_NUTS = "Visual Nuts";

	public static void main(String[] args) {
		int ammount = 100;

		for (int i = 1; i <= ammount; i++) {
			System.out.println(getOutputByInt(i));
		}
	}

	public static String getOutputByInt(int num) {
		if (isDivisibleByThree(num)) {
			if (isDivisibleByFive(num)) {
				return VISUAL_NUTS;
			}
			return VISUAL;
		} else if (isDivisibleByFive(num)) {
			return NUTS;
		}

		return String.valueOf(num);
	}

	public static boolean isDivisibleByThree(int num) {
		return num % 3 == 0;
	}

	public static boolean isDivisibleByFive(int num) {
		return num % 5 == 0;
	}
}