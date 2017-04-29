<?php

session_start();
//connect to database
include 'database.php';


if(isset($_POST['register_btn']))
{
	$firstname = $_POST['firstname'];
	$lastname = $_POST['lastname'];
	$phonenumber = $_POST['phonenumber'];
	$address = $_POST['address'];
	$username = $_POST['username'];
	$password = $_POST['password']; 
	$password2 = $_POST['password2'];
     if($password==$password2)
     {      
            $password=md5($password); //hash password before storing for security purposes
			$pdo = Database::connect();
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $sql="INSERT INTO hotel_customers (first_name, last_name, phone_number, address, username,password) VALUES(?,?,?,?,?,?)";
			$q = $pdo->prepare($sql);
			$q->execute(array($firstname,$lastname,$phonenumber,$address, $username, $password));
			header("Location: index.php");
			
    }
	 else
    {
      $_SESSION['message']="The two password do not match";   
     }
}
Database::disconnect();
?>
<!DOCTYPE html>
<html>
<head>
  <title>Register</title>
  <link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<div class="header">
    <h1>Register</h1>
</div>
<?php
    if(isset($_SESSION['message']))
    {
         echo "<div id='error_msg'>".$_SESSION['message']."</div>";
         unset($_SESSION['message']);
    }
?>
<form method="post" action="register.php">
  <table>
	 <tr>
           <td>First Name : </td>
           <td><input type="text" name="firstname" class="textInput"></td>
     </tr>
	 <tr>
           <td>Last Name : </td>
           <td><input type="text" name="lastname" class="textInput"></td>
     </tr>
	 <tr>
           <td>Phone Number : </td>
           <td><input type="text" name="phonenumber" class="textInput"></td>
     </tr>
	 <tr>
           <td>Address : </td>
           <td><input type="text" name="address" class="textInput"></td>
     </tr>
     <tr>
           <td>Username : </td>
           <td><input type="text" name="username" class="textInput"></td>
     </tr>
      <tr>
           <td>Password : </td>
           <td><input type="password" name="password" class="textInput"></td>
     </tr>
      <tr>
           <td>Password again: </td>
           <td><input type="password" name="password2" class="textInput"></td>
     </tr>
      <tr>
           <td></td>
           <td><input type="submit" name="register_btn" class="Register"></td>
     </tr>
  
</table>
</form>
</body>
</html>
