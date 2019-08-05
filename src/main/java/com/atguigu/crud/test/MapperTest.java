package com.atguigu.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private SqlSession SqlSession;
	
	@Test
	public void testCRUD() {
		
//		EmployeeMapper mapper = SqlSession.getMapper(EmployeeMapper.class);
//		for(int i = 0; i < 1000; i++) {
//			String uuid = UUID.randomUUID().toString().substring(0, 8);
//			mapper.insertSelective(new Employee(null, uuid, "m", uuid+"@yuange.com", 2));
//		}
		
//		Department department = new Department();
//		department.setDeptId(1);
//		department.setDeptName("苍井空部门");
//		department.setDeptName("开发部");
//		
		departmentMapper.insertSelective(new Department(null, "经理部"));
		
//		employeeMapper.insertSelective(new Employee(null, "苍老师", "0", "cang@yuange.com", 1));
//		employeeMapper.insertSelective(new Employee(null, "砖石态", "1", "laji@yuange.com", 1));
	}

}
