<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page session="true" %>
<%
    HttpSession sesionOk = request.getSession();
    sesionOk.invalidate();
%>
<jsp:forward page="index.jsp"/>
