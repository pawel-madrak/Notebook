<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Note managing app</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"
            defer></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"
            defer></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"
            defer></script>
    <link href="styles/styles.css" rel="stylesheet"/>
    <script src="scripts/loginScripts.js" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" defer></script>
</head>
<body>

<div class="header--login">
    <h1>Welcome to Your <span class="badge badge-primary">Notebook </span></h1>
    <h4>Please sign-in to get started!</h4>
</div>

<div class="form--sign--in border border-secondary rounded">
    <form name="f" action="/signin" method="post">
        <div class="form-group ">
            <label for="login">Login: </label>
            <input type="text" class="form-control" name="login" id="login" aria-describedby="emailHelp"
                   placeholder="Enter login" required>
        </div>
        <div class="form-group">
            <label for="password">Password: </label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
            <small id="emailHelp" class="form-text text-muted">We'll never share your password with anyone else.</small>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="remember-me" name="remember-me">
            <label class="form-check-label" for="remember-me">Remember me?</label>
        </div>
        <input type="submit" value="Login" class="btn btn-primary">
        <button type="button" value="SignUp" class="btn btn-primary" onclick="showSignUpModal()">Sign up</button>
    </form>
</div>
<div class="modal--sign--up modal modal--hidden">
    <form class="modal__form" action="/add-user" method="post" name="new-user">
        <button class="modal__button-close" data-button-close type="button" aria-label="Close form"
                onclick="closeSignUpModal()">
            <span aria-hidden="true">&times;</span>
        </button>
        <label for="">Enter login: </label>
        <input type="text" class="form-control" name="username" id="signUpLogin" required maxlength="16">
        <label for="">Enter email: </label>
        <input type="email" class="form-control" name="email" id="signUpEmail" required maxlength="24">
        <label for="">Enter password: </label>
        <input type="password" class="form-control" name="password" id="signUpPassword" required minlength="6" maxlength="16">
        <button type="submit" value="SignUp" class="modal__button-submit btn--primary--sign--up" data-button-submit>Create
            Account
        </button>
    </form>
</div>


</body>
</html>