<section class="col-12">
    <div class="row col-8 mx-auto">
        <div class="form-group col-sm-8">
            <label for="">Nome</label>
            <input type="text" value="{{@$participante->nome}}" name="nome" class="form-control">
        </div>
        <div class="form-group col-sm-4">
            <label for="">Status</label>
            <select name="status" id="" class="form-control">
                <option value="Ativo" @if(@$participante->status == 'Ativo') selected="" @endif>Ativo</option>
                <option value="Inativo" @if(@$participante->status == 'Inativo') selected="" @endif>Inativo</option>
            </select>
        </div>
        <div class="form-group col-sm-4">
            <label for="">Matrícula</label>
            <input type="text" value="{{@$participante->matricula}}" name="matricula" class="form-control" maxlength="2" size="2">
        </div>
        <div class="form-group col-sm-4">
            <label for="">Data de Nascimento</label>
            <input type="text" value="{{@$participante->data_nascimento}}" name="data_nascimento" class="form-control" maxlength="2" size="2">
        </div>
        <div class="form-group col-sm-4">
            <label for="">Telefone</label>
            <input type="text" value="{{@$participante->telefone}}" name="telefone" class="form-control">
        </div>
        <div class="form-group col-sm-3">
            <label for="">RG</label>
            <input type="text" value="{{@$participante->rg}}" name="rg" class="form-control">
        </div>
        <div class="form-group col-sm-3">
            <label for="">CPF</label>
            <input type="text" value="{{@$participante->cpf}}" name="cpf" class="form-control">
        </div>
        
        <div class="form-group col-sm-6">
            <label for="">Email</label>
            <input type="email" value="{{@$participante->email}}" name="email" class="form-control">
        </div>
        <div class="form-group col-sm-9">
            <label for="">Endereço</label>
            <input type="text" value="{{@$participante->endereco}}" name="endereco" class="form-control">
        </div>
        <div class="form-group col-sm-3">
            <label for="">CEP</label>
            <input type="text" value="{{@$participante->cep}}" name="cep" class="form-control">
        </div>
        <div class="form-group col-sm-4">
            <label for="">Cidade</label>
            <input type="text" value="{{@$participante->cidade}}" name="cidade" class="form-control">
        </div>
        <div class="form-group col-sm-2">
            <label for="">Estado</label>
            <input type="text" value="{{@$participante->estado}}" name="estado" class="form-control" maxlength="2" size="2">
        </div>

       
        
        
    </div>
    <div class="clearfix m-top-lg m-bottom-lg"></div>
</section>
