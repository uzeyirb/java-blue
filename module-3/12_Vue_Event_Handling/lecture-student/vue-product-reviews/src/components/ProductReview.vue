<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>
    <p class="description">{{ description }}</p>
    <div class="well-display">
      <div class="well">
        <!-- but we need to put out it back to original to do that do same v-on but on amount class reason why it works by click is 
         due to reactivity of the vue  -->
        <span class="amount" v-on:click="filter = 0">{{ averageRating }}</span>
        Average Rating
      </div>
      <div class="well">
        <!-- we will apply click on event on span and it has not default behavior we will call filter value that we
        have creating under data but we need to put out it back to original to do that do same v-on but on amount class  -->
        <span class="amount" v-on:click="filter = 1">{{
          numberOfOneStarReviews
        }}</span>
        1 Star Review{{ numberOfOneStarReviews == 1 ? "" : "s" }}
      </div>
      <div class="well">
        <!-- we will apply click on event on span and it has not default behavior we will call filter value that we
        have creating under data but we need to put out it back to original to do that do same v-on but on amount class  -->
        <span class="amount" v-on:click="filter = 2">{{
          numberOfTwoStarReviews
        }}</span>
        2 Star Review{{ numberOfTwoStarReviews == 1 ? "" : "s" }}
      </div>
      <div class="well">
        <!-- we will apply click on event on span and it has not default behavior we will call filter value that we
        have creating under data but we need to put out it back to original to do that do same v-on but on amount class  -->
        <span class="amount" v-on:click="filter = 3">{{
          numberOfThreeStarReviews
        }}</span>
        3 Star Review{{ numberOfThreeStarReviews == 1 ? "" : "s" }}
      </div>
      <div class="well">
        <!-- we will apply click on event on span and it has not default behavior we will call filter value that we
        have creating under data but we need to put out it back to original to do that do same v-on but on amount class  -->
        <span class="amount" v-on:click="filter = 4">{{
          numberOfFourStarReviews
        }}</span>
        4 Star Review{{ numberOfFourStarReviews == 1 ? "" : "s" }}
      </div>
      <div class="well">
        <!-- we will apply click on event on span and it has not default behavior we will call filter value that we
        have creating under data but we need to put out it back to original to do that do same v-on but on amount class  -->
        <span class="amount" v-on:click="filter = 5">{{
          numberOfFiveStarReviews
        }}</span>
        5 Star Review{{ numberOfFiveStarReviews == 1 ? "" : "s" }}
      </div>
    </div>

    <!-- # means this page  it is used common when you use the page and then turn arround
    and then we will hide the form using v-if on form tag
    to add event on the link we need to add click which will show the add new review
    we need to add prevent because links have default behaviour redirecting to new location
    and we will add our showform from methods and set it to true we might want to add showform to reset form as well
    when we reset it shall hide the form go to resetForm method under methods-->
    <a href="#" v-on:click.prevent="showForm = true" v-show="showForm === false"
      >Add New Review</a
    >

    <!--As the submission event is form event we will have v-on attribute to handle the event on form tag
    we will call addReview from methods down below It is a very common need to call event.preventDefault() or event.stopPropagation() inside 
    event handlers. Although we can do this easily inside methods, it would be better if the methods can be 
    purely about data logic rather than having to deal with DOM event details.
    To address this problem, Vue provides event modifiers for v-on. Recall that modifiers are directive postfixes denoted by a dot.
    .stop .prevent .capture
    we have 2 options  v-if-completely takes out the object or add to the Dom. on the other hand  v-show keeps the element without removing it
    it hides or shows it. From user point of view it is same
    -->
    <form v-if="showForm" v-on:submit.prevent="addReview">
      <div class="form-element">
        <label for="reviewer">Name:</label>
        <!--In order to bind input attribute to the user input review we will use  v-model 
        reason why we have named is newReview.reviewer  object inside data has reviewer key-->
        <input id="reviewer" type="text" v-model="newReview.reviewer" />
      </div>
      <div class="form-element">
        <label for="title">Title:</label>
        <!--In order to bind input attribute to the user input title we will use  v-model 
        reason why we have named is newReview.title  object inside data has reviewer key-->
        <input id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <!-- In order to bind input attribute to the user v-model="newReview.rating will be added to select
        reason why we have v-model here is select is form filed "  issue we have here is rating is shown a string
        on browser to modify it add .number to v-model attribute in order to treat it as a number-->
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review:</label>
        <!-- In order to bind textarea attribute to the user v-model="newReview.review will be added to textarea
        reason why we have v-model here is textarea is form filed "  -->
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>
      <!--Submit and reset buttons have default to fire dault action 
      we want isFormValid to change state when value is returned when property changes
      we want to do something on constant reeavluation of property that is why we will add computed property 
      we need to bind with v-bind-->
      
      <input type="submit" value="Save" v-bind:disabled="!isFormValid" /> 

      <!-- we want to resetForm when we hit cancel we will fire click action
      then when hit button to prevent default we will have .prevent and we will call resetForm
      method from methods under the script
      Reason why our event is in cancel but not form element is:  in the form case we needed to wait
      users to submit the form when form submission is occuring becuse we want to stop it from happening so the type button submit
      its default behavior is to generate submit event on the form we want to capture what to prevent it from submitting it is also
      action when user say i am done however cancel button is regular button and it does nothing by default meaning before we but event on it
      when we hit cancel nothing will happen -->
      <input type="button" value="Cancel" v-on:click="resetForm" />
    </form>

    <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in filteredReviews"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          class="starRating"
          v-for="n in review.rating"
          v-bind:key="n"
          v-bind:title="review.rating + ' Star Review'"
        />
      </div>
      <h3>{{ review.title }}</h3>
      <p>{{ review.review }}</p>
      <p>
        Favorite?
        <input type="checkbox" v-model="review.favorited" />
      </p>
    </div>
     <!-- In order to display  whole element we will use v-if-->
    <div v-if="filteredReviews.length === 0">
      <!-- In order to display how what is user trying to see we will display filter -->
      <p>No {{ filter }} Star Reviews Found</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Parties for Dummies",
      description:
        "Host and plan the perfect cigar party for all your squirrelly friends.",

      // First, In order to bind form to newReview object we need to create newReview object under export default
      newReview: {},
      //In order to hide(show) unhide part of the form we need to create variable
      //just to keep track of the state when to show or when to hide
      //name it showForm and make it false because we want to hidden by default
      //then add link above form tag element
      showForm: false,
      filter: 0,
      reviews: [
        {
          reviewer: "Malcolm Gladwell",
          title: "What a book!",
          review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
          rating: 3,
        },
        {
          reviewer: "Tim Ferriss",
          title: "Had a cigar party started in less than 4 hours.",
          review:
            "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
          rating: 4,
        },
        {
          reviewer: "Ramit Sethi",
          title: "What every new entrepreneurs needs. A door stop.",
          review:
            "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
          rating: 1,
        },
        {
          reviewer: "Gary Vaynerchuk",
          title: "And I thought I could write",
          review:
            "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
          rating: 3,
        },
      ],
    };
  },
  computed: {
    //In order to filter reviews we will create filter method then we will add this to our review class elemement
    // but to keep track of our user choise we need to create filter variable under data
    filteredReviews() {
      return this.reviews.filter((review) => {
        return this.filter === 0 ? true : this.filter === review.rating;
      });
    },

    averageRating() {
      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      //The toFixed() method formats a number using fixed-point notation the average used to be 3.33333333
      return (sum / this.reviews.length).toFixed(2);
    },
    //Because of the reactivity we cannot get rid of the methods and we need to have repitition
    numberOfOneStarReviews() {
       //we have called function from methods
      return this.numberOfReviews(1);
    },
     //Because of the reactivity we cannot get rid of the methods and we need to have repitition
    numberOfTwoStarReviews() {
      //we have called function from methods
      return this.numberOfReviews(2);
    },
     //Because of the reactivity we cannot get rid of the methods and we need to have repitition
    numberOfThreeStarReviews() {
       //we have called function from methods
      return this.numberOfReviews(3);
    },
     //Because of the reactivity we cannot get rid of the methods and we need to have repitition
    numberOfFourStarReviews() {
       //we have called function from methods
     return this.numberOfReviews(4);
    },
     //Because of the reactivity we cannot get rid of the methods and we need to have repitition
    numberOfFiveStarReviews() {
       //we have called function from methods
     return this.numberOfReviews(5);
    },
    isFormValid(){
      //we will check if newReview object is not empty 
      return this.newReview.reviewer && this.newReview.title && this.newReview.rating && this.newReview.review;
    }
  },
  //Methods are NOT REACTIVE - meaning they are not updated when values change,
  //we must call them when there is an update or use them in a computed property
  // and pass them the data to make them reactive - which will the reactive
  // computed property to call the method again when the data is changed.
  methods: {
    addReview() {
      //The unshift() method adds one or more elements to the beginning of an array and returns the new length of the array.
      this.reviews.unshift(this.newReview);
      //when we call methods from another scope use this keyword.
      this.resetForm();
    },

    resetForm() {
      //In order to reset newReview we will assign empty object where it originally started
      //then we will call it from addReview method because after each save we will empty form
      this.newReview = {};
      this.showForm = false;
    },
    //This method will count number of reviews then we will add this function
    numberOfReviews(numOfStars){
      return this.reviews.reduce((count, review) => {
        return count + (review.rating === numOfStars);
      }, 0);
    }
  },
};
</script>

<style scoped>
div.main {
  margin: 1rem 0;
}
div.main div.well-display {
  display: flex;
  justify-content: space-around;
}
div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}
div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}
div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}
div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}
div.main div.review div.rating img {
  height: 100%;
}
div.main div.review p {
  margin: 20px;
}
div.main div.review h3 {
  display: inline-block;
}
div.main div.review h4 {
  font-size: 1rem;
}
div.main div.review.favorited {
  background-color: lightyellow;
}
div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input,
div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type="button"] {
  width: 100px;
}
form > input[type="submit"] {
  width: 100px;
  margin-right: 10px;
}
div.main div.well-display div.well span.amount:hover{
  color: blue;
  cursor: pointer;
}
</style>