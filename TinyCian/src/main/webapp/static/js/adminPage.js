function getAdminPage() {
    fetch('/admin', {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        if (response.status === 403) {
            alert("Sorry you have not access to that info")
            location.replace("/account")
            return;
        }
        return response.text()
    }).then((html) => {
        var b = document.body;
        b.innerHTML = ''
        b.innerHTML = html
    })
}

function getUsersFilter() {
    let div = document.getElementById('filter')
    div.innerHTML = ''

    let roleLabel = document.createElement('label')
    roleLabel.innerHTML = 'role'
    let roleSelect = document.createElement('select')
    roleSelect.id = 'role'
    let clientOption = document.createElement('option')
    clientOption.value = 'CLIENT'
    clientOption.text = 'CLIENT'
    roleSelect.add(clientOption)
    let ownerOption = document.createElement('option')
    ownerOption.value = 'OWNER'
    ownerOption.text = 'OWNER'
    roleSelect.add(ownerOption)
    let adminOption = document.createElement('option')
    adminOption.value = 'ADMIN'
    adminOption.text = 'ADMIN'
    roleSelect.add(adminOption)
    roleLabel.appendChild(roleSelect)
    div.appendChild(roleLabel)

    let statusLabel = document.createElement('label')
    statusLabel.innerHTML = 'userStatus'
    let statusSelect = document.createElement('select')
    statusSelect.id = 'userStatus'
    let registeredOption = document.createElement('option')
    registeredOption.value = 'REGISTERED'
    registeredOption.text = 'REGISTERED'
    statusSelect.add(registeredOption)
    let verifiedOption = document.createElement('option')
    verifiedOption.value = 'VERIFIED'
    verifiedOption.text = 'VERIFIED'
    statusSelect.add(verifiedOption)
    let deleteOption = document.createElement('option')
    deleteOption.value = 'DELETE'
    deleteOption.text = 'DELETE'
    statusSelect.add(deleteOption)
    statusLabel.appendChild(statusSelect)
    div.appendChild(statusLabel)

    let columnLabel = document.createElement('label')
    columnLabel.innerHTML = 'column'
    let columnSelect = document.createElement('select')
    columnSelect.id = 'column'
    let idOption = document.createElement('option')
    idOption.value = 'id'
    idOption.text = 'id'
    columnSelect.add(idOption)
    let lastNameOption = document.createElement('option')
    lastNameOption.value = 'LastName'
    lastNameOption.text = 'LastName'
    columnSelect.add(lastNameOption)
    let createDateOption = document.createElement('option')
    createDateOption.value = 'createDate'
    createDateOption.text = 'createDate'
    columnSelect.add(createDateOption)
    let birthdayDateOption = document.createElement('option')
    birthdayDateOption.value = 'birthdayDate'
    birthdayDateOption.text = 'birthdayDate'
    columnSelect.add(birthdayDateOption)
    columnLabel.appendChild(columnSelect)
    div.appendChild(columnLabel)

    let orderLabel = document.createElement('label')
    orderLabel.innerHTML = 'order'
    let orderSelect = document.createElement('select')
    orderSelect.id = 'order'
    let ascOption = document.createElement('option')
    ascOption.value = 'ASC'
    ascOption.text = 'ASC'
    orderSelect.add(ascOption)
    let descOption = document.createElement('option')
    descOption.value = 'desc'
    descOption.text = 'desc'
    orderSelect.add(descOption)
    orderLabel.appendChild(orderSelect)
    div.appendChild(orderLabel)


    let button = document.createElement('button');
    button.textContent = 'search'
    button.addEventListener('click', () => {
        getUsers(
            document.getElementById('role').value,
            document.getElementById('userStatus').value,
            document.getElementById('column').value,
            document.getElementById('order').value
        )
    })
    div.appendChild(button)


    let fieldLabel = document.createElement('label')
    fieldLabel.innerHTML = 'field'
    let fieldSelect = document.createElement('select')
    fieldSelect.id = 'select'
    let loginOption = document.createElement('option')
    loginOption.id = 'login'
    loginOption.text = 'login'
    fieldSelect.add(loginOption)
    let nameOption = document.createElement('option')
    nameOption.id = 'name'
    nameOption.text = 'name'
    fieldSelect.add(nameOption)
    let phoneOption = document.createElement('option')
    phoneOption.id = 'phone'
    phoneOption.text = 'phone'
    fieldSelect.add(phoneOption)
    fieldLabel.appendChild(fieldSelect)
    div.appendChild(fieldLabel)

    let valueLabel = document.createElement('label')
    valueLabel.innerHTML = 'value'
    let valueInput = document.createElement('input')
    valueInput.id = 'value'
    valueInput.name = 'value'
    valueInput.type = 'text'
    valueLabel.appendChild(valueInput)
    let buttonForCertain = document.createElement('button')
    buttonForCertain.textContent = 'search'
    buttonForCertain.addEventListener('click', () => {
        findUser(document.getElementById('select').value,
            document.getElementById('value').value)
    })
    div.appendChild(valueLabel)
    div.appendChild(buttonForCertain)
}


function getUsers(role, userStatus, column, order) {
    fetch('/admin/users?role=' + role + '&userStatus=' + userStatus + '&column=' + column + '&order=' + order, {
        method: 'get',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        let table = document.getElementById('info')

        table.innerHTML = ''

        table.innerHTML = '    <tr>\n' +
            '        <th>id</th>\n' +
            '        <th>insertDate</th>\n' +
            '        <th>updateDate</th>\n' +
            '        <th>birthdayDate</th>\n' +
            '        <th>firstName</th>\n' +
            '        <th>lastName</th>\n' +
            '        <th>patronymic</th>\n' +
            '        <th>phone</th>\n' +
            '        <th>login</th>\n' +
            '        <th>role</th>\n' +
            '        <th>status</th>\n' +
            '        <th>userType</th>\n' +
            '        <th>delete</th>\n' +
            '    </tr>';

        for (let i = 0; i < users.length; i++) {
            let row = table.insertRow(-1)
            let idCell = row.insertCell(0)
            let insertDateCell = row.insertCell(1)
            let updateDateCell = row.insertCell(2)
            let birthdayDateCell = row.insertCell(3)
            let firstNameCell = row.insertCell(4)
            let lastNameCell = row.insertCell(5)
            let patronymicCell = row.insertCell(6)
            let phoneCell = row.insertCell(7)
            let loginCell = row.insertCell(8)
            let roleCell = row.insertCell(9)
            let statusCell = row.insertCell(10)
            let userTypeCell = row.insertCell(11)
            let deleteCell = row.insertCell(12)

            let button = document.createElement('button')

            button.addEventListener('click', () => {
                deleteUser(users[i].id)
            })
            button.textContent = 'delete'

            idCell.innerHTML = users[i].id
            idCell.id = 'cellForDelete' + users[i].id
            insertDateCell.innerHTML = users[i].insertDate
            updateDateCell.innerHTML = users[i].updateDate
            birthdayDateCell.innerHTML = users[i].birthdayDate
            firstNameCell.innerHTML = users[i].firstName
            lastNameCell.innerHTML = users[i].lastName
            patronymicCell.innerHTML = users[i].patronymic
            phoneCell.innerHTML = users[i].phone
            loginCell.innerHTML = users[i].login
            roleCell.innerHTML = users[i].role
            statusCell.innerHTML = users[i].status
            userTypeCell.innerHTML = users[i].userType
            deleteCell.appendChild(button)
        }
    })
}


function deleteUser(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/admin/deleteUser?id=' + id, {
        method: 'DELETE',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: params
    })
}


function findUser(field, value) {
    fetch('/admin/certainUser?field=' + field + '&value=' + value, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        let table = document.getElementById('info')

        table.innerHTML = ''

        table.innerHTML = '    <tr>\n' +
            '        <th>id</th>\n' +
            '        <th>insertDate</th>\n' +
            '        <th>updateDate</th>\n' +
            '        <th>birthdayDate</th>\n' +
            '        <th>firstName</th>\n' +
            '        <th>lastName</th>\n' +
            '        <th>patronymic</th>\n' +
            '        <th>phone</th>\n' +
            '        <th>login</th>\n' +
            '        <th>role</th>\n' +
            '        <th>status</th>\n' +
            '        <th>userType</th>\n' +
            '    </tr>';

        for (let i = 0; i < users.length; i++) {
            let row = table.insertRow(-1)
            let idCell = row.insertCell(0)
            let insertDateCell = row.insertCell(1)
            let updateDateCell = row.insertCell(2)
            let birthdayDateCell = row.insertCell(3)
            let firstNameCell = row.insertCell(4)
            let lastNameCell = row.insertCell(5)
            let patronymicCell = row.insertCell(6)
            let phoneCell = row.insertCell(7)
            let loginCell = row.insertCell(8)
            let roleCell = row.insertCell(9)
            let statusCell = row.insertCell(10)
            let userTypeCell = row.insertCell(11)
            let deleteCell = row.insertCell(12)

            let button = document.createElement('button')

            button.addEventListener('click', () => {
                deleteUser(users[i].id)
            })
            button.textContent = 'delete'

            idCell.innerHTML = users[i].id
            idCell.id = 'cellForDelete' + users[i].id
            insertDateCell.innerHTML = users[i].insertDate
            updateDateCell.innerHTML = users[i].updateDate
            birthdayDateCell.innerHTML = users[i].birthdayDate
            firstNameCell.innerHTML = users[i].firstName
            lastNameCell.innerHTML = users[i].lastName
            patronymicCell.innerHTML = users[i].patronymic
            phoneCell.innerHTML = users[i].phone
            loginCell.innerHTML = users[i].login
            roleCell.innerHTML = users[i].role
            statusCell.innerHTML = users[i].status
            userTypeCell.innerHTML = users[i].userType
            deleteCell.appendChild(button)
        }
    })
}

//////////////////////////////////////////////////////////////////////////////////


function getAgentsFilter() {
    let div = document.getElementById('filter')
    div.innerHTML = ''

    let agentLevelLabel = document.createElement('label')
    agentLevelLabel.innerHTML = 'agentLevel'
    let agentLevelSelect = document.createElement('select')
    agentLevelSelect.id = 'agentLevel'
    let startigOption = document.createElement('option')
    startigOption.value = 'STARTING'
    startigOption.text = 'STARTING'
    agentLevelSelect.add(startigOption)
    let verifiedLevelOption = document.createElement('option')
    verifiedLevelOption.value = 'VERIFIED'
    verifiedLevelOption.text = 'VERIFIED'
    agentLevelSelect.add(verifiedLevelOption)
    let experiencedOption = document.createElement('option')
    experiencedOption.value = 'EXPERIENCED'
    experiencedOption.text = 'EXPERIENCED'
    agentLevelSelect.add(experiencedOption)
    let proOption = document.createElement('option')
    proOption.value = 'PRO'
    proOption.text = 'PRO'
    agentLevelSelect.add(proOption)
    agentLevelLabel.appendChild(agentLevelSelect)
    div.appendChild(agentLevelLabel)

    let statusLabel = document.createElement('label')
    statusLabel.innerHTML = 'userStatus'
    let statusSelect = document.createElement('select')
    statusSelect.id = 'userStatus'
    let registeredOption = document.createElement('option')
    registeredOption.value = 'REGISTERED'
    registeredOption.text = 'REGISTERED'
    statusSelect.add(registeredOption)
    let verifiedOption = document.createElement('option')
    verifiedOption.value = 'VERIFIED'
    verifiedOption.text = 'VERIFIED'
    statusSelect.add(verifiedOption)
    let deleteOption = document.createElement('option')
    deleteOption.value = 'DELETE'
    deleteOption.text = 'DELETE'
    statusSelect.add(deleteOption)
    statusLabel.appendChild(statusSelect)
    div.appendChild(statusLabel)

    let columnLabel = document.createElement('label')
    columnLabel.innerHTML = 'column'
    let columnSelect = document.createElement('select')
    columnSelect.id = 'column'
    let idOption = document.createElement('option')
    idOption.value = 'id'
    idOption.text = 'id'
    columnSelect.add(idOption)
    let lastNameOption = document.createElement('option')
    lastNameOption.value = 'LastName'
    lastNameOption.text = 'LastName'
    columnSelect.add(lastNameOption)
    let createDateOption = document.createElement('option')
    createDateOption.value = 'createDate'
    createDateOption.text = 'createDate'
    columnSelect.add(createDateOption)
    let birthdayDateOption = document.createElement('option')
    birthdayDateOption.value = 'birthdayDate'
    birthdayDateOption.text = 'birthdayDate'
    columnSelect.add(birthdayDateOption)
    columnLabel.appendChild(columnSelect)
    div.appendChild(columnLabel)

    let orderLabel = document.createElement('label')
    orderLabel.innerHTML = 'order'
    let orderSelect = document.createElement('select')
    orderSelect.id = 'order'
    let ascOption = document.createElement('option')
    ascOption.value = 'ASC'
    ascOption.text = 'ASC'
    orderSelect.add(ascOption)
    let descOption = document.createElement('option')
    descOption.value = 'desc'
    descOption.text = 'desc'
    orderSelect.add(descOption)
    orderLabel.appendChild(orderSelect)
    div.appendChild(orderLabel)


    let button = document.createElement('button');
    button.addEventListener('click', () => {
        getAgents(document.getElementById('agentLevel').value,
            document.getElementById('userStatus').value,
            document.getElementById('column').value,
            document.getElementById('order').value)
    })
    button.textContent = 'search'
    div.appendChild(button)


    let fieldLabel = document.createElement('label')
    fieldLabel.innerHTML = 'field'
    let fieldSelect = document.createElement('select')
    fieldSelect.id = 'select'
    let nameOption = document.createElement('option')
    nameOption.id = 'name'
    nameOption.text = 'name'
    fieldSelect.add(nameOption)
    let phoneOption = document.createElement('option')
    phoneOption.id = 'phone'
    phoneOption.text = 'phone'
    fieldSelect.add(phoneOption)
    let agencyNameOption = document.createElement('option')
    agencyNameOption.id = 'agencyName'
    agencyNameOption.text = 'agencyName'
    fieldSelect.add(agencyNameOption)
    fieldLabel.appendChild(fieldSelect)
    div.appendChild(fieldLabel)

    let valueLabel = document.createElement('label')
    valueLabel.innerHTML = 'value'
    let valueInput = document.createElement('input')
    valueInput.id = 'value'
    valueInput.name = 'value'
    valueInput.type = 'text'
    valueLabel.appendChild(valueInput)
    let buttonForCertain = document.createElement('button')
    buttonForCertain.textContent = 'search'
    buttonForCertain.addEventListener('click', () => {
        findAgent(document.getElementById('select').value,
            document.getElementById('value').value)
    })
    div.appendChild(valueLabel)
    div.appendChild(buttonForCertain)

}


function getAgents(agentLevel, userStatus, column, order) {
    fetch('/admin/agents?agentLevel=' + agentLevel + '&userStatus=' + userStatus + '&column=' + column + '&order=' + order, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        let table = document.getElementById('info')

        table.innerHTML = ''

        table.innerHTML = '    <tr>\n' +
            '        <th>id</th>\n' +
            '        <th>insertDate</th>\n' +
            '        <th>updateDate</th>\n' +
            '        <th>birthdayDate</th>\n' +
            '        <th>firstName</th>\n' +
            '        <th>lastName</th>\n' +
            '        <th>patronymic</th>\n' +
            '        <th>phone</th>\n' +
            '        <th>login</th>\n' +
            '        <th>role</th>\n' +
            '        <th>status</th>\n' +
            '        <th>userType</th>\n' +
            '        <th>organisation</th>\n' +
            '        <th>agentLevel</th>\n' +
            '        <th>delete</th>\n' +
            '    </tr>';

        for (let i = 0; i < users.length; i++) {
            let row = table.insertRow(-1)
            let idCell = row.insertCell(0)
            let insertDateCell = row.insertCell(1)
            let updateDateCell = row.insertCell(2)
            let birthdayDateCell = row.insertCell(3)
            let firstNameCell = row.insertCell(4)
            let lastNameCell = row.insertCell(5)
            let patronymicCell = row.insertCell(6)
            let phoneCell = row.insertCell(7)
            let loginCell = row.insertCell(8)
            let roleCell = row.insertCell(9)
            let statusCell = row.insertCell(10)
            let userTypeCell = row.insertCell(11)
            let organisationCell = row.insertCell(12)
            let agentLevelCell = row.insertCell(13)
            let deleteCell = row.insertCell(14)

            let button = document.createElement('button')

            button.addEventListener('click', () => {
                deleteAgent(users[i].id)
            })

            button.textContent = 'delete'

            idCell.innerHTML = users[i].id
            idCell.id = 'cellForDelete' + users[i].id
            insertDateCell.innerHTML = users[i].insertDate
            updateDateCell.innerHTML = users[i].updateDate
            birthdayDateCell.innerHTML = users[i].birthdayDate
            firstNameCell.innerHTML = users[i].firstName
            lastNameCell.innerHTML = users[i].lastName
            patronymicCell.innerHTML = users[i].patronymic
            phoneCell.innerHTML = users[i].phone
            loginCell.innerHTML = users[i].login
            roleCell.innerHTML = users[i].role
            statusCell.innerHTML = users[i].status
            userTypeCell.innerHTML = users[i].userType
            organisationCell.innerHTML = users[i].organisation.id
            agentLevelCell.innerHTML = users[i].agentLevel
            deleteCell.appendChild(button)
        }
    })
}


function deleteAgent(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/admin/deleteAgent?id=' + id, {
        method: 'DELETE',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: params
    })
}


function findAgent(field, value) {
    fetch('/admin/certainAgent?field=' + field + '&value=' + value, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        let table = document.getElementById('info')

        table.innerHTML = ''

        table.innerHTML = '    <tr>\n' +
            '        <th>id</th>\n' +
            '        <th>insertDate</th>\n' +
            '        <th>updateDate</th>\n' +
            '        <th>birthdayDate</th>\n' +
            '        <th>firstName</th>\n' +
            '        <th>lastName</th>\n' +
            '        <th>patronymic</th>\n' +
            '        <th>phone</th>\n' +
            '        <th>login</th>\n' +
            '        <th>role</th>\n' +
            '        <th>status</th>\n' +
            '        <th>userType</th>\n' +
            '        <th>organisation</th>\n' +
            '        <th>agentLevel</th>\n' +
            '        <th>delete</th>\n' +
            '    </tr>';

        for (let i = 0; i < users.length; i++) {
            let row = table.insertRow(-1)
            let idCell = row.insertCell(0)
            let insertDateCell = row.insertCell(1)
            let updateDateCell = row.insertCell(2)
            let birthdayDateCell = row.insertCell(3)
            let firstNameCell = row.insertCell(4)
            let lastNameCell = row.insertCell(5)
            let patronymicCell = row.insertCell(6)
            let phoneCell = row.insertCell(7)
            let loginCell = row.insertCell(8)
            let roleCell = row.insertCell(9)
            let statusCell = row.insertCell(10)
            let userTypeCell = row.insertCell(11)
            let organisationCell = row.insertCell(12)
            let agentLevelCell = row.insertCell(13)
            let deleteCell = row.insertCell(14)

            let button = document.createElement('button')

            button.addEventListener('click', () => {
                deleteAgent(users[i].id)
            })

            button.textContent = 'delete'

            idCell.innerHTML = users[i].id
            idCell.id = 'cellForDelete' + users[i].id
            insertDateCell.innerHTML = users[i].insertDate
            updateDateCell.innerHTML = users[i].updateDate
            birthdayDateCell.innerHTML = users[i].birthdayDate
            firstNameCell.innerHTML = users[i].firstName
            lastNameCell.innerHTML = users[i].lastName
            patronymicCell.innerHTML = users[i].patronymic
            phoneCell.innerHTML = users[i].phone
            loginCell.innerHTML = users[i].login
            roleCell.innerHTML = users[i].role
            statusCell.innerHTML = users[i].status
            userTypeCell.innerHTML = users[i].userType
            organisationCell.innerHTML = users[i].organisation.id
            agentLevelCell.innerHTML = users[i].agentLevel
            deleteCell.appendChild(button)
        }
    })
}


////////////////////////////////////////////////////////////////////


function getRepresentativeFilter() {
    let div = document.getElementById('filter')
    div.innerHTML = ''


    let statusLabel = document.createElement('label')
    statusLabel.innerHTML = 'userStatus'
    let statusSelect = document.createElement('select')
    statusSelect.id = 'userStatus'
    let registeredOption = document.createElement('option')
    registeredOption.value = 'REGISTERED'
    registeredOption.text = 'REGISTERED'
    statusSelect.add(registeredOption)
    let verifiedOption = document.createElement('option')
    verifiedOption.value = 'VERIFIED'
    verifiedOption.text = 'VERIFIED'
    statusSelect.add(verifiedOption)
    let deleteOption = document.createElement('option')
    deleteOption.value = 'DELETE'
    deleteOption.text = 'DELETE'
    statusSelect.add(deleteOption)
    statusLabel.appendChild(statusSelect)
    div.appendChild(statusLabel)

    let columnLabel = document.createElement('label')
    columnLabel.innerHTML = 'column'
    let columnSelect = document.createElement('select')
    columnSelect.id = 'column'
    let idOption = document.createElement('option')
    idOption.value = 'id'
    idOption.text = 'id'
    columnSelect.add(idOption)
    let lastNameOption = document.createElement('option')
    lastNameOption.value = 'LastName'
    lastNameOption.text = 'LastName'
    columnSelect.add(lastNameOption)
    let createDateOption = document.createElement('option')
    createDateOption.value = 'createDate'
    createDateOption.text = 'createDate'
    columnSelect.add(createDateOption)
    let birthdayDateOption = document.createElement('option')
    birthdayDateOption.value = 'birthdayDate'
    birthdayDateOption.text = 'birthdayDate'
    columnSelect.add(birthdayDateOption)
    columnLabel.appendChild(columnSelect)
    div.appendChild(columnLabel)

    let orderLabel = document.createElement('label')
    orderLabel.innerHTML = 'order'
    let orderSelect = document.createElement('select')
    orderSelect.id = 'order'
    let ascOption = document.createElement('option')
    ascOption.value = 'asc'
    ascOption.text = 'asc'
    orderSelect.add(ascOption)
    let descOption = document.createElement('option')
    descOption.value = 'desc'
    descOption.text = 'desc'
    orderSelect.add(descOption)
    orderLabel.appendChild(orderSelect)
    div.appendChild(orderLabel)


    let button = document.createElement('button');
    button.addEventListener('click', () => {
        getRepresentatives(document.getElementById('userStatus').value,
            document.getElementById('column').value,
            document.getElementById('order').value)
    })
    button.textContent = 'search'
    div.appendChild(button)


    let fieldLabel = document.createElement('label')
    fieldLabel.innerHTML = 'field'
    let fieldSelect = document.createElement('select')
    fieldSelect.id = 'select'
    let nameOption = document.createElement('option')
    nameOption.id = 'name'
    nameOption.text = 'name'
    fieldSelect.add(nameOption)
    let phoneOption = document.createElement('option')
    phoneOption.id = 'phone'
    phoneOption.text = 'phone'
    fieldSelect.add(phoneOption)
    let agencyNameOption = document.createElement('option')
    agencyNameOption.id = 'agencyName'
    agencyNameOption.text = 'agencyName'
    fieldSelect.add(agencyNameOption)
    fieldLabel.appendChild(fieldSelect)
    div.appendChild(fieldLabel)

    let valueLabel = document.createElement('label')
    valueLabel.innerHTML = 'value'
    let valueInput = document.createElement('input')
    valueInput.id = 'value'
    valueInput.name = 'value'
    valueInput.type = 'text'
    valueLabel.appendChild(valueInput)
    let buttonForCertain = document.createElement('button')
    buttonForCertain.textContent = 'search'
    buttonForCertain.addEventListener('click', () => {
        findRepresentative(document.getElementById('select').value,
            document.getElementById('value').value)
    })
    div.appendChild(valueLabel)
    div.appendChild(buttonForCertain)
}


function getRepresentatives(userStatus, column, order) {
    fetch('/admin/representative?userStatus=' + userStatus + '&column=' + column + '&order=' + order, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        let table = document.getElementById('info')

        table.innerHTML = ''

        table.innerHTML = '    <tr>\n' +
            '        <th>id</th>\n' +
            '        <th>insertDate</th>\n' +
            '        <th>updateDate</th>\n' +
            '        <th>birthdayDate</th>\n' +
            '        <th>firstName</th>\n' +
            '        <th>lastName</th>\n' +
            '        <th>patronymic</th>\n' +
            '        <th>phone</th>\n' +
            '        <th>login</th>\n' +
            '        <th>role</th>\n' +
            '        <th>status</th>\n' +
            '        <th>userType</th>\n' +
            '        <th>organisation</th>\n' +
            '        <th>agentLevel</th>\n' +
            '        <th>delete</th>\n' +
            '    </tr>';

        for (let i = 0; i < users.length; i++) {
            let row = table.insertRow(-1)
            let idCell = row.insertCell(0)
            let insertDateCell = row.insertCell(1)
            let updateDateCell = row.insertCell(2)
            let birthdayDateCell = row.insertCell(3)
            let firstNameCell = row.insertCell(4)
            let lastNameCell = row.insertCell(5)
            let patronymicCell = row.insertCell(6)
            let phoneCell = row.insertCell(7)
            let loginCell = row.insertCell(8)
            let roleCell = row.insertCell(9)
            let statusCell = row.insertCell(10)
            let userTypeCell = row.insertCell(11)
            let organisationCell = row.insertCell(12)
            let deleteCell = row.insertCell(13)

            let button = document.createElement('button')

            button.addEventListener('click', () => {
                deleteRepresentative(users[i].id)
            })

            button.textContent = 'delete'

            idCell.innerHTML = users[i].id
            idCell.id = 'cellForDelete' + users[i].id
            insertDateCell.innerHTML = users[i].insertDate
            updateDateCell.innerHTML = users[i].updateDate
            birthdayDateCell.innerHTML = users[i].birthdayDate
            firstNameCell.innerHTML = users[i].firstName
            lastNameCell.innerHTML = users[i].lastName
            patronymicCell.innerHTML = users[i].patronymic
            phoneCell.innerHTML = users[i].phone
            loginCell.innerHTML = users[i].login
            roleCell.innerHTML = users[i].role
            statusCell.innerHTML = users[i].status
            userTypeCell.innerHTML = users[i].userType
            organisationCell.innerHTML = users[i].organisation.id
            deleteCell.appendChild(button)
        }
    })
}


function deleteRepresentative(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/admin/deleteRepresentative?id=' + id, {
        method: 'DELETE',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: params
    })
}


function findRepresentative(field, value) {
    fetch('/admin/certainRepresentative?field=' + field + '&value=' + value, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        let table = document.getElementById('info')

        table.innerHTML = ''

        table.innerHTML = '    <tr>\n' +
            '        <th>id</th>\n' +
            '        <th>insertDate</th>\n' +
            '        <th>updateDate</th>\n' +
            '        <th>birthdayDate</th>\n' +
            '        <th>firstName</th>\n' +
            '        <th>lastName</th>\n' +
            '        <th>patronymic</th>\n' +
            '        <th>phone</th>\n' +
            '        <th>login</th>\n' +
            '        <th>role</th>\n' +
            '        <th>status</th>\n' +
            '        <th>userType</th>\n' +
            '        <th>organisation</th>\n' +
            '        <th>delete</th>\n' +
            '    </tr>';

        for (let i = 0; i < users.length; i++) {
            let row = table.insertRow(-1)
            let idCell = row.insertCell(0)
            let insertDateCell = row.insertCell(1)
            let updateDateCell = row.insertCell(2)
            let birthdayDateCell = row.insertCell(3)
            let firstNameCell = row.insertCell(4)
            let lastNameCell = row.insertCell(5)
            let patronymicCell = row.insertCell(6)
            let phoneCell = row.insertCell(7)
            let loginCell = row.insertCell(8)
            let roleCell = row.insertCell(9)
            let statusCell = row.insertCell(10)
            let userTypeCell = row.insertCell(11)
            let organisationCell = row.insertCell(12)
            let deleteCell = row.insertCell(13)

            let button = document.createElement('button')

            button.addEventListener('click', () => {
                deleteRepresentative(users[i].id)
            })

            button.textContent = 'delete'

            idCell.innerHTML = users[i].id
            idCell.id = 'cellForDelete' + users[i].id
            insertDateCell.innerHTML = users[i].insertDate
            updateDateCell.innerHTML = users[i].updateDate
            birthdayDateCell.innerHTML = users[i].birthdayDate
            firstNameCell.innerHTML = users[i].firstName
            lastNameCell.innerHTML = users[i].lastName
            patronymicCell.innerHTML = users[i].patronymic
            phoneCell.innerHTML = users[i].phone
            loginCell.innerHTML = users[i].login
            roleCell.innerHTML = users[i].role
            statusCell.innerHTML = users[i].status
            userTypeCell.innerHTML = users[i].userType
            organisationCell.innerHTML = users[i].organisation.id
            deleteCell.appendChild(button)
        }
    })
}


////////////////////////////////////////////////////////////////////////


function getAgencysFilter() {
    let div = document.getElementById('filter')
    div.innerHTML = ''


    let agencyStatusLabel = document.createElement('label')
    agencyStatusLabel.innerHTML = 'agencyStatus'
    let statusSelect = document.createElement('select')
    statusSelect.id = 'agencyStatus'
    let registeredOption = document.createElement('option')
    registeredOption.value = 'REGISTERED'
    registeredOption.text = 'REGISTERED'
    statusSelect.add(registeredOption)
    let verifiedOption = document.createElement('option')
    verifiedOption.value = 'VERIFIED'
    verifiedOption.text = 'VERIFIED'
    statusSelect.add(verifiedOption)
    let deleteOption = document.createElement('option')
    deleteOption.value = 'DELETE'
    deleteOption.text = 'DELETE'
    statusSelect.add(deleteOption)
    agencyStatusLabel.appendChild(statusSelect)
    div.appendChild(agencyStatusLabel)

    let columnLabel = document.createElement('label')
    columnLabel.innerHTML = 'column'
    let columnSelect = document.createElement('select')
    columnSelect.id = 'column'
    let idOption = document.createElement('option')
    idOption.value = 'id'
    idOption.text = 'id'
    columnSelect.add(idOption)
    let lastNameOption = document.createElement('option')
    lastNameOption.value = 'name'
    lastNameOption.text = 'name'
    columnSelect.add(lastNameOption)
    let createDateOption = document.createElement('option')
    createDateOption.value = 'createDate'
    createDateOption.text = 'createDate'
    columnSelect.add(createDateOption)
    columnLabel.appendChild(columnSelect)
    div.appendChild(columnLabel)

    let orderLabel = document.createElement('label')
    orderLabel.innerHTML = 'order'
    let orderSelect = document.createElement('select')
    orderSelect.id = 'order'
    let ascOption = document.createElement('option')
    ascOption.value = 'asc'
    ascOption.text = 'asc'
    orderSelect.add(ascOption)
    let descOption = document.createElement('option')
    descOption.value = 'desc'
    descOption.text = 'desc'
    orderSelect.add(descOption)
    orderLabel.appendChild(orderSelect)
    div.appendChild(orderLabel)


    let button = document.createElement('button');
    button.textContent = 'search'
    button.addEventListener('click', () => {
        getAgencys(
            document.getElementById('agencyStatus').value,
            document.getElementById('column').value,
            document.getElementById('order').value)
    })
    div.appendChild(button)


    let fieldLabel = document.createElement('label')
    fieldLabel.innerHTML = 'field'
    let fieldSelect = document.createElement('select')
    fieldSelect.id = 'select'
    let idOptionForSearch = document.createElement('option')
    idOptionForSearch.id = 'id'
    idOptionForSearch.text = 'id'
    fieldSelect.add(idOptionForSearch)
    // let loginOption=document.createElement('option')
    // loginOption.id='login'
    // loginOption.text='login'
    // fieldSelect.add(loginOption)
    // let nameOption=document.createElement('option')
    // nameOption.id='name'
    // nameOption.text='name'
    // fieldSelect.add(nameOption)
    // let phoneOption=document.createElement('option')
    // phoneOption.id='phone'
    // phoneOption.text='phone'
    // fieldSelect.add(phoneOption)
    fieldLabel.appendChild(fieldSelect)
    div.appendChild(fieldLabel)

    let valueLabel = document.createElement('label')
    valueLabel.innerHTML = 'value'
    let valueInput = document.createElement('input')
    valueInput.id = 'value'
    valueInput.name = 'value'
    valueInput.type = 'text'
    valueLabel.appendChild(valueInput)
    let buttonForCertain = document.createElement('button')
    buttonForCertain.textContent = 'search'
    buttonForCertain.addEventListener('click', () => {
        findAgency(document.getElementById('select').value,
            document.getElementById('value').value)
    })
    div.appendChild(valueLabel)
    div.appendChild(buttonForCertain)
}


function getAgencys(agencyStatus, column, order) {
    fetch('/admin/agencys?agencyStatus=' + agencyStatus + '&column=' + column + '&order=' + order, {
        method: 'get',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        let table = document.getElementById('info')

        table.innerHTML = ''

        table.innerHTML = '    <tr>\n' +
            '        <th>id</th>\n' +
            '        <th>name</th>\n' +
            '        <th>description</th>\n' +
            '        <th>phoneNumber</th>\n' +
            '        <th>linkOnWebsite</th>\n' +
            '        <th>status</th>\n' +
            '        <th>insertDate</th>\n' +
            '        <th>delete</th>\n' +
            '    </tr>';

        for (let i = 0; i < users.length; i++) {
            let row = table.insertRow(-1)
            let idCell = row.insertCell(0)
            let nameCell = row.insertCell(1)
            let descriptionCell = row.insertCell(2)
            let phoneNumberCell = row.insertCell(3)
            let linkOnWebsiteCell = row.insertCell(4)
            let statusCell = row.insertCell(5)
            let insertDateCell = row.insertCell(6)
            let deleteCell = row.insertCell(7)

            let button = document.createElement('button')

            button.addEventListener('click', () => {
                deleteAgency(users[i].id)
            })

            button.textContent = 'delete'

            idCell.innerHTML = users[i].id
            idCell.id = 'cellForDelete' + users[i].id
            nameCell.innerHTML = users[i].name
            descriptionCell.innerHTML = users[i].description
            phoneNumberCell.innerHTML = users[i].phoneNumber
            linkOnWebsiteCell.innerHTML = users[i].linkOnWebsite
            statusCell.innerHTML = users[i].status
            insertDateCell.innerHTML = users[i].insertDate
            deleteCell.appendChild(button)
        }
    })
}


function deleteAgency(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/admin/deleteAgency?id=' + id, {
        method: 'DELETE',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: params
    })
}


function findAgency(field, value) {
    fetch('/admin/certainAgency?field=' + field + '&value=' + value, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        let table = document.getElementById('info')

        table.innerHTML = ''

        table.innerHTML = '    <tr>\n' +
            '        <th>id</th>\n' +
            '        <th>name</th>\n' +
            '        <th>description</th>\n' +
            '        <th>phoneNumber</th>\n' +
            '        <th>linkOnWebsite</th>\n' +
            '        <th>status</th>\n' +
            '        <th>insertDate</th>\n' +
            '        <th>delete</th>\n' +
            '    </tr>';

        for (let i = 0; i < users.length; i++) {
            let row = table.insertRow(-1)
            let idCell = row.insertCell(0)
            let nameCell = row.insertCell(1)
            let descriptionCell = row.insertCell(2)
            let phoneNumberCell = row.insertCell(3)
            let linkOnWebsiteCell = row.insertCell(4)
            let statusCell = row.insertCell(5)
            let insertDateCell = row.insertCell(6)
            let deleteCell = row.insertCell(7)

            let button = document.createElement('button')

            button.addEventListener('click', () => {
                deleteAgency(users[i].id)
            })
            button.textContent = 'delete'

            idCell.innerHTML = users[i].id
            idCell.id = 'cellForDelete' + users[i].id
            nameCell.innerHTML = users[i].name
            descriptionCell.innerHTML = users[i].description
            phoneNumberCell.innerHTML = users[i].phoneNumber
            linkOnWebsiteCell.innerHTML = users[i].linkOnWebsite
            statusCell.innerHTML = users[i].status
            insertDateCell.innerHTML = users[i].insertDate
            deleteCell.appendChild(button)
        }
    })
}


//////////////////////////////////////////////////////////////

function getResidentialComplexFilter() {
    let div = document.getElementById('filter')
    div.innerHTML = ''


    let residentialComplexStatusLabel = document.createElement('label')
    residentialComplexStatusLabel.innerHTML = 'residentialComplexStatus'
    let residentialComplexStatusSelect = document.createElement('select')
    residentialComplexStatusSelect.id = 'residentialComplexStatus'
    residentialComplexStatusSelect.name = 'residentialComplexStatus'
    residentialComplexStatusSelect.type = 'text'
    let registeredOption = document.createElement('option')
    registeredOption.value = 'REGISTERED'
    registeredOption.text = 'REGISTERED'
    residentialComplexStatusSelect.add(registeredOption)
    let verifiedOption = document.createElement('option')
    verifiedOption.value = 'VERIFIED'
    verifiedOption.text = 'VERIFIED'
    residentialComplexStatusSelect.add(verifiedOption)
    let deleteOption = document.createElement('option')
    deleteOption.value = 'DELETE'
    deleteOption.text = 'DELETE'
    residentialComplexStatusSelect.add(deleteOption)
    residentialComplexStatusLabel.appendChild(residentialComplexStatusSelect)
    div.appendChild(residentialComplexStatusLabel)

    let columnLabel = document.createElement('label')
    columnLabel.innerHTML = 'column'
    let columnSelect = document.createElement('select')
    columnSelect.id = 'column'
    let idOption = document.createElement('option')
    idOption.value = 'id'
    idOption.text = 'id'
    columnSelect.add(idOption)
    let nameOption = document.createElement('option')
    nameOption.value = 'name'
    nameOption.text = 'name'
    columnSelect.add(nameOption)
    let numberOfBuildingsOption = document.createElement('option')
    numberOfBuildingsOption.value = 'numberOfBuildings'
    numberOfBuildingsOption.text = 'numberOfBuildings'
    columnSelect.add(numberOfBuildingsOption)
    columnLabel.appendChild(columnSelect)
    div.appendChild(columnLabel)

    let orderLabel = document.createElement('label')
    orderLabel.innerHTML = 'order'
    let orderSelect = document.createElement('select')
    orderSelect.id = 'order'
    let ascOption = document.createElement('option')
    ascOption.value = 'asc'
    ascOption.text = 'asc'
    orderSelect.add(ascOption)
    let descOption = document.createElement('option')
    descOption.value = 'desc'
    descOption.text = 'desc'
    orderSelect.add(descOption)
    orderLabel.appendChild(orderSelect)
    div.appendChild(orderLabel)


    let button = document.createElement('button');
    button.textContent = 'search'
    button.addEventListener('click', () => {
        getResidentialComplexes(
            document.getElementById('residentialComplexStatus').value,
            document.getElementById('column').value,
            document.getElementById('order').value)
    })
    div.appendChild(button)


    let fieldLabel = document.createElement('label')
    fieldLabel.innerHTML = 'field'
    let fieldSelect = document.createElement('select')
    fieldSelect.id = 'select'
    let idOptionForSearch = document.createElement('option')
    idOptionForSearch.id = 'id'
    idOptionForSearch.text = 'id'
    fieldSelect.add(idOptionForSearch)
    let nameOptionForCurrency = document.createElement('option')
    nameOptionForCurrency.id = 'name'
    nameOptionForCurrency.text = 'name'
    fieldSelect.add(nameOptionForCurrency)
    fieldLabel.appendChild(fieldSelect)
    div.appendChild(fieldLabel)

    let valueLabel = document.createElement('label')
    valueLabel.innerHTML = 'value'
    let valueInput = document.createElement('input')
    valueInput.id = 'value'
    valueInput.name = 'value'
    valueInput.type = 'text'
    valueLabel.appendChild(valueInput)
    let buttonForCertain = document.createElement('button')
    buttonForCertain.textContent = 'search'
    buttonForCertain.addEventListener('click', () => {
        findResidentialComplex(document.getElementById('select').value,
            document.getElementById('value').value)
    })
    div.appendChild(valueLabel)
    div.appendChild(buttonForCertain)
}


function getResidentialComplexes(residentialComplexStatus, column, order) {
    fetch('/admin/residentialComplexes?residentialComplexStatus=' + residentialComplexStatus + '&column=' + column + '&order=' + order, {
        method: 'get',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        let table = document.getElementById('info')

        table.innerHTML = ''

        table.innerHTML = '    <tr>\n' +
            '        <th>id</th>\n' +
            '        <th>city</th>\n' +
            '        <th>district</th>\n' +
            '        <th>numberOfBuildings</th>\n' +
            '        <th>numberOfReadyBuildings</th>\n' +
            '        <th>agency</th>\n' +
            '        <th>name</th>\n' +
            '        <th>description</th>\n' +
            '        <th>linkOnWebsite</th>\n' +
            '        <th>phoneNumber</th>\n' +
            '        <th>deliveryYear</th>\n' +
            '        <th>status</th>\n' +
            '        <th>delete</th>\n' +
            '    </tr>';

        for (let i = 0; i < users.length; i++) {
            let row = table.insertRow(-1)
            let idCell = row.insertCell(0)
            let cityCell = row.insertCell(1)
            let districtCell = row.insertCell(2)
            let numberOfBuildingsCell = row.insertCell(3)
            let numberOfReadyBuildingsCell = row.insertCell(4)
            let agencyCell = row.insertCell(5)
            let nameCell = row.insertCell(6)
            let descriptionCell = row.insertCell(7)
            let linkOnWebsiteCell = row.insertCell(8)
            let phoneNumberCell = row.insertCell(9)
            let deliveryYearCell = row.insertCell(10)
            let statusCell = row.insertCell(11)
            let deleteCell = row.insertCell(12)

            let button = document.createElement('button')

            button.addEventListener('click', () => {
                deleteResidentialComplex(users[i].id)
            })
            button.textContent = 'delete'

            idCell.innerHTML = users[i].id
            idCell.id = 'cellForDelete' + users[i].id
            cityCell.innerHTML = users[i].city
            districtCell.innerHTML = users[i].district
            numberOfBuildingsCell.innerHTML = users[i].numberOfBuildings
            numberOfReadyBuildingsCell.innerHTML = users[i].numberOfReadyBuildings
            agencyCell.innerHTML = users[i].agency.name
            nameCell.innerHTML = users[i].name
            descriptionCell.innerHTML = users[i].description
            linkOnWebsiteCell.innerHTML = users[i].linkOnWebsite
            phoneNumberCell.innerHTML = users[i].phoneNumber
            deliveryYearCell.innerHTML = users[i].deliveryYear
            statusCell.innerHTML = users[i].status
            deleteCell.appendChild(button)
        }
    })
}


function deleteResidentialComplex(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/admin/deleteResidentialComplex?id=' + id, {
        method: 'DELETE',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: params
    })
}


function findResidentialComplex(field, value) {
    fetch('/admin/certainResidentialComplex?field=' + field + '&value=' + value, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        let table = document.getElementById('info')

        table.innerHTML = ''

        table.innerHTML = '    <tr>\n' +
            '        <th>id</th>\n' +
            '        <th>city</th>\n' +
            '        <th>district</th>\n' +
            '        <th>numberOfBuildings</th>\n' +
            '        <th>numberOfReadyBuildings</th>\n' +
            '        <th>agency</th>\n' +
            '        <th>name</th>\n' +
            '        <th>description</th>\n' +
            '        <th>linkOnWebsite</th>\n' +
            '        <th>phoneNumber</th>\n' +
            '        <th>deliveryYear</th>\n' +
            '        <th>status</th>\n' +
            '        <th>delete</th>\n' +
            '    </tr>';

        for (let i = 0; i < users.length; i++) {
            let row = table.insertRow(-1)
            let idCell = row.insertCell(0)
            let cityCell = row.insertCell(1)
            let districtCell = row.insertCell(2)
            let numberOfBuildingsCell = row.insertCell(3)
            let numberOfReadyBuildingsCell = row.insertCell(4)
            let agencyCell = row.insertCell(5)
            let nameCell = row.insertCell(6)
            let descriptionCell = row.insertCell(7)
            let linkOnWebsiteCell = row.insertCell(8)
            let phoneNumberCell = row.insertCell(9)
            let deliveryYearCell = row.insertCell(10)
            let statusCell = row.insertCell(11)
            let deleteCell = row.insertCell(12)

            let button = document.createElement('button')

            button.addEventListener('click', () => {
                deleteResidentialComplex(users[i].id)
            })
            button.textContent = 'delete'

            idCell.innerHTML = users[i].id
            idCell.id = 'cellForDelete' + users[i].id
            cityCell.innerHTML = users[i].city
            districtCell.innerHTML = users[i].district
            numberOfBuildingsCell.innerHTML = users[i].numberOfBuildings
            numberOfReadyBuildingsCell.innerHTML = users[i].numberOfReadyBuildings
            agencyCell.innerHTML = users[i].agency.name
            nameCell.innerHTML = users[i].name
            descriptionCell.innerHTML = users[i].description
            linkOnWebsiteCell.innerHTML = users[i].linkOnWebsite
            phoneNumberCell.innerHTML = users[i].phoneNumber
            deliveryYearCell.innerHTML = users[i].deliveryYear
            statusCell.innerHTML = users[i].status
            deleteCell.appendChild(button)
        }
    })
}

///////////////////////////////////////////////////////////////////////////////////////////

function getRealtyFilter() {
    let div = document.getElementById('filter')
    div.innerHTML = ''

    let flatOrHouseLabel = document.createElement('label')
    flatOrHouseLabel.innerHTML = 'flatOrHouse'
    let flatOrHouseSelect = document.createElement('select')
    flatOrHouseSelect.id = 'flatOrHouse'
    let flatOption = document.createElement('option')
    flatOption.value = 'FLAT'
    flatOption.text = 'FLAT'
    flatOrHouseSelect.add(flatOption)
    let houseOption = document.createElement('option')
    houseOption.value = 'HOUSE'
    houseOption.text = 'HOUSE'
    flatOrHouseSelect.add(houseOption)
    flatOrHouseLabel.appendChild(flatOrHouseSelect)
    div.appendChild(flatOrHouseLabel)


    let statusLabel = document.createElement('label')
    statusLabel.innerHTML = 'realtyStatus'
    let statusSelect = document.createElement('select')
    statusSelect.id = 'realtyStatus'
    let registeredOption = document.createElement('option')
    registeredOption.value = 'REGISTERED'
    registeredOption.text = 'REGISTERED'
    statusSelect.add(registeredOption)
    let verifiedOption = document.createElement('option')
    verifiedOption.value = 'VERIFIED'
    verifiedOption.text = 'VERIFIED'
    statusSelect.add(verifiedOption)
    let deleteOption = document.createElement('option')
    deleteOption.value = 'DELETE'
    deleteOption.text = 'DELETE'
    statusSelect.add(deleteOption)
    statusLabel.appendChild(statusSelect)
    div.appendChild(statusLabel)

    let realtyTypeLabel = document.createElement('label')
    realtyTypeLabel.innerHTML = 'realtyType'
    let realtyTypeSelect = document.createElement('select');
    realtyTypeSelect.id = 'realtyType'
    realtyTypeSelect.name = 'realtyType'
    realtyTypeSelect.type = 'text'
    let newOption = document.createElement('option')
    newOption.text = 'NEW'
    newOption.value = 'NEW'
    realtyTypeSelect.add(newOption)
    let secondaryOption = document.createElement('option')
    secondaryOption.text = 'SECONDARY'
    secondaryOption.value = 'SECONDARY'
    realtyTypeSelect.add(secondaryOption)
    realtyTypeLabel.appendChild(realtyTypeSelect)
    div.appendChild(realtyTypeLabel)

    let advertTypeLabel = document.createElement('label')
    advertTypeLabel.innerHTML = 'advertType'
    let advertTypeSelect = document.createElement('select');
    advertTypeSelect.id = 'advertType'
    advertTypeSelect.name = 'advertType'
    advertTypeSelect.type = 'text'
    let permanentOption = document.createElement('option')
    permanentOption.text = 'PERMANENT'
    permanentOption.value = 'PERMANENT'
    advertTypeSelect.add(permanentOption)
    let monthOption = document.createElement('option')
    monthOption.text = 'MONTH'
    monthOption.value = 'MONTH'
    advertTypeSelect.add(monthOption)
    let dayOption = document.createElement('option')
    dayOption.text = 'DAY'
    dayOption.value = 'DAY'
    advertTypeSelect.add(dayOption)
    let yearOption = document.createElement('option')
    yearOption.text = 'YEAR'
    yearOption.value = 'YEAR'
    advertTypeSelect.add(yearOption)
    advertTypeLabel.appendChild(advertTypeSelect)
    div.appendChild(advertTypeLabel)

    let squareFromLabel = document.createElement('label')
    squareFromLabel.innerHTML = 'squareFrom'
    let squareFromInput = document.createElement('input');
    squareFromInput.id = 'squareFrom'
    squareFromInput.name = 'squareFrom'
    squareFromInput.type = 'text'
    squareFromLabel.appendChild(squareFromInput)
    div.appendChild(squareFromLabel)

    let squareToLabel = document.createElement('label')
    squareToLabel.innerHTML = 'squareTo'
    let squareToInput = document.createElement('input');
    squareToInput.id = 'squareTo'
    squareToInput.name = 'squareTo'
    squareToInput.type = 'text'
    squareToLabel.appendChild(squareToInput)
    div.appendChild(squareToLabel)


    let costFromLabel = document.createElement('label')
    costFromLabel.innerHTML = 'costFrom'
    let costFromInput = document.createElement('input');
    costFromInput.id = 'costFrom'
    costFromInput.name = 'costFrom'
    costFromInput.type = 'text'
    costFromLabel.appendChild(costFromInput)
    div.appendChild(costFromLabel)


    let costToLabel = document.createElement('label')
    costToLabel.innerHTML = 'costTo'
    let costToInput = document.createElement('input');
    costToInput.id = 'costTo'
    costToInput.name = 'costTo'
    costToInput.type = 'text'
    costToLabel.appendChild(costToInput)
    div.appendChild(costToLabel)


    let button = document.createElement('button');
    button.textContent = 'search'
    button.addEventListener('click', () => {
        getRealtys(
            document.getElementById('flatOrHouse').value,
            document.getElementById('realtyStatus').value,
            document.getElementById('realtyType').value,
            document.getElementById('advertType').value,
            document.getElementById('squareFrom').value,
            document.getElementById('squareTo').value,
            document.getElementById('costFrom').value,
            document.getElementById('costTo').value
        )
    })
    div.appendChild(button)

    let flatOrHouseSearchLabel = document.createElement('label')
    flatOrHouseSearchLabel.innerHTML = 'field'
    let flatOrHouseSelectForSearch = document.createElement('select')
    flatOrHouseSelectForSearch.id = 'selectFlatOrHouse'
    let flatOptionForSearch = document.createElement('option')
    flatOptionForSearch.id = 'FLAT'
    flatOptionForSearch.text = 'FLAT'
    flatOrHouseSelectForSearch.add(flatOptionForSearch)
    let houseOptionForSearch = document.createElement('option')
    houseOptionForSearch.id = 'HOUSE'
    houseOptionForSearch.text = 'HOUSE'
    flatOrHouseSelectForSearch.add(houseOptionForSearch)
    flatOrHouseSearchLabel.appendChild(flatOrHouseSelectForSearch)
    div.appendChild(flatOrHouseSearchLabel)

    let fieldLabel = document.createElement('label')
    fieldLabel.innerHTML = 'field'
    let fieldSelect = document.createElement('select')
    fieldSelect.id = 'select'
    let addressOption = document.createElement('option')
    addressOption.id = 'address'
    addressOption.text = 'id'
    fieldSelect.add(addressOption)
    let residentialComplexOption = document.createElement('option')
    residentialComplexOption.id = 'residentialComplex'
    residentialComplexOption.text = 'residentialComplex'
    fieldSelect.add(residentialComplexOption)
    fieldLabel.appendChild(fieldSelect)
    div.appendChild(fieldLabel)

    let valueLabel = document.createElement('label')
    valueLabel.innerHTML = 'value'
    let valueInput = document.createElement('input')
    valueInput.id = 'value'
    valueInput.name = 'value'
    valueInput.type = 'text'
    valueLabel.appendChild(valueInput)
    let buttonForCertain = document.createElement('button')
    buttonForCertain.textContent = 'search'
    buttonForCertain.addEventListener('click', () => {
        findRealty(document.getElementById('selectFlatOrHouse').value,
            document.getElementById('select').value,
            document.getElementById('value').value)
    })
    div.appendChild(valueLabel)
    div.appendChild(buttonForCertain)
}


function getRealtys(flatOrHouse, realtyStatus, realtyType, advertType, squareFrom, squareTo, costFrom, costTo) {
    var url;
    if (flatOrHouse === 'HOUSE') {
        url = '/admin/houses?realtyStatus=' + realtyStatus + '&realtyType=' + realtyType + '&advertType=' + advertType + '&squareFrom=' + squareFrom + '&squareTo=' + squareTo + '&costFrom=' + costFrom + '&costTo=' + costTo
    } else {
        url = '/admin/flats?realtyStatus=' + realtyStatus + '&realtyType=' + realtyType + '&advertType=' + advertType + '&squareFrom=' + squareFrom + '&squareTo=' + squareTo + '&costFrom=' + costFrom + '&costTo=' + costTo
    }
    fetch(url, {
        method: 'get',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        let table = document.getElementById('info')

        table.innerHTML = ''

        if (flatOrHouse === 'HOUSE') {
            table.innerHTML = '    <tr>\n' +
                '        <th>id</th>\n' +
                '        <th>residentialComplex</th>\n' +
                '        <th>owner</th>\n' +
                '        <th>square</th>\n' +
                '        <th>regions</th>\n' +
                '        <th>district</th>\n' +
                '        <th>address</th>\n' +
                '        <th>description</th>\n' +
                '        <th>advertType</th>\n' +
                '        <th>cost</th>\n' +
                '        <th>flatOrHouse</th>\n' +
                '        <th>status</th>\n' +
                '        <th>releaseDate</th>\n' +
                '        <th>areaSquare</th>\n' +
                '        <th>material</th>\n' +
                '        <th>levels</th>\n' +
                '        <th>delete</th>\n' +
                '    </tr>';

            for (let i = 0; i < users.length; i++) {
                let row = table.insertRow(-1)
                let idCell = row.insertCell(0)
                let residentialComplexCell = row.insertCell(1)
                let ownerCell = row.insertCell(2)
                let squareCell = row.insertCell(3)
                let regionsCell = row.insertCell(4)
                let districtCell = row.insertCell(5)
                let addressCell = row.insertCell(6)
                let descriptionCell = row.insertCell(7)
                let advertTypeCell = row.insertCell(8)
                let costCell = row.insertCell(9)
                let flatOrHouseCell = row.insertCell(10)
                let statusCell = row.insertCell(11)
                let releaseDateCell = row.insertCell(12)
                let areaSquareCell = row.insertCell(13)
                let materialCell = row.insertCell(14)
                let levelsCell = row.insertCell(15)
                let deleteCell = row.insertCell(16)

                let button = document.createElement('button')

                button.addEventListener('click', () => {
                    deleteHouse(users[i].id)
                })
                button.textContent = 'delete'

                idCell.innerHTML = users[i].id
                idCell.id = 'cellForDelete' + users[i].id
                residentialComplexCell.innerHTML = users[i].residentialComplex.name
                ownerCell.innerHTML = users[i].owner.id
                squareCell.innerHTML = users[i].square
                regionsCell.innerHTML = users[i].regions
                districtCell.innerHTML = users[i].district
                addressCell.innerHTML = users[i].address
                descriptionCell.innerHTML = users[i].description
                advertTypeCell.innerHTML = users[i].advertType
                costCell.innerHTML = users[i].cost
                flatOrHouseCell.innerHTML = users[i].flatOrHouse
                releaseDateCell.innerHTML = users[i].releaseDate
                statusCell.innerHTML = users[i].status
                areaSquareCell.innerHTML = users[i].areaSquare
                materialCell.innerHTML = users[i].material
                levelsCell.innerHTML = users[i].levels
                deleteCell.appendChild(button)
            }
        } else {
            table.innerHTML = '    <tr>\n' +
                '        <th>id</th>\n' +
                '        <th>residentialComplex</th>\n' +
                '        <th>owner</th>\n' +
                '        <th>square</th>\n' +
                '        <th>regions</th>\n' +
                '        <th>district</th>\n' +
                '        <th>address</th>\n' +
                '        <th>description</th>\n' +
                '        <th>advertType</th>\n' +
                '        <th>cost</th>\n' +
                '        <th>flatOrHouse</th>\n' +
                '        <th>releaseDate</th>\n' +
                '        <th>status</th>\n' +
                '        <th>numberOfRooms</th>\n' +
                '        <th>level</th>\n' +
                '        <th>kitchenSquare</th>\n' +
                '        <th>livingSquare</th>\n' +
                '        <th>realtyType</th>\n' +
                '    </tr>';

            for (let i = 0; i < users.length; i++) {
                let row = table.insertRow(-1)
                let idCell = row.insertCell(0)
                let residentialComplexCell = row.insertCell(1)
                let ownerCell = row.insertCell(2)
                let squareCell = row.insertCell(3)
                let regionsCell = row.insertCell(4)
                let districtCell = row.insertCell(5)
                let addressCell = row.insertCell(6)
                let descriptionCell = row.insertCell(7)
                let advertTypeCell = row.insertCell(8)
                let costCell = row.insertCell(9)
                let flatOrHouseCell = row.insertCell(10)
                let releaseDateCell = row.insertCell(11)
                let statusCell = row.insertCell(12)
                let numberOfRoomsCell = row.insertCell(13)
                let levelCell = row.insertCell(14)
                let kitchenSquareCell = row.insertCell(15)
                let livingSquareCell = row.insertCell(16)
                let realtyTypeCell = row.insertCell(17)
                let deleteCell = row.insertCell(18)

                let button = document.createElement('button')

                button.addEventListener('click', () => {
                    deleteFlat(users[i].id)
                })
                button.textContent = 'delete'

                idCell.innerHTML = users[i].id
                idCell.id = 'cellForDelete' + users[i].id
                residentialComplexCell.innerHTML = users[i].residentialComplex.name
                ownerCell.innerHTML = users[i].owner.id
                squareCell.innerHTML = users[i].square
                regionsCell.innerHTML = users[i].regions
                districtCell.innerHTML = users[i].district
                addressCell.innerHTML = users[i].address
                descriptionCell.innerHTML = users[i].description
                advertTypeCell.innerHTML = users[i].advertType
                costCell.innerHTML = users[i].cost
                flatOrHouseCell.innerHTML = users[i].flatOrHouse
                releaseDateCell.innerHTML = users[i].releaseDate
                statusCell.innerHTML = users[i].status
                numberOfRoomsCell.innerHTML = users[i].numberOfRooms
                levelCell.innerHTML = users[i].level
                kitchenSquareCell.innerHTML = users[i].kitchenSquare
                livingSquareCell.innerHTML = users[i].livingSquare
                realtyTypeCell.innerHTML = users[i].realtyType
                deleteCell.appendChild(button)
            }
        }

    })
}


function deleteHouse(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/admin/deleteHouse?id=' + id, {
        method: 'DELETE',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: params
    })
}

function deleteFlat(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/admin/deleteFlat?id=' + id, {
        method: 'DELETE',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: params
    })
}


function findRealty(flatOrHouse, field, value) {
    if (flatOrHouse === 'HOUSE') {
        fetch('/admin/certainHouse?field=address&value=' + value, {
            method: 'GET',
            headers: {
                'AUTHORIZATION': localStorage.getItem('accessToken')
            }
        }).then((response) => {
            return response.json()
        }).then((users) => {
            let table = document.getElementById('info')

            table.innerHTML = '    <tr>\n' +
                '        <th>id</th>\n' +
                '        <th>residentialComplex</th>\n' +
                '        <th>owner</th>\n' +
                '        <th>square</th>\n' +
                '        <th>regions</th>\n' +
                '        <th>district</th>\n' +
                '        <th>address</th>\n' +
                '        <th>description</th>\n' +
                '        <th>advertType</th>\n' +
                '        <th>cost</th>\n' +
                '        <th>flatOrHouse</th>\n' +
                '        <th>status</th>\n' +
                '        <th>releaseDate</th>\n' +
                '        <th>areaSquare</th>\n' +
                '        <th>material</th>\n' +
                '        <th>levels</th>\n' +
                '        <th>delete</th>\n' +
                '    </tr>';

            for (let i = 0; i < users.length; i++) {
                let row = table.insertRow(-1)
                let idCell = row.insertCell(0)
                let residentialComplexCell = row.insertCell(1)
                let ownerCell = row.insertCell(2)
                let squareCell = row.insertCell(3)
                let regionsCell = row.insertCell(4)
                let districtCell = row.insertCell(5)
                let addressCell = row.insertCell(6)
                let descriptionCell = row.insertCell(7)
                let advertTypeCell = row.insertCell(8)
                let costCell = row.insertCell(9)
                let flatOrHouseCell = row.insertCell(10)
                let statusCell = row.insertCell(11)
                let releaseDateCell = row.insertCell(12)
                let areaSquareCell = row.insertCell(13)
                let materialCell = row.insertCell(14)
                let levelsCell = row.insertCell(15)
                let deleteCell = row.insertCell(16)

                let button = document.createElement('button')

                button.addEventListener('click', () => {
                    deleteHouse(users[i].id)
                })
                button.textContent = 'delete'

                idCell.innerHTML = users[i].id
                idCell.id = 'cellForDelete' + users[i].id
                residentialComplexCell.innerHTML = users[i].residentialComplex.name
                ownerCell.innerHTML = users[i].owner.id
                squareCell.innerHTML = users[i].square
                regionsCell.innerHTML = users[i].regions
                districtCell.innerHTML = users[i].district
                addressCell.innerHTML = users[i].address
                descriptionCell.innerHTML = users[i].description
                advertTypeCell.innerHTML = users[i].advertType
                costCell.innerHTML = users[i].cost
                flatOrHouseCell.innerHTML = users[i].flatOrHouse
                releaseDateCell.innerHTML = users[i].releaseDate
                statusCell.innerHTML = users[i].status
                areaSquareCell.innerHTML = users[i].areaSquare
                materialCell.innerHTML = users[i].material
                levelsCell.innerHTML = users[i].levels
                deleteCell.appendChild(button)
            }
        })
    } else {
        fetch('/admin/certainFlat?field=' + field + '&value=' + value, {
            method: 'GET',
            headers: {
                'AUTHORIZATION': localStorage.getItem('accessToken')
            }
        }).then((response) => {
            return response.json()
        }).then((users) => {
            let table = document.getElementById('info')

            table.innerHTML = '    <tr>\n' +
                '        <th>id</th>\n' +
                '        <th>residentialComplex</th>\n' +
                '        <th>owner</th>\n' +
                '        <th>square</th>\n' +
                '        <th>regions</th>\n' +
                '        <th>district</th>\n' +
                '        <th>address</th>\n' +
                '        <th>description</th>\n' +
                '        <th>advertType</th>\n' +
                '        <th>cost</th>\n' +
                '        <th>flatOrHouse</th>\n' +
                '        <th>releaseDate</th>\n' +
                '        <th>status</th>\n' +
                '        <th>numberOfRooms</th>\n' +
                '        <th>level</th>\n' +
                '        <th>kitchenSquare</th>\n' +
                '        <th>livingSquare</th>\n' +
                '        <th>realtyType</th>\n' +
                '    </tr>';

            for (let i = 0; i < users.length; i++) {
                let row = table.insertRow(-1)
                let idCell = row.insertCell(0)
                let residentialComplexCell = row.insertCell(1)
                let ownerCell = row.insertCell(2)
                let squareCell = row.insertCell(3)
                let regionsCell = row.insertCell(4)
                let districtCell = row.insertCell(5)
                let addressCell = row.insertCell(6)
                let descriptionCell = row.insertCell(7)
                let advertTypeCell = row.insertCell(8)
                let costCell = row.insertCell(9)
                let flatOrHouseCell = row.insertCell(10)
                let releaseDateCell = row.insertCell(11)
                let statusCell = row.insertCell(12)
                let numberOfRoomsCell = row.insertCell(13)
                let levelCell = row.insertCell(14)
                let kitchenSquareCell = row.insertCell(15)
                let livingSquareCell = row.insertCell(16)
                let realtyTypeCell = row.insertCell(17)
                let deleteCell = row.insertCell(18)

                let button = document.createElement('button')

                button.addEventListener('click', () => {
                    deleteFlat(users[i].id)
                })
                button.textContent = 'delete'

                idCell.innerHTML = users[i].id
                idCell.id = 'cellForDelete' + users[i].id
                residentialComplexCell.innerHTML = users[i].residentialComplex.name
                ownerCell.innerHTML = users[i].owner.id
                squareCell.innerHTML = users[i].square
                regionsCell.innerHTML = users[i].regions
                districtCell.innerHTML = users[i].district
                addressCell.innerHTML = users[i].address
                descriptionCell.innerHTML = users[i].description
                advertTypeCell.innerHTML = users[i].advertType
                costCell.innerHTML = users[i].cost
                flatOrHouseCell.innerHTML = users[i].flatOrHouse
                releaseDateCell.innerHTML = users[i].releaseDate
                statusCell.innerHTML = users[i].status
                numberOfRoomsCell.innerHTML = users[i].numberOfRooms
                levelCell.innerHTML = users[i].level
                kitchenSquareCell.innerHTML = users[i].kitchenSquare
                livingSquareCell.innerHTML = users[i].livingSquare
                realtyTypeCell.innerHTML = users[i].realtyType
                deleteCell.appendChild(button)
            }
        })
    }
}