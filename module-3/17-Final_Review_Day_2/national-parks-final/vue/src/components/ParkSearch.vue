<template>
  <div>
      <select v-model="selectedState" v-on:change="setStateFilter">
          <option value="">All</option>
          <option 
            v-for="state in stateList" 
            :key="state" 
            :value="state">{{ state }}</option>
      </select>
  </div>
</template>

<script>
export default {
    name: 'park-search',
    data() {
        return {
            selectedState: this.$store.state.stateFilter
        }
    },
    computed: {
        stateList() {
            const states = this.$store.state.parks.map( park => {
                return park.state;
            });

            const uniqueStates = [...new Set(states)];
            // could also use:  Array.from(new Set(states))

            return uniqueStates.sort();
        }
    },
    methods: {
        setStateFilter() {
            this.$store.commit('SET_STATE_FILTER', this.selectedState);
        }
    }
}
</script>

<style>

</style>