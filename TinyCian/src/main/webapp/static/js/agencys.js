function searchAgencys(status, column, order) {
    return fetch('/agencys/data?status=' + status + '&column=' + column + '&order=' + order)
        .then((response) => {
            return response.json()
        }).then((agencys) => {
            fillList(agencys)
        })
}

function fillList(agencys) {
    let table = document.getElementById("agencys");
    table.innerHTML = "";

    table.innerHTML = '    <tr>\n' +
        '        <th>id</th>\n' +
        '        <th>name</th>\n' +
        '        <th>phone</th>\n' +
        '        <th>insertDate</th>\n' +
        '    </tr>';

    for (let i = 0; i < agencys.length; i++) {

        let row = table.insertRow(-1)
        let idCell = row.insertCell(0)
        let firstNameCell = row.insertCell(1)
        let phoneCell = row.insertCell(2)
        let insertDateCell = row.insertCell(3)


        let a = document.createElement('a');
        a.href = "http://localhost:8080/agency?id=" + agencys[i].id;
        a.text = agencys[i].id

        idCell.appendChild(a)
        firstNameCell.innerHTML = agencys[i].name
        phoneCell.innerHTML = agencys[i].phoneNumber
        insertDateCell.innerHTML = agencys[i].insertDate

    }
}