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
<section class="content-header">
    <h1 class="col-6">Candidatos a Voluntário</h1>
    <div class="clearfix"></div>
</section>

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
                                <th>Telefone</th>
                                <th>Tipo</th>
                                <th class="text-right">Ações</th>

                            </tr>
                        </thead>
                        <tbody>
                            @foreach(@$voluntarios as $v)
                                <tr>
                                    <td>{{ $v->nome }}</td>
                                    <td>{{ $v->email }}</td>
                                    <td>{{ $v->telefone }}</td>
                                    <td>{{ $v->tipo }}</td>
                                    <td class="text-right">
                                    <a href="{{ route('admin.futuros.delete', $v->id) }}"
                                            class="btn btn-danger btn-xs"><i class="fas fa-trash"></i></a></td>
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