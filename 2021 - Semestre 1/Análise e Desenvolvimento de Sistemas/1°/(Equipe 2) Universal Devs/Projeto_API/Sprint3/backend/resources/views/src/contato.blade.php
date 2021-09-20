@extends('layouts.site')
@section('pre-asset')
<style>

    #container{
        min-height: 60vh;
    }
</style>
@endsection
@section('content')
<div class="control_800" style="margin-top: 40px">
    <h1 id="contato" style="text-align: center; font-size: 64px">Contato</h1>
    <div class="containeri">
        <form action="#" id="form" class="form-contact" tabindex="1">
            <input type="text" class="form-control form-contact-input" name="nome" placeholder="Nome" required />
            <input type="email" class="form-control form-contact-input" name="email" placeholder="Email" required />
            <textarea class="form-control form-contact-textarea" name="conteudo" placeholder="Deixe uma mensagem"
                required></textarea>
            <button type="submit" class="btn btn-success btn-lg">Enviar</button>
        </form>
    </div>
</div>
@endsection

@section('pos-script')
<script>
    $("#form").submit(function (e) {
        e.preventDefault();
        $.ajax({
            type: "post",
            url: "{{ route('enviar-contato') }}",
            data: $("#form").serialize(),
            headers: {
                'X-CSRF-TOKEN': "{{ csrf_token() }}"
            },
            success: function (data) {
                if (data.status == "ok") {
                    swal("Sucesso!", "Seus dados foram enviados com sucesso!", "success");
                   
                } else {
                    swal("Opa!", "Algo deu errado.", "info");
                }
                $("#form")[0].reset();
            }
        });
        e.preventDefault();
    });
</script>
@endsection
