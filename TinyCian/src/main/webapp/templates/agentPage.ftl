<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta charset="UTF-8">

    <title>Title</title>
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
<div style="padding-top: 260px">
    <img style="display: block;margin: 0 auto" id="avatar" width="60px" height="60px" src="/file/downloadFile?id=${user.logo}">
    <h3 style="text-align: center">${user.firstName} ${user.lastName} ${user.patronymic}</h3>
    <h3 style="text-align: center">Contacts:</h3>
    <p style="text-align: center">Phone: ${user.phone}</p>
    <p style="text-align: center">Email:${user.login}</p>
    <h3 style="text-align: center">Organisation:</h3>
    <p style="text-align: center">${user.organisation.name}</p>
</div>

</body>
</html>