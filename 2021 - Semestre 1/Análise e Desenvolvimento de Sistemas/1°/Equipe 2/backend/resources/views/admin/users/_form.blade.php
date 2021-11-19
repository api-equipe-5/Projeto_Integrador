<section class="col-12">
    <div class="row">
        <div class="col-12">
                <div class="form-group col-5">
                    <label for="name">Nome</label>
                    <input type="text" name="name" class="form-control" value="{{ @$usuario->name }}" required>
                </div>
        
            
           
                <div class="form-group col-5">
                    <label for="email">Email</label>
                    <input class="form-control" name="email" value="{{ @$usuario->email }}" required>
                </div>
                <div class="form-group col-5">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" name="senha" required>
            </div>
        </div>
    </div>
    <div class="clearfix m-top-lg m-bottom-lg">
    </div>
</section>
