<?php
	$a = $_POST['a'];
	$b = $_POST['b'];
	$c = $_POST['c'];
	$a = floatval($a);
	$b = floatval($b);
	$c = floatval($c);
	$y = -($b /(3 * $a)) - ($c / (3 * $a)) - (($b*$b) - (3 * $a * $c))/ (3 * $a * $c);
	echo $y;
	header("Location: index.php");
?>