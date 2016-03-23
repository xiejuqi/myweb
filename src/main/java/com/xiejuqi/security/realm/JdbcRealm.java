package com.xiejuqi.security.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.xiejuqi.domain.ShiroUser;
import com.xiejuqi.service.ShiroUserService;
import com.xiejuqi.domain.Permission;
import com.xiejuqi.domain.Role;

public class JdbcRealm extends AuthorizingRealm implements Realm, InitializingBean {

	@Autowired
	private ShiroUserService shiroUserService;


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		String username = (String) super.getAvailablePrincipal(principals);
		ShiroUser user = shiroUserService.findUserByUsername(username);

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		Set<String> roles = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();

		for (Role role : user.getRoleSet()) {
			roles.add(role.getName());
			for (Permission per : role.getPermissionSet()) {
				permissions.add(per.getName());
			}
		}

		info.addRoles(roles);
		info.addStringPermissions(permissions);

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		SimpleAuthenticationInfo info = null;

		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String username = upt.getUsername();
		ShiroUser user = shiroUserService.findUserByUsername(username);

		if (user == null) {
			throw new AuthenticationException();
		}

		info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());

		return info;
	}

	// ------------------------------------------------------------------------------------------------------------


	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
	}

}
