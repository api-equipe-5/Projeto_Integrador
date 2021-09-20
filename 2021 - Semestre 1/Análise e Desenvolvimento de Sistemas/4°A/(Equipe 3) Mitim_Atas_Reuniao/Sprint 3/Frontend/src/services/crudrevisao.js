import api from './api';

export const revisoes = async () => {
    try{
        const response = await api.get('/revisao/revisoes');
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const cadrev = async (dadosusuario) => {
    try{
        const response = await api.post('/revisao/add', dadosusuario);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const edirev = async (data) => {
    try{
        const response = await api.put('/revisao/edit', data);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const delrev = async (id) => {
    try{
        console.log(id)
        const response = await api.delete('/revisao/delete', {data:{id:parseInt(id)}});
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}