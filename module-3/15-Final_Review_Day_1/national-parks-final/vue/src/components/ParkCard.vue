<template>
<<<<<<< HEAD
  <div id="parkCard">
    <img v-bind:src="park.image_url" :alt="park.fullName" />
    <div>
      <h2>
        <router-link
          :to="{
            name: 'park-detail',
            params: {
              parkcode: park.parkCode,
            },
          }"
          >{{ park.fullName }}</router-link
        >
      </h2>
      <p>
        {{ park.state }}
      </p>
    </div>
=======
  <div id="parkCard" v-on:click="goToParkPage">
      <img v-bind:src="park.image_url" :alt="park.fullName">
      <div>
        <h2><router-link :to="{ 
                                name: 'park-detail',
                                params: {
                                  parkcode: park.parkCode
                                }
                              }">{{ park.fullName }}</router-link></h2>
        <p>{{ park.state }}</p>
      </div>
>>>>>>> d27ca0328bf872d7f8d1b01f0758bee755ee9fe0
  </div>
</template>

<script>
export default {
<<<<<<< HEAD
  props: ["park"],
  methods: {
    goToParkPage() {
      this.$router.push({
        name: "park-detail",
        params: { parkcode: park.parkCode },
      });
    },
  },
};
=======
    props: ['park'],
    methods: {
      // While this works and demonstrates the click event and $router.push
      // using a router-link around the div would be a cleaner solution.
      goToParkPage() {
        this.$router.push({ 
          name: 'park-detail', 
          params: { 
            parkcode: this.park.parkCode
          }
        });
      }
    }
}
>>>>>>> d27ca0328bf872d7f8d1b01f0758bee755ee9fe0
</script>

<style>
#parkCard {
<<<<<<< HEAD
  display: flex;
  margin: 20px;
  padding: 10px;
  border: 1px black solid;
  border-radius: 10px;
}
#parkCard img {
  width: 200px;
  margin-right: 20px;
=======
    display: flex;
    margin: 20px;
    padding: 10px;
    border: 1px black solid;
    border-radius: 10px;
}
#parkCard img {
    width: 200px;
    margin-right: 20px;
>>>>>>> d27ca0328bf872d7f8d1b01f0758bee755ee9fe0
}
</style>