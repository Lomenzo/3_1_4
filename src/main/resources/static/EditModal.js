const editModal = document.getElementById('ModalEdit')
editModal.addEventListener('show.bs.modal', event => {

    // Button that triggered the modal
    const button = event.relatedTarget

    // Extract info from data-bs-* attributes
    const userId = button.getAttribute('data-bs-userId')
    const userName = button.getAttribute('data-bs-userName')
    const userSalary = button.getAttribute('data-bs-userSalary')

    // Update the modal's content.
    const modaluserId = editModal.querySelector('#userId')
    const modaluserName = editModal.querySelector('#userName')
    const modaluserSalary = editModal.querySelector('#userSalary')

    modaluserId.value = userId
    modaluserName.value = userName
    modaluserSalary.value = userSalary

})