<!-- <section class="col-12">
    <div class="row col-8 mx-auto">
        <div class="form-group col-sm-12">
            <label for="">Nome</label>
            <input type="text" value="{{@$projeto->nome}}" name="nome" class="form-control">
        </div>
        
        <div class="form-group col-sm-12">
            <label for="">Descricao</label>
            <textarea name="descricao" id="" cols="30" rows="10" class="form-control">{{@$projeto->descricao}}</textarea>
        </div>
    </div>
    <div class="clearfix m-top-lg m-bottom-lg"></div>
</section> -->
<h6>Criado por: {{ $projeto->criador }}</h6>
<hr>
<p>{{ $projeto->descricao }}</p>
<select name="projeto" class="form-control">
    <option value="aprovado">Aprovar</option>
    <option value="reprovado">Reprovar</option>
</select>