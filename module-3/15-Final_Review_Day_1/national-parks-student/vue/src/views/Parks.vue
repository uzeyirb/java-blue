<template>
  <div>
    <h1>Parks</h1>
    <park-list/>
  </div>
</template>

<script>
import ParkList from "@/components/ParkList";
export default {
  name: "parks",
  components: {
    ParkList,
  },
};
</script>

<style>
</style>