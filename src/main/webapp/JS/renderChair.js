function renderChairs(m,id,toa,chairs) {
    let divs = "";
    const div = document.createElement('div');

    div.classList.add('option-chair-item');


    for(let i = 1; i <=4; i++) {
        div.innerHTML = `
            <div class="item-backrest"></div>
            <div class="item-square" data-id=${chairs[i+m-1]["seatId"]} id="${i+m}-${toa}-${id}" data-value="available" data-status="available">
                ${i+m}
            </div>
        `;
        divs += div.outerHTML;
    }
    return divs;
}

function render_chair_column(m,id,toa,chairs) {
    let divs = "";
    const div = document.createElement('div');

    div.classList.add('option-chair-column');


    for(let i = 0; i <=4; i++) {
        div.innerHTML = `
            ${renderChairs(m+i*4,id,toa,chairs)}
        `;
        divs += div.outerHTML;
    }
    return divs;
}

//
// export function getChairs(id, toa,chairs) {
//
//     return `
//
//     <div class="form-option-${toa}" id="form-option-${id}-${toa}">
//     <div class="modal">
//         <div class="modal__overlay"></div>
//         <div class="modal__body body-option-${toa}" id="${id}-${toa}-chair">
//             <div class="auth-form-option auth-form-option-${toa} ">
//                 <div class="auth-form-option-container">
//                     <div class="option-header">
//                         <h1>Toa: ${toa}</h1>
//                     </div>
//
//                     <div class="option-body option-body-${toa}">
//                         <div class="option-body-left">
//                             ${render_chair_column(0,id,toa,chairs)}
//                         </div>
//
//                         <div class="option-body-mid">
//                             <div class="mid-item"></div>
//
//                             <div class="mid-item"></div>
//                         </div>
//
//                         <div class="option-body-right">
//                             ${render_chair_column(20,id,toa,chairs)}
//                         </div>
//                     </div>
//
//                     <div class="option-desc">
//                         <div class="option-desc-item">
//                             <div class="option-chair-item">
//                                 <div class="item-backrest"></div>
//
//                                 <div class="item-square color-chair-soldout"
//                                     style="cursor: default;"></div>
//                             </div>
//                             <span>Đã có người chọn</span>
//                         </div>
//
//                         <div class="option-desc-item">
//                             <div class="option-chair-item">
//                                 <div class="item-backrest"></div>
//
//                                 <div class="item-square color-chair-hold"
//                                     style="cursor: default;"></div>
//                             </div>
//                             <span>Bạn đang chọn</span>
//                         </div>
//                     </div>
//
//                     <div class="option-status">
//                         <p class="text-status">Đã chọn: 0</p>
//                     </div>
//
//                     <div class="box-btn">
//                         <button class="login-btn confirmbook">Tiếp tục</button>
//                         <button class="login-btn login-btn--back" id="option-back-${toa}">Trở lại</button>
//                     </div>
//                 </div>
//             </div>
//         </div>
//     </div>
// </div>
//
//     `;
function getChair(totalSeat,seats,scheduleKey) {
    console.log(seats)
    let chairsHTML = '';
    for (let i = 1; i <= totalSeat; i++) {
        chairsHTML += `<div class="seat" data-scheduleKey="${scheduleKey}" data-idseat="${seats[i-1].seatId}" data-nameChair="${i}" data-value="available" data-status="available">${i}</div>`;
    }
    return chairsHTML;
}
async function getCarriage(carriage, scheduleKey, stt) {
    let seats = [];
    try {
        const response = await fetch(`/metroway/seats/carriageID/${carriage.carriageId}`);
        if (!response.ok) {
            console.log("LỖI");
            return '';
        }
        const data = await response.json();
        seats = [...data];
        console.log(seats);
    } catch (error) {
        console.log(error);
    }

    return `
    <div class="carriage">
        <header class="name-carriage">Toa ${stt}: ${carriage.seatType}</header>
        <div class="chairs">
            <div class="container-chair">
                ${getChair(carriage.seatCount, seats, scheduleKey)}
            </div>
        </div>
    </div>`;
}


    export async function getChairs(listCarriage, scheduleKey) {
        let result = `<div class="form-option">
            <div class="modal">
                <div class="modal__overlay"></div>
                <div class="modal__body">
                    <div class="auth-form-option">
                        <div class="auth-form-option-container">`;

        for (let i = 0; i < listCarriage.length; i++) {
            const carriageHTML = await getCarriage(listCarriage[i], scheduleKey, i+1);
            result += carriageHTML;
        }
        result += `
        <div class="option-desc">
                                <div class="option-desc-item">
                                    <div class="option-chair-item">
                                        <div class="item-backrest"></div>
        
                                        <div class="item-square color-chair-soldout"
                                            style="cursor: default;"></div>
                                    </div>
                                    <span>Đã có người chọn</span>
                                </div>

                                <div class="option-desc-item">
                                    <div class="option-chair-item">
                                        <div class="item-backrest"></div>
        
                                        <div class="item-square color-chair-hold"
                                            style="cursor: default;"></div>
                                    </div>
                                    <span>Bạn đang chọn</span>
                                </div>
                            </div>
                            
                            <div class="option-status">
                                <p class="text-status">Đã chọn: 0</p>
                            </div>

                            <div class="box-btn">
                                <button class="login-btn confirmbook">Tiếp tục</button>
                                <button class="login-btn login-btn--back chooseChair--back">Trở lại</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>`;
        return result;


        // return `
        //
        // <div class="form-option">
        //     <div class="modal">
        //         <div class="modal__overlay"></div>
        //         <div class="modal__body">
        //             <div class="auth-form-option">
        //                 <div class="auth-form-option-container">
        //                     <div class="carriage">
        //                         <header class="name-carriage">Toa 1: Ngồi mềm điều hòa</header>
        //                         <div class="chairs">
        //                             <div class="container-chair">
        //                                 ${getChair(40)}
        //                             </div>
        //                         </div>
        //                     </div>
        //
        //                     <div class="carriage">
        //                         <header class="name-carriage">Toa 1</header>
        //                         <div class="chairs">
        //                             <div class="container-chair">
        //                                 ${getChair(40)}
        //                             </div>
        //                         </div>
        //                     </div>
        //
        //                     <div class="carriage">
        //                         <header class="name-carriage">Toa 1</header>
        //                         <div class="chairs">
        //                             <div class="container-chair">
        //                                 ${getChair(40)}
        //                             </div>
        //                         </div>
        //                     </div>
        //
        //                     <div class="carriage">
        //                         <header class="name-carriage">Toa 1</header>
        //                         <div class="chairs">
        //                             <div class="container-chair">
        //                                 ${getChair(40)}
        //                             </div>
        //                         </div>
        //                     </div>
        //
        //                     <div class="carriage">
        //                         <header class="name-carriage">Toa 1</header>
        //                         <div class="chairs">
        //                             <div class="container-chair">
        //                                 ${getChair(40)}
        //                             </div>
        //                         </div>
        //                     </div>
        //
        //                     <div class="option-desc">
        //                         <div class="option-desc-item">
        //                             <div class="option-chair-item">
        //                                 <div class="item-backrest"></div>
        //
        //                                 <div class="item-square color-chair-soldout"
        //                                     style="cursor: default;"></div>
        //                             </div>
        //                             <span>Đã có người chọn</span>
        //                         </div>
        //
        //                         <div class="option-desc-item">
        //                             <div class="option-chair-item">
        //                                 <div class="item-backrest"></div>
        //
        //                                 <div class="item-square color-chair-hold"
        //                                     style="cursor: default;"></div>
        //                             </div>
        //                             <span>Bạn đang chọn</span>
        //                         </div>
        //                     </div>
        //
        //                     <div class="option-status">
        //                         <p class="text-status">Đã chọn: 0</p>
        //                     </div>
        //
        //                     <div class="box-btn">
        //                         <button class="login-btn confirmbook">Tiếp tục</button>
        //                         <button class="login-btn login-btn--back">Trở lại</button>
        //                     </div>
        //                 </div>
        //             </div>
        //         </div>
        //     </div>
        // </div>
        //
        // `;
    }