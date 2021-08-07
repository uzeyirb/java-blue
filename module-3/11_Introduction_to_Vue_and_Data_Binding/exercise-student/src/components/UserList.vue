<template>
  <table id="tblUsers">
    <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>
          <input type="text" id="firstNameFilter" v-model="filter.firstName" />
          <!-- add v model to filter  -->
        </td>
        <td>
          <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          <!-- add v model to filter  -->
        </td>
        <td>
          <input type="text" id="usernameFilter" v-model="filter.username" />
          <!-- add v model to filter  -->
        </td>
        <td>
          <input type="text" id="emailFilter" v-model="filter.emailAddress" />
          <!-- add v model to filter  -->
        </td>
        <td>
          <select id="statusFilter" v-model="filter.status">
            <!-- add v model to filter  -->
            <option value="">Show All</option>
            <option value="Active">Active</option>
            <option value="Disabled">Disabled</option>
          </select>
        </td>
      </tr>
      <!-- user listing goes here -->
      <tr v-for="user in filteredList" v-bind:key="user.id" v-bind:class="{ disabled: user.status === 'Disabled' }">
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.emailAddress }}</td>
        <td>{{ user.status }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "user-list",
  data() {
    return {
      //Create filter object
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "",
      },
      users: [
        {
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active",
        },
        {
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active",
        },
        {
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Disabled",
        },
        {
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active",
        },
        {
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active",
        },
        {
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Disabled",
        },
      ],
    };
  },
  computed: {
    //vue.js form filter
    filteredList() {
      return this.users.filter((user) => {
        const searchFirstName = this.filter.firstName.toLowerCase();
        const firstNameData = user.firstName.toLowerCase();

        const searchLastName = this.filter.lastName.toLowerCase();
        const lastNameData = user.lastName.toLowerCase();

        const searchUserName = this.filter.username.toLowerCase();
        const userNameData = user.username.toLowerCase();

        const searchEmailAddress = this.filter.emailAddress.toLowerCase();
        const emailAddressData = user.emailAddress.toLowerCase();

        const searchStatus = this.filter.status.toLowerCase();
        const statusData = user.status.toLowerCase();

        return (
          firstNameData.includes(searchFirstName) &&
          lastNameData.includes(searchLastName) &&
          userNameData.includes(searchUserName) &&
          emailAddressData.includes(searchEmailAddress) &&
          statusData.includes(searchStatus)
        );
      });
    },
  },
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input,
select {
  font-size: 16px;
}
</style>
