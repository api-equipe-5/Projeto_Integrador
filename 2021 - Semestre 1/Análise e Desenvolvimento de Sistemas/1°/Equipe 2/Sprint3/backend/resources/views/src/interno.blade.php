@extends('layouts.site')
@section('content')
<div class="control_800">
        <section class="Projeto1">
            <div class="control_800">
                <h2 class="Titulo">{{ $projeto->nome }}</h2>
                <br>
                <p>
                   {{ $projeto->descricao }}
                </p>
                @if($projeto->media)
                <div class="container_img">
                    <img src="{{ $projeto->media->fullpatch() }}" id="FotoProjeto" />
                </div>
                @endif
            </div>
        </section>
</div>
@endsection