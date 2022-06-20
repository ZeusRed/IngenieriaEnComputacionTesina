var modeloPerfil;
function ModelPerfil() {
    var th = this;
    th.id = ko.observable();
    th.calle = ko.observable();
    th.colonia = ko.observable();
    th.numero = ko.observable();
    th.cpostal = ko.observable();

    th.guardarDireccion = function () {
        if (th.calle()) {
            if (th.colonia()) {
                if (th.numero()) {
                    if (th.cpostal()) {
                        var p = window.path + "/ConfirmarDireccion";
                        $.ajax({
                            type: "get",
                            url: p, //"/Ventas/CattipoUsuario", charset=utf-8
                            data: {
                                calle: th.calle(),
                                colonia: th.colonia(),
                                cp: th.cpostal(),
                                numero: th.numero()

                            },
                            contentType: "application/json",

                            dataType: "json",
                            //  async: false,
                            // processData: false,
                            success: function (response) {
                                // alert(response); Vistas/Productos/index.jsp
                                $('#cover-spin').hide(0);

                                if (response.isNewDireccion == true) {
                                    var path = window.path + "/Direcciones";
                                    window.location.href = path;
                                } else {
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
                        alert("Debe incluir un codigo postal");
                    }
                } else {
                    alert("Debe incluir un numero de hogar");
                }
            } else {
                alert("Debe incluir una colonia");
            }
        } else {
            alert("Debe incluir una calle");
        }
    }

    th.eliminarDireccion = function (id) {
        $('#cover-spin').show(0);
         var p = window.path + "/EliminarDireccion";
        $.ajax({
            type: "get",
            url: p, //"/Ventas/CattipoUsuario", charset=utf-8
            data: {
                 idDir:id

            },
            contentType: "application/json",

            dataType: "json",
            //  async: false,
            // processData: false,
            success: function (response) {
                // alert(response); Vistas/Productos/index.jsp
                $('#cover-spin').hide(0);

                if (response.isDeleteDireccion == true) {
                    var path = window.path + "/Direcciones";
                    window.location.href = path;
                } else {
                    alert("No se pudo eliminar correctamente");
                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No llego respuesta eliminar F");
                console.log(jqXHR);
                console.log(errorThrown);
                $('#cover-spin').hide(0);

            },
        });
      
    }
    th.init = function () {
        $('#cover-spin').show(0);

        $('#cover-spin').hide(0);
    }
}
$(function () {
    // if(!modeloCarrito){
    modeloPerfil = new ModelPerfil();
    modeloPerfil.init();
    ko.applyBindings();
    //  } 
});


