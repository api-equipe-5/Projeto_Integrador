import axios from "axios"

const ATAS_REST_API_URL = 'http://localhost:8080/api/atas'

class AtasService {
    getAtas(){
        return axios.get(ATAS_REST_API_URL);  
    }

}

export default new AtasService();