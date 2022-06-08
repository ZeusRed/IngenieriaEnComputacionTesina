  var modeloCarrito;
function ModelCarrito() {
    var th = this;
    th.id = ko.observable("");
    th.descripcion = ko.observable("");
    th.existencia = ko.observable(0);
    th.precio = ko.observable(0);
    th.imagenPromo = ko.observable("");
    th.tipo = ko.observable("");
    th.isSaved = ko.observable(true);
  
  th.agregar=function(id){
     // alert("llego"+id);
          var p = window.path + "/ComprasAdd";
           $('#cover-spin').show(0);
       $.ajax({
            type: "GET",
            url: p, //"/Ventas/CattipoUsuario", charset=utf-8
            data: {
                idProd: id
                
            },
            contentType: "application/json",

            dataType: "json",
            //  async: false,
            // processData: false,
            success: function (response) {
                // alert(response); Vistas/Productos/index.jsp
                if(response.add){
                  console.log("se agrego------->"+response.add);
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
                        });
                        
                         Toast.fire({
                                icon: 'success',
                                title: 'Se agrego un nuevo producto al carrito'
                            }).then((result) => {

                           //     window.location.href = window.path + '/';

                            });
                    }else{
                        alert("No se agrego correctamente")
                        console.log(" no se agrego------->"+response.add);
                        $('#cover-spin').hide(0);
                    }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No llego respuesta eliminar cat");
                console.log(jqXHR);
                console.log(errorThrown);
                $('#cover-spin').hide(0);
            },
        });
  }
    th.init = function () {
        $('#cover-spin').show(0);
   //    alert("Listo el carrito de compras");
      $('#cover-spin').hide(0);
 
    };
    th.eliminarProd=function(id){
       //  alert("Eliminando--->"+id);
           var p = window.path + "/DeleteProdCarrito";
          $.ajax({
            type: "GET",
            url: p, //"/Ventas/CattipoUsuario", charset=utf-8
            data: {
                idProd: id
                
            },
            contentType: "application/json",

            dataType: "json",
            //  async: false,
            // processData: false,
            success: function (response) {
                // alert(response); Vistas/Productos/index.jsp
                if(response.delete){
                  console.log("se elimino------->"+response.delete);
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
                        });
                        
                         Toast.fire({
                                icon: 'success',
                                title: 'Se elimino producto del carrito'
                            }).then((result) => {

                            window.location.href = window.path + '/Carrito';

                            });
                    }else{
                        alert("No se elimino correctamente")
                        console.log(" no se agrego------->"+response.add);
                        $('#cover-spin').hide(0);
                    }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No llego respuesta eliminar ");
                console.log(jqXHR);
                console.log(errorThrown);
                $('#cover-spin').hide(0);
            },
        });
    }
}
$(function () {
 // if(!modeloCarrito){
     modeloCarrito = new ModelCarrito();
    modeloCarrito.init();
    ko.applyBindings(); 
     //  } 
});

