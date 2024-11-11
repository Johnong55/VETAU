import {getTable} from "./renderAdmin.js";

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

const headers = ["Ma tau", "Ten tau", "Toa"];
const trainData = [
    { maTau: 'T01', tenTau: 'Tàu lòn', toa: '1A, 2A, 3A' },
    { maTau: 'T02', tenTau: 'Tòn làu', toa: '1B, 2B, 3B' },
    { maTau: 'T03', tenTau: 'Dooley', toa: '1C, 2C, 3C' }
];

const funcMap = {
    allTrains: () => { wrapTableEL.innerHTML = getTable(headers, trainData);},
    addTrain: () => {},
    deleteTrain: () => {},

    allToas: () => {},
    addToa: () => {},
    deleteToa: () => {},

    allTrips: () => {},
    addTrip: () => {},
    deleteTrip: () => {},

    allStations: () => {},
    addStation: () => {},
    deleteStation: () => {},

    allCities: () => {},
    addCity: () => {},
    deleteCity: () => {},

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

const wrapTableEL = document.querySelector(".wrap-table");
console.log(wrapTableEL);

menuAdmin.addEventListener('click', function (e){
    console.log(e.target)
    if(e.target.dataset.key) {
        (funcMap[e.target.dataset.key])();
    }
})