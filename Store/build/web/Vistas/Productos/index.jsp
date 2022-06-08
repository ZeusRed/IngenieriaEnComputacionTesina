<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="Modelo.Producto" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">
        <link href="${pageContext.request.contextPath}/ProductosCard.css" rel="stylesheet" type="text/css"/>

     <div id="cover-spin"></div>

        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"  >
            <h1 class="h2">Administración de Productos </h1>
            <div class="btn-toolbar mb-2 mb-md-0">
                <div class="btn-group me-2">
                    <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/NuevoProducto">
                        <span data-feather="plus-circle"></span>
                        Nuevo Producto
                    </a>
                </div>
              
            </div>
        </div>
        <div class="row">
            <div class=col-lg-12">
                 <table id="Productos" class="table table-striped table-hover" style="width: 100%;"></table> 
            </div>
        </div>
        <br>
        <br>

        
     
        <!-- 
           <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#home" id="1">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#menu1" id="2">Menu 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#menu2" id="3">Menu 2</a>
            </li>
        </ul>

        <!-- Tab panes
        <div class="tab-content">
            <div class="tab-pane container active" id="home">
                <c:if test="${lst != null}">
                    <div class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3  " style="background-color: #EAEDED"> 



                        <c:forEach  var="h" items="${map}"  >
                            <div class="row">
                                <c:forEach var="e" items="${h.value}"  >  
                                    <p>Llego ${e.getDescripcion()}<p>
                                    <div class="col-md-4 col-sm-6">
                                        <div class="card mb-30">
                                            <a class="card-img-tiles" href="#" data-abc="true">
                                                <div class="inner">
                                                     <div class="main-img">
                                                        <img src="data:image/webp;base64,${e.getBase64Image()}" alt="Category">
                                                    </div>
                                                    <div class="thumblist">
                                                        <c:forEach var="f" items="${e.getGaleria()}"  >  
                                                            <img src="data:image/webp;base64,${f}" alt="Category">
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </a>
                                            <div class="card-body text-center">
                                                <h4 class="card-title">Laptops</h4>
                                                <p class="text-muted">Starting from $499</p><a class="btn btn-outline-primary btn-sm" href="#" data-abc="true">View Products</a>
                                            </div>
                                        </div>
                                    </div>

                                </c:forEach>

                            </div>  played 
                        </c:forEach>

                    </div>


                </c:if>
   </div>


         
            <div class="tab-pane container fade" id="menu1">b</div>
            <div class="tab-pane container fade" id="menu2">c</div>
        </div>
 -->
                     <script>
            //  var editar = '@User.IsInRole("ActivoFijo.Editar")' == 'True';
            var path = "${pageContext.request.contextPath}";
        </script>
        <script src="${pageContext.request.contextPath}/Productos.js?v=3" type="text/javascript"></script>
    </jsp:attribute>
</mt:dashboard>