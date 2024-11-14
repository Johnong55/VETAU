const btn_book = document.querySelector("#btn-book");
const nameEL = document.querySelector("#name");
const ageEL = document.querySelector("#age");
const genderEL = document.querySelector("#gender");
const sdtEL = document.querySelector("#sdt");
const emailEL = document.querySelector("#email");

const payload = {
	name: nameEL.value,
	age: ageEL.value,
	gender: genderEL.value,
	sdt: sdtEL.value,
	email: emailEL.value
}

console.log(btn_book);
	btn_book.addEventListener('click', function() {
		console.log(12)
		fetch('booknow',{
			method: 'POST',
			headers: {'Content-Type':'application/json'},
			body: JSON.stringify(payload)
		})
			.then(response =>{
				if(!response.ok) {
					console.log("LỖIIIII");
				}
				return response.text();
			})
			.then(data => {
				if(data === "ok") {
					localStorage.setItem("userInfo", JSON.stringify(payload));
					window.location.href = "/metroway/payment";
				}
			})
			.catch(error => {
				console.log(error);
			})
	});