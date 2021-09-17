from src.packages import CriptografiaAES

cripto = CriptografiaAES()

def user_is_funcionario(chave, user):
    return eval(cripto.descriptografar(chave.chave_privada, user.funcionario))