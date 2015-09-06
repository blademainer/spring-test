package com.xiongyingqi.set;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author <a href="http://xiongyingqi.com">qi</a>
 * @version 2015-09-02 17:52
 */
public class TreeSetTest {
    @Test
    public void testTreeSet() throws Exception {
        Set<String> set = new TreeSet<String>();
        set.add("a");
        set.add("b");
        set.add("1");
        System.out.println(set);
    }
}
