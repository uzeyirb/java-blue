const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
 const pageTitle = document.getElementById('page-title');
 pageTitle.querySelector('.name').innerText = name;
 

}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  const p = document.querySelector('.description');
  p.innerText = p;
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {
  const main = document.getElementById('main');
  reviews.forEach((review) =>{
    //Create a div with the class review
    const container = document.createElement('div');
    container.classList.add('review');
    main.insertAdjacentElement('beforeend', container);
    //Add the reviewers name 
    addReviewer(container, review.reviewer);
    //Add star rating
    addRating(container, review.rating);
    //Add review title
    addTitle(container, review.title);
    // Add the review text
    addReview(container, review.review);
    main.insertAdjacentElement('beforeend', container);
  });

}

/**
 * I will creating a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} el: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const h4 = document.createElement('h4');
  h4.innerText = name;
  parent.appendChild(h4);
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  // Create a div with class rating
  const rating = document.createElement('div');
  rating.classList.add('rating');
  // for each star
  for (let i = 0; i < numberOfStars; i++) {
    // create an image with src img/star.png and class rating star
    const star = document.createElement('img');
    star.classList.add('ratingStar');
    star.src = 'img/star.png';
    // attach it as a child to the rating div
    rating.appendChild(star);
  }

  // attach the rating div to the parent div (container)
  parent.appendChild(rating);
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  // Create an H3
  const h3 = document.createElement('h3');
  // Add the text
  h3.innerText = title;
  // Attach to the parent in the DOM
  parent.appendChild(h3);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const p = document.createElement('p');
  p.innerText = review;
  parent.appendChild(p);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
