package com.xiejuqi.test;

import com.gome.util.EncryptionUtils;

/**
 * 
 * @Filename EncryCodeTest.java
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
 * @Date: 2016年3月21日 下午3:04:11
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class EncryCodeTest {
	public static void main(String[] args) {
		System.out.println("加密后字符串：" + EncryptionUtils.getEncryptionStr("0108042144482", EncryptionUtils.getEncryptionKey()));
	    System.out.println("解密后字符串：" + EncryptionUtils.getClearText("uNSCFSyqgedv4qjl+86oz9==", EncryptionUtils.getEncryptionKey()));
	}
}
