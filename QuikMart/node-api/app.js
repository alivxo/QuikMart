// Import the Express library, which is used to create the API server
const express = require('express');

// Import the MySQL library for connecting to and interacting with the MySQL database
const mysql = require('mysql2');

// Initialize an Express application
const app = express();

// Define the port number the server will listen on
const port = 3000;

// Configure the database connection details
const db = mysql.createConnection({
    host: 'localhost',      // The hostname of the database server (usually 'localhost' for local development)
    user: 'root',  // The username to connect to the database
    password: 'YUm15510n', // The password to connect to the database
});

// Connect to the database and check for any errors
db.connect((err) => {
    if (err) {
        // If there's an error connecting, log the error and stop further execution
        console.error('Error connecting to the database:', err);
        return;
    }
    // Log a success message if the connection to the database is established
    console.log('Connected to the database');
});

// Define a route to handle GET requests at the "/products" endpoint
app.get('/products', (req, res) => {
    // SQL query to select specific fields from the "products" table
    const sqlQuery = 'SELECT product_id, product_name, quantity, price FROM products';

    // Execute the SQL query on the database
    db.query(sqlQuery, (err, results) => {
        if (err) {
            // If there's an error executing the query, send a 500 error response
            res.status(500).send('Error retrieving data from the database');
        } else {
            // If successful, send the query results as a JSON response
            res.json(results);
        }
    });
});

// Start the server and listen for incoming requests on the defined port
app.listen(port, () => {
    // Log a message to indicate that the server is running and listening for requests
    console.log(`Server is running on http://localhost:${port}`);
});
