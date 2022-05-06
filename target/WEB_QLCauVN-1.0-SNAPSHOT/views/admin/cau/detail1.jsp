<%--
  Created by IntelliJ IDEA.
  User: thongpro
  Date: 3/31/22
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="d-sm-flex align-items-center justify-content-between mb-4 offset-5">
    <h1 class="h3 mb-0 text-gray-800">Chi Tiết Cầu</h1>
</div>
<form class=" row mt-3 ms-0 pe-0">
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Tên Cầu : <span style="color: red">${cau.tenCau}</span></label>
    </div>
    <c:if test="${empty cau.namXD ||
            empty cau.namHT ||
            empty cau.namKT ||
            empty cau.idChuDauTu.hoTen ||
            empty cau.tongMucDauTu||
            empty cau.taiTrongTK ||
            empty cau.idDonViThietKe.tenDonVi ||
            empty cau.idDonViThiCong.tenDonVi ||
            empty cau.idDonViGiamSat.tenDonVi}">
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Năm Xây Dựng : <span style="color: red">Chưa Cập Nhật</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Năm Hoàn Thành : <span style="color: red">Chưa Cập Nhật</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Năm Khai Thác : <span style="color: red">Chưa Cập Nhật</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Chủ Đầu Tư : <span style="color: red">Chưa Cập Nhật</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Tổng Mức Đầu Tư <span style="color: red">Chưa Cập Nhật</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Tải Trọng Thiết Kế <span style="color: red">Chưa Cập Nhật</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Đơn Vị Thiết Kế <span style="color: red">Chưa Cập Nhật</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Đơn Vị Thi Công <span style="color: red">Chưa Cập Nhật</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Đơn Vị Tư Vấn Giám Sát<span
                    style="color: red">Chưa Cập Nhật</span></label>
        </div>
    </c:if>
    <c:if test="${
            !empty cau.namXD ||
            !empty cau.namHT ||
            !empty cau.namKT ||
            !empty cau.idChuDauTu.hoTen ||
            !empty cau.tongMucDauTu||
            !empty cau.taiTrongTK ||
            !empty cau.idDonViThietKe.tenDonVi ||
            !empty cau.idDonViThiCong.tenDonVi ||
            !empty cau.idDonViGiamSat.tenDonVi}">
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Năm Xây Dựng : <span style="color: red"><fmt:formatDate value="${cau.namXD}" pattern="yyyy"/></span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Năm Hoàn Thành : <span style="color: red"><fmt:formatDate value="${cau.namHT}" pattern="yyyy"/></span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Năm Khai Thác : <span style="color: red"><fmt:formatDate value="${cau.namKT}" pattern="yyyy"/></span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Chủ Đầu Tư : <span style="color: red">${cau.idChuDauTu.hoTen}</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Tổng Mức Đầu Tư <span style="color: red"><fmt:formatNumber value="${cau.tongMucDauTu}" pattern="#,###"/> VND</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Tải Trọng Thiết Kế <span style="color: red"><fmt:formatNumber value="${cau.taiTrongTK}" pattern="#,###"/> tấn</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Đơn Vị Thiết Kế <span style="color: red">${cau.idDonViThietKe.tenDonVi}</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Đơn Vị Thi Công <span style="color: red">${cau.idDonViThiCong.tenDonVi}</span></label>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Đơn Vị Tư Vấn Giám Sát<span
                    style="color: red">${cau.idDonViGiamSat.tenDonVi}</span></label>
        </div>
    </c:if>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Đơn Vị Quản Lý<span
                style="color: red">${cau.idDonViQuanLy.name}</span></label>
    </div>
    <c:if test="${empty cau.idViTri.tenXa ||
             empty cau.idViTri.idHuyen.idTinh.tenTinh ||
             empty cau.idViTri.idHuyen.tenHuyen}">
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Vị Trí Xây Dựng<span
                    style="color: red">Chưa Cập Nhật</span></label>
        </div>
    </c:if>
    <%--            ViTri--%>
    <c:if test="${!empty cau.idViTri.tenXa ||
             !empty cau.idViTri.idHuyen.idTinh.tenTinh ||
             !empty cau.idViTri.idHuyen.tenHuyen}">
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Vị Trí Xây Dựng<span
                    style="color: red">${cau.idViTri.tenXa},${cau.idViTri.idHuyen.tenHuyen},${cau.idViTri.idHuyen.idTinh.tenTinh}</span></label>
        </div>
    </c:if>
    <%--            Quoc Lo--%>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Quốc Lộ<span
                style="color: red">${cau.idQuocLo.tenQuocLo}</span></label>
    </div>
    <%--            Tinh Trang null--%>
    <c:if test="${empty cau.idTinhTrang.tenTinhTrang}">
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Tình Trạng Cầu<span
                    style="color: red">Chưa Cập Nhật</span></label>
        </div>
    </c:if>
    <%--Tinh Trang--%>
    <c:if test="${!empty cau.idTinhTrang.tenTinhTrang}">
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Tình Trạng Cầu<span
                    style="color: red">${cau.idTinhTrang.tenTinhTrang}</span></label>
        </div>
    </c:if>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Ngày Tạo<span
                style="color: red"><fmt:formatDate value="${cau.dateCreate}" pattern="dd/MM/yyyy hh:mm:ss"/></span></label>
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Ngày Cập Nhật<span
                style="color: red"><fmt:formatDate value="${cau.dateUpdate}" pattern="dd/MM/yyyy hh:mm:ss"/></span></label>
    </div>

</form>


