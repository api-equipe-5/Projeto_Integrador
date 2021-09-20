@extends('layouts.painel')
@section('pre-assets')
<style>
    #content {
        padding-bottom: 0;
    }

    .text-center {
        color: #ff4d4d;
    }

    .icon {
        font-size: 180px;
    }
</style>
@endsection
@section('painel')
<section class="control_800">
    <section class="col-12">
        <div class="col-12">
            <div class="card">
                

                <!-- /.card-header -->
                <div class="card-body table-responsive p-0">

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>Email</th>
                                    <th>Conteúdo</th>
                                    <th class="text-right">Ações</th>

                                </tr>
                            </thead>
                            <tbody>
                                @foreach(@$msgs as $msg)
                                <tr>
                                    <td>{{$msg->nome}}</td>
                                    <td>{{$msg->email}}</td>
                                    <td>{{mb_strimwidth($msg->conteudo, 0 ,50,'...')}}</td>
                                    <td class="text-right"><a href="{{route('admin.ver_mensagem', $msg->id)}}" class="btn btn-primary">a</a></td>

                                </tr>
                                @endforeach
                            </tbody>
                        </table>


                </div>
                <!-- /.card-body -->
            </div>
            <!-- /.card -->

        </div>

    </section>
</section>

@endsection