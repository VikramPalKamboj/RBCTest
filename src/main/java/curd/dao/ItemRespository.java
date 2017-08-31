package curd.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import curd.model.Item;

//Create, Read, Update, Delete: by this interfacce we don't need to write static queries for crud operation. 
public interface ItemRespository extends CrudRepository<Item, Integer>{
	

	@Query(nativeQuery=true, value="SELECT * FROM Item.item ORDER BY date_created DESC")
	public List<Item> getItemBydateCreated();
	
	
	public Item findByName(String name);

}
