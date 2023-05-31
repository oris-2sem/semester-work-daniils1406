function escape(string) {
    var htmlEscapes = {
        '&': 'Безопасный аналог амперсанд',
        '<': 'Безопасный аналог <',
        '>': 'Безопасный аналог >',
        '"': 'Безопасный аналог "',
        "'": "Безопасный аналог '"
    };

    return string.replace(/[&<>"']/g, function(match) {
        return htmlEscapes[match];
    });
};

function clientForm() {
    let div = document.getElementById("registrationForm")
    div.className = 'container'
    div.innerHTML = '';


    let div1 = document.createElement('div')
    div1.className = 'row mb-3'


    let firstNameLabel = document.createElement('label')
    firstNameLabel.innerHTML = 'firstName'
    let firstNameInput = document.createElement('input');
    firstNameInput.id = 'firstName'
    firstNameInput.name = 'firstName'
    firstNameInput.type = 'text'
    firstNameLabel.appendChild(firstNameInput)
    div1.appendChild(firstNameLabel)
    div.appendChild(div1)

    let div2 = document.createElement('div')
    div2.className = 'row mb-3'

    let lastNameLabel = document.createElement('label')
    lastNameLabel.innerHTML = 'lastName'
    let lastNameInput = document.createElement('input');
    lastNameInput.id = 'lastName'
    lastNameInput.name = 'lastName'
    lastNameInput.type = 'text'
    lastNameLabel.appendChild(lastNameInput)
    div2.appendChild(lastNameLabel)
    div.appendChild(div2)

    let div3 = document.createElement('div')
    div3.className = 'row mb-3'


    let patronymicLabel = document.createElement('label')
    patronymicLabel.innerHTML = 'patronymic'
    let patronymicInput = document.createElement('input');
    patronymicInput.id = 'patronymic'
    patronymicInput.name = 'patronymic'
    patronymicInput.type = 'text'
    patronymicLabel.appendChild(patronymicInput)
    div3.appendChild(patronymicLabel)
    div.appendChild(div3)


    let div4 = document.createElement('div')
    div4.className = 'row mb-3'

    let phoneLabel = document.createElement('label')
    phoneLabel.innerHTML = 'phone'
    let phoneInput = document.createElement('input');
    phoneInput.id = 'phone'
    phoneInput.name = 'phone'
    phoneInput.type = 'text'
    phoneLabel.appendChild(phoneInput)
    div4.appendChild(phoneLabel)
    div.appendChild(div4)


    let div5 = document.createElement('div')
    div5.className = 'row mb-3'

    let loginLabel = document.createElement('label')
    loginLabel.innerHTML = 'login'
    let loginInput = document.createElement('input');
    loginInput.id = 'login'
    loginInput.name = 'login'
    loginInput.type = 'text'
    loginLabel.appendChild(loginInput)
    div5.appendChild(loginLabel)
    div.appendChild(div5)


    let div6 = document.createElement('div')
    div6.className = 'row mb-3'

    let passwordLabel = document.createElement('label')
    passwordLabel.innerHTML = 'password'
    let passwordInput = document.createElement('input');
    passwordInput.id = 'password'
    passwordInput.name = 'password'
    passwordInput.type = 'text'
    passwordLabel.appendChild(passwordInput)
    div6.appendChild(passwordLabel)
    div.appendChild(div6)


    let div7 = document.createElement('div')
    div7.className = 'row mb-3'

    let birthdayDateLabel = document.createElement('label')
    birthdayDateLabel.innerHTML = 'birthdayDate'
    let birthdayDateInput = document.createElement('input');
    birthdayDateInput.id = 'birthdayDate'
    birthdayDateInput.name = 'birthdayDate'
    birthdayDateInput.type = 'date'
    birthdayDateLabel.appendChild(birthdayDateInput)
    div7.appendChild(birthdayDateLabel)
    div.appendChild(div7)


    let button = document.createElement('button')
    button.innerHTML = 'registration'
    button.addEventListener('click', () => createUser(document.getElementById("firstName").value,
        document.getElementById("lastName").value,
        document.getElementById("patronymic").value,
        document.getElementById("phone").value,
        document.getElementById("login").value,
        document.getElementById("password").value,
        document.getElementById("birthdayDate").value))
    div.appendChild(button)

}

function createUser(firstName, lastName, patronymic, phone, login, password, birthdayDate) {
    if (firstName === '' || lastName === '' || patronymic === '' || phone === '' || login === '' || password === '' || birthdayDate === '') {
        alert('Please fill all labels')
        return
    }
    let body = {
        "firstName": escape(firstName),
        "lastName": escape(lastName),
        "patronymic": escape(patronymic),
        "phone": escape(phone),
        "login": escape(login),
        "password": escape(password),
        "birthdayDate": escape(birthdayDate),
        "role": "CLIENT",
        "userType": "CLIENT"
    };

    fetch("/signin/user", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    }).then((response) => {
        response.text().then((promise) => {
            if (promise === 'true') {
                location.replace('/loginPage?value=This login already in use')
            } else {
                location.replace('/loginPage?value=You were successfully reggistered')
            }
        })
    })
}

function agentForm() {
    let div = document.getElementById("registrationForm")
    div.innerHTML = '';


    let div1 = document.createElement('div')
    div1.className = 'row mb-3'

    let firstNameLabel = document.createElement('label')
    firstNameLabel.innerHTML = 'firstName'
    let firstNameInput = document.createElement('input');
    firstNameInput.id = 'firstName'
    firstNameInput.name = 'firstName'
    firstNameInput.type = 'text'
    firstNameLabel.appendChild(firstNameInput)
    div1.appendChild(firstNameLabel)
    div.appendChild(div1)


    let div2 = document.createElement('div')
    div2.className = 'row mb-3'

    let lastNameLabel = document.createElement('label')
    lastNameLabel.innerHTML = 'lastName'
    let lastNameInput = document.createElement('input');
    lastNameInput.id = 'lastName'
    lastNameInput.name = 'lastName'
    lastNameInput.type = 'text'
    lastNameLabel.appendChild(lastNameInput)
    div2.appendChild(lastNameLabel)
    div.appendChild(div2)


    let div3 = document.createElement('div')
    div3.className = 'row mb-3'

    let patronymicLabel = document.createElement('label')
    patronymicLabel.innerHTML = 'patronymic'
    let patronymicInput = document.createElement('input');
    patronymicInput.id = 'patronymic'
    patronymicInput.name = 'patronymic'
    patronymicInput.type = 'text'
    patronymicLabel.appendChild(patronymicInput)
    div3.appendChild(patronymicLabel)
    div.appendChild(div3)


    let div4 = document.createElement('div')
    div4.className = 'row mb-3'

    let phoneLabel = document.createElement('label')
    phoneLabel.innerHTML = 'phone'
    let phoneInput = document.createElement('input');
    phoneInput.id = 'phone'
    phoneInput.name = 'phone'
    phoneInput.type = 'text'
    phoneLabel.appendChild(phoneInput)
    div4.appendChild(phoneLabel)
    div.appendChild(div4)


    let div5 = document.createElement('div')
    div5.className = 'row mb-3'

    let loginLabel = document.createElement('label')
    loginLabel.innerHTML = 'login'
    let loginInput = document.createElement('input');
    loginInput.id = 'login'
    loginInput.name = 'login'
    loginInput.type = 'text'
    loginLabel.appendChild(loginInput)
    div5.appendChild(loginLabel)
    div.appendChild(div5)


    let div6 = document.createElement('div')
    div6.className = 'row mb-3'

    let passwordLabel = document.createElement('label')
    passwordLabel.innerHTML = 'password'
    let passwordInput = document.createElement('input');
    passwordInput.id = 'password'
    passwordInput.name = 'password'
    passwordInput.type = 'text'
    passwordLabel.appendChild(passwordInput)
    div6.appendChild(passwordLabel)
    div.appendChild(div6)


    let div7 = document.createElement('div')
    div7.className = 'row mb-3'

    let birthdayDateLabel = document.createElement('label')
    birthdayDateLabel.innerHTML = 'birthdayDate'
    let birthdayDateInput = document.createElement('input');
    birthdayDateInput.id = 'birthdayDate'
    birthdayDateInput.name = 'birthdayDate'
    birthdayDateInput.type = 'date'
    birthdayDateLabel.appendChild(birthdayDateInput)
    div7.appendChild(birthdayDateLabel)
    div.appendChild(div7)


    let div8 = document.createElement('div')
    div8.className = 'row mb-3'

    let organisationLabel = document.createElement('label')
    organisationLabel.innerHTML = 'organisation'
    let organisationInput = document.createElement('input');
    organisationInput.id = 'organisation'
    organisationInput.name = 'organisation'
    organisationInput.type = 'text'
    organisationLabel.appendChild(organisationInput)
    div8.appendChild(organisationLabel)
    div.appendChild(div8)

    let button = document.createElement('button')
    button.innerHTML = 'registration'
    button.addEventListener('click', () => createAgent(document.getElementById("firstName").value,
        document.getElementById("lastName").value,
        document.getElementById("patronymic").value,
        document.getElementById("phone").value,
        document.getElementById("login").value,
        document.getElementById("password").value,
        document.getElementById("birthdayDate").value,
        document.getElementById("organisation").value))

    div.appendChild(button)


}


function createAgent(firstName, lastName, patronymic, phone, login, password, birthdayDate, organisation) {
    if (firstName === '' || lastName === '' || patronymic === '' || phone === '' || login === '' || password === '' || birthdayDate === '') {
        alert('Please fill all labels')
        return
    }
    let body = {
        "firstName": escape(firstName),
        "lastName": escape(lastName),
        "patronymic": escape(patronymic),
        "phone": escape(phone),
        "login": escape(login),
        "password": escape(password),
        "birthdayDate": escape(birthdayDate),
        "role": "AGENT",
        "userType": "CLIENT",
        "organisation": escape(organisation)
    };

    fetch("/signin/agent", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    }).then((response) => {
        response.text().then((promise) => {
            if (promise === 'true') {
                location.replace('/loginPage?value=This login already in use')
            } else {
                location.replace('/loginPage?value=You were successfully reggistered')
            }
        })
    })
}


function representativeForm() {
    let div = document.getElementById("registrationForm")
    div.innerHTML = ''

    let div1 = document.createElement('div')
    div1.className = 'row mb-3'

    let firstNameLabel = document.createElement('label')
    firstNameLabel.innerHTML = 'firstName'
    let firstNameInput = document.createElement('input');
    firstNameInput.id = 'firstName'
    firstNameInput.name = 'firstName'
    firstNameInput.type = 'text'
    firstNameLabel.appendChild(firstNameInput)
    div1.appendChild(firstNameLabel)
    div.appendChild(div1)

    let div2 = document.createElement('div')
    div2.className = 'row mb-3'

    let lastNameLabel = document.createElement('label')
    lastNameLabel.innerHTML = 'lastName'
    let lastNameInput = document.createElement('input');
    lastNameInput.id = 'lastName'
    lastNameInput.name = 'lastName'
    lastNameInput.type = 'text'
    lastNameLabel.appendChild(lastNameInput)
    div2.appendChild(lastNameLabel)
    div.appendChild(div2)

    let div3 = document.createElement('div')
    div3.className = 'row mb-3'

    let patronymicLabel = document.createElement('label')
    patronymicLabel.innerHTML = 'patronymic'
    let patronymicInput = document.createElement('input');
    patronymicInput.id = 'patronymic'
    patronymicInput.name = 'patronymic'
    patronymicInput.type = 'text'
    patronymicLabel.appendChild(patronymicInput)
    div3.appendChild(patronymicLabel)
    div.appendChild(div3)

    let div4 = document.createElement('div')
    div4.className = 'row mb-3'

    let phoneLabel = document.createElement('label')
    phoneLabel.innerHTML = 'phone'
    let phoneInput = document.createElement('input');
    phoneInput.id = 'phone'
    phoneInput.name = 'phone'
    phoneInput.type = 'text'
    phoneLabel.appendChild(phoneInput)
    div4.appendChild(phoneLabel)
    div.appendChild(div4)

    let div5 = document.createElement('div')
    div5.className = 'row mb-3'

    let loginLabel = document.createElement('label')
    loginLabel.innerHTML = 'login'
    let loginInput = document.createElement('input');
    loginInput.id = 'login'
    loginInput.name = 'login'
    loginInput.type = 'text'
    loginLabel.appendChild(loginInput)
    div5.appendChild(loginLabel)
    div.appendChild(div5)

    let div6 = document.createElement('div')
    div6.className = 'row mb-3'

    let passwordLabel = document.createElement('label')
    passwordLabel.innerHTML = 'password'
    let passwordInput = document.createElement('input');
    passwordInput.id = 'password'
    passwordInput.name = 'password'
    passwordInput.type = 'text'
    passwordLabel.appendChild(passwordInput)
    div6.appendChild(passwordLabel)
    div.appendChild(div6)

    let div7 = document.createElement('div')
    div7.className = 'row mb-3'

    let birthdayDateLabel = document.createElement('label')
    birthdayDateLabel.innerHTML = 'birthdayDate'
    let birthdayDateInput = document.createElement('input');
    birthdayDateInput.id = 'birthdayDate'
    birthdayDateInput.name = 'birthdayDate'
    birthdayDateInput.type = 'date'
    birthdayDateLabel.appendChild(birthdayDateInput)
    div7.appendChild(birthdayDateLabel)
    div.appendChild(div7)

    let div8 = document.createElement('div')
    div8.className = 'row mb-3'

    let organisationLabel = document.createElement('label')
    organisationLabel.innerHTML = 'organisation'
    let organisationInput = document.createElement('input');
    organisationInput.id = 'organisation'
    organisationInput.name = 'organisation'
    organisationInput.type = 'text'
    organisationLabel.appendChild(organisationInput)
    div8.appendChild(organisationLabel)
    div.appendChild(div8)


    let button = document.createElement('button')
    button.innerHTML = 'registration'
    button.addEventListener('click', () => createRepresentative(document.getElementById("firstName").value,
        document.getElementById("lastName").value,
        document.getElementById("patronymic").value,
        document.getElementById("phone").value,
        document.getElementById("login").value,
        document.getElementById("password").value,
        document.getElementById("birthdayDate").value,
        document.getElementById("organisation").value))
    div.appendChild(button)
}

function createRepresentative(firstName, lastName, patronymic, phone, login, password, birthdayDate, organisation) {
    if (firstName === '' || lastName === '' || patronymic === '' || phone === '' || login === '' || password === '' || birthdayDate === '' || organisation === '') {
        alert('Please fill all labels')
        return
    }

    const regexExp = /^[0-9a-fA-F]{8}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{12}$/gi;
    if (!regexExp.test(organisation)) {
        alert('Incorrect id of organisation')
        return;
    }

    let body = {
        "firstName": escape(firstName),
        "lastName": escape(lastName),
        "patronymic": escape(patronymic),
        "phone": escape(phone),
        "login": escape(login),
        "password": escape(password),
        "birthdayDate": escape(birthdayDate),
        "role": "REPRESENTATIVE",
        "userType": "CLIENT",
        "organisation": escape(organisation)
    };

    // fetch("/signin/representative", {
    //     method: 'POST',
    //     headers: {
    //         "Content-Type": "application/json"
    //     },
    //     body: JSON.stringify(body)
    // });

    fetch('/agency/byId?id=' + organisation
    ).then((response) => {
        response.json().then((agency) => {
            if (agency === '') {
                alert('Agency with this id not exists')
            } else {
                fetch("/signin/representative", {
                    method: 'POST',
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(body)
                }).then((response) => {
                    response.text().then((promise) => {
                        if (promise === 'true') {
                            location.replace('/loginPage?value=This login already in use')
                        } else {
                            location.replace('/loginPage?value=You were successfully reggistered')
                        }
                    })
                })
            }
        })
    })


}