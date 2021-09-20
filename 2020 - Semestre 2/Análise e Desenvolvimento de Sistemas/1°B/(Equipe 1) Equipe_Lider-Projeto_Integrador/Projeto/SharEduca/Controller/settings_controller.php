<?php
    namespace Controller;

    use Model\Model;
    use PHPMailer\PHPMailer\PHPMailer;
    use PHPMailer\PHPMailer\SMTP;
    use PHPMailer\PHPMailer\Exception;

    include_once dirname(__DIR__)."\Model\model.php";
    require_once dirname(__DIR__)."\settings\PHPMailer\PHPMailer.php";
    require_once dirname(__DIR__)."\settings\PHPMailer\SMTP.php";
    require_once dirname(__DIR__)."\settings\PHPMailer\Exception.php";

    // Classe responsável por efetuar pagamentos e enviar mensagens
    Class Settings{
        private $model;

        private $email = [
            "user" => "", // E-mail do SMTP
            "pass" => "" // Senha do SMTP
        ];

        private $mastercard = [
            "MerchantID" => "", // 
            "ApiPass" => "", //
            "OrderID" => "21"
        ];

        
        public function sendMessage($data){
            $mail = new PHPMailer(True);

            try{
                $mail->isSMTP();
                $mail->Host = "smtp.gmail.com";
                $mail->SMTPAuth = True;
                $mail->Username = $this->email["user"];
                $mail->Password = $this->email["pass"];
                $mail->Port = 587;

                $mail->setFrom($data["email"]);
                $mail->addAddress($data["email"]);

                $mail->isHTML(True);
                $mail->Subject = $data["title"];
                $mail->Body = $data["content"];
                $mail->AltBody = $data["title"];

                if($mail->send()){
                    return "E-mail enviado com sucesso";
                }else{
                    return "E-mail não enviado";
                }
            }catch (Exception $e){
                return "Erro: ".$mail->ErrorInfo;
            }
            //*/
        }

        public function masterCard($total){
            $amount = number_format($total,2,".",""); // Valor total da compra
            $returnURL = "http://127.0.0.1/myfiles/Equipe_Lider-Projeto_Integrador/Projeto/SharEduca/Carrinho";
            $currency = "AED";

            $ch = curl_init();

            curl_setopt($ch,CURLOPT_URL,"https://ap-gateway.mastercard.com/api/nvp/version/49");
            curl_setopt($ch,CURLOPT_RETURNTRANSFER,1);
            curl_setopt($ch,CURLOPT_POST,1);
            curl_setopt($ch,CURLOPT_POSTFIELDS,"apiOperation=CREATE_CHECKOUT_SESSION&"
            ."apiPassword=".$this->mastercard['ApiPass']."&"
            ."interaction.returnUrl=$returnURL&"
            ."apiUsername=merchant.".$this->mastercard['MerchantID']."&merchant=".$this->mastercard['MerchantID']."&"
            ."order.id=".$this->mastercard['orderID']."&order.amount=$amount&order.currency=$currency");

            $headers = array();
            $headers[] = "Content-Type: application/x-www-form-urlencoded";
            curl_setopt($ch,CURLOPT_HTTPHEADER,$headers);

            $result = curl_exec($ch);
            if(curl_errno($ch)){
                echo "Erro: ".curl_error($ch);
            }

            curl_close($ch);
            $sessionId = explode("=",explode("&",$result)[2])[1];
            require dirname(__DIR__)."\View\MasterCard.php";
        }
    }
?>