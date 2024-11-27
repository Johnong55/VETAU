const infoTrainTrip = JSON.parse(sessionStorage.getItem("infoOrder"));

const data = {
    purchaseMethod: "VnPay",
    scheduleId: infoTrainTrip.scheduleId,
    departureStationName: infoTrainTrip.startCity,
    arrivalStationName: infoTrainTrip.endCity,
    accountId: "AC002",
    seatId: "",
    departureTime: infoTrainTrip.departureTime,
    arrivalTime: infoTrainTrip.arrivalTime
};

const chairHolds = JSON.parse(sessionStorage.getItem("chairhold"));
const fetchPromises = [];

Object.keys(chairHolds).forEach(key => {
    const requestData = { ...data, seatId: key };
    const fetchPromise = fetch('/metroway/tickets', {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(requestData)
    })
        .then(response => {
            if (!response.ok) throw new Error("Request failed");
            return response.json();
        })
        .catch(error => {
            console.error(error);
            return { code: -1 };
        });

    fetchPromises.push(fetchPromise);
});

Promise.all(fetchPromises).then(results => {
    const resultCodes = results.map(res => res.code);
    console.log(results);
    console.log(resultCodes);

    if (resultCodes.every(code => code === 0) && resultCodes.length !== 0) {
        console.log(1);
        window.location.href = "/metroway/bookingsuccess";
    } else {
        console.log(2);
        // chuyen trang that bai
    }
});
