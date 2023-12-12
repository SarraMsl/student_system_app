<?php
include 'functions.php';

// Call the getStudents function
$students = getStudents();

if ($students !== false) {
    // Students found
    echo json_encode(array("status" => "success", "data" => $students));
} else {
    // No students found or an error occurred
    echo json_encode(array("status" => "failure", "message" => "No students found or an error occurred"));
}
?>

