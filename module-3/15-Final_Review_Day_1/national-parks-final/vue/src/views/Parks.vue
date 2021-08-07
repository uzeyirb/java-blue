<template>
  <div>
      <h1>Parks</h1>
      <parks-list />
  </div>
</template>
<script>
import ParksList from '@/components/ParksList'
export default {
    name: 'parks',
    components: {
        ParksList
    }
}
</script>
<style>
</style>