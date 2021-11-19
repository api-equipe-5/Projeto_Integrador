<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VoMariaFelix</title>
    <link rel="stylesheet" type="text/css" href="{{ asset('dist/css/cssGeral.css') }}"
        media="screen" />
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" rel="stylesheet" />

</head>
@yield('pre-asset')

<body>
    <div id="tudo">
        <header>
            <img src="{{ asset('dist/img/logo.PNG') }}" id="logo">

            <h1 class="float-l">

            </h1>

            <input type="checkbox" id="control-nav" />
            <label for="control-nav" class="control-nav"></label>
            <label for="control-nav" class="control-nav-close"></label>

            <nav class="float-r">
                <ul class="list-auto">
                    <li>
                        <a href="{{ url('/') }}" title="PaginaInicial"><i
                                class="fas fa-home"></i></a>
                    </li>
                    <li>
                        <a href="{{ url('/projetos') }}" title="Projetos">Projetos</a>
                    </li>
                    <li>
                        <a href="{{ url('/voluntarios') }}" title="Voluntarios">Voluntários</a>
                    </li>
                    <li>
                        <a href="{{ url('/contato') }}" title="Contato">Contato</a>
                    </li>

                </ul>
            </nav>
        </header>
        <div id="container">
            @yield('content')
        </div>
        <footer class="footer">
            <div class="cont">
                <div class="">


                    <div class="footer-col">
                        <h4>O que procura?</h4>
                        <ul>
                            <li><a href="{{url('/voluntarios')}}">Voluntários</a></li>
                            <li><a href="{{url('/projetos')}}">Projetos</a></li>
                            <li><a href="{{url('/contato')}}">Contato</a></li>

                        </ul>
                    </div>
                    
                </div>
            </div>
        </footer>
    </div>
    <script type="text/javascript" src="{{ asset('dist/js/Carrosel.js') }}"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>

    <script>
        $('.slick_projetos').slick({
                    prevArrow: '<a class="arrow arrow-prev"><i class="fas fa-chevron-left"></i></a>',
                    nextArrow: '<a class="arrow arrow-next"><i class="fas fa-chevron-right"></i></a>',
                    responsive: [
                        {
                            breakpoint: 768,
                            settings: {
                                slidesToShow: 1,
                                slidesToScroll: 1,
                                autoplay: true,
                                autoplaySpeed: 2000,
                                infinite: true,
                                dots: false,
                                arrows: false
                            }
                        }
                    ]
                });
    </script>
    @yield('pos-script')
</body>

</html>