var modeloUSr;

function Model() {
    var th = this;
    th.nombre = ko.observable("");
    th.ap = ko.observable("");
    th.am = ko.observable("");
    th.correo = ko.observable("");

    th.reloadTable = function () {
        th.tableCatUsers.ajax.reload(null, false);
        th.tableUsers.ajax.reload(null, false);
        console.log("...................recargando");
    };
    th.dataTest = function () {
        var p = window.path + "/CattipoUsuario";
        console.log("url:" + p);
        $.ajax({
            type: "GET",
            url: p, //"/Ventas/CattipoUsuario",
            data: {reqValue: ">>>>>>>>>>>>>>>>>>>>llego"},
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            //  async: false,
            success: function (response) {
                console.log(response);

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No llego respuesta");
                console.log(jqXHR);
                console.log(errorThrown);
            },
        });
    };
    th.getCatUser = function () {
        var p = window.path + "/CattipoUsuario";

        th.tableCatUsers = $('#catalogoTipoUsuarios').DataTable({
            responsive: true,
            destroy: true,
            ajax: {
                url: p,
                type: "GET",
                dataSrc: "",
                async: true,
                data: {reqValue: ">>>>>>>>>>>>>>>>>>>>"}

            },
            columns: [
                {title: "Id", data: "id"},
                {title: "Descripcion", data: "descripcion"},

                {
                    title: 'Acciones', orderable: false,
                    data: null, "render": function (data) {
                        /*var control = '<div class="dropdown"><button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Acciones<span class="caret"></span></button>'; //'<div class="input-group acciones"> <div class="input-group-prepend">  <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"><i class="fa fa-files-o"></i> </a> <div class="dropdown-menu">';
                         control+='   <ul class="dropdown-menu">'  
                         control += '<a class="dropdown-item" href="#">Action</a>';//'<a class="dropdown-item" id="' + data.id + '"  onclick="model.verXML(\'' + data.id + '\');" >  Editar </a>';
                         control += '<a class="dropdown-item" href="#">Another action</a>';//'<a class="dropdown-item" id="' + data.id + '"  onclick="model.download(\'' + data.id + '\');" >   Eliminar </a>';
                         
                         
                         control += '</ul></div>'//'</div></div></div>';*/
                        var control = '';

                        control += '<button class="btn bng-transparent" type="button"  id="' + data.id + '" onclick="modeloUSr.editarCat(\'' + data.id + '\');"> <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-edit-3" aria-hidden="true"><path d=\"M17 3a2.828 2.828 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5L17 3z\"></path> </svg>&nbsp;</button>&nbsp;';

                       // control += '<button class="btn bg-transparent" type="button"  id="' + data.id + '" onclick="modeloUSr.eliminarCat(\'' + data.id + '\');"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash" aria-hidden="true"><polyline points=\"3 6 5 6 21 6\"></polyline><path d=\"M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2\"></path></svg>&nbsp;</button>';

                        return control;
                    }
                }
            ],
            language: Helper.dataTablesLanguage

        });

        var control = '';
        control += '<div class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3  " style="background-color: #EAEDED"> ';
        control += '<div class="container mt-100" >';
        control += '<div class="row">';
        control += '<div class="col-md-4 col-sm-6">';
        control += '<div class="card mb-30">';
        control += '<a class="card-img-tiles" href="#" data-abc="true">';
        control += '<div class="inner">';
        control += '<div class="main-img">';
        control += '<img src="https://i.imgur.com/O0GMYuw.jpg" alt="Category">';
        control += '</div>';
        control += '<div class="thumblist">';
        control += '<img src="https://i.imgur.com/ILEU18M.jpg" alt="Category">';
        control += '</div>';
        control += '</div>';
        control += '</a>';
        control += '<div class="card-body text-center">';
        control += '<h4 class="card-title">Laptops</h4>';
        control += '<p class="text-muted">Starting from $499</p><a class="btn btn-outline-primary btn-sm" href="#" data-abc="true">View Products</a>';
        control += '</div>';
        control += '</div>';
        control += ' </div>';
        control += ' </div>';
        control += ' </div>';
        control += ' </div>';

      //  $('#imagen').append(control);
    };
    th.getUsers = function () {
        var p = window.path + "/UsuariosConsulta";

        th.tableUsers = $('#Usuarios').DataTable({
            responsive: true,
            destroy: true,
            ajax: {
                url: p,
                type: "GET",
                dataSrc: "",
                async: true,
                data: {reqValue: ">>>>>>>>>>>>>>>>>>>>"}

            },
            columns: [
                {title: "Id", data: "id"},
                {title: "Nombre", data: "nombre"},
                {title: "A.Paterno", data: "apaterno"},
                {title: "A.Materno", data: "amaterno"},
                {title: "Email", data: "correo"},
                {
                    title: 'Acciones', orderable: false,
                    data: null, "render": function (data) {

                        var control = '';
                        control += '<button class="btn bng-transparent" type="button"  id="' + data.id + '" onclick="modeloUSr.getDetalle(\'' + data.id + '\');"><i class="bi bi-eye"></i>&nbsp;</button>&nbsp;';

                        control += '<button class="btn b   g-transparent" type="button"  id="' + data.id + '" onclick="modeloUSr.getDetalleEditar(\'' + data.id + '\');"> <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-edit-3" aria-hidden="true"><path d=\"M17 3a2.828 2.828 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5L17 3z\"></path> </svg>&nbsp;</button>&nbsp;';
                        control += '<button class="btn bg-transparent" type="button"  id="' + data.id + '" onclick="modeloUSr.eliminarModal(\'' + data.id + '\');"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash" aria-hidden="true"><polyline points=\"3 6 5 6 21 6\"></polyline><path d=\"M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2\"></path></svg>&nbsp;</button>';

                        return control;
                    }
                }
            ],
            language: Helper.dataTablesLanguage

        });

    };

    th.getDetalle = function (id) {
        var p = window.path + "/ConsultaUsuario?id=" + id;
        window.location.href = p;
    };

    th.getDetalleEditar = function (id) {
        var p = window.path + "/EditarUsuario?id=" + id;
        window.location.href = p;
    };
    th.eliminarModal = function (id) {
        console.log("id><<<<<<<<<" + id);
        $("#eliminarModalContent").modal("show");
    };
    th.eliminar = function () {
        $('#cover-spin').show(0);
        setTimeout(function () {
            console.log("........................eliminando");
            th.reloadTable();
            $('#cover-spin').hide(0);
        }, 2000);
    };
    th.guardar = function () {
        $('#cover-spin').show(0);
        setTimeout(function () {
            console.log("nombre>" + th.nombre());
            console.log("ap>" + th.ap());
            console.log("am>" + th.am());
            console.log("correo>" + th.correo());

            if (false) {
                var p = window.path + "/Usuarios";
                window.location.href = p;
            } else {
                alert("Ocurrio un error al guardar un nuevo usuario");
            }
            $('#cover-spin').hide(0);
        }, 2000);


    };
    th.eliminarCat = function (id) {
        console.log("Eliminando cat" + id);
          var p = window.path +"/DeleteCattipoUsuario?id="+id
            $.ajax({
            type: "post",
            url: p, //"/Ventas/CattipoUsuario", charset=utf-8
            /*data: {
                id: id
                
            },*/
            contentType: "application/json",

            dataType: "json",
            //  async: false,
            // processData: false,
            success: function (response) {
                // alert(response); Vistas/Productos/index.jsp
                $('#cover-spin').hide(0);
                  th.reloadTable();
                  console.log(response);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No llego respuesta eliminar cat");
                console.log(jqXHR);
                console.log(errorThrown);
                $('#cover-spin').hide(0);
            },
        });
    };
    th.editarCat = function (id) {
        console.log("Editando cat" + id);
    }
    th.editarPerfil=function(){
        debugger;
        var nom=$('#nombre').val();
        var ap=$('#apaterno').val();
        var am=$('#amaterno').val();
        var p=window.path+"/UpdatePerfil";
         $.ajax({
            type: "post",
            url: p, //"/Ventas/CattipoUsuario", charset=utf-8
            data: {
                nombre:nom,
                apaterno:ap,
                amaterno:am
                
            },
          //  contentType: "application/json",

            dataType: "json",
            //  async: false,
            // processData: false,
            success: function (response) {
               
            },
           /* error: function (jqXHR, textStatus, errorThrown) {
                alert("No llego respuesta editar user");
                console.log(jqXHR);
                console.log(errorThrown);
                $('#cover-spin').hide(0);
            },*/
        });
        
    }
    
    th.cambiaPerfil=function(id){
        alert("llego"+id);
    }
    th.init = function () {
        // alert("hola");
        // th.dataTest();
        $('#cover-spin').show(0);
        th.getUsers();
        th.getCatUser();
        $('#cover-spin').hide(0);
    };

}

$(function () {
    modeloUSr = new Model();
    modeloUSr.init();
    ko.applyBindings(modeloUSr);




});

 