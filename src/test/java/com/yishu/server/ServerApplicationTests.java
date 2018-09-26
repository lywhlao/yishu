package com.yishu.server;

import com.yishu.server.dao.BookPODao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

	@Autowired
	BookPODao bookPODao;

	@Test
	public void contextLoads() {

		System.out.println(bookPODao.getByIndex(2, 3));
	}

}
