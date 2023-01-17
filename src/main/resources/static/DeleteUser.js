const formDelete = document.getElementById('formDelete')
formDelete.addEventListener('submit', e =>{
    e.preventDefault();
    const formData = new FormData(formDelete);
    fetch("api/user/"+formData.get("id"), {
        method: "DELETE"
    })
        .then(() => getAllUsersList());
    $("#ModalDelete").modal("hide");
    formDelete.reset();
})