package controllers.admin;
import Dao.*;
import entitys.*;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@MultipartConfig
@WebServlet({"/QuanLyCau", "/storeCau", "/updateCau", "/deleteCau", "/editCau","/showDetailCau"})
public class CauServlet extends HttpServlet {
    private ChuDauTuDao chuDauTuDao;
    private DonViThiCongDao donViThiCongDao;
    private DonViGiamSatDao donViGiamSatDao;
    private DonViQuanLyDao donViQuanLyDao;
    private QuocLoDao quocLoDao;
    private DonViThietKeDao donViThietKeDao;
    private XaDao xaDao;
    private TinhTrangCauDao tinhTrangCauDao;
    private CauDao cauDao;
    private TinhDao tinhDao;
    private HuyenDao huyenDao;
    public CauServlet() {
        this.chuDauTuDao=new ChuDauTuDao();
        this.donViThiCongDao = new DonViThiCongDao();
        this.donViGiamSatDao=new DonViGiamSatDao();
        this.donViQuanLyDao=new DonViQuanLyDao();
        this.quocLoDao=new QuocLoDao();
        this.donViThietKeDao=new DonViThietKeDao();
        this.xaDao=new XaDao();
        this.tinhTrangCauDao=new TinhTrangCauDao();
        this.cauDao=new CauDao();
        this.tinhDao=new TinhDao();
        this.huyenDao=new HuyenDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("QuanLyCau")) {
            this.create(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("updateCau")) {
            this.update(request, response);
        } else if (uri.contains("storeCau")) {
            this.store(request, response);
        } else if (uri.contains("editCau")) {
            this.edit(request, response);
        } else if (uri.contains("deleteCau")) {
            this.delete(request, response);
        }else if (uri.contains("showDetailCau")){
            this.show(request,response);
        }

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        allList(request, response);
        request.setAttribute("view", "/views/admin/cau/create.jsp");
        request.setAttribute("view1", "/views/admin/cau/table.jsp");
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }
    protected void allList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChuDauTu> dschudautu=this.chuDauTuDao.all();
        request.setAttribute("dschudautu",dschudautu);
        List<DonViThiCong> dsdonvithicong=this.donViThiCongDao.all();
        request.setAttribute("dsdonvithicong",dsdonvithicong);
        List<DonViThietKe> dsdonvithietke=this.donViThietKeDao.all();
        request.setAttribute("dsdonvithietke",dsdonvithietke);
        List<DonViQuanLy> dsdonviquanly=this.donViQuanLyDao.all();
        request.setAttribute("dsdonviquanly",dsdonviquanly);
        List<QuocLo> dsquoclo=this.quocLoDao.all();
        request.setAttribute("dsquoclo",dsquoclo);
        List<ViTriXa> dsxa=this.xaDao.all();
        request.setAttribute("dsxa",dsxa);
        List<DonViGiamSat> dsdonvigiamsat=this.donViGiamSatDao.all();
        request.setAttribute("dsdonvigiamsat",dsdonvigiamsat);
        List<Tinh> dstinh=this.tinhDao.all();
        request.setAttribute("dstinh",dstinh);
        List<Huyen> dshuyen=this.huyenDao.all();
        request.setAttribute("dshuyen",dshuyen);
        List<TinhTrang> dstinhtrang=this.tinhTrangCauDao.all();
        request.setAttribute("dstinhtrang",dstinhtrang);
        List<Cau> list=this.cauDao.all();
        request.setAttribute("list", list);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idChu= Integer.parseInt(request.getParameter("idChu"));
        int idThietKe= Integer.parseInt(request.getParameter("idThietKe"));
        int idThiCong= Integer.parseInt(request.getParameter("idThiCong"));
        int idGiamSat= Integer.parseInt(request.getParameter("idGiamSat"));
        int idQuanLy= Integer.parseInt(request.getParameter("idQuanLy"));
        int id_vitri= Integer.parseInt(request.getParameter("id_vitri"));
        int idQL= Integer.parseInt(request.getParameter("idQL"));
        int id_tinhtrang= Integer.parseInt(request.getParameter("id_tinhtrang"));
        int idCau= Integer.parseInt(request.getParameter("id"));
        try {
            ChuDauTu chuDauTu = this.chuDauTuDao.findByID(idChu);
            DonViThietKe thietKe=this.donViThietKeDao.findByID(idThietKe);
            DonViThiCong thiCong=this.donViThiCongDao.findByID(idThiCong);
            DonViGiamSat giamSat=this.donViGiamSatDao.findByID(idGiamSat);
            DonViQuanLy quanLy=this.donViQuanLyDao.findByID(idQuanLy);
            ViTriXa xa=this.xaDao.findByID(id_vitri);
            QuocLo quocLo=this.quocLoDao.findByID(idQL);
            TinhTrang tinhTrang = this.tinhTrangCauDao.findByID(id_tinhtrang);
            Cau entity = this.cauDao.findByID(idCau);
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setIdChuDauTu(chuDauTu);
            entity.setIdDonViThietKe(thietKe);
            entity.setIdDonViThiCong(thiCong);
            entity.setIdDonViGiamSat(giamSat);
            entity.setIdDonViQuanLy(quanLy);
            entity.setIdViTri(xa);
            entity.setIdQuocLo(quocLo);
            entity.setIdTinhTrang(tinhTrang);
            entity.setDateCreate(entity.getDateCreate());
            java.util.Date t = new java.util.Date();
            entity.setDateUpdate(new Date(t.getTime()));
            entity.setIdQuocLo(quocLo);
            entity.setTrangThai(1);
            this.cauDao.update(entity);
            session.setAttribute("message", "Cập Nhật Thành Công");
            response.sendRedirect("/QuanLyCau");
        } catch (Exception e) {
            response.sendRedirect("/QuanLyCau");
            session.setAttribute("error", "Cập Nhật Thất Bại");
            e.printStackTrace();
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        try {
            Cau entity = this.cauDao.findByID(id);
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setTrangThai(0);
            this.cauDao.update(entity);
            session.setAttribute("message", "Xóa Thành Công");
            response.sendRedirect("/QuanLyCau");
        } catch (Exception e) {
            session.setAttribute("error", "Xóa Thất Bại");
            response.sendRedirect("/QuanLyCau");
            e.printStackTrace();
        }
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        Cau cau = this.cauDao.findByID(id);
        request.setAttribute("cau", cau);
        this.allList(request, response);
        request.setAttribute("view", "/views/admin/cau/edit.jsp");
        request.setAttribute("view1", "/views/admin/cau/table.jsp");
        request.getRequestDispatcher("views/admin/admin.jsp").forward(request, response);
    }
    protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.allList(request, response);
        int id= Integer.parseInt(request.getParameter("id"));
        Cau cau =this.cauDao.findByID(id);
        request.setAttribute("cau",cau);
        request.setAttribute("view", "/views/admin/cau/detail.jsp");
        request.getRequestDispatcher("views/admin/admin.jsp").forward(request, response);
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id= Integer.parseInt(request.getParameter("idQuanLy"));
        int id2= Integer.parseInt(request.getParameter("idQL"));
        Cau entity = new Cau();
        List<Cau> list = new ArrayList<>();
        try {
            DonViQuanLy donViQuanLy = this.donViQuanLyDao.findByID(id);
            QuocLo quocLo = this.quocLoDao.findByID(id2);
            BeanUtils.populate(entity, request.getParameterMap());
                entity.setTrangThai(1);
                entity.setDateCreate(new java.sql.Date(new java.util.Date().getTime()));
                java.util.Date t = new java.util.Date();
                entity.setDateUpdate(new Date(t.getTime()));
                entity.setIdDonViQuanLy(donViQuanLy);
                entity.setIdQuocLo(quocLo);
                this.cauDao.create(entity);
                session.setAttribute("message", "Thêm Mới Thành Công");
                list.add(entity);
                request.setAttribute("list", list);
                List<Cau> all = this.cauDao.all();
                request.setAttribute("list", all);
                response.sendRedirect("/QuanLyCau");
        } catch (Exception e) {
            session.setAttribute("error", "Thêm Mới Thất Bại");
            response.sendRedirect("/QuanLyCau");
            e.printStackTrace();
        }
    }
}
