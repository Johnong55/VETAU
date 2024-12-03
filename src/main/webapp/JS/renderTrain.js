export function parseDateTime24Hour(input) {
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

export function calculateTimeDifference(startTime, endTime) {
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
    return parseInt((diffInMilliseconds / (1000 * 60 * 60)).toString()) + " giờ";
}


export function getTrainEL(Train_Trip, index) {
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

    return `
    <div class="wrap-lable">
        <div class="booking-label">
            <div class="label-title">
                <p style="margin-bottom: 6px;">${nameTrain}</p>
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
                
                <button class="search-btn choose-chair" data-index="${index}">Chọn ghế</button>
               
            </div>
        </div>
    </div>
 `;
}
