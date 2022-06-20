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
            <h1 class="h2">Administración de Productos/Nuevo </h1>
            <div class="btn-toolbar mb-2 mb-md-0">
                <div class="btn-group me-2">

                </div>
                <div class="btn-group me-2">
                    <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/Productos">
                        <i class="bi bi-arrow-return-left"></i>
                        Regresar
                    </a>
                </div>
            </div>
        </div>





        <div class="row">
            <div class="col-lg-4">


                <div class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3  "> 

                    <div class="card" style="width: 30rem">


                        <div class="card-body">



                            <div class="form-group">
                                <!--  <label for="Nombre">Descripción</label>-->
                                <h3>Descripción</h3>
                                <input type="text" class="form-control"   placeholder="Descripcion" value="" id="desc" data-bind="value:modeloProd.descripcion"    >
                                <!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                            </div>
                            <br>
                            <div class="form-group">
                                <!--  <label for="Nombre">Precio</label>-->
                                <h3>Precio</h3>
                                <input type="number" class="form-control"   placeholder="Precio" value=""  id="precio" data-bind="value:modeloProd.precio"  >
                                <!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                            </div>
                            <br>
                            <div class="form-group">
                                <h3>Tipo de Producto</h3>
                                <select class="form-select" id="tipo" aria-label="Default select example" data-bind="value:modeloProd.tipo">
                                    <option value="0" selected>Selecciona</option>
                                    <c:if test="${tipos != null}">
                                        <c:forEach var="f" items="${tipos}" varStatus="loop">  


                                            <option value="${f.getId()}">${f.getDescripcion()}</option>


                                        </c:forEach> 
                                    </c:if>
                                </select>
                            </div>
                            <br>
                            <div class="form-group">
                                <!-- <label for="Nombre">Existencia</label>-->
                                <h3>Existencia</h3>
                                <input id="existencia" name="existencia"  type="number"  min="1"  step="1" onkeydown="if (event.key === '.') {
                                            event.preventDefault();
                                        }"  oninput="event.target.value = event.target.value.replace(/[^0-9]*/g,'');" class="form-control" 
                                                placeholder="Existencia" value="" data-bind="value:modeloProd.existencia"  >
                                <!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                            </div>
                            <br>

                            <br>
                            <div class="form-group">
                                <button class="btn btn-sm btn-outline-secondary" data-bind="click:modeloProd.guardar(true), enable: modeloProd.isSaved">
                                    <i class="bi bi-bookmark-check"></i>
                                    Guardar
                                </button>
                            </div> 

                            <br>

                            <br>
                            <br>

                        </div> 

                    </div>
                </div>
            </div>

            <div class="col-lg-8"   id="imagenes" style="display:none;">
                <div class="container">
                    <div class="row">


                        <div class="col-sm">
                            <form id="upload-form" class="upload-box" action="${pageContext.request.contextPath}/EditarProductoSet" method="post" enctype="multipart/form-data">

                                <div class="col-md-12 col-sm-12">

                                    <div class="card mb-30">
                                        <a class="card-img-tiles" href="#" data-abc="true">
                                            <div class="inner">
                                                <div class="main-img">
                                                    <img src="https://dummyimage.com/600x400/000/fff" alt="Category" id="x0" />  
                                                </div>

                                            </div>
                                        </a>

                                        <div class="card-body text-center">

                                            <label class="btn btn-success" >
                                                <i class="bi bi-arrow-clockwise"></i>
                                                Cambiar Imagen 
                                                <input type="file" id="0" name="0" onchange="modeloProd.getFileImage(this);" hidden />

                                            </label>
                                        </div>
                                        <!-- <input class="button btn" id="upload-button" value="upload" data-bind="click:modeloProd.actualizarGaleria()" />-->

                                    </div>   
                                </div>
                            </form>
                        </div>


                        <div class="col-sm">
                            <form id="upload-form" class="upload-box" action="${pageContext.request.contextPath}/EditarProductoSet" method="post" enctype="multipart/form-data">
                                <div class="col-md-12 col-sm-12">

                                    <div class="card mb-30">
                                        <a class="card-img-tiles" href="#" data-abc="true">
                                            <div class="inner">
                                                <div class="main-img">
                                                    <img src="https://dummyimage.com/600x400/000/fff" alt="Category" id="x0" class="imgsServer">
                                                </div>

                                            </div>
                                        </a>
                                        <div class="card-body text-center">

                                            <label class="btn btn-success" >
                                                <i class="bi bi-arrow-clockwise"></i>
                                                Cambiar Imagen <input type="file" id="0"  name="0" onchange="modeloProd.getFileImage(this);" hidden>
                                            </label>
                                        </div>
                                    </div>  
                                </div>
                            </form>
                        </div> 

                        <div class="col-sm">
                            <form id="upload-form" class="upload-box" action="${pageContext.request.contextPath}/EditarProductoSet" method="post" enctype="multipart/form-data">
                                <div class="col-md-12 col-sm-12">

                                    <div class="card mb-30">
                                        <a class="card-img-tiles" href="#" data-abc="true">
                                            <div class="inner">
                                                <div class="main-img">
                                                    <img src="https://dummyimage.com/600x400/000/fff" alt="Category" id="x0" class="imgsServer">
                                                </div>

                                            </div>
                                        </a>
                                        <div class="card-body text-center">

                                            <label class="btn btn-success" >
                                                <i class="bi bi-arrow-clockwise"></i>
                                                Cambiar Imagen <input type="file" id="0"  name="0" onchange="modeloProd.getFileImage(this);" hidden>
                                            </label>
                                        </div>
                                    </div>  
                                </div>
                            </form>
                        </div> 
                        <div class="col-sm">
                            <form id="upload-form" class="upload-box" action="${pageContext.request.contextPath}/EditarProductoSet" method="post" enctype="multipart/form-data">
                                <div class="col-md-12 col-sm-12">

                                    <div class="card mb-30">
                                        <a class="card-img-tiles" href="#" data-abc="true">
                                            <div class="inner">
                                                <div class="main-img">
                                                    <img src="https://dummyimage.com/600x400/000/fff" alt="Category" id="x0" class="imgsServer">
                                                </div>

                                            </div>
                                        </a>
                                        <div class="card-body text-center">

                                            <label class="btn btn-success" >
                                                <i class="bi bi-arrow-clockwise"></i>
                                                Cambiar Imagen <input type="file" id="0"  name="0" onchange="modeloProd.getFileImage(this);" hidden>
                                            </label>
                                        </div>
                                    </div>  
                                </div>
                            </form>
                        </div> 

                    </div>
                </div>

            </div>
        </div>


       <script>

            var path = "${pageContext.request.contextPath}";
        </script>
        <script src="${pageContext.request.contextPath}/Productos.js?v=12" type="text/javascript"></script>

    </jsp:attribute>
</mt:dashboard>
