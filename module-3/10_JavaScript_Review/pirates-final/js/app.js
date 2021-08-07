/*
* Add Events and functions to move the Ship and Win the game
*/
const obstacles = ['pirate', 'iceberg'];

// Creates the Grid -- this should only occur after the DOM loads
<<<<<<< HEAD
document.addEventListener('DOmContentLoaded', () => {
    createGrid();
})

=======
document.addEventListener('DOMContentLoaded', () => {
    createGrid();

    document.querySelector('body').addEventListener('keydown', (event) =>{
        if (event.key === 'ArrowRight') {
            moveShipRight();
        }
        if (event.key === 'ArrowLeft') {
            moveShipLeft();
        }
        if (event.key === 'ArrowDown') {
            moveShipDown();
        }
        if (event.key === 'ArrowUp') {
            moveShipUp();
        }
    });

    document.getElementById('resetButton').addEventListener('click', (event) => {
        resetGame();
        event.preventDefault();
    });

})

function moveShipRight() {
    const ship = getShipLocation();
    const right = ship.nextElementSibling;
    moveShip(ship, right);
}

function moveShipLeft() {
    const ship = getShipLocation();
    const left = ship.previousElementSibling;
    moveShip(ship, left);
}

function moveShipDown() {
    const ship = getShipLocation();
    const down = getElementAtSameIndex(ship, ship.parentElement.nextElementSibling);
    moveShip(ship, down);
}

function moveShipUp() {
    const ship = getShipLocation();
    const down = getElementAtSameIndex(ship, ship.parentElement.previousElementSibling);
    moveShip(ship, down);
}

function moveShip(shipElement, newElement) {
    if (isLoss(newElement)) {
        lose();
    } else if (isWin(newElement)) {
        win();
    } else if (canMoveToElement(newElement)) {
        shipElement.classList.remove('boat');
        newElement.classList.add('boat');
    }

}
>>>>>>> cc6ce72033ea5c627ddf59a729564b065cd5920e

function canMoveToElement(element) {
    if (element == null || element.classList.contains('pirate') 
        || element.classList.contains('iceberg')) {
        return false;
    }
    return true;
}

function isWin(nextElement) {
    if (nextElement.classList.contains('treasure')) {
        return true;
    }
    return false;
}

function win() {
    const announce = document.querySelector('.announce');
    announce.classList.add('winText');
    announce.innerText = "You Win!";
    getShipLocation().classList.remove('boat');
}



function isLoss(nextElement) {
    if (nextElement.classList.contains('pirate') || 
        nextElement.classList.contains('iceberg')) {
        return true;
    } else {
        return false;
    }
}

function lose() {
    const announce = document.querySelector('.announce');
    announce.classList.add('winText');
    announce.innerText = 'You Sunk!';
    const ship = getShipLocation();
    ship.classList.remove('boat');

    ship.classList.add('boat_explosion');
    // setTimeout( functionToCallWhenTimerExpires,  millisecondsToWait)
    setTimeout( () => {
        ship.classList.remove('boat_explosion');
        ship.classList.add('boat_sunk');
    }, 250);
}

function getElementAtSameIndex(ship, newParent) {
    let elementAtIndex = null;
    if (newParent != null) {
        const index = Array.from(ship.parentNode.children).indexOf(ship);
        elementAtIndex = newParent.childNodes[index];
    }

    return elementAtIndex;
}

function getShipLocation() {
    return document.getElementById('frame').querySelector('.boat');
}

/**
 * Reset the Game
 */
function resetGame() {

    // Create the Obstacles
    createObstacles();

    resetBoat();


    // Inform the user they can start
    document.querySelector('.announce').innerText = "Play!";
   // Set the starting location of the boat and treasure
    const frame = document.getElementById('frame');
    frame.firstElementChild.firstElementChild.classList.add('boat');
    frame.lastElementChild.lastElementChild.classList.add('treasure');
}

function resetBoat() {
    const boat = getShipLocation();
    if (boat != null) {
        boat.classList.remove('boat');
    }
    const shipSunk = document.getElementById('frame').querySelector('.boat_sunk');
    if (shipSunk != null) {
        shipSunk.classList.remove('boat_sunk');
    }
}


/**
 * Creates the game grid
 */
function createGrid() {

    const frame = document.getElementById('frame');

    // Add Code to create the game grid
    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

/**
 * Builds the grid rows
 * @param {HTMLElement} frame 
 */
function buildRow(frame) {
    const row = document.createElement('div');
    row.classList.add('row');
    frame.appendChild(row);
    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

/**
 * Builds the grid squares 
 * @param {HTMLElement} row 
 * @param {int} count 
 */
function buildSquare(row, count) {
   // Add code to create the grid Squares and add them to the row
   const square = document.createElement('div');
   square.classList.add('square');
   row.insertAdjacentElement('beforeend', square);
}

function createObstacles() {
    //const rows = document.querySelectorAll("#frame .row");
    const rows = document.getElementById('frame').children;
    const rowsArray = Array.from(rows);

    rowsArray.forEach( (row, rowIndex) => {
        const cells = row.children;
        Array.from(cells).forEach( (cell, cellIndex) => {
           if ( !(rowIndex === 0 && cellIndex === 0)  && 
             !(rowIndex === rows.length - 1 && cellIndex === cells.length - 1)
           ) {
               addObstacles(cell);
           }
        });
    });
    
}


/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs
    cell.classList.remove('pirate');
    cell.classList.remove('iceberg');

    const rand = Math.floor(Math.random() * 100) + 1;

    if (rand > 85) {
        // Add pirates here
        cell.classList.add('pirate');
    } else if (rand > 80) {
        // Add iceberg here
        cell.classList.add('iceberg');
    } 
}




