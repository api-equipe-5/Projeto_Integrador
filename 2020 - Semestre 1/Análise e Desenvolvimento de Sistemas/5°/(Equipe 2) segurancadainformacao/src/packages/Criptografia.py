from Crypto.Random import get_random_bytes
from Crypto.Cipher import AES
from Crypto.Hash import SHA3_512
from Crypto import Random
from io import BytesIO

class CriptografiaAES:
    
   
    def criaChave(self):
        #cria chave com o tamanho de 256 bits, que é o limite para o AES
        key = get_random_bytes(32)#32 bytes
        chave={"chave":key}
        return chave

    def criptografar(self, chav, texto):
        #Variaveis
        lista=[]
        crip=''
        #converte o conteudo como String
        texto=str(texto)
        
        #chave
        chavAes = AES.new(chav, AES.MODE_EAX)
        #Encripta
        text, tag = chavAes.encrypt_and_digest(texto.encode("utf8"))
        #cria uma lista de bytes
        [lista.append(x) for x in(chavAes.nonce, tag, text)]
        #Junta as lista de byte
        crip=b''.join(lista)

        return crip
    
    def descriptografar(self, chav, crip):
        #converte os dados em bytes para io
        entrada=BytesIO(crip)

        nonce, tag, text=\
            [entrada.read(x) for x in(16,16,-1)]
        # Descriptografando dados com AES
        chaveAes = AES.new(chav, AES.MODE_EAX, nonce)
        descrip = chaveAes.decrypt_and_verify(text, tag)
        
        return descrip.decode("utf-8")