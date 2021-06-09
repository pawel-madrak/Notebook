<html>
<head>
    <meta charset="UTF-8">
    <title>Note managing app</title>
    <link href="styles/styles.css" rel="stylesheet"/>
    <script src="scripts/profileScripts.js" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" defer></script>
</head>
<body>
<div>
    <div id="header">
        <h2>your notes</h2>
    </div>
    <div>
        <form  method="post" action="/logout">
            <button class="modal__button-submit" type="submit">Logout</button>
        </form>
        <a href="/notes">Notes</a>
    </div>
</div>


    <form id="editUserForm" class="modal__form" action="/profile" method="put" name="userUpdate">
        <#list model["user"] as user>
            <label for="" class="modal__label" name="profile" id="profile" >Your Profile</label>
        <label for="" class="modal__label" >Username: </label>
            <input type="text" class="modal__input" name="username" id="username" value="${user.username}" readonly>
        <label for="" class="modal__label">Email: </label>
        <input type="text" class="modal__input" name="email" id="email" value="${user.email}" required>
        <label for="" class="modal__label">Password: </label>
        <input   class="modal__input" name="password" id="password" required>
        <button type="button" value="Update" class="modal__button-submit" data-button-submit onclick="editUser()">Update</button>
        </#list>
    </form>






</body>

</html>