var confirmPassword = document.querySelector('#confirm-password')
var messageConfirmPass = document.querySelector('.message-confirm-password')

var email = document.querySelector('#email')
var pass = document.querySelector('#password')
var signUpBtn = document.querySelector('#signUp')
var messageEmail = document.querySelector('.message-email')
var messagePass = document.querySelector('.message-password')

var checkEmail = false
var checkPass = false
var checkConfirm = false

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



// validate confirm password
confirmPassword.addEventListener('input', function (e) {
    let passwordValue = pass.value.trim();
    console.log(passwordValue);
    let confirmPasswordValue = confirmPassword.value.trim();
    if (confirmPasswordValue !== passwordValue) {
        messageConfirmPass.style.visibility = 'inherit';
        checkConfirm = false
    } else {
        messageConfirmPass.style.visibility = 'hidden';
        checkConfirm = true;
    }
})

//
signUpBtn.addEventListener('click', function(e){
    e.preventDefault();
    if (checkEmail === false || checkPass === false || checkConfirm === false) {
        alert('Vui lòng nhập lại !');
    }
})
