package com.gcf.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcf.sms.bean.Company;
import com.gcf.sms.dao.CompanyMapper;
@Service
public class CompanyService {

	@Autowired
	private CompanyMapper companyMapper;
	
	public List<Company> getCompanies() {
		List<Company> companies = companyMapper.selectByExample(null);
		return companies;
	}

}
