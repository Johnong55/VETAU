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
        startCity: input_startCity.value,
        endCity: input_endCity.value,
        date: input_date.value
    };

    fetch('findtrain',{
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)

    })
        .then(response => {
            if(!response.ok) {
                console.log("LỖIIII");
            }
            return response.text();
        })
        .then(data =>{
            console.log(data);
            if(data === "ok") {
                localStorage.setItem("startCity",input_startCity.value);
                localStorage.setItem("endCity",input_endCity.value);
                localStorage.setItem("date",input_date.value);
                window.location.href = "/metroway/processbooking";
            }
        })
        .catch(error => {
            console.log(error);
        })
});