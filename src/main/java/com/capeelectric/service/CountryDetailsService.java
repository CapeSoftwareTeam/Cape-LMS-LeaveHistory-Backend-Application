package com.capeelectric.service;

import java.util.List;

import com.capeelectric.exception.CountryDetailsException;
import com.capeelectric.model.country;
import com.capeelectric.model.State;

public interface CountryDetailsService {
	
		public List<country> fetchCountries();
		public List<State> fetchStatesByCountryCode(String code) throws CountryDetailsException;
	}
