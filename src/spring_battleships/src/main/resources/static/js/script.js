$(document).ready(function() {
    function createGrid(container) {
        for (let i = 0; i < 100; i++) {
   	        $(container).append('<div class="cell" data-index="' + i + '"></div>')
        }
    }
    console.log("asd")
    createGrid('#player1-grid')
    createGrid('#player2-grid')
})