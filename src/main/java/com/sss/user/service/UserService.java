package com.sss.user.service;

import com.github.pagehelper.PageInfo;
import com.sss.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * Created by Administrator on 2017/9/28.
 */
@Service
public interface UserService {

    PageInfo<User> queryPage(Map<String, Object> map, int start, int limit);

    void delUserBy(Long id);

    void save(User user);
}
