@extends('layouts.site')
@section('content')
<div class="control_800" style="padding-top: 90px">
    <h1 style="font-size: 64px; text-align: center;">Projetos</h1>
    @foreach($projetos as $projeto)
        <section class="Projeto1">

            @if($projeto->media)
                <img src="{{ $projeto->media->fullpatch() }}" class="float-r" id="FotoProjeto" />
            @else
                <img src="{{ asset('dist/img/not-found.jpg') }}" class="float-r" id="FotoProjeto" alt="">
            @endif
            <h2 class="Titulo">{{ $projeto->nome }}</h2>
            <br>
            <p>
               {{ mb_strimwidth($projeto->descricao, 0, 150, "...") }}
            </p>
            <p class="Informacoes">
                <a href="{{ route('projetos.projeto',$projeto->slug) }}"
                    class="btn btn-primary">Ver Mais</a>
            </p>

        </section>
    @endforeach
</div>
@endsection