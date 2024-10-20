const listChair = document.querySelector("#listChair");
const numberOfChair = document.querySelector("#numberofchair");
const total_bill = document.querySelector("#total-bill");


const chairHold = JSON.parse(localStorage.getItem("chairhold"));
console.log(chairHold);
if(chairHold) {
    numberOfChair.innerHTML = Object.keys(chairHold).length;

    let chair_String = "";
    Object.values(chairHold).forEach(tmp => {
        chair_String += tmp + ", ";
    });
    chair_String = chair_String.slice(0, -2);
    listChair.innerHTML = chair_String;
}

let money = 200000*(Object.keys(chairHold).length) + 50000;
total_bill.innerHTML = money.toLocaleString('vi-VN') + " VND"; // đổi sang định dạng có dấu chấm. VD 200.000