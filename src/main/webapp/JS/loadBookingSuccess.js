const infoOrder = JSON.parse(sessionStorage.getItem("infoOrder"));
const trainNameEL = document.querySelector(".name-train");
trainNameEL.innerHTML = infoOrder.trainName;
console.log(infoOrder)

document.querySelector(".day-start").innerHTML = infoOrder.dateStart;
document.querySelector(".hour-start").innerHTML = infoOrder.timeStart;
document.querySelector(".location-start").innerHTML = infoOrder.startCity;

document.querySelector(".day-end").innerHTML = infoOrder.dateEnd;
document.querySelector(".hour-end").innerHTML = infoOrder.timeEnd;
document.querySelector(".location-end").innerHTML = infoOrder.endCity;

document.querySelector(".hour-illus").innerHTML = infoOrder.duration;

document.querySelector(".name-chair").innerHTML = sessionStorage.getItem("nameChairs");
console.log(sessionStorage.getItem("nameChairs"))


const tmp1 = parseInt(sessionStorage.getItem("amount"));


document.querySelector("#abc").innerHTML = tmp1.toLocaleString('vi-VN') + " VND";

const user = JSON.parse(sessionStorage.getItem("userInfo"));
console.log(user);

document.querySelector(".name-user").innerHTML = "Tên: " + user.name;
document.querySelector(".age-user").innerHTML = "Tuổi: " + user.age;
document.querySelector(".gender-user").innerHTML = "Giới tính: " + user.gender;
document.querySelector(".email-user").innerHTML = user.email;

