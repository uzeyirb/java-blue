<template>
  <div id="app">
    <header>
      <h1>National Parks</h1>
    </header>
    <div id="nav">
      <router-link :to="{ name: 'parks' }">Parks</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>
