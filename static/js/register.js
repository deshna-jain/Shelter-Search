function validatename() {
  var name = document.getElementById("name").value;
  var name_re = /[A-Za-z]+/;
if (name_re.test(name)) {
    document.getElementById("lblname").innerHTML = "Valid";
    document.getElementById("lblname").style.visibility = "visible";
    document.getElementById("lblname").style.color = "green";
  } else {
    document.getElementById("lblname").style.visibility = "visible";
    return false;
  }
return true;
}
function validatemail() {
  var email = document.getElementById("email").value;
  var email_re = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,3})$/;
if (email_re.test(email)) {
    document.getElementById("lblemail").innerHTML = "Valid";
    document.getElementById("lblemail").style.visibility = "visible";
    document.getElementById("lblemail").style.color = "green";
  } else {
    document.getElementById("lblemail").style.visibility = "visible";
    return false;
  }
return true;
}
function validatemobile(){ 
  var mob = document.getElementById("mob").value;
  var mob_re = /^[7-9]\d{9}$/;
if (mob_re.test(mob)) {
    document.getElementById("lblmob").innerHTML = "Valid";
    document.getElementById("lblmob").style.visibility = "visible";
    document.getElementById("lblmob").style.color = "green";
  } else {
    document.getElementById("lblmob").style.visibility = "visible";
    return false;
  }
return true;
}
function validatepass(){
  var pass = document.getElementById("pass").value;
  var rpass = document.getElementById("rpass").value;
  var pass_re = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
  if (pass_re.test(pass)) {
    document.getElementById("lblpass").innerHTML = "Valid";
    document.getElementById("lblpass").style.visibility = "visible";
    document.getElementById("lblpass").style.color = "green";
  } else {
    document.getElementById("lblpass").style.visibility = "visible";
    return false;
  }
  if (rpass != pass) {
    alert("Password do not match");
    return false;
  }
  return True;
}
function validate(){
if(!((validatename())&&(validatemail())&&(validatemobile())&&(validatepass()))){
alert("Registeration unsuccessful");
return false;
}
alert("Registeration successful")
return true;
}
