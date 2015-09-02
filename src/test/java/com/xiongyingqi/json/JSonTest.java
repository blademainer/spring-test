package com.xiongyingqi.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiongyingqi.vo.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="http://xiongyingqi.com">qi</a>
 * @version 2015-09-02 14:07
 */
public class JSonTest {
    public static final Logger logger = LoggerFactory.getLogger(JSonTest.class);

    @Test
    public void testObject() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserName("a");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(user));
        logger.error("呵呵");

    }
}
