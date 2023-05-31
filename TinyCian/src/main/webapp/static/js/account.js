function getUserPage() {
    fetch('/accountInfo', {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        if (response.status === 403) {
            alert("Sorry your session is end!")
            localStorage.removeItem('accessToken')
            location.replace("/loginPage")
            return;
        }
        return response.text()
    }).then(function (html) {
        var b = document.body
        b.innerHTML = '';
        b.innerHTML = html
    })
}

function changePassword(login, newPassword) {
    if (newPassword === '') {
        alert('Please fill all labels')
        return
    }
    var params = new URLSearchParams('login=' + login + '&newPassword=' + newPassword)
    fetch('/user/resetPassword', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: params
    })
    logout();
}


function uploadImage(id, entity, file, fileType) {

    var mult = new FormData()
    mult.append('id', id)
    mult.append('entity', entity)
    mult.append('file', file[0])
    mult.append('fileType', fileType)
    fetch('/file/uploadImage', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken'),
            accept: 'application/json',
        },
        body: mult
    }).then((fileId) => {
        return fileId.json()
    }).then((fileId) => {
        var params1 = new URLSearchParams('id=' + id + '&logo=' + fileId.fileName)
        fetch('/user/setAvatar', {
            method: 'POST',
            headers: {
                'AUTHORIZATION': localStorage.getItem('accessToken')
            },
            body: params1
        })
        location.replace('/account')
    }).catch((e) => {
        location.replace('/account')
    })
}

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

function changeUser(birthdayDate, firstName, lastName, patronymic, phone, login) {
    if (firstName === '' || lastName === '' || patronymic === '' || phone === '' || login === '' || birthdayDate === '') {
        alert('Please fill all labels')
        return
    }

    let body = {
        "id": "",
        "birthdayDate": escape(birthdayDate),
        "firstName": escape(firstName),
        "lastName": escape(lastName),
        "patronymic": escape(patronymic),
        "phone": escape(phone),
        "login": escape(login)
    }

    fetch('/user', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken'),
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    }).then((response) => {
        response.text().then((promise) => {
            if (promise === 'true') {
                logout()
                location.replace('/loginPage?value=This login already in use')
            } else {
                logout()
                location.replace('/loginPage?value=You were successfully changed')
            }
        })
    })
}