<%@page import="leetexto.Leer"%>
<%@page import="com.proyecto.DTO.Cuento"%>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="es">
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
                    <% int c = 1;
                        ArrayList<Cuento> user = new ArrayList<Cuento>();
                        user = (ArrayList) request.getSession().getAttribute("Mostrar");
                    %>
                    <br><br><br><br><br>
                    <table id="simple-example-table" class="table table-hover table-condensed table-hover" >
                        <tbody>
                            <tr align="left">
                                <th>Titulo</th>
                                <th>Texto</th>
                                <th>Escuchar las frases</th>
                            </tr>
                            <% for (Cuento Mostrar : user) {%>
                            <tr>
                                <td><%out.print(Mostrar.getTitulo());%></td>
                                <td><%out.print(Mostrar.getContenido());%></td>
                                <td><a href="TextoCtrl?accion=Reproducir&texto=<%=Mostrar.getContenido()%>"><button class="btn btn-info">Reproducir</button></a></td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>


                </div>
                <div class="col-xs-4"></div>
            </div>
            <footer>

            </footer>
        </div>
    </body>
</html>