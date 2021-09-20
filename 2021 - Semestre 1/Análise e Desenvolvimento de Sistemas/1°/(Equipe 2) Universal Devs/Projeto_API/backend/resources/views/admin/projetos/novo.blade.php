@extends('layouts.painel')
@section('pre-assets')

@endsection
@section('painel')

<div class="control_800">
    <section class="content-header m-bottom-lg text-center">
        <h1>Novo Projeto</h1>
        <div class="clearfix"></div>
    </section>
    <form id="form">
        @CSRF
            @include('admin.projetos._form')
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
            url: "{{ route('admin.projetos.store') }}",
            data: $("#form").serialize(),
            success: function (data) {
                if (data.status == "ok") {
                    swal("Sucesso!", "Seus dados foram enviados com sucesso!", "success");
                    window.location.replace(
                        "{{ route('admin.projetos.lista') }}"
                    );
                } else {
                    swal("Opa!", "Algo deu errado.", "info");
                }
            }
        });
        e.preventDefault();
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


    // function string_to_slug() {
    //     str = document.getElementById('slug').value;
    //     console.log(str);
    //     str = str.replace(/^\s+|\s+$/g, "");
    //     str = str.toLowerCase();
    //     var from = "åàáãäâèéëêìíïîòóöôùúüûñç·/_,:;";
    //     var to = "aaaaaaeeeeiiiioooouuuunc------";

    //     for (var i = 0, l = from.length; i < l; i++) {
    //         str = str.replace(new RegExp(from.charAt(i), "g"), to.charAt(i));
    //     }

    //     document.getElementById('slug').replace(/[^a-z0-9 -]/g, "")
    //     document.getElementById('slug').replace(/\s+/g, "-") 
    //     document.getElementById('slug').replace(/-+/g, "-")
    //     document.getElementById('slug').replace(/-+$/, ""); 


    // }
</script>
@endsection