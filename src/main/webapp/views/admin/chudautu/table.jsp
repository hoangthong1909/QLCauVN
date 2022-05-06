<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<c:if test="${empty ds}">
    <p class="alert alert-warning">
        Vui Lòng Thêm Mới Dữ Liệu
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
        <th scope="col">Số CMND</th>
        <th scope="col">Họ Tên Chủ Đầu Tư</th>
        <th scope="col">Giới Tính</th>
        <th scope="col">Điện Thoại</th>
        <th scope="col">Email</th>
        <th scope="col">Địa Chỉ</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ds}" var="chudautu" varStatus="status">
        <tr>
            <td>#${status.count}</td>
            <td>${chudautu.cmnd}</td>
            <td>${chudautu.hoTen}</td>
            <td>
                <c:choose>
                    <c:when test="${chudautu.gioiTinh==true}">Nam</c:when>
                    <c:when test="${chudautu.gioiTinh==false}">Nữ</c:when>
                    <c:otherwise>-</c:otherwise>
                </c:choose>
            </td>
            <td>${chudautu.sdt}</td>
            <td>${chudautu.email}</td>
            <td>${chudautu.diaChi}</td>

            <td>
                <form action="editChuDauTu" method="post">
                    <input type="hidden" value="${chudautu.id}" name="id">
                    <button class="btn btn-primary">Cập Nhật</button>
                </form>
            </td>
            <td>
                <button class="btn btn-danger" data-toggle="modal" data-target="#a${chudautu.id}">Xóa</button>
            </td>
            <div id="a${chudautu.id}" class="modal" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">Xác nhận</h3>
                            <button type="button" class="btn-close" data-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <h5>Bạn muốn xóa Chủ Đầu Tư ${chudautu.hoTen} ?</h5>
                        </div>
                        <div class="modal-footer">
                            <form action="deleteChuDauTu" method="post">
                                <input type="hidden" value="${chudautu.id}" name="id">
                                <button class="btn btn-danger">Xóa</button>
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
