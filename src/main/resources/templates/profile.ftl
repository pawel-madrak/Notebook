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
    <script src="scripts/profileScripts.js" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" defer></script>
</head>
<body>
<div class="container">
    <div class="row nav">
        <div id="header" class="col-8">
            <h1><span class="badge badge-primary">Notebook</span></h1>
        </div>
        <div class="col-1">
            <a href="/notes" class="btn btn-primary">Notes</a>
        </div>
        <div class="col-1">
            <form method="post" action="/logout">
                <button class="btn btn-primary" type="submit">Logout</button>
            </form>
        </div>
    </div>
    <div class=" row">
    <div class="form--update border border-secondary rounded col-5">
            <#list model["user"] as user>
                <div class="form-group">
                    <label for=""  name="profile" id="profile">Your Profile</label>
                </div>
                <div class="form-group row">
                    <label for="" class="col-sm-2 col-form-label" >Username: </label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control-plaintext" name="username"  value="${user.username}"
                           readonly>
                        </div>
                </div>

        </#list>
                    <form id="form--edit--user" action="/profile" method="put">
                <div class="form-group row">
                    <label for="" class="col-sm-2 col-form-label">Email: </label>
                    <div class="col-sm-10">
                    <input type="email" class="form-control" name="email"  maxlength="24" required>
                        </div>
                </div>
                <div class="form-group row">
                    <label for="" class="col-sm-2 col-form-label">Password: </label>
                    <div class="col-sm-10">
                    <input type="password" class="form-control" name="password"  required minlength="6" maxlength="16">
                        </div>
                </div>
                <button type="submit" value="Update" class="btn btn-primary" data-button-submit
                        onclick="editUser()">Update
                </button>
        </form>
    </div>
    </div>
</div>
</body>

</html>