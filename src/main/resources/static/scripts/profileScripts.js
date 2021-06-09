function editUser() {
    $.ajax({
        url: '/profile',
        type: 'PUT',
        data:$("#editUserForm").serialize()})
        .then( function () { location.reload(); })
        .then( function () { return confirm('Your data has been updated') })
        .catch(function (err) { console.log(err) })
}
