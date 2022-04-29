"use strict";

const ADDR = "http://localhost:8080";


axios.get(`${ADDR}/`)
    .then(res => { // handle response with callback
        console.log(res);
        console.log("DATA: ", res.data);
    }).catch(err => console.log(err)); // handle error


console.log("Tarot Cards: Major Arcana");

const getAllOutput = document.querySelector("#getAllOutput");

const tarotId = document.querySelector("#tarotId");

const getAll = () => {
    axios.get(`${ADDR}/tarot/getAll`)
    .then(res => {
        const tarot = res.data;

        getAllOutput.innerHTML = ""; // blanks an element

        tarot.forEach(tarot => renderTarot(tarot, getAllOutput));
    }).catch(err => console.log(err));
}

const renderTarot = (tarot) => {   
    const tarotColumn = document.createElement('div');
    tarotColumn.classList.add("col");

    const tarotCard = document.createElement('div');
    tarotCard.classList.add("card");
    tarotColumn.appendChild(tarotCard);

    const newTarot = document.createElement('div');
    newTarot.classList.add("card-body");
    
    const tarotName = document.createElement("h3");
    tarotName.innerText = tarot.name;
    tarotName.classList.add("card-title");
    newTarot.appendChild(tarotName);
    // tarotName.addEventListener('click', (e) => updateField(e, tarot.id));

    const tarotNumber = document.createElement("p");
    tarotNumber.innerText = `Number: ${tarot.number}`; 
    tarotNumber.classList.add("card-text");
    // tarotNumber.addEventListener('click', (e) => updateField(e, tarot.id));
    newTarot.appendChild(tarotNumber);

    const tarotUpright = document.createElement("p");
    tarotUpright.innerText = `Upright: ${tarot.upright}`;
    tarotUpright.classList.add("card-text");
    // tarotUpright.addEventListener('click', (e) => updateField(e, tarot.id));
    newTarot.appendChild(tarotUpright);

    const tarotReversed = document.createElement("p");
    tarotReversed.innerText = `Reversed: ${tarot.reversed}`; 
    tarotReversed.classList.add("card-text");
    // tarotReversed.addEventListener('click', (e) => updateField(e, tarot.id));
    newTarot.appendChild(tarotReversed);

    const deleteButton = document.createElement('button');
    deleteButton.innerText = "DELETE";
    deleteButton.classList.add("btn", "btn-primary");
    deleteButton.addEventListener('click', () => deleteTarot(tarot.id));

    newTarot.appendChild(deleteButton);

    tarotCard.appendChild(newTarot);

    getAllOutput.appendChild(tarotColumn);
}

const deleteTarot = id => {
    axios.delete(`${ADDR}/tarot/delete/${id}`)
        .then(res => {
            console.log(res);
            getAll();
        }).catch(err => console.log(err));
}

// const getById = () => {
//     axios.get(`${ADDR}/tarot/get/${tarotId.value}`)
//     .then(res => {
//         const tarot = res.data;
//         getByIdOutput.innerHTML = "";
//         renderTarot(tarot, getByIdOutput);
//     }).catch(err => console.log(err));
// }

document.querySelector("input#searchNumber").addEventListener('input', ({target: {value}}) => {
    console.log("SEARCH: ", value);
    if (!value) return getAll();
    axios.get(`${ADDR}/tarot/getByNumber/${value}`)
        .then(({data}) => {
            getAllOutput.innerHTML = "";
            console.log("DATA: ", data);    
            data.forEach(tarot => renderarot(Tarot));
        }).catch(err => console.log(err));
});

document.querySelector("section#postSection > form").addEventListener('submit', (e) => {
    e.preventDefault(); // stops the form submitting in the default way

    const form = e.target;

    const data = {
        name: form.name.value,
        number: form.number.value,
        upright: form.upright.value,
        reversed: form.reversed.value
    }

    console.log("DATA: ", data);

    axios.post(`${ADDR}/tarot/create`, data)
    .then((res) => {
        console.log(res);
        getAll();

        form.reset(); //resets form
        form.name.focus(); // selects the name input
    }).catch(err => console.log(err));
});

getAll();
