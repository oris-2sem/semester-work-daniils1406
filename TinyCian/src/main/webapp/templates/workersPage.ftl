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
<button onclick="getUserPage()">back</button>
<table class="table table-striped">
    <tr>
        <th>id</th>
        <th>birthdayDate</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>patronymic</th>
        <th>phone</th>
        <th>login</th>
        <th>agentLevel</th>
        <th>dismiss</th>
    </tr>
    <#list agentsList as agent>
        <tr>
            <th>${agent.id}</th>
            <th>${agent.birthdayDate}</th>
            <th>${agent.firstName}</th>
            <th>${agent.lastName}</th>
            <th>${agent.patronymic}</th>
            <th>${agent.phone}</th>
            <th>${agent.login}</th>
            <th>${agent.agentLevel}</th>
            <th>
                <button onclick="dismissAgent('${agent.id}')">dismiss</button>
            </th>
        </tr>
    </#list>
</table>

<label>
    <input type="text" id="agentId" name="agentId">
</label>
<button onclick="hireAgent(document.getElementById('agentId').value)">hire</button>
</body>
</html>