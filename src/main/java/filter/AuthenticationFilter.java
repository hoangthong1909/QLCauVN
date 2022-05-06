package filter;


import entitys.Admin;
import entitys.DonViQuanLy;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName="filter2",urlPatterns = {"/storeAdmin", "/editAdmin", "/updateAdmin", "/deleteAdmin", "/Admin","/storeDonViQuanLy", "/editDonViQuanLy", "/updateDonViQuanLy", "/deleteDonViQuanLy", "/DonViQuanLy"})
public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
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

    public void init(FilterConfig fConfig) throws ServletException {
    }

}