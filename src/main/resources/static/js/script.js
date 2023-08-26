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

//function updateTable() {
//    fetchItems();
//}


async function addNewHistory() {

    const historyForm = document.getElementById('addHistoryForm');
    const historyTableBody = document.getElementById('table-body');

    const patientId = document.getElementById('patId').value;
    const history = document.getElementById('notes').value;

    console.log(patientId);
    console.log(history);

     // Construct URL with request parameters
    const url = `/patHistory/add?patId=${encodeURIComponent(patientId)}&note=${encodeURIComponent(history)}`;

     // Add row to the table
    const newRow = historyTableBody.insertRow();
    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    cell1.textContent = patientId;
    cell2.textContent = history;

     try {
        // Make POST API request
        const response = await fetch(url, {
          method: 'POST'
        });

        if (response.ok) {
          console.log('History added successfully.');
        } else {
          console.error('Failed to add history.');
        }
     } catch (error) {
        console.error('An error occurred:', error);
     }
}


function getRowId(row) {
    return row.getAttribute('data-row-id');
}

async function saveChanges() {
    const tableBody = document.querySelector("#history-demographics tbody");
    const rows = tableBody.querySelectorAll('tr');
    const updatedData = [];
    console.log(tableBody);
    console.log("rows " + rows);


     rows.forEach(row => {
       const cells = row.querySelectorAll('td');
       const dataObject = {
         patId: cells[0].textContent,
         note: cells[1].textContent,
       };
       updatedData.push(dataObject);
     });

    console.log(updatedData)
    sendPutRequest(updatedData);
}


function sendPutRequest(data) {

  const apiUrl = 'https://api.example.com/update';

  fetch('patHistory/update', {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
  .then(response => {
    if (response.ok) {
      console.log('Data updated successfully.');
    } else {
      console.error('Failed to update data.');
    }
  })
  .then(response => response.json())
      .then(data => {
          // Handle the API response, if needed
          console.log('API response:', data);
          location.assign("./");
      })
  .catch(error => {
    console.error('Error occurred while updating data:', error);
  });
}

document.getElementById('updateHistoryButton').addEventListener('click', () => {
    saveChanges();
});


//// Add a click event listener to the "add New Patient" button
//document.getElementById('addNewHistory').addEventListener('click', updateTable);

document.getElementById('addHistoryForm').addEventListener('submit', addNewHistory);
window.onload = fetchItems;