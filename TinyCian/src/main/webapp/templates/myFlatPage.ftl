<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</head>
<body>
<button class="btn btn-primary" onclick="getHousePage()">getHouses</button>
<button class="btn btn-secondary" onclick="getUserPage()">back</button>
<div>
    <h4>Create new flat</h4>
    <label>residentialComplex
        <input id="residentialComplexForCreate" name="residentialComplexForCreate">
    </label>
    <br>
    <input name="ownerId" id="ownerId" value="${userId}" type="hidden">
    <label>square
        <input id="squareForCreate" name="squareForCreate" type="number">
    </label>
    <br>
    <label>region
        <#--    <input id="regionsForCreate" name="regionsForCreate">-->
        <select id="regionsForCreate" name="regionsForCreate">
            <option value="1">Республика Адыгея</option>
            <option value="2">Республика Башкортостан</option>
            <option value="3">Республика Бурятия</option>
            <option value="4">Республика Алтай (Горный Алтай)</option>
            <option value="5">Республика Дагестан</option>
            <option value="6">Республика Ингушетия</option>
            <option value="7">Кабардино-Балкарская Республика</option>
            <option value="8">Республика Калмыкия</option>
            <option value="9">Республика Карачаево-Черкессия</option>
            <option value="10">Республика Карелия</option>
            <option value="11">Республика Коми</option>
            <option value="12">Республика Марий Эл</option>
            <option value="13">Республика Мордовия</option>
            <option value="14">Республика Саха (Якутия)</option>
            <option value="15">Республика Северная Осетия — Алания</option>
            <option value="16">Республика Татарстан</option>
            <option value="17">Республика Тыва</option>
            <option value="18">Удмуртская Республика</option>
            <option value="19">Республика Хакасия</option>
            <option value="21">Чувашская Республика</option>
            <option value="22">Алтайский край</option>
            <option value="23">Краснодарский край</option>
            <option value="24">Красноярский край</option>
            <option value="25">Приморский край</option>
            <option value="26">Ставропольский край</option>
            <option value="27">Хабаровский край</option>
            <option value="28">Амурская область</option>
            <option value="29">Архангельская область</option>
            <option value="30">Астраханская область</option>
            <option value="31">Белгородская область</option>
            <option value="32">Брянская область</option>
            <option value="33">Владимирская область</option>
            <option value="34">Волгоградская область</option>
            <option value="35">Вологодская область</option>
            <option value="36">Воронежская область</option>
            <option value="37">Ивановская область</option>
            <option value="38">Иркутская область</option>
            <option value="39">Калининградская область</option>
            <option value="40">Калужская область</option>
            <option value="41">Камчатский край</option>
            <option value="42">Кемеровская область</option>
            <option value="43">Кировская область</option>
            <option value="44">Костромская область</option>
            <option value="45">Курганская область</option>
            <option value="46">Курская область</option>
            <option value="47">Ленинградская область</option>
            <option value="48">Липецкая область</option>
            <option value="49">Магаданская область</option>
            <option value="50">Московская область</option>
            <option value="51">Мурманская область</option>
            <option value="52">Нижегородская область</option>
            <option value="53">Новгородская область</option>
            <option value="54">Новосибирская область</option>
            <option value="55">Омская область</option>
            <option value="56">Оренбургская область</option>
            <option value="57">Орловская область</option>
            <option value="58">Пензенская область</option>
            <option value="59">Пермский край</option>
            <option value="60">Псковская область</option>
            <option value="61">Ростовская область</option>
            <option value="62">Рязанская область</option>
            <option value="63">Самарская область</option>
            <option value="64">Саратовская область</option>
            <option value="65">Сахалинская область</option>
            <option value="66">Свердловская область</option>
            <option value="67">Смоленская область</option>
            <option value="68">Тамбовская область</option>
            <option value="69">Тверская область</option>
            <option value="70">Томская область</option>
            <option value="71">Тульская область</option>
            <option value="72">Тюменская область</option>
            <option value="73">Ульяновская область</option>
            <option value="74">Челябинская область</option>
            <option value="75">Забайкальский край</option>
            <option value="76">Ярославская область</option>
            <option value="77">Москва</option>
            <option value="78">Санкт-Петербург</option>
            <option value="79">Еврейская автономная область</option>
            <option value="82">Республика Крым</option>
            <option value="83">Ненецкий автономный округ</option>
            <option value="86">Ханты-Мансийский автономный округ — Югра</option>
            <option value="87">Чукотский автономный округ</option>
            <option value="89">Ямало-Ненецкий автономный округ</option>
            <option value="92">г. Севастополь</option>
            <option value="94">Территории, находящиеся за пределами РФ и обслуживаемые Департаментом режимных объектов
                МВД
                России
            </option>
            <option value="95">Чеченская республика</option>
        </select>
    </label>
    <br>
    <label>district
        <input id="districtForCreate" name="districtForCreate">
    </label>
    <br>
    <label>address
        <input id="addressForCreate" name="addressForCreate">
    </label>
    <br>
    <label>description
        <input id="descriptionForCreate" name="descriptionForCreate">
    </label>
    <br>
    <label>advertType
        <select id="advertTypeForCreate" name="advertTypeForCreate">
            <option value="PERMANENT">PERMANENT</option>
            <option value="MONTH">MONTH</option>
            <option value="DAY">DAY</option>
            <option value="YEAR">YEAR</option>
        </select>
    </label>
    <br>
    <label>cost
        <input id="costForCreate" name="costForCreate" type="number">
    </label>
    <br>
    <label>releaseDate
        <input type="date" id="releaseDateForCreate" name="releaseDateForCreate">
    </label>
    <br>
    <label>numberOfRooms
        <input id="numberOfRoomsForCreate" name="numberOfRoomsForCreate" type="number">
    </label>
    <br>
    <label>level
        <input id="levelForCreate" name="levelForCreate" type="number">
    </label>
    <br>
    <label>kitchenSquare
        <input id="kitchenSquareForCreate" name="kitchenSquareForCreate" type="number">
    </label>
    <br>
    <label>livingSquare
        <input id="livingSquareForCreate" name="livingSquareForCreate" type="number">
    </label>
    <br>
    <label>realtyType
        <select id="realtyTypeForCreate" name="realtyTypeForCreate">
            <option value="NEW">NEW</option>
            <option value="SECONDARY">SECONDARY</option>
        </select>
    </label>
    <label>currency
        <select id="currency" name="currency">
            <option value="EUR">EUR</option>
            <option value="RUB">RUB</option>
            <option value="USD">USD</option>
        </select>
    </label>
    <br>
    <button class="btn btn-info" onclick="createFlat(document.getElementById('residentialComplexForCreate').value,
document.getElementById('squareForCreate').value,
document.getElementById('regionsForCreate').value,
document.getElementById('districtForCreate').value,
document.getElementById('addressForCreate').value,
document.getElementById('descriptionForCreate').value,
document.getElementById('advertTypeForCreate').value,
document.getElementById('costForCreate').value,
document.getElementById('releaseDateForCreate').value,
document.getElementById('numberOfRoomsForCreate').value,
document.getElementById('levelForCreate').value,
document.getElementById('kitchenSquareForCreate').value,
document.getElementById('livingSquareForCreate').value,
document.getElementById('realtyTypeForCreate').value,
document.getElementById('ownerId').value,
document.getElementById('currency').value
)">CreateFlat
    </button>
</div>
<table border="1" class="table table-striped">
    <#list realtyList as realty>
        <tr>
            <td>
                <h3>${realty.id}</h3>
                <#--                <#list imagesOfFlats as listOfImage>-->
                <#if imagesOfFlats[realty?index]?has_content>
                    <#list imagesOfFlats[realty?index] as image>
                        <img onclick="deleteViewFlat('${image}')" src="/file/downloadFile?id=${image}" width="15%">
                    </#list>
                </#if>
                <#--                </#list>-->
            </td>
            <td>
                <h5>Add new view</h5>
                <input type="file" id="view${realty.id}">
                <button onclick="addViewFlat(
                        '${realty.id}',
                        'FLAT',
                        document.getElementById('view${realty.id}').files,
                        'VIEW'
                        )">
                    Add new image
                </button>
            </td>
        </tr>
        <tr>
            <td>
                <input id="id${realty.id}" name="id${realty.id}" value="${realty.id}" type="hidden">
                <input id="residentialComplex${realty.id}" name="residentialComplex" type="hidden"
                       value="${realty.residentialComplex.id}">
                <input id="owner${realty.id}" name="owner" value="${realty.owner.id}" type="hidden">
                <label>square
                    <input id="square${realty.id}" name="square" value="${realty.square}" type="number">
                </label>
                <label>region
                    <select id="region${realty.id}" name="region">
                        <option value="1">Республика Адыгея</option>
                        <option value="2">Республика Башкортостан</option>
                        <option value="3">Республика Бурятия</option>
                        <option value="4">Республика Алтай (Горный Алтай)</option>
                        <option value="5">Республика Дагестан</option>
                        <option value="6">Республика Ингушетия</option>
                        <option value="7">Кабардино-Балкарская Республика</option>
                        <option value="8">Республика Калмыкия</option>
                        <option value="9">Республика Карачаево-Черкессия</option>
                        <option value="10">Республика Карелия</option>
                        <option value="11">Республика Коми</option>
                        <option value="12">Республика Марий Эл</option>
                        <option value="13">Республика Мордовия</option>
                        <option value="14">Республика Саха (Якутия)</option>
                        <option value="15">Республика Северная Осетия — Алания</option>
                        <option value="16">Республика Татарстан</option>
                        <option value="17">Республика Тыва</option>
                        <option value="18">Удмуртская Республика</option>
                        <option value="19">Республика Хакасия</option>
                        <option value="21">Чувашская Республика</option>
                        <option value="22">Алтайский край</option>
                        <option value="23">Краснодарский край</option>
                        <option value="24">Красноярский край</option>
                        <option value="25">Приморский край</option>
                        <option value="26">Ставропольский край</option>
                        <option value="27">Хабаровский край</option>
                        <option value="28">Амурская область</option>
                        <option value="29">Архангельская область</option>
                        <option value="30">Астраханская область</option>
                        <option value="31">Белгородская область</option>
                        <option value="32">Брянская область</option>
                        <option value="33">Владимирская область</option>
                        <option value="34">Волгоградская область</option>
                        <option value="35">Вологодская область</option>
                        <option value="36">Воронежская область</option>
                        <option value="37">Ивановская область</option>
                        <option value="38">Иркутская область</option>
                        <option value="39">Калининградская область</option>
                        <option value="40">Калужская область</option>
                        <option value="41">Камчатский край</option>
                        <option value="42">Кемеровская область</option>
                        <option value="43">Кировская область</option>
                        <option value="44">Костромская область</option>
                        <option value="45">Курганская область</option>
                        <option value="46">Курская область</option>
                        <option value="47">Ленинградская область</option>
                        <option value="48">Липецкая область</option>
                        <option value="49">Магаданская область</option>
                        <option value="50">Московская область</option>
                        <option value="51">Мурманская область</option>
                        <option value="52">Нижегородская область</option>
                        <option value="53">Новгородская область</option>
                        <option value="54">Новосибирская область</option>
                        <option value="55">Омская область</option>
                        <option value="56">Оренбургская область</option>
                        <option value="57">Орловская область</option>
                        <option value="58">Пензенская область</option>
                        <option value="59">Пермский край</option>
                        <option value="60">Псковская область</option>
                        <option value="61">Ростовская область</option>
                        <option value="62">Рязанская область</option>
                        <option value="63">Самарская область</option>
                        <option value="64">Саратовская область</option>
                        <option value="65">Сахалинская область</option>
                        <option value="66">Свердловская область</option>
                        <option value="67">Смоленская область</option>
                        <option value="68">Тамбовская область</option>
                        <option value="69">Тверская область</option>
                        <option value="70">Томская область</option>
                        <option value="71">Тульская область</option>
                        <option value="72">Тюменская область</option>
                        <option value="73">Ульяновская область</option>
                        <option value="74">Челябинская область</option>
                        <option value="75">Забайкальский край</option>
                        <option value="76">Ярославская область</option>
                        <option value="77">Москва</option>
                        <option value="78">Санкт-Петербург</option>
                        <option value="79">Еврейская автономная область</option>
                        <option value="82">Республика Крым</option>
                        <option value="83">Ненецкий автономный округ</option>
                        <option value="86">Ханты-Мансийский автономный округ — Югра</option>
                        <option value="87">Чукотский автономный округ</option>
                        <option value="89">Ямало-Ненецкий автономный округ</option>
                        <option value="92">г. Севастополь</option>
                        <option value="94">Территории, находящиеся за пределами РФ и обслуживаемые Департаментом
                            режимных объектов МВД
                            России
                        </option>
                        <option value="95">Чеченская республика</option>
                    </select>
                </label>
                <label>district
                    <input id="district${realty.id}" name="district" value="${realty.district}">
                </label>
                <label>address
                    <input id="address${realty.id}" name="address" value="${realty.address}">
                </label>
                <label>description
                    <input id="description${realty.id}" name="description" value="${realty.description}">
                </label>
                <label>advertType
                    <select id="advertType${realty.id}" name="advertType">
                        <option value="PERMANENT">PERMANENT</option>
                        <option value="MONTH">MONTH</option>
                        <option value="DAY">DAY</option>
                        <option value="YEAR">YEAR</option>
                    </select>
                </label>
                <label>cost
                    <input id="cost${realty.id}" name="cost" value="${realty.cost}" type="number">
                </label>
                <input id="flatOrHouse${realty.id}" name="flatOrHouse" value="${realty.flatOrHouse}" type="hidden">
                <label>releaseDate
                    <input id="releaseDate${realty.id}" name="releaseDate" value="${realty.releaseDate}" type="date">
                </label>
                <label>numberOfRooms
                    <input id="numberOfRooms${realty.id}" name="numberOfRooms" value="${realty.numberOfRoom}"
                           type="number">
                </label>
                <label>level
                    <input id="level${realty.id}" name="level" value="${realty.level}" type="number">
                </label>
                <label>kitchenSquare
                    <input id="kitchenSquare${realty.id}" name="kitchenSquare" value="${realty.kitchenSquare}"
                           type="number">
                </label>
                <label>livingSquare
                    <input id="livingSquare${realty.id}" name="livingSquare" value="${realty.livingSquare}"
                           type="number">
                </label>
                <label>realtyType
                    <select id="realtyType${realty.id}" name="realtyType">
                        <option value="NEW">NEW</option>
                        <option value="SECONDARY">SECONDARY</option>
                    </select>
                </label>
                <label>currency
                    <select id="currency${realty.id}" name="currency">
                        <option value="EUR">EUR</option>
                        <option value="RUB">RUB</option>
                        <option value="USD">USD</option>
                    </select>
                </label>
            </td>
            <td>
                <button class="btn btn-outline-primary" onclick="changeFlat(
                        document.getElementById('id${realty.id}').value,
                        document.getElementById('residentialComplex${realty.id}').value,
                        document.getElementById('square${realty.id}').value,
                        document.getElementById('region${realty.id}').value,
                        document.getElementById('district${realty.id}').value,
                        document.getElementById('address${realty.id}').value,
                        document.getElementById('description${realty.id}').value,
                        document.getElementById('advertType${realty.id}').value,
                        document.getElementById('cost${realty.id}').value,
                        document.getElementById('releaseDate${realty.id}').value,
                        document.getElementById('numberOfRooms${realty.id}').value,
                        document.getElementById('level${realty.id}').value,
                        document.getElementById('kitchenSquare${realty.id}').value,
                        document.getElementById('livingSquare${realty.id}').value,
                        document.getElementById('realtyType${realty.id}').value,
                        document.getElementById('owner${realty.id}').value,
                        document.getElementById('currency${realty.id}').value
                        )">ChangeRealty
                </button>
                <br>
                <button class="btn btn-outline-danger" onclick="deleteFlat(document.getElementById('id${realty.id}').value)">DeleteRealty</button>
                <br>
                <button class="btn btn-outline-secondary" onclick="hideFlat(document.getElementById('id${realty.id}').value)">hide</button>
                <br>
                <button class="btn btn-outline-info" onclick="showFlat(document.getElementById('id${realty.id}').value)">show</button>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>