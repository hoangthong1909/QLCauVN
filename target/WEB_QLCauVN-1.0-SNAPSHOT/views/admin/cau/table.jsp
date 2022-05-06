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
<c:if test="${empty list}">
    <p class="alert alert-warning">
        Chưa Có Cầu Nào Cần Cập Nhật
    </p>
</c:if>
<c:if test="${!empty sessionScope.error}">
    <div class="alert alert-danger">
            ${sessionScope.error}
    </div>
    <c:remove var="error" scope="session"/>
</c:if>
<c:if test="${!empty sessionScope.message}">
    <div class="alert alert-success">
            ${sessionScope.message}
    </div>
    <c:remove var="message" scope="session"/>
</c:if>
<table class="table table-success table-striped">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Tên Cầu</th>
        <th scope="col">Đơn Vị Quản Lý</th>
        <th scope="col">Quốc Lộ</th>
        <th scope="col">Năm Xây Dựng ~ Năm Hoàn Thành</th>
        <th scope="col">Vị Trí Xây Dựng</th>
        <th scope="col">Tình Trạng Cầu</th>
        <th scope="col">Ngày Cập Nhật</th>
        <c:if test="${sessionScope.admin !=null}">
            <th></th>
        </c:if>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${list}" var="cau" varStatus="status">
        <tr>
            <td>#${status.count}</td>
            <td>${cau.tenCau}</td>
            <td>${cau.idDonViQuanLy.name}</td>
            <td>${cau.idQuocLo.tenQuocLo}</td>
            <c:if test="${empty cau.namXD || empty cau.namHT || empty cau.idViTri.tenXa || empty cau.idTinhTrang.tenTinhTrang}">
                <td style="text-align: center;color: red">Chưa Cập Nhật</td>
                <td style="color: red">Chưa Cập Nhật</td>
                <td style="color: red">Chưa Cập Nhật</td>
            </c:if>
                <%--            <%------%>
            <c:if test="${!empty cau.namXD || !empty cau.namHT || !empty cau.idViTri.tenXa || !empty cau.idTinhTrang.tenTinhTrang}">
                <td style="text-align: center"><fmt:formatDate value="${cau.namXD}" pattern="yyyy"/>-
                    <fmt:formatDate value="${cau.namHT}" pattern="yyyy"/></td>
                <td>${cau.idViTri.tenXa},${cau.idViTri.idHuyen.tenHuyen},${cau.idViTri.idHuyen.idTinh.tenTinh}</td>
                <td>${cau.idTinhTrang.tenTinhTrang}</td>
            </c:if>
            <td><fmt:formatDate value="${cau.dateUpdate}" pattern="dd/MM/yyyy hh:mm:ss"/></td>
            <td>
                <form action="/editCau" method="post">
                    <input type="hidden" value="${cau.id}" name="id">
                    <button class="btn btn-primary">Sửa</button>
                </form>
            </td>
            <c:if test="${sessionScope.admin !=null}">
                <td>
                    <button class="btn btn-danger" data-toggle="modal" data-target="#c${cau.id}">Xóa</button>
                </td>
            </c:if>
            <td>
                <form action="showDetailCau" method="post">
                    <input type="hidden" name="id" value="${cau.id}">
                    <button class="btn btn-warning">Xem Chi Tiết</button>
                </form>
            </td>
            <div id="c${cau.id}" class="modal" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">Xác nhận</h3>
                            <button type="button" class="btn-close" data-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <h5>Bạn muốn xóa Cầu ${cau.tenCau} ?</h5>
                        </div>
                        <div class="modal-footer">
                            <form action="/deleteCau" method="post">
                                <input type="hidden" value="${cau.id}" name="id">
                                <button class="btn btn-danger">Xóa</button>
                            </form>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal"
                                    aria-label="Close">Hủy
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </tr>
    </c:forEach>
    </tbody>
</table>


