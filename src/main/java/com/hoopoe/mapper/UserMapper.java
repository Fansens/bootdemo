package com.hoopoe.mapper;

import com.hoopoe.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * 用户数据库操作
 * <p>
 * Created by wildcrab on 17-3-22.
 */
@Mapper
public interface UserMapper{

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据用户id查询用户
     *
     * @param userId 用户ID
     * @return
     */
    @Select("select * from tb_user where user_id = #{userId}")
    @ResultMap("com.hoopoe.mapper.UserMapper.userMap")
    User getUserById(@Param("userId") String userId);

    /**
     * 根据用户登录名查询
     *
     * @param userLoginName 用户登录名
     * @return
     */
    @Select("select * from tb_user where user_login_name = #{loginName}")
    @ResultMap("com.hoopoe.mapper.UserMapper.userMap")
    User getUserByLogin(@Param("loginName") String userLoginName);

}
