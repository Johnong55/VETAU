



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
	if(tmp !==null) {
		const newObject = { ...tmp, ...listChairHold };
		console.log(newObject);
		localStorage.setItem("listChairHold",JSON.stringify(newObject));
	} else {
		localStorage.setItem("listChairHold",JSON.stringify(listChairHold));
	}
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

	const Chairs = document.querySelectorAll(".seat");
	if(Chairs) {
		Chairs.forEach(tmp => {
			Object.keys(listChairHold).forEach(key => {
				if (tmp.dataset.idseat === key) {
					const son = tmp.dataset.schedulekey.split("-");
					const dad = listChairHold[key].split("-");
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
};

