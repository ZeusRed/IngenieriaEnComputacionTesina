var modeloProd;
function Model() {
    var th = this;
    th.id = ko.observable("");
    th.descripcion = ko.observable("");
    th.existencia = ko.observable(0);
    th.precio = ko.observable(0);
    th.imagenPromo = ko.observable("");
    th.tipo = ko.observable("");
    th.isSaved = ko.observable(true);
    th.reloadTable = function () {

        th.tableProds.ajax.reload(null, false);
        console.log("...................recargando");
    };

    th.getProds = function () {
        var p = window.path + "/ProductosConsulta";
        th.tableProds = $('#Productos').DataTable({
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
                {title: "Precio", data: "precio"},
                {title: "Existencia", data: "existencia"},

                {
                    title: 'Acciones', orderable: false,
                    data: null, "render": function (data) {

                        var control = '';
                        control += '<button class="btn bng-transparent" type="button"  id="' + data.id + '" onclick="modeloProd.getDetalle(\'' + data.id + '\');"><i class="bi bi-eye"></i>&nbsp;</button>&nbsp;';

                        control += '<button class="btn b   g-transparent" type="button"  id="' + data.id + '" onclick="modeloProd.getDetalleEditar(\'' + data.id + '\');"> <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-edit-3" aria-hidden="true"><path d=\"M17 3a2.828 2.828 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5L17 3z\"></path> </svg>&nbsp;</button>&nbsp;';
                        control += '<button class="btn bg-transparent" type="button"  id="' + data.id + '" onclick="modeloProd.eliminarModal(\'' + data.id + '\');"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash" aria-hidden="true"><polyline points=\"3 6 5 6 21 6\"></polyline><path d=\"M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2\"></path></svg>&nbsp;</button>';
                        console.log(data.imagen);
                        return control;
                    }
                }
            ],
            language: Helper.dataTablesLanguage

        });
    };
    th.getDetalleEditar = function (id) {
        var p = window.path + "/EditarProducto?id=" + id;
        th.id(id);
        window.location.href = p;

    };
    th.getDetalle = function (id) {
        var p = window.path + "/ConsultarProducto?id=" + id;
        th.id(id);
        window.location.href = p;
    };
    th.getFileImage = function (ev) {
        if (ev.files && ev.files[0]) {

            var FR = new FileReader();

            FR.addEventListener("load", function (e) {
                //console.log("->" + e.target.result);
                //  document.getElementById("img").src = e.target.result;
                // document.getElementById("b64").innerHTML = e.target.result;
                var tmppath = URL.createObjectURL(ev.files[0]);
                $('#x' + ev.id).attr("src", e.target.result);
                if (ev.id == '0') {
                    // th.imagenPromo(ev.files[0]);
                    th.actualizarGaleria();
                } else {
                    th.actualizarGaleriaProds(ev.id)
                }

            });
            var objects = $(".imgsServer");
            for (var obj of objects) {
                console.log(obj);
            }
            FR.readAsDataURL(ev.files[0]);
        } else {
            alert("No hay archivo disponible");
        }

    };
    th.actualizar = function () {
        $('#cover-spin').show(0);


        th.id($('#idP').val());
        th.descripcion($('#desc').val());
        th.existencia($('#existencia').val());
        th.precio($('#precio').val());

        console.log(th.imagenPromo());
        var p = window.path + "/EditarDatosProducto";
        console.log("url:" + p);
        $.ajax({
            type: "get",
            url: p, //"/Ventas/CattipoUsuario", charset=utf-8
            data: {
                id: th.id(),
                descripcion: th.descripcion(),
                precio: th.precio(),
                cantidad: th.existencia()
            },
            contentType: "application/json",

            dataType: "json",
            //  async: false,
            // processData: false,
            success: function (response) {
                // alert(response); Vistas/Productos/index.jsp
                $('#cover-spin').hide(0);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No llego respuesta editar");
                console.log(jqXHR);
                console.log(errorThrown);
                $('#cover-spin').hide(0);
            },
        });
    };
    th.actualizarGaleria = function () {

        var ev = $('#0');

        if (ev[0].files.length > 0) {
            var frm = $('#upload-form');
            let result = fetch(frm.attr('action'), {method: 'POST', body: new FormData(document.querySelector("#upload-form"))})
                    //  .then((resp) => resp.json())
                    .then(function (text) {
                        console.log(text);
                        var i = 0;
                    });
            /* var p = window.path + "/EditarProductoSet";
             
             var frm = $('#upload-form');
             $.ajax({
             type: frm.attr('method'),
             url: frm.attr('action'),
             data: frm.serialize(),
             
             async: false,
             cache: false,
             contentType: false,
             processData: false,
             success: function (response) {
             alert(response);
             },
             error: function (jqXHR, textStatus, errorThrown) {
             alert("No llego respuesta editar");
             console.log(jqXHR);
             console.log(errorThrown);
             },
             });*/
        }
    };
    th.actualizarGaleriaProds = function (id) {



        var frm = $('#upload-form' + id);
        let result = fetch(frm.attr('action'), {method: 'POST', body: new FormData(document.querySelector("#upload-form" + id))})
                //  .then((resp) => resp.json())
                .then(function (text) {
                    console.log(text);
                    var i = 0;
                });


    };
    th.guardar = function (isclick) {
          if (th.descripcion() != "" && th.existencia() > 0 && th.precio() > 0 && th.tipo() != "") {
            $('#cover-spin').show(0);
            var i = 0;
            console.log("" + th.descripcion() + " " + th.existencia() + " " + th.precio() + " " + th.tipo());
            //cuando llegue el id generado se bloquea el producto y se agrega la galeria , se colocara una bandera para que no salga del modulo, sino se guardara incompleto
         // alert("Guardado ");
           var p = window.path + "/NuevoProdSet";
               $.ajax({
            type: "get",
            url: p, //"/Ventas/CattipoUsuario", charset=utf-8
            data: {
                id: th.id(),
                descripcion: th.descripcion(),
                precio: th.precio(),
                cantidad: th.existencia(),
                tipo:th.tipo()
            },
            contentType: "application/json",

            dataType: "json",
            //  async: false,
            // processData: false,
            success: function (response) {
                // alert(response); Vistas/Productos/index.jsp
                $('#cover-spin').hide(0);
                  th.isSaved(false);
                  if(response){
                      var path=window.path+"/Productos";
                       window.location.href=path;
                  }else{
                         alert("No se pudo guardar correctamente");
                  }
                 
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No llego respuesta guardar");
                console.log(jqXHR);
                console.log(errorThrown);
                $('#cover-spin').hide(0);
              
            },
        });
               
                
            } else {
                alert("Debes completar todos los campos para poder generar tu producto.");
                $('#cover-spin').hide(0);
            }
       
    };
    th.eliminarModal=function(id){
        alert("Se elimino:"+ id);
    };
    th.init = function () {
        $('#cover-spin').show(0);
        th.getProds();
        $('#cover-spin').hide(0);



    };
}
$(function () {

    modeloProd = new Model();
    modeloProd.init();
    ko.applyBindings();
});