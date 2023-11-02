package com.example.demonew.mapper;

import com.example.demonew.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface DeptMapper {
//    @Select("select * from dept")
    List<Dept> list(String name);

//    @Delete("delete from dept where id = #{id}")
    void deleteById(List<Integer> ids);

//    @Insert("insert into dept (name,create_time,update_time) values (#{name},#{createTime},#{updateTime}) ")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    void insert(Dept dept);

//    @Select("SELECT * from dept where id=(#{id})")
    Dept search(Integer id);

//    @Update("update dept set name = #{name} where id =#{id}")
    void update(Dept dept);

}
