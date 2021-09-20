import api from './api';

export const participantes = async () => {
    try{
        const response = await api.get('/participante/participantes');
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const cadpart = async (dadosusuario) => {
    try{
        const response = await api.post('/participante/add', dadosusuario);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const edipart = async (data) => {
    try{
        const response = await api.put('/participante/edit', data);
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}

export const delpart = async (id) => {
    try{
        console.log(id)
        const response = await api.delete('/participante/delete', {data:{id:parseInt(id)}});
        console.log(response);
        return response;
      }
      catch (err) {
          console.log(err);
          return err;
      }
}