const isAuth = ()=>{
    if(localStorage.getItem("token")){
        return true;
    }else{
        return false;
    }
}

export default isAuth;