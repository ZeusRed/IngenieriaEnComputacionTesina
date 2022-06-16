 
<%@tag description="java" pageEncoding="UTF-8" isELIgnored="false" %>


<%@attribute name="message"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>

<%@ attribute name="content" fragment="true"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Reynaldo Mejia">
        <meta name="generator" content="RMR_1.0.0">
        <title>Electronic Shop &copy;</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/dashboard/">
        <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/logoEShop.png">
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.11/css/jquery.dataTables.css">
        <script src="${pageContext.request.contextPath}/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.11/js/jquery.dataTables.js"></script>
        <script src="${pageContext.request.contextPath}/site.js" type="text/javascript"></script>
        <!-- Bootstrap core CSS -->
        <script src="${pageContext.request.contextPath}/assets/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/assets/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css"> 
        <link href="${pageContext.request.contextPath}/Estilos_2.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.9/dist/sweetalert2.all.min.js"></script> 
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.9/dist/sweetalert2.min.css"> 
        <link href="${pageContext.request.contextPath}/SweetAlertModal.css" rel="stylesheet" type="text/css"/>
        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>


        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/dashboard.css" rel="stylesheet">
    </head>
    <body>

        <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="${pageContext.request.contextPath}/Inicio">
                <img class="imagen" width="30" heigth="30" src="${pageContext.request.contextPath}/logoEShop.png">
                Electronic Shop &copy;</a>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <input class="form-control form-control-dark w-100" type="text" placeholder="Buscar" aria-label="Buscar" style="display:none;">  
            <div class="form-control form-control-dark w-100" style="background-color:#212529 ">

            </div>
            <div class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <a class="nav-link px-3" href="${pageContext.request.contextPath}/Carrito">
                        <span class="bi bi-cart4"></span>
                        Mis Compras</a>
                </div>

            </div>
            <div class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <a class="nav-link px-3" href="${pageContext.request.contextPath}/Perfil">
                        <i class="bi bi-person"></i>
                        Perfil</a>
                </div>

            </div>
            <div class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <a class="nav-link px-3" href="${pageContext.request.contextPath}/Direcciones">
                        <i class="bi bi-geo-alt"></i>
                        Mis direcciones</a>
                </div>

            </div>

            <div class="navbar-nav">
                <div class="nav-item text-nowrap"> <!--href="${pageContext.request.contextPath}/LogOut"-->
                    <a class="nav-link px-3" id="logOut">
                              <!--  <img class="imagen" width="25" heigth="25" src="${pageContext.request.contextPath}/logoutEShop.svg">-->
                        <i class="bi bi-door-open"></i>
                        Cerrar Sesión</a>
                </div>

            </div>
        </header>

        <div class="container-fluid">
            <div class="row">
                <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                    <div class="position-sticky pt-3">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/Inicio">
                                    <span data-feather="home" ></span>
                                    Inicio
                                </a>
                            </li>
                            <li class="nav-item" >
                                <a class="nav-link" href="${pageContext.request.contextPath}/Compras">
                                    <!-- <span data-feather="file"></span>-->

                                    <i class="bi bi-basket"></i>
                                    Compras
                                </a>
                            </li>
                            <li class="nav-item" id="p">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Productos" style="color:red">
                                    <!--  <span data-feather="shopping-cart"></span> -->
                                    <span class="bi bi-layout-wtf"></span>
                                    Productos
                                </a>
                            </li>
                            <li class="nav-item" id="u">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Usuarios" style="color:red">
                                    <span data-feather="users" style="color:red"></span>
                                    Usuarios
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Pedidos">
                                    <i class="bi bi-receipt-cutoff"></i>
                                    Mis pedidos
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/WishList">
                                    <i class="bi bi-ui-checks-grid"></i>
                                    Lista de deseos
                                </a>
                            </li>
                        </ul>

                                             <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted" >
                                                 <span>Categorias</span>
                                                                      <!--   <a class="link-secondary" href="#" aria-label="Add a new report" id="cat">
                                                     <span data-feather="plus-circle" style="color:red"></span>
                                                 </a> -->
                                             </h6>
                                          
                                  
                       
                        <ul class="nav flex-column mb-2">
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/DatLaptosSource?idCP=1">
                                    <i class="bi bi-laptop"></i>
                                    Laptop
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/DatTabletSource?idCP=2">
                                    <i class="bi bi-tablet"></i>

                                    Tablet
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/DatAcceSource?idCP=3">
                                    <i class="bi bi-controller"></i>
                                    Accesorios
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/DatMovilesSource?idCP=4">
                                    <i class="bi bi-phone"></i>
                                    Moviles
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/DatProtectoresSource?idCP=5">
                                    <i class="bi bi-aspect-ratio"></i>
                                    Protectores
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>

                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4" >


                    <jsp:invoke fragment="content"></jsp:invoke>

                    </main>
                </div>
            </div>
            <br>
            <br>
            <footer class=" text-center text-white" style="background-color: #f1f1f1;">
                <!-- Grid container -->
                <div class="container pt-1 d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center">
                    <!-- Section: Social media -->
                    <section class="mb-1">
                        <!-- Facebook -->
                        <a
                            class="btn btn-link btn-floating btn-lg text-dark m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                            ><i class="bi bi-facebook"></i></a>

                        <!-- Twitter -->
                        <a
                            class="btn btn-link btn-floating btn-lg text-dark m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                            > <i class="bi bi-twitter"></i></a>

                        <!-- Google -->
                        <a
                            class="btn btn-link btn-floating btn-lg text-dark m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                            ><i class="bi bi-google"></i></a>

                        <!-- Instagram -->
                        <a
                            class="btn btn-link btn-floating btn-lg text-dark m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                            ><i class="bi bi-instagram"></i></a>

                        <!-- Linkedin -->
                        <a
                            class="btn btn-link btn-floating btn-lg text-dark m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                            ><i class="bi bi-linkedin"></i></a>
                        <!-- Github -->
                        <a
                            class="btn btn-link btn-floating btn-lg text-dark m-1"
                            href="#!"
                            role="button"
                            data-mdb-ripple-color="dark"
                            ><i class="fab fa-github"></i
                            ></a>

                        <!-- Copyright -->


                        <a class="btn btn-link btn-floating btn-lg text-dark m-1" href="${pageContext.request.contextPath}/Terminos"> Copyright 2021: Electronic Shop &copy;</a>

                </section>
                <!-- Section: Social media -->
            </div>
            <!-- Grid container -->


            <!-- Copyright -->
        </footer>




        <script src="${pageContext.request.contextPath}/knockout-3.5.1.debug.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/knockout-3.5.1.js" type="text/javascript"></script>

        <script src="${pageContext.request.contextPath}/assets/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/dashboard.js"></script>
     <!--  <script src="${pageContext.request.contextPath}/Compras.js" type="text/javascript"></script>-->
        <script type="text/javascript">
            var path = "${pageContext.request.contextPath}";

            $('#logOut').on('click', function () {

                $.ajax({
                    type: "GET",
                    url: path + "/LogOut",
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

            });

            $(document).ready(function () {
                console.log("ready!");
                //consultar los modulos permitidos
                $.ajax({
                    type: "GET",
                    url: path + "/VerificaComponentes",
                    data: {

                    },
                    //  contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    //  async: false,
                    success: function (response) {

                        console.log(response);
                        if (response.acceso === false) {
                            $('#p').hide();
                            $('#u').hide();
                            $('#cat').hide();
                        }

                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert("No llego respuesta");
                        console.log(jqXHR);
                        console.log(errorThrown);
                    },
                });




            });


        </script>
    </body>
</html>


