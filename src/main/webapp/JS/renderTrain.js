export function getTrainEL(Train_Trip, idTrain) {

    // const nameTrain = Train_Trip["name"];
    // const startCity = Train_Trip["startCity"];
    // const endCity = Train_Trip["endCity"];
    // const timeStart = Train_Trip["timeStart"];
    // const timeEnd = Train_Trip["timeEnd"];



    return `
    
    <div class="wrap-lable">
        <div class="booking-label">
            <div class="label-title">
                <p style="margin-bottom: 6px;">123ABC</p>
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
                    <p class="day">Ngày 14/9</p>

                    <p class="hour">11:25 pm</p>

                    <p class="location"> Da Nang </p>
                </div>

                <div class="time-illustration">
                    <p class="hour-illus">25 giờ</p>
                </div>

                <div class="wrap-time time-end">
                    <p class="day">Ngày 15/9</p>

                    <p class="hour">12:25 pm</p>

                    <p class="location"> Ha Noi </p>
                </div>
            </div>

            <div class="wrap-options">
                <div class="option option-3A" id="${idTrain}-3A">
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

                <div class="option option-2A" id="${idTrain}-2A" >
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

                <div class="option option-1A" id="${idTrain}-1A">
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