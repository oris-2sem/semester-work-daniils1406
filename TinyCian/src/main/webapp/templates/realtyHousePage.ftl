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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">CIAN</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/residentialComplexes">Residential complex</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/users">Users</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/agents">Agents</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/agencys">Agencies</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/loginPage">Log in</a>
            </li>
        </ul>
    </div>
</nav>
<div style="width: 30%" id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
    <div style="margin: auto; margin-left: 650px" class="carousel-inner">
        <#list imagesOfFlats as image>
            <div class="carousel-item active">
                <img style="display: block; margin: 0 auto" src="/file/downloadFile?id=${image}" class="d-block w-100">
            </div>
        </#list>
    </div>
    <button style="margin-left: 650px" class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Предыдущий</span>
    </button>
    <button style="margin-left: 1150px;position: absolute" class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Следующий</span>
    </button>
</div>

<h2 style="text-align: center">${realty.flatOrHouse}</h2>
<h3 style="text-align: center">Place:</h3>
<p style="text-align: center">Region:${realty.regions.regionName} District:${realty.district} Address: ${realty.address}</p>
<h3 style="text-align: center">Description</h3>
<p style="text-align: center">${realty.description}</p>
<h4 style="text-align: center">${realty.cost} <#if realty.currency=='EUR'>€</#if><#if realty.currency=='USD'>$</#if><#if realty.currency=='RUB'>₽</#if></h4>
<button style="margin-left: 880px" onclick="createNotification('${realty.owner.id}','${realty.id}')">Interested in</button>
<h4 style="text-align: center">Convert price</h4>
<form style="margin-left: 800px" method="post" action="/realty">
    <input type="hidden" id="id" name="id" value="${realty.id}">
    <input type="hidden" id="realtyType" name="realtyType" value="HOUSE">
    <label>To
        <select id="to" name="to">
            <option value="USD">USD</option>
            <option value="EUR">EUR</option>
            <option value="RUB">RUB</option>
        </select>
    </label>
    <label>From
        <select id="from" name="from">
            <option value="USD">USD</option>
            <option value="EUR">EUR</option>
            <option value="RUB">RUB</option>
        </select>
    </label>
    <input type="number" id="amount" name="amount">
    <button type="submit">Convert</button>
</form>
<#if result?has_content>
    <h3 style="text-align: center">Result:${result}</h3>
</#if>
</body>
</html>