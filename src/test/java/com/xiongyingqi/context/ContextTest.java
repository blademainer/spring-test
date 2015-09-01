package com.xiongyingqi.context;

import com.xiongyingqi.config.SpringConfig;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by qi<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2015-06-16 14:09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class})
public class ContextTest {
    @org.junit.Test
    public void testInstance() throws Exception {
        ContextInj instance = ContextInj.getInstance();
        System.out.println(instance);
        Assert.assertNotNull(instance);

    }
    @org.junit.Test
    public void testContext() throws Exception {
        ContextInj instance = ContextInj.getInstance();
        System.out.println(instance.getContext());
        Assert.assertNotNull(instance.getContext());
    }

}
