const listChair = document.querySelector("#listChair");
const numberOfChair = document.querySelector("#numberofchair");
const total_bill = document.querySelector("#total-bill");


const chairHold = JSON.parse(sessionStorage.getItem("chairhold"));
console.log(chairHold);
if(chairHold) {
    numberOfChair.innerHTML = Object.keys(chairHold).length.toString();

    let chair_String = "";
    Object.values(chairHold).forEach(tmp => {
        const parts = tmp.split("-");
        const dm = `${parts[0]}-${parts[1]}`;
        console.log(dm)
        chair_String += dm + ", ";
    });
    chair_String = chair_String.slice(0, -2);
    sessionStorage.setItem("nameChairs",chair_String)
    listChair.innerHTML = chair_String;
}
const infoOrder = JSON.parse(sessionStorage.getItem("infoOrder"));
const trainNameEL = document.querySelector(".name-train");
trainNameEL.innerHTML = infoOrder.trainName;

const dateStartEL = document.querySelector(".day-start");
dateStartEL.innerHTML = infoOrder.dateStart;
const timeStartEL = document.querySelector(".hour-start");
timeStartEL.innerHTML = infoOrder.timeStart;
const cityStartEL = document.querySelector(".location-start");
cityStartEL.innerHTML = infoOrder.startCity;

const dateEndEL = document.querySelector(".day-end");
dateEndEL.innerHTML = infoOrder.dateEnd;
const timeEndEL = document.querySelector(".hour-end");
timeEndEL.innerHTML = infoOrder.timeEnd;
const cityEndEL = document.querySelector(".location-end");
cityEndEL.innerHTML = infoOrder.endCity;

const durEL = document.querySelector(".hour-illus");
durEL.innerHTML = infoOrder.duration;



let money = 200000*(Object.keys(chairHold).length) + 50000;
total_bill.innerHTML = money.toLocaleString('vi-VN') + " VND"; // đổi sang định dạng có dấu chấm. VD 200.000


if(sessionStorage.getItem("userInfo")) {
    const user = JSON.parse(sessionStorage.getItem("userInfo"));
    document.querySelector(".name-user").value = user.name;
    document.querySelector(".age-user").value = user.age;
    document.querySelector(".gender-user").value = user.gender;
    document.querySelector(".sdt-user").value = user.sdt
    document.querySelector(".email-user").value = user.email;
}