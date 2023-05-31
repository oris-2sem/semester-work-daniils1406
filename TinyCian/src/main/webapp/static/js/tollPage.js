function getToolPage(){
    fetch('/tool',{
        method:'GET',
        headers:{
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response)=>{
        return response.text()
    }).then((html)=>{
        var b=document.body
        b.innerHTML=''
        b.innerHTML=html
    })
}

function agencyTool(){
    let div=document.getElementById('info')
    div.innerHTML=''
    let create=document.createElement('h3')
    create.textContent='Create new agency'
    div.appendChild(create)

    div.appendChild(document.createElement('br'))

    let nameLabel=document.createElement('label')
    nameLabel.innerHTML='name'
    let nameInput=document.createElement('input');
    nameInput.id='name'
    nameInput.name='name'
    nameInput.type='text'
    nameLabel.appendChild(nameInput)
    div.appendChild(nameLabel)

    div.appendChild(document.createElement('br'))

    let descriptionLabel=document.createElement('label')
    descriptionLabel.innerHTML='description'
    let descriptionInput=document.createElement('input');
    descriptionInput.id='description'
    descriptionInput.name='description'
    descriptionInput.type='text'
    descriptionLabel.appendChild(descriptionInput)
    div.appendChild(descriptionLabel)

    div.appendChild(document.createElement('br'))


    let phoneNumberLabel=document.createElement('label')
    phoneNumberLabel.innerHTML='phoneNumber'
    let phoneNumberInput=document.createElement('input');
    phoneNumberInput.id='phoneNumber'
    phoneNumberInput.name='phoneNumber'
    phoneNumberInput.type='text'
    phoneNumberLabel.appendChild(phoneNumberInput)
    div.appendChild(phoneNumberLabel)

    div.appendChild(document.createElement('br'))

    let linkOnWebsiteLabel=document.createElement('label')
    linkOnWebsiteLabel.innerHTML='linkOnWebsite'
    let linkOnWebsiteInput=document.createElement('input');
    linkOnWebsiteInput.id='linkOnWebsite'
    linkOnWebsiteInput.name='linkOnWebsite'
    linkOnWebsiteInput.type='text'
    linkOnWebsiteLabel.appendChild(linkOnWebsiteInput)
    div.appendChild(linkOnWebsiteLabel)

    div.appendChild(document.createElement('br'))

    let regionsLabel=document.createElement('label')
    regionsLabel.innerHTML='regions'
    let regionsSelect=document.createElement('select');
    regionsSelect.id='regions'
    regionsSelect.multiple=true;
    let region1=document.createElement('option')
    region1.value='1'
    region1.text='Республика Адыгея'
    regionsSelect.add(region1)
    let region2=document.createElement('option')
    region2.value='2'
    region2.text='Республика Башкортостан'
    regionsSelect.add(region2)
    let region3=document.createElement('option')
    region3.value='3'
    region3.text='Республика Бурятия'
    regionsSelect.add(region3)
    let region4=document.createElement('option')
    region4.value='4'
    region4.text='Республика Алтай (Горный Алтай)'
    regionsSelect.add(region4)
    let region5=document.createElement('option')
    region5.value='5'
    region5.text='Республика Дагестан'
    regionsSelect.add(region5)
    let region6=document.createElement('option')
    region6.value='6'
    region6.text='Республика Ингушетия'
    regionsSelect.add(region6)
    let region7=document.createElement('option')
    region7.value='7'
    region7.text='Кабардино-Балкарская Республика'
    regionsSelect.add(region7)
    let region8=document.createElement('option')
    region8.value='8'
    region8.text='Республика Калмыкия'
    regionsSelect.add(region8)
    let region9=document.createElement('option')
    region9.value='9'
    region9.text='Республика Карачаево-Черкессия'
    regionsSelect.add(region9)
    let region10=document.createElement('option')
    region10.value='10'
    region10.text='Республика Карелия'
    regionsSelect.add(region10)
    let region11=document.createElement('option')
    region11.value='11'
    region11.text='Республика Коми'
    regionsSelect.add(region11)
    let region12=document.createElement('option')
    region12.value='12'
    region12.text='Республика Марий Эл'
    regionsSelect.add(region12)
    let region13=document.createElement('option')
    region13.value='13'
    region13.text='Республика Мордовия'
    regionsSelect.add(region13)
    let region14=document.createElement('option')
    region14.value='14'
    region14.text='Республика Саха (Якутия)'
    regionsSelect.add(region14)
    let region15=document.createElement('option')
    region15.value='15'
    region15.text='Республика Северная Осетия — Алания'
    regionsSelect.add(region15)
    let region16=document.createElement('option')
    region16.value='16'
    region16.text='Республика Татарстан'
    regionsSelect.add(region16)
    let region17=document.createElement('option')
    region17.value='17'
    region17.text='Республика Тыва'
    regionsSelect.add(region17)
    let region18=document.createElement('option')
    region18.value='18'
    region18.text='Удмуртская Республика'
    regionsSelect.add(region18)
    let region19=document.createElement('option')
    region19.value='19'
    region19.text='Республика Хакасия'
    regionsSelect.add(region19)
    let region21=document.createElement('option')
    region21.value='21'
    region21.text='Чувашская Республика'
    regionsSelect.add(region21)
    let region22=document.createElement('option')
    region22.value='22'
    region22.text='Алтайский край'
    regionsSelect.add(region22)
    let region23=document.createElement('option')
    region23.value='23'
    region23.text='Краснодарский край'
    regionsSelect.add(region23)
    let region24=document.createElement('option')
    region24.value='24'
    region24.text='Красноярский край'
    regionsSelect.add(region24)
    let region25=document.createElement('option')
    region25.value='25'
    region25.text='Приморский край'
    regionsSelect.add(region25)
    let region26=document.createElement('option')
    region26.value='26'
    region26.text='Ставропольский край'
    regionsSelect.add(region26)
    let region27=document.createElement('option')
    region27.value='27'
    region27.text='Хабаровский край'
    regionsSelect.add(region27)
    let region28=document.createElement('option')
    region28.value='28'
    region28.text='Амурская область'
    regionsSelect.add(region28)
    let region29=document.createElement('option')
    region29.value='29'
    region29.text='Архангельская область'
    regionsSelect.add(region29)
    let region30=document.createElement('option')
    region30.value='30'
    region30.text='Астраханская область'
    regionsSelect.add(region30)
    let region31=document.createElement('option')
    region31.value='31'
    region31.text='Белгородская область'
    regionsSelect.add(region31)
    let region32=document.createElement('option')
    region32.value='32'
    region32.text='Брянская область'
    regionsSelect.add(region32)
    let region33=document.createElement('option')
    region33.value='33'
    region33.text='Владимирская область'
    regionsSelect.add(region33)
    let region34=document.createElement('option')
    region34.value='34'
    region34.text='Волгоградская область'
    regionsSelect.add(region34)
    let region35=document.createElement('option')
    region35.value='35'
    region35.text='Вологодская область'
    regionsSelect.add(region35)
    let region36=document.createElement('option')
    region36.value='36'
    region36.text='Воронежская область'
    regionsSelect.add(region36)
    let region37=document.createElement('option')
    region37.value='37'
    region37.text='Ивановская область'
    regionsSelect.add(region37)
    let region38=document.createElement('option')
    region38.value='38'
    region38.text='Иркутская область'
    regionsSelect.add(region38)
    let region39=document.createElement('option')
    region39.value='39'
    region39.text='Калининградская область'
    regionsSelect.add(region39)
    let region40=document.createElement('option')
    region40.value='40'
    region40.text='Калужская область'
    regionsSelect.add(region40)
    let region41=document.createElement('option')
    region41.value='41'
    region41.text='Камчатский край'
    regionsSelect.add(region41)
    let region42=document.createElement('option')
    region42.value='42'
    region42.text='Кемеровская область'
    regionsSelect.add(region42)
    let region43=document.createElement('option')
    region43.value='43'
    region43.text='Кировская область'
    regionsSelect.add(region43)
    let region44=document.createElement('option')
    region44.value='44'
    region44.text='Костромская область'
    regionsSelect.add(region44)
    let region45=document.createElement('option')
    region45.value='45'
    region45.text='Курганская область'
    regionsSelect.add(region45)
    let region46=document.createElement('option')
    region46.value='46'
    region46.text='Курская область'
    regionsSelect.add(region46)
    let region47=document.createElement('option')
    region47.value='47'
    region47.text='Ленинградская область'
    regionsSelect.add(region47)
    let region48=document.createElement('option')
    region48.value='48'
    region48.text='Липецкая область'
    regionsSelect.add(region48)
    let region49=document.createElement('option')
    region49.value='49'
    region49.text='Магаданская область'
    regionsSelect.add(region49)
    let region50=document.createElement('option')
    region50.value='50'
    region50.text='Московская область'
    regionsSelect.add(region50)
    let region51=document.createElement('option')
    region51.value='51'
    region51.text='Мурманская область'
    regionsSelect.add(region51)
    let region52=document.createElement('option')
    region52.value='52'
    region52.text='Нижегородская область'
    regionsSelect.add(region52)
    let region53=document.createElement('option')
    region53.value='53'
    region53.text='Новгородская область'
    regionsSelect.add(region53)
    let region54=document.createElement('option')
    region54.value='54'
    region54.text='Новосибирская область'
    regionsSelect.add(region54)
    let region55=document.createElement('option')
    region55.value='55'
    region55.text='Омская область'
    regionsSelect.add(region55)
    let region56=document.createElement('option')
    region56.value='56'
    region56.text='Оренбургская область'
    regionsSelect.add(region56)
    let region57=document.createElement('option')
    region57.value='57'
    region57.text='Орловская область'
    regionsSelect.add(region57)
    let region58=document.createElement('option')
    region58.value='58'
    region58.text='Пензенская область'
    regionsSelect.add(region58)
    let region59=document.createElement('option')
    region59.value='59'
    region59.text='Пермский край'
    regionsSelect.add(region59)
    let region60=document.createElement('option')
    region60.value='60'
    region60.text='Псковская область'
    regionsSelect.add(region60)
    let region61=document.createElement('option')
    region61.value='61'
    region61.text='Ростовская область'
    regionsSelect.add(region61)
    let region62=document.createElement('option')
    region62.value='62'
    region62.text='Рязанская область'
    regionsSelect.add(region62)
    let region63=document.createElement('option')
    region63.value='63'
    region63.text='Самарская область'
    regionsSelect.add(region63)
    let region64=document.createElement('option')
    region64.value='64'
    region64.text='Саратовская область'
    regionsSelect.add(region64)
    let region65=document.createElement('option')
    region65.value='65'
    region65.text='Сахалинская область'
    regionsSelect.add(region65)
    let region66=document.createElement('option')
    region66.value='66'
    region66.text='Свердловская область'
    regionsSelect.add(region66)
    let region67=document.createElement('option')
    region67.value='67'
    region67.text='Смоленская область'
    regionsSelect.add(region67)
    let region68=document.createElement('option')
    region68.value='68'
    region68.text='Тамбовская область'
    regionsSelect.add(region68)
    let region69=document.createElement('option')
    region69.value='69'
    region69.text='Тверская область'
    regionsSelect.add(region69)
    let region70=document.createElement('option')
    region70.value='70'
    region70.text='Томская область'
    regionsSelect.add(region70)
    let region71=document.createElement('option')
    region71.value='71'
    region71.text='Тульская область'
    regionsSelect.add(region71)
    let region72=document.createElement('option')
    region72.value='72'
    region72.text='Тюменская область'
    regionsSelect.add(region72)
    let region73=document.createElement('option')
    region73.value='73'
    region73.text='Ульяновская область'
    regionsSelect.add(region73)
    let region74=document.createElement('option')
    region74.value='74'
    region74.text='Челябинская область'
    regionsSelect.add(region74)
    let region75=document.createElement('option')
    region75.value='75'
    region75.text='Забайкальский край'
    regionsSelect.add(region75)
    let region76=document.createElement('option')
    region76.value='76'
    region76.text='Ярославская область'
    regionsSelect.add(region76)
    let region77=document.createElement('option')
    region77.value='77'
    region77.text='Москва'
    regionsSelect.add(region77)
    let region78=document.createElement('option')
    region78.value='78'
    region78.text='Санкт-Петербург'
    regionsSelect.add(region78)
    let region79=document.createElement('option')
    region79.value='79'
    region79.text='Еврейская автономная область'
    regionsSelect.add(region79)
    let region82=document.createElement('option')
    region82.value='82'
    region82.text='Республика Крым'
    regionsSelect.add(region82)
    let region83=document.createElement('option')
    region83.value='83'
    region83.text='Ненецкий автономный округ'
    regionsSelect.add(region83)
    let region86=document.createElement('option')
    region86.value='86'
    region86.text='Ханты-Мансийский автономный округ — Югра'
    regionsSelect.add(region86)
    let region87=document.createElement('option')
    region87.value='87'
    region87.text='Чукотский автономный округ'
    regionsSelect.add(region87)
    let region89=document.createElement('option')
    region89.value='89'
    region89.text='Ямало-Ненецкий автономный округ'
    regionsSelect.add(region89)
    let region92=document.createElement('option')
    region92.value='92'
    region92.text='г. Севастополь'
    regionsSelect.add(region92)
    let region94=document.createElement('option')
    region94.value='94'
    region94.text='Территории, находящиеся за пределами РФ и обслуживаемые Департаментом режимных объектов МВД России'
    regionsSelect.add(region94)
    let region95=document.createElement('option')
    region95.value='95'
    region95.text='Чеченская республика'
    regionsSelect.add(region95)
    regionsLabel.appendChild(regionsSelect)
    div.appendChild(regionsLabel)
    div.appendChild(document.createElement('br'))
    let addButton=document.createElement('button')
    addButton.textContent='add'
    addButton.addEventListener('click',()=>
        addAgency(document.getElementById('name').value,
            document.getElementById('description').value,
            document.getElementById('phoneNumber').value,
            document.getElementById('linkOnWebsite').value,
            document.getElementById('regions').value))
    div.appendChild(addButton)


}

function addAgency(name,description,phoneNumber,linkOnWebsite,regionsList){
    var regionsOfAgency=[]
    for (var option of document.getElementById("regions").options) {
        if(option.selected){
            regionsOfAgency.push(option.value)
        }
    }
    if(name==='' || description==='' || phoneNumber==='' || linkOnWebsite==='' || regionsOfAgency.length===0){
        alert('Please fill all labels')
        return
    }

    let body={
        "name":name,
        "description":description,
        "phoneNumber":phoneNumber,
        "linkOnWebsite":linkOnWebsite,
        "regionsList": regionsOfAgency
    }
    console.log(regionsOfAgency)
    fetch('/tool/createAgency',{
        method:'POST',
        headers:{
            'AUTHORIZATION': localStorage.getItem('accessToken'),
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    })
    alert('Agency succesful created')
}


function residentialComplexTool(){
    let div=document.getElementById('info')
    div.innerHTML=''
    let create=document.createElement('h3')
    create.textContent='Create new agency'
    div.appendChild(create)

    div.appendChild(document.createElement('br'))

    let cityLabel=document.createElement('label')
    cityLabel.innerHTML='city'
    let cityInput=document.createElement('input');
    cityInput.id='city'
    cityInput.name='city'
    cityInput.type='text'
    cityLabel.appendChild(cityInput)
    div.appendChild(cityLabel)

    div.appendChild(document.createElement('br'))

    let districtLabel=document.createElement('label')
    districtLabel.innerHTML='district'
    let districtInput=document.createElement('input');
    districtInput.id='district'
    districtInput.name='district'
    districtInput.type='text'
    districtLabel.appendChild(districtInput)
    div.appendChild(districtLabel)

    div.appendChild(document.createElement('br'))

    let numberOfBuildingsLabel=document.createElement('label')
    numberOfBuildingsLabel.innerHTML='numberOfBuildings'
    let numberOfBuildingsInput=document.createElement('input');
    numberOfBuildingsInput.onkeydown="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57"
    numberOfBuildingsInput.id='numberOfBuildings'
    numberOfBuildingsInput.name='numberOfBuildings'
    numberOfBuildingsInput.type='number'
    numberOfBuildingsLabel.appendChild(numberOfBuildingsInput)
    div.appendChild(numberOfBuildingsLabel)

    div.appendChild(document.createElement('br'))

    let numberOfReadyBuildingsLabel=document.createElement('label')
    numberOfReadyBuildingsLabel.innerHTML='numberOfReadyBuildings'
    let numberOfReadyBuildingsInput=document.createElement('input');
    numberOfReadyBuildingsInput.id='numberOfReadyBuildings'
    numberOfReadyBuildingsInput.name='numberOfReadyBuildings'
    numberOfReadyBuildingsInput.type='number'
    numberOfReadyBuildingsLabel.appendChild(numberOfReadyBuildingsInput)
    div.appendChild(numberOfReadyBuildingsLabel)

    div.appendChild(document.createElement('br'))


    let agencyLabel=document.createElement('label')
    agencyLabel.innerHTML='agency'
    let agencyInput=document.createElement('input');
    agencyInput.id='agency'
    agencyInput.name='agency'
    agencyInput.type='text'
    agencyLabel.appendChild(agencyInput)
    div.appendChild(agencyLabel)

    div.appendChild(document.createElement('br'))


    let nameLabel=document.createElement('label')
    nameLabel.innerHTML='name'
    let nameInput=document.createElement('input');
    nameInput.id='name'
    nameInput.name='name'
    nameInput.type='text'
    nameLabel.appendChild(nameInput)
    div.appendChild(nameLabel)


    div.appendChild(document.createElement('br'))

    let descriptionLabel=document.createElement('label')
    descriptionLabel.innerHTML='description'
    let descriptionInput=document.createElement('input');
    descriptionInput.id='description'
    descriptionInput.name='description'
    descriptionInput.type='text'
    descriptionLabel.appendChild(descriptionInput)
    div.appendChild(descriptionLabel)

    div.appendChild(document.createElement('br'))

    let linkOnWebsiteLabel=document.createElement('label')
    linkOnWebsiteLabel.innerHTML='linkOnWebsite'
    let linkOnWebsiteInput=document.createElement('input');
    linkOnWebsiteInput.id='linkOnWebsite'
    linkOnWebsiteInput.name='linkOnWebsite'
    linkOnWebsiteInput.type='text'
    linkOnWebsiteLabel.appendChild(linkOnWebsiteInput)
    div.appendChild(linkOnWebsiteLabel)

    div.appendChild(document.createElement('br'))

    let phoneNumberLabel=document.createElement('label')
    phoneNumberLabel.innerHTML='phoneNumber'
    let phoneNumberInput=document.createElement('input');
    phoneNumberInput.id='phoneNumber'
    phoneNumberInput.name='phoneNumber'
    phoneNumberInput.type='text'
    phoneNumberLabel.appendChild(phoneNumberInput)
    div.appendChild(phoneNumberLabel)

    div.appendChild(document.createElement('br'))

    let deliveryYearLabel=document.createElement('label')
    deliveryYearLabel.innerHTML='deliveryYear'
    let deliveryYearInput=document.createElement('input');
    deliveryYearInput.id='deliveryYear'
    deliveryYearInput.name='deliveryYear'
    deliveryYearInput.type='date'
    deliveryYearLabel.appendChild(deliveryYearInput)
    div.appendChild(deliveryYearLabel)

    div.appendChild(document.createElement('br'))

    let regionsLabel=document.createElement('label')
    regionsLabel.innerHTML='regions'
    let regionsSelect=document.createElement('select');
    regionsSelect.id='regions'
    let region1=document.createElement('option')
    region1.value='1'
    region1.text='Республика Адыгея'
    regionsSelect.add(region1)
    let region2=document.createElement('option')
    region2.value='2'
    region2.text='Республика Башкортостан'
    regionsSelect.add(region2)
    let region3=document.createElement('option')
    region3.value='3'
    region3.text='Республика Бурятия'
    regionsSelect.add(region3)
    let region4=document.createElement('option')
    region4.value='4'
    region4.text='Республика Алтай (Горный Алтай)'
    regionsSelect.add(region4)
    let region5=document.createElement('option')
    region5.value='5'
    region5.text='Республика Дагестан'
    regionsSelect.add(region5)
    let region6=document.createElement('option')
    region6.value='6'
    region6.text='Республика Ингушетия'
    regionsSelect.add(region6)
    let region7=document.createElement('option')
    region7.value='7'
    region7.text='Кабардино-Балкарская Республика'
    regionsSelect.add(region7)
    let region8=document.createElement('option')
    region8.value='8'
    region8.text='Республика Калмыкия'
    regionsSelect.add(region8)
    let region9=document.createElement('option')
    region9.value='9'
    region9.text='Республика Карачаево-Черкессия'
    regionsSelect.add(region9)
    let region10=document.createElement('option')
    region10.value='10'
    region10.text='Республика Карелия'
    regionsSelect.add(region10)
    let region11=document.createElement('option')
    region11.value='11'
    region11.text='Республика Коми'
    regionsSelect.add(region11)
    let region12=document.createElement('option')
    region12.value='12'
    region12.text='Республика Марий Эл'
    regionsSelect.add(region12)
    let region13=document.createElement('option')
    region13.value='13'
    region13.text='Республика Мордовия'
    regionsSelect.add(region13)
    let region14=document.createElement('option')
    region14.value='14'
    region14.text='Республика Саха (Якутия)'
    regionsSelect.add(region14)
    let region15=document.createElement('option')
    region15.value='15'
    region15.text='Республика Северная Осетия — Алания'
    regionsSelect.add(region15)
    let region16=document.createElement('option')
    region16.value='16'
    region16.text='Республика Татарстан'
    regionsSelect.add(region16)
    let region17=document.createElement('option')
    region17.value='17'
    region17.text='Республика Тыва'
    regionsSelect.add(region17)
    let region18=document.createElement('option')
    region18.value='18'
    region18.text='Удмуртская Республика'
    regionsSelect.add(region18)
    let region19=document.createElement('option')
    region19.value='19'
    region19.text='Республика Хакасия'
    regionsSelect.add(region19)
    let region21=document.createElement('option')
    region21.value='21'
    region21.text='Чувашская Республика'
    regionsSelect.add(region21)
    let region22=document.createElement('option')
    region22.value='22'
    region22.text='Алтайский край'
    regionsSelect.add(region22)
    let region23=document.createElement('option')
    region23.value='23'
    region23.text='Краснодарский край'
    regionsSelect.add(region23)
    let region24=document.createElement('option')
    region24.value='24'
    region24.text='Красноярский край'
    regionsSelect.add(region24)
    let region25=document.createElement('option')
    region25.value='25'
    region25.text='Приморский край'
    regionsSelect.add(region25)
    let region26=document.createElement('option')
    region26.value='26'
    region26.text='Ставропольский край'
    regionsSelect.add(region26)
    let region27=document.createElement('option')
    region27.value='27'
    region27.text='Хабаровский край'
    regionsSelect.add(region27)
    let region28=document.createElement('option')
    region28.value='28'
    region28.text='Амурская область'
    regionsSelect.add(region28)
    let region29=document.createElement('option')
    region29.value='29'
    region29.text='Архангельская область'
    regionsSelect.add(region29)
    let region30=document.createElement('option')
    region30.value='30'
    region30.text='Астраханская область'
    regionsSelect.add(region30)
    let region31=document.createElement('option')
    region31.value='31'
    region31.text='Белгородская область'
    regionsSelect.add(region31)
    let region32=document.createElement('option')
    region32.value='32'
    region32.text='Брянская область'
    regionsSelect.add(region32)
    let region33=document.createElement('option')
    region33.value='33'
    region33.text='Владимирская область'
    regionsSelect.add(region33)
    let region34=document.createElement('option')
    region34.value='34'
    region34.text='Волгоградская область'
    regionsSelect.add(region34)
    let region35=document.createElement('option')
    region35.value='35'
    region35.text='Вологодская область'
    regionsSelect.add(region35)
    let region36=document.createElement('option')
    region36.value='36'
    region36.text='Воронежская область'
    regionsSelect.add(region36)
    let region37=document.createElement('option')
    region37.value='37'
    region37.text='Ивановская область'
    regionsSelect.add(region37)
    let region38=document.createElement('option')
    region38.value='38'
    region38.text='Иркутская область'
    regionsSelect.add(region38)
    let region39=document.createElement('option')
    region39.value='39'
    region39.text='Калининградская область'
    regionsSelect.add(region39)
    let region40=document.createElement('option')
    region40.value='40'
    region40.text='Калужская область'
    regionsSelect.add(region40)
    let region41=document.createElement('option')
    region41.value='41'
    region41.text='Камчатский край'
    regionsSelect.add(region41)
    let region42=document.createElement('option')
    region42.value='42'
    region42.text='Кемеровская область'
    regionsSelect.add(region42)
    let region43=document.createElement('option')
    region43.value='43'
    region43.text='Кировская область'
    regionsSelect.add(region43)
    let region44=document.createElement('option')
    region44.value='44'
    region44.text='Костромская область'
    regionsSelect.add(region44)
    let region45=document.createElement('option')
    region45.value='45'
    region45.text='Курганская область'
    regionsSelect.add(region45)
    let region46=document.createElement('option')
    region46.value='46'
    region46.text='Курская область'
    regionsSelect.add(region46)
    let region47=document.createElement('option')
    region47.value='47'
    region47.text='Ленинградская область'
    regionsSelect.add(region47)
    let region48=document.createElement('option')
    region48.value='48'
    region48.text='Липецкая область'
    regionsSelect.add(region48)
    let region49=document.createElement('option')
    region49.value='49'
    region49.text='Магаданская область'
    regionsSelect.add(region49)
    let region50=document.createElement('option')
    region50.value='50'
    region50.text='Московская область'
    regionsSelect.add(region50)
    let region51=document.createElement('option')
    region51.value='51'
    region51.text='Мурманская область'
    regionsSelect.add(region51)
    let region52=document.createElement('option')
    region52.value='52'
    region52.text='Нижегородская область'
    regionsSelect.add(region52)
    let region53=document.createElement('option')
    region53.value='53'
    region53.text='Новгородская область'
    regionsSelect.add(region53)
    let region54=document.createElement('option')
    region54.value='54'
    region54.text='Новосибирская область'
    regionsSelect.add(region54)
    let region55=document.createElement('option')
    region55.value='55'
    region55.text='Омская область'
    regionsSelect.add(region55)
    let region56=document.createElement('option')
    region56.value='56'
    region56.text='Оренбургская область'
    regionsSelect.add(region56)
    let region57=document.createElement('option')
    region57.value='57'
    region57.text='Орловская область'
    regionsSelect.add(region57)
    let region58=document.createElement('option')
    region58.value='58'
    region58.text='Пензенская область'
    regionsSelect.add(region58)
    let region59=document.createElement('option')
    region59.value='59'
    region59.text='Пермский край'
    regionsSelect.add(region59)
    let region60=document.createElement('option')
    region60.value='60'
    region60.text='Псковская область'
    regionsSelect.add(region60)
    let region61=document.createElement('option')
    region61.value='61'
    region61.text='Ростовская область'
    regionsSelect.add(region61)
    let region62=document.createElement('option')
    region62.value='62'
    region62.text='Рязанская область'
    regionsSelect.add(region62)
    let region63=document.createElement('option')
    region63.value='63'
    region63.text='Самарская область'
    regionsSelect.add(region63)
    let region64=document.createElement('option')
    region64.value='64'
    region64.text='Саратовская область'
    regionsSelect.add(region64)
    let region65=document.createElement('option')
    region65.value='65'
    region65.text='Сахалинская область'
    regionsSelect.add(region65)
    let region66=document.createElement('option')
    region66.value='66'
    region66.text='Свердловская область'
    regionsSelect.add(region66)
    let region67=document.createElement('option')
    region67.value='67'
    region67.text='Смоленская область'
    regionsSelect.add(region67)
    let region68=document.createElement('option')
    region68.value='68'
    region68.text='Тамбовская область'
    regionsSelect.add(region68)
    let region69=document.createElement('option')
    region69.value='69'
    region69.text='Тверская область'
    regionsSelect.add(region69)
    let region70=document.createElement('option')
    region70.value='70'
    region70.text='Томская область'
    regionsSelect.add(region70)
    let region71=document.createElement('option')
    region71.value='71'
    region71.text='Тульская область'
    regionsSelect.add(region71)
    let region72=document.createElement('option')
    region72.value='72'
    region72.text='Тюменская область'
    regionsSelect.add(region72)
    let region73=document.createElement('option')
    region73.value='73'
    region73.text='Ульяновская область'
    regionsSelect.add(region73)
    let region74=document.createElement('option')
    region74.value='74'
    region74.text='Челябинская область'
    regionsSelect.add(region74)
    let region75=document.createElement('option')
    region75.value='75'
    region75.text='Забайкальский край'
    regionsSelect.add(region75)
    let region76=document.createElement('option')
    region76.value='76'
    region76.text='Ярославская область'
    regionsSelect.add(region76)
    let region77=document.createElement('option')
    region77.value='77'
    region77.text='Москва'
    regionsSelect.add(region77)
    let region78=document.createElement('option')
    region78.value='78'
    region78.text='Санкт-Петербург'
    regionsSelect.add(region78)
    let region79=document.createElement('option')
    region79.value='79'
    region79.text='Еврейская автономная область'
    regionsSelect.add(region79)
    let region82=document.createElement('option')
    region82.value='82'
    region82.text='Республика Крым'
    regionsSelect.add(region82)
    let region83=document.createElement('option')
    region83.value='83'
    region83.text='Ненецкий автономный округ'
    regionsSelect.add(region83)
    let region86=document.createElement('option')
    region86.value='86'
    region86.text='Ханты-Мансийский автономный округ — Югра'
    regionsSelect.add(region86)
    let region87=document.createElement('option')
    region87.value='87'
    region87.text='Чукотский автономный округ'
    regionsSelect.add(region87)
    let region89=document.createElement('option')
    region89.value='89'
    region89.text='Ямало-Ненецкий автономный округ'
    regionsSelect.add(region89)
    let region92=document.createElement('option')
    region92.value='92'
    region92.text='г. Севастополь'
    regionsSelect.add(region92)
    let region94=document.createElement('option')
    region94.value='94'
    region94.text='Территории, находящиеся за пределами РФ и обслуживаемые Департаментом режимных объектов МВД России'
    regionsSelect.add(region94)
    let region95=document.createElement('option')
    region95.value='95'
    region95.text='Чеченская республика'
    regionsSelect.add(region95)
    regionsLabel.appendChild(regionsSelect)
    div.appendChild(regionsLabel)
    div.appendChild(document.createElement('br'))

    let addButton=document.createElement('button');
    addButton.textContent='add'
    div.appendChild(addButton)
    addButton.addEventListener('click',()=>{
        addResidentialComplex(
            document.getElementById('city').value,
            document.getElementById('district').value,
            document.getElementById('numberOfBuildings').value,
            document.getElementById('numberOfReadyBuildings').value,
            document.getElementById('agency').value,
            document.getElementById('name').value,
            document.getElementById('description').value,
            document.getElementById('linkOnWebsite').value,
            document.getElementById('phoneNumber').value,
            document.getElementById('deliveryYear').value,
            document.getElementById('regions').value
        )
    })
}


function addResidentialComplex(city,district,numberOfBuildings,numberOfReadyBuildings,agency,name,description,linkOnWebsite,phoneNumber,deliveryYear,regions){
    if(city==='' || district==='' || numberOfBuildings==='' || numberOfReadyBuildings==='' || agency==='' || name==='' || description==='' || linkOnWebsite==='' || phoneNumber==='' ||
        deliveryYear==='' || regions===''){
        alert('Please fill all labels')
        return
    }

    const regexExp = /^[0-9a-fA-F]{8}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{12}$/gi;
    if(!regexExp.test(agency)){
        alert('Incorrect id of Residential complex')
        return;
    }


    let body={
        "city":city,
        "district":district,
        "numberOfBuildings":numberOfBuildings,
        "numberOfReadyBuildings":numberOfReadyBuildings,
        "agency":agency,
        "name":name,
        "description":description,
        "linkOnWebsite":linkOnWebsite,
        "phoneNumber":phoneNumber,
        "deliveryYear":deliveryYear,
        "regions":regions
    }
    console.log(body)
    console.log(JSON.stringify(body))
    fetch('/tool/createResidentialComplex',{
        method:'POST',
        headers:{
            'AUTHORIZATION': localStorage.getItem('accessToken'),
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    })

    alert('ResidentialComplex succesful created')
}

function findAgencyForTool(field, value) {
    console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!")
    fetch('/admin/certainAgency?field=' + field + '&value=' + value, {
        method: 'GET',
        headers: {
            'AUTHORIZATION': localStorage.getItem('accessToken')
        }
    }).then((response) => {
        return response.json()
    }).then((users) => {
        console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!")
        let table = document.getElementById('changeAgency')

        table.innerHTML = ''


        let nameLabel=document.createElement('label');
        nameLabel.textContent='name'
        let nameInput=document.createElement('input')
        nameInput.id='nameChange'
        nameInput.value=users[0].name
        nameLabel.appendChild(nameInput)

        table.appendChild(nameLabel)

        let descriptionLabel=document.createElement('label');
        descriptionLabel.textContent='description'
        let descriptionInput=document.createElement('input')
        descriptionInput.id='descriptionChange'
        descriptionInput.value=users[0].description
        descriptionLabel.appendChild(descriptionInput)

        table.appendChild(descriptionLabel)

        let phoneNumberLabel=document.createElement('label');
        phoneNumberLabel.textContent='phoneNumber'
        let phoneNumberInput=document.createElement('input')
        phoneNumberInput.id='phoneNumberChange'
        phoneNumberInput.value=users[0].phoneNumber
        phoneNumberLabel.appendChild(phoneNumberInput)

        table.appendChild(phoneNumberLabel)


        let linkOnWebsiteLabel=document.createElement('label');
        linkOnWebsiteLabel.textContent='linkOnWebsite'
        let linkOnWebsiteInput=document.createElement('input')
        linkOnWebsiteInput.id='linkOnWebsiteChange'
        linkOnWebsiteInput.value=users[0].linkOnWebsite
        linkOnWebsiteLabel.appendChild(linkOnWebsiteInput)

        table.appendChild(linkOnWebsiteLabel)

        let regionsLabel=document.createElement('label')
        regionsLabel.innerHTML='regions'
        let regionsSelect=document.createElement('select');
        regionsSelect.multiple=true;
        regionsSelect.id='regionsUpdate'
        let region1=document.createElement('option')
        region1.value='1'
        region1.text='Республика Адыгея'
        regionsSelect.add(region1)
        let region2=document.createElement('option')
        region2.value='2'
        region2.text='Республика Башкортостан'
        regionsSelect.add(region2)
        let region3=document.createElement('option')
        region3.value='3'
        region3.text='Республика Бурятия'
        regionsSelect.add(region3)
        let region4=document.createElement('option')
        region4.value='4'
        region4.text='Республика Алтай (Горный Алтай)'
        regionsSelect.add(region4)
        let region5=document.createElement('option')
        region5.value='5'
        region5.text='Республика Дагестан'
        regionsSelect.add(region5)
        let region6=document.createElement('option')
        region6.value='6'
        region6.text='Республика Ингушетия'
        regionsSelect.add(region6)
        let region7=document.createElement('option')
        region7.value='7'
        region7.text='Кабардино-Балкарская Республика'
        regionsSelect.add(region7)
        let region8=document.createElement('option')
        region8.value='8'
        region8.text='Республика Калмыкия'
        regionsSelect.add(region8)
        let region9=document.createElement('option')
        region9.value='9'
        region9.text='Республика Карачаево-Черкессия'
        regionsSelect.add(region9)
        let region10=document.createElement('option')
        region10.value='10'
        region10.text='Республика Карелия'
        regionsSelect.add(region10)
        let region11=document.createElement('option')
        region11.value='11'
        region11.text='Республика Коми'
        regionsSelect.add(region11)
        let region12=document.createElement('option')
        region12.value='12'
        region12.text='Республика Марий Эл'
        regionsSelect.add(region12)
        let region13=document.createElement('option')
        region13.value='13'
        region13.text='Республика Мордовия'
        regionsSelect.add(region13)
        let region14=document.createElement('option')
        region14.value='14'
        region14.text='Республика Саха (Якутия)'
        regionsSelect.add(region14)
        let region15=document.createElement('option')
        region15.value='15'
        region15.text='Республика Северная Осетия — Алания'
        regionsSelect.add(region15)
        let region16=document.createElement('option')
        region16.value='16'
        region16.text='Республика Татарстан'
        regionsSelect.add(region16)
        let region17=document.createElement('option')
        region17.value='17'
        region17.text='Республика Тыва'
        regionsSelect.add(region17)
        let region18=document.createElement('option')
        region18.value='18'
        region18.text='Удмуртская Республика'
        regionsSelect.add(region18)
        let region19=document.createElement('option')
        region19.value='19'
        region19.text='Республика Хакасия'
        regionsSelect.add(region19)
        let region21=document.createElement('option')
        region21.value='21'
        region21.text='Чувашская Республика'
        regionsSelect.add(region21)
        let region22=document.createElement('option')
        region22.value='22'
        region22.text='Алтайский край'
        regionsSelect.add(region22)
        let region23=document.createElement('option')
        region23.value='23'
        region23.text='Краснодарский край'
        regionsSelect.add(region23)
        let region24=document.createElement('option')
        region24.value='24'
        region24.text='Красноярский край'
        regionsSelect.add(region24)
        let region25=document.createElement('option')
        region25.value='25'
        region25.text='Приморский край'
        regionsSelect.add(region25)
        let region26=document.createElement('option')
        region26.value='26'
        region26.text='Ставропольский край'
        regionsSelect.add(region26)
        let region27=document.createElement('option')
        region27.value='27'
        region27.text='Хабаровский край'
        regionsSelect.add(region27)
        let region28=document.createElement('option')
        region28.value='28'
        region28.text='Амурская область'
        regionsSelect.add(region28)
        let region29=document.createElement('option')
        region29.value='29'
        region29.text='Архангельская область'
        regionsSelect.add(region29)
        let region30=document.createElement('option')
        region30.value='30'
        region30.text='Астраханская область'
        regionsSelect.add(region30)
        let region31=document.createElement('option')
        region31.value='31'
        region31.text='Белгородская область'
        regionsSelect.add(region31)
        let region32=document.createElement('option')
        region32.value='32'
        region32.text='Брянская область'
        regionsSelect.add(region32)
        let region33=document.createElement('option')
        region33.value='33'
        region33.text='Владимирская область'
        regionsSelect.add(region33)
        let region34=document.createElement('option')
        region34.value='34'
        region34.text='Волгоградская область'
        regionsSelect.add(region34)
        let region35=document.createElement('option')
        region35.value='35'
        region35.text='Вологодская область'
        regionsSelect.add(region35)
        let region36=document.createElement('option')
        region36.value='36'
        region36.text='Воронежская область'
        regionsSelect.add(region36)
        let region37=document.createElement('option')
        region37.value='37'
        region37.text='Ивановская область'
        regionsSelect.add(region37)
        let region38=document.createElement('option')
        region38.value='38'
        region38.text='Иркутская область'
        regionsSelect.add(region38)
        let region39=document.createElement('option')
        region39.value='39'
        region39.text='Калининградская область'
        regionsSelect.add(region39)
        let region40=document.createElement('option')
        region40.value='40'
        region40.text='Калужская область'
        regionsSelect.add(region40)
        let region41=document.createElement('option')
        region41.value='41'
        region41.text='Камчатский край'
        regionsSelect.add(region41)
        let region42=document.createElement('option')
        region42.value='42'
        region42.text='Кемеровская область'
        regionsSelect.add(region42)
        let region43=document.createElement('option')
        region43.value='43'
        region43.text='Кировская область'
        regionsSelect.add(region43)
        let region44=document.createElement('option')
        region44.value='44'
        region44.text='Костромская область'
        regionsSelect.add(region44)
        let region45=document.createElement('option')
        region45.value='45'
        region45.text='Курганская область'
        regionsSelect.add(region45)
        let region46=document.createElement('option')
        region46.value='46'
        region46.text='Курская область'
        regionsSelect.add(region46)
        let region47=document.createElement('option')
        region47.value='47'
        region47.text='Ленинградская область'
        regionsSelect.add(region47)
        let region48=document.createElement('option')
        region48.value='48'
        region48.text='Липецкая область'
        regionsSelect.add(region48)
        let region49=document.createElement('option')
        region49.value='49'
        region49.text='Магаданская область'
        regionsSelect.add(region49)
        let region50=document.createElement('option')
        region50.value='50'
        region50.text='Московская область'
        regionsSelect.add(region50)
        let region51=document.createElement('option')
        region51.value='51'
        region51.text='Мурманская область'
        regionsSelect.add(region51)
        let region52=document.createElement('option')
        region52.value='52'
        region52.text='Нижегородская область'
        regionsSelect.add(region52)
        let region53=document.createElement('option')
        region53.value='53'
        region53.text='Новгородская область'
        regionsSelect.add(region53)
        let region54=document.createElement('option')
        region54.value='54'
        region54.text='Новосибирская область'
        regionsSelect.add(region54)
        let region55=document.createElement('option')
        region55.value='55'
        region55.text='Омская область'
        regionsSelect.add(region55)
        let region56=document.createElement('option')
        region56.value='56'
        region56.text='Оренбургская область'
        regionsSelect.add(region56)
        let region57=document.createElement('option')
        region57.value='57'
        region57.text='Орловская область'
        regionsSelect.add(region57)
        let region58=document.createElement('option')
        region58.value='58'
        region58.text='Пензенская область'
        regionsSelect.add(region58)
        let region59=document.createElement('option')
        region59.value='59'
        region59.text='Пермский край'
        regionsSelect.add(region59)
        let region60=document.createElement('option')
        region60.value='60'
        region60.text='Псковская область'
        regionsSelect.add(region60)
        let region61=document.createElement('option')
        region61.value='61'
        region61.text='Ростовская область'
        regionsSelect.add(region61)
        let region62=document.createElement('option')
        region62.value='62'
        region62.text='Рязанская область'
        regionsSelect.add(region62)
        let region63=document.createElement('option')
        region63.value='63'
        region63.text='Самарская область'
        regionsSelect.add(region63)
        let region64=document.createElement('option')
        region64.value='64'
        region64.text='Саратовская область'
        regionsSelect.add(region64)
        let region65=document.createElement('option')
        region65.value='65'
        region65.text='Сахалинская область'
        regionsSelect.add(region65)
        let region66=document.createElement('option')
        region66.value='66'
        region66.text='Свердловская область'
        regionsSelect.add(region66)
        let region67=document.createElement('option')
        region67.value='67'
        region67.text='Смоленская область'
        regionsSelect.add(region67)
        let region68=document.createElement('option')
        region68.value='68'
        region68.text='Тамбовская область'
        regionsSelect.add(region68)
        let region69=document.createElement('option')
        region69.value='69'
        region69.text='Тверская область'
        regionsSelect.add(region69)
        let region70=document.createElement('option')
        region70.value='70'
        region70.text='Томская область'
        regionsSelect.add(region70)
        let region71=document.createElement('option')
        region71.value='71'
        region71.text='Тульская область'
        regionsSelect.add(region71)
        let region72=document.createElement('option')
        region72.value='72'
        region72.text='Тюменская область'
        regionsSelect.add(region72)
        let region73=document.createElement('option')
        region73.value='73'
        region73.text='Ульяновская область'
        regionsSelect.add(region73)
        let region74=document.createElement('option')
        region74.value='74'
        region74.text='Челябинская область'
        regionsSelect.add(region74)
        let region75=document.createElement('option')
        region75.value='75'
        region75.text='Забайкальский край'
        regionsSelect.add(region75)
        let region76=document.createElement('option')
        region76.value='76'
        region76.text='Ярославская область'
        regionsSelect.add(region76)
        let region77=document.createElement('option')
        region77.value='77'
        region77.text='Москва'
        regionsSelect.add(region77)
        let region78=document.createElement('option')
        region78.value='78'
        region78.text='Санкт-Петербург'
        regionsSelect.add(region78)
        let region79=document.createElement('option')
        region79.value='79'
        region79.text='Еврейская автономная область'
        regionsSelect.add(region79)
        let region82=document.createElement('option')
        region82.value='82'
        region82.text='Республика Крым'
        regionsSelect.add(region82)
        let region83=document.createElement('option')
        region83.value='83'
        region83.text='Ненецкий автономный округ'
        regionsSelect.add(region83)
        let region86=document.createElement('option')
        region86.value='86'
        region86.text='Ханты-Мансийский автономный округ — Югра'
        regionsSelect.add(region86)
        let region87=document.createElement('option')
        region87.value='87'
        region87.text='Чукотский автономный округ'
        regionsSelect.add(region87)
        let region89=document.createElement('option')
        region89.value='89'
        region89.text='Ямало-Ненецкий автономный округ'
        regionsSelect.add(region89)
        let region92=document.createElement('option')
        region92.value='92'
        region92.text='г. Севастополь'
        regionsSelect.add(region92)
        let region94=document.createElement('option')
        region94.value='94'
        region94.text='Территории, находящиеся за пределами РФ и обслуживаемые Департаментом режимных объектов МВД России'
        regionsSelect.add(region94)
        let region95=document.createElement('option')
        region95.value='95'
        region95.text='Чеченская республика'
        regionsSelect.add(region95)
        regionsLabel.appendChild(regionsSelect)


        table.appendChild(regionsLabel)

        let button=document.createElement('button')
        button.addEventListener('click',()=>{
            updateAgency(users[0].id,
                document.getElementById('nameChange').value,
                document.getElementById('descriptionChange').value,
                document.getElementById('phoneNumberChange').value,
                document.getElementById('linkOnWebsiteChange').value)
        })

        button.textContent='Change'
        table.appendChild(button)

    })
}


function updateAgency(id,name,description,phoneNumber,linkOnWebsite,regionsList){
    var regionsOfAgency=[]
    for (var option of document.getElementById("regionsUpdate").options) {
        if(option.selected){
            regionsOfAgency.push(option.value)
        }
    }
    if(name==='' || description==='' || phoneNumber==='' || linkOnWebsite==='' || regionsOfAgency.length===0){
        alert('Please fill all labels')
        return
    }

    let body={
        "id":id,
        "name":name,
        "description":description,
        "phoneNumber":phoneNumber,
        "linkOnWebsite":linkOnWebsite,
        "regionsList": regionsOfAgency
    }
    console.log(regionsOfAgency)
    console.log(id)
    fetch('/tool/update',{
        method:'POST',
        headers:{
            'AUTHORIZATION': localStorage.getItem('accessToken'),
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    })
    alert('Agency succesfull changed')
}
