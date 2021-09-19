let btnSignin = document.querySelector("#signin")
let btnRegister = document.querySelector("#register")
let body = document.querySelector("body")

btnSignin.addEventListener("click", function () {
    body.className = "sign-in-js"
})

btnRegister.addEventListener("click", function () {
    body.className = "register-js"
})

