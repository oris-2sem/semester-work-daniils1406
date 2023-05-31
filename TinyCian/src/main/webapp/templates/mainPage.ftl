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
<#--    <meta-->
<#--            http-equiv="Content-Security-Policy"-->
<#--            content="-->
<#--    default-src 'self' https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js;-->
<#--    script-src 'self' https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js;-->
<#--    connect-src 'self' https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js;-->
<#--    style-src 'self' https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js;-->
<#--  "-->
<#--    />-->
    <title>Title</title>
    <script src="/static/js/mainPage.js"></script>
    <script src="/static/js/users.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <style>
        { margin: 0; padding: 0; }

        body {
            background: url('/static/img/london-city-skyscrapers.jpg') no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }

        label{
            color: white;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<@menu/>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<h3 style="color: white; font-style: oblique; font-weight: bold; text-align: center">Find realty of your dream</h3>
<br>
<div class="text-center">
    <form action="advertisement" method="get">
    <label>Realty
        <select class="form-control" id="realtyType" name="realtyType">
            <option value="newFlat">newFlat</option>
            <option value="secondaryFlat">secondaryFlat</option>
            <option value="house">house</option>
        </select>
    </label>
    <label>Deal type
        <select class="form-control" id="rentOrBuy" name="rentOrBuy">
            <option value="PERMANENT">PERMANENT</option>
            <option value="Year">rentYear</option>
            <option value="Month">rentMonth</option>
            <option value="Day">rentDay</option>
        </select>
    </label>
    <label>Square from
        <input class="form-control" id="squareFrom" name="squareFrom" type="text">
    </label>
    <label>Square to
        <input class="form-control" id="squareTo" name="squareTo" type="text">
    </label>
    <label>Cost from
        <input class="form-control" id="costFrom" name="costFrom" type="text">
    </label>
    <label>Cost to
        <input class="form-control" id="costTo" name="costTo" type="text">
    </label>
    <span style="margin-top: 100px" class="input-group-addon"><input type="submit" value="Search"
                                                                     class="btn btn-primary"></span>
    </form>
</div>


</body>
</html>

