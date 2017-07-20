package com.xc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xc.model.User;
import com.xc.service.UserService;
import com.xc.service.impl.UserServiceBean;

public class Test {
	public static void main(String args[]) throws Exception {
		// String resource = "conf.xml";
		// InputStream is = Resources.getResourceAsStream(resource);
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(is);
		// SqlSession session = sessionFactory.openSession();
		// String statement = "com.xc.mapping.UserMapper.getUser";
		// User user = session.selectOne(statement,1);
		// System.out.println(user);
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("bean.xml");
		// User user = ctx.getBean("person", User.class);
		// System.out.println(user.toString());
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		UserService userServiceBean = new UserServiceBean();
		User user = new User();
		user.setId(5);
		user.setUserName("»€—“");
		user.setAge(21);
		user.setAddress("∫º÷›∫º÷›");
		userServiceBean.add(user);
	}
}
