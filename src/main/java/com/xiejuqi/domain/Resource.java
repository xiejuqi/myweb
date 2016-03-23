package com.xiejuqi.domain;

import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @author guoqiushi
 *
 */
public class Resource extends BaseLogger{
	
	private static final long serialVersionUID = 1L;
	
	private long sp_id;
    private String sp_name;
    private long sp_parent_id;
    private long sys_id;
    private String sp_desc;
    private String href;
    private String target;
    private String sp_visible;
    private String permission;
    private String icon;
    private String sp_type;
    private String version;
    private int rank;
    
    public Resource() {
	}
    
	public Resource(long sp_id, String sp_name, long sp_parent_id, long sys_id,
			String sp_desc, String href, String permission, String version) {
		this.sp_id = sp_id;
		this.sp_name = sp_name;
		this.sp_parent_id = sp_parent_id;
		this.sys_id = sys_id;
		this.sp_desc = sp_desc;
		this.href = href;
		this.permission = permission;
		this.version = version;
	}

	public Resource(int sp_id, String sp_name, int sp_parent_id, int sys_id,
			String sp_desc, String href, String target, String sp_visible,
			String permission, String icon, String sp_type,String version,int rank) {
		
		this.sp_id = sp_id;
		this.sp_name = sp_name;
		this.sp_parent_id = sp_parent_id;
		this.sys_id = sys_id;
		this.sp_desc = sp_desc;
		this.href = href;
		this.target = target;
		this.sp_visible = sp_visible;
		this.permission = permission;
		this.icon = icon;
		this.sp_type = sp_type;
		this.version = version;
		this.rank = rank;
	}
	public void setSp_id(int sp_id) {
		this.sp_id = sp_id;
	}
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}
	public void setSp_parent_id(int sp_parent_id) {
		this.sp_parent_id = sp_parent_id;
	}
	public String getSp_desc() {
		return sp_desc;
	}
	public void setSp_desc(String sp_desc) {
		this.sp_desc = sp_desc;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getSp_visible() {
		return sp_visible;
	}
	public void setSp_visible(String sp_visible) {
		this.sp_visible = sp_visible;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSp_type() {
		return sp_type;
	}
	public void setSp_type(String sp_type) {
		this.sp_type = sp_type;
	}
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public void setSys_id(int sys_id) {
		this.sys_id = sys_id;
	}

	public long getSp_id() {
		return sp_id;
	}

	public void setSp_id(long sp_id) {
		this.sp_id = sp_id;
	}

	public long getSp_parent_id() {
		return sp_parent_id;
	}

	public void setSp_parent_id(long sp_parent_id) {
		this.sp_parent_id = sp_parent_id;
	}

	public long getSys_id() {
		return sys_id;
	}

	public void setSys_id(long sys_id) {
		this.sys_id = sys_id;
	}
     
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
