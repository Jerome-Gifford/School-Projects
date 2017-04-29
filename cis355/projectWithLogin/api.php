<?php
include 'database.php';
		$pdo = Database::connect();
		if($_GET['res_id']){ 
		$sql = "SELECT * FROM hotel_reservations, hotel_customers, hotel_rooms WHERE 
							hotel_reservations.cust_id = hotel_customers.cust_id AND 
							hotel_reservations.room_id = hotel_rooms.room_id AND res_id = " . $_GET['res_id'];
		}
		else{
		$sql = "SELECT * FROM hotel_reservations, hotel_customers, hotel_rooms WHERE 
							hotel_reservations.cust_id = hotel_customers.cust_id AND 
							hotel_reservations.room_id = hotel_rooms.room_id";
		}
		
		$arrCust = array();
		/*
		$arrRoom = array();
		$startDate = array();
		$endDate = array();
		*/
		
		foreach ($pdo->query($sql) as $row)(
			array_push($arrCust, $row['first_name'] . " " . $row['last_name'] . ", ")
		);

		/*
		foreach ($pdo->query($sql) as $row)(
			array_push($arrRoom, $row['room_num'] . ", ")
		);
		
		foreach ($pdo->query($sql) as $row)(
			array_push($startDate, $row['start_date'] . ", ") 
		);
		
		foreach ($pdo->query($sql) as $row)(
			array_push($endDate, $row['end_date'] . ", ")
		);
		*/
		
		Database::disconnect();
		echo '{"Customer":' . json_encode($arrCust) . '}';
?>