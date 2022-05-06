package controllers.user;

import Dao.ChuDauTuDao;
import entitys.ChuDauTu;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
@WebServlet({"/storeChuDauTu", "/editChuDauTu", "/updateChuDauTu", "/deleteChuDauTu", "/ChuDauTu"})
public class ChuDauTuServlet extends HttpServlet {
    private ChuDauTuDao dao;

    public ChuDauTuServlet() {
        this.dao = new ChuDauTuDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("ChuDauTu")) {
            this.create(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("storeChuDauTu")) {
            this.store(request, response);
        } else if (uri.contains("updateChuDauTu")) {
            this.update(request, response);
        } else if (uri.contains("editChuDauTu")) {
            this.edit(request, response);
        } else if (uri.contains("deleteChuDauTu")) {
            this.delete(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChuDauTu> list = this.dao.all();
        request.setAttribute("ds", list);
        request.setAttribute("view", "/views/admin/chudautu/create.jsp");
        request.setAttribute("view1", "/views/admin/chudautu/table.jsp");
        request.getRequestDispatcher("views/admin/admin.jsp").forward(request, response);
    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            ChuDauTu before = this.dao.findByID(id);
            ChuDauTu entity = new ChuDauTu();
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setTrangThai(before.getTrangThai());
            this.dao.update(entity);
            session.setAttribute("message","Cập Nhật Thành Công");
            response.sendRedirect("/ChuDauTu");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error","Cập Nhật Thất Bại");
            response.sendRedirect("/ChuDauTu");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            ChuDauTu entity = this.dao.findByID(id);
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setTrangThai(false);
            this.dao.update(entity);
            session.setAttribute("message","Xóa Thành Công");
            response.sendRedirect("/ChuDauTu");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error","Xóa Thất Bại");
            response.sendRedirect("/ChuDauTu");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ChuDauTu entity = new ChuDauTu();
        String cmnd=request.getParameter("cmnd");
        String phone=request.getParameter("sdt");
        String email=request.getParameter("email");
        ChuDauTu chudautu=this.dao.findByCMND(cmnd);
        ChuDauTu chudautu1=this.dao.findByPhone(phone);
        ChuDauTu chudautu2=this.dao.findByEmail(email);
        List<ChuDauTu> list = new ArrayList<>();
        try {
            if (chudautu!=null){
                session.setAttribute("error","Số CMND Chủ Đầu Tư Đã Tồn Tại");
                if (chudautu1!=null){
                    session.setAttribute("error","Số Điện Thoại Chủ Đầu Tư Đã Tồn Tại");
                }if (chudautu2!=null){
                    session.setAttribute("error","Email Chủ Đầu Tư Đã Tồn Tại");
                }
                response.sendRedirect("/ChuDauTu");
            }else {
                BeanUtils.populate(entity, request.getParameterMap());
                entity.setTrangThai(true);
                this.dao.create(entity);
                session.setAttribute("message", "Thêm Mới Thành Công");
                list.add(entity);
                request.setAttribute("ds", list);
                List<ChuDauTu> all = this.dao.all();
                request.setAttribute("ds", all);
                response.sendRedirect("/ChuDauTu");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/ChuDauTu");
            session.setAttribute("error", "Thêm Mới Thất Bại");
        }

    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        ChuDauTu entity = this.dao.findByID(id);
        request.setAttribute("chudautu", entity);
        List<ChuDauTu> list = this.dao.all();
        request.setAttribute("ds", list);
        request.setAttribute("view", "/views/admin/chudautu/edit.jsp");
        request.setAttribute("view1", "/views/admin/chudautu/table.jsp");
        request.getRequestDispatcher("views/admin/admin.jsp").forward(request, response);
    }
}
