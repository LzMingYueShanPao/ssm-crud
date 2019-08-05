package com.atguigu.crud.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.atguigu.crud.bean.Employee;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
		"file:src/main/webapp/WEB-INF/springDispatcherServlet-servlet.xml"})
public class MVCTest {
	
	@Autowired
	WebApplicationContext context;//传入Spring IOC

	MockMvc mockMvc;//虚拟MVC
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//模拟请求拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
		
		MockHttpServletRequest request = result.getRequest();
		PageInfo attribute = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("当前页码："+attribute.getPageNum());
		System.out.println("总页码："+attribute.getPages());
		System.out.println("总记录数："+attribute.getTotal());
		
		List<Employee> list = attribute.getList();
		for(Employee employee : list) {
			System.out.println("id："+employee.getEmpId()+",    name："+employee.getEmpName());
		}
	}
	
}
