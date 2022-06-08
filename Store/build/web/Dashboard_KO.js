 var modelo;
var accs = window.path + "/Inicio";

function Model() {
    var th = this;
 
th.logOut=function(){
     $.ajax({
            type: "GET",
            url: window.path +"/LogOut",
            data: {
          
            },
          //  contentType: "application/json; charset=utf-8",
            dataType: "json",
            //  async: false,
            success: function (response) {
                
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

                if (response.logout == true) {
 
                    Toast.fire({
                        icon: 'success',
                        title: 'Nos vemos pronto'
                    }).then((result) => {

                        window.location.href = window.path + '/';

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
    
}
    th.acceso = function () {

        console.log("Inicia el ingreso al portal");
          console.log(th.correo());
            console.log(th.pwd());
          console.log("Inicia el ingreso al portal");
        $.ajax({
            type: "GET",
            url: window.path +"/LoginAccess",
            data: {
                correo: th.correo(),
                pwd: th.pwd()
            },
          //  contentType: "application/json; charset=utf-8",
            dataType: "json",
            //  async: false,
            success: function (response) {
                
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

    th.init = function () {
  
    };

}

$(function () {
    modelo = new Model();
    modelo.init();
    ko.applyBindings(modelo);




});




