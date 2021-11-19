@extends('layouts.painel')
@section('pre-assets')

@endsection
@section('painel')
<section class="content-header m-bottom-lg">
<h1>Novo Usuario</h1>
 
<div class="clearfix"></div>
</section>

  <form action="" id="form">

  @CSRF

  @include('admin.users._form')

    <div class="footerActions">
     <div class="list-action">
      <div class="row col-8">
         <div class="col-4 text-left">
            <a href="{{route('admin.users.list')}}" class="btn btn-default btn-flat">Voltar</a>
        </div>
        <div class="col-4">
      
         <button type="submit" id="submit" class="btn btn-success btn-flat float-right">Salvar</button>
        </div>
      </div>
    </div>
  </div>

  </form>
  @endsection
  @section('pos-script')

  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $("#form").submit(function (e) {
        e.preventDefault();
        $.ajax({
            type: "GET",
            url: "{{ route('admin.users.create') }}",
            data: $("#form").serialize(),
            success: function (data) {
                if (data.status == "ok") {
                    swal("Sucesso!", "Seus dados foram enviados com sucesso!", "success");
                    window.location.replace("{{ route('admin.users.list') }}");
                } else {
                    swal("Opa!", "Algo deu errado.", "info");
                }
            }
        });

        e.preventDefault(); // avoid to execute the actual submit of the form.
    });


    


</script>
@endsection