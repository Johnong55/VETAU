export function getTable(headers, list, type) {
    const headerRow = headers.map(header => `<th class="header-table">${header}</th>`).join('') + `<th class="header-table"></th>`;

    const bodyRows = list.map(row => `
        <tr>
            ${Object.values(row).map(value => {
                if(value === false) {
                    return `<td>Bình thường</td>`
                } else if(value === true) {
                    return `<td>Hỏng</td>`
                } else if(value !== null) {
                    return `<td>${value}</td>`
                }
    }).join('')}
            <td>
                <button class="btn btn-primary btn-update" data-type="${type}" data-id="${Object.values(row)[0]}">Cập nhật</button>
            </td>
        </tr>
    `).join('');

    return `
        <table class="table table-bordered table-hover">
            <thead>
                <tr class="h3">${headerRow}</tr>
            </thead>
            <tbody class="h4">${bodyRows}</tbody>
        </table>
    `;
}

export function getDelete(headers, list) {
    const headerRow = headers.map(header => `<th class="header-table">${header}</th>`).join('') +
        `<th class="header-table">Chọn để xóa</th>`;

    const bodyRows = list.map(row => `
        <tr>
            ${Object.values(row).map(value => `<td>${value}</td>`).join('')}
            <td><input type="checkbox"></td>
        </tr>
    `).join('');

    return `
        <table class="table table-bordered table-hover">
            <thead>
                <tr class="h3">${headerRow}</tr>
            </thead>
            <tbody class="h4">${bodyRows}</tbody>
        </table>
        <button class="btn btn-primary btn-lg" style="margin-left: 95%">Xóa</button>
    `;
}


export function getAddTrain(option,id,name) {
    if(id) {
        return `
    <div>
  <div class="mb-3 mt-3">
    <label for="nameTrain" class="form-label display-6">Tên tàu :</label>
    <input type="text" class="form-control form-control-lg" id="nameTrain" value="${name}" placeholder="Nhập tên tàu" name="nameTrain">
  </div>
  
  <button class="btn btn-primary btn-lg btn-addTrain" data-id="${id}" data-status="${option}">${option}</button>
</div>
    `;
    } else {
        return `
    <div>
  <div class="mb-3 mt-3">
    <label for="nameTrain" class="form-label display-6">Tên tàu :</label>
    <input type="text" class="form-control form-control-lg" id="nameTrain" placeholder="Nhập tên tàu" name="nameTrain">
  </div>
  
  <button class="btn btn-primary btn-lg btn-addTrain" data-status="${option}">${option}</button>
</div>
    `;
    }
}
export function getAddTrip(trains, stations, option) {
    const trainOptions = trains.length > 0
       ? trains.map(train => `<option value="${train["trainId"]}">${train["trainName"]}</option>`).join('')
       : '<option disabled>Không có tàu khả dụng</option>';

    const stationOptions = stations.length > 0
       ? stations.map(station => `<option value="${station["stationId"]}">${station["stationName"]}</option>`).join('')
       : '<option disabled>Không có ga khả dụng</option>';

    return `
    <div>
      <div class="mb-3 mt-3">
        <label for="trainSelect" class="form-label display-6 mb-3">Chọn tàu :</label>
        <select class="form-select form-select-lg mb-3" id="trainSelect">
                ${trainOptions}
        </select>
        
        <label for="departureSelect" class="form-label display-6 mb-3">Chọn điểm xuất phát :</label>
        <select class="form-select form-select-lg mb-3" id="departureSelect">
                ${stationOptions}
        </select>
        
        <label for="destinationSelect" class="form-label display-6 mb-3">Chọn điểm đến :</label>
        <select class="form-select form-select-lg mb-3" id="destinationSelect">
                ${stationOptions}
        </select>
        
        <label for="datetime" class="form-label display-6 mb-3">Chọn ngày giờ xuất phát :</label>
         <input id="timeDeparture" type="text" class="form-control form-control-lg" placeholder="Chọn ngày giờ" />
         
         <label for="datetime" class="form-label display-6 mb-3">Chọn ngày giờ đến :</label>
         <input id="timeDestination" type="text" class="form-control form-control-lg" placeholder="Chọn ngày giờ" />
      </div>
  
        <button class="btn btn-primary btn-lg btn-addTrip" data-status="${option}">${option}</button>
    </div>
    `;
}


export function getAddCarriage(trainNames,option,id,toa) {
    if(id) {

        const generateOptions = (trainNames, selectedTrainID) => {
            return trainNames
                .map(
                    train => `<option value="${train.trainId}" ${train.trainId === selectedTrainID ? "selected" : ""}>${train.trainName}</option>`
                )
                .join('');
        };


        return `
<div>
  <div class="input-group input-group-lg mb-3">
    <span class="input-group-text">Tên toa</span>
    <input type="text" class="form-control nameCarriage" value="${toa.carriageName}">
  </div>
  
  <div class="input-group input-group-lg mb-3">
    <span class="input-group-text">Số lượng ghế</span>
    <input type="number" class="form-control numOfCarriage" value="${toa.seatCount}">
  </div>
  
  <select class="form-select form-select-lg mb-3 typeOfSeat" value="${toa.seatType}">
    <option value="FIRST_CLASS">Phòng nằm</option>
    <option value="SECOND_CLASS">Giường nằm</option>
    <option value="DOUBLE_NORMAL_CLASS">Ghế đôi</option>
    <option value="SINGLE_NORMAL_CLASS">Ghế đơn</option>
  </select>
  
  <select class="form-select form-select-lg idTrain" value="${toa.trainID}">
    ${generateOptions(trainNames, toa.trainID)}
  </select>
  
  <button class="btn btn-primary btn-lg mt-3 btn-addCarriage" data-status="${option}" data-id="${id}">${option}</button>
</div>`;
    } else {
        return `
<div>
  <div class="input-group input-group-lg mb-3">
    <span class="input-group-text">Tên toa</span>
    <input type="text" class="form-control nameCarriage">
  </div>
  
  <div class="input-group input-group-lg mb-3">
    <span class="input-group-text">Số lượng ghế</span>
    <input type="number" class="form-control numOfCarriage">
  </div>
  
  <select class="form-select form-select-lg mb-3 typeOfSeat">
    <option value="FIRST_CLASS">Phòng nằm</option>
    <option value="SECOND_CLASS">Giường nằm</option>
    <option value="DOUBLE_NORMAL_CLASS">Ghế đôi</option>
    <option value="SINGLE_NORMAL_CLASS">Ghế đơn</option>
  </select>
  
  <select class="form-select form-select-lg idTrain">
    ${trainNames
            .map(train => `<option value="${train.trainId}">${train.trainName}</option>`)
            .join('')}
  </select>
  
  <button class="btn btn-primary btn-lg mt-3 btn-addCarriage" data-status="${option}">${option}</button>
</div>`;
    }

}
export function getAddStation(cities, option,station) {
    if(station) {

        const cityOptions = cities.map(city =>
            `<option value="${city.cityID}" ${city.cityName === station.cityName ? "selected" : ""} >${city.cityName}</option>`).join('');

        return `
        <div>
            <div class="input-group input-group-lg mb-3">
                <span class="input-group-text">Tên ga</span>
                <input type="text" class="form-control nameStation" value="${station.stationName}">
            </div>
            <div class="input-group input-group-lg mb-3">
                <span class="input-group-text">Địa chỉ</span>
                <input type="text" class="form-control addressStation" value="${station.address}">
            </div>
            <select class="form-select form-select-lg idCity">
                ${cityOptions}
            </select>
            <button class="btn btn-primary btn-lg mt-3 btn-addStation" data-status="${option}" data-id="${station.stationId}">${option}</button>
        </div>
    `;
    } else {
        const cityOptions = cities.map(city =>
            `<option value="${city.cityID}">${city.cityName}</option>`).join('');

        return `
        <div>
            <div class="input-group input-group-lg mb-3">
                <span class="input-group-text">Tên ga</span>
                <input type="text" class="form-control nameStation">
            </div>
            <div class="input-group input-group-lg mb-3">
                <span class="input-group-text">Địa chỉ</span>
                <input type="text" class="form-control addressStation">
            </div>
            <select class="form-select form-select-lg idCity">
                ${cityOptions}
            </select>
            <button class="btn btn-primary btn-lg mt-3 btn-addStation" data-status="${option}">${option}</button>
        </div>
    `;
    }
}


export function getAddCity(option, city) {
    if(city) {
        return `
        <div>
  <div class="input-group input-group-lg mb-3">
    <span class="input-group-text">Tên thành phố</span>
    <input type="text" class="form-control nameCity" value="${city.cityName}">
  </div>
<button class="btn btn-primary btn-lg mt-3 btn-addCity" data-status="${option}" data-id="${city.cityID}">${option}</button>

</div>
    `;
    } else {
        return `
        <div>
  <div class="input-group input-group-lg mb-3">
    <span class="input-group-text">Tên thành phố</span>
    <input type="text" class="form-control nameCity">
  </div>
<button class="btn btn-primary btn-lg mt-3 btn-addCity" data-status="${option}">${option}</button>

</div>
    `;
    }
}

export function getAddChair(carriages) {
    const carriageOptions = carriages.map(carriage =>
        `<option value="${carriage["carriageId"]}">${carriage["carriageName"]}</option>`).join('');
    return `
        <div>
        
            <select class="form-select form-select-lg" id="idCarriage">
                ${carriageOptions}
            </select>
            <button class="btn btn-primary btn-lg mt-3 btn-addChair" data-status="Thêm">Thêm</button>
        </div>
    `;
}