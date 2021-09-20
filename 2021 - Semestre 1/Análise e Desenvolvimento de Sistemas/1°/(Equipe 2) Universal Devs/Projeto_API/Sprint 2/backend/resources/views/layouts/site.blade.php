<!DOCTYPE html>
<html lang="en" prefix="og: http://ogp.me/ns#">

<head>
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-SQ92LDV2P1"></script>
    <script>
        window.dataLayer = window.dataLayer || [];

        function gtag() {
            dataLayer.push(arguments);
        }
        gtag('js', new Date());

        gtag('config', 'G-SQ92LDV2P1');
    </script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta property="og:locale" content="pt_BR">
    <meta property="og:url" content="http://paroquiasantateresinha.org.br">
    <meta property="og:title" content="Paróquia Santa Teresinha SJC">
    <meta property="og:site_name" content="Paróquia Santa Teresinha SJC">
    <meta property="og:description" content="">
    <meta property="og:image" content="{{ asset('dist/img/og-wpp.jpg') }}">
    <meta property="og:image:type" content="image/jpeg">
    <meta property="og:image:width" content="800">
    <meta property="og:image:height" content="800">
    <link rel="stylesheet" href="{{ asset('/dist/css/styles.css') }}">
    <link rel="stylesheet" href="{{ asset('/vendor/fa5/css/all.min.css') }}">
    <link rel="stylesheet" type="text/css"
        href="{{ asset('/vendor/slick-1.8.1/slick/slick.css') }}" />
    <link rel="stylesheet" type="text/css"
        href="{{ asset('/vendor/slick-1.8.1/slick/slick-theme.css') }}" />
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" rel="stylesheet" />

    @yield('pre-assets')

    <title>Paróquia Santa Teresinha SJC @yield('title')</title>
</head>
<style>
    #cookies {

        position: fixed;
        bottom: 10px;
        left: 10px;
        width: 300px;
        z-index: 999999;
        background: #808080;
        border-radius: 10px;
        box-shadow: 0px 5px 11px #000;
    }

    #play_audio {
        background: #fff;
        height: 6ch;
        overflow: hidden;
        text-align: center;
        margin: 0 auto;
        max-width: 100%;
        margin-bottom: 10px;
    }

    .animate {
        transition: 0.3s all linear;
    }

    .height13ch {
        height: 13ch !important;
    }

    audio {
        display: block;
        margin: 0 auto;
    }

    #play_audio a {
        width: fit-content;
        display: block;
        margin: 8px auto;
        padding: 0 5px;
        color: #000;
        text-decoration: none;
        border: 2px solid #000;
        border-radius: 20px;
        margin-bottom: 16px;
        font-size: 14px !important;
    }

    #play_audio a:hover{
        background: #000;
        color: #fff;
        transition:0.2s all linear
    }
</style>

<body>
    <div id="tudo">
        <div class="bg-flowers">
            <img src="{{ asset('/dist/img/gif_flor.gif') }}" alt="">
        </div>
        <div class="cookie-banner" id="cookies" style="display:none;">
            <p class="m-all-sm">
                Nós usamos cookies para otimizar sua experiência neste site.
                Ao continuar a navegar, você está aceitando nossa Política de Privacidade
            </p>
            <button class="closes btn btn-sm btn-gray m-all-sm hvr-float-shadow float-right" onclick="cookies()">Ok, eu
                concordo</button>
        </div>
        <header id="header">
            <div class="logo">
                <a href="{{ url('/') }}">
                    <img src="{{ asset('/dist/img/logo-branco.png') }}" alt="">
                </a>
            </div>
            <div id="nav-icon2" data-alvo="nav#menu">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
            <div class="bg-red"></div>

            <nav id="menu">
                <div class="bg-red"></div>

                <ul>
                    <li><a href="{{ url('/') }}">Home</a></li>
                    <li><a href="">Paróquia</a>
                        <ul class="submenu">
                            <li><a href="{{ url('/capelas') }}">Capelas</a></li>
                            <li><a href="{{ url('/horarios') }}">Horários</a></li>
                            <li><a href="{{ url('/local') }}">Localização</a></li>
                        </ul>
                    </li>
                    <li><a href="{{ url('/padroeira') }}">Padroeira</a></li>
                    <li><a href="{{ route('noticias.home') }}">Notícias</a></li>

                </ul>
            </nav>

        </header>
        @if(@$audio)
            <div id="play_audio">
                <a href="#">Reflexão diária - {{ $audio['dia'] }} </a>
                <audio controls>
                    <source
                        src="{{ asset('uploads/audio/'.$audio['arquivo']) }}"
                        class="col-12" type="audio/mpeg">
                </audio>
            </div>
        @endif
        <div id="content">
            @yield('content')
        </div>
        <footer>
            <img src="{{ asset('/dist/img/rose.png') }}" alt="">
            <ul class="control">
                <li class="col-sm-4 col-xs-12">
                    <h4 style="margin-top: 40px">{{ $frase->frase }}</h4>
                </li>
                <li class="col-sm-4 col-xs-12">
                    <div class="content-social">
                        <a href="https://www.facebook.com/santateresinhasjc" target="_blank"><i
                                class="fab fa-facebook-f"></i></a>
                        <a href="https://www.instagram.com/santateresinhasjc/?hl=pt-br" target="_blank"><i
                                class="fab fa-instagram"></i></a>
                        <a href="https://www.youtube.com/channel/UC0WWZEjfJPKN16MaE6sAseA" target="_blank"><i
                                class="fab fa-youtube"></i></a>
                    </div>
                </li>
                <li class="col-sm-4 col-xs-12">
                    <iframe
                        src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2Fsantateresinhasjc%2F&tabs=mensagens&width=340&height=100&small_header=true&adapt_container_width=true&hide_cover=false&show_facepile=true&appId"
                        width="340" height="100" style="border:none;overflow:hidden" scrolling="no" frameborder="0"
                        allowfullscreen="true"
                        allow="autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share"></iframe>
                    <style>
                        div._3qw {
                            display: none !important;
                        }
                    </style>
                </li>
            </ul>
        </footer>

    </div>
    <div id="fb-root"></div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous">
    </script>
    <script async defer crossorigin="anonymous" src="https://connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v9.0"
        nonce="ydEKxqvo"></script>
    <script type="text/javascript"
        src="{{ asset('/vendor/slick-1.8.1/slick/slick.min.js') }}"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.14/jquery.mask.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
    <script src="//cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
    <script src="{{ asset('/dist/js/frontpst.js') }}">
    </script>
    <script>
        $('.banner-slick').slick({
            prevArrow: '<div class="arrow arrow-prev"><i class="fas fa-chevron-left"></i></div>',
            nextArrow: '<div class="arrow arrow-next"><i class="fas fa-chevron-right"></i></div>',
            autoplay: true,
            autoplaySpeed: 2000,
            infinite: true,
            centerMode: true,
            slidesToShow: 1,
            variableWidth: true,
            dots: true
        });

        var largura = $(window).width();
        if (largura < 768) {
            $('.submenu').siblings('a').click(function (e) {
                e.preventDefault();

                $(this).siblings('.submenu').toggleClass('active');
                $(this).toggleClass('afterNone');

            });
        }

        window.onload = function () {
            verificaCookies();
        }

        function cookies() {
            let key = 'teste';
            localStorage.setItem(key, 'value');
            var a = localStorage.getItem(key);
            verificaCookies();
        }

        function verificaCookies() {
            let key = 'teste';
            var a = localStorage.getItem(key);
            if (a == null) {
                console.log('nulo');
                document.getElementById("cookies").style.display = "block";

            } else {
                console.log('nao nulo');
                document.getElementById("cookies").style.display = "none";
            }
        }

        $('#play_audio a').click(function (e) {
            e.preventDefault();
            $('#play_audio').addClass('animate');
            $('#play_audio').toggleClass('height13ch');
        })
    </script>
    @yield('pos-script')

</body>

</html>