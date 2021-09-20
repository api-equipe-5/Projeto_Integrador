import axio from 'axios';

const api = axio.create({
    baseURL: 'http://localhost:8080/jumbo'
})

export default api; 