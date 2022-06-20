<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" session="false" %>
<%@page import="Modelo.Usuario" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">
        
        
        <div id="cover-spin"></div>
        
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"  >
            <h1 class="h2">Mis direcciones </h1>
            <div class="btn-toolbar mb-2 mb-md-0">
                <div class="btn-group me-2">
                    <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/NuevaDireccion">
                        <span data-feather="plus-circle"></span>
                        Nueva Dirección
                    </a>
                    <!--  <button type="button" class="btn btn-sm btn-outline-secondary">Compartir</button>
                     <button type="button" class="btn btn-sm btn-outline-secondary">Exportar</button>-->


                </div>
                <!--<button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                    <span data-feather="calendar"></span>
                    This week
                </button>-->
            </div>
        </div>
<div class="row">
            <div class="col-lg-11">


                <div class="d-flex justify-content-center">
                    <div class="container">

                        <table class="table">
                            <thead>
                                <tr>
                                   

                                    <th scope="col">C.P</th>
                                    <th scope="col">Calle</th>
                                    <th scope="col">Colonia</th>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                               <c:forEach  var="h" items="${direcciones}">
                                    <tr>
                                        <th scope="row">${h.getCodigoPostal()}</th>
                                        <td>${h.getCalle()}</td>
                                        <td>${h.getColonia()}</td>
                                         <td>${h.getNumero()}</td>
<!--
onclick="modeloCarrito.eliminarProd(this.id)" 
-->
                                        <td><button type="button" class="btn btn-danger" id="${h.getIdDireccion()}" onclick="modeloPerfil.eliminarDireccion(this.id)"  >X</button></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script>
         
            var path = "${pageContext.request.contextPath}";
        </script>
        <script src="${pageContext.request.contextPath}/Perfiles.js?v=3" type="text/javascript"></script>

    </jsp:attribute>
</mt:dashboard>