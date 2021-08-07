<template>
  <div id="addemail">
      <h1>Add Email</h1>
      <div>
<<<<<<< HEAD
          <label for="name">Name:</label>
          <input type="text" id="name">
      </div>
      <div>
          <label for="email">Email:</label>
          <input type="text" name="email">
      </div>
      <div>
          <label for="emailType">Email Type:</label>
          <select id="emailType">
              <option value="Home">Home</option>
              <option value="Work">Work</option>
              <option value="Other">Other</option>
          </select>
      </div>
  </div>
  
=======
          <label for="name">Name: </label>
          <input type="text" id="name" v-model="usersName">
      </div>
      <div>
          <label for="email">Email:</label> 
          <input type="text" id="email" v-model="email">
      </div>
      <div>
          <label for="emailType">Email Type:</label>
          <select id="emailType" v-model="emailType">
              <option value="HOME">Home</option>
              <option value="WORK">Work</option>
              <option value="OTHER">Other</option>
          </select>
      </div>

      <div>
          <h2>You selected</h2>
          <div>Name: {{ usersName }}</div>
          <div>Email: {{ email }}</div>
          <div>Email Type: {{ emailType }}</div>
      </div>
  </div>
>>>>>>> 5643a14cd15e1c3262fd2ba45a16735870634d95
</template>

<script>
export default {
<<<<<<< HEAD
    name: 'add-email'
=======
    name: 'add-email',
    data() {
        return {
            usersName: '',
            email: '',
            emailType: ''
        }
    }
>>>>>>> 5643a14cd15e1c3262fd2ba45a16735870634d95
}
</script>

<style>

</style>