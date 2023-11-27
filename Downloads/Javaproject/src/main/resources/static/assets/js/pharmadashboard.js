function deleteMessage(element) {
    const messageElement = element.closest('.message');
    messageElement.classList.add('deleted');
    messageElement.style.display = 'none';
}

const deleteIcons = document.querySelectorAll('.message .action.delete');
deleteIcons.forEach(function (deleteIcon) {
    deleteIcon.addEventListener('click', function (event) {
        event.preventDefault();
        deleteMessage(this);
    });
});

document.querySelector('.trash-button').addEventListener('click', function() {
    const deletedMessages = document.querySelectorAll('.message.deleted');
    const undeletedMessages = document.querySelectorAll('.message:not(.deleted)');
    
    undeletedMessages.forEach(function(message) {
        message.style.display = 'none';
    });
    
    deletedMessages.forEach(function(message) {
        message.style.display = 'block';
    });
});

//for sent messages:
function sendMessage() {
// Capture the message content from the form
var from = document.getElementById("from").value;
var to = document.getElementById("to").value;
var object = document.getElementById("object").value;
var message = document.getElementById("message").value;

// Create a new message element
var sentMessages = document.getElementById("sent-messages");
var newMessage = document.createElement("div");
newMessage.className = "sent-message";
newMessage.innerHTML = "<strong>From:</strong> " + from + "<br><strong>To:</strong> " + to + "<br><strong>Subject:</strong> " + object + "<br><strong>Message:</strong> " + message;

// Append the new message to the "Sent" section
sentMessages.appendChild(newMessage);

// Clear the form
document.getElementById("from").value = "";
document.getElementById("to").value = "";
document.getElementById("object").value = "";
document.getElementById("message").value = "";
// Hide the inbox and show the "Sent" section
document.getElementById("inbox-messages").style.display = "none";
document.getElementById("sent-messages").style.display = "block";
}


const sentIcons = document.querySelectorAll('.message .action.send');
sentIcons.forEach(function (sentIcon) {
sentIcon.addEventListener('click', function (event) {
event.preventDefault();
sendMessage(); // Call sendMessage without any arguments
});
});

document.querySelector('.rocket-button').addEventListener('click', function() {
const messages = document.querySelectorAll('.message');

messages.forEach(function(message) {
message.style.display = 'none';
});

// Optionally, you can show the "Sent" section
document.getElementById("sent-messages").style.display = "block";
});



function toggleStar(element) {
    const messageElement = element.closest('.message');
    const starIcon = messageElement.querySelector('.fa-star-o');

    // Toggle the star icon and update the visual state
    if (starIcon) {
        starIcon.classList.remove('fa-star-o');
        starIcon.classList.add('fa-star');
        messageElement.classList.add('stared');
    } else {
        const filledStarIcon = messageElement.querySelector('.fa-star');
        filledStarIcon.classList.remove('fa-star');
        filledStarIcon.classList.add('fa-star-o');
        messageElement.classList.remove('stared');
    }
}


document.querySelector('.stared-button').addEventListener('click', function(){
    const staredMessages = document.querySelectorAll('.message.stared');
    const unstaredMessages = document.querySelectorAll('.message:not(.stared)');
    
    unstaredMessages.forEach(function(message) {
        message.style.display = 'none';
    });
    
    staredMessages.forEach(function(message) {
        message.style.display = 'block';
    });
});


function handleInboxClick() {
    const deletedMessages = document.querySelectorAll('.message.deleted');
    const undeletedMessages = document.querySelectorAll('.message:not(.deleted)');
    
    undeletedMessages.forEach(function(message) {
        message.style.display = 'block';
    });
    
    deletedMessages.forEach(function(message) {
        message.style.display = 'none';
    });

    const staredMessages = document.querySelectorAll('.message.stared');
    staredMessages.forEach(function(message) {
        message.style.display = 'block';
    });
}



const messages = document.querySelectorAll('.message');

messages.forEach(function (message) {
    message.addEventListener('click', function (event) {
        event.preventDefault(); // Prevent the default behavior of the anchor element
        
    });
});


function showComposemessage(){
    const composeEmailSection = document.getElementById('compose-email');
    composeEmailSection.style.display = 'block';
}

// Function to hide the compose email section
function hidecomposeemail() {
    const composeEmailSection = document.getElementById('compose-email');
    composeEmailSection.style.display = 'none';
}

// Add a click event listener to the trash button in the compose email section
document.querySelector('.trash-button').addEventListener('click', hideComposeEmail);







function openPDFInNewWindow() {
// Specify the URL of the PDF file
var pdfURL = "file_url_here"; // Replace with your PDF file URL

// Open a new browser window with the PDF file
var newWindow = window.open(pdfURL, "_blank", "width=800, height=600");

// Focus on the new window (optional)
if (newWindow) {
    newWindow.focus();
}
}



// Function to send a message
// Function to send a message
function sendMessage() {
    // Capture the message content from the form
    var from = document.getElementById("from").value;
    var to = document.getElementById("to").value;
    var object = document.getElementById("object").value;
    var messageContent = document.getElementById("message").value;
    var currentTime = new Date().toLocaleTimeString();

    // Create a new message element
    var inboxMessages = document.querySelector('.messages');
    var newMessage = document.createElement("li");
    newMessage.className = "message unread";
    newMessage.innerHTML = `
        <a href="#">
            <div class="actions">
                <span class="action"><i class="fa fa-square-o"></i></span>
                <span class="action important" onclick="toggleStar(this)"><i class="fa fa-star-o"></i></span>
                <span class="action delete" onclick="deleteMessage(this)"><i class="fa fa-trash"></i></span>
            </div>
            <div class="header">
                <span class="from">${from}</span>
                <span class="date">
                    <span class="fa fa-paper-clip"></span> ${currentTime}
                </span>
            </div>
            <div class="title">
                ${object}
            </div>
            <div class="description">
                ${messageContent}
            </div>
        </a>
    `;

    // Append the new message to the "Inbox" section
    inboxMessages.appendChild(newMessage);

    // Clear the form
    document.getElementById("from").value = "";
    document.getElementById("to").value = "";
    document.getElementById("object").value = "";
    document.getElementById("message").value = "";

    // Optionally, you can hide the compose email section
    hidecomposeemail();
}