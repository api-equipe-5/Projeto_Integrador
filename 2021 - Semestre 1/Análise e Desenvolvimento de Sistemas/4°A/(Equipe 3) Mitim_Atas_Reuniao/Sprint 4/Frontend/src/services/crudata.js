import api from './api';

export const atas = async () => {
    try{
        const response = await api.get('/ata/atas');
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const cadata = async (dadosusuario) => {
    try{
        const response = await api.post('/ata/add', dadosusuario);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const ediata = async (data) => {
    try{
        const response = await api.put('/ata/edit', data);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const delata = async (id) => {
    try{
        console.log(id)
        const response = await api.delete('/ata/delete', {data:{id:parseInt(id)}});
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}