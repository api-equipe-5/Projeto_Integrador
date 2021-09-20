import api from './api';

export const apracesso = async (data) => {
    try{
        const response = await api.put('/aprova_acesso/aprovar', data);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}