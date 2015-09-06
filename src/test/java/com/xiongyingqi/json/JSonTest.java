package com.xiongyingqi.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiongyingqi.vo.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
        user.setAge(10);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(user));
        logger.error("呵呵");

    }
    @Test
    public void testStream() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserName("a");
        user.setAge(10);
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("b");
        user2.setAge(12);

        List<User> userList = new ArrayList<User>();
        userList.add(user);
        userList.add(user2);
        int ages = userList.stream()
                .filter(x -> x.getAge() != null)
                .mapToInt(User::getAge)
                .sum();
        logger.error("age sum: {}", ages);
    }
}
