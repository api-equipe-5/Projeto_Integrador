import api from './api';

export const login = async (dadoslogin) => {
    try{
        const response = await api.post('/login/', dadoslogin);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const acesso = async (dadosacesso) => {
    try{
        const response = await api.post('/solicitacao_acesso/solicitar', dadosacesso);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}