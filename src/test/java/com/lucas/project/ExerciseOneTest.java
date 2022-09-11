package com.lucas.project;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class ExerciseOneTest {

	@Test
	void testIsDivisibleByThree() {
		assertAll(() -> assertFalse(ExerciseOne.isDivisibleByThree(1)),
				() -> assertTrue(ExerciseOne.isDivisibleByThree(3)),
				() -> assertFalse(ExerciseOne.isDivisibleByThree(5)));
	}

	@Test
	void testIsDivisibleByFive() {
		assertAll(() -> assertFalse(ExerciseOne.isDivisibleByFive(1)),
				() -> assertTrue(ExerciseOne.isDivisibleByFive(5)),
				() -> assertFalse(ExerciseOne.isDivisibleByFive(7)));
	}

	@Test
	void testGetOutputByInt() {
		Map<Integer, String> assertMap = getPreparedAssertionMap();

		for (Integer key : assertMap.keySet()) {
			assertEquals(assertMap.get(key), ExerciseOne.getOutputByInt(key));
		}
	}

	private Map<Integer, String> getPreparedAssertionMap() {
		Map<Integer, String> assertMap = new HashMap<>();
		assertMap.put(1, "1");
		assertMap.put(3, "Visual");
		assertMap.put(4, "4");
		assertMap.put(5, "Nuts");
		assertMap.put(7, "7");
		assertMap.put(10, "Nuts");
		assertMap.put(13, "13");
		assertMap.put(15, "Visual Nuts");
		assertMap.put(16, "16");

		return assertMap;
	}
}