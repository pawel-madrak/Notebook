
const addModal = document.querySelector(".modal--add");
const updateModal = document.querySelector(".modal--update");
const allNotes = document.querySelectorAll(".note");
const delButton = document.querySelector(".button-del");
const edtButton = document.querySelector(".button-edt");
const sortingSelect = document.getElementById('sorting');
const boardSample = document.querySelector(".board__content__sample");
let idOfNote = "";

const showAddModal = () => addModal.classList.remove("modal--hidden");
const showUpdateModal = () => updateModal.classList.remove("modal--hidden");
const closeAddModal = () => addModal.classList.add("modal--hidden");
const closeUpdateModal = () => updateModal.classList.add("modal--hidden");


allNotes.forEach(note =>  {
    const importance = note.children[3].textContent;
    switch (importance) {
        case '1':
            note.classList.add("btn-success");
            break;
        case '2':
            note.classList.add("btn-warning");
            break;
        case '3':
            note.classList.add("btn-danger");
            break;

}});



allNotes.forEach(note => note.addEventListener("click", () => {
        boardSample.classList.add("js-hidden");
        document.querySelector(".board__content__title").innerText = note.children[0].textContent;
        document.querySelector(".board__content__context").innerText = note.children[1].textContent;
        idOfNote = note.children[2].textContent;
        edtButton.classList.remove("js-hidden");
        delButton.classList.remove("js-hidden");
    }));

function deleteNote() {
    $.ajax({
        url: '/notes/' + idOfNote,
        type: 'DELETE'})
        .then( function () { location.reload(); })
        .then( function () { return confirm("Note deleted") })
        .catch(function (err) { console.log(err) });
}

function editNote() {
    $.ajax({
        url: '/notes/'+idOfNote,
        type: 'PUT',
        data:$("#form--edit").serialize()})
        .then( function () { location.reload(); })
        .then( function () { return confirm("Note updated") })
        .catch(function (err) {
            alert("please provide a title")
            console.log(err) })
}


sortingSelect.addEventListener('change', () => {
    location = "/notes?orderBy=" + sortingSelect.value;

})

window.addEventListener('load', () => {
    const urlParams = new URLSearchParams(window.location.search);
    const requestParam = urlParams.get('orderBy');
    if (requestParam !== null) {
        sortingSelect.value = requestParam;
    }
});