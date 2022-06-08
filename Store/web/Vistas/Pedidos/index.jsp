  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">
        <br>
        <br>
        <h3 class="text-center">Mis Pedidos </h3>
        <hr>
        <br>
        <br>

        <div class="row">
            <div class="col-lg-11">


                <div class="d-flex justify-content-center">
                    <div class="container">

                        <table class="table">
                            <thead>
                                <tr>
                                  <!--  <th scope="col"></th>-->
                                    <th scope="col"></th>
                                    <th scope="col">Producto</th>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col">Subtotal</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                   <!-- Repetir con las compras con un for
                               
                                  -->
                            <c:forEach  var="p" items="${pedidos}"  >
                            
                          
                                <tr>

                                    <!--<td><button type="button" class="btn" style="background-color: transparent;"><i class="bi bi-trash"></i></button></td>
                                    <td><img src="https://cdn.pixabay.com/photo/2016/10/16/16/33/dual-screen-1745705_960_720.png" alt="80" height="50" /></td>
                                    -->
                                    <td>
                                        <img src="data:image/webp;base64,${p.getBase64Image()}" alt="80" height="50" >
   
                                    </td>
                                    <td>${p.getProducto()}</td>
                                    <td>${p.getCantidad()}</td>
                                    <td>${p.getSubtotal()}</td>
                                    <td><button type="button" class="btn btn-success">Volver a comprar</button></td>
                                </tr>
                                  </c:forEach>
                             
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
</mt:dashboard>
