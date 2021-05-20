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
    <label for="" class="modal__label">login: </label>
    <input type="text" class="modal__input" name="login" id="login" required>
    <label for="" class="modal__label">password: </label>
    <input type="text" class="modal__input" name="password" id="password" required>
    <button type="button" value="Login" class="modal__button-submit" >Log in</button>
    <button type="button" value="SignUp" class="modal__button-submit" onclick="showSignUpModal()">Sign up</button>
</div>
<div class="signUpModal modal modal--hidden">
    <form id="signUpForm" class="modal__form" action="/login" method="post" name="user">
        <button class="modal__button-close" data-button-close type="button" aria-label="Close form" onclick="closeSignUpModal()">
            <span aria-hidden="true">&times;</span>
        </button>
        <label for="" class="modal__label">Enter login: </label>
        <input type="text" class="modal__input" name="signUpTitle" id="signUpTitle" required>
        <label for="" class="modal__label">Enter password: </label>
        <input type="text" class="modal__input" name="signUpPassword" id="signUpPassword" required>
        <button type="button" value="SignUp" class="modal__button-submit" data-button-submit >Create Account</button>
    </form>
</div>




</body>
</html>