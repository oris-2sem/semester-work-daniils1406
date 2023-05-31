function getFlatPage() {
    fetch('/myFlat', {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.text()
    }).then(function (html) {
        var b = document.body
        b.innerHTML = ''
        b.innerHTML = html
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

function createFlat(residentialComplex, square, region, district, address, description, advertType, cost, releaseDate, numberOfRoom, level, kitchenSquare, livingSquare, realtyType, owner,currency) {
    if (residentialComplex === '' || square === '' || region === '' || district === '' || address === '' || description === '' ||
        advertType === '' || cost === '' || releaseDate === '' || numberOfRoom === '' || level === '' || kitchenSquare === '' ||
        livingSquare === '' || realtyType === '' || owner === '') {
        alert('Please fill all labels')
        return
    }
    const regexExp = /^[0-9a-fA-F]{8}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{12}$/gi;
    if (!regexExp.test(residentialComplex)) {
        alert('Incorrect id of Residential complex')
        return;
    }
    var body = {
        "residentialComplex": escape(residentialComplex),
        "owner": escape(owner),
        "square": escape(square),
        "regions": escape(region),
        "district": escape(district),
        "address": escape(address),
        "description": escape(description),
        "advertType": escape(advertType),
        "cost": escape(cost),
        "flatOrHouse": "FLAT",
        "releaseDate": escape(releaseDate),
        "numberOfRoom": escape(numberOfRoom),
        "level": escape(level),
        "kitchenSquare": escape(kitchenSquare),
        "livingSquare": escape(livingSquare),
        "realtyType": escape(realtyType),
        "currency": escape(currency)
    }
    fetch('/residentialComplex/byId?id=' + residentialComplex, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken'),
        }
    }).then((response) => {
        response.text().then((residential) => {
            console.log(residential)
            if (residential.includes('NOT_FOUND')) {
                alert('Residential complex with this id not exists')
            } else {
                fetch('/myFlat', {
                    method: 'POST',
                    headers: {
                        'AUTHORIZATION': localStorage.getItem('accessToken'),
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(body)
                }).then(() => {
                    getFlatPage()
                })
            }
        })
    })

}

function changeFlat(id, residentialComplex, square, region, district, address, description, advertType, cost, releaseDate, numberOfRooms, level, kitchenSquare, livingSquare, realtyType, owner,currency) {
    if (residentialComplex === '' || square === '' || region === '' || district === '' || address === '' || description === '' ||
        advertType === '' || cost === '' || releaseDate === '' || numberOfRooms === '' || level === '' || kitchenSquare === '' ||
        livingSquare === '' || realtyType === '' || owner === '' || id === '') {
        alert('Please fill all labels')
        return
    }
    var body = {
        "id": id,
        "residentialComplex": escape(residentialComplex),
        "owner": escape(owner),
        "square": escape(square),
        "regions": escape(region),
        "district": escape(district),
        "address": escape(address),
        "description": escape(description),
        "advertType": escape(advertType),
        "cost": escape(cost),
        "flatOrHouse": "FLAT",
        "releaseDate": escape(releaseDate),
        "numberOfRoom": escape(numberOfRooms),
        "level": escape(level),
        "kitchenSquare": escape(kitchenSquare),
        "livingSquare": escape(livingSquare),
        "realtyType": escape(realtyType),
        "currency": escape(currency)
    }
    fetch('/myFlat/update', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken'),
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    }).then(() => {
        getFlatPage()
    })

}

function deleteFlat(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/myFlat/delete', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken'),
        },
        body: params
    })
}

function hideFlat(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/myFlat/hide', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken'),
        },
        body: params
    })
}

function showFlat(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/myFlat/show', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken'),
        },
        body: params
    })
}

function deleteViewFlat(id) {
    fetch('/file/deleteFile?id=' + id, {
        method: 'DELETE',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    })
    getFlatPage()
}

function addViewFlat(id, entity, file, fileType) {
    var mult = new FormData()
    mult.append('id', id)
    mult.append('entity', entity)
    mult.append('file', file[0])
    mult.append('fileType', fileType)
    fetch('/file/uploadImage', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: mult
    }).then((fileId) => {
        return fileId.text()
    }).then((fileId) => {
        var params1 = new URLSearchParams('id=' + id + '&logo=' + fileId)
        fetch('/user/setAvatar', {
            method: 'POST',
            headers: {
                'AUTHORIZATION': localStorage.getItem('accessToken')
            },
            body: params1
        })
        getFlatPage()
    }).catch((e) => {
        alert(e.message)
        getFlatPage()
    })
}