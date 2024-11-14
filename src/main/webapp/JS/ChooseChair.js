import {getChairs} from "./renderChair.js";
import {ws} from "./ConfirmBook.js";


const option3As = document.querySelectorAll(".option-3A");
const option2As = document.querySelectorAll(".option-2A");
const option1As = document.querySelectorAll(".option-1A");
let txt_status = null;


function loadChairHold() {
	let listChairHold;
	if(localStorage.getItem("listChairHold")!=='[object Object]') {
		listChairHold = JSON.parse(localStorage.getItem("listChairHold"));
		console.log(listChairHold);
	}
	const Chairs = document.querySelectorAll(".item-square");
	Chairs.forEach(tmp => {
		for (let key in listChairHold) {
			if (tmp.id === listChairHold[key]) {
				tmp.style.backgroundColor = "rgb(196, 196, 196)";
				tmp.style.cursor = "not-allowed";
				tmp.dataset.value = "holding";
			}
		}
	});
}

function chooseChair() {
	let count = 0;
	let chairs = document.querySelectorAll(".item-square");
	chairs.forEach(tmp => {
		tmp.addEventListener('click', function() {
			const style = window.getComputedStyle(tmp);
			if (style.backgroundColor === "rgba(0, 0, 0, 0)") {
				tmp.style.backgroundColor = "rgb(245, 148, 92)";
				tmp.dataset.status = "selecting"
				count++;
			} else if (style.backgroundColor === "rgb(245, 148, 92)") {
				tmp.style.backgroundColor = "rgba(0, 0, 0, 0)";
				tmp.dataset.status = "available";
				count--;
			}
			const parent = tmp.closest(".auth-form-option-container");
			txt_status = parent.querySelector(".text-status");
			txt_status.textContent = "Đã chọn: " + count;

		});
	});
}
function ExitOption(toa, bodyToa, form_option) {
	const id_btn_back = "option-back-" + toa;
	const btn_back = document.getElementById(id_btn_back);
	console.log(btn_back);
	btn_back.addEventListener('click', function (){
		bodyToa.classList.remove("scale-out-center");
		bodyToa.classList.remove("scale-up-center");

		bodyToa.classList.add("scale-out-center");

		setTimeout(function() {
			form_option.style.display = "none";
		}, 200);
		let chairs = document.querySelectorAll(".item-square");
		chairs.forEach(tmp => {
			if (tmp.dataset.status === "selecting") {
				setTimeout(function() {
					tmp.style.backgroundColor = "rgba(0, 0, 0, 0)";
					tmp.dataset.status = "available";
				}, 300);
			}
		});
		let idForm = "form-option-" + toa;
		const form = document.getElementsByClassName(idForm);
		Object.values(form).forEach(tmp => {
			tmp.remove();
		})
	})
}

function actionBtnNext() {
	const buttonContinue = document.querySelector(".confirmbook");
	console.log(buttonContinue);
		buttonContinue.addEventListener('click', function() {
			let chairHold = {};
			let key = 0;
			let chairs_selected = [];
			let chairs_duplicate = [];
			const Chairs = document.querySelectorAll(".item-square");
			Chairs.forEach(tmp => {
				// lấy ghế đang chọn
				if (tmp.dataset.status === "selecting") {
					chairs_selected.push(tmp);
				}
			});
			chairs_selected.forEach(chair => {
				// xử lí chống trùng
				if (chair.dataset.value !== "holding") {
					chairHold[key] = chair.id;
					key++;
				} else if (chair.dataset.value === "holding") {
					chairs_duplicate.push(chair.id);
					chair.dataset.status = "non_available"
				}
			});
			if (chairs_duplicate.length === 0) {
				console.log(chairHold);
				ws.send(JSON.stringify(chairHold));
				// ok đéo trùng, tạo gói data truyền đi ghế chọn sang confirmbookservlet,
				// rồi lưu ghế vào session, lấy ra ở reviewbooking
				fetch('confirmbook', {
					method: 'POST',
					headers: { 'Content-Type': 'application/json' },
					body: JSON.stringify(chairHold)

				})
					.then(response => {
						if (!response.ok) console.log("LỖIIII");
						return response.text()
					})
					.then(data => {
						console.log(data);
						if (data === "ok") {
							localStorage.setItem("chairhold",JSON.stringify(chairHold));
							window.location.href = "/metroway/reviewbooking";
						}
					})
					.catch(error => {
						console.log(error);
					})
			} else {
				alert("Ghế " + chairs_duplicate + " đã có người vừa chọn!!!");
				// còn xử lí trừ bớt ghế, đợi có id ghế đúng làm cho dễ
			}
		});
}

function open_ViewOption3A(id) {
	console.log(1);
	console.log(document.body);
	document.body.insertAdjacentHTML('beforeend', getChairs(id, "3A"));
	let idBody = id + "-3A-chair"
	const bodyToa = document.getElementById(idBody);
	bodyToa.classList.remove("scale-out-center");
	bodyToa.classList.remove("scale-up-center");

	bodyToa.classList.add("scale-up-center");
	const id_form_option_3A = "form-option-" + id +"-3A";
	const form_option_3A = document.getElementById(id_form_option_3A);
	form_option_3A.style.display = "block";
	loadChairHold();
	chooseChair();
	actionBtnNext();
	ExitOption("3A",bodyToa,form_option_3A);

}

function open_ViewOption2A(id) {

	document.body.insertAdjacentHTML('beforeend', getChairs(id, "2A"));
	console.log(document.body);
	let idBody = id + "-2A-chair"
	const bodyToa = document.getElementById(idBody);
	bodyToa.classList.remove("scale-out-center");
	bodyToa.classList.remove("scale-up-center");

	bodyToa.classList.add("scale-up-center");
	const id_form_option_2A = "form-option-" + id +"-2A";
	const form_option_2A = document.getElementById(id_form_option_2A);
	form_option_2A.style.display = "block";
	chooseChair();
	ExitOption("2A",bodyToa,form_option_2A);
}

function open_ViewOption1A(id) {

	document.body.insertAdjacentHTML('beforeend', getChairs(id, "1A"));
	console.log(document.body);
	let idBody = id + "-1A-chair"
	const bodyToa = document.getElementById(idBody);
	bodyToa.classList.remove("scale-out-center");
	bodyToa.classList.remove("scale-up-center");

	bodyToa.classList.add("scale-up-center");
	const id_form_option_1A = "form-option-" + id +"-1A";
	const form_option_1A = document.getElementById(id_form_option_1A);
	form_option_1A.style.display = "block";
	chooseChair();
	ExitOption("1A",bodyToa,form_option_1A);
}

option3As.forEach(option_3A => {
	option_3A.addEventListener('click', function() {
		console.log(2);
		// lấy index ra truyền dô hàm, gắn đại dô thử nè
		const id = option_3A.id;
		open_ViewOption3A(id);
	});
});

option2As.forEach(option_2A => {
	option_2A.addEventListener('click', function() {
		// lấy index ra truyền dô hàm, gắn đại dô thử nè
		const id = option_2A.id;
		open_ViewOption2A(id);
	});
});

option1As.forEach(option_1A => {
	option_1A.addEventListener('click', function() {
		// lấy index ra truyền dô hàm, gắn đại dô thử nè
		const id = option_1A.id;
		open_ViewOption1A(id);
	});
});


