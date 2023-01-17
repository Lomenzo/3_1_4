async function getAllUsersList() {

    const response = await fetch("api/user");

    if (response.ok) {
        let json = await response.json()
            .then(data => replaceTable(data));
    } else {
        alert("Îøèáêà HTTP: " + response.status);
    }

    function replaceTable(data) {

        const placement = document.getElementById("usersTablePlacement")
        placement.innerHTML = "";
        data.forEach(({id, name, salary, roles}) => {
            let userRoles = "";
            roles.forEach((role) => {
                userRoles = userRoles + role.name.split("_")[0] + " ";
            })
            const element = document.createElement("tr");
            element.innerHTML = `
            <th scope="row">${id}</th>
            <td>${name}</td>
            <td>${salary}</td>
            <td>${userRoles}</td>    
            
            <td>
                <button type="button" class="btn btn-info text-white" data-bs-userId=${id}
                                                                      data-bs-userName=${name} 
                                                                      data-bs-userSalary=${salary}
                                                                      data-bs-toggle="modal"
                                                                      data-bs-target="#ModalEdit">Edit</button>
            </td>
            
            <td>
                <button type="button" class="btn btn-danger" data-bs-userId=${id}
                                                             data-bs-userName=${name} 
                                                             data-bs-userSalary=${salary}
                                                             data-bs-toggle="modal"
                                                             data-bs-target="#ModalDelete">Delete</button>
            </td>        
            `
            placement.append(element);
        })
    }
}
