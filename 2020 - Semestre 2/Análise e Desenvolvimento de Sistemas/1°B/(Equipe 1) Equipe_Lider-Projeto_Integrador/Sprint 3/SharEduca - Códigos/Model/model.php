<?php
    namespace Model;

    use Model\Connection;
    include_once "connection.php";

    // Classe responsável por fazer requisições ao banco de dados.
    Class Model{
        var $con;

        public function __construct(){
            $this->con = new Connection();
        }
        
        public function getUser($id){
            $sql = (gettype($id) == "integer" ?
                "select * from Usuario where id = $id" 
                :
                'select * from Usuario where nome like "'.$id.'" or email like "'.$id.'"'
            );
            $data = $this->con->execute($sql);
            if($data[0]){
                return $data[1]->fetch_assoc();
            }else{
                return False;
            }
            
        }

        public function setUser($var){
            $sql = "insert into Usuario(nome,email,senha) values ("
                .'"'.$var["nome"].'",'
                .'"'.$var["email"].'",'
                .'"'.$var["senha"].'")';
            
            $request = $this->con->execute($sql);
            if ($request[0]){
                return $request[1];
            }else{
                return $request;
            }
        }

        /* Descontinuado
        public function addItemCart($cart, $item){
            $request = $this->con->execute(
                "call add_ItemCarrinho($cart, $item);"
            );
            if($request[0] == True){
                return "Item adicionado ao Carrinho.";
            }else{
                return "Erro ao adicionar o Item.";
            }
        }

        public function clearCart($cart){
            $request = $this->con->execute(
                "call clear_ItemCarrinho($cart);"
            );
            if($request[0] == True){
                return "Carrinho esvaziado.";
            }else{
                return "Erro ao limpar o Carrinho.";
            }
        }

        public function rmItemCart($cart, $item){
            $request = $this->con->execute(
                "call remove_ItemCarrinho($cart, $item);"
            );
            if($request[0] == True){
                return "Item removido.";
            }else{
                return "Erro ao remover o Item do Carrinho.";
            }
        }
        */

        /* teste */
        public function itemCart($action,$user,$item=null){
            $sql = "";
            switch ($action) {
                case 'add':
                    $sql = "call add_ItemCarrinho($user, $item);";
                    break;
                
                case 'remove':
                    $sql = "call remove_ItemCarrinho($user, $item);";
                    break;

                case 'clear':
                    $sql = "call clear_Carrinho($user);";
                    break;
            }
            return $this->con->execute($sql);

        }

        /* precisa de descrição */
        public function getCartInfo($user_id){
            $sql = "select item from Carrinho where usuario = $user_id;";
            $item_id = $this->con->execute($sql);
            $item = $data = $request = [];

            if($item_id[0]){
                while ($row = mysqli_fetch_array($item_id[1])){
                    $data[] = $row;
                }
                for($x=0;$x<count($data);$x++){
                    $sql = "select * from Item where id = ".$data[$x]["item"];
                    $item = $this->con->execute($sql);

                    if($item[0]){
                        $request[$x] = $item[1]->fetch_assoc();

                        $request[$x]["nome"] = utf8_encode($request[$x]["nome"]);
                        $request[$x]["descrip"] = utf8_encode($request[$x]["descrip"]);

                        $size = $request[$x]["tamanho"] / 1024;
                        if($size < 1024){
                            $request[$x]["tamanho"] = number_format($size,2,",",".")."KB";
                        }else{
                            $request[$x]["tamanho"] = number_format($size / 1024,2,",",".")."MB";
                        }
                        
                    }
                }
                // Retorna os dados separados por arrays
                return $request;

            }else{
                // Retorna a mensagem de erro obtida
                return "Nenhum item no carrinho";
            }

        }

        /*  */

        public function getContent($var){
            $sql = "select * from Conteudo where ";

            $sql = (gettype($var) == "integer" ? 
                $sql."id = $var limit 1" : $sql."nome = \"$var\" limit 1;"
            );

            return $this->rowRequest($sql, True);
        }

        public function getAllContent(){
            $sql = "select * from Conteudo;";
            return $this->rowRequest($sql);
        }

        public function getItem($nome){
            $sql = "select * from Item where nome = \"$nome\" limit 1;";
            return $this->rowRequest($sql, True);
        }

        public function getAllItens($id){
            $sql = "select * from Item where conteudo = $id;";
            return $this->rowRequest($sql);
        }

        private function rowRequest($sql, $one_row=False){
            $request = $this->con->execute($sql);
            $array = [];
            
            if($request[0] && $request[1]->num_rows>0){

                if($one_row){
                    return $request[1]->fetch_assoc();
                }else{
                    while ($row = mysqli_fetch_array($request[1])){
                        $array[] = $row;
                    }

                    return $array;
                }
                
                return "Falha ao retornar a requisição";

            }else{
                return "Falha de comunicação com o banco de dados";
            }
        }

        public function newContent($content){

            $sql = "insert into Conteudo(nome,descrip,img) values ('".
                utf8_decode($content['name'])."','".
                utf8_decode($content['descrip'])."','".
                utf8_decode($content['img'])
            ."');";
            return $this->con->execute($sql);
        }

        public function saveData($file){

            $sql = "insert into Item(nome,tipo,tamanho,conteudo,descrip,valor) values ('".
                utf8_decode($file["name"])."','".
                $file["type"]."',".
                $file["size"].",".
                $file["content"].",'".
                utf8_decode($file["descrip"])."',".
                $file["value"]
            .");";
            return $this->con->execute($sql);
        }
    }
?>