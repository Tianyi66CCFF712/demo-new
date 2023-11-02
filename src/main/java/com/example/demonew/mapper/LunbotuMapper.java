package com.example.demonew.mapper;

import com.example.demonew.entity.Lunbotu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LunbotuMapper {

//    public List<Emp> page(Integer start, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
//
//
//    public Long count();不加pagehelper的原始方式返回总记录数

    void deleteByid(List<Integer> ids);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into lunbotu(name, image, create_time, update_time) values (#{name},#{image},#{createTime},#{updateTime})")
    void add(Lunbotu lunbotu);

    @Update("update lunbotu set name=#{name},image=#{image},update_time=#{ updateTime} where id = #{id}")
    void update(Lunbotu emp);

    @Select("select * from lunbotu where id=#{id}")
    Lunbotu search(Integer id);


    List<Lunbotu> list(String name);
}
