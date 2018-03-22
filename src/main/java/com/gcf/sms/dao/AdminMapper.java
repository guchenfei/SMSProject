package com.gcf.sms.dao;

import com.gcf.sms.bean.Admin;
import com.gcf.sms.bean.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
	long countByExample(AdminExample example);

	int deleteByExample(AdminExample example);

	int deleteByPrimaryKey(Integer adminId);

	int insert(Admin record);

	int insertSelective(Admin record);

	List<Admin> selectByExample(AdminExample example);

	Admin selectByPrimaryKey(Integer adminId);

	List<Admin> selectByExampleWithCpy(AdminExample example);

	Admin selectByPrimaryKeyWithCpy(Integer adminId);

	int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

	int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

	int updateByPrimaryKeySelective(Admin record);

	int updateByPrimaryKey(Admin record);
}