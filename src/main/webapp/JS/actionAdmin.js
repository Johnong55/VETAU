import {getAddTrain, getAddCarriage, getAddStation, getAddCity} from "./renderAdmin.js";

const wrap_table = document.querySelector(".wrap-table");

console.log(wrap_table)

wrap_table.addEventListener('click', function (e) {
    console.log(e.target)
    if(e.target.classList.contains("btn-addTrain")) {
        const trainName = e.target.parentNode.querySelector(".form-control").value;
        const data = {trainName}
        if(e.target.dataset.status === "Thêm") {
            console.log(JSON.stringify(data))
            fetch("/metroway/trains",{
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            })
                .then(response => {
                    if(!response.ok) console.log("LOIII");
                    return response.json();
                })
                .then(data => {
                    console.log(data);
                    alert("Thêm thành công")
                })
                .catch(error => console.log(error))
        } else if(e.target.dataset.status === "Cập nhật") {
            const idTrain = e.target.dataset.id;
            console.log(data)
            console.log(idTrain)
            fetch(`/metroway/trains/${idTrain}`, {
                method: "PUT",
                headers: {'Content-Type':'application/json'},
                body: JSON.stringify(data)
            })
                .then(response => {
                    if(!response.ok) console.log("LOI")
                    return response.json()
                })
                .then(data => {
                    console.log(data)
                    alert("Cập nhật thành công")
                })
                .catch(error => console.log(error))
        }
    } else if(e.target.classList.contains("btn-addCarriage")) {
        const formEL = e.target.parentNode;
        const nameCarriageEL = formEL.querySelector(".nameCarriage");
        const numOfCarriageEL = formEL.querySelector(".numOfCarriage");
        const typeOfSeatEL = formEL.querySelector(".typeOfSeat");
        const trainEL = formEL.querySelector(".idTrain");
        const data = {
            carriageName: nameCarriageEL.value,
            seatCount: numOfCarriageEL.value,
            carriageClass: typeOfSeatEL.value,
            trainID: trainEL.value
        }
        console.log(data)
        if(e.target.dataset.status === "Thêm") {

            fetch('/metroway/carriages', {
                method: "POST",
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            })
                .then(response => {
                    if(!response.ok) console.log("LOIII")
                    return response.json();
                })
                .then(data => {
                    console.log(data)
                    alert("Thêm thành công")
                })
                .catch(error => console.log(error))
        } else if(e.target.dataset.status === "Cập nhật") {
            const id = e.target.dataset.id;

            fetch(`/metroway/carriages/${id}`, {
                method: "PUT",
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            })
                .then(response => {
                    if(!response.ok) console.log("LOIII")
                    return response.json();
                })
                .then(data => {
                    console.log(data)
                    alert("Cập nhật thành công")
                })
                .catch(error => console.log(error))
        }

    } else if(e.target.classList.contains("btn-addStation")) {
        const formEL = e.target.parentNode;
        const nameStationEL = formEL.querySelector(".nameStation");
        const addressStationEL = formEL.querySelector(".addressStation");
        const idCityEL = formEL.querySelector(".idCity");
        const data = {
            stationName: nameStationEL.value,
            address: addressStationEL.value,
            cityID: idCityEL.value
        }
        console.log(data);
        if(e.target.dataset.status === "Thêm") {
            fetch('/metroway/stations',{
                method: "POST",
                headers: {'Content-Type':'application/json'},
                body: JSON.stringify(data)
            })
                .then(response => {
                    if(!response.ok) console.log("LOI")
                    return response.json()
                })
                .then(data => {
                    console.log(data)
                    alert("Thêm thành công")
                })
                .catch(error => console.log(error))
        } else if(e.target.dataset.status === "Cập nhật") {
            const id = e.target.dataset.id;
            fetch(`/metroway/stations/${id}`, {
                method: "PUT",
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(data)
            })
                .then(response => {
                    if(!response.ok) console.log("LOI")
                    return response.json()
                })
                .then(data => {
                    console.log(data)
                    alert("Cập nhật thành công")
                })
                .catch(error => console.log(error))
        }
    } else if(e.target.classList.contains("btn-addCity")) {
        const formEL = e.target.parentNode;
        const nameCityEL = formEL.querySelector(".nameCity");
        const data = {
            cityName: nameCityEL.value
        }
        console.log(data)
        if (e.target.dataset.status === "Thêm") {
            fetch('/metroway/cities', {
                method: "POST",
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(data)
            })
                .then(response => {
                    if (!response.ok) console.log("LOIII")
                    return response.json()
                })
                .then(data => {
                    console.log(data)
                    alert("Thêm thành công")
                })
                .catch(error => console.log(error))
        } else if (e.target.dataset.status === "Cập nhật") {
            const id = e.target.dataset.id;
            fetch(`/metroway/cities/${id}`, {
                method: "PUT",
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(data)
            })
                .then(response => {
                    if (!response.ok) console.log("LOI")
                    return response.json()
                })
                .then(data => {
                    console.log(data)
                    alert("Cập nhật thành công")
                })
                .catch(error => console.log(error))
        }
    }else if(e.target.classList.contains("btn-addChair")) {
        const formEL = e.target.parentNode;
        const idCarriage = formEL.querySelector("#idCarriage").value;
        const data = {
            carriageID: idCarriage
        };
        if(e.target.dataset.status === "Thêm") {
            fetch('/metroway/seats', {
                method: "POST",
                headers: {'Content-Type':'application/json'},
                body: JSON.stringify(data)
            })
                .then(response => {
                    if(!response.ok) console.log("LOI")
                    return response.json()
                })
                .then(data => {
                    console.log(data)
                    alert("Thêm thành công")
                })
                .catch(error => console.log(error))
        } else if(e.target.dataset.status === "Cập nhật") {

        }


    } else if(e.target.classList.contains("btn-addTrip")){
        const formEL = e.target.parentNode;
        const idTrain = formEL.querySelector("#trainSelect").value;
        const idStationDeparture = formEL.querySelector("#departureSelect").value;
        const idStationDestination = formEL.querySelector("#destinationSelect").value;
        const timeDeparture = formEL.querySelector("#timeDeparture").value.replace(" ", "T");
        const timeDestination = formEL.querySelector("#timeDestination").value.replace(" ", "T");
        const data = {
            timeToRun: timeDeparture,
            arrivalTime: timeDestination,
            departureStationId: idStationDeparture,
            arrivalStationId: idStationDestination,
            trainId: idTrain
        };
        console.log(data);
        fetch('/metroway/schedules', {
            method: "POST",
            headers: {'Content-Type' : 'application/json'},
            body: JSON.stringify(data)
        })
           .then(response => {
               if(!response.ok){
                   console.log("LOI")
               }
               return response.json();
           })
           .then(data => {
               console.log(data);
               alert("Thêm thành công")
           })
           .catch(error => {
               console.log(error);
           })
    } else if(e.target.classList.contains("btn-update")) {
        console.log(e.target.dataset.id)
        const id = e.target.dataset.id
        console.log(e.target.dataset.type)
        if(e.target.dataset.type === "train") {
            fetch(`/metroway/trains/id/${id}`)
                .then(response => {
                    if(!response.ok) console.log("LOI")
                    return response.json()
                })
                .then(data => {
                    console.log(data)
                    wrap_table.innerHTML = getAddTrain("Cập nhật",id, data.trainName)
                })
                .catch(error => console.log(error))
        } else if(e.target.dataset.type === "toa") {
            let trains = [];
            fetch('/metroway/trains')
                .then(response => response.json())
                .then(data => {
                    console.log(data)
                    trains = [...data];

                    fetch(`/metroway/carriages/id/${id}`)
                        .then(response => {
                            if(!response.ok) console.log("LOI")
                            return response.json()
                        })
                        .then(data => {
                            console.log(data)
                            wrap_table.innerHTML = getAddCarriage(trains,"Cập nhật",id, data)
                        })
                        .catch(error => console.log(error))

                })
                .catch(error => console.log(error))
        } else if(e.target.dataset.type === "station") {
            fetch(`/metroway/stations/id/${id}`)
                .then(response => {
                    if(!response.ok) console.log("LOI")
                    return response.json()
                })
                .then(data1 => {
                    console.log(data1)
                    fetch('/metroway/cities')
                        .then(response => response.json())
                        .then(data2 => {
                            console.log(data2)
                            wrap_table.innerHTML = getAddStation(data2,"Cập nhật",data1)
                        })
                })
                .catch(error => console.log(error))
        } else if(e.target.dataset.type === "city") {
            fetch(`/metroway/cities/id/${id}`)
                .then(response => {
                    if(!response.ok) console.log("LOI")
                    return response.json()
                })
                .then(data => {
                    console.log(data)
                    wrap_table.innerHTML = getAddCity("Cập nhật",data)
                })
                .catch(error => console.log(error))
        }
    }
})