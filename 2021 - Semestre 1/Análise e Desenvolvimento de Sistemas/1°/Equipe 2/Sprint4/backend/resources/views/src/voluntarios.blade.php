@extends('layouts.site')
@section('content')
<div class="control_800" style="padding-top: 90px">
    <h1 style="font-size: 64px; text-align: center;">Voluntários</h1>
    <div class="row">
        @foreach($voluntarios as $voluntario)
            <div class="col-sm-4">
                <h2 class="titulo">{{ $voluntario->nome }}</h2>
                <br>
                <p>
                    <strong>Email: </strong>{{ $voluntario->email }}
                </p>
                <p id="Informacoes">
                    <strong>Tipo:</strong> {{ $voluntario->tipo }}
                </p>
                <hr>
            </div>
            
        @endforeach
    </div>
</div>
@endsection