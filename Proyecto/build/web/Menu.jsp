<%@include file="Session.jsp" %>    
<nav class="navbar navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->

        <div class="navbar-header">
            <a class="navbar-brand" href="Administrador.jsp"><b>Proyecto</b></a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><% out.println("Bienvenido: " + session.getAttribute("usuario"));%></a></li>

            <li><a href="TextoCtrl?accion=Mostrar">Mostrar Notas</a></li>
            <li><a href="RegTexto.jsp">Registrar tus notas</a></li>
            <li><a href="Salir.jsp">Salir</a></li>
        </ul>
    </div><!-- /.container-fluid -->
</nav>
