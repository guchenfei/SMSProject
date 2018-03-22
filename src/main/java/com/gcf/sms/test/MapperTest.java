package com.gcf.sms.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gcf.sms.bean.Admin;
import com.gcf.sms.bean.Company;
import com.gcf.sms.bean.Contacts;
import com.gcf.sms.dao.AdminMapper;
import com.gcf.sms.dao.CompanyMapper;
import com.gcf.sms.dao.ContactsMapper;



/**
 * 测试dao层的工作
 * @author gcf
 *推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位置
 *3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	ContactsMapper contactsMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试CompanyMapper
	 */
	@Test
	public void testAdminCRUD(){
		
		System.out.println(adminMapper);
		
		//1、插入用户成功
		/*adminMapper.insertSelective(new Admin(null, "刘星", "123456", 0, "1996-10-24", "13522558582", "山西朔州", "156156165@qq.com", 2, 3));*/
		//2,修改用户成功
		/*Admin admin = new Admin();
		admin.setAdminId(13);
		admin.setUsername("lx");
		adminMapper.updateByPrimaryKeySelective(admin);*/
		//3查询单用户成功
		/*Admin admin = adminMapper.selectByPrimaryKey(13);
		System.out.println(admin);*/
		//4.查询用户及所属公司出现结果：Admin [adminId=13, username=lx, userpass=123456, usersex=0, userbirthday=1996-10-24, userpnum=13522558582, useraddress=山西朔州, useremail=156156165@qq.com, usertype=2, cpyId=3, company=com.gcf.sms.bean.Company@5a3bc7ed, getCompany()=com.gcf.sms.bean.Company@5a3bc7ed, getAdminId()=13, getUsername()=lx, getUserpass()=123456, getUsersex()=0, getUserbirthday()=1996-10-24, getUserpnum()=13522558582, getUseraddress()=山西朔州, getUseremail()=156156165@qq.com, getUsertype()=2, getCpyId()=3, getClass()=class com.gcf.sms.bean.Admin, hashCode()=404648734, toString()=com.gcf.sms.bean.Admin@181e731e]
		/*Admin admin = adminMapper.selectByPrimaryKeyWithCpy(13);
		System.out.println(admin);*/
		//4，删除用户成功
		/*adminMapper.deleteByPrimaryKey(12);*/
	}
	/**
	 * 测试ContactsMapper
	 */
	@Test
	public void testContactsCRUD() {
		System.out.println(contactsMapper);
		//1,测试联系人添加成功
		/*contactsMapper.insertSelective(new Contacts(null, "刘星", 0, "1993-10-24", "13156151535","山西阳泉" ,"16465456@qq.com", 3));*/
		//2,测试修改联系人成功
		/*Contacts contacts = new Contacts();
		contacts.setContactId(12);
		contacts.setConname("lx");
		contactsMapper.updateByPrimaryKeySelective(contacts);*/
		//3,测试查询成功
		/*Contacts contacts = contactsMapper.selectByPrimaryKey(12);
		System.out.println(contacts);*/
		/*Contacts contacts = contactsMapper.selectByPrimaryKeyWithCpy(12);
		System.out.println(contacts);*/
		//4,测试删除联系人成功
		contactsMapper.deleteByPrimaryKey(11);
	}

}
