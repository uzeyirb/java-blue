<template>
  <div>
    <park-card v-for="park in $store.state.parks" 
    v-bind:key="park.parkCode"
    v-bind:park="park" />
  </div>
</template>

<script>
import ParkCard from "@/components/ParkCard";
export default {
  components: {
    ParkCard,
  },
};
</script>

<style>
</style>