package com.capeelectric.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capeelectric.exception.CountryDetailsException;
import com.capeelectric.model.country;
import com.capeelectric.model.State;
import com.capeelectric.repository.CountryRepository;
import com.capeelectric.repository.StateRepository;
import com.capeelectric.service.CountryDetailsService;


	@Service
	public class CountryDetailsServiceImpl implements CountryDetailsService {
		@Autowired
		private CountryRepository countryRepository;

		@Autowired
		private StateRepository stateRepository;

		public List<State> fetchStatesByCountryCode(String code) throws CountryDetailsException {

			List<State> state = stateRepository.fetchStatesByCountryCode(code);
			return sortStateList(state);
		}

		private List<State> sortStateList(List<State> state) {
			state.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
			return state;
		}

		

//		private List<Country> sortCountrylist(List<Country> country) {
//			country.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
//			return country;
//		}

		@Override
		public List<country> fetchCountries() {
			// TODO Auto-generated method stub
			List<country> country = (List<country>) countryRepository.findAll();
			return country;
			
		}
		
		

			
		}
	



