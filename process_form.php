<?php
// Database connection
$conn = new mysqli("localhost", "username", "password", "database_name");

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Get form data
$name = $_POST['name'];
$roll = $_POST['roll'];
$dob = $_POST['dob'];
$gender = $_POST['gender'];
$address = $_POST['address'];
$contact = $_POST['contact'];
$email = $_POST['email'];
$department = $_POST['department'];

// Insert query
$sql = "INSERT INTO students (name, roll, dob, gender, address, contact, email, department) 
        VALUES ('$name', '$roll', '$dob', '$gender', '$address', '$contact', '$email', '$department')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
