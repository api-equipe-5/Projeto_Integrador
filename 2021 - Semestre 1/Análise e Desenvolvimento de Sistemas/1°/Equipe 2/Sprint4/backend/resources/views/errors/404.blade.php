@extends('layouts.site')
@section('pre-asset')
<style>
#content {
    padding-bottom: 0;
}

#container{
    margin-top: 300px;
}

.text-center{
    color: #ff4d4d;
}

.icon{
    font-size: 180px;
}



</style>
@endsection
@section('content')
<div class="control_800">
    <div class="text-center">
        <h1 style="font-size: 100px">404</h1>
        <i class="icon fas fa-exclamation-triangle""></i>
        <h3>Página não encontrada</h3>
    </div>
</div>
@endsection