package com.xiongyingqi.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author <a href="http://xiongyingqi.com">qi</a>
 * @version 2015-09-01 16:23
 */

public class UserControllerTest extends BaseTest{


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddUser() throws Exception {
        mockMvc.perform(
                post("/user")
                .param("name", "a")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print());
    }
}
