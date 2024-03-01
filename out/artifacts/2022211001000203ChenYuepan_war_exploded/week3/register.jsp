<%--
  Created by IntelliJ IDEA.
  User: 31586
  Date: 2024/3/16
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            box-sizing: border-box;
        }
        form {
            margin: 100px auto;
            width: 300px;
            height: 400px;
            border: 1px solid black;
        }
        form ul {
            margin-left: -25px;
        }
        form ul li {
            width: 270px;
            height: 35px;
            list-style: none;
            margin-bottom: 20px;
        }
        .da {
            width: 100%;
            height: 100%;
        }
        .xiao {
            width: 70px;
            height: 35px;
            text-align: center;
            line-height: 35px;
        }
        .xiao input {
            width: 100%;
            height: 100%;
        }
        .text {
            margin-left: 15px;
        }
    </style>
    <script>
        window.onload=function(){
            var username=document.getElementById("username")
            username.onblur= function () {
                if(!username.value){
                    alert("name is required")
                }
            }
            var password=document.getElementById("password")
            password.onblur=function() {
                if(!password.value){
                    // alert("password is required")
                }else if(password.value.length<8){
                    // alert("length must more than 8")
                }
            }
            var email=document.getElementById("Email")
            email.onblur=function(){
                if(!email.value){
                    // alert("email is required")
                }
            }
        }
    </script>
</head>
<body>
<form action="/ChenYuepan/show" method="post">
    <h3 class="text">New User Registration!</h3>
    <ul>
        <li><input id="username" type="text" name="username" placeholder="Username" class="da"></li>
        <li><input id="password" type="password" name="password" placeholder="password" class="da"></li>
        <li><input id="Email" type="text" name="Email" placeholder="Email" class="da"></li>
        <li>
            Gender:
            <label><input type="radio" name="gender" checked="checked" value="man">Male</label>
            <label><input type="radio" name="gender" value="female">Female</label>
        </li>
        <li><input id="birth" type="text" name="birth" placeholder="Date of Birth(yyyy-mm-dd)" class="da"></li>
        <li class="xiao"> <input type="submit" value="Register" ></li>
    </ul>
</form>
</body>
</html>
