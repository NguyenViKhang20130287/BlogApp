var email = document.querySelector('#email')
var pass = document.querySelector('#password')
var loginBtn = document.querySelector('#login')
var messageEmail = document.querySelector('.message-email')
var messagePass = document.querySelector('.message-password')

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
        loginBtn.disabled = true
    }
    if (ValidateEmail(emailValue)) {
        messageEmail.style.visibility = 'hidden';
        loginBtn.disabled = false
    }
})

// validate password
pass.addEventListener('input', function (e) {
    let passwordValue = pass.value.trim();
    // console.log('check: ', ValidateEmail(emailValue));
    if (passwordValue.trim().length < 8) {
        messagePass.style.visibility = 'initial';
        loginBtn.disabled = true
    } else {
        messagePass.style.visibility = 'hidden';
        loginBtn.disabled = false
    }
})


