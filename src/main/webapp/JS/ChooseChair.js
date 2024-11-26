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
					chairHold[chair.dataset.id] = chair.id;
				} else if (chair.dataset.value === "holding") {
					chairs_duplicate.push(chair.id);
					chair.dataset.status = "non_available"
				}
			});
			if (chairs_duplicate.length === 0) {
				console.log(chairHold);
				ws.send(JSON.stringify(chairHold));
				sessionStorage.setItem("chairhold",JSON.stringify(chairHold));
				window.location.href = "/metroway/reviewbooking";
			} else {
				alert("Ghế " + chairs_duplicate + " đã có người vừa chọn!!!");
				// còn xử lí trừ bớt ghế, đợi có id ghế đúng làm cho dễ
			}
		});
}

function open_ViewOption3A(id,chairs) {
	console.log(1);
	console.log(document.body);
	document.body.insertAdjacentHTML('beforeend', getChairs(id, "3A",chairs));
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


const wrap_right = document.querySelector("#booking-right-body");
console.log(wrap_right)

wrap_right.addEventListener('click' ,function (e){
	console.log(e.target)

	if(e.target.classList.contains("option-3A") || e.target.closest(".option-3A")){
		console.log(3);
		const id = (e.target.classList.contains("option-3A")) ? e.target.id : e.target.closest(".option-3A").id;
		console.log(id)
		const idCarriage = (e.target.classList.contains("option-3A")) ? e.target.dataset.id : e.target.closest(".option-3A").dataset.id;
		console.log(idCarriage)
		fetch(`/metroway/seats/carriageID/${idCarriage}`)
			.then(response => {
				if(!response.ok) console.log("LOI")
				return response.json()
			})
			.then(data => {
				console.log(data)
				open_ViewOption3A(id,data);
			})
			.then(error => console.log(error))
	} else if(e.target.classList.contains("option-2A") || e.target.closest(".option-2A")) {
		console.log(2)
		const id = (e.target.classList.contains("option-2A")) ? e.target.id : e.target.closest(".option-2A").id;
		console.log(id)
		open_ViewOption2A(id);
	} else if(e.target.classList.contains("option-1A") || e.target.closest(".option-1A")) {
		console.log(1)
		const id = (e.target.classList.contains("option-1A")) ? e.target.id : e.target.closest(".option-1A").id;
		console.log(id)
		open_ViewOption1A(id);
	}
})

