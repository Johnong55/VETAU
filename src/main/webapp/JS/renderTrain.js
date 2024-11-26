function parseDateTime24Hour(input) {
    const date = new Date(input);

    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    const formattedDate = `${year}-${month}-${day}`;

    const hour = String(date.getHours()).padStart(2, '0');
    const minute = String(date.getMinutes()).padStart(2, '0');
    const formattedTime = `${hour}:${minute}`;

    return { date: formattedDate, time: formattedTime };
}

function calculateTimeDifference(startTime, endTime) {
    // Chuyển chuỗi thời gian thành đối tượng Date
    const start = new Date(startTime);
    const end = new Date(endTime);

    // Kiểm tra tính hợp lệ của hai thời gian
    if (isNaN(start.getTime()) || isNaN(end.getTime())) {
        throw new Error("Chuỗi thời gian không hợp lệ. Định dạng đúng: ISO 8601 (ví dụ: 2024-11-06T18:00:00).");
    }

    // Tính chênh lệch thời gian (mili giây)
    const diffInMilliseconds = end - start;

    // Chuyển đổi sang giờ
    return diffInMilliseconds / (1000 * 60 * 60) + " giờ";
}


export function getTrainEL(Train_Trip) {
    const nameTrain = Train_Trip["trainName"];
    const startCity = Train_Trip["departureCity"];
    const endCity = Train_Trip["arrivalCity"];
    const timeStart = Train_Trip["departureTimeAtDepartureCity"];
    const timeEnd = Train_Trip["arrivalTimeAtArrivalCity"];

    const carriages = Train_Trip["carriages"];
    console.log(carriages)

    const { date: dateStart, time: timeStartFormatted } = parseDateTime24Hour(timeStart);
    const { date: dateEnd, time: timeEndFormatted } = parseDateTime24Hour(timeEnd);

    const difference = calculateTimeDifference(timeStart, timeEnd);

    const data = {
        trainName: nameTrain,
        scheduleId: Train_Trip["scheduleId"],
        startCity: startCity,
        endCity: endCity,
        timeStart: timeStartFormatted,
        timeEnd: timeEndFormatted,
        dateStart: dateStart,
        dateEnd: dateEnd,
        duration: difference
    }
    sessionStorage.setItem("infoOrder", JSON.stringify(data));

    return `
    <div class="wrap-lable">
        <div class="booking-label">
            <div class="label-title">
                <p style="margin-bottom: 6px;">${nameTrain}</p>
            </div>

            <div class="lable-info-bonus">
                <div class="lable-info-bonus-left">
                    <p>Các ga đi qua:</p>
                    <div class="info-bonus-left-result">Huế, Vinh, Thanh Hóa, Ninh Bình</div>
                </div>

                <div class="lable-info-bonus-right">
                    <p>Xem chi tiết thời gian</p>
                </div>
            </div>

            <div class="lable-time_line">
                <div class="wrap-time time-start">
                    <p class="day">${dateStart}</p>
                    <p class="hour">${timeStartFormatted}</p>
                    <p class="location">${startCity}</p>
                </div>

                <div class="time-illustration">
                    <p class="hour-illus">${difference}</p>
                </div>

                <div class="wrap-time time-end">
                    <p class="day">${dateEnd}</p>
                    <p class="hour">${timeEndFormatted}</p>
                    <p class="location">${endCity}</p>
                </div>
            </div>

            <div class="wrap-options">
                <div class="option option-3A" data-id=${carriages[0]["carriageId"]} id="${carriages[0]["carriageId"]}-3A">
                    <div class="content">
                        <div class="option-left">
                            <p>Toa</p>
                            <p>Giá</p>
                        </div>
                        <div class="option-right">
                            <p>3A</p>
                            <p>200.000 VND</p>
                        </div>
                    </div>
                </div>

                <div class="option option-2A" data-id=${carriages[1]["carriageId"]} id="${carriages[1]["carriageId"]}-2A">
                    <div class="content">
                        <div class="option-left">
                            <p>Toa</p>
                            <p>Giá</p>
                        </div>
                        <div class="option-right">
                            <p>2A</p>
                            <p>400.000 VND</p>
                        </div>
                    </div>
                </div>

                <div class="option option-1A" data-id=${carriages[2]["carriageId"]} id="${carriages[2]["carriageId"]}-1A">
                    <div class="content">
                        <div class="option-left">
                            <p>Toa</p>
                            <p>Giá</p>
                        </div>
                        <div class="option-right">
                            <p>1A</p>
                            <p>600.000 VND</p>
                        </div>
                    </div>
                </div>

                <div class="option">
                    <div class="sold-out">
                        <p>Hết vé</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
 `;
}
