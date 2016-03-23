package com.xiejuqi.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename Teacher.java
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
 * @Date: 2016年1月25日 下午4:04:08
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Teacher {
	private String teacherName;
	private List<Note> notes = new ArrayList<Note>();

	public Teacher(String teacherName) {
		this.teacherName = teacherName;
	}

	public void addNote(Note note) {
		notes.add(note);
	}

	public String getTeacherName() {
		return teacherName;
	}

	public List<Note> getNotes() {
		return notes;
	}
}
