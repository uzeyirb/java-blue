<template>
  <div class="reviews">
      <review-display
        v-for="review in filteredReviews"
        v-bind:key="review.id"
        v-bind:review="review" />
        <div class="no-reviews" v-if="!hasReviews">
            <p>No {{ $store.state.filter }} Star Reviews Found</p>
        </div>
  </div>
</template>

<script>
import ReviewDisplay from './ReviewDisplay'

export default {
    name: 'review-list',
    components: {
        ReviewDisplay
    },
    computed: {
        filteredReviews() {
            const reviews = this.$store.state.reviews;
            const filter = this.$store.state.filter;
            return reviews.filter( review => {
                return filter === 0 ? true : filter === review.rating;
            });
        },
        hasReviews() {
            return this.filteredReviews.length > 0;
        }
    }
}
</script>

<style>

</style>