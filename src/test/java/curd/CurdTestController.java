package curd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


public class CurdTestController extends CurdRbcTestApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
   // testing for fetching element using id.
	@Test
	public void getItem() throws Exception {
		mockMvc.perform(get("/items/2")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.id").value("2"))
				.andExpect(jsonPath("$.name").value("vikram"))
				.andExpect(jsonPath("$.city").value("new york"))
				.andExpect(jsonPath("$.dateCreated").value("1502330233000"));
		
	}
	
	// testing for getting all elements (localhost:8080/items)
	@Test
    public void getallItems() throws Exception {
        this.mockMvc.perform(get("/items").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
            
    }
	
	// testing for getting all elements (localhost:8080/items/latest)
	@Test
    public void getallItemsLatest() throws Exception {
        this.mockMvc.perform(get("/items/latest").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
            
    }
	//Testing new elements
	@Test
	public void addItem() throws Exception {
		mockMvc.perform(get("/items/add")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.id").value("4"))
				.andExpect(jsonPath("$.name").value("vikram"))
				.andExpect(jsonPath("$.city").value("new york"))
				.andExpect(jsonPath("$.dateCreated").value("1502330233000"));
		
	}


}