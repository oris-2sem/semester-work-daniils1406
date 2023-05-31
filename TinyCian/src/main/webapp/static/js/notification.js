function createNotification(ownerId, realtyId) {
    if (localStorage.getItem('accessToken') == null) {
        window.location.replace('/loginPage')
    }
    var clientId;
    fetch('/util/getId?token=' + localStorage.getItem('accessToken')).then((response) => {
        return response.json()
    }).then((response) => {
        fetch('/notification/create?clientId=' + response + '&ownerId=' + ownerId + '&realtyId=' + realtyId, {
            method: 'GET',
            headers: {
                'AUTHORIZATION': localStorage.getItem('accessToken')
            }
        })
    })
}


function showDeleteNotification(id) {
    fetch('/notification/notificationList?id=' + id, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json();
    }).then((notifications) => {
        fillNotificationList(notifications)
    })
}

function fillNotificationList(notifications) {
    let list = document.getElementById("archive")
    list.innerHTML = ''
    for (let i = 0; i < notifications.length; i++) {
        let li = document.createElement('li')
        let a = document.createElement('a')
        a.href = '/user?id=' + notifications[i].client
        a.textContent = 'User with id ' + notifications[i].client + ' interested in realty with id ' + notifications[i].realty
        let text = 'User with id <a href="/user?id=' + notifications[i].client + '">' + notifications[i].client + '</a> interested in realty ' + notifications[i].realty
        li.appendChild(a)
        list.appendChild(li)
    }
}


function deleteNotification(id) {
    fetch('/notification/delete?id=' + id, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    })
}

function findOutRealtyType(id) {
    fetch('/util/findOutRealty?id=' + id, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.text()
    })
}