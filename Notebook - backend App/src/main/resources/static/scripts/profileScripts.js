function editUser() {
    $.ajax({
        url: '/profile',
        type: 'PUT',
        data:$("#form--edit--user").serialize()
        })
        .catch(function (err) {
            console.log(err) });

}
