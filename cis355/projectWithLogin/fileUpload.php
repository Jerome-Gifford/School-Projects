<?php
include 'database.php';

	// initialize $_FILES variables
	$fileName = $_FILES['userfile']['name'];
	$tmpName  = $_FILES['userfile']['tmp_name'];
	$fileSize = $_FILES['userfile']['size'];
	$fileType = $_FILES['userfile']['type'];
	$content = file_get_contents($tmpName);
	$room_id = $_REQUEST['room_id'];
	
	$pdo = Database::connect();
	
	$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	$sql = "UPDATE hotel_rooms  set filename = ?, filesize = ?, filetype =?, content= ? WHERE room_id = ?";
	//$sql = "INSERT INTO hotel_room (filename,filesize,filetype,content) values(?, ?, ?, ?)";
	$q = $pdo->prepare($sql);
	$q->execute(array($fileName,$fileSize,$fileType,$content,$room_id));

	
	Database::disconnect();
	header("Location: index.php");
	
	
?>