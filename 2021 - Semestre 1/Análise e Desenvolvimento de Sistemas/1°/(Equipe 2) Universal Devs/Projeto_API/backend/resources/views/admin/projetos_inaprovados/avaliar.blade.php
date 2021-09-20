@extends('layouts.painel')
@section('pre-assets')
<style>
    .footerActions {
        position: fixed;
        width: calc(100% - 73px);
        background: #fff;
        z-index: 100;
        bottom: 0;
        left: 73px;
        opacity: 0.5;

    }

    .footerActions:hover {
        opacity: 1;
    }

    .content-wrapper>.content {
        padding-bottom: 100px;
    }

    .list-action {
        padding: 10px;
    }

    .footerActions {
        position: relative;
    }
</style>
@endsection
@section('painel')
<section class="content-header m-bottom-lg text-center">

    <div class="clearfix"></div>
</section>
<div class="col-8 mx-auto">
    <form action="" id="form">
        @include('admin.projetos_inaprovados._form')
        <div class="footerActions">
            <div class="list-action">
                <div class="row">
                    <div class="col-4 text-left">
                        <a href="" class="btn btn-flat btn-default" data-action="sair">Sair</a>
                    </div>
                    <div class="col-4 text-right">
                        <button type="submit" class="btn btn-flat btn-primary">Salvar e Sair</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
@endsection
@section('pos-script')

<script>
    $("#form").submit(function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "{{ route('admin.inaprovados.update',$projeto->id) }}",
            data: $("#form").serialize(),
            headers: {
                'X-CSRF-TOKEN': "{{ csrf_token() }}"
            },
            success: function (data) {
                if (data.status == "ok") {
                    swal("Sucesso!", "Seus dados foram enviados com sucesso!", "success");
                    window.location.replace(
                    "{{ route('admin.inaprovados.lista') }}");
                } else {
                    swal("Opa!", "Algo deu errado.", "info");
                }
            }
        });

        e.preventDefault(); 
    });

    $('.datepicker').datepicker();
</script>
@endsection