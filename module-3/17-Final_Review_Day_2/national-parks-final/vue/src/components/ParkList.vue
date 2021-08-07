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
import parkService from '@/services/ParkService'
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
   },
   methods:{
     getAllParks(){
       parkService.getParks().then(
         response =>{
           this.$store.commit('SET_PARKS', response.data);
         }
       )
        .catch(
          error =>{
            //Status code error: 500, 400
            if(error.response){
              console.error( error.response.status + " " + error.response.statusText);
            }
            //Connection Error
            else if(error.request){
              console.error(error.request);
            }
            //Axios
            else{
              console.log("Unexpected Axios error");
            }

          }
        )
     }
   },
   created(){
     this.getAllParks();
   }
}
</script>

<style>

</style>