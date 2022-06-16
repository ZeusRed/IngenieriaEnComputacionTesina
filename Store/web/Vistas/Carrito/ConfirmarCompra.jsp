<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">
        <br>
        <br>
        <h3 class="text-center">Finalizar Compra</h3>
        <hr>
        
            <br>
            <br>
            <div  class="row">
                <div class="col-lg-2">
                    <h5>
                        No.Tarjeta:
                    </h5>   
                </div>
            
                <div class="col-lg-2">


                    <input class="form-control" type="tel" inputmode="numeric" pattern="[0-9\s]{13,19}" autocomplete="cc-number" maxlength="19" placeholder="xxxx xxxx xxxx xxxx" data-bind="value:modeloCarrito.noTarjeta">
                </div>
            
                <div class="col-lg-2">
             
                     <h5> 
                              Codigo de seguridad:
                    </h5>  
              
                </div>
                
                <div class="col-lg-1">
                 
                    <input class="form-control" type="text" inputmode="numeric" pattern="[0-3\s]{13,19}" autocomplete="cc-number" maxlength="3" placeholder="xxx" data-bind="value:modeloCarrito.codSeg">
           
                </div>
                <div class="col-lg-2">
                     <h5> 
                         Fecha de vencimiento:
                    </h5> 
                </div>
                <div class="col-lg-1">
                 
                    <input class="form-control" type="text" inputmode="numeric"  autocomplete="cc-number" maxlength="4" placeholder="xxxx" data-bind="value:modeloCarrito.fecSeg">
           
                </div>
            </div>
            <br/>
            <br/>
            <br>
            <div  class="row">
                <div class="col-lg-3">


                    <h4>
                        Dirección de envio:
                    </h4>   
                </div>

                <div class="col-lg-3">
                    <select class="form-select" id="DireccionIdSelected">
                      
                         <option value="" selected disabled hidden>Selecciona una opción</option>
                          <c:forEach  var="h" items="${direcciones}">
                               
                           
                                     <option value="${h.getIdDireccion()}">${h.getCalle()} ${h.getColonia()}  ${h.getCodigoPostal()}</option>
                                       
                               
                                </c:forEach>
                        <!--<option   value="1">Zacazonapan</option>
                        <option   value="1">Zacazonapan1</option>
                        <option   value="1">Zacazonapan2</option>
                        <option   value="1">Zacazonapan3</option>-->

                    </select>
                </div>
            </div>
        
        <br>
        <br>
        <div class="row">
            <div class="col-lg-11">

                <div class="d-flex justify-content-center">


                    <!--  <button class="btn btn-secondary" data-bind="  enable: modeloCarrito.isSaved">
                          <i class="bi bi-arrow-repeat"></i>
                          Seguir Comprando
                      </button>-->
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Carrito">


                        <i class="bi bi-arrow-repeat"></i>
                        Regresar
                    </a>
                    &nbsp;
                    &nbsp;
                    <button class="btn btn-success" onclick="modeloCarrito.confirmarCompra()"> 


                        <i class="bi bi-aspect-ratio" ></i>
                        Finalizar Compra
                    </button>





                </div>
            </div>
        </div>
                     <script>

            var path = "${pageContext.request.contextPath}";
        </script>
        <script src="${pageContext.request.contextPath}/Compras.js?v=8" type="text/javascript"></script>

    </jsp:attribute>
</mt:dashboard> 