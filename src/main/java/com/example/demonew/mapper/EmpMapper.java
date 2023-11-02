package com.example.demonew.mapper;

import com.example.demonew.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {

//    public List<Emp> page(Integer start, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
//
//
//    public Long count();不加pagehelper的原始方式返回总记录数




    void deleteByid(List<Integer> ids);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into emp(name, image, create_time, update_time) values (#{name},#{image},#{createTime},#{updateTime})")
    void add(Emp emp);

    @Update("update emp set name=#{name},image=#{image},update_time=#{ updateTime} where id = #{id}")
    void update(Emp emp);

    @Select("select * from emp where id=#{id}")
    Emp search(Integer id);


    List<Emp> list(String name);
}
