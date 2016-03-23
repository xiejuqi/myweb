package com.xiejuqi.xtream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.xiejuqi.base.BaseLogger;
import com.xiejuqi.domain.Address;
import com.xiejuqi.domain.Note;
import com.xiejuqi.domain.Student;
import com.xiejuqi.domain.Teacher;

/**
 * 
 * @Filename XtreamTest.java
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
 * @Date: 2016年1月25日 下午3:51:23
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class XtreamTest extends BaseLogger {

	private XStream xstream = new XStream(new StaxDriver());

	public  XtreamTest() {
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
		// Java 对象转换为XML
		String xml = xstream.toXML(student);
		String s = "<com.xiejuqi.domain.Student><id>100001</id><tname>赵宏轩</tname><age>18</age><className>高三一班</className><address><country>中国</country><province>河南省</province><city>洛阳市</city><district>伊川县</district></address></com.xiejuqi.domain.Student>";
		System.out.println(formatXml(s));
		// XML转换为Object
		xstream.aliasField("tname", Student.class, "name");
		Student student1 = (Student) xstream.fromXML(s);
		System.out.println(student1);
		
		
		/**测试别名*/
		Teacher t1=new Teacher("张三");
        Note n1=new Note("笔记1","数学");
        Note n2=new Note("笔记2","语文");
        Note n3=new Note("笔记3","英语");
        t1.addNote(n1);
        t1.addNote(n2);
        t1.addNote(n3);
        
        /**将Teacher的全限定类名改为teacher，note同理*/
        xstream.alias("teacher", Teacher.class);
        xstream.alias("note", Note.class);
        
        //xstream.aliasPackage("com.zeusjava.test", "com.zeusjava.entity");
        /**将teacherName属性改为name*/
        xstream.aliasField("name", Teacher.class, "teacherName");
        
        /**隐式集合别名用来在XML中当集合将不表示根节点的时候，不显示notes根节点*/
        xstream.addImplicitCollection(Teacher.class, "notes");

        /**属性别名用来将一个XML属性序列化一个变量，将属性从节点中转移至XML中
         * <teacher>
         * 	<name>张三</name>             
         * </teacher>
		 *
         * 转变为：
         * 
         * <teacher name="张三">
         * </teacher>
         * */
        xstream.useAttributeFor(Teacher.class, "teacherName");

        String aliasXml = xstream.toXML(t1);
        System.out.println(formatXml(aliasXml));
	}

	public static String formatXml(String xml) {
		try {
			Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			Source xmlSource = new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
			StreamResult res = new StreamResult(new ByteArrayOutputStream());
			serializer.transform(xmlSource, res);
			return new String(((ByteArrayOutputStream) res.getOutputStream()).toByteArray());
		} catch (Exception e) {
			return xml;
		}
	}
	
	public static void main(String[] args) {
		new XtreamTest();
	}
}
