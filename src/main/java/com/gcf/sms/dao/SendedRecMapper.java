package com.gcf.sms.dao;

import com.gcf.sms.bean.SendedRec;
import com.gcf.sms.bean.SendedRecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SendedRecMapper {
    long countByExample(SendedRecExample example);

    int deleteByExample(SendedRecExample example);

    int deleteByPrimaryKey(Integer srecordId);

    int insert(SendedRec record);

    int insertSelective(SendedRec record);

    List<SendedRec> selectByExample(SendedRecExample example);

    SendedRec selectByPrimaryKey(Integer srecordId);
    
    List<SendedRec> selectByExampleWithAdmCom(SendedRecExample example);

    SendedRec selectByPrimaryKeyWithAdmCom(Integer srecordId);

    int updateByExampleSelective(@Param("record") SendedRec record, @Param("example") SendedRecExample example);

    int updateByExample(@Param("record") SendedRec record, @Param("example") SendedRecExample example);

    int updateByPrimaryKeySelective(SendedRec record);

    int updateByPrimaryKey(SendedRec record);
}