<html>
<head>
    <meta charset="UTF-8">
    <title>Note managing app</title>
    <link href="styles/styles.css" rel="stylesheet"/>
    <script src="scripts/scripts.js" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" defer></script>
</head>
<body>



<div>
    <form name="f" action="/signin" method="post">
    <fieldset>
    <label for="" class="modal__label">login: </label>
    <input type="text" class="modal__input" name="login" id="login" required>
    <label for="" class="modal__label">password: </label>
    <input type="text" class="modal__input" name="password" id="password" required>
        <div class="form-check">
            <input type="checkbox"  id="remember-me" name="remember-me">
            <label class="form-check-label" for="remember-me">Remember me?</label>
        </div>
    <input type="submit" value="Login" class="modal__button-submit" >Log in</input>
    <button type="button" value="SignUp" class="modal__button-submit" onclick="showSignUpModal()">Sign up</button>
    </fieldset>
    </form>
</div>
<div class="signUpModal modal modal--hidden">
    <form id="signUpForm" class="modal__form" action="/add-user" method="post" name="user">
        <button class="modal__button-close" data-button-close type="button" aria-label="Close form" onclick="closeSignUpModal()">
            <span aria-hidden="true">&times;</span>
        </button>
        <label for="" class="modal__label">Enter login: </label>
        <input type="text" class="modal__input" name="username" id="signUpLogin" required>
        <label for="" class="modal__label">Enter email: </label>
        <input type="text" class="modal__input" name="email" id="signUpEmail" required>
        <label for="" class="modal__label">Enter password: </label>
        <input type="text" class="modal__input" name="password" id="signUpPassword" required>
        <button type="submit" value="SignUp" class="modal__button-submit" data-button-submit >Create Account</button>
    </form>
</div>




</body>
</html>