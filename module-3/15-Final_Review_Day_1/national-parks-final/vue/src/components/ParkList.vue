<template>
  <div>
<<<<<<< HEAD
    <park-card v-for="park in $store.state.parks" 
    v-bind:key="park.parkCode" 
    v-bind:park='park'/>
=======
      <park-card 
        v-for="park in filteredParks" 
        v-bind:key="park.parkCode"  
        v-bind:park="park" />
>>>>>>> d27ca0328bf872d7f8d1b01f0758bee755ee9fe0
  </div>
</template>

<script>
<<<<<<< HEAD
import ParkCard from "@/components/ParkCard";
export default {
  components: { 
      ParkCard 
  },
};
</script>

<style>
=======
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

>>>>>>> d27ca0328bf872d7f8d1b01f0758bee755ee9fe0
</style>