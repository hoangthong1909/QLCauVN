package controllers.admin;

import Dao.AdminDao;
import Dao.DonViQuanLyDao;
import JPAUtils.EncryptUtil;
import entitys.Admin;
import entitys.DonViQuanLy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet({"/login","/logout"})
public class LoginServlet extends HttpServlet {
    private AdminDao adminDao;
    private DonViQuanLyDao donViQuanLyDao;

    public LoginServlet() {
        this.adminDao = new AdminDao();
        this.donViQuanLyDao = new DonViQuanLyDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("logout")) {
            this.logout(request, response);
        }
        request.setAttribute("view", "/views/account/info/login.jsp");
        request.getRequestDispatcher("/views/account/account.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        Admin admin = this.adminDao.findByEmail(email);
        DonViQuanLy quanLy = this.donViQuanLyDao.findByEmail(email);
        if (admin == null && quanLy==null) {
            session.setAttribute("error", "Tên Đăng Nhập Không Tồn Tại");
            response.sendRedirect("/login");
        } else {
            if (admin!=null){
                boolean check = EncryptUtil.check(pwd, admin.getPassword());
                if (check==true){
                    response.sendRedirect("/Admin");
                    session.setAttribute("admin", admin);
                }else {
                    // Đăng nhập thất bại
                    session.setAttribute("error", "Mật Khẩu không chính xác ");
                    response.sendRedirect("/login");
                }
            }
            if (quanLy!=null){
                boolean check2 = EncryptUtil.check(pwd, quanLy.getPassword());
                if (check2 == true && admin==null) {
                    // Đăng nhập thành công
                    response.sendRedirect("/QuanLyCau");
                    session.setAttribute("user", quanLy);
                } else {
                    // Đăng nhập thất bại
                    session.setAttribute("error", "Mật Khẩu không chính xác ");
                    response.sendRedirect("/login");
                }
            }

        }
    }
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        session.removeAttribute("user");
    }
}