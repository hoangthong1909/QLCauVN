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
<div class="row">
    <div class="col-2 offset-1"></div>
<div class="pull-right offset-11 pe-0 mb-1">
    <a class="btn btn-primary" href="/QuanLyCau">Trở Về</a>
</div>
</div>
<table class="table table-success table-striped table-responsive-sm">
    <thead>
    <tr>
        <th scope="col">Tên Cầu</th>
        <th scope="col">Năm Xây Dựng</th>
        <th scope="col">Năm Hoàn Thành</th>
        <th scope="col">Năm Khai Thác</th>
        <th scope="col">Chủ Đầu Tư</th>
        <th scope="col">Tổng Mức Đầu Tư</th>
        <th scope="col">Tải Trọng Thiết Kế</th>
        <th scope="col">Đơn Vị Thiết Kế</th>
        <th scope="col">Đơn Vị Thi Công</th>
        <th scope="col">Đơn Vị Tư Vấn Giám Sát</th>
        <th scope="col">Đơn Vị Quản Lý</th>
        <th scope="col">Vị Trí Xây Dựng</th>
        <th scope="col">Quốc Lộ</th>
        <th scope="col">Tình Trạng Cầu</th>
        <th scope="col">Ngày Tạo</th>
        <th scope="col">Ngày Cập Nhật</th>

    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${cau.tenCau}</td>
<%--            Check null--%>
            <c:if test="${empty cau.namXD ||
            empty cau.namHT ||
            empty cau.namKT ||
            empty cau.idChuDauTu.hoTen ||
            empty cau.tongMucDauTu||
            empty cau.taiTrongTK ||
            empty cau.idDonViThietKe.tenDonVi ||
            empty cau.idDonViThiCong.tenDonVi ||
            empty cau.idDonViGiamSat.tenDonVi}">
                <td style="color: red">Chưa Cập Nhật</td>
                <td style="color: red">Chưa Cập Nhật</td>
                <td style="color: red">Chưa Cập Nhật</td>
                <td style="color: red">Chưa Cập Nhật</td>
                <td style="color: red">Chưa Cập Nhật</td>
                <td style="color: red">Chưa Cập Nhật</td>
                <td style="color: red">Chưa Cập Nhật</td>
                <td style="color: red">Chưa Cập Nhật</td>
                <td style="color: red">Chưa Cập Nhật</td>
            </c:if>
<%--            Check--%>
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
                <td><fmt:formatDate value="${cau.namXD}" pattern="yyyy"/></td>
                <td><fmt:formatDate value="${cau.namHT}" pattern="yyyy"/></td>
                <td><fmt:formatDate value="${cau.namKT}" pattern="yyyy"/></td>
                <td>${cau.idChuDauTu.hoTen}</td>
                <td><fmt:formatNumber value="${cau.tongMucDauTu}" pattern="#,###"/> VND</td>
                <td><fmt:formatNumber value="${cau.taiTrongTK}" pattern="#,###"/> tấn</td>
                <td>${cau.idDonViThietKe.tenDonVi}</td>
                <td>${cau.idDonViThiCong.tenDonVi}</td>
                <td>${cau.idDonViGiamSat.tenDonVi}</td>
            </c:if>
<%--            DonVi--%>
            <td>${cau.idDonViQuanLy.name}</td>
<%--            Vi Tri Null--%>
            <c:if test="${empty cau.idViTri.tenXa ||
             empty cau.idViTri.idHuyen.idTinh.tenTinh ||
             empty cau.idViTri.idHuyen.tenHuyen}">
                <td style="color: red">Chưa Cập Nhật</td>
            </c:if>
<%--            ViTri--%>
            <c:if test="${!empty cau.idViTri.tenXa ||
             !empty cau.idViTri.idHuyen.idTinh.tenTinh ||
             !empty cau.idViTri.idHuyen.tenHuyen}">
                <td>${cau.idViTri.tenXa},${cau.idViTri.idHuyen.tenHuyen},${cau.idViTri.idHuyen.idTinh.tenTinh}</td>
            </c:if>
<%--            Quoc Lo--%>
            <td>${cau.idQuocLo.tenQuocLo}</td>

<%--            Tinh Trang null--%>
            <c:if test="${empty cau.idTinhTrang.tenTinhTrang}">
                <td style="color: red">Chưa Cập Nhật</td>
            </c:if>
            <%--Tinh Trang--%>
            <c:if test="${!empty cau.idTinhTrang.tenTinhTrang}">
                <td>${cau.idTinhTrang.tenTinhTrang}</td>
            </c:if>

            <td><fmt:formatDate value="${cau.dateCreate}" pattern="dd/MM/yyyy hh:mm:ss"/></td>
            <td><fmt:formatDate value="${cau.dateUpdate}" pattern="dd/MM/yyyy hh:mm:ss"/></td>

        </tr>
    </tbody>
</table>


