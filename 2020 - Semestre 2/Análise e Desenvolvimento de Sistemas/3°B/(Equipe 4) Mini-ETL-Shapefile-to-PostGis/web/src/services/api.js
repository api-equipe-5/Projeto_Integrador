import axios from 'axios';

const api = axios.create({
    baseURL: "https://fathomless-harbor-71902.herokuapp.com/"
    //baseURL:'http://localhost:8080'
});

export default api;
