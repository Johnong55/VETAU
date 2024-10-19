        const add_foods = document.querySelectorAll(".add-food");
        const delete_foods = document.querySelectorAll(".delete-food");
        const name_foods = document.querySelectorAll(".name-food");
        const price_foods = document.querySelectorAll(".price-food");
        const bill = document.querySelector(".bill-content");
        let name_food = "";
        let price_food = "";
        let total_price = "";

        for(let i = 0; i < add_foods.length; i++) {
            add_foods[i].addEventListener('click', function() {
                name_food = name_foods[i].innerText.replace(/(\r\n|\n|\r)/gm, ""); // bỏ xuống dòng các thứ
                let tmp1 = parseInt(price_foods[i].innerText.replace(/\D/g, '')); // lấy số
                price_food = tmp1.toLocaleString('vi-VN'); // định dạng dấu chấm cho số
                console.log(name_food + price_food);
                bill.innerHTML += `
                    <div class="bill-content-item">
                            <div class="bill-content-item-left">
                                ${name_food}
                            </div>
                            <div class="bill-content-item-right">
                                ${price_food} VND
                            </div>
                    </div>
                `;
                let total = document.querySelector(".bill-total-right");
                let tmp2 = parseInt(total.innerText.replace(/\D/g, '')) + tmp1;
                total_price = tmp2.toLocaleString('vi-VN');
                total.innerHTML = `
                    ${total_price} VND
                `;
            });
        };

        for(let i = 0; i < delete_foods.length; i ++) {
            delete_foods[i].addEventListener('click', function () {
                let name_food_Bills = document.querySelectorAll(".bill-content-item-left");
                name_food = name_foods[i].innerText.replace(/(\r\n|\n|\r)/gm, "");
                let tmp1 = parseInt(price_foods[i].innerText.replace(/\D/g, ''));
                for(let i = 0; i < name_food_Bills.length; i++) {
                    if(name_food === name_food_Bills[i].innerText) {
                        bill.removeChild(name_food_Bills[i].parentElement);
                        let total = document.querySelector(".bill-total-right");
                        let tmp2 = parseInt(total.innerText.replace(/\D/g, '')) - tmp1;
                        total_price = tmp2.toLocaleString('vi-VN');
                        total.innerHTML = `
                            ${total_price} VND
                        `;
                        return;
                    }
                }
            });
        };