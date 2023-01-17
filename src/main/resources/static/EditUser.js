const formEdit = document.getElementById("formEdit");
formEdit.addEventListener('submit', e => {
    e.preventDefault();

    const formData = new FormData(formEdit);
    const object = {
        roles: []
    };

    formData.forEach((value, key) => {
        if (key === "rolesId") {
            const roleId = value.split(" ")[0];
            const roleName = value.split(" ")[1];
            const role = {
                id: roleId,
                name: roleName
            };
            object.roles.push(role);
        } else {
            object[key] = value;
        }
    });

    fetch("api/user/" + formData.get("id"), {
        method: "PUT",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(object)
    })
        .then(() => getAllUsersList());
    $("#ModalEdit").modal("hide");
    formEdit.reset();

})