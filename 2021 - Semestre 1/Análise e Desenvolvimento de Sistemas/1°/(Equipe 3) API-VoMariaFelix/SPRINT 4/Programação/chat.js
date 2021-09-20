var btn = document.getElementById('btn-div');
var container2 = document.querySelector('.container2');
var chat2 = document.querySelector('.chat2');
var exit = document.querySelector('.exit');
btn.addEventListener('click', function() {
    
if(container2.style.display === 'block') {
    container2.style.display = 'none';
    chat2.style.display = 'block';
} else {
    container2.style.display = 'block';
    chat2.style.display = 'none';
}

if(chat2.style.display === 'none') {
    exit.style.display = 'block';
} else {
    exit.style.display = 'none';
}

if(container2.style.display === 'block') {
    carousel-control.style.position == 'fixed';
} else {
    carousel-control.style.position == 'absolute';
}
});