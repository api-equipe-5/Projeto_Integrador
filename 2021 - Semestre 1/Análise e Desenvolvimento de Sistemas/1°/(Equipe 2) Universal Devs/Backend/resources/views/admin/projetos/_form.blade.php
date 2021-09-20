<section class="col-12">
    <div class="row col-8 mx-auto">
        <div class="form-group col-sm-8">
            <label for="">Nome</label>
            <input type="text" value="{{@$projeto->nome}}" name="nome" class="form-control">
        </div>
        <div class="form-group col-sm-4">
            <label for="">Status</label>
            <select name="status" id="" class="form-control">
                <option value="Ativo" @if(@$aluno->status == 'Ativo') selected="" @endif>Ativo</option>
                <option value="Inativo" @if(@$aluno->status == 'Inativo') selected="" @endif>Inativo</option>
            </select>
        </div>
        <div class="form-group col-sm-12">
            <label for="">Descricao</label>
            <textarea name="descricao" id="" cols="30" rows="10" class="form-control">{{@$projeto->descricao}}</textarea>
        </div>
    </div>
    <div class="clearfix m-top-lg m-bottom-lg"></div>
</section>
