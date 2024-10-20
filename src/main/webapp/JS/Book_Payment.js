const btn_book = document.querySelector("#btn-book");
console.log(btn_book);
	btn_book.addEventListener('click', function() {
		console.log("aa");
		window.location.href = "/payment";
	});