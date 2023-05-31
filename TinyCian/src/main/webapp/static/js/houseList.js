function getHousePage() {
    fetch('/myHouse', {
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

function createHouse(residentialComplex, square, region, district, address, description, advertType, cost, releaseDate, areaSquare, material, levels, owner,currency) {
    if (residentialComplex === '' || square === '' || region === '' || district === '' || address === '' || description === '' ||
        advertType === '' || cost === '' || releaseDate === '' || areaSquare === '' || material === '' || levels === '' ||
        owner === '') {
        alert('Please fill all labels')
        return
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
        "flatOrHouse": "HOUSE",
        "releaseDate": escape(releaseDate),
        "areaSquare": escape(areaSquare),
        "material": escape(material),
        "levels": escape(levels),
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
                fetch('/myHouse', {
                    method: 'POST',
                    headers: {
                        'AUTHORIZATION': localStorage.getItem('accessToken'),
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(body)
                }).then(() => {
                    getHousePage()
                })
            }
        })
    })
    // fetch('/myHouse', {
    //     method: 'POST',
    //     headers: {
    //         'AUTHORIZATION': localStorage.getItem('accessToken'),
    //         "Content-Type": "application/json"
    //     },
    //     body: JSON.stringify(body)
    // }).then(() => {
    //     getHousePage()
    // })
}

function deleteViewHouse(id) {
    fetch('/file/deleteFile?id=' + id, {
        method: 'DELETE',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    })
    getHousePage()
}

function addViewHouse(id, entity, file, fileType) {
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
        getHousePage()
    }).catch((e) => {
        alert(e.message)
        getHousePage()
    })
    // getHousePage()
}

function changeHouse(id, residentialComplex, square, region, district, address, description, advertType, cost, releaseDate, areaSquare, material, levels, owner,currency) {
    if (residentialComplex === '' || square === '' || region === '' || district === '' || address === '' || description === '' ||
        advertType === '' || cost === '' || releaseDate === '' || areaSquare === '' || material === '' || levels === '' ||
        owner === '' || id === '') {
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
        "flatOrHouse": "HOUSE",
        "releaseDate": escape(releaseDate),
        "areaSquare": escape(areaSquare),
        "material": escape(material),
        "levels": escape(levels),
        "currency": escape(currency)
    }
    fetch('/myHouse/update', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken'),
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    }).then(() => {
        getHousePage();
    })
}

function deleteHouse(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/myHouse/delete', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: params
    })
    getHousePage()
}

function hideHouse(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/myHouse/hide', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: params
    })
}

function showHouse(id) {
    var params = new URLSearchParams('id=' + id)
    fetch('/myHouse/show', {
        method: 'POST',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        },
        body: params
    })
}