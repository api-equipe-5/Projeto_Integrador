class Session():

    def __init__(self):
        self.session = dict()


    def addUser(self, user):
        self.session[user.email] = user


    def removeUser(self, user):
        if user.name in self.session:
            self.session.pop(user.email)
        else:
            print(f'ERRO: O usuário {user.name} não foi removido pois ele não está na sessão')
    

    

        
    
