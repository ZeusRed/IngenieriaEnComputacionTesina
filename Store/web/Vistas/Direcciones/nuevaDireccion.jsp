 <%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" session="false" %>
<%@page import="Modelo.Usuario" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">


        <div id="cover-spin"></div>
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Nueva Dirección </h1>
            <div class="btn-toolbar mb-2 mb-md-0">
                <div class="btn-group me-2">
                 
                </div>
                <!--<button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                    <span data-feather="calendar"></span>
                    This week
                </button>-->
            </div>
        </div>
     <!--   <style> 
            .Perfil{


                display: block;
                width: 400px;
                height: 400px; 
                position: absolute;

                clip: rect(0px 400px 400px 10px);
            }
        </style>-->
    
 

            <div class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3" > 

                <div class="card" style="width: 45rem;">
                    <div class="row no-gutters">
                      
                        <div class="col-sm-7">
                            <div class="card-body">

                                <form  >
                                    <div class="form-group">

                                        <label for="CP">Codigo Postal</label>
                                        <input type="number" class="form-control" id="nombre" aria-describedby="emailHelp" placeholder="Codigo Postal"  data-bind="value:modeloPerfil.cpostal" >
                                   <small id="name" class="form-text text-muted ">Obligatorio</small>

                                    </div>

                                    <br>
                                    <div class="form-group">
                                        <label for="Calle">Calle</label>
                                        <input type="text" class="form-control" id="apaterno" aria-describedby="emailHelp" placeholder="Calle" data-bind="value:modeloPerfil.calle" >                            
                                        <small id="ap" class="form-text text-muted ">Obligatorio</small>

                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <label for="Colonia">Colonia</label>
                                        <input type="text" class="form-control" id="amaterno" aria-describedby="emailHelp" placeholder="Colonia" data-bind="value:modeloPerfil.colonia" >
                                              <small id="am" class="form-text text-muted ">Obligatorio</small>

                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <label for="numero">Numero </label>
                                        <input type="number" class="form-control" id="amaterno" aria-describedby="emailHelp" placeholder="Numero" value="" data-bind="value:modeloPerfil.numero" >
                                             <small id="email" class="form-text text-muted ">Obligatorio</small>

                                    </div> 
 
                                    <br>
                                    <br>
                                    <div class="d-flex justify-content-center"> 
                                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/Direcciones">
                                            <i class="bi bi-arrow-return-left"></i>
                                            Regresar
                                        </a>
                                        &nbsp;    &nbsp;
                                   
                                        <button class="btn btn-success " data-bind="click:modeloPerfil.guardarDireccion" >
                                            <span data-feather="save"></span>
                                            Guardar
                                        </button>
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

        <script src="${pageContext.request.contextPath}/Perfiles.js?v=3" type="text/javascript"></script>
    </jsp:attribute>
</mt:dashboard>
