package com.gcf.sms.dao;

import com.gcf.sms.bean.Sended;
import com.gcf.sms.bean.SendedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SendedMapper {
    long countByExample(SendedExample example);

    int deleteByExample(SendedExample example);

    int deleteByPrimaryKey(Integer srecordId);

    int insert(Sended record);

    int insertSelective(Sended record);

    List<Sended> selectByExample(SendedExample example);

    Sended selectByPrimaryKey(Integer srecordId);

    int updateByExampleSelective(@Param("record") Sended record, @Param("example") SendedExample example);

    int updateByExample(@Param("record") Sended record, @Param("example") SendedExample example);

    int updateByPrimaryKeySelective(Sended record);

    int updateByPrimaryKey(Sended record);
}