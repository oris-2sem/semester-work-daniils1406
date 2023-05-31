<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta charset="UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <title>Title</title>
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
<div style="padding-top: 260px">
    <h2 style="text-align: center">${agency.name}</h2>
    <h3 style="text-align: center">Description:</h3>
    <p style="text-align: center">${agency.description}</p>
    <h3 style="text-align: center">Contacts </h3>
    <p style="text-align: center">Phone:${agency.phoneNumber}</p>
    <p style="text-align: center">Website: <a style="text-align: center" href="${agency.linkOnWebsite}" rel="noopener noreferrer">${agency.linkOnWebsite}</a></p>
    <h4 style="text-align: center">In cian since: ${agency.insertDate}</h4>
</div>
</body>
</html>