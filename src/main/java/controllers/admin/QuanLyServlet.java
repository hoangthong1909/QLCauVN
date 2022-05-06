package controllers.admin;

import Dao.AdminDao;
import Dao.DonViQuanLyDao;
import JPAUtils.EncryptUtil;
import JPAUtils.FileUtil;
import entitys.Admin;
import entitys.DonViQuanLy;
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
@WebServlet({"/storeDonViQuanLy", "/editDonViQuanLy", "/updateDonViQuanLy", "/deleteDonViQuanLy", "/DonViQuanLy"})
public class QuanLyServlet extends HttpServlet {
    private DonViQuanLyDao dao;

    public QuanLyServlet() {
        this.dao = new DonViQuanLyDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("DonViQuanLy")) {
            this.create(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("storeDonViQuanLy")) {
            this.store(request, response);
        } else if (uri.contains("updateDonViQuanLy")) {
            this.update(request, response);
        } else if (uri.contains("editDonViQuanLy")) {
            this.edit(request, response);
        } else if (uri.contains("deleteDonViQuanLy")) {
            this.delete(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DonViQuanLy> list = this.dao.all();
        request.setAttribute("ds", list);
        request.setAttribute("view", "/views/user/create.jsp");
        request.setAttribute("view1", "/views/user/table.jsp");
        request.getRequestDispatcher("views/admin/admin.jsp").forward(request, response);
    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            DonViQuanLy before = this.dao.findByID(id);
            DonViQuanLy entity = new DonViQuanLy();
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setPassword(before.getPassword());
            entity.setStatus(before.getStatus());
            this.dao.update(entity);
            session.setAttribute("message","Cập Nhật Thành Công");
            response.sendRedirect("/DonViQuanLy");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error","Cập Nhật Thất Bại");
            response.sendRedirect("/DonViQuanLy");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            DonViQuanLy entity = this.dao.findByID(id);
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setStatus(false);
            this.dao.update(entity);
            session.setAttribute("message","Xóa Thành Công");
            response.sendRedirect("/DonViQuanLy");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error","Xóa Thất Bại");
            response.sendRedirect("/DonViQuanLy");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DonViQuanLy entity = new DonViQuanLy();
        List<DonViQuanLy> list = new ArrayList<>();
        String phone=request.getParameter("phone");
        DonViQuanLy users=this.dao.findByPhone(phone);
        String email=request.getParameter("email");
        DonViQuanLy users1=this.dao.findByEmail(email);
        try {
            if (users!=null){
                session.setAttribute("error","Số Điện Thoại Đã Tồn Tại");
                response.sendRedirect("/DonViQuanLy");
                return;
            }else {
                if (users1 != null) {
                    session.setAttribute("error", "Email Đã Tồn Tại");
                    response.sendRedirect("/DonViQuanLy");
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
                    List<DonViQuanLy> all = this.dao.all();
                    request.setAttribute("ds", all);
                    response.sendRedirect("/DonViQuanLy");
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
        DonViQuanLy entity = this.dao.findByID(id);
        request.setAttribute("user", entity);
        List<DonViQuanLy> list = this.dao.all();
        request.setAttribute("ds", list);
        request.setAttribute("view", "/views/user/edit.jsp");
        request.setAttribute("view1", "/views/user/table.jsp");
        request.getRequestDispatcher("views/admin/admin.jsp").forward(request, response);
    }
}
