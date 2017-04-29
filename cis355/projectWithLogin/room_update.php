<?php
session_start(); // required for every php file for application

// if userid is not set then call login function
if (empty($_SESSION['userid'])){ // user not set
	header("Location: index.php");
}

	require 'database.php';

	$room_id = null;
	if ( !empty($_GET['room_id'])) {
		$room_id = $_REQUEST['room_id'];
	}
	
	if ( null==$room_id ) {
		header("Location: index.php");
	}
	
	if ( !empty($_POST)) {
		// keep track validation errors
		$room_numError = null;
		$num_of_bedsError = null;
		$num_of_bathsError = null;
		$room_priceError = null;
		
		// keep track post values
		$room_num = $_POST['room_num'];
		$num_of_beds = $_POST['num_of_beds'];
		$num_of_baths = $_POST['num_of_baths'];
		$room_price = $_POST['room_price'];
		
		// validate input
		$valid = true;
		if (empty($room_num)) {
			$room_numError = 'No Room Number';
			$valid = false;
		}
		
		if (empty($num_of_beds)) {
			$num_of_bedsError = 'Missing Number of Beds';
			$valid = false;
		}
		
		if (empty($num_of_baths)) {
			$num_of_baths = 'Missing Number of Baths';
			$valid = false;
		}
		
		if (empty($room_price)) {
			$room_priceError = 'Missing Room Price';
			$valid = false;
		}
		
		// update data
		if ($valid) {
			$pdo = Database::connect();
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			$sql = "UPDATE hotel_rooms  set room_num = ?, num_of_beds = ?, num_of_baths =?, room_price = ? WHERE room_id = ?";
			$q = $pdo->prepare($sql);
			$q->execute(array($room_num,$num_of_beds,$num_of_baths,$room_price,$room_id));
			Database::disconnect();
			header("Location: index.php");
		}
	} else {
		$pdo = Database::connect();
		$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		$sql = "SELECT * FROM hotel_rooms where room_id = ?";
		$q = $pdo->prepare($sql);
		$q->execute(array($room_id));
		$data = $q->fetch(PDO::FETCH_ASSOC);
		$room_num = $data['room_num'];
		$num_of_beds = $data['num_of_beds'];
		$num_of_baths = $data['num_of_baths'];
		$room_price = $data['room_price'];
		$fileName = $data['filename'];
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
		    			<h3>Update a Room</h3>
		    		</div>
    		
			<?php
				if (empty($fileName)){
					echo '<form action="fileUpload.php?room_id=' . $room_id .'" enctype="multipart/form-data" method="post">' ;
					echo ' <lable>Choose file:</label> ' ;
					echo ' <input type="file" name="userfile" id="userfile"/> ' ;
					echo '	<br> ';
					echo ' <input type="submit"/> ' ;
					echo ' </form> ' ;
				}
				else{
					echo '<img  height=5%; width=15%; src="data:image/jpeg;base64,' . 
							base64_encode( $data['content'] ) . '" />'; 
				}

				?>
			
			
	    			<form class="form-horizontal" action="room_update.php?room_id=<?php echo $room_id?>" method="post">
					  <div class="control-group <?php echo !empty($room_numError)?'error':'';?>">
					    <label class="control-label">Room #</label>
					    <div class="controls">
					      	<input name="room_num" type="text"  placeholder="#" value="<?php echo !empty($room_num)?$room_num:'';?>">
					      	<?php if (!empty($room_numError)): ?>
					      		<span class="help-inline"><?php echo $room_numError;?></span>
					      	<?php endif; ?>
					    </div>
					  </div>
					  <div class="control-group <?php echo !empty($num_of_bedsError)?'error':'';?>">
					    <label class="control-label"># of Beds</label>
					    <div class="controls">
					      	<input name="num_of_beds" type="text"  placeholder="#" value="<?php echo !empty($num_of_beds)?$num_of_beds:'';?>">
					      	<?php if (!empty($num_of_bedsError)): ?>
					      		<span class="help-inline"><?php echo $num_of_bedsError;?></span>
					      	<?php endif; ?>
					    </div>
					  </div>
					  <div class="control-group <?php echo !empty($num_of_bathsError)?'error':'';?>">
					    <label class="control-label"># of Baths</label>
					    <div class="controls">
					      	<input name="num_of_baths" type="text"  placeholder="#" value="<?php echo !empty($num_of_baths)?$num_of_baths:'';?>">
					      	<?php if (!empty($num_of_bathsError)): ?>
					      		<span class="help-inline"><?php echo $num_of_bathsError;?></span>
					      	<?php endif; ?>
					    </div>
					  </div>
					  <div class="control-group <?php echo !empty($room_priceError)?'error':'';?>">
					    <label class="control-label">Room Price</label>
					    <div class="controls">
					      	<input name="room_price" type="text"  placeholder="" value="<?php echo !empty($room_price)?$room_price:'';?>">
					      	<?php if (!empty($room_priceError)): ?>
					      		<span class="help-inline"><?php echo $room_priceError;?></span>
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