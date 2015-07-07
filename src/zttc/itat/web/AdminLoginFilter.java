package zttc.itat.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import zttc.itat.model.User;
import zttc.itat.model.UserException;

public class AdminLoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsq = (HttpServletRequest) req;
		User user = (User) hsq.getSession().getAttribute("loginUser");
		if(user.getUserType() != 1){
			/*((HttpServletResponse)resp).sendRedirect(hsq.getContextPath()+"/login");*/
			throw new UserException("您没有权限查看！请联系管理员蜀黍。。。");
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
