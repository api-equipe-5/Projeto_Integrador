import axio from 'axios';

const apiFlask = axio.create({
    baseURL: 'http://localhost:5000'
})

export default apiFlask; 