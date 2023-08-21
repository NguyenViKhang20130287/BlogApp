var email = document.querySelector('#email')
var pass = document.querySelector('#password')
var loginBtn = document.querySelector('#login')
var messageEmail = document.querySelector('.message-email')
var messagePass = document.querySelector('.message-password')

var checkEmail = false
var checkPass = false

//
function ValidateEmail(mail) {
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
        return (true)
    }
    return (false)
}

// validate email
email.addEventListener('input', function (e) {
    let emailValue = email.value.trim()
    // console.log('check: ', ValidateEmail(emailValue));
    if (!ValidateEmail(emailValue)) {
        messageEmail.style.visibility = 'initial';
        checkEmail = false
    }
    if (ValidateEmail(emailValue)) {
        messageEmail.style.visibility = 'hidden';
        checkEmail = true
    }
})

// validate password
pass.addEventListener('input', function (e) {
    let passwordValue = pass.value.trim();
    // console.log('check: ', ValidateEmail(emailValue));
    if (passwordValue.trim().length < 8) {
        messagePass.style.visibility = 'initial';
        checkPass = false;
    } else {
        messagePass.style.visibility = 'hidden';
        checkPass = true;
    }
})


// 

loginBtn.addEventListener('click', function(e){
    e.preventDefault();
    if (checkEmail === false || checkPass === false) {
        alert('Vui lòng nhập lại !');
    }
})
