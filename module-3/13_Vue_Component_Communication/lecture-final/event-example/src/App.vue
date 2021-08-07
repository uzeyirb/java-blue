<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <event-example />
  </div>
</template>

<script>
import EventExample from './components/EventExample'

export default {
  name: 'App',
  components: {
    EventExample
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
  margin-top: 60px;
}
</style>
