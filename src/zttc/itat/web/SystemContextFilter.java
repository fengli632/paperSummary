package zttc.itat.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import zttc.itat.model.SystemContext;

public class SystemContextFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		int pageOffset = 0;
		int pageSize = 10;
		try {
			pageOffset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (NumberFormatException e) {
		}
		try { 
			SystemContext.setOffset(pageOffset);
			SystemContext.setPageSize(pageSize);
			chain.doFilter(req, resp);
		}finally {
			SystemContext.removeOffset();
			SystemContext.removePageSize();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
