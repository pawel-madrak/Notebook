<html>
<head>
    <meta charset="UTF-8">
    <title>Note managing app</title>
    <link href="styles/styles.css" rel="stylesheet"/>
    <script src="scripts/scripts.js" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" defer></script>
</head>
<body>
<div id="header">
    <h2>your notes</h2>
</div>
<div class="addnote">
    <a href="#"  note-add-button onclick="showModal()">Add note</a>
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
    <button onclick="deleteNote()">delete</button>
    <button>edit</button>
</div>


<div class="modal modal--hidden">
    <form class="modal__form" action="/add" method="post" name="note">
        <button class="modal__button-close" data-button-close type="button" aria-label="Close form" onclick="closeModal()">
            <span aria-hidden="true">&times;</span>
        </button>
        <label for="" class="modal__label">Enter title: </label>
        <input type="text" class="modal__input" name="title" id="title" required>
        <label for="" class="modal__label">Enter context: </label>
        <textarea  rows="40" cols="80" class="modal__input" name="context" id="context">Input your note.. </textarea>
        <button type="submit" value="Save" class="modal__button-submit" data-button-submit>Add</button>
    </form>
</div>
</body>

</html>