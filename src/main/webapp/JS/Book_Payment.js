const btn_book = document.querySelector("#btn-book");
const nameEL = document.querySelector("#name");
const ageEL = document.querySelector("#age");
const genderEL = document.querySelector("#gender");
const sdtEL = document.querySelector("#sdt");
const emailEL = document.querySelector("#email");

console.log(btn_book);
	btn_book.addEventListener('click', function() {
		const payload = {
			name: nameEL.value,
			age: ageEL.value,
			gender: genderEL.value,
			sdt: sdtEL.value,
			email: emailEL.value
		}
		sessionStorage.setItem("userInfo", JSON.stringify(payload));
		window.location.href = "/metroway/payment";
	});