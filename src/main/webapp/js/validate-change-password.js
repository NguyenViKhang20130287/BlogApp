var newPass = document.querySelector("#new-password")
var changePassBtn = document.querySelector("#change-pass-btn")
var messNewPass = document.querySelector(".message-new-password")

newPass.addEventListener('input', function (e) {
    let newPassValue = newPass.value.trim();
    // console.log('check: ', ValidateEmail(emailValue));
    if (newPassValue.length < 8) {
        messNewPass.style.visibility = 'initial';
        changePassBtn.disabled = true
    } else {
        messNewPass.style.visibility = 'hidden';
        changePassBtn.disabled = false
    }
})