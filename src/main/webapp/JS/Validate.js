export function checkUsername(usernameEl) {

    let valid = false;

    const min = 3,
        max = 25;

    const username = usernameEl.value.trim();

    if (!isRequired(username)) {
        showError(usernameEl, 'Tên đăng nhập không thể trống.');
    } else if (!isBetween(username.length, min, max)) {
        showError(usernameEl, `Tên đăng nhập phải từ ${min} đến ${max} kí tự.`)
    } else {
        showSuccess(usernameEl);
        valid = true;
    }
    return valid;
};


export function checkEmail(emailEl) {
    let valid = false;
    const email = emailEl.value.trim();
    if (!isRequired(email)) {
        showError(emailEl, 'Email không thể trống.');
    } else if (!isEmailValid(email)) {
        showError(emailEl, 'Email không hợp lệ.')
    } else {
        showSuccess(emailEl);
        valid = true;
    }
    return valid;
};

export function checkPassword(passwordEl) {
    let valid = false;


    const password = passwordEl.value.trim();

    if (!isRequired(password)) {
        showError(passwordEl, 'Mật khẩu không thể trống.');
    } else if (!isPasswordSecure(password)) {
        showError(passwordEl, 'Mật khẩu phải có ít nhất 8 ký tự bao gồm ít nhất 1 ký tự viết thường, 1 ký tự viết hoa, 1 số và 1 ký tự đặc biệt (!@#$%^&*)');
    } else {
        showSuccess(passwordEl);
        valid = true;
    }

    return valid;
};

export function checkConfirmPassword(passwordEl, confirmPasswordEl) {
    let valid = false;
    // check confirm password
    const confirmPassword = confirmPasswordEl.value.trim();
    const password = passwordEl.value.trim();

    if (!isRequired(confirmPassword)) {
        showError(confirmPasswordEl, 'Vui lòng nhập lại mật khẩu');
    } else if (password !== confirmPassword) {
        showError(confirmPasswordEl, 'Mật khẩu không đúng');
    } else {
        showSuccess(confirmPasswordEl);
        valid = true;
    }

    return valid;
};

const isEmailValid = (email) => {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
};

const isPasswordSecure = (password) => {
    const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    return re.test(password);
};

const isRequired = value => value === '' ? false : true;
const isBetween = (length, min, max) => length < min || length > max ? false : true;


const showError = (input, message) => {
    // get the form-field element
    const formField = input.parentElement;
    // add the error class
    formField.classList.remove('success');
    formField.classList.add('error');

    // show the error message
    const error = formField.querySelector('small');
    error.textContent = message;
};

const showSuccess = (input) => {
    // get the form-field element
    const formField = input.parentElement;

    // remove the error class
    formField.classList.remove('error');
    formField.classList.add('success');

    // hide the error message
    const error = formField.querySelector('small');
    error.textContent = '';
}


// form.addEventListener('submit', function (e) {
//     // prevent the form from submitting
//     e.preventDefault();
//
//     // validate fields
//     let isUsernameValid = checkUsername(),
//         isEmailValid = checkEmail(),
//         isPasswordValid = checkPassword(),
//         isConfirmPasswordValid = checkConfirmPassword();
//
//     let isFormValid = isUsernameValid &&
//         isEmailValid &&
//         isPasswordValid &&
//         isConfirmPasswordValid;
//
//     // submit to the server if the form is valid
//     if (isFormValid) {
//
//     }
// });