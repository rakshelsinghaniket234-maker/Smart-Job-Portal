```javascript
/* =========================================
   SMART JOB PORTAL
   FORM VALIDATION
   ========================================= */


/* =========================
   LOGIN VALIDATION
   ========================= */

function validateLogin() {

    let email =
        document.getElementById("email").value.trim();

    let password =
        document.getElementById("password").value.trim();


    if (email === "") {

        alert("Please enter email.");

        return false;
    }


    if (!email.includes("@")) {

        alert("Please enter a valid email.");

        return false;
    }


    if (password === "") {

        alert("Please enter password.");

        return false;
    }


    if (password.length < 6) {

        alert("Password must contain at least 6 characters.");

        return false;
    }


    return true;
}


/* =========================
   REGISTRATION VALIDATION
   ========================= */

function validateRegistration() {

    let name =
        document.getElementById("name").value.trim();

    let email =
        document.getElementById("email").value.trim();

    let password =
        document.getElementById("password").value.trim();

    let phone =
        document.getElementById("phone").value.trim();


    if (name === "") {

        alert("Please enter your name.");

        return false;
    }


    if (email === "") {

        alert("Please enter email.");

        return false;
    }


    if (!email.includes("@")) {

        alert("Please enter valid email.");

        return false;
    }


    if (password === "") {

        alert("Please enter password.");

        return false;
    }


    if (password.length < 6) {

        alert("Password must contain at least 6 characters.");

        return false;
    }


    if (phone === "") {

        alert("Please enter phone number.");

        return false;
    }


    if (!/^[0-9]{10}$/.test(phone)) {

        alert("Phone number must contain exactly 10 digits.");

        return false;
    }


    return true;
}


/* =========================
   ADD JOB VALIDATION
   ========================= */

function validateJob() {

    let title =
        document.getElementById("title").value.trim();

    let location =
        document.getElementById("location").value.trim();

    let salary =
        document.getElementById("salary").value.trim();

    let skills =
        document.getElementById("skills").value.trim();


    if (title === "") {

        alert("Please enter job title.");

        return false;
    }


    if (location === "") {

        alert("Please enter job location.");

        return false;
    }


    if (salary === "") {

        alert("Please enter salary.");

        return false;
    }


    if (parseFloat(salary) <= 0) {

        alert("Salary must be greater than 0.");

        return false;
    }


    if (skills === "") {

        alert("Please enter required skills.");

        return false;
    }


    return true;
}
```
