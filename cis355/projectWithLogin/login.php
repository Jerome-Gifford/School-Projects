<?php
session_start();

$username = $_POST['username'];
$password = $_POST['password'];
$password_hash = md5($password); 
$loginApproved = false; 

// find record with username
// confirm password equals the password in the database 
include 'database.php';
$pdo = Database::connect();
$sql = 'SELECT * FROM hotel_customers WHERE username = "' . $username . '"';
foreach ($pdo->query($sql) as $row) {
	if (0 == strcmp(trim($row['password']), trim($password_hash))) {
		$loginApproved = true;
		$_SESSION['userid'] = $row['cust_id'];
	}
}
Database::disconnect();
header("Location: index.php");
?>