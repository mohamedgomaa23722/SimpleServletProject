
const queryString = window.location.search;
console.log(queryString);

const urlParams = new URLSearchParams(queryString);
console.log(urlParams);

const page_type = urlParams.get('isvalid')
console.log(page_type);

let userEle = document.getElementById('UserName')
let passwordEle = document.getElementById('password')
let errorLabel = document.getElementById('errorMessage');
if (queryString.length != 0) {
    userEle.classList.add("Error");
    passwordEle.classList.add("Error");
    errorLabel.innerHTML = 'Invalid username or password'
} else {
    userEle.classList.remove("Error");
    passwordEle.classList.remove("Error");
    errorLabel.innerHTML = ''
}

function applyCookie(){
    console.log('created')
    document.cookie = `UserName = ${userEle.value}`;
    document.cookie = `password = ${passwordEle.value}`
}

