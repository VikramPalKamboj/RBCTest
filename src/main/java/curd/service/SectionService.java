package curd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curd.dao.SectionRepository;
import curd.model.Section;


@Service
public class SectionService {

		@Autowired
		private SectionRepository sectionRepository;
		
		
		public List<Section> getallItems() {
			List<Section> section=new ArrayList<Section>();
			sectionRepository.findAll().forEach(section::add);
			return section;
		}

		public List<Section> searchcountry(String country) {
			return sectionRepository.findByCountry(country);
		}
}
