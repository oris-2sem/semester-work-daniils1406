<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="/static/js/workers.js"></script>
    <script src="/static/js/flatList.js"></script>
    <script src="/static/js/houseList.js"></script>
    <script src="/static/js/account.js"></script>
    <script src="/static/js/notification.js"></script>
    <link href="/static/css/change.css" rel="stylesheet">
    <style>
        li:hover{
            background-color: dimgrey;
            border-radius: 10px;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">CIAN</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#--            <li class="nav-item active">-->
            <#--                <a class="nav-link" href="/residentialComplexes">Residential complex</a>-->
            <#--            </li>-->
            <li class="nav-item">
                <a class="nav-link" onclick="getFlatPage()">Realty list</a>
            </li>
            <#if user.role=="REPRESENTATIVE">
                <li class="nav-item">
                    <a class="nav-link" onclick="getWorkersPage()">Workers list</a>
                </li>
            </#if>
            <#if user.role=="ADMIN">
                <li class="nav-item">
                    <a class="nav-link" onclick="getAdminPage()">Information</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" onclick="getToolPage()">Add information</a>
                </li>
            </#if>
            <li class="nav-item">
                <a class="nav-link" onclick="location.replace('/')">Main menu</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" onclick="logout()">Exit</a>
            </li>
        </ul>
    </div>
</nav>

<h4 style="text-align: center">Hello ${user.firstName}</h4>

<h6 style="text-align: center">Your avatar:</h6>
<div style="margin-left: 650px">
    <img style=" margin-left: 235px;display: block" id="avatar" width="8%" src="/file/downloadFile?id=${user.logo}">
    <br>
    <input class="btn btn-secondary" type="file" id="newAvatar"/>
    <button class="btn btn-info" onclick="uploadImage(
            '${user.id}',
            'USER',
            document.getElementById('newAvatar').files,
            'LOGO'
            )">Upload new image
    </button>
</div>


<#--<h4>Your data:</h4>-->
<#--<div style="margin-left: 30px; border: black; background-color: cornflowerblue; border-radius: 20px">-->
<div class="form">
    <div class="title">Your data</div>
    <div class="subtitle">Change something in any time</div>
    <h5 style="color: white">ID:<br>${user.id}</h5>
    <input type="hidden" id="id" name="id" value="${user.id}">
    <div class="input-container ic2">
        <label>birthdayDate
            <input class="input" type="date" id="birthdayDate" name="birthdayDate" value="${user.birthdayDate}"
                   placeholder="">
        </label>
    </div>

    <div class="input-container ic2">
        <label>firstName
            <input class="input" type="text" id="firstName" name="firstName" value="${user.firstName}">
        </label>
    </div>
    <div class="input-container ic2">
        <label>lastName
            <input class="input" type="text" id="lastName" name="lastName" value="${user.lastName}">
        </label>
    </div>
    <div class="input-container ic2">
        <label>patronymic
            <input class="input" type="text" id="patronymic" name="patronymic" value="${user.patronymic}">
        </label>
    </div>
    <div class="input-container ic2">
        <label>phone
            <input class="input" type="text" id="phone" name="phone" value="${user.phone}">
        </label>
    </div>
    <div class="input-container ic2">
        <label>login
            <input class="input" type="text" id="login" name="login" value="${user.login}">
        </label>
    </div>

    <button style="margin: auto" class="btn btn-success" onclick="changeUser(
    document.getElementById('birthdayDate').value,
    document.getElementById('firstName').value,
    document.getElementById('lastName').value,
    document.getElementById('patronymic').value,
    document.getElementById('phone').value,
    document.getElementById('login').value
)">Change data
    </button>
    <h6></h6>
    <div class="input-container ic2">
    <label>newPassword
        <input class="input" type="text" id="newPassword" name="newPassword">
    </label>
    </div>

    <button class="btn btn-success" onclick="changePassword(
    document.getElementById('login').value,
document.getElementById('newPassword').value)">changePassword
    </button>
    <br>
</div>


<ul>
    <#list notifications as notification>
        <li>User with id <a href="/user?id=${notification.client.id}">${notification.client.id}</a> interested in
            realty ${notification.realty.address}</li>
        <button onclick="deleteNotification('${notification.id}')">delete</button>
    </#list>
</ul>

<button class="btn btn-primary" onclick="showDeleteNotification('${user.id}')">show archive</button>
<ul id="archive">

</ul>
</body>
</html>