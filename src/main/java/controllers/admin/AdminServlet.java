package controllers.admin;

import Dao.AdminDao;
import JPAUtils.EncryptUtil;
import JPAUtils.FileUtil;
import entitys.Admin;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
@WebServlet({"/storeAdmin", "/editAdmin", "/updateAdmin", "/deleteAdmin", "/Admin"})
public class AdminServlet extends HttpServlet {
    private AdminDao dao;

    public AdminServlet() {
        this.dao = new AdminDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("Admin")) {
            this.create(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("storeAdmin")) {
            this.store(request, response);
        } else if (uri.contains("updateAdmin")) {
            this.update(request, response);
        } else if (uri.contains("editAdmin")) {
            this.edit(request, response);
        } else if (uri.contains("deleteAdmin")) {
            this.delete(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Admin> list = this.dao.all();
        request.setAttribute("ds", list);
        request.setAttribute("view", "/views/admin/QLadmin/create.jsp");
        request.setAttribute("view1", "/views/admin/QLadmin/table.jsp");
        request.getRequestDispatcher("views/admin/admin.jsp").forward(request, response);
    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            Admin before = this.dao.findByID(id);
            Admin entity = new Admin();
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setPassword(before.getPassword());
            entity.setStatus(before.getStatus());
            this.dao.update(entity);
            session.setAttribute("message","Cập Nhật Thành Công");
            response.sendRedirect("/Admin");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error","Cập Nhật Thất Bại");
            response.sendRedirect("/Admin");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            Admin entity = this.dao.findByID(id);
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setStatus(false);
            this.dao.update(entity);
            session.setAttribute("message","Xóa Thành Công");
            response.sendRedirect("/Admin");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error","Xóa Thất Bại");
            response.sendRedirect("/Admin");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin entity = new Admin();
        List<Admin> list = new ArrayList<>();
        String phone=request.getParameter("phone");
        Admin users=this.dao.findByPhone(phone);
        String email=request.getParameter("email");
        Admin users1=this.dao.findByEmail(email);
        try {
            if (users!=null){
                session.setAttribute("error","Số Điện Thoại Đã Tồn Tại");
                response.sendRedirect("/Admin");
                return;
            }else {
                if (users1 != null) {
                    session.setAttribute("error", "Email Đã Tồn Tại");
                    response.sendRedirect("/Admin");
                    return;
                } else {
                    BeanUtils.populate(entity, request.getParameterMap());
                    String encrypted = EncryptUtil.encrypt(request.getParameter("password"));
                    entity.setStatus(true);
                    entity.setPassword(encrypted);
                    this.dao.create(entity);
                    session.setAttribute("message", "Thêm Mới Thành Công");
                    list.add(entity);
                    request.setAttribute("ds", list);
                    List<Admin> all = this.dao.all();
                    request.setAttribute("ds", all);
                    response.sendRedirect("/User");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm Mới Thất Bại");
        }

    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        Admin entity = this.dao.findByID(id);
        request.setAttribute("admin", entity);
        List<Admin> list = this.dao.all();
        request.setAttribute("ds", list);
        request.setAttribute("view", "/views/admin/QLadmin/edit.jsp");
        request.setAttribute("view1", "/views/admin/QLadmin/table.jsp");
        request.getRequestDispatcher("views/admin/admin.jsp").forward(request, response);
    }
}
