package com.xiongyingqi.controller;

import com.xiongyingqi.result.ResultCode;
import com.xiongyingqi.util.EntityHelper;
import com.xiongyingqi.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author <a href="http://xiongyingqi.com">qi</a>
 * @version 2015-09-01 16:11
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultCode addUser(User user) {
        EntityHelper.print(user);
        ResultCode resultCode = new ResultCode();
        resultCode.setCode("0");
        resultCode.setMessage("ok");
        return resultCode;
    }
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultCode addUserByGet(User user) {
        EntityHelper.print(user);
        ResultCode resultCode = new ResultCode();
        resultCode.setCode("0");
        resultCode.setMessage("ok");
        return resultCode;
    }
}
