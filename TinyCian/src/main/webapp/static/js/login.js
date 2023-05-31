function login() {
    let login = document.getElementById('login').value
    let password = document.getElementById('password').value
    var params = new URLSearchParams('login=' + login + '&password=' + password)
    fetch('/login', {
        method: 'POST',
        body: params
    }).then((response) => {
        console.log(response)
        if (response.status === 403 || response.status === 401) {
            alert("Wrong password or email")
            location.replace('/loginPage?value=Wrong password or email')
            return;
        }
        return response.json()
    }).then((tokens) => {
        if (tokens.accessToken !== null && tokens.accessToken !== '' && tokens.accessToken !== undefined) {
            localStorage.setItem('accessToken', tokens.accessToken)
            window.location.href = '/account'
        }
        // else {
        //     window.location.href = '/loginPage?value=Wrong password or email'
        // }
    })
}

function alreadyLogIn() {
    if (localStorage.getItem('accessToken') != null) {
        window.location.replace('/account')
    }
}
