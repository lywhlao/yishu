package com.yishu.server.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.yishu.server.model.po.BookPO;

@Mapper
public interface BookPODao {

    List<BookPO> getByIndex(@Param("beginIndex") long beginIndex,
                            @Param("endIndex") long endIndex);

    int insert(@Param("pojo") BookPO pojo);

    int insertSelective(@Param("pojo") BookPO pojo);

    int insertList(@Param("pojos") List<BookPO> pojo);

    int update(@Param("pojo") BookPO pojo);
}
