const form_option_3A = document.querySelector(".form-option-3A");
const form_option_2A = document.querySelector(".form-option-2A");
const form_option_1A = document.querySelector(".form-option-1A");
const body_3A = document.querySelector(".body-option-3A");
const body_2A = document.querySelector(".body-option-2A");
const body_1A = document.querySelector(".body-option-1A");
const option3As = document.querySelectorAll(".option-3A");
const option2As = document.querySelectorAll(".option-2A");
const option1As = document.querySelectorAll(".option-1A");
const chairs = document.querySelectorAll(".item-square");
let txt_status = null;
let count = 0;


function ExitOption_3A() {

	body_3A.classList.remove("scale-out-center");
	body_3A.classList.remove("scale-up-center");

	body_3A.classList.add("scale-out-center");

	setTimeout(function() {
		form_option_3A.style.display = "none";
	}, 200);
	chairs.forEach(tmp => {
		if (tmp.dataset.status == "selecting") {
			setTimeout(function() {
				tmp.style.backgroundColor = "rgba(0, 0, 0, 0)";
				tmp.dataset.status = "available";
			}, 300);
		}
	});
	count = 0;
	if (txt_status) {
		txt_status.textContent = "Đã chọn: " + count;
	}
}

function ExitOption_2A() {

	body_2A.classList.remove("scale-out-center");
	body_2A.classList.remove("scale-up-center");

	body_2A.classList.add("scale-out-center");

	setTimeout(function() {
		form_option_2A.style.display = "none";
	}, 200);
	chairs.forEach(tmp => {
		if (tmp.dataset.status == "selecting") {
			setTimeout(function() {
				tmp.style.backgroundColor = "rgba(0, 0, 0, 0)";
				tmp.dataset.status = "available";
			}, 300);
		}
	});
	count = 0;
	if (txt_status) {
		txt_status.textContent = "Đã chọn: " + count;
	}
}

function ExitOption_1A() {

	body_1A.classList.remove("scale-out-center");
	body_1A.classList.remove("scale-up-center");

	body_1A.classList.add("scale-out-center");

	setTimeout(function() {
		form_option_1A.style.display = "none";
	}, 200);
	chairs.forEach(tmp => {
		if (tmp.dataset.status == "selecting") {
			setTimeout(function() {
				tmp.style.backgroundColor = "rgba(0, 0, 0, 0)";
				tmp.dataset.status = "available";
			}, 300);
		}
	});
	count = 0;
	if (txt_status) {
		txt_status.textContent = "Đã chọn: " + count;
	}
}

function open_ViewOption3A(data_index) {

	body_3A.classList.remove("scale-out-center");
	body_3A.classList.remove("scale-up-center");

	body_3A.classList.add("scale-up-center");
	form_option_3A.style.display = "block";
}

function open_ViewOption2A(data_index) {

	body_2A.classList.remove("scale-out-center");
	body_2A.classList.remove("scale-up-center");

	body_2A.classList.add("scale-up-center");
	form_option_2A.style.display = "block";
}

function open_ViewOption1A(data_index) {

	body_1A.classList.remove("scale-out-center");
	body_1A.classList.remove("scale-up-center");

	body_1A.classList.add("scale-up-center");
	form_option_1A.style.display = "block";
}

option3As.forEach(option_3A => {
	option_3A.addEventListener('click', function() {
		// lấy index ra truyền dô hàm, gắn đại dô thử nè
		const data_index = 0;
		open_ViewOption3A(data_index);
	});
});

option2As.forEach(option_3A => {
	option_3A.addEventListener('click', function() {
		// lấy index ra truyền dô hàm, gắn đại dô thử nè
		const data_index = 0;
		open_ViewOption2A(data_index);
	});
});

option1As.forEach(option_3A => {
	option_3A.addEventListener('click', function() {
		// lấy index ra truyền dô hàm, gắn đại dô thử nè
		const data_index = 0;
		open_ViewOption1A(data_index);
	});
});

chairs.forEach(tmp => {
	tmp.addEventListener('click', function() {
		const style = window.getComputedStyle(tmp);
		console.log(style.backgroundColor);
		if (style.backgroundColor === "rgba(0, 0, 0, 0)") {
			tmp.style.backgroundColor = "rgb(245, 148, 92)";
			tmp.dataset.status = "selecting"
			count++;
		} else if (style.backgroundColor === "rgb(245, 148, 92)") {
			tmp.style.backgroundColor = "rgba(0, 0, 0, 0)";
			tmp.dataset.status = "available";
			count--;
		}
		console.log(count);
		const parent = tmp.closest(".auth-form-option-container");
		txt_status = parent.querySelector("#text-status");
		txt_status.textContent = "Đã chọn: " + count;

	});
});