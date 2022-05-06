<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<h2>
    <fmt></fmt>
</h2>
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
        <th scope="col">DRVN</th>
        <th scope="col">Liên Hệ</th>
        <th scope="col">Email</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ds}" var="admin">
        <tr>
            <td>${admin.name}</td>
            <td>${admin.phone}</td>
            <td>${admin.email}</td>
            <td>${admin.address}</td>
            <td>
                <form action="editAdmin" method="post">
                    <input type="hidden" value="${admin.id}" name="id">
                    <button class="btn btn-primary">Cập Nhật</button>
                </form>
            </td>
            <td>
                <button class="btn btn-danger" data-toggle="modal" data-target="#a${admin.id}">Xóa</button>
            </td>
            <div id="a${admin.id}" class="modal" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">Xác nhận</h3>
                            <button type="button" class="btn-close" data-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <h5>Bạn muốn xóa người dùng ${admin.name} ?</h5>
                        </div>
                        <div class="modal-footer">
                            <form action="deleteAdmin" method="post">
                                <input type="hidden" value="${admin.id}" name="id">
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
