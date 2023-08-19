function fetchItems() {
    fetch('/patHistory/get')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector('#history-demographics tbody');
            tableBody.innerHTML = ''; // Clear existing data if any
            console.log(data);
            // Loop through the data and create table rows
            data.forEach(item => {
                const row = document.createElement('tr');
                row.setAttribute('data-row-id', item.patId);

                //Name column
                const idCell = document.createElement("td");
                idCell.innerText = item.patId;
                idCell.contentEditable = true;
                row.appendChild(idCell);

                //Family Name column
                const notesCell = document.createElement("td");
                notesCell.innerText = item.note;
                notesCell.contentEditable = true;
                row.appendChild(notesCell);


                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error fetching data:', error));
}

// Function to handle form submission and add new row to the table
function addNewHistory(event) {
    event.preventDefault();
    const form = event.target;
    const patId = form.patId.value;
    const notes = form.notes.value;

    // Create a new row for the new item and add it to the table
    const tableBody = document.querySelector('#history-demographics tbody');
    const newRow = document.createElement('tr');
    newRow.innerHTML = `
        <td contenteditable="true">${patientName}</td>
        <td contenteditable="true">${familyName}</td>
    `;
    tableBody.appendChild(newRow);

    console.log(tableBody);
    console.log(newRow);

    // Clear the form fields
    form.reset();

    const formData = {
        name: patientName,
        familyName: familyName,
        dateOfBirth: dob,
        sex: gender,
        homeAddress: address,
        phoneNumber: phone
    };

    // Send the form data to the POST API using fetch
    fetch('patHistory/add?id=2&notes=Best notes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData),
    })
    .then(data => {
        // Handle the API response, if needed
        console.log('API response:', data);
        location.assign("./");
    })
    .catch(error => console.error('Error submitting data:', error));
}

document.getElementById('addNewHistory').addEventListener('submit', addNewHistory);
window.onload = fetchItems;