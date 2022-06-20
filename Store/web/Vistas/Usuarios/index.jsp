 
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" session="false" %>
<%@page import="Modelo.Producto" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>  

<mt:dashboard title="Dashboard">
    <jsp:attribute name="content">
         <link href="${pageContext.request.contextPath}/ProductosCard.css" rel="stylesheet" type="text/css"/>

        <div id="cover-spin"></div>

        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"  >
            <h1 class="h2">Administración de Usuarios </h1>
            <div class="btn-toolbar mb-2 mb-md-0">
                <div class="btn-group me-2">
                    <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/NuevoUsuario">
                        <span data-feather="plus-circle"></span>
                        Nuevo Usuario
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
            <div class=col-lg-12">
                <table id="Usuarios" class="table table-striped table-hover" style="width: 100%;"></table>
            </div>
        </div>
        <br>
        <br>

        <h1 class="h2 pt-3 pb-2 mb-3 border-bottom">Tipos de Usuario</h1>
        <div class="row">
            <div class=col-lg-12">
                <table id="catalogoTipoUsuarios" class="table table-striped table-hover" style="width: 100%; "></table>
            </div>
        </div>
        <div id="imagen">
         
              
        
        </div>
        <!--Modal de eliminación-->
        <div id="eliminarModalContent" class="modal fade" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Confirmación</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <p>Estas seguro de eliminar el siguiente usuario?</p>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-warning" data-bs-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal" data-bind="click:eliminar">Eliminar</button>
                    </div>
                </div>
            </div>
        </div>
        <script>
            //  var editar = '@User.IsInRole("ActivoFijo.Editar")' == 'True';
            var path = "${pageContext.request.contextPath}";
        </script>
        <script src="${pageContext.request.contextPath}/Usuarios.js?v=9" type="text/javascript"></script>

    </jsp:attribute>
</mt:dashboard>