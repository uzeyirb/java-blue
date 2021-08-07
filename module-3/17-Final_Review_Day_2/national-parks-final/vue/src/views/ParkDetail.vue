<template>
  <div id="parkDetail">
      <h1>{{park.fullName}}</h1>
      <p>{{ park.state}} </p>
      <img :src="park.image_url" />
      <p><a v-bind:href="park.url">{{park.fullName}}</a></p>
      <p>{{ park.Description }}</p>
      
  </div>
</template>

<script>
export default {
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
</style>