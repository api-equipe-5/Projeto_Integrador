@extends('layouts.painel')
@section('pre-assets')
<style>
  .footerActions{
    position: fixed;
    width: calc(100% - 73px);
    background: #fff;
    z-index: 100;
    bottom: 0;
    left: 73px;
    opacity: 0.5;

  }
  .footerActions:hover{
    opacity: 1;
  }
.content-wrapper>.content {
    padding-bottom: 100px;
}
.list-action {
  padding: 10px;
}

#preview ul li{
        list-style: none;
      }

      #preview ul li img{
        max-width: 400px;
      }
      .footerActions {
        position: relative; 
      }
</style>
@endsection
@section('painel')
<section class="content-header m-bottom-lg">
<h1> Editar</h1>
 
<div class="clearfix"></div>
</section>

<form action="" id="form">
  
   
  @include('admin.users._form')
      <div class="footerActions">
     <div class="list-action">
      <div class="row">
         <div class="col-4 text-left ">
           <a href="" class="btn btn-flat btn-default" data-action="sair">Sair</a>
        </div>
        <div class="col-4 text-right ">
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
            url: "{{ route('admin.users.update',$usuario->id) }}",
            data: $("#form").serialize(),
            headers: {
                'X-CSRF-TOKEN': "{{ csrf_token() }}"
            },
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