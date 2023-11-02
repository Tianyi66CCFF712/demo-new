package com.example.demonew.mapper;

import com.example.demonew.entity.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface UserMapper {

//    public List<User> page(Integer start, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
//
//
//    public Long count();不加pagehelper的原始方式返回总记录数




    void deleteByid(List<Integer> ids);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into user(username, name, gender, image , create_time, update_time,password) values (#{username},#{name},#{gender},#{image},#{createTime},#{updateTime},#{password})")
    void add(User User);

    @Update("update user set username=#{username},name=#{name},gender=#{gender},image=#{image}, update_time=#{ updateTime},password=#{password} where id = #{id}")
    void update(User User);

    @Select("select * from user where id=#{id}")
    User search(Integer id);


    public List<User> list (String name, Integer gender, LocalDate begin,LocalDate end);
    public List<User> login (String name,String password);
}
