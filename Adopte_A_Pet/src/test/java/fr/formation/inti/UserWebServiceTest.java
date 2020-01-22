package fr.formation.inti;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.assertj.core.internal.Classes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import fr.formation.inti.Iservices.IDepartementService;
import fr.formation.inti.Iservices.ITitleService;
import fr.formation.inti.Iservices.IUserService;
import fr.formation.inti.conf.WebMvcConfig;
import fr.formation.inti.controller.MainController;
import fr.formation.inti.dao.IUserRepository;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Title;
import fr.formation.inti.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@ContextConfiguration(classes = WebMvcConfig.class)
@WebMvcTest(MainController.class)
public class UserWebServiceTest  {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private IUserRepository userRepository;
	@MockBean
	private IUserService userService;
	@MockBean
	private IDepartementService deptService;
	@MockBean
	private ITitleService titleService;
	@Autowired
	private WebApplicationContext wac;
	
	
	private User user;
	private User userFindById;
	private User userUpdate;
	
	@Before
	public void setUp() throws Exception {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		Departement dept = deptService.findByDeptid(1);
		Title title = titleService.findByIdtitle(1);
		User user = new User(dept, title, "Dam", "123456");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
	}
	
	 @Test
	    public void find_bookId_OK() throws Exception {

	        mockMvc.perform(get("/showByIDSEARCH"))
	                /*.andDo(print())*/
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.id", is(1)))
	                .andExpect(jsonPath("$.name", is("Book Name")))
	                .andExpect(jsonPath("$.author", is("Mkyong")))
	                .andExpect(jsonPath("$.price", is(9.99)));

	        verify(userRepository, times(1)).findById(1);

	    }
	
//	@Test
//	public void testSaveGetUpdateDeleteUser() {
//		Departement dept = deptService.findByDeptid(1);
//		Title title = titleService.findByIdtitle(1);
//		user= new User(dept, title, "Dam", "123456");
//		try {
//			// Save
////			user.setIduser(1);
//			if(userService.save(user) == new User(dept,title,"Dam","123456")) {
//				
//			}
//			userService.save(user);
//			System.out.println("JUNIT Save User () with new ID "+ user.getIduser() + "with name "+ user.getUsername());
//			assertTrue(true);
//			// Find
//			userFindById = userRepository.findByIduser(1);
//			System.out.println("JUNIT Find By ID () with ID "+ user.getIduser() + " and Name " + user.getUsername());
//			assertTrue(true);
//			// Update
//			userUpdate = user;
//			userUpdate.setUsername("Test Junit Update");
//			System.out.println("JUNIT Update User () with ID "+ userUpdate.getIduser() + " \n new Username : "+ userUpdate.getUsername());
//			assertTrue(true);
//			// Delete
//			userService.delete(userUpdate.getIduser());
//			System.out.println("JUNIT Delete User done !");
//			assertTrue(true);
//		}catch(Exception e) {
//			assertTrue("#JUNIT## \n" + e.getMessage().toString(), false);
//		}
	
}

