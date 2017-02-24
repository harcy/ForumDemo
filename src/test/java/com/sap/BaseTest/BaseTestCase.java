package com.sap.BaseTest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * Created by I337300 on 12/27/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Conf/applicationContext-test.xml"})
public class BaseTestCase extends AbstractJUnit4SpringContextTests {

    static{
        try {
            Log4jConfigurer.initLogging("classpath:Properties/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
