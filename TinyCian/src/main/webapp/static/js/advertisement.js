function searchAdvertisement(rentOrBy, realtyType, squareFrom, squareTo, costFrom, costTo) {
    let url;
    if (realtyType === 'house') {
        url = '/advertisement/dataHouse?rentOrBy=' + rentOrBy + '&squareFrom=' + squareFrom + '&squareTo=' + squareTo + '&costFrom=' + costFrom + '&costTo=' + costTo;
    } else {
        url = '/advertisement/dataFlat?rentOrBy=' + rentOrBy + '&realtyType=' + realtyType + '&squareFrom=' + squareFrom + '&squareTo=' + squareTo + '&costFrom=' + costFrom + '&costTo=' + costTo
    }
    return fetch(url)
        .then((response) => {
            return response.json()
        }).then((realtyes) => {
            fillList(realtyes)
        })
}


function fillList(agencys) {
    let table = document.getElementById("advertisements");
    table.innerHTML = "";


    table.innerHTML = '    <tr>\n' +
        '        <th>id</th>\n' +
        '        <th>district</th>\n' +
        '        <th>address</th>\n' +
        // '        <th>advertType</th>\n' +
        // '        <th>cost</th>\n' +
        '    </tr>';

    for (let i = 0; i < agencys.length; i++) {

        let row = table.insertRow(-1)
        let idCell = row.insertCell(0)
        let districtCell = row.insertCell(1)
        let addressCell = row.insertCell(2)
        // let advertTypeCell = row.insertCell(3)
        // let costCell = row.insertCell(4)

        let a = document.createElement('a');
        a.href = "http://localhost:8080/realty?id=" + agencys[i].id + "&realtyType=" + agencys[i].flatOrHouse;
        a.text = agencys[i].id

        // console.log(advertTypeCell[i].advertType)
        // console.log(advertTypeCell[i].cost)
        idCell.appendChild(a)
        districtCell.innerHTML = agencys[i].district
        addressCell.innerHTML = agencys[i].address
        // advertTypeCell.innerHTML = advertTypeCell[i].advertType
        // costCell.innerHTML = advertTypeCell[i].cost

    }
}