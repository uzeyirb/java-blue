// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
//const groceries = [pasta, butter, cheese, avocado, coffee, yogurt, fish, tea, cucumber, tomato];
const groceries =  [
  { id: 1, name: 'Pasta' },
  { id: 2, name: 'Butter' },
  { id: 3, name: 'Cheese' },
  { id: 4, name: 'Avocado' },
  { id: 5, name: 'Coffee'},
  { id: 6, name: 'Yogurt' },
  { id: 7, name: 'Fish' },
  { id: 8, name: 'Tea' },
  { id: 9, name: 'Cucumber' },
  { id: 10, name: 'Tomato' }
];




/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {

  const title = document.getElementById('title');
  title.innerText = pageTitle;
    
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((value) => {
    const li = document.createElement('li');
    li.innerText = value.name;
    ul.appendChild(li);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  let allListItems = document.querySelectorAll('li');
  allListItems.forEach(element => {
    element.classList.add('completed');
  })
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});



