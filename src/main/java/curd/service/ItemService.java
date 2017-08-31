package curd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curd.dao.ItemRespository;
import curd.model.Item;

//represent service class (service class that calls a DAO)
@Service
public class ItemService {

	@Autowired 
	private ItemRespository itemRespository;
	
	public List<Item> getallItems() {
		List<Item> item=new ArrayList<Item>();
		itemRespository.findAll().forEach(item::add);
		return item;
	}
	
	public List<Item> getallItemsLatest() {
		List<Item> item=new ArrayList<Item>();
		itemRespository.getItemBydateCreated().forEach(item::add);
		return item;
	}

	public Item getItem(int id) {
		
		return itemRespository.findOne(id);
	}

	public void addItem(Item item) {
		 itemRespository.save(item);
	}

	public void updateItem(int id, Item item) {
		itemRespository.save(item);
	}

	

	public void deleteItem(int id) {
		itemRespository.delete(id);
	}
	
	
	public Item findbyname(String name){
		return itemRespository.findByName(name);
	}

	

}
