<?php 
	
	require 'database.php';

	$res_id = null;
	if ( !empty($_GET['res_id'])) {
		$res_id = $_REQUEST['res_id'];
	}
	
	if ( null==$res_id ) {
		header("Location: index.php");
	}
	
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
			$cust_ideError = 'No Customer ID';
			$valid = false;
		}
		
		if (empty($room_id)) {
			$room_id = 'No Room ID';
			$valid = false;
		}
		
		if (empty($start_date)) {
			$start_dateError = 'Please enter a Start Date';
			$valid = false;
		}
		
		if (empty($address)) {
			$end_dateError = 'Please enter a End Date';
			$valid = false;
		}
		
		// update data
		if ($valid) {
			$pdo = Database::connect();
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			$sql = "UPDATE hotel_reservations  set cust_id = ?, room_id = ?, start_date =?, end_date = ? WHERE res_id = ?";
			$q = $pdo->prepare($sql);
			$q->execute(array($cust_id,$room_id,$start_date,$end_date,$res_id));
			Database::disconnect();
			header("Location: index.php");
		}
	} else {
		$pdo = Database::connect();
		$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		$sql = "SELECT * FROM hotel_reservations, hotel_customers, hotel_rooms WHERE 
							hotel_reservations.cust_id = hotel_customers.cust_id AND 
							hotel_reservations.room_id = hotel_rooms.room_id AND res_id = ?";
		$q = $pdo->prepare($sql);
		$q->execute(array($res_id));
		$data = $q->fetch(PDO::FETCH_ASSOC);
		$cust_id = $data['first_name'];
		$room_id = $data['room_num'];
		$start_date = $data['start_date'];
		$end_date = $data['end_date'];
		Database::disconnect();
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
		    			<h3>Update a Reservation</h3>
		    		</div>
    		
	    			<form class="form-horizontal" action="reservation_update.php?res_id=<?php echo $res_id?>" method="post">
					  <div class="control-group <?php echo !empty($cust_idError)?'error':'';?>">
					    <label class="control-label">First Name</label>
					    <div class="controls">
					      	<input name="cust_id" type="text"  placeholder="ID" value="<?php echo !empty($cust_id)?$cust_id:'';?>" readonly style="background-color: #DCDCDC;">
					      	<?php if (!empty($cust_idError)): ?>
					      		<span class="help-inline"><?php echo $cust_idError;?></span>
					      	<?php endif; ?>
					    </div>
					  </div>
					  <div class="control-group <?php echo !empty($room_idError)?'error':'';?>">
					    <label class="control-label">Room #</label>
					    <div class="controls">
					      	<input name="room_id" type="text"  placeholder="ID" value="<?php echo !empty($room_id)?$room_id:'';?>">
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
						  <button type="submit" class="btn btn-success">Update</button>
						  <a class="btn" href="index.php">Back</a>
						</div>
					</form>
				</div>
				
    </div> <!-- /container -->
  </body>
</html>