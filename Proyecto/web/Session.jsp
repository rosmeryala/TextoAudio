<%
    int rol = 0;
    String rolId = "";
    String User = "";
    HttpSession sesionOk = request.getSession();
    if (sesionOk.getAttribute("usuario") == null) {

        response.sendRedirect("../Proyecto/Login.jsp?msg= Es necesario identificarse");
    } else {
        sesionOk.getAttribute("usuario");
        sesionOk.getAttribute("correo");
        rolId = "" + sesionOk.getAttribute("id");
        User = "" + sesionOk.getAttribute("usuario");
        rol = Integer.parseInt(rolId);
    }

    /*HttpSession sesion=request.getSession();
     out.println("nombreUsuario:" + sesion.getAttribute("usuario"));
     out.println("IdSesion:"+sesion.getId());*/
%>