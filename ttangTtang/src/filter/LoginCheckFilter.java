package filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
	private List<String> excludedUrls;

	@Override
	public void init(FilterConfig config) throws ServletException {
		String excludePattern = config.getInitParameter("excludedUrls");
		excludedUrls = Arrays.asList(excludePattern.split(","));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String path = ((HttpServletRequest) request).getServletPath();

		if (!excludedUrls.contains(path)) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpSession session = httpRequest.getSession(false);

			boolean login = false;
			if (session != null) {
				if (session.getAttribute("memberUser") != null) {
					login = true;
				}
			}
			if (login) {
				chain.doFilter(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.do");
				dispatcher.forward(request, response);
			}

		}else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
	}
}