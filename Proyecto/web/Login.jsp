<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Pagina</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
        <![endif]-->
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </head>
    <body background="img/fondo.jpg">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-1"></div>
                <div class="col-md-1"></div>
                <div class="col-xs-8">
                    <div class="ingreso">
                        <div class="form-inline">
                            <center>
                                <br><br><br><br><br><br><br><br><br><br><br><br>
                                <h1 class="text-center" style="color: blue; font-family: cursive">Bienvenido ingresa para disfrutar y aprender</h1>
                                <br><br><br>
                                <%

                                    if (request.getParameter("msg") != null) {
                                %>
                                <div style="color: red">
                                    <%
                                        out.print(request.getParameter("msg"));
                                    %>
                                </div>
                                <% }%>
                                <form name="regist" method="post" action="registriUsuario">
                                    <div class="form-group">
                                        <input id="usuario" type="text" class="form-control" name="Usuario" required  title="">
                                    </div>
                                    <div class="form-group">
                                        <input id="Password1" type="password" class="form-control" name="Password" required  title="">
                                    </div> 
                                    <input type="submit" class="btn btn-default" value="Ingresar" name="Ingreso">

                                </form>
                            </center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
