package com.sk.sample.siren.account;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.sk.sample.siren.account.domain.model.Account;
import com.sk.sample.siren.account.domain.model.MemberType;
import com.sk.sample.siren.account.domain.model.MembershipLevelType;
import com.sk.sample.siren.shared.domain.Address;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AccountApplicationTest {

	@SuppressWarnings("rawtypes")
	private HttpMessageConverter mappingJackson2HttpMessageConverter;
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(converter -> converter instanceof MappingJackson2HttpMessageConverter).findAny().get();
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void addAccount() throws Exception {
		Account testAccount = new Account("karma2481", "1234", "karma2481@sk.com", "제유닛", MemberType.BUYER,
				MembershipLevelType.VIP, "010-1111-1221");
		testAccount.setAddress(new Address(00000, "성남시 분당구"));
		
		mockMvc.perform(post("/accounts")
				.content(this.toJsonString(testAccount))
				.contentType(contentType))				
				.andExpect(status().isCreated());
	}	

	@Test
	public void getAll() throws Exception {
		HttpServletResponse response = mockMvc.perform(get("/accounts")
												.contentType(contentType))
												.andExpect(status().isOk())
												.andReturn().getResponse();

		System.out.println("getAll : " + ((MockHttpServletResponse) response).getContentAsString());		
	}
	
	@Test
	public void findByNameLike() throws Exception {
		HttpServletResponse response = mockMvc.perform(get("/accounts/search/findByNameLike")
												.param("name", "김종국")
												.contentType(contentType))
												.andExpect(status().isOk())
												.andReturn().getResponse();

		System.out.println("findByNameLike : " + ((MockHttpServletResponse) response).getContentAsString());		
	}	
	
	
	@SuppressWarnings("unchecked")
	protected String toJsonString(Object obj) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(obj, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}

}