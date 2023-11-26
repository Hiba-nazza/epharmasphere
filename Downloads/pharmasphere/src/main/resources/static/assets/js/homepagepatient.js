function sendMessage() {
    const selectedPharmacy = document.getElementById('pharmacySelect').value;
    const message = document.getElementById('message').value;
    const file = document.getElementById('fileUpload').files[0]; // Assuming you're only allowing a single file

    const formData = new FormData();
    formData.append('selectedPharmacy', selectedPharmacy);
    formData.append('message', message);
    formData.append('file', file);

    fetch('/sendMessage', {
        method: 'POST',
        body: formData,
    })
    .then(response => response.json())
    .then(data => {
        console.log('Message sent successfully:', data);
        // Add any additional logic or UI updates here
    })
    .catch(error => {
        console.error('Error sending message:', error);
        // Handle errors or display a message to the user
    });
}
function displaySelectedPharmacy() {
    const selectedPharmacyId = document.getElementById('pharmacySelect').value;
    
    // Make a request to fetch the details of the selected pharmacy
    fetch(`/api/pharmacies/${selectedPharmacyId}`)
        .then(response => response.json())
        .then(selectedPharmacy => {
            // Update the details in the 'selectedPharmacyDetails' div
            const detailsDiv = document.getElementById('selectedPharmacyDetails');
            detailsDiv.innerHTML = `<p>Name: ${selectedPharmacy.name}</p>
                                     <p>Address: ${selectedPharmacy.address}</p>
                                     <p>Email: ${selectedPharmacy.email}</p>`;

            // Set the selected pharmacy's ID as the value of the hidden input field
            document.getElementById('selectedPharmacyId').value = selectedPharmacy.id;

            // Set the patient's email as the value of the hidden input field for sender
            document.getElementById('senderEmail').value = '${patient.email}';

            // Automatically set the pharmacy name as the subject in the message field
            document.getElementById('message').value = `Regarding your services, ${selectedPharmacy.name}, `;
        })
        .catch(error => console.error('Error retrieving selected pharmacy details', error));
}

    
    
document.addEventListener('DOMContentLoaded', function () {
    fetch('/api/pharmacies')
        .then(response => response.json())
        .then(data => {
            // Manipulate the data here, for example, by displaying it in a select dropdown
            const pharmacySelect = document.getElementById('pharmacySelect');

            data.forEach(pharmacy => {
                const option = document.createElement('option');
                option.value = pharmacy.id;
                option.text = pharmacy.pharmacy_name;
                pharmacySelect.appendChild(option);
            });
        })
        .catch(error => console.error('Error fetching pharmacies', error));
});