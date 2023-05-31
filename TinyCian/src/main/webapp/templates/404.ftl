<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cosmotema 404 - 404 | page not found</title>
    <link rel="shortcut icon" type="image/png" href="#">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&family=Roboto&family=Playfair+Display&display=swap");

        html {
            scroll-behavior: smooth;
        }

        body {
            font-family: "Roboto", sans-serif;
            color: #6f6f6f;
            font-size: 16px;
            padding: 0;
            margin: 0;
            font-weight: 400;
            position: relative;
            line-height: 1.7;
            background-color: #f8f6ff;
        }

        img {
            max-width: 100%;
            height: auto;
        }

        h1 {
            font-size: 62px;
        }

        h2 {
            font-size: 32px;
        }

        @media (max-width: 991px) {
            h2 {
                font-size: 36px;
            }
        }

        @media (max-width: 575px) {
            h2 {
                font-size: 28px;
            }
        }

        h3 {
            font-size: 24px;
        }

        h4 {
            font-size: 22px;
        }

        @media (max-width: 767px) {
            h4 {
                font-size: 20px;
            }
        }

        h5 {
            font-size: 20px;
        }

        @media (max-width: 767px) {
            h5 {
                font-size: 18px;
            }
        }

        h6 {
            font-size: 18px;
        }

        h1,
        h2,
        h3,
        h4,
        h5,
        h6 {
            font-family: "Poppins", sans-serif;
            color: #525252;
            font-weight: 600;
            margin: 0;
            line-height: 1.4;
        }

        h1>a,
        h2>a,
        h3>a,
        h4>a,
        h5>a,
        h6>a {
            font-family: "Poppins", sans-serif;
            color: #525252;
            font-weight: 600;
            -webkit-transition: all 0.3s;
            -o-transition: all 0.3s;
            transition: all 0.3s;
            line-height: 1.4;
        }

        p,
        li,
        span {
            margin: 0;
        }

        a {
            text-decoration: none;
            display: inline-block;
            font-family: "Roboto", sans-serif;
            font-weight: 400;
        }

        a:hover {
            text-decoration: none;
        }

        .cmn-btn {
            padding: 12px 35px;
            text-transform: uppercase;
            border-radius: 5px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            -ms-border-radius: 5px;
            -o-border-radius: 5px;
            background-color: #6e41ff;
            box-shadow: 0px 10px 20px 0px rgba(0, 0, 0, 0.15);
            -webkit-transition: all 0.3s;
            -o-transition: all 0.3s;
            transition: all 0.3s;
            color: #ffffff;
        }

        .cmn-btn:hover {
            color: #ffffff;
            background-color: #5b28ff;
        }

        .error {
            position: relative;
            padding: 120px 0;
        }

        .error .title {
            font-size: 42px;
            margin-top: 30px;
            margin-bottom: 15px;
        }

        @media (max-width: 480px) {
            .error .title {
                font-size: 32px;
            }
        }

        .error .title b {
            font-size: 72px;
            color: #f45570;
        }

        .error p {
            font-size: 18px;
        }
    </style>
</head>
<body>


<div class="error">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-7 text-center">
                <img src="/static/img/error-404.png" alt="image 404">
                <h2><b>404</b> Страница не найдена</h2>
                <p>посетите главную страницу <br> возможно вы найдёте её</p>
                <a href="/" class="cmn-btn mt-4">На главную</a>
            </div>
        </div>
    </div>
</div>


</body>
</html>