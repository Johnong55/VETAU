import {
    getTable,
    getAddTrain,
    getDelete,
    getAddCarriage,
    getAddStation,
    getAddCity,
    getAddChair,
    getAddTrip
} from "./renderAdmin.js";

const Items = {
    train: [
        { key: "allTrains", label: "Tất cả tàu" },
        { key: "addTrain", label: "Thêm tàu" },
        { key: "deleteTrain", label: "Xóa tàu" }
    ],
    toa: [
        { key: "allToas", label: "Tất cả toa" },
        { key: "addToa", label: "Thêm toa" },
        { key: "deleteToa", label: "Xóa toa" }
    ],
    chair: [
        { key: "allChairs", label: "Tất cả ghế" },
        { key: "addChair", label: "Thêm ghế" },
        { key: "deleteChair", label: "Xóa ghế" }
    ],
    trip: [
        { key: "allTrips", label: "Tất cả chuyến tàu" },
        { key: "addTrip", label: "Thêm chuyến tàu" },
        { key: "deleteTrip", label: "Xóa chuyến tàu" }
    ],
    station: [
        { key: "allStations", label: "Tất cả ga" },
        { key: "addStation", label: "Thêm ga" },
        { key: "deleteStation", label: "Xóa ga" }
    ],
    city: [
        { key: "allCities", label: "Tất cả thành phố" },
        { key: "addCity", label: "Thêm thành phố" },
        { key: "deleteCity", label: "Xóa thành phố" }
    ],
    customer: [
        { key: "allCustomers", label: "Tất cả khách hàng" },
        { key: "addCustomer", label: "Thêm khách hàng" },
        { key: "resetPassword", label: "Cấp mật khẩu" },
        { key: "deleteCustomer", label: "Xóa khách hàng" }
    ],
    ticket: [
        { key: "allTickets", label: "Tất cả vé" },
        { key: "successfulTickets", label: "Vé mua thành công" },
        { key: "cancelledTickets", label: "Vé đã hủy" },
        { key: "ticketPrice", label: "Giá vé" }
    ]
};

async function fetchData(url) {
    try {
        const response = await fetch(url);
        if (!response.ok) {
            console.log(response.status);
        }
        return await response.json();
    } catch (error) {
        console.error('Có lỗi:', error);
    }
}

const wrapTableEL = document.querySelector(".wrap-table");

const funcMap = {
    allTrains: () => {
        const headersAllTrains = ["Mã tàu", "Tên tàu"];
        fetch('/metroway/trains')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getTable(headersAllTrains, data,"train");
            } )
            .catch(error => console.error('Error:', error));
        },
    addTrain: () => {
        console.log(123)
        wrapTableEL.innerHTML = getAddTrain("Thêm")
    },
    deleteTrain: () => {
        const headersAllTrains = ["Mã tàu", "Tên tàu"];
        fetch('/metroway/trains')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getDelete(headersAllTrains, data);
            } )
            .catch(error => console.error('Error:', error));

    },

    allToas: () => {
        const headersAllToas = ["Mã toa", "Tên toa","Số lượng ghế","Loại ghế","Mã tàu"];
        fetch('/metroway/carriages')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getTable(headersAllToas, data, "toa");
            } )
            .catch(error => console.error('Error:', error));
    },
    addToa: () => {
        fetch('/metroway/trains')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getAddCarriage(data,"Thêm")
            })
            .catch(error => console.log(error))
    },
    deleteToa: () => {
        const headersAllToas = ["Mã toa", "Tên toa","Số lượng ghế","Loại ghế","Mã tàu"];
        fetch('/metroway/carriages')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getDelete(headersAllToas, data);
            } )
            .catch(error => console.error('Error:', error));
    },

    allChairs: () => {
        const headersAllChairs = ["Mã ghế", "Tên ghế","Trạng thái", "","Toa","Loại ghế"];
        fetch('/metroway/seats')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getTable(headersAllChairs, data, "chair");
            } )
            .catch(error => console.error('Error:', error));
    },
    addChair: () => {
        fetch('/metroway/carriages')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getAddChair(data);
            })
            .catch(error => console.log(error))
    },
    deleteChair: () => {},

    allTrips: () => {
        const headersAllTrips = ["Mã chuyến tàu","Thời gian đến","Trạm xuất phát", "Trạm dừng", "Mã tàu"];
        fetch('/metroway/schedules')
           .then(response => response.json())
           .then(data => {
               console.log(data)
               wrapTableEL.innerHTML = getTable(headersAllTrips, data, "schedule");
           } )
           .catch(error => console.error('Error:', error));
    },
    addTrip: async () => {
        // lấy tàu và ga
        let dataTrain = await fetchData('/metroway/trains');
        let dataStation = await fetchData('/metroway/stations');
        console.log(dataTrain);
        console.log(dataStation);
        wrapTableEL.innerHTML = getAddTrip(dataTrain, dataStation, "Thêm");
        flatpickr("#timeDeparture", {
            enableTime: true,
            dateFormat: "Y-m-d H:i",
            time_24hr: true
        });
        flatpickr("#timeDestination", {
            enableTime: true,
            dateFormat: "Y-m-d H:i",
            time_24hr: true
        });
    },
    deleteTrip: () => {},

    allStations: () => {
        const headersAllStations = ["Mã ga","Tên ga","Địa chỉ","Thành phố"];
        fetch('/metroway/stations')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getTable(headersAllStations,data, "station")
            })
            .catch(error => console.log(error))
    },
    addStation: () => {
        fetch('/metroway/cities')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getAddStation(data,"Thêm")
            })

    },
    deleteStation: () => {
        const headersAllStations = ["Mã ga","Tên ga","Địa chỉ","Thành phố"];
        fetch('/metroway/stations')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getDelete(headersAllStations,data)
            })
            .catch(error => console.log(error))
    },

    allCities: () => {
        const headersAllCities = ["Mã thành phố", "Tên thành phố"];
        fetch('/metroway/cities')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getTable(headersAllCities,data, "city")
            })
            .catch(error => console.log(error))

    },
    addCity: () => {
        wrapTableEL.innerHTML = getAddCity("Thêm");
    },
    deleteCity: () => {
        const headersAllCities = ["Mã thành phố", "Tên thành phố"];
        fetch('/metroway/cities')
            .then(response => response.json())
            .then(data => {
                console.log(data)
                wrapTableEL.innerHTML = getDelete(headersAllCities,data)
            })
            .catch(error => console.log(error))
    },

    allCustomers: () => {},
    addCustomer: () => {},
    resetPassword: () => {},
    deleteCustomer: () => {},

    allTickets: () => {},
    successfulTickets: () => {},
    cancelledTickets: () => {},
    ticketPrice: () => {}
};



const menuAdminEL = document.querySelectorAll(".options-admin-item");
menuAdminEL.forEach(item => {
    item.addEventListener('click', function () {
        const nextDiv = item.nextElementSibling;

        if (nextDiv && nextDiv.classList.contains("list-group")) {
            nextDiv.remove();
        } else {
            const content = Items[item.dataset.value];
            const newDiv = document.createElement('ul');
            newDiv.classList.add("list-group", "list-group-flush", "h4", "ms-5");

            content.forEach(item => {
                newDiv.innerHTML += `

                        <li class="list-group-item list-group-item-action ms-5 pt-3" data-key="${item["key"]}">${item["label"]}</li>

                    `;
            })

            item.insertAdjacentElement("afterend", newDiv);
        }
    })
})

const menuAdmin = document.querySelector("#menu-admin");

console.log(menuAdmin);

menuAdmin.addEventListener('click', function (e){
    console.log(e.target)
    if(e.target.dataset.key) {
        (funcMap[e.target.dataset.key])();
    } else if(e.target.classList.contains("btn-logout")) {
        window.location.href = "/metroway/processbooking"
    }
})