function getPage() {
    fetch('/users', {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.text()
    }).then(function (html) {
        var parser = new DOMParser();

        var doc = parser.parseFromString(html, 'text/html');


        var b = document.body
        b.innerHTML = '';
        b.innerHTML = html
    })
}