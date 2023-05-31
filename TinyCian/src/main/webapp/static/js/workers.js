function getWorkersPage() {
    fetch('/workers', {
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
        var b = document.body
        b.innerHTML = ''
        b.innerHTML = html
    })
}

function dismissAgent(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/workers/dismiss', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken'),
        },
        body: params
    })

    location.reload()
}

function hireAgent(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/workers/hire', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken'),
        },
        body: params
    })

    location.reload()
}