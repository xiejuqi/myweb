package com.xiejuqi.security.service;

import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

public class DefaultSessionService implements SessionService {
	
	private SessionManager sessionManager;

	public int countOnlineUser() {
		return ((DefaultWebSessionManager) sessionManager).getSessionDAO().getActiveSessions().size();
	}
}
