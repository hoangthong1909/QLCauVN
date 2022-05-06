
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="d-sm-flex align-items-center justify-content-between mb-4 offset-5">
    <h1 class="h3 mb-0 text-gray-800">Quản Lý Cầu</h1>
</div>
<form class=" row mt-3 ms-0 pe-0" action="updateCau?id=${cau.id}" method="post" >
    <c:if test="${sessionScope.admin !=null}">
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Tên Cầu</label>
        <input type="text" class="form-control" name="tenCau" value="${cau.tenCau}">
    </div>
    </c:if>
    <c:if test="${sessionScope.user !=null}">
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Tên Cầu : <span style="color: red">${cau.tenCau}</span> </label>
            <input type="hidden" d class="form-control" name="tenCau" value="${cau.tenCau}">
        </div>
        <div class="mb-3 col-6">
            <label class="form-label fw-bold">Quốc Lộ : <span style="color: red">${cau.idQuocLo.tenQuocLo}</span></label>
            <input type="hidden" class="form-control" name="idQL" value="${cau.idQuocLo.id}">
        </div>
        <input type="hidden" class="form-control" name="idQuanLy" value="${cau.idDonViQuanLy.id}">
    </c:if>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Ngày Xây Dụng </label>
        <input type="date" class="form-control" name="namXD" value="${cau.namXD}">
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Ngày Hoàn Thành</label>
        <input type="date" class="form-control" name="namHT" value="${cau.namHT}">
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Ngày Đưa Vào Khai Thác</label>
        <input type="date" class="form-control" name="namKT" value="${cau.namKT}">
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Chủ Đầu Tư</label>
        <select  class="form-select" name="idChu" >
            <c:forEach  items="${ dschudautu }" var="chu">
                <option ${cau.idChuDauTu.id==chu.id ? "selected":""} value="${ chu.id }">
                    ${ chu.hoTen}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Tổng Mức Đầu Tư</label>
        <input type="number" class="form-control" name="tongMucDauTu" value="${cau.tongMucDauTu}">
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Tải Trọng Thiết Kế</label>
        <input type="number" class="form-control" name="taiTrongTK" value="${cau.taiTrongTK}">
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Đơn Vị Thiết Kế </label>
        <select  class="form-select" name="idThietKe" >
            <c:forEach  items="${ dsdonvithietke }" var="thietke">
                <option ${cau.idDonViThietKe.id==thietke.id ? "selected":""} value="${ thietke.id }">
                        ${ thietke.tenDonVi}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Đơn Vị Thi Công </label>
        <select  class="form-select" name="idThiCong" >
            <c:forEach  items="${ dsdonvithicong }" var="thicong">
                <option ${cau.idDonViThiCong.id==thicong.id ? "selected":""} value="${ thicong.id }">
                        ${ thicong.tenDonVi}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Đơn Vị Tư Vấn Giám Sát</label>
        <select  class="form-select" name="idGiamSat" >
            <c:forEach  items="${ dsdonvigiamsat }" var="giamsat">
                <option ${cau.idDonViGiamSat.id==giamsat.id ? "selected":""} value="${ giamsat.id }">
                        ${ giamsat.tenDonVi}
                </option>
            </c:forEach>
        </select>
    </div>
<c:if test="${sessionScope.admin !=null}">
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Đơn Vị Quản Lý</label>
        <select  class="form-select" name="idQuanLy" >
            <c:forEach  items="${ dsdonviquanly }" var="ql">
                <option ${cau.idDonViQuanLy.id==ql.id ? "selected":""} value="${ ql.id }">
                    ${ ql.name}
                </option>
            </c:forEach>
        </select>
    </div>
</c:if>
    <div class="mb-3 col-2">
        <label class="form-label fw-bold">Tỉnh</label>
        <select  class="form-select" name="id_tinh" onchange="javascript:handleSelect(this)" >
            <c:forEach  items="${ dstinh }" var="tinh">
                <option ${cau.idViTri.idHuyen.idTinh.id==tinh.id ? "selected":""} ${t.id==tinh.id ? "selected":""} value="${ tinh.id }">
                    ${ tinh.tenTinh}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3 col-2">
        <label class="form-label fw-bold">Huyện</label>
        <select  class="form-select" name="id_huyen" onchange="javascript:handleSelect1(this)">
            <c:forEach  items="${ dshuyen }" var="huyen">
                <option ${cau.idViTri.idHuyen.id==huyen.id ? "selected":""} ${h.id==huyen.id ? "selected":""} value="${ huyen.id }">
                        ${ huyen.tenHuyen}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3 col-2">
        <label class="form-label fw-bold">Xã</label>
        <select  class="form-select" name="id_vitri" >
            <c:forEach  items="${ dsxa }" var="xa">
                <option ${cau.idViTri.id==xa.id ? "selected":""} value="${ xa.id }">
                        ${ xa.tenXa}
                </option>
            </c:forEach>
        </select>
    </div>
<c:if test="${sessionScope.admin !=null}">
<div class="mb-3 col-6">
        <label class="form-label fw-bold">Quốc Lộ</label>
        <select class="form-select" name="idQL" >
            <c:forEach items="${ dsquoclo }" var="quoclo">
                <option ${cau.idQuocLo.id==quoclo.id ? "selected":""}  value="${ quoclo.id }">
                        ${ quoclo.tenQuocLo}
                </option>
            </c:forEach>
        </select>
    </div>
</c:if>
    <div class="mb-3 col-6">
        <label class="form-label fw-bold">Tình Trạng Cầu</label>
        <select class="form-select" name="id_tinhtrang" >
            <c:forEach items="${ dstinhtrang }" var="tinhtrang">
                <option ${cau.idTinhTrang.id==tinhtrang.id ? "selected":""}  value="${ tinhtrang.id }">
                        ${ tinhtrang.tenTinhTrang}
                </option>
            </c:forEach>
        </select>
    </div>


    <div class="mt-3">
        <button  class="btn btn-success">Cập Nhật</button>
        <button type="reset" class="btn btn-primary">Làm Mới</button>
    </div>
</form>
<br>
<script type="text/javascript">
    function handleSelect(elm)
    {
        window.location = "/editCau?idTinh="+elm.value;
    }
    function handleSelect1(elm)
    {
        window.location = "/editCau?idH="+elm.value;
    }
</script>

