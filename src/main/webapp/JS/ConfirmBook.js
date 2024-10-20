



// Kết nối WebSocket
const ws = new WebSocket("ws://localhost:8080/hello");
ws.onopen = function() {
	console.log("WebSocket is open now.");
};

ws.onerror = function(error) {
	console.error('Không thể kết nối tới WebSocket endpoint:', error);
};

ws.onmessage = function(event) {
	let listChairHold = JSON.parse(event.data);
	const Chairs = document.querySelectorAll(".item-square");

	Chairs.forEach(tmp => {
		for (let i = 0; i < listChairHold.length; i++) {
			if (tmp.id == listChairHold[i]) {
				setTimeout(function() {
					tmp.style.backgroundColor = "rgb(196, 196, 196)";
				}, 300);
				tmp.style.cursor = "not-allowed";
				tmp.dataset.value = "holding";
			}
		}
	});
};


const buttonContinues = document.querySelectorAll(".confirmbook");
console.log(buttonContinues);
buttonContinues.forEach(buttonContinue => {
	buttonContinue.addEventListener('click', function() {
		let chairHold = {};
		let key = 0;
		let chairs_selected = [];
		let chairs_duplicate = [];
		const Chairs = document.querySelectorAll(".item-square");
		Chairs.forEach(tmp => {
			// lấy ghế đang chọn
			console.log(tmp.dataset.status);
			if (tmp.dataset.status == "selecting") {
				chairs_selected.push(tmp);
			}
		});
		chairs_selected.forEach(chair => {
			// xử lí chống trùng
			if (chair.dataset.value != "holding") {
				chairHold[key] = chair.id;
				key++;
			} else if (chair.dataset.value == "holding") {
				chairs_duplicate.push(chair.id);
				chair.dataset.status = "non_available"
			}
		});
		if (chairs_duplicate.length === 0) {
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
						window.location.href = "/reviewbooking";
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
});




