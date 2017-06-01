<%-- 
    Document   : utilidades
    Created on : 30/05/2017, 02:05:30 PM
    Author     : arK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>My CRUD</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="css/creative.min.css" rel="stylesheet">

   
    </head>
    
    <body id="page-top">
         <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="/index.html">My KinderGarten</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="./index.html">Principal</a>
                    </li>
                   <li>
                        <a  href="./index.jsp">CRUD</a>
                    </li>
                    <li>
                        <a  href="./utilidades.jsp">Utilidades</a>
                    </li>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
        
        <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading">HERRAMIENTAS UTILES</h1>
                <hr>
                
                           
        <h1>LISTANDO ARREGLO!</h1>
                        
        <form action="./utilidadesServlet" method="POST">
	<input type="url" name="file">
    <input type="submit" name="action" value="listar">
    
 </form>
            <br>
            
            <table class="table table-striped table-inverse">
                <th>Children Id</th>
                <th>Name</th>
                <th>Edad</th>
                <th>Padre</th>
                <th>Madre</th>
                
                <c:forEach items="${childrensArreglo}" var="child">
                    <tr>
                        <td>${child.id}</td>
                        <td>${child.name}</td>
                        <td>${child.edad}</td>
                        <td>${child.padre}</td>
                        <td>${child.madre}</td>
                    </tr>
                </c:forEach>
           </table>
         <a href="./index.html" class="btn btn-primary btn-xl page-scroll">Volver</a>
             </div>
        </div>
    </header>
            
            <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/creative.min.js"></script>
            
    </body>
</html>
