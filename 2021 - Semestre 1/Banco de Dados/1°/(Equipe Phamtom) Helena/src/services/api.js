import axios from "axios";

const api = axios.create({
  baseURL: "https://free.currconv.com/api/v7",
});

export default api;

// https://free.currconv.com/api/v7
// /convert?q=USD_BRL&compact=ultra&apiKey=d8148018a3851e72d0e5