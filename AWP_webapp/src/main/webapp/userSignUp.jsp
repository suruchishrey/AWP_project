<%-- 
    Document   : userSignUp
    Created on : 10 Apr, 2020, 2:18:28 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="SignUp.css">
    <title>Sign Up</title>
                <script type="text/javascript">  

function formValidation()
{
    let user_name = document.User_registration.name;
    let uname = document.User_registration.username;
    let passw = document.User_registration.password;
    let mob = document.User_registration.mob_no;
    let mail = document.User_registration.email;
    let gen = document.User_registration.gender;

    if(name_validation(user_name,1,20))
    {
        if(username_validation(uname))
        {
            if(password(passw))
            {
                 if(validate_mobile(mob))
                    {
                        if(validate_mail(mail))
                        {

                            return true;
                        }
                    } 
                
                
            }

        }
    }
    return false;
}

function name_validation(user_name,min,max)
{
    let length = user_name.value.length;
    if(length==0)
    {
        window.alert("Name should not be empty");
        user_name.focus();
        return false;
    }
    else if(length<min || length>max)
    {
        window.alert("Name should be between"+min+"to"+max+"characters");
        user_name.focus();
        return false;
    }
    else
    {
        return true;
    }
}

function username_validation(uname)
{
    let length = uname.value.length;
    if(length==0)
    {
        window.alert("User_Name should not be empty");
        uname.focus();
        return false;
    }
    else
    {
        return true;
    }
}

function password(passw)
{
    let length = passw.value.length;
    if(length<6)
    {
        window.alert("Password must contain at least 6 characters");
        passw.focus();
        return false;
    }
    else {
        let lowerCaseLetters = /[a-z]/g;
        if (passw.value.match(lowerCaseLetters)) {
            let upperCaseLetters = /[A-Z]/g;
            if (passw.value.match(upperCaseLetters)) {
                let numbers = /[0-9]/g;
                if (passw.value.match(numbers)) {
                    return true;
                } else {
                    window.alert("Password must contain a lowercase,Uppercase and a number");
                    passw.focus();
                    return false;
                }
            } else {
                window.alert("Password must contain a lowercase,Uppercase and a number");
                passw.focus();
                return false;
            }
        } else {
            window.alert("Password must contain a lowercase,Uppercase and a number");
            passw.focus();
            return false;
        }


    }
}

function validate_mobile(mob)
{
    let phoneno = /^\d{10}$/;
    if(mob.value.match(phoneno))
    {
        return true;
    }
    else
    {
        window.alert("Enter Correct phone-number");
        mob.focus();
        return false;
    }
}

function validate_mail(mail)
{
    let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(mail.value.match(mailformat))
    {
        return true;
    }
    else
    {
        window.alert("Enter correct email");
        mail.focus();
        return false;
    }
}
  
function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
</head>
<body>
    <h1>Let's get started!</h1>
    <div class="main">
        <div class="contentUser">

            <form action="userregisterservlet" method="post" name="User_registration"  onsubmit="return formValidation()">
            
            <label for="name">Name</label>
            <div class="inputField"><input type="text" name="name" id="field" placeholder="Name" required></div>
            <br>
            <label for="username">Username</label>
            <div class="inputField"><input type="text" name="username" id="field" placeholder="Username" required></div>    
            <br>
            <label for="password">Password</label>
            <div class="inputField"><input type="password" name="password" id="password" placeholder="Password" required>
            </div>
            <input type="checkbox" onclick="myFunction()">Show Password 
            <br>
            <%--<label for="name">Re-enter Password</label>
            <div class="inputField"><input type="password" name="password2" id="field" placeholder="Confirm Password" required></div>
            --%>
            <br>
            <label for="mob_no">Mobile no.</label>
            <div class="inputField"><input type="tel" name="mob_no" id="field"  placeholder="Mobile no" required></div>
            <br>
            <label for="email">E-mail</label>
            <div class="inputField"><input type="text" name="email" id="field" placeholder="e-mail" required></div>    
            <br>
            <label for="gender">Gender</label>
            
            Male
            <input type="radio" name="gender" value = "M" >
            Female
            <input type="radio" name="gender" value = "F" >
            Other
            <input type="radio" name="gender" value = "O" >
            <br>
            <br>
            <label for="address">Address</label>
            <div class="inputField"><input type="text" name="address" id="field" placeholder="Your current address" required></div>
            <br>
            <label for="agree"><input type="checkbox" name="agree"> I agree to all the T&C.</label>
            <br>
            <br>
            <a href="index.jsp"><button>Back</button></a>
            <button type="submit"  id="button">submit</button>
            
            <p style="color: red">${error_message}</p>
            
            </form>
        </div>
    </div>
            
</body>
</html>