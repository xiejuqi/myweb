package com.xiejuqi.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.xiejuqi.domain.Student;
import com.xiejuqi.service.TestService;
import com.xiejuqi.util.ExcelUtil;
import javax.annotation.Resource;
/**
 * 
 * @Filename StrpingUploadFilesController.java
 * 
 * @Description http://www.cnblogs.com/fjsnail/p/3491033.html 这个博客有三种上传文件的方式
 *              http://cafebabe.cn/study/2015/11/21/springmvn-export-excel/		这个博客是下载Excel文件的
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年2月2日 下午4:12:32
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
/**
 * 
 * String newStr = new String(oldStr.getBytes(), "UTF-8"); 
 * java中的String类是按照unicode进行编码的，当使用String(byte[] bytes, String encoding)构造字符串时，
 * encoding所指的是bytes中的数据是按照那种方式编码的，而不是最后产生的String是什么编码方式，换句话说，
 * 是让系统把bytes中的数据由encoding编码方式转换成unicode编码。如果不指明，bytes的编码方式将由jdk根据操作系统决定。 
 * 
 * java.net.URLEncoder.encode就是按照某种编码格式对某个字符串进行编码和解码
 * 
 * @author xiejuqi
 */
@Controller
public class StrpingUploadFilesController {
	
	@SuppressWarnings("restriction")
	@Resource
	private TestService sameInterface;

	@RequestMapping(value = "/toUploadFile.html")
	public String goUploadFilePage() {

		return "uploadFile";
	}

	/**
	 * 使用Spring自带的上传文件方式
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping(value = "/postUpload.html")
	public String postUpload(HttpServletRequest request) throws IllegalStateException, IOException {

		long startTime = System.currentTimeMillis();

		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String path = "E:/springUpload" + file.getOriginalFilename();
					// 上传
					file.transferTo(new File(path));
				}
			}
		}
		return "/success";
	}

	@RequestMapping(value = "/displayExcelFile.html")
	public String displayExcelFile(ModelMap modelMap) {

		List<Student> studentList = createStudent();
		modelMap.addAttribute("list", studentList);
		sameInterface.say();
		
		return "displayStudents";
	}

	/**
	 * 导出Excel表格
	 * @param response
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcelFile.html")
	public String exportExcelFile(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String fileName = "班级表格";

		String userAgent = request.getHeader("User-Agent");
		// 针对IE或者以IE为内核的浏览器：
		if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
			fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		} else {
			/*// 非IE浏览器的处理：
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");*/
		}

		String[] keys = { "id", "className", "age", "name" };
		String[] colums = { "id", "班级名", "年龄", "姓名" };
		List<Map<String, Object>> studentMap = createStudentMap();

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		try {
			ExcelUtil.createWorkBook(studentMap, keys, colums).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);

		// 设置response参数，可以打开下载页面
		fileName = new String((fileName + ".xls").getBytes(), "iso-8859-1");
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + fileName);
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}

	/**
	 * 构造页面展示学生数据
	 * @return
	 */
	public List<Student> createStudent() {

		List<Student> list = new ArrayList<Student>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		/** sheet名字 */
		Map<String, Object> sheetMap = new HashMap<String, Object>();

		Student s1 = new Student();
		s1.setAge(12);
		s1.setClassName("计应101");
		s1.setId("1");
		s1.setName("张三");

		Student s2 = new Student();
		s2.setAge(10);
		s2.setClassName("计应100");
		s2.setId("2");
		s2.setName("李四");

		Student s3 = new Student();
		s3.setAge(5);
		s3.setClassName("计应000");
		s3.setId("10");
		s3.setName("王五");

		Student s4 = new Student();
		s4.setAge(3);
		s4.setClassName("计应545");
		s4.setId("454");
		s4.setName("小飞");

		Student s5 = new Student();
		s5.setAge(2);
		s5.setClassName("营销1520");
		s5.setId("0");
		s5.setName("小明");

		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);

		return list;
	}

	/**
	 * 构造导出Excel表格所需要的数据
	 * @return
	 */
	public List<Map<String, Object>> createStudentMap() {

		List<Student> list = createStudent();

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		/** sheet名字 */
		Map<String, Object> sheetMap = new HashMap<String, Object>();

		sheetMap.put("sheetName", "sheet1");

		mapList.add(sheetMap);

		for (Student s : list) {
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", s.getId());
			map.put("className", s.getClassName());
			map.put("age", s.getAge());
			map.put("name", s.getName());

			mapList.add(map);
		}

		return mapList;
	}
	
	
	
	

}
