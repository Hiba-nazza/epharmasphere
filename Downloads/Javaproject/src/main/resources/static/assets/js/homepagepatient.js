/*function sendMessage() {
    // Get the selected pharmacy's ID and email
    var selectedPharmacyId = document.getElementById('pharmacySelect').value;
    var senderEmail = document.getElementById('senderEmail').value;

    // Validate that a pharmacy is selected
    if (!selectedPharmacyId) {
        alert('Please select a pharmacy.');
        return;
    }

    // Get the message content
    var messageContent = document.getElementById('message').value;

    // Perform any additional validation as needed

    // Create an object with the message data
    var messageData = {
        sender: senderEmail,
        receiver: selectedPharmacyId.email, // Replace with logic to get pharmacy email based on selectedPharmacyId
        subject: 'Message from Patient',
        content: messageContent
    };

    // Perform an AJAX request to send the message to the server
    // Adjust the URL and method based on your server-side implementation
    // For simplicity, I'll use the Fetch API
    fetch('/homepagepatient', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(messageData),
    })
    .then(response => response.json())
    .then(data => {
        // Handle the response as needed
        console.log('Message sent successfully:', data);
        alert('Message sent successfully!');
        window.location.href = '/dash'; // Redirect to the dashboard
    })
    .catch((error) => {
        console.error('Error sending message:', error);
        alert('Error sending message. Please try again.');
    });
}*/
document.addEventListener('DOMContentLoaded', function () {
    // Fetch pharmacies data from the server
    fetch('/api/pharmacies')
        .then(response => response.json())
        .then(data => {
            const pharmacySelect = document.getElementById('pharmacySelect');

            // Populate the select dropdown with pharmacy data
            data.forEach(pharmacy => {
                const option = document.createElement('option');
                option.value = pharmacy.email;
                option.text = pharmacy.email;
                pharmacySelect.appendChild(option);
            });
        })
        .catch(error => console.error('Error fetching pharmacies', error));

    // Add event listener to the Send Message button
    const sendMessageButton = document.getElementById('sendMessageButton');
    sendMessageButton.addEventListener('click', function () {
        // Get selected pharmacy, message, and file path values
        const selectedPharmacy = document.getElementById('pharmacySelect').value;
        const message = document.getElementById('message').value;
        const fileInput = document.getElementById('fileUpload');
        const filePath = fileInput.files.length > 0 ? fileInput.files[0].name : null;

        // Create an object with the message data
        const messageData = {
            selectedPharmacy: selectedPharmacy,
            message: message,
            filePath: filePath
        };

        // Perform an AJAX request to send the message data to the server
        fetch('/homepagepatient', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(messageData),
        })
        .then(response => response.json())
        .then(data => {
            // Handle the response as needed
            console.log('Message sent successfully:', data);
            alert('Message sent successfully!');
            // Redirect to the dashboard after a successful message send
            window.location.href = '/dash';
        })
        .catch((error) => {
            console.error('Error sending message:', error);
            alert('Error sending message. Please try again.');
        });
    });
});
