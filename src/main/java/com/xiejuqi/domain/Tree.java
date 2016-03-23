package com.xiejuqi.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author guoqiushi
 *
 */
public class Tree implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6610338760905578894L;
	/**
	 * iD
	 */
	private long id;
	/**
	 * 父类ID
	 */
	private long pid;

	/**
	 * 名称
	 */
	private String text;

	/**
	 * 状态
	 */
	private String state = "closed";

	/**
	 * 是否选中
	 */
	private boolean checked = false;

	/**
	 * 子菜单
	 */
	private List<Tree> children;

	/**
	 * URL
	 */
	private String href;

	/**
	 * 排序
	 */
	private int rank;

	/**
	 * 是否是系统
	 */
	private String isSystem;

	/**
	 * 系统ID
	 */
	private long sys_id;
	
	private String code;
	
	private String describe;
	
	public Tree() {
	}

	public Tree(String text, String state) {
		this.text = text;
		this.state = state;
	}

	public Tree(long id, long pid, String text, long sys_id) {
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.sys_id = sys_id;
	}

	public Tree(long id, long pid, String text, String isSystem, long sys_id) {
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.isSystem = isSystem;
		this.sys_id = sys_id;
	}

	public Tree(String text, String state, List<Tree> children,String isSystem, long sys_id) {
		this.text = text;
		this.state = state;
		this.children = children;
		this.isSystem = isSystem;
		this.sys_id = sys_id;
	}

	public Tree(long id, long pid, String text, String isSystem, long sys_id, int rank, String href) {
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.isSystem = isSystem;
		this.sys_id = sys_id;
		this.rank = rank;
		this.href = href;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}


	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(String isSystem) {
		this.isSystem = isSystem;
	}

	public long getSys_id() {
		return sys_id;
	}

	public void setSys_id(long sys_id) {
		this.sys_id = sys_id;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

}
