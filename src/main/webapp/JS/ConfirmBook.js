



// Kết nối WebSocket
export const ws = new WebSocket("ws://localhost:8080/metroway/hello");
ws.onopen = function() {
	console.log("WebSocket is open now.");
};

ws.onerror = function(error) {
	console.error('Không thể kết nối tới WebSocket endpoint:', error);
};


ws.onmessage = function(event) {
	let listChairHold = {};
	listChairHold =	JSON.parse(event.data);
	console.log(listChairHold);
	let tmp = JSON.parse(localStorage.getItem("listChairHold"));
	console.log(tmp);
	const newObject = {};
	if(tmp !==null) {
		let count = 0;
		for (const key in tmp) {
			newObject[key] = tmp[key];
			count++;
		}
		for (const key in listChairHold) {
			newObject[count] = listChairHold[key];
			count++;
		}
		console.log(newObject);
		localStorage.setItem("listChairHold",JSON.stringify(newObject));
	} else {
		localStorage.setItem("listChairHold",JSON.stringify(listChairHold));
	}



	const Chairs = document.querySelectorAll(".item-square");
	if(Chairs) {
		Chairs.forEach(tmp => {
			for (let key in listChairHold) {
				if (tmp.id === listChairHold[key]) {
					setTimeout(function() {
						tmp.style.backgroundColor = "rgb(196, 196, 196)";
					}, 300);
					tmp.style.cursor = "not-allowed";
					tmp.dataset.value = "holding";
				}
			}
		});
	}
};

