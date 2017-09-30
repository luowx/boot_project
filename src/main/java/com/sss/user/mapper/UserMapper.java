package com.sss.user.mapper;

import com.sss.user.entity.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/28.
 */
@Repository
public interface UserMapper {
    List<User> selectByCond(Map<String, Object> cond, RowBounds rowBounds);

    void delUserBy(Long id);

    void addUser(User user);

    void updateUser(User user);
}
