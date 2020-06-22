import com.thread.threadlocal.RequestHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class HttpFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println(String.format("do filter, %d, %s", Thread.currentThread().getId(), request.getServletPath()));
        RequestHolder.add(Thread.currentThread().getId());
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
