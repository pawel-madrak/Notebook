
const modal = document.querySelector(".modal");
const modalCloseButton = document.querySelector("[data-button-close]");
const selectedNote = document.querySelectorAll(".box");
idOfNoteToDelete = "";

const showModal = () => modal.classList.remove("modal--hidden");
const closeModal = () => modal.classList.add("modal--hidden");



function showNote() {
    selectedNote.forEach(note => note.addEventListener("click", () => {
    document.querySelector(".board__content__title").innerText = note.children[0].textContent;
    document.querySelector(".board__content__context").innerText = note.children[1].textContent;
    idOfNoteToDelete = note.children[2].textContent;
    }))};

function deleteNote() {
    $.ajax({
        url: '/notes/' + idOfNoteToDelete,
        type: 'DELETE',
        success: function(result) {
        console.log("usunieto");
        location.reload();
           /*  var newDoc = document.open("text/html", "replace");
            newDoc.write(result);
            newDoc.close(); */
        }
    });
}