const infoTrainTrip =  JSON.parse(sessionStorage.getItem("infoOrder"));

const data = {
    purchaseMethod: "VnPay",
    status: "success",
    scheduleId: infoTrainTrip.scheduleId,
    departureCityName: infoTrainTrip.startCity,
    arrivalCityName: infoTrainTrip.endCity,
    departureTimeAtDepartureCity: infoTrainTrip.timeStart,
    arrivalTimeAtArrivalCity: infoTrainTrip.timeEnd,
    accountId: "",
    seatId: ""
}
const chairHolds = JSON.parse(sessionStorage.getItem("chairhold"));

Object.keys(chairHolds).forEach(key => {
    data.seatId = key;
    // fetch()
})
