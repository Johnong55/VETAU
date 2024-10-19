const btn_book = document.querySelector("#btn-book");
console.log(btn_book);
	btn_book.addEventListener('click', function() {
		console.log("aa");
		fetch('booknow',{
			method: 'POST',
			headers: {'Content-Type': 'application/json'},
			
		})
		.then(response => {
			if(!response.ok) console.log("LỖIIII");
			return response.text()
		})
		.then(data => {
			console.log(data);
			if(data === "ok") {
				window.location.href = "payment.jsp";
			}
		})
		.catch(error => {
			console.log(error);
		})
});