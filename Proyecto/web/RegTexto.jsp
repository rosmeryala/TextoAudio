<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <title>Proyecto</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include  file="Menu.jsp" %>
                <div class="col-xs-3"></div>
                <div class="col-xs-6">
                    <br><br><br><br><br><br>
                    <center>
                        <%
                            if (request.getParameter("msg") != null) {
                        %>
                        <div style="color: red">
                            <%
                                out.print(request.getParameter("msg"));
                            %>
                        </div>
                        <% }%>
                        <form role="form" method="post" action="TextoCtrl">
                            <label>Titulo de mi nota</label>
                            <input type="text" class="form-control" name="Titulo">
                            <br><br>
                            <label>Contenido</label>
                            <textarea style="height: 300px;" class="form-control-n" name="Texto"></textarea>
                            <br><br><br>
                            <input type="submit" style="float: right" class= "btn btn-info" name="reg" value="Registrar">
                        </form>
                        <a href="Administrador.jsp"><button style="float: right" class="btn btn-danger">Cancelar</button></a>
                        <br><br><br><br>
                    </center>
                </div>
                <div class="col-xs-4"></div>
            </div>
            <footer>

            </footer>
        </div>
    </body>
</html>