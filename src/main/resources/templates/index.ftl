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
    <script src="scripts/indexScripts.js" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" defer></script>
</head>
<body>
<div class="container">
    <div id="navigation" class="row nav">
        <div id="header" class="col-8">
            <h1> <span class="badge badge-primary">Notebook</span></h1>
        </div>
        <div class="col-1">
            <a href="/profile" class="btn btn-primary">Profile</a>
        </div>
        <div class="col-1">
            <form method="post" action="/logout">
                <button class="btn btn-primary" type="submit">Logout</button>
            </form>
        </div>
    </div>
    <div class="row panel--sorting">
    <label for="sorting" class="col-2">Select sorting: </label>
    <select name="sorting" id="sorting" class="form-control col-2">
        <option value="alphabetical" >Alphabetical</option>
        <option value="byImportance" >By Importance</option>
        <option value="byDate" >By Date</option>
    </select>
    </div>
    <div class="row content">
        <div class="col-2">
            <div>
                <a href="#" class="btn--add--note btn btn-primary" note-add-button onclick="showAddModal()">Add note</a>
                    <#list model["noteList"] as note>
                        <div class="note btn">
                            <p class="text text__title">${note.title}</p>
                            <p class="text">${note.context}</p>
                            <p class="js-hidden">${note.id}</p>
                            <p class="js-hidden">${note.importance}</p>
                        </div>
                    </#list>
            </div>
        </div>
        <div class="col-8 board">
            <div class="board__screen">
                <div class="board__content">
                    <h3 class="board__content__title"></h3>
                    <p class="board__content__context"></p>
                    <p class="board__content__sample">Select a note to display...</p>
                </div>
                <div class="btn--notes">
                <button class="  btn btn-danger button-del js-hidden" onclick="deleteNote()">delete</button>
                <button class="btn btn-primary button-edt js-hidden" onclick="showUpdateModal()">edit</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal--add modal modal--hidden">
    <form class="modal__form" action="/notes" method="post" name="note">
        <button class="modal__button-close" data-button-close type="button" aria-label="Close form"
                onclick="closeAddModal()">
            <span aria-hidden="true">&times;</span>
        </button>
        <label for="" >Enter title: </label>
        <input type="text" class="form-control" name="title" maxlength="40" required>
        <label for="" >Enter context: </label>
        <textarea rows="10" cols="20" class="form-control" name="context" maxlength="250"></textarea>
        <label for="importance">Select an importance: </label>
        <select name="importance" id="importance" class="form-control" required>
            <option class="option--low" value="1">Low</option>
            <option class="option--medium" value="2">Medium</option>
            <option class="option--high" value="3">High</option>
        </select>
        <button type="submit" value="Save" class="modal__button-submit" data-button-submit>Add</button>
    </form>
</div>
<div class="modal--update modal modal--hidden">
    <form id="form--edit" class="modal__form" action="/notes/" method="put" name="note">
        <button class="modal__button-close" data-button-close type="button" aria-label="Close form"
                onclick="closeUpdateModal()">
            <span aria-hidden="true">&times;</span>
        </button>
        <label for="" class="modal__label">Enter title: </label>
        <input type="text" class="form-control" name="title" id="title" maxlength="40" required>
        <label for="" class="modal__label">Enter context: </label>
        <textarea rows="10" cols="20" class="form-control" name="edtContext" id="context" maxlength="250"></textarea>
        <button type="button" value="Update" class="modal__button-submit" data-button-submit onclick="editNote()">
            Update
        </button>
    </form>
</div>


</body>

</html>