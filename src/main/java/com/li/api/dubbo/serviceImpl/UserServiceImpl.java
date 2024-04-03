package com.li.api.dubbo.serviceImpl;

import com.li.api.dubbo.model.User;
import com.li.api.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Arrays;
import java.util.List;

/**
 * @Author lijinzhou
 * @Date 2023/2/27 18:25
 * @PackageName:com.li.api.dubbo.serviceImpl
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@DubboService
public class UserServiceImpl implements UserService {

    // 模拟数据
    private static final List<User> USERS = Arrays.asList(
            new User(1, "张三"),
            new User(2, "李四")
    );

    @Override
    public User getByUserId(Integer userId) {
        for (User user : USERS) {
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return USERS;
    }
}
