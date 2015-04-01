<%@page import="leetexto.Leer"%>
<%@include file="Session.jsp" %>
<%@page import="com.proyecto.DTO.Cuento"%>
<%    Cuento Mostrar = new Cuento();
    Leer Leo = new Leer();
    String text;
//text = 
    request.getSession().setAttribute("textos", request.getParameter("texto"));
//request.getSession().setAttribute("elimi", ""+elim.EliminarPartesDto(request.getParameter("serial")));
    Leo.leerTexto("textos");
//response.sendRedirect("Mostrar.jsp");
%>
