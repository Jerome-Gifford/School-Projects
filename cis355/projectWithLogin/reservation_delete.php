<?php 
session_start(); // required for every php file for application

// if userid is not set then call login function
if (empty($_SESSION['userid'])){ // user not set
	header("Location: index.php");
}

	require 'database.php';
	$res_id = 0;
	
	if ( !empty($_GET['res_id'])) {
		$res_id = $_REQUEST['res_id'];
	}
	
	if ( !empty($_POST)) {
		// keep track post values
		$res_id = $_POST['res_id'];
		
		// delete data
		$pdo = Database::connect();
		$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		$sql = "DELETE FROM hotel_reservations  WHERE res_id = ?";
		$q = $pdo->prepare($sql);
		$q->execute(array($res_id));
		Database::disconnect();
		header("Location: index.php");
		
	} 
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
    <div class="container">
    
    			<div class="span10 offset1">
    				<div class="row">
		    			<h3>Delete a Reservation</h3>
		    		</div>
		    		
	    			<form class="form-horizontal" action="reservation_delete.php" method="post">
	    			  <input type="hidden" name="res_id" value="<?php echo $res_id;?>"/>
					  <p class="alert alert-error">Are you sure you want to delete your Reservation?</p>
					  <div class="form-actions">
						  <button type="submit" class="btn btn-danger">Yes</button>
						  <a class="btn" href="index.php">No</a>
						</div>
					</form>
				</div>
				
    </div> <!-- /container -->
  </body>
</html>