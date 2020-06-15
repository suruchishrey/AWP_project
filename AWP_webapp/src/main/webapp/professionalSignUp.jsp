<%-- 
    Document   : professionalSignUp
    Created on : 10 Apr, 2020, 2:19:17 PM
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
    let user_name = document.Prof_registration.name;
    let uname = document.Prof_registration.username;
    let passw = document.Prof_registration.password;
    let mob = document.Prof_registration.mobilenumber;
    let mail = document.Prof_registration.email;
    let gen = document.Prof_registration.gender;

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
        
        <div class="contentProfessional">
            <form method="post" action="RegisterProfServlet" onsubmit="return formValidation()" name="Prof_registration">
            <label for="name">Name</label>
            <div class="inputField"><input type="text" name="name" id="name" placeholder="Name" required></div>
            <br>
            <label for="username">Username</label>
            <div class="inputField"><input type="text" name="username" id="username" placeholder="Username" required></div>    
            <br>
            <label for="password">Password</label>
            <div class="inputField"><input type="password" name="password" id="password" placeholder="Password" required></div>
            <br>
            <input type="checkbox" onclick="myFunction()">Show Password 
            <br>
            <span id="errorpass"></span>
            <br>

            <label for="mobilenumber">Mobile no.</label>
            <div class="inputField"><input type="tel" name="mobilenumber" id="mobilenumber" pattern="[0-9]{10}" placeholder="Mobile no" required ></div>
   
            <br>
            <label for="email">E-mail</label>
            <div class="inputField"><input type="text" name="email" id="email" placeholder="E-mail" required></div>    
            <br>
            <label for="profession">Profession</label>
            <div class="inputField"><input type="text" name="profession" id="profession" placeholder="Profession e.g.Room cleaner" required></div>    
            <br>
             <label for="cars">Choose the profession:</label>

            <select name="service_id" id="cars" required>
                <option value="0">Select a Service that you would offer</option>
              <option value="1">Room Cleaning</option>
              <option value="2">Car Cleaning</option>
              <option value="3">Washroom Cleaning</option>
              <option value="4">Water Repairs</option>
              <option value="5">Electrical Repairs</option>
              <option value="6">Vehicle Repairs</option>
              <option value="7">Home Tutor</option>
              <option value="8">Music Tutor</option>
              <option value="9">Yoga Tutor</option>
              <option value="10">Art Tutor</option>
            </select> 
            <br>
            <br>
            <label for="gender">Gender</label>
            
            Male
            <input type="radio" name="gender" value="male" required >
            Female
            <input type="radio" name="gender" value="female" >
            Other
            <input type="radio" name="gender" value="other">
            <br>
            <br>
            <label for="address">Address</label>
            <div class="inputField"><input type="text" name="address" id="address" placeholder="Your current address" required></div>
            <br>
            <label for="agree"><input type="checkbox" name="agree" value="agreed" required> I agree to all the T&C.</label>
            <br>
            <br>
            <a href="indexProfessional.jsp"><button>Back</button></a>
            
            <input type="submit" value="Submit" id="button">
            </form>
        </div>

    </div>
</body>
</html>
