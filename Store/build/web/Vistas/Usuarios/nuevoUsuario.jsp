<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" session="false" %>
<%@page import="Modelo.Usuario" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">


        <div id="cover-spin"></div>
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Administración de Usuarios/Nuevo </h1>
            <div class="btn-toolbar mb-2 mb-md-0">
                <div class="btn-group me-2">
                   <!-- <button type="button" class="btn btn-sm btn-outline-secondary">Compartir</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">Exportar</button>-->
                </div>
                <!--<button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                    <span data-feather="calendar"></span>
                    This week
                </button>-->
            </div>
        </div>
        <style> 
            .Perfil{


                display: block;
                width: 400px;
                height: 400px; 
                position: absolute;

                clip: rect(0px 400px 400px 10px);
            }
        </style>
    
 

            <div class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3" > 

                <div class="card" style="width: 45rem;">
                    <div class="row no-gutters">
                        <div class="col-sm-5">

                            <img class="card-img" src="${pageContext.request.contextPath}/blank-profile-picture-g99e282e05_1280.png" alt=""/>
                        </div>
                        <div class="col-sm-7">
                            <div class="card-body">

                                <form  >
                                    <div class="form-group">

                                        <label for="Nombre">Nombre</label>
                                        <input type="text" class="form-control" id="nombre" aria-describedby="emailHelp" placeholder="Nombre"  data-bind="value:nombre" >
                                   <small id="name" class="form-text text-muted ">Obligatorio</small>

                                    </div>

                                    <br>
                                    <div class="form-group">
                                        <label for="Nombre">Apellido Paterno</label>
                                        <input type="text" class="form-control" id="apaterno" aria-describedby="emailHelp" placeholder="Apellido Paterno" data-bind="value:ap" >                            
                                        <small id="ap" class="form-text text-muted ">Obligatorio</small>

                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <label for="Nombre">Apellido Materno</label>
                                        <input type="text" class="form-control" id="amaterno" aria-describedby="emailHelp" placeholder="Apellido Materno" data-bind="value:am" >
                                              <small id="am" class="form-text text-muted ">Obligatorio</small>

                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <label for="Nombre">Correo</label>
                                        <input type="email" class="form-control" id="amaterno" aria-describedby="emailHelp" placeholder="Correo" value="" data-bind="value:correo" >
                                             <small id="email" class="form-text text-muted ">Obligatorio</small>

                                    </div> 
 
                                    <br>
                                    <br>
                                    <div class="d-flex justify-content-center"> 
                                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/Usuarios">
                                            <i class="bi bi-arrow-return-left"></i>
                                            Regresar
                                        </a>
                                        &nbsp;    &nbsp;
                                   
                                        <button class="btn btn-success " data-bind="click:guardar" >
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
            //  var editar = '@User.IsInRole("ActivoFijo.Editar")' == 'True';
            var path = "${pageContext.request.contextPath}";
        </script>

        <script src="${pageContext.request.contextPath}/Usuarios.js?v=3" type="text/javascript"></script>
    </jsp:attribute>
</mt:dashboard>
