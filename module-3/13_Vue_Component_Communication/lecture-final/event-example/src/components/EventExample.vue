<template>
  <div>
      <h1>Events</h1>
      <input type="button" value="Click Me"
        v-on:click="buttonClickHandler" />
      <h1>{{ buttonClickMessage}}</h1>
      
      <form @submit.prevent.stop.once="submitForm(1, $event)">
          <input type="submit" />
      </form>


  </div>
</template>

<script>
export default {
    data() {
        return {
            buttonClickMessage: ''
        }
    },
    methods: {
        buttonClickHandler( eventObj ) {
            console.log(eventObj);
            this.buttonClickMessage = 'Clicked';
        },
        submitForm(number, eventObj) {
            console.log(number);
            console.log(eventObj);
            alert("form submitted");
        }
    }
}
</script>

<style>

</style>