package com.wallet.controller;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder; 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.dto.UserDTO;
import com.wallet.entity.User;
import com.wallet.service.UserService;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {

	private static final String EMAIL="email@email.com";
	private static final String NAME="User Teste";
	private static final String PASSWORD ="123456";
	private static final String URL ="/user";
	private static final Long ID =1L;
	@MockBean
	UserService service;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	public void testsave() throws Exception {
		
		BDDMockito.given(service.save(Mockito.any(User.class))).willReturn(getMockUser());
		
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad(ID,EMAIL,NAME,PASSWORD))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))	
				.andExpect(status().isCreated())
				.andExpect(jasonPath("$.data.id").value(ID))
				.andExpect(jasonPath("$.data.email").value(EMAIL))
				.andExpect(jasonPath("$.data.name").value(NAME))
				.andExpect(jasonPath("$.data.password").doesNotExists()));

		
		
	}
	@Test
	public void testeSaveInvaldUser() {
		
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad(ID,"email",NAME,PASSWORD))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))	
				.andExpect(status().isBadRequest())
				.andExpect(jasonPath("$.erros").value("E-mail Invalido"));
		
	}
	
	private Object jasonPath(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getMockUser() {
	User u= new User();
	u.setid(ID);
	u.setemail(EMAIL);
	u.setnome(NAME);
	u.setpassword(PASSWORD);
	
	return u;
	}
	
	public String getJsonPayLoad(Long id, String name,String email,String password) throws JsonProcessingException {
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setEmail(email);
		dto.setName(name);
		dto.setPassword(password);
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(dto);
		
	}
	
	
}
