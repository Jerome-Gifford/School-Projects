<?php  
session_start(); // required for every php file for application

// if userid is not set then call login function
if (empty($_SESSION['userid'])){ // user not set
  login();
  exit();
}

// enables user to log in
function login() {
    echo '<form action="login.php" method="post">';
	echo '<p>Username:';
	echo '<input type="text" name="username"><br>';
	echo '<p>Password:';
	echo '<input type="password" name="password"><br>';
	echo '<input type="submit" value="Submit">';
	echo '</form>';
	echo '<a class="btn btn-success" href="register.php">Register</a>';
} 
include 'database.php';
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
    		<div class="row">
    			<h3>Hotel Reservations CRUD</h3>
    		</div>
			<div class="row">
				<p>
					<a href="reservation_create.php" class="btn btn-success">Create Reservation</a>
					<a href="logout.php" class="btn btn-danger">Log Out</a>
				</p>
				
			<div class="row">
    			<h3>Customers</h3>
    		</div>
				<table class="table table-striped table-bordered">
		              <thead>
		                <tr>
		                  <th>First Name</th>
		                  <th>Last Name</th>
		                  <th>Phone Number</th>
		                  <th>Address</th>
						  <th>Action</th>
		                </tr>
		              </thead>
		              <tbody>
		              <?php 
					   //include 'database.php'; was already included above
					   $pdo = Database::connect();
					   $sql = 'SELECT * FROM hotel_customers ORDER BY cust_id DESC';
	 				   foreach ($pdo->query($sql) as $row) {
						   		echo '<tr>';
							   	echo '<td>'. $row['first_name'] . '</td>';
							   	echo '<td>'. $row['last_name'] . '</td>';
							   	echo '<td>'. $row['phone_number'] . '</td>';
								echo '<td>'. $row['address'] . '</td>';
							   	echo '<td width=250>';
							   	echo '<a class="btn btn-success" href="customer_update.php?cust_id='.$row['cust_id'].'">Update</a>';
							    echo '</td>';
							   	echo '</tr>';
					   }
					   Database::disconnect();
					  ?>
				      </tbody>
	            </table>
			<div class="row">
    			<h3>Rooms</h3>
    		</div>
				<table class="table table-striped table-bordered">
		              <thead>
		                <tr>
		                  <th>Room Number</th>
		                  <th>Num of Beds</th>
		                  <th>Num of Baths</th>
		                  <th>Room Price</th>
						  <th>Action</th>
		                </tr>
		              </thead>
		              <tbody>
		              <?php 
					   //include 'database.php'; WAS ALREADY INCLUDED ABOVE
					   $pdo = Database::connect();
					   $sql = 'SELECT * FROM hotel_rooms ORDER BY room_id DESC';
	 				   foreach ($pdo->query($sql) as $row) {
						   		echo '<tr>';
							   	echo '<td>'. $row['room_num'] . '</td>';
							   	echo '<td>'. $row['num_of_beds'] . '</td>';
							   	echo '<td>'. $row['num_of_baths'] . '</td>';
								echo '<td>'. "$" . $row['room_price'] . '</td>';
							   	echo '<td width=250>';
							   	echo '<a class="btn btn-success" href="room_update.php?room_id='.$row['room_id'].'">Update</a>';
							    echo '</td>';
							   	echo '</tr>';
					   }
					   Database::disconnect();
					  ?>
				      </tbody>
	            </table>
				
				<div class="row">
    			<h3>Reservations</h3>
    		</div>
				<table class="table table-striped table-bordered">
		              <thead>
		                <tr>
		                  <th>Customer</th>
		                  <th>Room</th>
		                  <th>Start Date</th>
		                  <th>End Date</th>
						  <th>Action</th>
		                </tr>
		              </thead>
		              <tbody>
		              <?php 
					   //include 'database.php'; WAS ALREADY INCLUDED ABOVE
					   $pdo = Database::connect();
					   $sql = 'SELECT * FROM hotel_reservations, hotel_customers, hotel_rooms WHERE 
							hotel_reservations.cust_id = hotel_customers.cust_id AND 
							hotel_reservations.room_id = hotel_rooms.room_id ORDER BY res_id DESC';
	 				   foreach ($pdo->query($sql) as $row) {
						   		echo '<tr>';
							   	echo '<td>'. $row['first_name'] . '</td>';
							   	echo '<td>'. $row['room_num'] . '</td>';
							   	echo '<td>'. $row['start_date'] . '</td>';
								echo '<td>'. $row['end_date'] . '</td>';
							   	echo '<td width=250>';
							   	echo '<a class="btn btn-success" href="reservation_update.php?res_id='.$row['res_id'].'">Update</a>';
							    echo '<a class="btn btn-danger" href="reservation_delete.php?res_id='.$row['res_id'].'">Delete</a>';
								echo '</td>';
							   	echo '</tr>';
					   }
					   Database::disconnect();
					  ?>
				      </tbody>
	            </table>
    	</div>
    </div> <!-- /container -->
  </body>
</html>