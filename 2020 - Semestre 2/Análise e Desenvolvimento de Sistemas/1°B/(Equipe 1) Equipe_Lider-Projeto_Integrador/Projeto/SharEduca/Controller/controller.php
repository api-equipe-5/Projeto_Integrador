<?php
    namespace Controller;

    use Model\Model, Controller\AccountManager, Controller\Item, Controller\Settings;

    include_once dirname(__DIR__)."\Model\model.php";
    include_once dirname(__DIR__)."\Controller\acc_controller.php";
    include_once dirname(__DIR__)."\Controller\itens_controller.php";
    require_once dirname(__DIR__)."\Controller\settings_controller.php";

    // Classe central de controle, responsável por conectar todos os métodos e funções com 
    Class Controller{
        private $model;
        private $user;
        private $account;
        private $item;
        private $settings;
        private $acc_status;
        public $resp = "";

        // Local onde são salvos os itens
        private $storage = "data/";

        public function __construct($local){
            $this->model = new Model();
            $this->account = new AccountManager();
            $this->item = new Item();
            $this->settings = new Settings();

            $this->user_config();

            $paste = ($local != "" ?
                dirname(__DIR__)."/View/".$local.".php" : ""
            );

            if(file_exists($paste)){
                require $paste;
            }else{
                require dirname(__DIR__)."/View/error/404.php";
            }

            if(isset($_GET["con"])){
                $var = explode(",",$_GET["con"]);
                $this->{$var[0]}($var[1]);
            }
            
            // teste
            #session_destroy();
            //

        }

        /* precisa de descrição */
        private function user_config(){
            if(isset($_POST["submit_login"])){
                $this->login();
            }else if(isset($_POST["submit_logon"])){
                $this->logon();
            }

            $this->user = (isset($_SESSION["user"]) ?
                $_SESSION["user"] : ""
            );

            $this->acc_status = (is_array($this->user) ?
                "Conta" : "Login"                
            );
        }

        // Recarrega a página (View) onde se encontra
        public function refresh($local=null){
            if($local == null){
                echo '<meta HTTP-EQUIV="refresh" content="0;URL='.$_SERVER["HTTP_REFERER"].'">';
            }else{
                echo '<meta HTTP-EQUIV="refresh" content="0;URL='.$local.'">';
            }
        }

        // Mostra todos os conteúdos
        public function showContents(){
            $this->item->requestContents();
        }

        // Mostra todos os itens de um conteúdo
        public function showItens($i){
            $cancel = (isset($this->user["id"]) && $this->user["id"] != null ?
                False : True
            );
            
            $this->item->requestItens(utf8_decode($i),$cancel);
        }

        // Retorna o arquivo solicitado pelo nome ($i).
        public function showFile($i){
            return $this->item->requestFile($i);
        }

        /* precisa de descrição */
        public function showCart(){
            if(isset($this->user["id"]) && $this->user["id"] != null){
                return $this->model->getCartInfo($this->user["id"]);
            }else{
                return $this->model->getCartInfo(null);
            }
        }

        /* precisa de descrição */
        public function addOption($var,$local=null){
            if(isset($this->user['acesso']) && $this->user['acesso']){
                if($var){
                    return "<a href='Novo_Conteudo' class='btn btn-outline-primary rounded-circle'><strong>+</strong></a>";
                }else{
                    return "<a href='Novo_Item?i=".$local."' class='btn btn-outline-primary rounded-circle'><strong>+</strong></a>";
                }
            }
        }

        // Remove o item selecionado ($item) do carrinho de compras
        public function remove($item){
            $item = $this->model->getItem(utf8_decode($item))["id"];
            
            if($this->model->itemCart("remove",$this->user["id"],$item)[1]){
                $this->refresh();
            }
        }

        // Adiciona o item informado ao carrinho de compras
        public function add($item){
            $this->item->addItemCarrinho($this->user["id"],$item);
        }

        /* precisa de descrição */
        public function clear(){
            $this->model->itemCart("clear",$this->user["id"]);
            $this->refresh();
        }

        public function addContent(){
            $content = [
                'name' => '',
                "descrip" => '',
                'img' => ''
            ];
            if(isset($_POST['upload'])){
                $content['name'] = (isset($_POST['name']) && !empty($_POST['name']) ?
                    utf8_decode(utf8_encode(trim($_POST['name']))) : "Sem nome"
                );

                $content['descrip'] = (isset($_POST['descrip']) && !empty($_POST['descrip']) ?
                    utf8_decode(utf8_encode(trim($_POST['descrip']))) : "Sem descrição."
                );

                $content['img'] = (isset($_FILES['file']['tmp_name']) && !empty($_FILES['file']['tmp_name']) ?
                    utf8_decode(utf8_encode($_FILES['file']['name'])) : "logo.jpeg"
                );
                
                $response = $this->model->newContent($content);
                if($response[0]){
                    move_uploaded_file($_FILES['file']['tmp_name'],"imagens/".utf8_decode($content['img']));
                    $this->resp = "Novo Conteúdo adicionado: ".$content["name"];
                    $this->refresh("Conteudos");
                }else{
                    $this->resp = "Falha ao salvar o conteúdo";
                }
            }
        }

        // Registra e adiciona um novo item/produto ao sistema.
        public function addItem(){
            $file = [
                'file' => '',
                'size' => 0,
                'type' => '',
                'descrip' => '',
                'content' => 0,
                'value' => 0.0
            ];
            if(isset($_POST['upload'])){
                if (isset($_FILES['file']['tmp_name']) && !empty($_FILES['file']['tmp_name'])){
                    #$file['name'] = rand(1000,100000)."-".$_FILES['file']['name'];
                    $file['name'] = utf8_decode(utf8_encode($_FILES['file']['name']));

                    // Estes dados são obtidos junto do arquivo selecionado.
                    $file['file'] = $_FILES['file']['tmp_name'];
                    $file['size'] = $_FILES['file']['size'];
                    $file['type'] = $_FILES['file']['type'];
                

                    // Verifica se o dados informado $_POST está vazio antes de ser registrado.
                    // Caso o campo informado estiver vazio, ele receberá um valor pré definido.
                    $file['descrip'] = (isset($_POST['descrip']) && !empty($_POST['descrip']) ?
                        utf8_decode(utf8_encode(trim($_POST['descrip']))) : "Sem descrição."
                    );

                    $file['content'] = (isset($_POST['content']) && !empty($_POST['content']) ?
                        $this->model->getContent(utf8_decode($_POST['content']))["id"] : 0
                    );

                    $file['value'] = (isset($_POST['value']) && !empty($_POST['value']) ?
                        str_replace(",",".",$_POST['value']) : 0.0
                    );
                    
                    $response = $this->model->saveData($file);
                    if($response[0]){
                        move_uploaded_file($file['file'],$this->storage.utf8_decode($file['name']));
                        $this->resp = "Novo item adicionado: ".$file["name"];
                        $this->refresh("List_Item?i=".$_GET["i"]);
                    }else{
                        $this->resp = "Falha ao adicionar o item";
                    }
                }else{
                    $this->resp = "Nenhum arquivo selecionado";
                }
            }
        }

        // Retorna o popup mostrando as formas de pagamento 
        public function payment($data,$total){
            require dirname(__DIR__)."/View/Cards/Payment_card.php";
        }

        public function masterCard($total){
            new Settings("masterCard",$total);
        }

        /** Continuar depois */
        public function message(){
            if(isset($_POST["submit"])){
                if(isset($_POST["title"]) && isset($_POST["email"]) && isset($_POST["content"])){
                    $data = [
                        "title" => $_POST["title"],
                        "email" => $_POST["email"],
                        "content" => wordwrap($_POST["content"],70,"\r\n")
                    ];
                    return $this->settings->sendMessage($data);
                }
            }
            return null;
            /*
            $data = [];
            $response = null;
            $contact = "leo.ribeiro0256@gmail.com";
            if(isset($_POST["submit"])){
                if(isset($_POST["nome"]) && isset($_POST["email"]) && isset($_POST["content"])){
                    $data = [
                        "nome" => $_POST["nome"],
                        "email" => $_POST["email"],
                        "content" => wordwrap($_POST["content"],70,"\r\n")
                    ];

                    $headers = "MIME-Version: 1.0"."\r\n"
                        ."Content-type:text/html;charset=UTF-8"."\r\n"
                        ."From: ".$data["email"]."\r\n"
                        ."CC: ".$contact;
                    $response = mail($contact,$data["nome"],$data["content"],$header);
                    
                }
            }

            return $response;
            */
        }






        // Gera os dados necessários para o 'carrosel' mostrando os conteúdos.
        public function carousel(){
            return $this->item->generateCarousel();
        }


        // Realiza o Log in do cliente.
        private function login(){
            $this->account->makeLogin();
        }
        // Realiza o Log on do clente.
        private function logon(){
            $this->resp = $this->account->makeLogon();
        }


        /* ------ testes ------ */
        

        /** Temporário */
        public function server(){
            foreach ($_SERVER as $key => $value) {
                echo "$key => $value<br><br>";
            }
        }
    }
?>