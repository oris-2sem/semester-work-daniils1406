function searchResidentialComplexes(status, column, order) {
    return fetch('/residentialComplexes/data?status=' + status + '&column=' + column + '&order=' + order)
        .then((response) => {
            return response.json()
        }).then((residentialComplexes) => {
            fillList(residentialComplexes)
        })
}

function fillList(residentialComplexes) {
    let table = document.getElementById("residentialComplexes");
    table.innerHTML = "";

    table.innerHTML = '    <tr>\n' +
        '        <th>id</th>\n' +
        '        <th>name</th>\n' +
        '        <th>city</th>\n' +
        '        <th>phone</th>\n' +
        '        <th>agency</th>\n' +
        '    </tr>';


    for (let i = 0; i < residentialComplexes.length; i++) {

        let row = table.insertRow(-1)
        let idCell = row.insertCell(0)
        let nameCell = row.insertCell(1)
        let cityCell = row.insertCell(2)
        let phoneCell = row.insertCell(3)
        let agencyCell = row.insertCell(4)

        let a = document.createElement('a')
        a.href = "http://localhost:8080/residentialComplex?id=" + residentialComplexes[i].id;
        a.text = residentialComplexes[i].id

        idCell.appendChild(a)
        nameCell.innerHTML = residentialComplexes[i].name
        cityCell.innerHTML = residentialComplexes[i].city
        phoneCell.innerHTML = residentialComplexes[i].phoneNumber
        agencyCell.innerHTML = residentialComplexes[i].agency.name


    }
}