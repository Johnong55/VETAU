import {getChairs} from "./renderChair.js";
import {ws} from "./ConfirmBook.js";
import {parseDateTime24Hour, calculateTimeDifference} from "./renderTrain.js";

let txt_status = null;

const provinces = {
	1: "HàNội",
	2: "HảiPhòng",
	3: "NamĐịnh",
	4: "NinhBình",
	5: "ThanhHóa",
	6: "NghệAn",
	7: "Vinh",
	8: "HàTĩnh",
	9: "QuảngBình",
	10: "QuảngTrị",
	11: "Huế",
	12: "ĐàNẵng",
	13: "QuảngNam",
	14: "QuảngNgãi",
	15: "BìnhĐịnh",
	16: "PhúYên",
	17: "KhánhHòa",
	18: "NinhThuận",
	19: "BìnhThuận",
	20: "ĐồngNai",
	21: "BìnhDương",
	22: "SàiGòn"
};

function getIndexByValue(obj, value) {
	for (const key in obj) {
		if (obj[key] === value) {
			return key;
		}
	}
	return null;
}

function loadChairHold() {
	let listChairHolds;
	if(localStorage.getItem("listChairHold")) {
		listChairHolds = JSON.parse(localStorage.getItem("listChairHold"));
		console.log(listChairHolds);
		const Chairs = document.querySelectorAll(".seat");
		Chairs.forEach(tmp => {
			Object.keys(listChairHolds).forEach(key => {
				if (tmp.dataset.idseat === key) {
					const son = tmp.dataset.schedulekey.split("-");
					const dad = listChairHolds[key].split("-");
					if(son[0] === dad[0]) {
						if(!(getIndexByValue(provinces, dad[2]) <= getIndexByValue(provinces, son[1]))) {
							tmp.style.backgroundColor = "rgb(196, 196, 196)";
							tmp.style.cursor = "not-allowed";
							tmp.dataset.value = "holding";
						}
					}
				}
			})
		});
	}
}

function chooseChair() {
	let count = 0;
	let chairs = document.querySelectorAll(".seat");
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
function ExitOption(bodyToa) {
	const btn_back = document.querySelector(".chooseChair--back");
	console.log(btn_back);
	btn_back.addEventListener('click', function (){
		bodyToa.classList.remove("scale-out-center");
		bodyToa.classList.remove("scale-up-center");

		bodyToa.classList.add("scale-out-center");

		let chairs = document.querySelectorAll(".seat");
		chairs.forEach(tmp => {
			if (tmp.dataset.status === "selecting") {
				setTimeout(function() {
					tmp.style.backgroundColor = "rgba(0, 0, 0, 0)";
					tmp.dataset.status = "available";
				}, 300);
			}
		});
		document.querySelector(".form-option").remove();
	})
}

function actionBtnNext() {
	const buttonContinue = document.querySelector(".confirmbook");
	console.log(buttonContinue);
		buttonContinue.addEventListener('click', function() {
			let chairHold = {};
			let chairs_selected = [];
			let chairs_duplicate = [];
			const Chairs = document.querySelectorAll(".seat");
			Chairs.forEach(tmp => {
				// lấy ghế đang chọn
				if (tmp.dataset.status === "selecting") {
					chairs_selected.push(tmp);
				}
			});
			chairs_selected.forEach(chair => {
				// xử lí chống trùng
				if (chair.dataset.value !== "holding") {
					console.log(chair.dataset.idseat);
					chairHold[chair.dataset.idseat] = chair.dataset.schedulekey;
				} else if (chair.dataset.value === "holding") {
					chairs_duplicate.push(chair.dataset.nameChair);
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

function loadChair_SoldOut(departureCity, arrivalCity,scheduleId){
	const infoOrder = JSON.parse(sessionStorage.getItem("infoOrder"));
	console.log(infoOrder)
	console.log('/metroway/reserved?startStation='+departureCity+'&endStation='+arrivalCity+'&scheduleId='+scheduleId)
	fetch('/metroway/reserved?startStation='+departureCity+'&endStation='+arrivalCity+'&scheduleId='+scheduleId)
		.then(response => {
			if(!response.ok) console.log("LOI")
			return response.json()
		 	})
		.then(data => {
			 console.log(data)
			 console.log(data.result)
			let listChairHold = data.result
			 const Chairs = document.querySelectorAll(".seat");
			 Chairs.forEach(tmp => {
				 for (let i = 0; i < listChairHold.length; i++) {
					 if (tmp.dataset.idseat === listChairHold[i]) {
						 tmp.style.backgroundColor = "rgb(196, 196, 196)";
						 tmp.style.cursor = "not-allowed";
						 tmp.dataset.value = "holding";
					 }
				 }
			 });
		})
		.catch(error => console.log(error))

}

const wrap_right = document.querySelector("#booking-right-body");
console.log(wrap_right)

wrap_right.addEventListener('click' ,async function (e) {
	console.log(e.target)

	if (e.target.classList.contains("choose-chair")) {
		console.log("chuyen tau " + e.target.dataset.index);
		const index = e.target.dataset.index;
		const listTrainTrip = JSON.parse(sessionStorage.getItem("trainTrip"));
		console.log(listTrainTrip[index]);

		const timeStart = listTrainTrip[index]["departureTimeAtDepartureCity"];
		const timeEnd = listTrainTrip[index]["arrivalTimeAtArrivalCity"];

		const carriages = listTrainTrip[index]["carriages"];
		console.log(carriages)

		const { date: dateStart, time: timeStartFormatted } = parseDateTime24Hour(timeStart);
		const { date: dateEnd, time: timeEndFormatted } = parseDateTime24Hour(timeEnd);

		const difference = calculateTimeDifference(timeStart, timeEnd);

		const data = {
			trainName: listTrainTrip[index]["trainName"],
			scheduleId: listTrainTrip[index]["scheduleId"],
			startCity: listTrainTrip[index]["departureCity"],
			endCity: listTrainTrip[index]["arrivalCity"],
			timeStart: timeStartFormatted,
			timeEnd: timeEndFormatted,
			dateStart: dateStart,
			dateEnd: dateEnd,
			duration: difference,
			departureTime: listTrainTrip[index]["departureTimeAtDepartureCity"],
			arrivalTime: listTrainTrip[index]["arrivalTimeAtArrivalCity"]
		}
		sessionStorage.setItem("infoOrder", JSON.stringify(data));


		const chairsHTML = await getChairs(listTrainTrip[index]["carriages"], listTrainTrip[index]["scheduleKey"]);

		document.body.insertAdjacentHTML('beforeend', chairsHTML);

		const bodyToa = document.querySelector(".modal__body");
		bodyToa.classList.remove("scale-out-center");
		bodyToa.classList.remove("scale-up-center");

		bodyToa.classList.add("scale-up-center");
		const bodyChooseChair = document.querySelector(".form-option");
		bodyChooseChair.style.display = "block";
		loadChairHold();
		loadChair_SoldOut(listTrainTrip[index]["departureCity"], listTrainTrip[index]["arrivalCity"], listTrainTrip[index]["scheduleId"]);
		chooseChair();
		actionBtnNext()
		ExitOption(bodyToa);
	}

})

