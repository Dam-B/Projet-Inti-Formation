package fr.formation.inti;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
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
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Title;
import fr.formation.inti.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebMvcConfig.class)
public class UserWebServiceTest  {
	

	private MockMvc mockMvc;

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
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
//	@Test
//	public void testSave() throws Exception {
//		// given
//        User usr = new User();
//        usr.setAdoptions(null);
//        usr.setCentres(null);
//        usr.setDateCreation(dateCreation);
//
//        given(userService.save(usr)).willReturn();
//        // when + then
//        this.mockMvc.perform(get("/api/v1/stocks"))
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{'id': 1,'name': 'Stock 1';'price': 1}]"));
//    }
	@Test
	public void testSaveGetUpdateDeleteUser() {
		Departement dept = deptService.findByDeptid(1);
		Title title = titleService.findByIdtitle(1);
		user= new User(dept, title, "Dam", "123456");
		try {
			// Save
			user.setDateCreation(new Date());
			user.setDateFermeture(null);
			user.setDepartement(null);
			user.setIndividuals(null);
			user.setUsername("Damzer");
			user.setPassword("855462318615");
			userService.save(user);
			System.out.println("JUNIT Save User () with new ID "+ user.getIduser());
			assertTrue(true);
			// Find
			userFindById = userService.findByUsername("C_N");
			System.out.println("JUNIT Find By ID () with ID "+ userFindById.getIduser() + " and Name " + userFindById.getUsername());
			assertTrue(true);
			// Update
			userUpdate = user;
			userUpdate.setUsername("Test Junit Update");
			System.out.println("JUNIT Update User () with ID "+ userUpdate.getIduser() + " \n new Username : "+ userUpdate.getUsername());
			assertTrue(true);
			// Delete
			userService.delete(userUpdate.getIduser());
			assertTrue(true);
		}catch(Exception e) {
			assertTrue("#JUNIT## \n" + e.getMessage().toString(), false);
		}
	}
}
