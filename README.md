# Introduction to the Android Application 
# #tp 3 student_system 
 By Mousselmal sarra with nardjis belonis

The Android application showcased here is designed to manage student information through interaction with a remote API. This project focuses on integrating various essential elements of Android development, including user interface design, API communication, and data handling.

### Project Overview:

- **API Integration**: Utilizes Retrofit, a popular HTTP client library, to interact with a remote server hosting an API.
  
- **User Interface**: Implements a user-friendly interface allowing users to input student details conveniently.

- **Data Management**: Utilizes Gson for handling JSON data serialization/deserialization and manages student data using a structured `Student` model.

### Key Features:

1. **Student Data Input**: Allows users to input various student details including first name, last name, date of birth, email, and phone number via EditText fields.

2. **API Communication**: Communicates with a remote server via Retrofit, sending student data to the specified API endpoint for storage or processing.

3. **Feedback and Error Handling**: Provides user feedback through Toast messages and logs errors in case of unsuccessful API requests or network issues.

### Purpose:

This project serves as a learning and demonstration platform for integrating Android applications with remote APIs. It showcases the fundamental steps involved in connecting an Android app to a backend service for data exchange and management.


<br>
<br>

### Adding Data to the Database
<br>
<a href="https://ibb.co/ZmHMJq7"><img src="https://i.ibb.co/KwNrGTS/Screenshot-2023-12-12-235527.png" alt="Screenshot-2023-12-12-235527" border="0"></a>
<br>
<br>
<a href="https://ibb.co/KVP0qYv"><img src="https://i.ibb.co/6DMnP2C/Screenshot-2023-12-12-232928.png" alt="Screenshot-2023-12-12-232928" border="0"></a>
<br>
<br>

### When the Application Starts
<br>
<a href="https://ibb.co/dJfvyr7"><img src="https://i.ibb.co/Dg1FntL/Screenshot-2023-12-12-23-05-58-916-com-example-myapplication.jpg" alt="Screenshot-2023-12-12-23-05-58-916-com-example-myapplication" border="0"></a>


### First Step: Interface Description
This XML code represents the initial step in creating an Android application interface. It comprises various user interface elements:

1. **EditTexts**: Used for data input, each labeled accordingly.
   - `editTextFirstName`: For entering the first name.
   - `editTextLastName`: For entering the last name.
   - `editTextDOB`: For entering the date of birth.
   - `editTextEmail`: For entering an email address.
   - `editTextPhoneNumber`: For entering a phone number.

2. **Button**:
   - `btnAddStudent`: A button used to add student or client information.

Each element is within a `<RelativeLayout>`, which is a layout that allows positioning elements relative to each other or the outer parent.

For instance:
- `android:layout_below="@id/editTextLastName"` specifies the vertical position of an element (`editTextLastName`) below another element.
- `android:layout_marginTop="77dp"` determines the vertical space between this element and the one above it.

This layout provides an interface for inputting student or individual information like name, date of birth, email, and phone number, with a button to add this information.
<br>
<br>
ا
<a href="https://ibb.co/j8W6Bz7"><img src="https://i.ibb.co/HKxF1Cm/Screenshot-2023-12-13-002103.png" alt="Screenshot-2023-12-13-002103" border="0"></a>

### Second Step: Implementing API Communication

<br>
<br>
This code snippet represents a Retrofit interface called `StudentApiService` used for defining API endpoints and their respective functionalities in an Android application. Let's break it down:

- **`@Headers("Content-Type: application/json")`**: An annotation used to specify the content type of the request as JSON.

- **`@POST("addStudent.php")`**: Specifies that the method will make a POST request to the `addStudent.php` endpoint.

- **`Call<Void> insertData(...)`**: This method represents the structure of the API call.

  - **`@Query("parameter_name")`**: Denotes parameters sent in the request URL.

    - `String firstName`: Represents the first name of the student.
    - `String lastName`: Represents the last name of the student.
    - `String dateOfBirth`: Represents the date of birth of the student.
    - `String email`: Represents the email address of the student.
    - `String phoneNumber`: Represents the phone number of the student.

  - **`@Body Student data`**: Indicates that the request body will contain data serialized as a `Student` object.

This interface essentially defines a method `insertData` that expects various parameters representing student information in the form of query parameters (`@Query`) and a `Student` object in the request body (`@Body`). When invoked, this method will send a POST request to the specified endpoint to add student data.

To use this interface, you'll typically create a Retrofit instance, specifying the base URL, and then create an instance of `StudentApiService` using Retrofit's `create()` method. This created instance can be used to make API requests by calling the `insertData` method with appropriate arguments.
<br>
<br>
<a href="https://ibb.co/2cBR2zX"><img src="https://i.ibb.co/ssrcSTL/Screenshot-2023-12-13-002902.png" alt="Screenshot-2023-12-13-002902" border="0"></a>
<br>
<br>
### Step 3: Creating the Data Model
<br>
<br>
The code snippet defines a `Student` class that serves as a model representing student information. Let's break it down:

- **Annotations** (`@SerializedName`): These annotations from Gson library map the class fields to the specific names in JSON data received from or sent to the server. For instance, `@SerializedName("first_name")` ensures that the field `firstName` is serialized/deserialized as `first_name` in JSON.

- **Private Fields**: The class contains private fields representing various pieces of student information such as first name, last name, date of birth, email, and phone number.

- **Constructor**: The class includes a constructor to initialize a `Student` object with all the necessary information.

- **Getters and Setters**: Getter and setter methods are provided for accessing and modifying the private fields, following the JavaBean conventions. These methods enable access to the private fields encapsulated within the class.

This `Student` class serves as a blueprint for storing and managing student data within the Android application. It encapsulates the necessary properties of a student, allowing for easier manipulation and organization of student information in the app. This step involves defining a structured data model to handle the student-related data efficiently.
<br>
<br>
<a href="https://ibb.co/GRQnbT8"><img src="https://i.ibb.co/gJZmBVf/Screenshot-2023-12-13-003709.png" alt="Screenshot-2023-12-13-003709" border="0">
<br>
<br>
### Step 4: Sending Student Data to the API
This code represents the fourth step in integrating the API within an Android application:
1. **Retrofit Configuration**:
   - Initializes Retrofit with the base URL and Gson converter factory necessary for JSON serialization/deserialization.

2. **View Initialization**:
   - Retrieves references to various EditText fields (`editTextFirstName`, `editTextLastName`, `editTextDOB`, `editTextEmail`, `editTextPhoneNumber`) and a Button (`btnAddStudent`) from the layout XML.

3. **Button Click Listener**:
   - Sets up an onClickListener for the `btnAddStudent` button, triggering the `addStudent()` method when clicked.

4. **`addStudent()` Method**:
   - Gathers user input data from EditText fields (`firstName`, `lastName`, `dob`, `email`, `phoneNumber`).
   - Creates a `Student` object using the collected data.
   - Converts the `Student` object into a JSON string using Gson (`json` variable).
   - Initiates an API call using Retrofit's `apiService.insertData()` method.
   - Provides a callback (`enqueue`) to handle the API response asynchronously.
   
5. **API Call and Response Handling**:
   - Makes a POST request using Retrofit's `insertData()` method from the `StudentApiService` interface.
   - Passes the student data to be added (`student`) as both URL query parameters and the request body.
   - Implements callbacks (`onResponse` and `onFailure`) to handle the response asynchronously.
     - `onResponse`: Checks if the response was successful and displays a success message or a failure message accordingly.
     - `onFailure`: Handles errors or network issues by displaying a relevant message to the user.

This step involves establishing a connection between the Android app and the API by sending student data collected from the user interface to the backend server using Retrofit, then handling the server's response to update the user interface accordingly.
<br>
<br>
<a href="https://ibb.co/pyx2dQj"><img src="https://i.ibb.co/Wt6nf0v/Screenshot-2023-12-13-003945.png" alt="Screenshot-2023-12-13-003945" border="0"></a>

<br>
<br>
This is the fifth step, dealing with the `build.gradle` file configuration within an Android project. This file serves as a crucial setup for the project's settings and dependencies. Let me explain the content of this file:
لاق

### Project Configuration:

- **Plugin Declaration**:
  - Specifies the use of the Android Application Plugin (`com.android.application`), enabling the creation of an Android application.

- **Android Configurations**:
  - Contains information about the application version, such as `applicationId`, `versionCode`, and `versionName`.
  - Specifies the minimum required Android OS version (`minSdk`) and the targeted version (`targetSdk`).

- **Build Settings**:
  - Defines build configurations like ProGuard settings for the final release (`release`).
  - Specifies the level of optimization (`isMinifyEnabled`) to reduce the app size in the final release.

- **Compilation and Compatibility Settings**:
  - Sets the compatibility levels for source (`sourceCompatibility`) and target (`targetCompatibility`) as Java 8.

- **Build Features**:
  - Enables the `viewBinding` feature, allowing the use of View Binding in the application.

### Dependencies:

- Contains dependencies required for the project, including:
  - AndroidX libraries supporting modern app development such as `appcompat`, `material`, and `constraintlayout`.
  - Lifecycle libraries for managing app lifecycle and ViewModel.
  - Navigation libraries for facilitating navigation between app screens.
  - Testing libraries like JUnit and Espresso for unit testing and automated testing.

- Retrofit and Gson Dependencies: Adds Retrofit and Gson converter dependencies for network operations and JSON data conversion.

- Kotlin Dependencies: Updates for the Kotlin language if it's used as the primary programming language in the project.

This step involves setting up the project's configurations, specifying dependencies, and defining the necessary build settings to compile and manage the Android application.
<br>
<br>
<a href="https://ibb.co/hXKpbQq"><img src="https://i.ibb.co/KN9Cd41/Screenshot-2023-12-13-004754.png" alt="Screenshot-2023-12-13-004754" border="0">
