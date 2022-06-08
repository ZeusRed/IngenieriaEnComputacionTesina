 
Helper = {
    dataTablesLanguage: {
        lengthMenu: "Mostrar _MENU_ registros por página",
        search: "Buscar",
        zeroRecords: "Ningún registro encontrado",
        info: "Mostrando del _START_ al _END_ de _TOTAL_ registros",
        infoEmpty: "No se encontró nigún resultado",
        infoFiltered: "filtrados de _MAX_ registros totales",
        processing: '<div style="background-color: #337ab7; border-radius:10px"> <div  class="dt-spinner" ></div> <span style="font-weight: bolder;font-size: 3em;color: white;">Por favor espere...</span> </div>',
        loadingRecords: "Cargando...",
        paginate: {
            first: "Primera",
            last: "Última",
            previous: "Anterior",
            next: "Siguiente"
        }
    },
    dataShortener: function (data, maxLength) {
        if (data.length > maxLength) {
            return '<span data-toggle="tooltip" data-placement="top" title="' + data + '" >' + data.substring(0, maxLength) + '...' + '</span>'
        }
        return '<span >' + data + '</span>'
    },
    datePickerLanguage: {
        "format": "DD-MM-YYYY",
        "daysOfWeek": [
            "Do",
            "Lu",
            "Ma",
            "Mi",
            "Ju",
            "Vi",
            "Sa"
        ],
        "monthNames": [
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Setiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
        ]
    },
    newGuid: function () {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
            var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
            return v.toString(16);
        });
    },
    currencyFormat: function (number) {
        var decPlaces = 2;
        var decSep = ".";
        var thouSep = ",";
        var sign = number < 0 ? "-$" : "$";
        var i = String(parseInt(number = Math.abs(Number(number) || 0).toFixed(decPlaces)));
        var j = (j = i.length) > 3 ? j % 3 : 0;
        //var j = i.length > 3 ? j / 3 : 0;

        return sign + (j ? i.substr(0, j) + thouSep : "") +
            i.substr(j).replace(/(\decSep{3})(?=\decSep)/g, "$1" + thouSep) +
            (decPlaces ? decSep + Math.abs(number - i).toFixed(decPlaces).slice(2) : "");
    },
    pageTitle: function (title) {
        document.title = title;
        $("#_pageTitle").text(document.title);

    },
    pad: function (n, width, z) {
        z = z || '0';
        n = n + '';
        return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
    }
}

Waiter = {
    show: function (message) {
        $("#_waiterSpinner").show("");
        $("#_waiterAlert").hide("");
        $("#_waiterDismiss").hide("");
        $("#_waiterMessage").text(message);
        $("#_waiter").modal({
            backdrop: "static",
            keyboard: false,
            show: true
        });
        $("#_waiterErrors").empty();
    },
    success: function (message) {
        toastr.success(message, 'SIRC', { timeOut: 5000 });
        $("#_waiterMessage").text("");
        setTimeout(function () { $("#_waiter").modal("hide"); }, 1000);
    },
    hide: function () {
        $("#_waiterMessage").text("");
        $("#_waiter").modal("hide");
    },
    errors: function (message, errors) {
        $("#_waiterMessage").text(message);
        $("#_waiterSpinner").hide("");
        $("#_waiterAlert").show("");
        $("#_waiterDismiss").show("");
        if (errors)
            $.each(errors, function (index, item) {
                $("#_waiterErrors").append("<li>" + item + "</li>")
            });
    }
}
