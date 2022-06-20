  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" session="false" %>

<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">
        <link href="${pageContext.request.contextPath}/ProductosCard.css" rel="stylesheet" type="text/css"/>
        <style> 
            .Perfil{


                display: block;
                width: 400px;
                height: 400px; 
                position: absolute;

                clip: rect(0px 400px 400px 10px);
            }
        </style>
        <div id="cover-spin"></div>
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Accesorios</h1>
            <div class="btn-toolbar mb-2 mb-md-0">

                <div class="btn-group me-2">
                    <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/Inicio">
                        <i class="bi bi-arrow-return-left"></i>
                        Regresar
                    </a>
                </div>
            </div>
        </div> 


        <div class="row">


            <div class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3  "> 
                <c:forEach  var="h" items="${map}"  >
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
                                        <button class="btn btn-outline-primary btn-sm" id="${e.getIdProducto()}" onclick="modeloCarrito.agregar(this.id)"  data-abc="true">Comprar</button>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>

                    </div>    
                </c:forEach>
            </div>


        </div>




        <script>
            
            var path = "${pageContext.request.contextPath}";
        </script>
        <!--<script src="${pageContext.request.contextPath}/Productos.js?v=2" type="text/javascript"></script>-->
              <script src="${pageContext.request.contextPath}/Compras.js?v=2" type="text/javascript"></script>
    </jsp:attribute>
</mt:dashboard>
