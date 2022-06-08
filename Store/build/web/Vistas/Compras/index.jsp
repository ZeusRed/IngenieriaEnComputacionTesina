<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">

          <div id="cover-spin"></div>
        <link href="${pageContext.request.contextPath}/ProductosCard.css" rel="stylesheet" type="text/css"/>
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h3 class="text-center">Productos disponibles</h3>
           <!-- <div class="btn-toolbar mb-2 mb-md-0">
                <div class="btn-group me-2">
                    <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                </div>
                <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                    <span data-feather="calendar"></span>
                    This week
                </button>
            </div>-->
        </div>
        <div class="container">

            <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            --><script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="https://placeimg.com/1080/500/tech" alt="First slide">
                        <!--<div class="carousel-caption d-none d-md-block">
                            <h5>My Caption Title (1st Image)</h5>
                            <p>The whole caption will only show up if the screen is at least medium size.</p>
                        </div>-->
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://placeimg.com/1080/500/tech" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://placeimg.com/1080/500/tech"" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previa</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Siguiente</span>
                </a>
            </div>
        </div>
        <div class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 ">
            <h2>Dale un vistazo a los ultimos productos en nuestro catálogo.</h2>
        </div>
        <div class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3  " style="background-color: #EAEDED"> 
               <c:forEach  var="h" items="${map}">
                    <div class="row">
                        <c:forEach var="e" items="${h.value}"  >  
                            
                            <div class="col-md-4 col-sm-6">
                                <div class="card mb-30">
                                    <a class="card-img-tiles" href="#" data-abc="true">
                                        <div class="inner">
                                            <div class="main-img">
                                                <img src="data:image/webp;base64,${e.getBase64Image()}" alt="Category">
                                            </div>
                                            <div class="thumblist">
                                                <c:forEach var="f" items="${e.getGaleria()}"  >  
                                                    <img src="data:image/webp;base64,${f.getBase64Image()}" alt="Category">
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </a>
                                    <div class="card-body text-center">
                                        <h4 class="card-title"> ${e.getDescripcion()}</h4>
                                        <p class="text-muted">Desde $${e.getPrecio()}</p>
                                        <button class="btn btn-outline-primary btn-sm" id="${e.getIdProducto()}" onclick="modeloCarrito.agregar(this.id)"   data-abc="true">Comprar</button>
                                         <button class="btn btn-outline-primary btn-sm" href="#" data-abc="true" disabled><i class="bi bi-star"></i></button>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>

                    </div>    
                </c:forEach>
        </div>
        <script type="text/javascript">
            
              $(document).ready(function () {
            
             $('#cover-spin').hide(0);
        });
        </script>
             <script>
   
            var path = "${pageContext.request.contextPath}";
        </script>
       <script src="${pageContext.request.contextPath}/Compras.js?v=2" type="text/javascript"></script>
    </jsp:attribute>
</mt:dashboard>