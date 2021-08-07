<template>
  <div>
      <park-card 
        v-for="park in filteredParks" 
        v-bind:key="park.parkCode"  
        v-bind:park="park" />
  </div>
</template>

<script>
import ParkCard from '@/components/ParkCard'
export default {
    
   components: {
       ParkCard
   },
   computed: {
     filteredParks() {
       const parks = this.$store.state.parks;
       const filter = this.$store.state.stateFilter;
       return parks.filter( park => {
         return filter ? park.state === filter : true;
       })
     }
   }
}
</script>

<style>

</style>