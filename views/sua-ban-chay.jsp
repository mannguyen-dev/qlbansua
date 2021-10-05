<%-- 
    Document   : sua-ban-chay
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="vi-VN"/>
<div id="page3" class="main">
    <div class="col1">
        <p>Danh sách sữa bán chạy</p>
        <ul>
            <c:forEach items="${dss}" var="s">
                <li><a href="trang-sua-ban-chay.jsp?maSua=${s.maSua}">${s.tenSua}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp" %>
        </div>
        <table>
            <tr>
                <td colspan="2" class="tieu-de-sua">${sua.tenSua }</td>
            </tr>
            <tr>
                <td><img src="./images/${sua.hinh}"></td>
                <td>
                    <p><b><i>Thành phần dinh dưỡng:</i></b><br>${sua.tpDinhDuong}</p>
                    <p><b><i>Lợi ích:</i></b><br>${sua.loiIch }</p>
                    <fmt:formatNumber value="${sua.donGia}" type="number" var="donGia"/>
                    <p><b><i>Trọng lượng:</i></b> ${sua.trongLuong} gr - <b><i>Đơn giá:</i></b> ${donGia} đ</p>
                </td>
            </tr>
        </table>
    </div>
</div>