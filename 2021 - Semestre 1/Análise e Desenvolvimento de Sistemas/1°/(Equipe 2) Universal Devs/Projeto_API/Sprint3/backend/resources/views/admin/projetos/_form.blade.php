<section class="col-12">
    <div class="row col-8 mx-auto">
        <div class="form-group col-sm-12">
            <label for="">Nome</label>
            <input type="text" value="{{ @$projeto->nome }}" name="nome" class="form-control">
        </div>

        <div class="form-group col-sm-12">
            <label for="">Descricao</label>
            <textarea name="descricao" id="" cols="30" rows="10"
                class="form-control">{{ @$projeto->descricao }}</textarea>
        </div>

        <div class="form-group col-sm-12">
            <div class="input-block">
                <label for="">Imagem</label>
                <div id="carregandoForm" class="carregandoDestaque" style="display: none">
                </div>

                <label for="uploadArquivos" class="uploadFileInput"
                    style="text-align: center;padding: 1em;display: block;background: #b9b9b9;">Selecione</label>
                <input id="uploadArquivos" type="file" name="imagePath" style="display: none;">

                <div id="preview">
                    <ul>
                        @if(@$projeto->media_id)
                            <li>
                                <img src="{{ @$projeto->media->fullpatch() }}" alt="">
                            </li>
                        @endif
                    </ul>
                </div>

            </div>
        </div>
    </div>
    <div class="clearfix m-top-lg m-bottom-lg"></div>
</section>
