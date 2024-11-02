import {checkUsername, checkEmail, checkPassword, checkConfirmPassword} from "./Validate.js"
import {Back} from "./login.js";
import {replaceButton} from "./user.js";
import {getCookie} from "./Cookie.js";

// login

const usernameEL = document.querySelector('#username-login');
const passwordEl = document.querySelector('#password-login');

const btn_login = document.querySelector("#login-button");

if(btn_login) {
    btn_login.addEventListener('click', function (e) {
        e.preventDefault();
        console.log(123);
        let isUsername = checkUsername(usernameEL),
            isPassword = checkPassword(passwordEl);
        let isFormValid = isPassword && isUsername;

        if(isFormValid) {
            console.log(usernameEL.value);
            console.log(passwordEl.value);

            const dataLogin = {
                username: usernameEL.value,
                password: passwordEl.value
            };

            fetch('/auth/token', {
                method: "POST",
                headers: {'Content-Type':'application/json'},
                body: JSON.stringify(dataLogin)
            })
                .then(response =>{
                    if(!response.ok) console.log("LOI!!!!")
                    return  response.json();
                })
                .then(data => {
                    console.log(data);
                    const token = data.result.token;
                    document.cookie = `identify=${token}; path=/; max-age=${60 * 60}; secure`;
                    console.log(getCookie("identify"));
                    Back();
                    replaceButton();
                })
                .catch(error => {
                    console.log(error);
                })
        }
    });
}

// sign up

const emailEl_sign_up = document.querySelector('#email-signup');
const passwordEl_sign_up = document.querySelector('#password-signup');
const comfirmpasswordEl_sign_up = document.querySelector("#confirm-password-signup");

const btn_sign_up = document.querySelector("#sign-up-btn");

if(btn_sign_up) {
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
}
