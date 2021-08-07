<template>
  <div>
    <form @submit.prevent="addItinerary">
      <label for="name">Name:</label>
      <input type="text" id="name" v-model="itinerary.name" required />
      <label for="startDate">Start Date:</label>
      <input
        type="date"
        id="startDate"
        v-model="itinerary.startDate"
        required
      />
      <label for="endDate">End Date:</label>
      <input type="date" id="endDate" v-model="itinerary.endDate" required />
      <input type="submit" />
    </form>
  </div>
</template>

<script>
import parkService from "@/services/ParkService";
export default {
  name: "add-itinerary",
  data() {
    return {
      itinerary: {},
    };
  },
  methods: {
    addItinerary() {
      parkService.addItinerary(this.itinerary).then((response) => {
        if (response.status === 200) {
          alert("Itinerary successful added");
        }
      });
    },
  },
};
</script>

<style>
</style>