package com.shuai.service.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description Created by min on 2017/10/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext-*.xml")

public class SensitiveWordBaseServiceImplTest {
    @Autowired
    private SensitiveWordBaseService sensitiveWordBaseService;

    @Test
    public void init() {

    }
}