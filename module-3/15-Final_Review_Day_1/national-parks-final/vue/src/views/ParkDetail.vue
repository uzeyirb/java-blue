<template>
<<<<<<< HEAD
  <div id ='parkDetail'>
    <h1> {{ park.fullName }}</h1>
    <p>{{park.state}}</p>
    <img :src="park.image_url" />
    <p><a v-bind:href="park.url">{{park.fullName}}</a></p>
    <p>{{park.Description}}</p>
=======
  <div id="parkDetail">
      <h1>{{park.fullName}}</h1>
      <p>{{ park.state}} </p>
      <img :src="park.image_url" />
      <p><a v-bind:href="park.url">{{park.fullName}}</a></p>
      <p>{{ park.Description }}</p>
      
>>>>>>> d27ca0328bf872d7f8d1b01f0758bee755ee9fe0
  </div>
</template>

<script>
export default {
<<<<<<< HEAD
  name: "park-detail",
  data() {
    return {
      park: {}
    };
  },
  created() {
    const parkcode = this.$route.params.parkcode;
    this.park = this.$store.state.parks.find((park) => {
      return park.parkcode === parkcode;
    });
   
  },
};
</script>

<style>
=======
    name: 'park-detail',
    data() {
        return {
            park: {}
        }
    },
    created() {
        const parkCode = this.$route.params.parkcode;
        this.park = this.$store.state.parks.find( park => {
            return park.parkCode === parkCode;
        });

    }
}
</script>

<style>
#parkDetail img {
    width: 80%;
}
>>>>>>> d27ca0328bf872d7f8d1b01f0758bee755ee9fe0
</style>