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
                <div class="col-xs-12">
                    <br><br>
                    <center>
                        <br><br><br><br><br>
                        <%
                            if (request.getParameter("msg") != null) {
                        %>
                        <div style="color: red">
                            <%
                                out.print(request.getParameter("msg"));
                            %>
                        </div>
                        <% }%>
                        <img class="img-responsive" src="img/sordos.jpg">

                    </center>
                </div>
            </div>
            <footer>

            </footer>
        </div>
    </body>
</html>