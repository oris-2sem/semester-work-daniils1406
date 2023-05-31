function searchUsers(status, role, column, order) {
    return fetch('/users/data?status=' + status + '&column=' + column + '&order=' + order + '&role=' + role)
        .then((response) => {
            return response.json()
        }).then((users) => {
            fillList(users)
        })
}

function fillList(users) {
    let table = document.getElementById("users");
    table.innerHTML = "";

    table.innerHTML = '    <tr>\n' +
        '        <th>id</th>\n' +
        '        <th>firstName</th>\n' +
        '        <th>lastName</th>\n' +
        '        <th>phone</th>\n' +
        '    </tr>';

    for (let i = 0; i < users.length; i++) {

        let row = table.insertRow(-1)
        let idCell = row.insertCell(0)
        let firstNameCell = row.insertCell(1)
        let lastNameCell = row.insertCell(2)
        let phoneCell = row.insertCell(3)

        let a = document.createElement('a');
        a.href = "http://localhost:8080/user?id=" + users[i].id;
        a.text = users[i].id

        idCell.appendChild(a)
        firstNameCell.innerHTML = users[i].firstName
        lastNameCell.innerHTML = users[i].lastName
        phoneCell.innerHTML = users[i].phone
    }
}