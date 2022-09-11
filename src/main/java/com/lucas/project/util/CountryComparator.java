package com.lucas.project.util;

import java.util.Comparator;

import com.lucas.project.vo.CountryVO;

public class CountryComparator implements Comparator<CountryVO> {

	@Override
	public int compare(CountryVO countryA, CountryVO countryB) {
		Integer sizeA = countryA.getLanguages() == null ? 0 : countryA.getLanguages().size();
		Integer sizeB = countryB.getLanguages() == null ? 0 : countryB.getLanguages().size();

		return sizeA.compareTo(sizeB);
	}
}
