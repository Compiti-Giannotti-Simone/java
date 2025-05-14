function createGrid(container) {
    const gridContainer = document.querySelector(container)
    const size = 10
        for (let i = 0; i < size * size; i++) {
        const gridItem = document.createElement('div')
        gridItem.setAttribute("data-index",i)
        gridItem.classList.add('cell')
        gridContainer.appendChild(gridItem)
    }
}

$(document).ready(function() {
    createGrid('#player1-grid')
    createGrid('#player2-grid')
})