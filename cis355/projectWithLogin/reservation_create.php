<?php 
session_start(); // required for every php file for application

// if userid is not set then call login function
if (empty($_SESSION['userid'])){ // user not set
	header("Location: index.php");
}

	require 'database.php';

	if ( !empty($_POST)) {
		// keep track validation errors
		$cust_idError = null;
		$room_idError = null;
		$start_dateError = null;
		$end_dateError = null;
		
		// keep track post values
		$cust_id = $_POST['cust_id'];
		$room_id = $_POST['room_id'];
		$start_date = $_POST['start_date'];
		$end_date = $_POST['end_date'];
		
		// validate input
		$valid = true;
		if (empty($cust_id)) {
			$cust_idError = 'Please select a Cutomer';
			$valid = false;
		}
		
		if (empty($room_id)) {
			$room_idError = 'Please select a Room';
			$valid = false;
		}
		
		if (empty($start_date)) {
			$start_dateError = 'Please select a Start Date';
			$valid = false;
		}
		
		if (empty($end_date)) {
			$end_dateError = 'Please select an End Date';
			$valid = false;
		}
		
		// insert data
		if ($valid) {
			$pdo = Database::connect();
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			$sql = "INSERT INTO hotel_reservations (cust_id,room_id,start_date,end_date) values(?, ?, ?, ?)";
			$q = $pdo->prepare($sql);
			$q->execute(array($cust_id,$room_id,$start_date,$end_date));
			Database::disconnect();
			header("Location: index.php");
		}
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
		    			<h3>Create a Reservation</h3>
		    		</div>
    		
	    			<form class="form-horizontal" action="reservation_create.php" method="post">
					  <div class="control-group <?php echo !empty($cust_idError)?'error':'';?>">
					    <label class="control-label">Customer</label>
					    <div class="controls">
					      	<?php
								$pdo = Database::connect();
								$sql = 'SELECT * FROM hotel_customers ORDER BY cust_id DESC';
								
								echo "<select class='form-control' name='cust_id' id='cust_id'>";
								foreach ($pdo->query($sql) as $row) {
									echo "<option value='" . $row['cust_id'] . " '> " . $row['first_name'] . "</option>";
								}
								echo "</select>";
								
								Database::disconnect();
							?>
					      	<?php if (!empty($cust_idError)): ?>
					      		<span class="help-inline"><?php echo $cust_idError;?></span>
					      	<?php endif; ?>
					    </div>
					  </div>
					  <div class="control-group <?php echo !empty($room_idError)?'error':'';?>">
					    <label class="control-label">Room</label>
					    <div class="controls">
					      	<?php
								$pdo = Database::connect();
								$sql = 'SELECT * FROM hotel_rooms ORDER BY room_num DESC';
								
								echo "<select class='form-control' name='room_id' id='room_id'>";
								foreach ($pdo->query($sql) as $row) {
									echo "<option value='" . $row['room_id'] . " '> " . $row['room_num'] . "</option>";
								}
								echo "</select>";
								
								Database::disconnect();
							?>
					      	<?php if (!empty($room_idError)): ?>
					      		<span class="help-inline"><?php echo $room_idError;?></span>
					      	<?php endif; ?>
					    </div>
					  </div>
					  <div class="control-group <?php echo !empty($start_dateError)?'error':'';?>">
					    <label class="control-label">Start Date</label>
					    <div class="controls">
					      	<input name="start_date" type="date"  placeholder="" value="<?php echo !empty($start_date)?$start_date:'';?>">
					      	<?php if (!empty($start_dateError)): ?>
					      		<span class="help-inline"><?php echo $start_dateError;?></span>
					      	<?php endif; ?>
					    </div>
					  </div>
					  <div class="control-group <?php echo !empty($end_dateError)?'error':'';?>">
					    <label class="control-label">End Date</label>
					    <div class="controls">
					      	<input name="end_date" type="date"  placeholder="" value="<?php echo !empty($end_date)?$end_date:'';?>">
					      	<?php if (!empty($end_dateError)): ?>
					      		<span class="help-inline"><?php echo $end_dateError;?></span>
					      	<?php endif; ?>
					    </div>
					  </div>
					  
					  <div class="form-actions">
						  <button type="submit" class="btn btn-success">Create</button>
						  <a class="btn" href="index.php">Back</a>
						</div>
					</form>
				</div>
    </div> <!-- /container -->
  </body>
</html>