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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <script src="/static/js/agents.js"></script>
</head>
<body>
<@menu/>
<label>level
    <select id="level" name="level" type="text">
        <option value="STARTING">STARTING</option>
        <option value="VERIFIED">VERIFIED</option>
        <option value="EXPERIENCED">EXPERIENCED</option>
        <option value="PRO">PRO</option>
    </select>
</label>
<label>column
    <select id="column" name="column">
        <option value="id">id</option>
        <option value="LastName">Last name</option>
        <option value="createDate">Create date</option>
        <option value="birthdayDate">Birthday date</option>
    </select>
</label>
<label>order
    <select id="order" name="order">
        <option value="ASC">ASC</option>
        <option value="DESC">DESC</option>
    </select>
</label>
<button class="btn btn-info" onclick="searchAgents('VERIFIED',document.getElementById('level').value,document.getElementById('column').value,
    document.getElementById('order').value)">Find
</button>
<table id="agents" class="table table-striped">

</table>

</body>
</html>