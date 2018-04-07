package com.gcf.sms.dao;

import com.gcf.sms.bean.FestivalTemp;
import com.gcf.sms.bean.FestivalTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FestivalTempMapper {
    long countByExample(FestivalTempExample example);

    int deleteByExample(FestivalTempExample example);

    int deleteByPrimaryKey(Integer festivalId);

    int insert(FestivalTemp record);

    int insertSelective(FestivalTemp record);

    List<FestivalTemp> selectByExample(FestivalTempExample example);

    FestivalTemp selectByPrimaryKey(Integer festivalId);

    int updateByExampleSelective(@Param("record") FestivalTemp record, @Param("example") FestivalTempExample example);

    int updateByExample(@Param("record") FestivalTemp record, @Param("example") FestivalTempExample example);

    int updateByPrimaryKeySelective(FestivalTemp record);

    int updateByPrimaryKey(FestivalTemp record);
}