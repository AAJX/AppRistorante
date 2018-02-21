$(window).scroll(function () {
if ($(window).scrollTop() >= 50) {
$('.navbar').css('background','#24201d');
} else {
$('.navbar').css('background','transparent');
}
});