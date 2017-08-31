package curd.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import curd.model.Section;

public interface SectionRepository extends CrudRepository<Section, Integer> {

	List<Section> findByCountry(String country);

}
