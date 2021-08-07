<template>
  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <input type="checkbox" id="selectAll" />
          </td>
          <td>
            <input
              type="text"
              id="firstNameFilter"
              v-model="filter.firstName"
            />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="usernameFilter" v-model="filter.username" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.emailAddress" />
          </td>
          <td>
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="Active">Active</option>
              <option value="Disabled">Disabled</option>
            </select>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr
          v-for="user in filteredList"
          v-bind:key="user.id"
          v-bind:class="{ disabled: user.status === 'Disabled' }"
        >
          <td>
            <input
              type="checkbox"
              v-bind:id="user.id"
              v-bind:value="user.id"
              v-model="selectedUserIDs"
            />
          </td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <!-- buttons have default to fire dault action 
      we want flipStatus to change state when value is returned when property changes
      we want to do something on constant reeavluation of property that is why we will add computed property 
      we need to bind with v-bind--->
          <td>
            <button class="btnEnableDisable" v-on:click="flipStatus(user.id)">
              {{ user.status == "Disabled" ? "Enable" : "Disable" }}
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <div class="all-actions" v-on:click.prevent="actionButtonDisabled">
      <button v-on:click="enableSelectedUsers">Enable Users</button>
      <button v-on:click="disableSelectedUsers">Disable Users</button>
      <button v-on:click="deleteSelectedUsers">Delete Users</button>
    </div>
    <!--  using v-if on form tag
    to add event on the link we need to add click which will show the add new review
    we need to add prevent because links have default behaviour redirecting to new location
    and we will add our showform from methods and set it to true we might want to add showform to reset form as well
    when we reset it shall hide the form go to resetForm method under methods-->
    <button v-on:click="showForm = true" v-show="showForm === false">
      Add New User
    </button>
    <!--As the submission event is form event we will have v-on attribute to handle the event on form tag
    we will call addReview from methods down below It is a very common need to call event.preventDefault() or event.stopPropagation() inside 
    event handlers. Although we can do this easily inside methods, it would be better if the methods can be 
    purely about data logic rather than having to deal with DOM event details.
    To address this problem, Vue provides event modifiers for v-on. Recall that modifiers are directive postfixes denoted by a dot.
    .stop .prevent .capture
    we have 2 options  v-if-completely takes out the object or add to the Dom. on the other hand  v-show keeps the element without removing it
    it hides or shows it. From user point of view it is same
    -->
    <form id="frmAddNewUser" v-if="showForm" v-on:submit.prevent="saveUser">
      <div class="field">
        <label for="firstName">First Name:</label>
        <!--In order to bind input attribute to the user input review we will use  v-model 
        reason why we have named is newUser.firstName  object inside data has reviewer key-->
        <input type="text" name="firstName" v-model="newUser.firstName" />
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <!--In order to bind input attribute to the user input title we will use  v-model 
        reason why we have named is newUser.lastName  object inside data has lastName key-->
        <input type="text" name="lastName" v-model="newUser.lastName" />
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <!--In order to bind input attribute to the user input title we will use  v-model 
        reason why we have named is newUser.username  object inside data has username key-->
        <input type="text" name="username" v-model="newUser.username" />
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <!--In order to bind input attribute to the user input title we will use  v-model 
        reason why we have named is newUser.emailAddress  object inside data has emailAddress key-->
        <input type="text" name="emailAddress" v-model="newUser.emailAddress" />
      </div>
      <button type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "user-list",
  data() {
    return {
      showForm: false,
      isActive: false,
      selectedUserIDs: [],
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "",
      },
      newUser: {},
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active",
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active",
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Disabled",
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active",
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active",
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Disabled",
        },
      ],
    };
  },
  methods: {
    saveUser() {
      //the unshift method adds one or more elements to the begnning of an array and returns the new length of the array
      this.users.unshift(this.newUser);
      // when we call methods from another scope use this keyword
      this.resetForm();
    },
    resetForm() {
      //In order to reset newReview we will assign empty object where it originally started
      //then we will call it from addReview method because after each save we will empty form
      this.newReview = {};
      this.showForm = false;
    },
    flipStatus(id) {
      if (this.users[id - 1].status == "Active") {
        this.users[id - 1].status = "Disabled";
      } else {
        this.users[id - 1].status = "Active";
      }
    },
    deleteSelectedUsers(){
        for (let i = 0; i < this.users.length; i++) {
        for (let j = 0; j < this.selectedUserIDs.length; j++) {
          if (this.users[i].id === this.selectedUserIDs[j]) {
            this.users.splice(i, 1);
          }
        }
      }
    },
    enableSelectedUsers(){
        for (let i = 0; i < this.users.length; i++) {
        for (let j = 0; j < this.selectedUserIDs.length; j++) {
          if (this.users[i].id === this.selectedUserIDs[j]) {
            this.users[i].status = 'Active';
        }
      }
    }
    this.selectedUserIDs = [];
  },
   disableSelectedUsers(){
        for (let i = 0; i < this.users.length; i++) {
        for (let j = 0; j < this.selectedUserIDs.length; j++) {
          if (this.users[i].id === this.selectedUserIDs[j]) {
            this.users[i].status = 'Disabled';
        }
      }
    }
    this.selectedUserIDs = [];
   }
   
  },
  
  computed: {
    actionButtonDisabled(){
      return this.selectedUserIDs.length === 0;
    },
    filteredList() {
      let filteredUsers = this.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter(
          (user) => user.status === this.filter.status
        );
      }
      return filteredUsers;
    },
  },
}
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
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

form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>
