<template>
  <div class="home">
    <h1>Itineraries</h1>
    <h2>Add</h2>
    <add-itinerary/>
    
  </div>
</template>

<script>
import AddItinerary from '@/components/AddItinerary'
export default {
  name: "home",
  components:{
    AddItinerary
  }
};
</script>
