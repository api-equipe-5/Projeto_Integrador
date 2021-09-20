import api from './api';

export const usuarios = async () => {
    try{
        const response = await api.get('/api/usuarios');
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const cadusu = async (dadosusuario) => {
    try{
        const response = await api.post('/api/add', dadosusuario);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const ediusu = async (data) => {
    try{
        const response = await api.put('/api/edit', data);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const delusu = async (id) => {
    try{
        console.log(id)
        const response = await api.delete('/api/delete', {data:{id:parseInt(id)}});
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}