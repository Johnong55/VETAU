import {checkUsername, checkEmail, checkPassword, checkConfirmPassword} from "./Validate.js"


// login

const emailEl = document.querySelector('#email-login');
const passwordEl = document.querySelector('#password-login');

const btn_login = document.querySelector("#login-button");

btn_login.addEventListener('click', function (e) {
    e.preventDefault();
    console.log(123);
    let isEmail = checkEmail(emailEl),
        isPassword = checkPassword(passwordEl);
    let isFormValid = isPassword && isEmail;

    if(isFormValid) {
        console.log(1);
    }
});

// sign up

const emailEl_sign_up = document.querySelector('#email-signup');
const passwordEl_sign_up = document.querySelector('#password-signup');
const comfirmpasswordEl_sign_up = document.querySelector("#confirm-password-signup");

const btn_sign_up = document.querySelector("#sign-up-btn");

btn_sign_up.addEventListener('click', function (e) {
    e.preventDefault();
    let isEmail = checkEmail(emailEl_sign_up),
        isPassword = checkPassword(passwordEl_sign_up),
        isComfirmPassword = checkConfirmPassword(passwordEl_sign_up, comfirmpasswordEl_sign_up);
    let isFormValid = isPassword && isEmail && isComfirmPassword;

    if(isFormValid) {
        console.log(2);
    }
})
