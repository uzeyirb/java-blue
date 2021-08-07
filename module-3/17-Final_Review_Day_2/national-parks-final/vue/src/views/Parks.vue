<template>
  <div>
      <h1>Parks</h1>
      <park-search />
      <park-list />
  </div>
</template>

<script>
import ParkList from '@/components/ParkList'
import ParkSearch from '@/components/ParkSearch'

export default {
    name: 'parks',
    components: {
        ParkList,
        ParkSearch
    }
}
</script>

<style>

</style>