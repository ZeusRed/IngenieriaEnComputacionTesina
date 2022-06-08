 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Logica.SessionLogic" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <!--<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">-->
        <!--<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>-->
        <link href="${pageContext.request.contextPath}/assets/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css"> 
        <!--<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
        <script src="${pageContext.request.contextPath}/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/jquery-3.3.1.min.js" type="text/javascript"></script>

        <link href="${pageContext.request.contextPath}/ModalSucess.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/SweetAlertModal.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.9/dist/sweetalert2.all.min.js"></script> 
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.9/dist/sweetalert2.min.css"> 
       <link href="${pageContext.request.contextPath}/Estilos_2.css" rel="stylesheet" type="text/css"/>

        <style>


            body{
                font-family: 'Mukta', sans-serif;
                height:100vh;
                min-height:550px;
                background-image: url(https://wallpapercave.com/wp/wp9442288.jpg);
                background-repeat: no-repeat;
                background-size:cover;
                background-position:center;
                position:relative;
                overflow-y: hidden;
            }
            a{
                text-decoration:none;
                color:#444444;
            }
            .login-reg-panel{
                position: relative;
                top: 50%;
                transform: translateY(-50%);
                text-align:center;
                width:80%;
                right:0;left:0;
                margin:auto;
                height:400px;
                background-color: rgba(79,115, 194, 0.9);
            }
            .white-panel{
                background-color: rgba(255,255, 255, 1);
                height:500px;
                position:absolute;
                top:-50px;
                width:50%;
                right:calc(50% - 50px);
                transition:.3s ease-in-out;
                z-index:0;
                box-shadow: 0 0 15px 9px #00000096;
            }
            .login-reg-panel input[type="radio"]{
                position:relative;
                display:none;
            }
            .login-reg-panel{
                color:#FFFFFF;
            }
            .login-reg-panel #label-login, 
            .login-reg-panel #label-register{
                border:1px solid #FFFFFF;
                padding:5px 5px;
                width:150px;
                display:block;
                text-align:center;
                border-radius:10px;
                cursor:pointer;
                font-weight: 600;
                font-size: 18px;
            }
            .login-info-box{
                width:30%;
                padding:0 50px;
                top:20%;
                left:0;
                position:absolute;
                text-align:left;
            }
            .register-info-box{
                width:40%;
                padding:0 50px;
                top:20%;
                right:0;
                position:absolute;
                text-align:left;

            }
            .right-log{right:50px !important;}

            .login-show, 
            .register-show{
                z-index: 1;
                display:none;
                opacity:0;
                transition:0.3s ease-in-out;
                color:#242424;
                text-align:left;
                padding:30px;
            }
            .show-log-panel{
                display:block;
                opacity:0.9;
            }
            .login-show input[type="text"], .login-show input[type="password"]{
                width: 100%;
                display: block;
                margin:20px 0;
                padding: 15px;
                border: 1px solid #b5b5b5;
                outline: none;
            }
            .login-show input[type="button"] {
                max-width: 150px;
                width: 100%;
                background: #444444;
                color: #f9f9f9;
                border: none;
                padding: 10px;
                text-transform: uppercase;
                border-radius: 2px;
                float:right;
                cursor:pointer;
            }
            .login-show a{
                display:inline-block;
                padding:10px 0;
            }

            .register-show input[type="text"], .register-show input[type="password"]{
                width: 100%;
                display: block;
                margin:15px 0;
                padding: 15px;
                border: 1px solid #b5b5b5;
                outline: none;
            }
            .register-show input[type="button"] {
                max-width: 170px;
                width: 100%;
                background: #444444;
                color: #f9f9f9;
                border: none;
                padding: 10px;
                text-transform: uppercase;
                border-radius: 2px;
                float:right;
                cursor:pointer;
            }
            .credit {
                position:absolute;
                bottom:10px;
                left:10px;
                color: #3B3B25;
                margin: 0;
                padding: 0;
                font-family: Arial,sans-serif;
                text-transform: uppercase;
                font-size: 12px;
                font-weight: bold;
                letter-spacing: 1px;
                z-index: 99;
            }
            a{
                text-decoration:none;
                color:#2c7715;
            }




        </style>
    </head>
    <body>
<%
    int isRed=2;
SessionLogic sl= new SessionLogic();
    sl=(SessionLogic) request.getSession().getAttribute("sessionUsuario");
        if(sl!=null){
             request.getRequestDispatcher("Inicio").forward(request, response);
           isRed=1;
     }else{
            isRed=0;
        }
     %>
      <div id="cover-spin"></div>
      
        <div class="login-reg-panel">
            <div class="login-info-box">
                <h2>Tienes una cuenta?</h2>
                <p>Ingresa desde el siguiente enlace.</p>
                <label id="label-register" for="log-reg-show">Ingresar</label>
                <input type="radio" name="active-log-panel" id="log-reg-show"  checked="checked">
            </div>

            <div class="register-info-box">
                <h2>No cuentas con una cuenta?</h2>
                <p>Registrate facilmente siguiendo el siguiente enlace.</p>
                <label id="label-login" for="log-login-show">Registrar</label>
                <input type="radio" name="active-log-panel" id="log-login-show">
            </div>

            <div class="white-panel">
                <div class="login-show">
                    <h2>INGRESAR</h2>
                    <input type="text" placeholder="Email" data-bind="value:correo">
                    <input type="password" placeholder="Contraseña" data-bind="value:pwd">
                    <input type="button"   id="Inicio" value="INGRESAR" data-bind="click:acceso">
                    <a href="Vistas/error.jsp">Recuperar Contraseña?</a>
                </div>
                <div class="register-show">
                    <h2>REGISTRAR</h2>
                    <div class="row">
                        <div class="col-md-4">
                                   <input type="text" placeholder="Nombre" data-bind="value:nombre">
                        </div>
                         <div class="col-md-4">
                                 <input type="text" placeholder="Apellido" data-bind="value:ap">
                        </div>
                         <div class="col-md-4">
                                 <input type="text" placeholder="Apellido" data-bind="value:am">
                        </div>
                    </div>
             
               
                    
                    <input type="text" placeholder="Email" data-bind="value:correo">
                    <input type="password" placeholder="Contraseña" data-bind="value:pwd">
                    <input type="password" placeholder="Confirmar Contraseña" data-bind="value:pwd2">
                  
           <input type="button"   id="REGISTRAR" value="REGISTRAR" data-bind="click:registro">
                </div>
            </div>
        </div>

    </body>
    <script src="${pageContext.request.contextPath}/assets/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">
        var path = "${pageContext.request.contextPath}";
        var isReload=<%=isRed%>
        var  isObject=<%=sl%>
        console.log(path);
        console.log("ISOBJECT>=>"+isObject);
        $(document).ready(function () {
            $('.login-info-box').fadeOut();
            $('.login-show').addClass('show-log-panel');
             $('#cover-spin').hide(0);
        });
        $('.login-reg-panel input[type="radio"]').on('change', function () {
            if ($('#log-login-show').is(':checked')) {
                $('.register-info-box').fadeOut();
                $('.login-info-box').fadeIn();
                $('.white-panel').addClass('right-log');
                $('.register-show').addClass('show-log-panel');
                $('.login-show').removeClass('show-log-panel');
            } else if ($('#log-reg-show').is(':checked')) {
                $('.register-info-box').fadeIn();
                $('.login-info-box').fadeOut();
                $('.white-panel').removeClass('right-log');
                $('.login-show').addClass('show-log-panel');
                $('.register-show').removeClass('show-log-panel');
            }
        });
       
      


    </script>
          <script src="${pageContext.request.contextPath}/Acceso.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/knockout-3.5.1.debug.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/knockout-3.5.1.js" type="text/javascript"></script>
</html>
