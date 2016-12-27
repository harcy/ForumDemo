package com.sap.service;

import com.sap.BaseTest.BaseTestCase;
import com.sap.entity.User;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by I337300 on 12/26/2016.
 */

public class UserServiceTest extends BaseTestCase{

    @Autowired
    private UserService userService;

    //private Logger logger = Logger.getLogger(UserServiceTest.class);

    @Test
    public void testSelectUserById() {
        logger.info("begin execute");
        User user = userService.selectUserById(Integer.valueOf(1));
        //logger.info(user.toString());
        logger.info("end execute");
        //System.out.println(user.toString());
    }
}