<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Pagina</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style-min.css" rel="stylesheet">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
        <![endif]-->

        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </head>
    <body background="img/foto_1758.jpg ">
        <!--<div class="barra"></div>-->
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-1"></div>
                <div class="col-md-1"></div>
                <div class="col-xs-8">
                    <div class="ingreso">
                        <div class="form-inline">
                            <center>
                                <form role="form" method="post" action="registriUsuario">
                                    <br><br><br><br><br><br><br><br><br><br><br>
                                    Usuario
                                    <br>
                                    <input id="usuario" name="usuario" type="text" class="form-control"  required>
                                    <br>
                                    Correo
                                    <br>
                                    <input id="usuario" name="correo" type="email" class="form-control"  required>
                                    <br>
                                    contrase�a
                                    <br>
                                    <input id="Password1" name="password" type="password" class="form-control"  required>
                                    <br>
                                    Repita la contrase�a
                                    <br>
                                    <input id="Password1" type="password" class="form-control"  required>
                                    <br><br>
                                    <input type="submit" class="btn btn-default" name="reg" value="Registrar">
                                </form>
                            </center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>