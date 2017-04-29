<?php
	$a = $_POST['a'];
	$b = $_POST['b'];
	$c = $_POST['c'];
	$d = $_POST['d'];
	$a = floatval($a);
	$b = floatval($b);
	$c = floatval($c);
	$d = floatval($d);
	$Q = sqrt(pow((2 * pow($b, 3)) - (9 * $a * $b * $c) + (27 * pow($a, 2) * $d), 2) - 4 * pow(( pow($b, 2) - 3 * $a * $c), 3));
	$Con = pow(.5 * ($Q + (2 * pow($b, 3)) - (9 * $a * $b * $c) + (27*pow($a, 2)*$d) ), 1/3);
	
	
	$x = -($b /(3 * $a)) - ($Con / (3 * $a)) - (($b*$b) - (3 * $a * $c))/ (3 * $a * $Con);
	echo "Q:" . $Q . '<br>';
	echo "C:" . $Con . '<br>';
	echo "X:" . $x . '<br>';

   echo '<form action="index.php" method="post">';
	echo '<p>A:';
	echo '<input type="text" name="a"><br>';
	echo '<p>B:';
	echo '<input type="text" name="b"><br>';
	echo '<p>C:';
	echo '<input type="text" name="c"><br>';
	echo '<p>D:';
	echo '<input type="text" name="d"><br>';
	echo '<input type="submit" value="Submit">';
	echo '</form>';
	show_source(__FILE__);  
?>