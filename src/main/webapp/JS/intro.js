import {getCookie} from "./Cookie.js";
import {replaceButton} from "./user.js";


const token = getCookie("identify");

console.log(token);

const data = {
    token: token
};

if(token) {
    fetch('auth/introspect', {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    })
        .then(response => {
            if(!response.ok) console.log("LOIIII");
            return response.json();
        })
        .then(data => {
            console.log(data.result);
            data.result.valid ? replaceButton() : console.log("xac thuc that bai");
        })
        .catch(error => {
            console.log(error);
        })
}