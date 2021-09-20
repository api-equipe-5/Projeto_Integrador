<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Vó Maria Felix | Adm</title>
    <link rel="stylesheet" href="{{ asset('/dist/css/upload-img.css') }}">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="{{ asset('/vendor/fa5/css/all.min.css') }}">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bbootstrap 4 -->
    <link rel="stylesheet"
        href="{{ asset('adminlte/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css') }}">
    <!-- iCheck -->
    <link rel="stylesheet"
        href="{{ asset('adminlte/plugins/icheck-bootstrap/icheck-bootstrap.min.css') }}">
    <!-- JQVMap -->
    <link rel="stylesheet" href="{{ asset('adminlte/plugins/jqvmap/jqvmap.min.css') }}">
    <!-- Theme style -->
    <link rel="stylesheet" href="{{ asset('/adminlte/css/adminlte.min.css') }}">
    <!-- overlayScrollbars -->
    <link rel="stylesheet"
        href="{{ asset('/adminlte/plugins/overlayScrollbars/css/OverlayScrollbars.min.css') }}">
    <!-- Daterange picker -->
    <link rel="stylesheet"
        href="{{ asset('/adminlte/plugins/daterangepicker/daterangepicker.css') }}">
    <!-- summernote -->
    <link rel="stylesheet"
        href="{{ asset('/adminlte/plugins/summernote/summernote-bs4.css') }}">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"
        integrity="sha256-siyOpF/pBWUPgIcQi17TLBkjvNgNQArcmwJB8YvkAgg=" crossorigin="anonymous" />
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha14/css/tempusdominus-bootstrap-4.min.css" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" rel="stylesheet" />
        @yield('pre-assets')
 
  
</head>
<style>
           
           .bell{
               color: #9e9e9e;
               
               transform-origin: 50% 4px;
               position: relative;
           }

           .icon-bell{
               position: relative;
           }
           

           .animation-bell{
               -webkit-animation: ring 4s .7s ease-in-out;
               -webkit-transform-origin: 50% 4px;
               -moz-animation: ring 4s .7s ease-in-out;
               -moz-transform-origin: 50% 4px;
               animation: ring 4s .7s ease-in-out infinite;

           }

           @-webkit-keyframes ring {
           0% { -webkit-transform: rotateZ(0); }
           1% { -webkit-transform: rotateZ(30deg); }
           3% { -webkit-transform: rotateZ(-28deg); }
           5% { -webkit-transform: rotateZ(34deg); }
           7% { -webkit-transform: rotateZ(-32deg); }
           9% { -webkit-transform: rotateZ(30deg); }
           11% { -webkit-transform: rotateZ(-28deg); }
           13% { -webkit-transform: rotateZ(26deg); }
           15% { -webkit-transform: rotateZ(-24deg); }
           17% { -webkit-transform: rotateZ(22deg); }
           19% { -webkit-transform: rotateZ(-20deg); }
           21% { -webkit-transform: rotateZ(18deg); }
           23% { -webkit-transform: rotateZ(-16deg); }
           25% { -webkit-transform: rotateZ(14deg); }
           27% { -webkit-transform: rotateZ(-12deg); }
           29% { -webkit-transform: rotateZ(10deg); }
           31% { -webkit-transform: rotateZ(-8deg); }
           33% { -webkit-transform: rotateZ(6deg); }
           35% { -webkit-transform: rotateZ(-4deg); }
           37% { -webkit-transform: rotateZ(2deg); }
           39% { -webkit-transform: rotateZ(-1deg); }
           41% { -webkit-transform: rotateZ(1deg); }

           43% { -webkit-transform: rotateZ(0); }
           100% { -webkit-transform: rotateZ(0); }
           }

           @-moz-keyframes ring {
           0% { -moz-transform: rotate(0); }
           1% { -moz-transform: rotate(30deg); }
           3% { -moz-transform: rotate(-28deg); }
           5% { -moz-transform: rotate(34deg); }
           7% { -moz-transform: rotate(-32deg); }
           9% { -moz-transform: rotate(30deg); }
           11% { -moz-transform: rotate(-28deg); }
           13% { -moz-transform: rotate(26deg); }
           15% { -moz-transform: rotate(-24deg); }
           17% { -moz-transform: rotate(22deg); }
           19% { -moz-transform: rotate(-20deg); }
           21% { -moz-transform: rotate(18deg); }
           23% { -moz-transform: rotate(-16deg); }
           25% { -moz-transform: rotate(14deg); }
           27% { -moz-transform: rotate(-12deg); }
           29% { -moz-transform: rotate(10deg); }
           31% { -moz-transform: rotate(-8deg); }
           33% { -moz-transform: rotate(6deg); }
           35% { -moz-transform: rotate(-4deg); }
           37% { -moz-transform: rotate(2deg); }
           39% { -moz-transform: rotate(-1deg); }
           41% { -moz-transform: rotate(1deg); }

           43% { -moz-transform: rotate(0); }
           100% { -moz-transform: rotate(0); }
           }

           @keyframes ring {
           0% { transform: rotate(0); }
           1% { transform: rotate(30deg); }
           3% { transform: rotate(-28deg); }
           5% { transform: rotate(34deg); }
           7% { transform: rotate(-32deg); }
           9% { transform: rotate(30deg); }
           11% { transform: rotate(-28deg); }
           13% { transform: rotate(26deg); }
           15% { transform: rotate(-24deg); }
           17% { transform: rotate(22deg); }
           19% { transform: rotate(-20deg); }
           21% { transform: rotate(18deg); }
           23% { transform: rotate(-16deg); }
           25% { transform: rotate(14deg); }
           27% { transform: rotate(-12deg); }
           29% { transform: rotate(10deg); }
           31% { transform: rotate(-8deg); }
           33% { transform: rotate(6deg); }
           35% { transform: rotate(-4deg); }
           37% { transform: rotate(2deg); }
           39% { transform: rotate(-1deg); }
           41% { transform: rotate(1deg); }

           43% { transform: rotate(0); }
           100% { transform: rotate(0); }
           }

           
       </style>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

        <!-- Navbar -->
        <nav class="main-header navbar navbar-expand navbar-white navbar-light">
            <!-- Left navbar links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
                </li>
                <li class="nav-item d-none d-sm-inline-block">
                    <a href="{{ url('/admin') }}" class="nav-link">Home</a>
                </li>
                <li class="nav-item d-sm-inline-block float-right icon-bell" style="position: absolute; right: 10px;">
                    <a href="" class="nav-link"><i class="bell fas fa-bell"></i></a>
                </li>
            </ul>
        </nav>
        <!-- /.navbar -->

        <!-- Main Sidebar Container -->
        <aside class="main-sidebar sidebar-dark-primary elevation-4">
            <!-- Brand Logo -->
            <a href="{{ url('/') }}" target="_blank" class="brand-link">
                <img src="{{ asset('dist/img/logo-branco.png') }}" alt=""
                    class="brand-image">
                <span class="brand-text font-weight-light">Instituto Vó Maria Felix</span>
            </a>

            <!-- Sidebar -->
            <div class="sidebar">
                <!-- Sidebar user panel (optional) -->
                <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                    <div class="info">
                        <a href="#" class="d-block">Olá, {{ Auth::user()->name }}</a>
                    </div>
                </div>

                <!-- Sidebar Menu -->
                <nav class="mt-2">
                    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                        data-accordion="false">
                        <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
                        <!-- <li class="nav-item menu-open">
                            <a href="#" class="nav-link">
                                <i class="nav-icon fas fa-home"></i>
                                <p>
                                    Home
                                     <i class="right fas fa-angle-left"></i>
                            </a>
                            
                        </li> -->
                        <li class="nav-header">Cadastros</li>
                        @if(Auth::user()->tipo == 'SuperAdmin')

                        <li class="nav-item">
                            <a href="{{route('admin.voluntarios.lista')}}" class="nav-link">
                                <i class="fas fa-chalkboard-teacher nav-icon"></i>
                                <p>
                                    Voluntários
                                </p>
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="{{route('admin.participantes.lista')}}" class="nav-link">
                                <i class="fas fa-user nav-icon"></i>
                                <p>
                                    Participantes
                                </p>
                            </a>
                        </li>
                        @endif
                        <li class="nav-item">
                            <a href="{{route('admin.projetos.lista')}}" class="nav-link">
                                <i class="fas fa-lightbulb nav-icon"></i>
                                <p>
                                    Projetos
                                </p>
                            </a>
                        </li>
                        
                        
                            
                            <!-- <ul class="nav nav-treeview">
              
              <li class="nav-item">
                <a href="pages/layout/top-nav.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Top Navigation</p>
                </a>
              </li>
            </ul> -->
                      
            @if(Auth::user()->tipo == 'SuperAdmin')
                        <li class="nav-header">Administração</li>
                            <li class="nav-item">
                                <a href="{{route('admin.inaprovados.lista')}}" class="nav-link">
                                    <i class="nav-icon fas fa-check-double"></i>
                                    <p>
                                        Aprovar Projetos
                                    </p>
                                </a>
                            </li>
            @endif
                    </ul>
                </nav>
                <!-- /.sidebar-menu -->
            </div>
            <!-- /.sidebar -->
        </aside>

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <div class="content-header">
                @yield('painel')
            </div>
        </div>
        <!-- /.content-wrapper -->


        <!-- Control Sidebar -->
        <aside class="control-sidebar control-sidebar-dark">
            <!-- Control sidebar content goes here -->
        </aside>
        <!-- /.control-sidebar -->
    </div>
    <!-- ./wrapper -->

    <!-- jQuery -->
    <script src="{{ asset('adminlte/plugins/jquery/jquery.min.js') }}"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="{{ asset('adminlte/plugins/jquery-ui/jquery-ui.min.js') }}"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button)
    </script>
    <!-- Bootstrap 4 -->
    <script src="{{ asset('adminlte/plugins/bootstrap/js/bootstrap.bundle.min.js') }}">
    </script>
    <!-- ChartJS -->
    <script src="{{ asset('adminlte/plugins/chart.js/Chart.min.js') }}"></script>
    <!-- Sparkline -->
    <script src="{{ asset('adminlte/plugins/sparklines/sparkline.js') }}"></script>
    <!-- JQVMap -->
    <script src="{{ asset('adminlte/plugins/jqvmap/jquery.vmap.min.js') }}"></script>
    <script src="{{ asset('adminlte/plugins/jqvmap/maps/jquery.vmap.usa.js') }}"></script>
    <!-- jQuery Knob Chart -->
    <script src="{{ asset('adminlte/plugins/jquery-knob/jquery.knob.min.js') }}"></script>
    <!-- daterangepicker -->
    <script src="{{ asset('adminlte/plugins/moment/moment.min.js') }}"></script>
    <script src="{{ asset('adminlte/plugins/daterangepicker/daterangepicker.js') }}"></script>
    <!-- Tempusdominus Bootstrap 4 -->
    <script
        src="{{ asset('adminlte/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js') }}">
    </script>
    <!-- Summernote -->
    <script src="{{ asset('adminlte/plugins/summernote/summernote-bs4.min.js') }}"></script>
    <!-- overlayScrollbars -->
    <script
        src="{{ asset('adminlte/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js') }}">
    </script>
    <!-- AdminLTE App -->
    <script src="{{ asset('adminlte/js/adminlte.js') }}"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="{{ asset('adminlte/js/pages/dashboard.js') }}"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="{{ asset('adminlte/js/demo.js') }}"></script>
    <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha14/js/tempusdominus-bootstrap-.4min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.14/jquery.mask.min.js"></script>
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha14/css/tempusdominus-bootstrap-4.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"
        integrity="sha256-bqVeqGdJ7h/lYPq6xrPv/YGzMEb6dNxlfiTUHSgRCp8=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>

    <script
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.pt-BR.min.js"
        integrity="sha256-QN6KDU+9DIJ/9M0ynQQfw/O90ef0UXucGgKn0LbUtq4=" crossorigin="anonymous"></script>
    <script src="//cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script>
        $('.summernote').summernote({
            fontNames: ['Arial', 'AlegrayaSC']
        });

        $('.summernote-easy').summernote({
            toolbar: [
                ['style', ['bold', 'italic', 'underline', 'clear']],
                ['font', ['strikethrough', 'superscript', 'subscript']],
                ['fontsize', ['fontsize']],
                ['color', ['color']],
                ['para', ['ul', 'ol', 'paragraph']],
                ['height', ['height']]
            ]
        });

        

        $('.summernote-base').summernote({
            toolbar: [
                ['style', ['bold', 'italic', 'underline', 'clear']],
            ]
        });
    </script>
        @if ($countProjetos > 0)
        <style>
        .icon-bell:after{
               display:block;
               height: 7px;
               width: 7px;
               border-radius:100%;
               background: #f60;
               position: absolute;
               bottom: 12px;
               left: 13px;
               content: '';
               z-index: 1;
           }
        </style>
        
        <script>
                $('.bell').addClass('animation-bell');
        </script>
       
        
        @endif
        @yield('pos-script')

</body>

</html>
