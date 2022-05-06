package filter;


import entitys.Admin;
import entitys.DonViQuanLy;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="filter1",urlPatterns = {"/QuanLyCau", "/storeCau", "/updateCau", "/deleteCau", "/editCau","/showDetailCau","/storeChuDauTu", "/editChuDauTu", "/updateChuDauTu", "/deleteChuDauTu", "/ChuDauTu"})
public class UserFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;
        HttpSession session = httpReq.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        DonViQuanLy user = (DonViQuanLy) session.getAttribute("user");
        if (user == null) {
            if (admin == null ) {
                httpRes.sendRedirect("/login");
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
