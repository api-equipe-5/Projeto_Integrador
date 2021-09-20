<?php
    namespace Controller;

    use Model\Model;
    include_once dirname(__DIR__)."\Model\model.php";

    // Classe responsável por requisitar, mostrar e alterar/adicionar os itens/produtos do sistema.
    Class Item{
        private $model;
        // Local onde são salvos os itens/produtos
        private $folder = "data/";
        public $resp;

        public function __construct(){
            $this->model = new Model();
        }

        // Mostra todos os itens de um conteúdo pelo nome ($i).
        public function requestItens($i,$cancel){
            $content = $this->model->getContent($i);
            if(is_array($content)){

                $itens = $this->model->getAllItens($content["id"]);
                if(is_array($itens)){
                    if(!empty($itens)){

                        $message = 0;

                        $title = $content["nome"];
                        $content = $content["id"];

                        $name = "";
                        $descrip = "";  $type = "";
                        $value = 0.0;   $zise = 0;

                        for($x = 0;$x < count($itens);$x++){
                            $name = utf8_encode($itens[$x]["nome"]);
                            $type = utf8_encode($itens[$x]["tipo"]);
                            $zise = $itens[$x]["tamanho"];
                            $descrip = utf8_encode($itens[$x]["descrip"]);
                            $value = str_replace(".",",",$itens[$x]["valor"]);

                            $resp  = (isset($_SESSION["resp"]) && !empty($_SESSION["resp"]) ?
                                $_SESSION["resp"] : ""
                            );

                            $cancel = ($cancel ?
                                "disabled" : ""
                            );

                            require dirname(__DIR__)."/View/Cards/List_Item_card.php";
                        }
                    }
                }else{
                    echo "Nenhum item encontrado";
                }

            }else{
                echo "Erro: $content";
            }
            
        }

        // Mostra todos os conteúdos.
        public function requestContents(){
            $contents = $this->model->getAllContent();
            $id = 0;        $name = "";
            $descrip = "";  $img = "logo.jpg"; 

            if(is_array($contents)){
                if(!empty($contents)){
                    foreach ($contents as $key => $value) {
                        $id = $value["id"];
                        $name = utf8_encode($value["nome"]);
                        $descrip = utf8_encode($value["descrip"]);
                        $img = utf8_encode($value["img"]);

                        require dirname(__DIR__)."/View/Cards/Conteudos_card.php";
                    }
                }else{
                    echo "Falha ao obter os conteúdos";
                }
            }
        }

        // Retorna o arquivo solicitado pelo nome ($i).
        public function requestFile($i){
            $get_file = $this->model->getItem(utf8_decode($i));

            $get_file["nome"] = utf8_encode($get_file["nome"]);
            $get_file["conteudo"] = utf8_encode($this->model->getContent((int)$get_file["conteudo"])["nome"]);
            $get_file["descrip"] = utf8_encode($get_file["descrip"]);
            
            return $get_file;
        }

        // Gera os dados necessários para o 'carrosel' dos conteúdos.
        public function generateCarousel(){
            $content = $this->model->getAllContent();

            $count = count($content);
            $name = $descrip = $img = [];

            for($x=0;$x<$count;$x++){
                $name[$x] = utf8_encode($content[$x]["nome"]);
                $descrip[$x] = utf8_encode($content[$x]["descrip"]);
                $img[$x] = $content[$x]["img"];
            }

            $data = [
                'count' => $count,
                'name' => $name,
                'descrip' => $descrip,
                'img' => $img
            ];

            return $data;
        }

        public function addItemCarrinho($user_id, $item){
            $item = $this->model->getItem(utf8_decode($item))["id"];
            
            $_SESSION["resp"] = ($this->model->itemCart("add",$user_id,$item)[1] ?
                "Adicionado ao Carrinho" : ""
            );
        }

    }
?>