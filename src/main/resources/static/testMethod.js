// async function testMethod() {
//
//     const response = await fetch("http://localhost:8080/api/user/1");
//
//     if (response.ok) {
//         let json = await response.json()
//             .then(data => console.log(data));
//     } else {
//         alert("Ошибка HTTP: " + response.status);
//     }
//}
//
// function testMethod() {
//
//     fetch('http://localhost:8080/api/user/1')
//         .then((response) => {
//             console.log(response);
//         })
//         .catch(function(error) {
//             console.log(error);
//         });
// }

/*
function getAllUsersList () {
fetch('http://localhost:8080/api/user/1')
    .then((response) => {
        console.log(response);
        if (response.ok) { // если HTTP-статус в диапазоне 200-299
            // получаем тело ответа (см. про этот метод ниже)
            let json = response.json().then((json) => {
                console.log(json.name)
            });
            console.log(json);
        } else {
            alert("Ошибка HTTP: " + response.status);
        }
    })
    .catch(function(error) {
        console.log(error);
    });
}
*/

async function getAllUsersList() {

    const response = await fetch("api/user");

    if (response.ok) {
        let json = await response.json()
            .then(data => replaceTable(data));
    } else {
        alert("Ошибка HTTP: " + response.status);
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
