<%--
  Created by IntelliJ IDEA.
  User: thongpro
  Date: 3/31/22
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="d-sm-flex align-items-center justify-content-between mb-4 offset-5">
    <h1 class="h3 mb-0 text-gray-800">Quản Lý Tài Khoản </h1>
</div>
<form class=" row mt-3 ms-0 pe-0" action="updateAdmin?id=${admin.id}" method="post" enctype="multipart/form-data">
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">DRVN</label>
        <input type="text" class="form-control" name="name" value="${admin.name}">
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Email</label>
        <input type="email" class="form-control" name="email" value="${admin.email}">
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Liên Hệ</label>
        <input type="tel" class="form-control" name="phone" value="${admin.phone}">
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Địa Chỉ</label>
        <input type="text" class="form-control" name="address">
    </div>
    <div class="mt-3">
        <button  class="btn btn-success">Cập Nhật</button>
        <button type="reset" class="btn btn-primary">Làm mới</button>
    </div>
</form>
<br>

