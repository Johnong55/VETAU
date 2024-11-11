export function getTable(headers,list) {

    let tableEL = `
        <table class="table table-bordered table-hover">
            <thead>
                <tr class="h3">
    `;

    headers.forEach(header => {
        tableEL += `
            <th class="header-table">${header}</th>
        `;
    });

    tableEL += `
                </tr>
            </thead>
            <tbody class="h4">
    `;

    list.forEach(tmp => {
        tableEL += `<tr>`;
        for (const key in tmp) {
            if (tmp.hasOwnProperty(key)) {
                tableEL += `
                    <td>${tmp[key]}</td>
                `;
            }
        }
        tableEL += `</tr>`;
    });

    tableEL += `
            </tbody>
        </table>
    `;

    return tableEL;

    // return `
    //
    // <table class="table table-bordered table-hover">
    //                 <thead>
    //                 <tr class="h3">
    //                     <th class="header-table">Mã tàu</th>
    //                     <th class="header-table">Tên tàu</th>
    //                     <th class="header-table">Toa</th>
    //                 </tr>
    //                 </thead>
    //                 <tbody class="h4">
    //                 <tr>
    //                     <td>T01</td>
    //                     <td>Tàu lòn</td>
    //                     <td>1A, 2A, 3A</td>
    //                 </tr>
    //                 <tr>
    //                     <td>T02</td>
    //                     <td>Tòn làu</td>
    //                     <td>1B, 2B, 3B</td>
    //                 </tr>
    //                 <tr>
    //                     <td>T03</td>
    //                     <td>Dooley</td>
    //                     <td>1C, 2C, 3C</td>
    //                 </tr>
    //                 </tbody>
    //             </table>
    //
    // `;
}