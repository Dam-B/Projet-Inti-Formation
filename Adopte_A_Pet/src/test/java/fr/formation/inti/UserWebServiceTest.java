package fr.formation.inti;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import fr.formation.inti.Iservices.IUserService;
import fr.formation.inti.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/applicationContext.xml")
public class UserWebServiceTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IUserService userService;
	
	private WebApplicationContext wac;
	@Before
	public void setUp() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	@Test
	public void testSave() throws Exception {
		// given
        User usr = new User();
        usr.setAdoptions(null);
        usr.setCentres(null);
        usr.setDateCreation(dateCreation);(new BigDecimal(1));

        given(userService.save(usr).wil;)
        // when + then
        this.mockMvc.perform(get("/api/v1/stocks"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'name': 'Stock 1';'price': 1}]"));
    }
	}
}
