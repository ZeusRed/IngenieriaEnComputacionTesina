<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">
        <br>
        <br>
        <h3 class="text-center">Finalizar Compra</h3>
        <hr>
        <div class="row">
            <br>
            <br>
            <div  class="row">
                <div class="col-lg-3">
                    <h4>
                        No.Tarjeta
                    </h4>   
                </div>
                <br/>
                <div class="col-lg-3">


                    <input class="form-control" type="tel" inputmode="numeric" pattern="[0-9\s]{13,19}" autocomplete="cc-number" maxlength="19" placeholder="xxxx xxxx xxxx xxxx">
                </div>
            </div>
            <br>
            <br>
            <div  class="row">
                <div class="col-lg-3">


                    <h4>
                        Dirección de envio:
                    </h4>   
                </div>

                <div class="col-lg-3">
                    <select class="form-control">
                        <option   value="1">Zacazonapan</option>
                        <option   value="1">Zacazonapan1</option>
                        <option   value="1">Zacazonapan2</option>
                        <option   value="1">Zacazonapan3</option>

                    </select>
                </div>
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
                    <a class="btn btn-success" href="${pageContext.request.contextPath}/ConfirmarCompra">


                        <i class="bi bi-aspect-ratio"></i>
                        Finalizar Compra
                    </a>





                </div>
            </div>
        </div>
    </jsp:attribute>
</mt:dashboard> 