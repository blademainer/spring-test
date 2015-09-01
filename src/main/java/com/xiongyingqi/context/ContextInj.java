package com.xiongyingqi.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by qi<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2015-06-16 14:06.
 */
@Component
public class ContextInj {
    public static final Logger LOGGER = LoggerFactory.getLogger(ContextInj.class);
    @Autowired
    private Context context;

    private static ContextInj singleton;

    public ContextInj() {
        singleton = this;
    }

    public static ContextInj getInstance() {
        if (singleton == null) {
            LOGGER.error("singleton is null");
        }
        try {
            throwException();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return singleton;
    }

    public static void throwException() throws Exception{
        throw new NullPointerException();
    }

    public Context getContext() {
        return context;
    }
}
