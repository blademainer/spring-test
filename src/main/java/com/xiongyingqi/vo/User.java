package com.xiongyingqi.vo;

import com.xiongyingqi.util.EntityHelper;

/**
 * @author <a href="http://xiongyingqi.com">qi</a>
 * @version 2015-09-01 16:14
 */
public class User extends EntityHelper implements BasePojo{
    private Integer userId;
    private String userName;
    private Integer age;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        if (!super.equals(o))
            return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null)
            return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null)
            return false;
        return !(age != null ? !age.equals(user.age) : user.age != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
