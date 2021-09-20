<section class="col-12">
    <div class="row col-8 mx-auto">
        <div class="form-group col-sm-12">
            <label for="">Nome</label>
            <input type="text" value="{{@$voluntario->nome}}" name="nome" class="form-control" required>
        </div>
        <div class="form-group col-sm-6">
            <label for="">Tipo</label>
            <select name="tipo" id="" class="form-control">
                <option value="Específico" @if(@$voluntario->tipo == 'Específico') selected="" @endif>Específico</option>
                <option value="Geral" @if(@$voluntario->tipo == 'Geral') selected="" @endif>Geral</option>
                <option value="Inativo"  @if(@$voluntario->tipo == 'Inativo') selected="" @endif>Inativo</option>
            </select>
        </div>
        <div class="form-group col-sm-6">
        <label for="">Status</label>
            <select name="status" id="" class="form-control">
                <option value="Ativo" @if(@$voluntario->status == 'Ativo') selected="" @endif>Ativo</option>
                <option value="Inativo"  @if(@$voluntario->status == 'Inativo') selected="" @endif>Inativo</option>
            </select>
        </div>
        <div class="form-group col-sm-6">
            <label for="">CPF</label>
            <input type="text" value="{{@$voluntario->cpf}}" name="cpf" class="form-control">
        </div>
        <div class="form-group col-sm-6">
            <label for="">RG</label>
            <input type="text" value="{{@$voluntario->rg}}" name="rg" class="form-control">
        </div>
        <div class="form-group col-sm-6">
            <label for="">Telefone</label>
            <input type="text" value="{{@$voluntario->telefone}}" name="telefone" class="form-control">
        </div>
        <div class="form-group col-sm-6">
            <label for="">Email</label>
            <input type="email" value="{{@$voluntario->email}}" name="email" class="form-control" required>
        </div>
        <div class="form-group col-sm-12">
            <label for="">Endereço</label>
            <input type="text" value="{{@$voluntario->endereco}}" name="endereco" class="form-control">
        </div>
        <div class="form-group col-sm-4">
            <label for="">Cidade</label>
            <input type="text" value="{{@$voluntario->cidade}}" name="cidade" class="form-control">
        </div>
        <div class="form-group col-sm-2">
            <label for="">Estado</label>
            <input type="text" value="{{@$voluntario->estado}}" name="estado" class="form-control" maxlength="2" size="2">
        </div>
        <div class="form-group col-sm-6">
            <label for="">Nacionalidade</label>
            <input type="text" value="{{@$voluntario->nacionalidade}}" name="nacionalidade" class="form-control">
        </div>
        <div class="form-group col-sm-12">
            <label for="">Profissão</label>
            <input type="text" value="{{@$voluntario->profissao}}" name="profissao" class="form-control">
        </div>
        <div class="form-group col-sm-6">
            <label for="">Horário</label>
            <input type="text" value="{{@$voluntario->horario}}" name="horario" class="form-control">
        </div>
        <div class="form-group col-sm-6 pl-5">
            <label for="">Dias Disponíveis</label>
            <p><input type="checkbox" name="dias_disponiveis[]" value="domingo" class="mr-2" 
            <?php
             if(in_array("domingo", @$dias_semana)){ 
                    echo "checked='checked'";
                }
            ?>
            ><span>Domingo</span></p>
            <p><input type="checkbox" name="dias_disponiveis[]" value="segunda" class="mr-2" 
            <?php
             if(in_array("segunda", @$dias_semana)){ 
                    echo "checked='checked'";
                }
            ?>
            ><span>Segunda-Feira</span></p>
            <p><input type="checkbox" name="dias_disponiveis[]" value="terca" class="mr-2"
            
            <?php
             if(in_array("terca", @$dias_semana)){ 
                    echo "checked='checked'";
                }
            ?>
            ><span>Terça-Feira</span></p>
            <p><input type="checkbox" name="dias_disponiveis[]" value="quarta" class="mr-2"
            <?php
             if(in_array("quarta", @$dias_semana)){ 
                    echo "checked='checked'";
                }
            ?>
            ><span>Quarta-Feira</span></p>
            <p><input type="checkbox" name="dias_disponiveis[]" value="quinta" class="mr-2"
            <?php
             if(in_array("quinta", @$dias_semana)){ 
                    echo "checked='checked'";
                }
            ?>
            ><span>Quinta-Feira</span></p>
            <p><input type="checkbox" name="dias_disponiveis[]" value="sexta" class="mr-2"
            <?php
             if(in_array("sexta", @$dias_semana)){ 
                    echo "checked='checked'";
                }
            ?>
            ><span>Sexta-Feira</span></p>
            <p><input type="checkbox" name="dias_disponiveis[]" value="sabado" class="mr-2"
            <?php
             if(in_array("sabado", @$dias_semana)){ 
                    echo "checked='checked'";
                }
            ?>
            ><span>Sábado</span></p>

        </div>
        <div class="form-group col-sm-12">
            <label for="">Senha</label>
            <input type="password" value="" name="password" class="form-control" required>
        </div>

    </div>
    <div class="clearfix m-top-lg m-bottom-lg"></div>
</section>
