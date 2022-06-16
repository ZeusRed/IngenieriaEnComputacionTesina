<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">
        <br>
        <br>
        <h3 class="text-center">Realizar Compra</h3>
        <hr>
        <br>
        <br>
        <div  class="row">
            <div class="col-lg-3">
                <h4>
                    Nombre del cliente:
                </h4>   
            </div>
            <br/>
            <div class="col-lg-3">


                <input type="text" class="form-control" value="${detalle.getNombre()}"  disabled> 
            </div>
        </div>
        <br>

        <div  class="row">
            <div class="col-lg-3">


                <h4>
                    Correo:
                </h4>   
            </div>

            <div class="col-lg-3">
                <input type="email" class="form-control" value="${detalle.getCorreo()}" disabled> 
            </div>
        </div>
        <br>
        <br>
        <div class="row">
            <div class="col-lg-11">


                <div class="d-flex justify-content-center">
                    <div class="container">

                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col"></th>

                                    <th scope="col">Nombre</th>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col">Subtotal</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach  var="h" items="${carrito}">
                                    <tr>
                                        <th scope="row">${h.getIteracion()}</th>
                                        <td>${h.getDescripcion()}</td>
                                        <td>${h.getCantidad()}</td>
                                        <td>${h.getSubtotal()}</td>

                                        <td><button type="button" class="btn btn-danger" id="${h.getIdProducto()}" onclick="modeloCarrito.eliminarProd(this.id)" >X</button></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!--
        data-bind="click:modeloCarrito.init(), enable: modeloCarrito.isSaved"
        -->
        <br>
        <br>



        <div class="row">
            <div class="col-lg-11">

                <div class="d-flex justify-content-center">


                    <!--  <button class="btn btn-secondary" data-bind="  enable: modeloCarrito.isSaved">
                          <i class="bi bi-arrow-repeat"></i>
                          Seguir Comprando
                      </button>-->
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Compras">


                        <i class="bi bi-arrow-repeat"></i>
                        Seguir Comprando
                    </a>
                    &nbsp;
                    &nbsp;
                    <c:if test="${carrito.size() != 0 }">  
                        <a class="btn btn-success" href="${pageContext.request.contextPath}/ConfirmarCompra">


                            <i class="bi bi-aspect-ratio"></i>
                            Realizar Compra
                        </a>
                    </c:if>
                    <c:if test="${carrito.size() == 0  }">  
                        <a class="btn btn-success disabled" >


                            <i class="bi bi-aspect-ratio"></i>
                            Realizar Compra
                        </a>
                    </c:if>



                </div>
            </div>
        </div>
        <script>

            var path = "${pageContext.request.contextPath}";
        </script>
        <script src="${pageContext.request.contextPath}/Compras.js?v=8" type="text/javascript"></script>
    </jsp:attribute>
</mt:dashboard> 