import axios from 'axios';


/*
.get(endpoint)
.delete(endpoint)
.post(endpoint, objectToCreateTheJSON)
.put(endpoint, objectToCreateTheJSON)
*/
export default{
    getParks(){
        return axios.get('/parks');
    },
    addItinerary(itinerary){
        return axios.post("/itenaries", itinerary)
    }
}