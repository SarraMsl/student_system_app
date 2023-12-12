<?php
include 'functions.php';

// Check if the student_id parameter is present in the request
if (isset($_GET['student_id'])) {
    $student_id = $_GET['student_id'];

    // Call the deleteStudent function
    $result = deleteStudent($student_id);

    if ($result) {
        // Student deleted successfully
        echo json_encode(array("status" => "success", "message" => "Student deleted successfully"));
    } else {
        // Failed to delete student
        echo json_encode(array("status" => "failure", "message" => "Failed to delete student"));
    }
} else {
    // Required parameter is missing
    echo json_encode(array("status" => "failure", "message" => "Missing student_id parameter"));
}
?>
