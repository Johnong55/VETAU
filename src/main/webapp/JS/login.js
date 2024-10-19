const login = document.querySelector(".form-login");
const signIn = document.querySelector(".form-signIn");
const body_sigIn = document.querySelector(".body-signIn");
const body_login = document.querySelector(".body-login");
const auth_form_signIn = document.querySelector(".auth-form-signIn");
const auth_form_login = document.querySelector(".auth-form-login");

function removeAnimationClass() {
	body_sigIn.classList.remove("flip-2-ver-right-1", "slide-in-top");
	body_login.classList.remove("flip-2-ver-right-1", "slide-in-top");
	auth_form_login.style.transform = "none";
	auth_form_signIn.style.transform = "none";
}

function Login() {
	removeAnimationClass();
	if (window.getComputedStyle(signIn).display === "block") {
		body_login.classList.add("flip-2-ver-right-1");
		auth_form_login.style.transform = "rotateY(180deg)";
		signIn.style.display = "none";
		login.style.display = "block";
	} else {
		body_login.classList.add("slide-in-top");
		login.style.display = "block";
	}
}

function SignIn() {
	removeAnimationClass();
	if (window.getComputedStyle(login).display === "block") {
		body_sigIn.classList.add("flip-2-ver-right-1");
		auth_form_signIn.style.transform = "rotateY(180deg)";
		login.style.display = "none";
		signIn.style.display = "block";
	} else {
		body_sigIn.classList.add("slide-in-top");
		signIn.style.display = "block";
	}
}
function Back() {
	removeAnimationClass();
	if (login.style.display === "block") {
		body_login.classList.add("slide-out-top");
		setTimeout(function() {
			login.style.display = "none";
		}, 300);
	}
	if (signIn.style.display === "block") {
		body_sigIn.classList.add("slide-out-top");
		setTimeout(function() {
			signIn.style.display = "none";
		}, 300);
	}
}