package com.gcf.sms.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gcf.sms.bean.AdminExample;
import com.gcf.sms.bean.SendedRec;
import com.gcf.sms.dao.AdminMapper;
import com.gcf.sms.dao.ContactsMapper;
import com.gcf.sms.dao.SendedRecMapper;

/**
 * 测试dao层的工作
 * 
 * @author gcf 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件 1、导入SpringTest模块
 *         2、@ContextConfiguration指定Spring配置文件的位置 3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {

	@Autowired
	AdminMapper adminMapper;

	@Autowired
	ContactsMapper contactsMapper;
	@Autowired
	SendedRecMapper sendedRecMapper;

	@Autowired
	SqlSession sqlSession;

	/**
	 * 测试CompanyMapper
	 */
	@Test
	public void testAdminCRUD() {

		System.out.println(adminMapper);

		// 1、插入用户成功
		/*
		 * adminMapper.insertSelective(new Admin(null, "刘星", "123456", 0,
		 * "1996-10-24", "13522558582", "山西朔州", "156156165@qq.com", 2, 3));
		 */
		// 2,修改用户成功
		/*
		 * Admin admin = new Admin(); admin.setAdminId(13);
		 * admin.setUsername("lx");
		 * adminMapper.updateByPrimaryKeySelective(admin);
		 */
		// 3查询单用户成功
		/*
		 * Admin admin = adminMapper.selectByPrimaryKey(13);
		 * System.out.println(admin);
		 */
		// 4.查询用户及所属公司出现结果：Admin [adminId=13, username=lx, userpass=123456,
		// usersex=0, userbirthday=1996-10-24, userpnum=13522558582,
		// useraddress=山西朔州, useremail=156156165@qq.com, usertype=2, cpyId=3,
		// company=com.gcf.sms.bean.Company@5a3bc7ed,
		// getCompany()=com.gcf.sms.bean.Company@5a3bc7ed, getAdminId()=13,
		// getUsername()=lx, getUserpass()=123456, getUsersex()=0,
		// getUserbirthday()=1996-10-24, getUserpnum()=13522558582,
		// getUseraddress()=山西朔州, getUseremail()=156156165@qq.com,
		// getUsertype()=2, getCpyId()=3, getClass()=class
		// com.gcf.sms.bean.Admin, hashCode()=404648734,
		// toString()=com.gcf.sms.bean.Admin@181e731e]
		/*
		 * Admin admin = adminMapper.selectByPrimaryKeyWithCpy(13);
		 * System.out.println(admin);
		 */
		// 4，删除用户成功
		AdminExample example = new AdminExample();
		example.createCriteria().andUseremailEqualTo("1234@qq.com");
		adminMapper.deleteByExample(example);
		// 5，批量插入多个用户，使用可以执行批量操作的sqlSession
		/*
		 * AdminMapper mapper = sqlSession.getMapper(AdminMapper.class); for(int
		 * i=0;i<200;i++){ mapper.insertSelective(new Admin(null, "用户"+(i+1),
		 * "123", 1, "1992-10-11", "13365234512", "北京市海淀区", "123@qq.com", 2,
		 * 3)); } System.out.println("批量添加用户完成！");
		 */
	}

	/**
	 * 测试ContactsMapper
	 */
	@Test
	public void testContactsCRUD() {
		System.out.println(contactsMapper);
		// 1,测试联系人添加成功
		/*
		 * contactsMapper.insertSelective(new Contacts(null, "刘星", 0,
		 * "1993-10-24", "13156151535","山西阳泉" ,"16465456@qq.com", 3));
		 */
		// 2,测试修改联系人成功
		/*
		 * Contacts contacts = new Contacts(); contacts.setContactId(12);
		 * contacts.setConname("lx");
		 * contactsMapper.updateByPrimaryKeySelective(contacts);
		 */
		// 3,测试查询成功
		/*
		 * Contacts contacts = contactsMapper.selectByPrimaryKey(12);
		 * System.out.println(contacts);
		 */
		/*
		 * Contacts contacts = contactsMapper.selectByPrimaryKeyWithCpy(12);
		 * System.out.println(contacts);
		 */
		// 4,测试删除联系人成功
		/* contactsMapper.deleteByPrimaryKey(11); */
	}

	/**
	 * 测试sendedRecMapper
	 */
	@Test
	public void testSendedRecCRUD() {
		System.out.println(sendedRecMapper);
		// 1，测试添加统计记录成功
		/*
		 * sendedRecMapper.insertSelective(new SendedRec(null, 2, "国庆节慰问",
		 * "给员工国庆节慰问", 3, 0, "2018-10-1", "立即发送", "国庆节快乐！", 0));
		 */
		// 2，测试查询
		/*
		 * List<SendedRec> sendedrecs =
		 * sendedRecMapper.selectByExampleWithAdmCom(null); for(SendedRec
		 * sendedRec:sendedrecs){ System.out.println(sendedRec.toString()); }
		 */
		// 3.删除
		/* sendedRecMapper.deleteByPrimaryKey(2); */
		// 测试更新
	}
}
