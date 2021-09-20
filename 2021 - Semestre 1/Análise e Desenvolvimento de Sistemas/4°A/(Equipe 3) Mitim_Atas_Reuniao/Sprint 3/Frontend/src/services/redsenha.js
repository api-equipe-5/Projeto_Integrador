import api from './api';

export const redsenha = async (data) => {
    try{
        const response = await api.put('/redefinicao_senha/redefinir_senha', data);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}