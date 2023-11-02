package com.example.demonew.mapper;

import com.example.demonew.entity.Honor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface HonorMapper {
    //    @Select("select * from dept")
    List<Honor> list(String name);

    //    @Delete("delete from dept where id = #{id}")
    void deleteById(List<Integer> ids);

    //    @Insert("insert into dept (name,create_time,update_time) values (#{name},#{createTime},#{updateTime}) ")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    void insert(Honor honor);

    //    @Select("SELECT * from dept where id=(#{id})")
    Honor search(Integer id);

    //    @Update("update dept set name = #{name} where id =#{id}")
    void update(Honor honor);

}
