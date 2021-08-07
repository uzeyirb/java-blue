<template>
  <div id="app">
  
    <!-- STEP 3: use the component as a tag in the template -->
    <product-review />

    <add-email />
  </div>
</template>

<script>
// STEP 1: import the component
import ProductReview from './components/ProductReview'
import AddEmail from './components/AddEmail'

export default {
  name: 'App',
  // STEP 2: add the imported component to the list of components
  components: {
    ProductReview,
    AddEmail
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
</style>
