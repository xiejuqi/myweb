package com.xiejuqi.xtream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.xiejuqi.domain.Address;
import com.xiejuqi.domain.Student;

/**
 * 
 * @Filename StudentTest2.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年2月22日 下午12:16:56
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class StudentTest2 {
	public static void main(String[] args) {
		Student student = new Student();
		Address address = new Address();
		address.setCountry("中国");
		address.setProvince("河南省");
		address.setCity("洛阳市");
		address.setDistrict("伊川县");
		student.setAddress(address);
		student.setClassName("高三一班");
		student.setAge(18);
		student.setId("100001");
		student.setName("赵宏轩");
		
		XStream xstream = new XStream();
		
		/**如果在类名上有别名的话使用这个静态方法会将完成的类名改为别名*/
//		Annotations.configureAliases(xstream, Student.class);
		
		/**效果同上*/
		xstream.aliasType("detail", Student.class);
		
		System.out.println(xstream.toXML(student));
	}
}
