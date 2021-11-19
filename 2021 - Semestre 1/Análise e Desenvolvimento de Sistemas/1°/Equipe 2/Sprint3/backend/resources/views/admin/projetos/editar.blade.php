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
    <h1>Editar: {{ $projeto->nome }}</h1>

    <div class="clearfix"></div>
</section>

<form action="" id="form">


    @include('admin.projetos._form')
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

@endsection
@section('pos-script')

<script>
    $("#form").submit(function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "{{ route('admin.projetos.update',$projeto->id) }}",
            data: $("#form").serialize(),
            headers: {
                'X-CSRF-TOKEN': "{{ csrf_token() }}"
            },
            success: function (data) {
                if (data.status == "ok") {
                    swal("Sucesso!", "Seus dados foram enviados com sucesso!", "success");
                    window.location.replace("{{ route('admin.projetos.lista') }}");
                } else {
                    swal("Opa!", "Algo deu errado.", "info");
                }
            }
        });

        e.preventDefault(); // avoid to execute the actual submit of the form.
    });


    $('#uploadArquivos').on('change', function () {
        $(".loadingimg").fadeIn('fast');
        var data = new FormData();
        console.log($("input[id='uploadArquivos']")[0].files);
        $.each($("input[id='uploadArquivos']")[0].files, function (i, file) {
            data.append('imagePath', file);
        });
        data.append('_token', '{{ csrf_token() }}');
        $.ajax({
            url: '{{ route("admin.ajax.uploadimg") }}',
            type: 'POST',
            cache: false,
            contentType: false,
            processData: false,
            headers: {
                'X-CSRF-TOKEN': "{{ csrf_token() }}"
            },
            data: data,
            success: function (result) {
                $.each(result, function (index, value) {
                    var html = '';
                    html += '<li>';
                    html += '<input type="hidden" name="arquivo" value="' + value + '" />';
                    html += '<br>';
                    html += `<img src="{{ asset("uploads/img/") }}/` +
                        value + `" alt="">`;
                    html += '</li>';
                    $('#preview ul').html(html);
                    //console.log(value);
                });
            }
        });
        $(".loadingimg").fadeOut('slow');
    });
    $('.datepicker').datepicker();
</script>
@endsection