<#macro menu>
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
</#macro>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta charset="UTF-8">
    <title>Title</title>

    <script src="/static/js/advertisement.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</head>
<body>
<#--<nav class="navbar navbar-expand-lg navbar-light bg-light">-->
<#--    <a class="navbar-brand" href="/">CIAN</a>-->

<#--    <div class="collapse navbar-collapse" id="navbarSupportedContent">-->
<#--        <ul class="navbar-nav mr-auto">-->
<#--            <li class="nav-item active">-->
<#--                &lt;#&ndash;                <a class="nav-link" href="/residentialComplexes">Residential complex <span class="sr-only">(current)</span></a>&ndash;&gt;-->
<#--                <a class="nav-link" href="/residentialComplexes">Residential complex</a>-->
<#--            </li>-->
<#--            <li class="nav-item">-->
<#--                <a class="nav-link" href="/users">Users</a>-->
<#--            </li>-->
<#--            <li class="nav-item">-->
<#--                <a class="nav-link" href="/agents">Agents</a>-->
<#--            </li>-->
<#--            <li class="nav-item">-->
<#--                <a class="nav-link" href="/agencys">Agencies</a>-->
<#--            </li>-->
<#--            <li class="nav-item">-->
<#--                <a class="nav-link" href="/loginPage">Log in</a>-->
<#--            </li>-->
<#--        </ul>-->
<#--    </div>-->
<#--</nav>-->
<@menu/>
<label>Realty
    <select id="realtyType" name="realtyType">
        <option value="newFlat">new flat</option>
        <option value="secondaryFlat">secondary flat</option>
        <option value="house">house</option>
    </select>
</label>
<label>Deal type
    <select id="rentOrBuy" name="rentOrBuy">
        <option value="PERMANENT">buy</option>
        <option value="Year">rentYear</option>
        <option value="Month">rentMonth</option>
        <option value="Day">rentDay</option>
    </select>
</label>
<label>Square
    <input id="squareFrom" name="squareFrom" type="text">
    <input id="squareTo" name="squareTo" type="text">
</label>
<label>Cost
    <input id="costFrom" name="costFrom" type="text">
    <input id="costTo" name="costTo" type="text">
</label>
<button onclick="searchAdvertisement(
    document.getElementById('rentOrBuy').value,
document.getElementById('realtyType').value,
document.getElementById('squareFrom').value,
document.getElementById('squareTo').value,
document.getElementById('costFrom').value,
document.getElementById('costTo').value)">Find
</button>

<table id="advertisements" class="table table-striped">

</table>
<script>searchAdvertisement(
        '${rentOrBuy}',
        '${realtyType}',
        ${squareFrom},
        ${squareTo},
        ${costFrom},
        ${costTo}
    )</script>

</body>
</html>