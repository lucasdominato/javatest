package com.lucas.project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucas.project.util.CountryComparator;
import com.lucas.project.vo.CountryVO;

public class ExerciseTwo {

	public static void main(String[] args) {
		List<CountryVO> countries = new ArrayList<>();

		try {
			countries = Arrays.asList(new ObjectMapper().readValue(
					new File(System.getProperty("user.dir") + "/src/main/resources/countries.json"),
					CountryVO[].class));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Number of countries in the world = " + countries.size());

		System.out.println("Country with the most official languages, where they officially speak German (de) = "
				+ findCountryWithMostLanguagesWhichSpeaksSpecificLanguage(countries, "de"));

		System.out.println(
				"Number of all the official languages spoken = " + getNumberOfUniqueLanguagesSpoken(countries));

		System.out.println(
				"Country with the highest number of official languages = " + findCountryWithMostLanguages(countries));

		System.out.println("Most common official language = " + findMostCommonOfficialLanguage(countries));
	}

	public static String findCountryWithMostLanguagesWhichSpeaksSpecificLanguage(List<CountryVO> countries,
			String language) {
		Optional<CountryVO> countryFound = countries.stream()
				.filter(country -> country.getLanguages().contains(language)).max(new CountryComparator());

		return countryFound.isPresent() ? countryFound.get().getCountry() : "";
	}

	public static int getNumberOfUniqueLanguagesSpoken(List<CountryVO> countries) {
		Set<String> languagesSpoken = countries.stream().flatMap(country -> country.getLanguages().stream())
				.collect(Collectors.toSet());
		return languagesSpoken.size();
	}

	public static String findCountryWithMostLanguages(List<CountryVO> countries) {
		Optional<CountryVO> countryFound = countries.stream().max(new CountryComparator());

		return countryFound.isPresent() ? countryFound.get().getCountry() : "";
	}

	public static String findMostCommonOfficialLanguage(List<CountryVO> countries) {
		String mostCommonLanguage = "";
		int mostCommonLanguageCount = 0;

		Map<String, Integer> languageMap = new HashMap<>();

		countries.stream().flatMap(country -> country.getLanguages().stream()).forEach(lang -> {
			if (!languageMap.containsKey(lang))
				languageMap.put(lang, 1);
			else
				languageMap.put(lang, languageMap.get(lang) + 1);
		});

		for (String key : languageMap.keySet()) {
			if (languageMap.get(key) > mostCommonLanguageCount) {
				mostCommonLanguageCount = languageMap.get(key);
				mostCommonLanguage = key;
			}
		}

		return mostCommonLanguage;
	}
}