const btn_findtrain = document.querySelector("#btn-findtrain");
const input_startCity = document.querySelector("#start-city");
const input_endCity = document.querySelector("#end-city");
const input_date = document.querySelector("#date-input");


console.log(btn_findtrain);

btn_findtrain.addEventListener('click', function (){
    console.log(123);
    console.log(input_date.value);
    console.log(typeof input_date.value);
    const data = {
        departureCity: input_startCity.value,
        arrivalCity: input_endCity.value,
        departureDate: input_date.value
    };
    sessionStorage.setItem("findTrain",JSON.stringify(data))
    window.location.href = "/metroway/processbooking";
});