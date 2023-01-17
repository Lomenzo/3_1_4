const DeleteModal = document.getElementById('ModalDelete')
DeleteModal.addEventListener('show.bs.modal', event => {

    // Button that triggered the modal
    const Dbutton = event.relatedTarget

    // Extract info from data-bs-* attributes
    const DuserId = Dbutton.getAttribute('data-bs-userId')
    const DuserName = Dbutton.getAttribute('data-bs-userName')
    const DuserSalary = Dbutton.getAttribute('data-bs-userSalary')

    // Update the modal's content.
    const DmodaluserId = DeleteModal.querySelector('#userIdDelete')
    const DmodaluserName = DeleteModal.querySelector('#userNameDelete')
    const DmodaluserSalary = DeleteModal.querySelector('#userSalaryDelete')

    DmodaluserId.value = DuserId
    DmodaluserName.value = DuserName
    DmodaluserSalary.value = DuserSalary

})