@extends('layouts.painel')
@section('pre-assets')

@endsection
@section('painel')

<div class="control_800">
    <section class="content-header m-bottom-lg text-center">
        <h1>{{ $msg->nome }}</h1>
        <h5>{{ $msg->email }}</h5>
        <div style="max-width: 1080px; margin: 0 auto;">
            <p style="margin-top: 50px; text-align: justify">{{ $msg->conteudo }}</p>
        </div>
        <a href="{{route('admin.delete_msg', $msg->id)}}" class="btn btn-danger">Deletar Mensagem</a>
        <div class="clearfix"></div>
    </section>

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