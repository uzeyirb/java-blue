const clickedText = "You did it!  You clicked the Shinny Red Button!!";

document.addEventListener('DOMContentLoaded', () =>{

    document.querySelector('input[type=button]').addEventListener('click', (eventObj) =>{
        console.log(eventObj);
        document.getElementById('showText').innerText = clickedText;
    });

});


