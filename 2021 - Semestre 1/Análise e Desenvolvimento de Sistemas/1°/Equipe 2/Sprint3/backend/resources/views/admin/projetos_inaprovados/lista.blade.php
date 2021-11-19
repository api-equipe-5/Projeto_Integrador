@extends('layouts.painel')
@section('pre-assets')
@endsection
@section('painel')
<section class="content-header">
    <h1 class="col-6">Projetos</h1>
    <div class="clearfix"></div>
</section>


<section class="col-12">
    <div class="col-12">
        <div class="card">
            <!-- /.card-header -->
            <div class="card-body table-responsive p-0">

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Criador</th>
                                <th class="text-right">Ações</th>

                            </tr>
                        </thead>
                        <tbody>
                            @foreach($projetos as $projeto)
                                <tr>
                                    <td>{{ $projeto->nome }}</td>

                                    <td>
                                        {{ $projeto->criador }}
                                    </td>
                                    <td class="project-actions text-right">
                                        <a class="btn btn-info btn-sm"
                                            href="{{ route('admin.inaprovados.avaliar', $projeto->id) }}">
                                            <i class="fas fa-eye"></i>
                                        </a>
                                        <!-- <a class="btn btn-info btn-sm" href="">
                                <i class="fas fa-eye">
                                </i>
                            </a> -->
                                        <a class="btn btn-danger btn-sm"
                                            href="{{ route('admin.projetos.delete', $projeto->id) }}">
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

</section>


@endsection

@section('pos-script')

@endsection