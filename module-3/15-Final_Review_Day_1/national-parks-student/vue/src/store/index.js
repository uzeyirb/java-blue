import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    parks: [
      {
          parkCode: 'acad',
          url: 'https://www.nps.gov/acad/index.htm',
          fullName: 'Acadia National Park',
          Description: 'Acadia National Park protects the natural beauty of the highest rocky headlands along the Atlantic coastline of the United States, an abundance of habitats, and a rich cultural heritage. At 3.5 million visits a year, it is one of the top 10 most-visited national parks in the United States. Visitors enjoy 27 miles of historic motor roads, 158 miles of hiking trails, and 45 miles of carriage roads',
          state: 'ME',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/3C7B45AE-1DD8-B71B-0B7EE131C7DFC2F5.jpg'
      },
      {
          parkCode: 'arch',
          url: 'https://www.nps.gov/arch/index.htm',
          fullName: 'Arches National Park',
          Description: 'Visit Arches to discover a landscape of contrasting colors, land forms, and textures unlike any other in the world. The park has over 2,000 natural stone arches and hundreds of soaring pinnacles, massive rock fins, and giant balanced rocks. This red-rock wonderland will amaze you with its formations, refresh you with its trails, and inspire you with its sunsets.',
          state: 'UT',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/3C79931C-1DD8-B71B-0BF201E3DB540D04.jpg'
      },
      {
          parkCode: 'cany',
          url: 'https://www.nps.gov/cany/index.htm',
          fullName: 'Canyonlands National Park',
          Description: 'Canyonlands invites you to explore a wilderness of countless canyons and fantastically formed buttes carved by the Colorado River and its tributaries. Rivers divide the park into four districts: Island in the Sky, The Needles, The Maze, and the rivers themselves. These areas share a primitive desert atmosphere, but each offers different opportunities for sightseeing and adventure.',
          state: 'UT',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/3C7A525D-1DD8-B71B-0B8E59D2EB39F6D0.jpg'
      },
      {
          parkCode: 'cuva',
          url: 'https://www.nps.gov/cuva/index.htm',
          fullName: 'Cuyahoga Valley National Park',
          Description: 'Though a short distance from the urban areas of Cleveland and Akron, Cuyahoga Valley National Park seems worlds away. The park is a refuge for native plants and wildlife, and provides routes of discovery for visitors. The winding Cuyahoga River gives way to deep forests, rolling hills, and open farmlands. Walk or ride the Towpath Trail to follow the historic route of the Ohio & Erie Canal.',
          state: 'OH',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/F7425874-D97F-BFD6-36581A36C8A7FF0D.jpg'
      },
      {
          parkCode: 'hocu',
          url: 'https://www.nps.gov/hocu/index.htm',
          fullName: 'Hopewell Culture National Historical Park',
          Description: 'Nearly 2000 years ago, American Indians built dozens of monumental mounds and earthen enclosures in southern Ohio. These earthwork complexes were ceremonial landscapes used for feasts, funerals, rituals, and rites of passage associated with an American Indian religious movement that swept over half the continent for almost 400 years. Come walk among the earthworks and experience the past.',
          state: 'OH',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/0C0231CE-C54D-AE33-ACAB8874C99A1B84.jpg'
      },
      {
          parkCode: 'pevi',
          url: 'https://www.nps.gov/pevi/index.htm"',
          fullName: 'Perrys Victory & International Peace Memorial',
          Description: 'Perrys Victory and International Peace Memorial was established to honor those who fought in the Battle of Lake Erie, during the War of 1812, and to celebrate the long-lasting peace among Great Britain, Canada and the U.S. The Memorial, a Doric column, rising 352 feet over Lake Erie is situated 5 miles from the longest undefended border in the world.',
          state: 'OH',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/2BC16FA1-DAB7-749D-EE14D8769B9C5273.jpg'
      },
      {
          parkCode: 'badl',
          url: 'https://www.nps.gov/badl/index.htm',
          fullName: 'Badlands National Park',
          Description: 'The rugged beauty of the Badlands draws visitors from around the world. These striking geologic deposits contain one of the world’s richest fossil beds. Ancient horses and rhinos once roamed here. The park’s 244,000 acres protect an expanse of mixed-grass prairie where bison, bighorn sheep, prairie dogs, and black-footed ferrets live today.',
          state: 'SD',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/3C82EBFE-1DD8-B71B-0B21072718DB2A95.jpg'
      },
      {
          parkCode: 'moru',
          url: 'https://www.nps.gov/moru/index.htm',
          fullName: 'Mount Rushmore National Memorial',
          Description: 'Majestic figures of George Washington, Thomas Jefferson, Theodore Roosevelt and Abraham Lincoln, surrounded by the beauty of the Black Hills of South Dakota, tell the story of the birth, growth, development and preservation of this country. From the history of the first inhabitants to the diversity of America today, Mount Rushmore brings visitors face to face with the rich heritage we all share.',
          state: 'SD',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/3C7C7FCF-1DD8-B71B-0B1C13F43534232D.jpg'
      },
      {
          parkCode: 'deva',
          url: 'https://www.nps.gov/deva/index.htm',
          fullName: 'Death Valley National Park',
          Description: 'In this below-sea-level basin, steady drought and record summer heat make Death Valley a land of extremes. Yet, each extreme has a striking contrast. Towering peaks are frosted with winter snow. Rare rainstorms bring vast fields of wildflowers. Lush oases harbor tiny fish and refuge for wildlife and humans. Despite its morbid name, a great diversity of life survives in Death Valley.',
          state: 'CA',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/010A933C-95B1-CBCD-D6D64D47D5B81E76.jpg'
      },
      {
          parkCode: 'jotr',
          url: 'https://www.nps.gov/jotr/index.htm',
          fullName: 'Joshua Tree National Park',
          Description: 'Two distinct desert ecosystems, the Mojave and the Colorado, come together in Joshua Tree National Park. A fascinating variety of plants and animals make their homes in a land sculpted by strong winds and occasional torrents of rain. Dark night skies, a rich cultural history, and surreal geologic features add to the wonder of this vast wilderness in southern California. Come explore for yourself.',
          state: 'CA',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/306D0D93-9CCA-76E1-AD48268F8D7A7E3E.jpg'
      },
      {
          parkCode: 'cuga',
          url: 'https://www.nps.gov/cuga/index.htm',
          fullName: 'Cumberland Gap National Historical Park',
          Description: 'At Cumberland Gap, the first great gateway to the west, follow the buffalo, the Native American, the longhunter, the pioneer... all traveled this route through the mountains into the wilderness of Kentucky. Modern day explorers and travelers stand in awe at this great gateway and the many miles of trails and scenic features found in the park.',
          state: 'KY',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/3C87BA5D-1DD8-B71B-0B9E79FC9A030567.jpg'
      },
      {
          parkCode: 'maca',
          url: 'https://www.nps.gov/maca/index.htm',
          fullName: 'Mammoth Cave National Park',
          Description: 'Rolling hills, deep river valleys, and the worlds longest known cave system. Mammoth Cave National Park is home to thousands of years of human history and a rich diversity of plant and animal life, earning it the title of UNESCO World Heritage Site and International Biosphere Reserve.',
          state: 'KY',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/94A76787-FA1B-8DC8-71277FDFA5E7CC79.jpg'
      },
      {
          parkCode: 'deto',
          url: 'https://www.nps.gov/deto/index.htm',
          fullName: 'Devils Tower National Monument',
          Description: 'The Tower is an astounding geologic feature that protrudes out of the prairie surrounding the Black Hills. It is considered sacred by Northern Plains Indians and indigenous people. Hundreds of parallel cracks make it one of the finest crack climbing areas in North America. Devils Tower entices us to learn more, explore more and define our place in the natural and cultural world.',
          state: 'WY',
          image_url: 'https://www.nps.gov/common/uploads/structured_data/3C812956-1DD8-B71B-0B0AB4D807441C9D.jpg'
      }
    ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
