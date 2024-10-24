function renderChairs(m,id,toa) {
    let divs = "";
    const div = document.createElement('div');

    div.classList.add('option-chair-item');


    for(let i = 1; i <=4; i++) {
        div.innerHTML = `
            <div class="item-backrest"></div>
            <div class="item-square" id="${i+m}-${toa}-${id}" data-value="available" data-status="available">
                ${i+m}
            </div>
        `;
        divs += div.outerHTML;
    }
    return divs;
}

function render_chair_column(m,id,toa) {
    let divs = "";
    const div = document.createElement('div');

    div.classList.add('option-chair-column');


    for(let i = 0; i <=4; i++) {
        div.innerHTML = `
            ${renderChairs(m+i*4,id,toa)}
        `;
        divs += div.outerHTML;
    }
    return divs;
}


export function getChairs(id, toa) {

    return `
    
    <div class="form-option-${toa}" id="form-option-${id}-${toa}">
    <div class="modal">
        <div class="modal__overlay"></div>
        <div class="modal__body body-option-${toa}" id="${id}-${toa}-chair">
            <div class="auth-form-option auth-form-option-${toa} ">
                <div class="auth-form-option-container">
                    <div class="option-header">
                        <h1>Toa: ${toa}</h1>
                    </div>

                    <div class="option-body option-body-${toa}">
                        <div class="option-body-left">
                            ${render_chair_column(0,id,toa)}
                        </div>

                        <div class="option-body-mid">
                            <div class="mid-item"></div>

                            <div class="mid-item"></div>
                        </div>

                        <div class="option-body-right">
                            ${render_chair_column(20,id,toa)}
                        </div>
                    </div>

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
                        <button class="login-btn login-btn--back" id="option-back-${toa}">Trở lại</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    
    `;
}