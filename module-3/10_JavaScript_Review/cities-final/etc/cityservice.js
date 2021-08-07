function getCities() {
    fetch('https://5f9719b611ab98001603b7c0.mockapi.io/api/cities').then( response => {
        return response.json();
    }).then( data => {
        cities = data;
        console.table(cities);
        showAllCities();
    })
}



