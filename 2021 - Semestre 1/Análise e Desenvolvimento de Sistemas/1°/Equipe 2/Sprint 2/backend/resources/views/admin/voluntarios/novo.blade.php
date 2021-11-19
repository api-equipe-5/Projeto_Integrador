@extends('layouts.painel')
@section('pre-assets')

@endsection
@section('painel')

<div class="control_800">
    <section class="content-header m-bottom-lg text-center">
        <h1>Novo Voluntario</h1>
        <div class="clearfix"></div>
    </section>
    <form id="form">
        @CSRF
            @include('admin.voluntarios._form')
            <div class="footerActions">
                <div class="list-action col-12 row">
                        <div class="col-10">
                            <a href="" class="btn btn-flat btn-default" data-action="sair">Sair</a>
                        </div>
                        <div class="col-2 float-right">
                            <button type="submit" class="btn btn-flat btn-primary">Salvar e Sair</button>
                        </div>
                </div>
            </div>
    </form>
</div>
@endsection
@section('pos-script')

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $("#form").submit(function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "{{ route('admin.voluntarios.store') }}",
            data: $("#form").serialize(),
            success: function (data) {
                if (data.status == "ok") {
                    swal("Sucesso!", "Seus dados foram enviados com sucesso!", "success");
                    window.location.replace(
                        "{{ route('admin.voluntarios.lista') }}");
                } else {
                    swal("Opa!", "Algo deu errado.", "info");
                }
            }
        });
        e.preventDefault();
    });
</script>
@endsection