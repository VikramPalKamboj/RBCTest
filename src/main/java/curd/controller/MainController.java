package curd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curd.dao.SectionRepository;
import curd.model.Item;
import curd.model.Section;
import curd.service.ItemService;
import curd.service.SectionService;

//by this annotation complier will know this is controller class
//(used for handling client request and fetching repository resources).
@Controller
public class MainController {
	
	
	//autowiring bean class
	@Autowired 
	private ItemService itemService;
	
	
	@Autowired 
	private SectionService sectionService;
	
	@Autowired 
	private SectionRepository sectionRepository;
	
	// adding mapping path for URL e.g localhost:8080/items
	@RequestMapping("/items")
	//fetching all elements 
	public List<Item> getallItems(){
		return itemService.getallItems();
	}
	
	
	
	
	//getting all latest based upon date.
	@RequestMapping("/items/latest")
	//fetching all elements according to latest date
	public List<Item> getallItemsLatest(){
		return itemService.getallItemsLatest();
	}
	
	// adding mapping path for URL e.g localhost:8080/items/1
	@RequestMapping(method=RequestMethod.GET, value="/items/{id}")
	//for getting a single element based on ID
	public Item getItem(@PathVariable int id){
		return itemService.getItem(id);
		
	}
	// adding mapping path for URL e.g localhost:8080/items/add
	@RequestMapping(method=RequestMethod.POST, value="/items/add")
	//adding new elements
	public void  addItem (@RequestBody Item item){
		 itemService.addItem(item);
		
	}
	
	// adding mapping path for URL e.g localhost:8080/items/1 (updating an element based on ID)
	@RequestMapping(method=RequestMethod.PUT, value="/items/{id}")
	//@pathVariable to get an targeted ID and @request body for targeted Item
	public void updateItem (@RequestBody Item item, @PathVariable int id){
		 itemService.updateItem(id, item);
		
	}
	
	// adding mapping path for URL e.g localhost:8080/items/1 (deleting an element based on ID)
	@RequestMapping(method=RequestMethod.DELETE, value="/items/{id}")
	//using @pathvariable to delete an element
	public void deleteItem (@PathVariable int id){
		 itemService.deleteItem(id);
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/items/name/{name}")
	//using @pathvariable to delete an element
	public  Item findName (@PathVariable String name){
		 return itemService.findbyname(name);
		
	}
	
	
	
	
    @RequestMapping(value = "/home")
	public String home(Model model)
	{
    	
    	List<Section> section=sectionService.getallItems();
    	model.addAttribute("task",section);
		return "home";
	}
    
    
    @RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("task", sectionService.searchcountry(search));
		model.addAttribute("search", search);
		return "home";
	}
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
	public String updateSection(@ModelAttribute Section section) {
		sectionRepository.save(section);
		return "redirect:home";
	}
    
    
    @GetMapping("/delete")
 	 	public String deleteSection(@RequestParam int id){
 		 sectionRepository.delete(id);
		return "redirect:home";
 		
 	}
 	
    @GetMapping("/add")
	public String updateTask(@RequestParam int id, @ModelAttribute Section section, Model model){
    	
    	List<Section> sect=sectionService.getallItems();
    	model.addAttribute("task",sect);
    	
    	model.addAttribute("sectionUpdate",sectionRepository.findOne(id));
		return "home";
	}
}
