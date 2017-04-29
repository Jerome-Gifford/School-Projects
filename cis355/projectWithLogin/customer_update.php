<?php 
session_start(); // required for every php file for application

// if userid is not set then call login function
if (empty($_SESSION['userid'])){ // user not set
	header("Location: index.php");
}
	
	require 'database.php';

	$cust_id = null;
	if ( !empty($_GET['cust_id'])) {
		$cust_id = $_REQUEST['cust_id'];
	}
	
	if ( null==$cust_id ) {
		header("Location: index.php");
	}
	
	if ( !empty($_POST)) {
		// keep track validation errors
		$first_nameError = null;
		$last_nameError = null;
		$phone_numberError = null;
		$addressError = null;
		
		// keep track post values
		$first_name = $_POST['first_name'];
		$last_name = $_POST['last_name'];
		$phone_number = $_POST['phone_number'];
		$address = $_POST['address'];
		
		// validate input
		$valid = true;
		if (empty($first_name)) {
			$first_nameError = 'Please enter a First Name';
			$valid = false;
		}
		
		if (empty($last_name)) {
			$last_nameError = 'Please enter a Last Name';
			$valid = false;
		}
		
		if (empty($phone_number)) {
			$phone_numberError = 'Please enter a Phone Number';
			$valid = false;
		}
		
		if (empty($address)) {
			$addressError = 'Please enter an Address';
			$valid = false;
		}
		
		// update data
		if ($valid) {
			$pdo = Database::connect();
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			$sql = "UPDATE hotel_customers  set first_name = ?, last_name = ?, phone_number =?, address = ? WHERE cust_id = ?";
			$q = $pdo->prepare($sql);
			$q->execute(array($first_name,$last_name,$phone_number,$address,$cust_id));
			Database::disconnect();
			header("Location: index.php");
		}
	} else {
		$pdo = Database::connect();
		$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		$sql = "SELECT * FROM hotel_customers where cust_id = ?";
		$q = $pdo->prepare($sql);
		$q->execute(array($cust_id));
		$data = $q->fetch(PDO::FETCH_ASSOC);
		$first_name = $data['first_name'];
		$last_name = $data['last_name'];
		$phone_number = $data['phone_number'];
		$address = $data['address'];
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
    		
	    			<form class="form-horizontal" action="customer_update.php?cust_id=<?php echo $cust_id?>" method="post">
					  <div class="control-group <?php echo !empty($first_nameError)?'error':'';?>">
					    <label class="control-label">First Name</label>
					    <div class="controls">
					      	<input name="first_name" type="text"  placeholder="First Name" value="<?php echo !empty($first_name)?$first_name:'';?>">
					      	<?php if (!empty($first_nameError)): ?>
					      		<span class="help-inline"><?php echo $first_nameError;?></span>
					      	<?php endif; ?>
					    </div>
					  </div>
					  <div class="control-group <?php echo !empty($last_nameError)?'error':'';?>">
					    <label class="control-label">Last Name</label>
					    <div class="controls">
					      	<input name="last_name" type="text"  placeholder="Last Name" value="<?php echo !empty($last_name)?$last_name:'';?>">
					      	<?php if (!empty($last_nameError)): ?>
					      		<span class="help-inline"><?php echo $last_nameError;?></span>
					      	<?php endif; ?>
					    </div>
					  </div>
					   <div class="control-group <?php echo !empty($phone_numberError)?'error':'';?>">
					    <label class="control-label">Phone Number</label>
					    <div class="controls">
					      	<input name="phone_number" type="text"  placeholder="Phone Number" value="<?php echo !empty($phone_number)?$phone_number:'';?>">
					      	<?php if (!empty($phone_numberError)): ?>
					      		<span class="help-inline"><?php echo $phone_numberError;?></span>
					      	<?php endif; ?>
					    </div>
					  </div>
					   <div class="control-group <?php echo !empty($addressError)?'error':'';?>">
					    <label class="control-label">Address</label>
					    <div class="controls">
					      	<input name="address" type="text"  placeholder="Address" value="<?php echo !empty($address)?$address:'';?>">
					      	<?php if (!empty($addressError)): ?>
					      		<span class="help-inline"><?php echo $addressError;?></span>
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