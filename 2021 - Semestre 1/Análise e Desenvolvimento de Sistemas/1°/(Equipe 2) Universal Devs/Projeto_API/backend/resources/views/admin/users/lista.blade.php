@extends('layouts.painel')
@section('pre-assets')
@endsection
@section('painel')
  <section class="content-header">
                    <h1  class="col-6">Usuários</h1>
                    <div class="clearfix"></div>
  </section>

   
<section class="col-12">
<div class="col-12">
            <div class="card">
              <div class="card-header">
              <a class="btn btn-primary btn-sm" href="{{route('admin.users.novo')}}">
                  <i class="fas fa-plus"></i>
                </a>    

                <!-- <div class="card-tools">
                
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">

                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                    </div>
                  </div>
                </div> -->
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover">
                  <thead>
                    <tr>
                        <th>#</th>
                      <th>Nome</th>
                      <th>Email</th>
                      <th>Tipo</th>

                      <th  class=" text-right">Ações</th>

                    </tr>
                  </thead>
                  <tbody>
                  @foreach($usuarios as $usuario)
                      <tr>
                      <td>{{$usuario->id}}</td>
                        <td>{{$usuario->name}}</td>
                        <td>{{$usuario->email}}</td>
                        <td>{{$usuario->tipo}}</td>

                         <td class="project-actions text-right">
                            <a class="btn btn-info btn-sm" href="{{route('admin.users.editar',$usuario->id)}}">
                                <i class="fas fa-pencil-alt">
                                </i>
                            </a>
                            <a class="btn btn-danger btn-sm" href="{{route('admin.users.delete',$usuario->id)}}">
                                <i class="fas fa-trash">
                                </i>                     
                            </a>
                        </td>  
                          </tr>
                @endforeach
                  </tbody>
                </table>
             

              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <center>
          {{ $usuarios->render() }}
          </center>

</section>
 

@endsection

@section('pos-script')
<script type="text/javascript">
   
</script>
  @endsection