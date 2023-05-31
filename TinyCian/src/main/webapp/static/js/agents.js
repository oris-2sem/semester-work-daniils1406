function searchAgents(status, level, column, order) {
    return fetch('/agents/data?status=' + status + '&column=' + column + '&order=' + order + '&level=' + level)
        .then((response) => {
            return response.json()
        }).then((agents) => {
            fillList(agents)
        })
}

function fillList(agents) {
    let table = document.getElementById("agents");
    table.innerHTML = "";

    table.innerHTML = '    <tr>\n' +
        '        <th>id</th>\n' +
        '        <th>firstName</th>\n' +
        '        <th>lastName</th>\n' +
        '        <th>phone</th>\n' +
        '    </tr>';


    for (let i = 0; i < agents.length; i++) {

        let row = table.insertRow(-1)
        let idCell = row.insertCell(0)
        let firstNameCell = row.insertCell(1)
        let lastNameCell = row.insertCell(2)
        let phoneCell = row.insertCell(3)

        let a = document.createElement('a');
        a.href = "http://localhost:8080/agent?id=" + agents[i].id;
        a.text = agents[i].id

        idCell.appendChild(a)
        firstNameCell.innerHTML = agents[i].firstName
        lastNameCell.innerHTML = agents[i].lastName
        phoneCell.innerHTML = agents[i].phone

    }
}