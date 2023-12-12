<?php
include 'functions.php';

// Check if all required parameters are present in the request
if (
    isset($_POST['student_id']) &&
    isset($_POST['first_name']) &&
    isset($_POST['last_name']) &&
    isset($_POST['date_of_birth']) &&
    isset($_POST['email']) &&
    isset($_POST['phone_number'])
) {
    $student_id = $_POST['student_id'];
    $first_name = $_POST['first_name'];
    $last_name = $_POST['last_name'];
    $date_of_birth = $_POST['date_of_birth'];
    $email = $_POST['email'];
    $phone_number = $_POST['phone_number'];

    // Call the updateStudent function
    $result = updateStudent($student_id, $first_name, $last_name, $date_of_birth, $email, $phone_number);

    if ($result) {
        // Student updated successfully
        echo json_encode(array("status" => "success", "message" => "Student updated successfully"));
    } else {
        // Failed to update student
        echo json_encode(array("status" => "failure", "message" => "Failed to update student"));
    }
} else {
    // Required parameter is missing
    echo json_encode(array("status" => "failure", "message" => "Missing required parameters"));
}
?>
