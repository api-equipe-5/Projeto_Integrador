@extends('layouts.site')

@section('content')
<div class="control_800">
    <section id="Formulario">
        <p id="inscricao">
            <strong>FAÇA SUA <br />INSCRIÇÃO! </strong>
        </p>
        <div id="linha">
        </div>
        <p id="descricaoForm">
            <br>
            <strong>Acesse e venha fazer parte<br> da nossa ONG</strong>
        </p>

        <a href="#" style="padding-left: 40px;"><button>Clique Aqui</button></a>

    </section>
    <h2 id="Voluntarios">Projetos</h2>
    <br>

    <div class="control_800">
        <div class="slick_projetos">
        @if (@$i>=1)
        @foreach($projetos as $projeto)
            <a href="{{ route('projetos.projeto',$projeto->slug) }}" class="projeto">
            @if($projeto->media)
                <img src="{{ $projeto->media->fullpatch() }}" alt="">
            @else
                <img src="{{ asset('dist/img/not-found.jpg') }}" alt="">
            @endif
            <p class="text-center">{{ $projeto->nome }}</p>
            </a>
        @endforeach
        @else
        <h3 style="text-align: center;">Não existem projetos cadastrados</h3>
        @endif
        </div>
    </div>
</div>
@endsection