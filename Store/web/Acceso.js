var model;
var accs = window.path + "/Inicio";
function Usuarios() {


}
function Model() {
    var th = this;
    th.nombre = ko.observable("");
    th.ap = ko.observable("");
    th.am = ko.observable("");
    th.correo = ko.observable("");
    th.pwd = ko.observable("");
    th.pwd2 = ko.observable("");
    th.usuariosModel = ko.observable();
    th.acceso = function () {

        console.log("Inicia el ingreso al portal");
        console.log(th.correo());
        console.log(th.pwd());
        console.log("Inicia el ingreso al portal");
        $('#cover-spin').show(0);
        $.ajax({
            type: "GET",
            url: window.path + "/LoginAccess",
            data: {
                correo: th.correo(),
                pwd: th.pwd()
            },
            //  contentType: "application/json; charset=utf-8",
            dataType: "json",
            //  async: false,
            success: function (response) {
                $('#cover-spin').hide(0);
                const Toast = Swal.mixin({
                    toast: true,
                    position: 'top-right',
                    iconColor: 'white',
                    customClass: {
                        popup: 'colored-toast'
                    },
                    showConfirmButton: false,
                    timer: 1000,
                    timerProgressBar: true
                })

                if (response.acceso == true) {
                    console.log(response.imagen);
                    Toast.fire({
                        icon: 'success',
                        title: 'Accediendo'
                    }).then((result) => {

                        window.location.href = window.path + '/Inicio';

                    })
                } else {

                    Toast.fire({
                        icon: 'error',
                        title: 'Error'
                    })

                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No llego respuesta");
                console.log(jqXHR);
                console.log(errorThrown);
            },
        });
    };
    th.registro = function () {
        $.ajax({
            type: "GET",
            url: window.path + "/RegistroServlet",
            data: {
                nombre: th.nombre(),
                ap: th.ap(),
                am: th.am(),
                correo: th.correo(),
                pwd: th.pwd()
            },
            //  contentType: "application/json; charset=utf-8",
            dataType: "json",
            //  async: false,
            success: function (response) {
                $('#cover-spin').hide(0);
                const Toast = Swal.mixin({
                    toast: true,
                    position: 'top-right',
                    iconColor: 'white',
                    customClass: {
                        popup: 'colored-toast'
                    },
                    showConfirmButton: false,
                    timer: 1000,
                    timerProgressBar: true
                })

                if (response.register == true) {
                    console.log(response.imagen);
                    Toast.fire({
                        icon: 'success',
                        title: 'Registrando'
                    }).then((result) => {

                        window.location.href = window.path;

                    })
                } else {

                    Toast.fire({
                        icon: 'error',
                        title: 'Error no se registro correctamente'
                    })

                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No llego respuesta");
                console.log(jqXHR);
                console.log(errorThrown);
            },
        });
    };
    th.init = function () {


    };

}

$(function () {
    var isR = window.isReload;
    console.log(">>>>>>>>>>>>" + isR);
    $.ajax({
        type: "GET",
        url: window.path + "/ConfirmaSession",
        data: {

        },
        //  contentType: "application/json; charset=utf-8",
        dataType: "json",
        //  async: false,
        success: function (response) {



            if (response.acceso == true) {
                window.location.href = window.path + '/Inicio';

            } else {

                model = new Model();

                model.init();
                ko.applyBindings(model);
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("No llego respuesta");
            console.log(jqXHR);
            console.log(errorThrown);
        },
    });



});



