import api from './api';

export const assuntos = async () => {
    try{
        const response = await api.get('/assunto/assuntos');
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const cadast = async (dadosusuario) => {
    try{
        const response = await api.post('/assunto/add', dadosusuario);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const ediast = async (data) => {
    try{
        const response = await api.put('/assunto/edit', data);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const delast = async (id) => {
    try{
        console.log(id)
        const response = await api.delete('/assunto/delete', {data:{id:parseInt(id)}});
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}