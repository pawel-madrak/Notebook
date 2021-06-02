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
<div id="header">
    <h2>your notes</h2>
</div>
<div>
    <form  method="post" action="/logout">
        <button class="modal__button-submit" type="submit">Logout</button>

    </form>
</div>
    </div>
<div class="addnote">
    <a href="#"  note-add-button onclick="showAddModal()">Add note</a>
</div>
<div id="content">
    <table class="datatable">
        <tr>
            <th>title</th>
            <th>content</th>
        </tr>
        <#list model["noteList"] as note>
            <tr class="box" onclick="showNote()">
                <td>${note.title}</td>
                <td>${note.context}</td>
                <td class="js-hidden">${note.id}</td>
            </tr>
        </#list>
    </table>
</div>

<div class="board">
    <div class="board__content">
        <label class="board__content__title"></label>
        <p class="board__content__context"></p>

    </div>
    <button class=" button-del js-hidden" onclick="deleteNote()">delete</button>
    <button class=" button-edt js-hidden" onclick="showUpdateModal()">edit</button>
</div>


<div class="addModal modal modal--hidden">
    <form class="modal__form" action="/notes" method="post" name="note">
        <button class="modal__button-close" data-button-close type="button" aria-label="Close form" onclick="closeAddModal()">
            <span aria-hidden="true">&times;</span>
        </button>
        <label for="" class="modal__label">Enter title: </label>
        <input type="text" class="modal__input" name="title" required>
        <label for="" class="modal__label">Enter context: </label>
        <textarea  rows="40" cols="80" class="modal__input" name="context">Input your note.. </textarea>
        <button type="submit" value="Save" class="modal__button-submit" data-button-submit>Add</button>
    </form>
</div>
<div class="updateModal modal modal--hidden">
    <form id="editForm" class="modal__form" action="/notes/" method="put" name="note">
        <button class="modal__button-close" data-button-close type="button" aria-label="Close form" onclick="closeUpdateModal()">
            <span aria-hidden="true">&times;</span>
        </button>
        <label for="" class="modal__label">Enter title: </label>
        <input type="text" class="modal__input" name="title" id="title" required>
        <label for="" class="modal__label">Enter context: </label>
        <textarea  rows="40" cols="80" class="modal__input" name="edtContext" id="context">Input your note.. </textarea>
        <button type="button" value="Update" class="modal__button-submit" data-button-submit onclick="editNote()">Update</button>
    </form>
</div>


</body>

</html>