
const addModal = document.querySelector(".addModal");
const updateModal = document.querySelector(".updateModal");
const modalCloseButton = document.querySelector("[data-button-close]");
const selectedNote = document.querySelectorAll(".box");
const delButton = document.querySelector(".button-del");
const edtButton = document.querySelector(".button-edt");
const signUpModal = document.querySelector(".signUpModal");
idOfNote = "";

const showAddModal = () => addModal.classList.remove("modal--hidden");
const showUpdateModal = () => updateModal.classList.remove("modal--hidden");
const showSignUpModal = () => signUpModal.classList.remove("modal--hidden");
const closeAddModal = () => addModal.classList.add("modal--hidden");
const closeUpdateModal = () => updateModal.classList.add("modal--hidden");
const closeSignUpModal = () => signUpModal.classList.add("modal--hidden");

function showNote() {
    selectedNote.forEach(note => note.addEventListener("click", () => {
    document.querySelector(".board__content__title").innerText = note.children[0].textContent;
    document.querySelector(".board__content__context").innerText = note.children[1].textContent;
    idOfNote = note.children[2].textContent;
    edtButton.classList.remove("js-hidden");
    delButton.classList.remove("js-hidden");
    }))};

function deleteNote() {
    $.ajax({
        url: '/notes/' + idOfNote,
        type: 'DELETE'})
            .then( function () { location.reload(); })
            .then( function () { return confirm('Pokoj usuniety') })
            .catch(function (err) { console.log(err) });
    }

function editNote() {
        $.ajax({
            url: '/notes/'+idOfNote,
            type: 'PUT',
            data:$("#editForm").serialize()})
                .then( function () { location.reload(); })
                .then( function () { return confirm('Pokoj zaktualizowany') })
                .catch(function (err) { console.log(err) })
    }
