package com.lucas.project;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucas.project.vo.CountryVO;

public class ExerciseTwoTest {

	private static List<CountryVO> countries;

	@BeforeAll
	static void loadCountries() {
		try {
			countries = Arrays.asList(new ObjectMapper().readValue(
					 "[{\"country\":\"US\",\"languages\":[\"en\"]},"
					+ "{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]},"
					+ "{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]},"
					+ "{\"country\":\"DE\",\"languages\":[\"de\"]},"
					+ "{\"country\":\"ES\",\"languages\":[\"es\"]}]",
					CountryVO[].class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFindCountryWithMostLanguagesWhichSpeaksSpecificLanguage() {
		assertAll(
				() -> assertEquals("BE",
						ExerciseTwo.findCountryWithMostLanguagesWhichSpeaksSpecificLanguage(countries, "de")),
				() -> assertEquals("ES",
						ExerciseTwo.findCountryWithMostLanguagesWhichSpeaksSpecificLanguage(countries, "es")),
				() -> assertEquals("NL",
						ExerciseTwo.findCountryWithMostLanguagesWhichSpeaksSpecificLanguage(countries, "fy")),
				() -> assertEquals("",
						ExerciseTwo.findCountryWithMostLanguagesWhichSpeaksSpecificLanguage(countries, "none")));
	}

	@Test
	void testGetNumberOfUniqueLanguagesSpoken() {
		List<CountryVO> countriesB = Arrays.asList(new CountryVO("BR", Arrays.asList("pt")),
				new CountryVO("AR", Arrays.asList("es")), new CountryVO("PT", Arrays.asList("pt")),
				new CountryVO("CH", Arrays.asList("es")));
		assertAll(() -> assertEquals(6, ExerciseTwo.getNumberOfUniqueLanguagesSpoken(countries)),
				() -> assertEquals(2, ExerciseTwo.getNumberOfUniqueLanguagesSpoken(countriesB)));
	}

	@Test
	void testFindCountryWithMostLanguages() {
		List<CountryVO> countriesB = Arrays.asList(new CountryVO("BR", Arrays.asList("pt")),
				new CountryVO("AR", Arrays.asList("es")), new CountryVO("PT", Arrays.asList("pt")),
				new CountryVO("CH", Arrays.asList("es")), new CountryVO("CA", Arrays.asList("en", "fr")));

		assertAll(() -> assertEquals("BE", ExerciseTwo.findCountryWithMostLanguages(countries)),
				() -> assertEquals("CA", ExerciseTwo.findCountryWithMostLanguages(countriesB)));
	}

	@Test
	void testFindMostCommonOfficialLanguage() {
		List<CountryVO> countriesB = Arrays.asList(new CountryVO("BR", Arrays.asList("pt")),
				new CountryVO("AR", Arrays.asList("es")), new CountryVO("PT", Arrays.asList("pt")),
				new CountryVO("CH", Arrays.asList("es")), new CountryVO("CA", Arrays.asList("en", "fr")),
				new CountryVO("PY", Arrays.asList("es", "gu")));

		assertAll(() -> assertEquals("de", ExerciseTwo.findMostCommonOfficialLanguage(countries)),
				() -> assertEquals("es", ExerciseTwo.findMostCommonOfficialLanguage(countriesB)));
	}
}