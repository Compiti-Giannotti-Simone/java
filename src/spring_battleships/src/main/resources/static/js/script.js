let nextShipSize
const possibleColors = ['#ed5f55','#f7ac57','#cfed55','#55eda6','#64f0f5','#8164f5','#c564f5','#ff8cd7','#a86f1e']

function getNextSize() {
    $.ajax({
        method: 'GET',
        url: '/get-next-size',
        success: function(data) {
            nextShipSize = data
        }
    })
}

function createGrid(container, enemy) {
    const gridContainer = document.querySelector(container)
    const size = 10
        for (let i = 0; i < size * size; i++) {
        const gridItem = document.createElement('div')
        gridItem.setAttribute("data-index",i)
        gridItem.classList.add('cell')
        gridItem.style.backgroundColor = '#fff'
        if(enemy) gridItem.addEventListener("click",attack);
        else {
            gridItem.addEventListener("click",placeShip);
            gridItem.addEventListener("mouseover",previewShip);
            gridItem.addEventListener("mouseout",unpreviewShip);
        }
        gridContainer.appendChild(gridItem)
    }
}

function unpreviewShip(event) {
    const hovered = parseInt(event.target.getAttribute('data-index'))
    const isHorizontal = parseInt(document.querySelector('#direction-select').value)
    if(isHorizontal == 0) {
        for(let i = 0; i < nextShipSize; i++) {
            if(hovered + ((nextShipSize-1)*10) < 100) {
            let index = hovered + (i*10)
            const cell = document.querySelector('#player1-grid').querySelector('[data-index="'+index+'"')
            cell.classList.remove('preview')
            }
        }
    }
    else {
        for(let i = 0; i < nextShipSize; i++) {
            const row = Math.floor(hovered/10)
            if(hovered + (nextShipSize-1) < (row+1)*10) {
            let index = hovered + i
            const cell = document.querySelector('#player1-grid').querySelector('[data-index="'+index+'"')
            cell.classList.remove('preview')
            }
        }
    }
}

function previewShip(event) {
    const hovered = parseInt(event.target.getAttribute('data-index'))
    const isHorizontal = parseInt(document.querySelector('#direction-select').value)
    if(isHorizontal == 0) {
        for(let i = 0; i < nextShipSize; i++) {
            if(hovered + ((nextShipSize-1)*10) < 100) {
            let index = hovered + (i*10)
            const cell = document.querySelector('#player1-grid').querySelector('[data-index="'+index+'"')
            cell.classList.add('preview')
            }
        }
    }
    else {
        for(let i = 0; i < nextShipSize; i++) {
            const row = Math.floor(hovered/10)
            if(hovered + (nextShipSize-1) < (row+1)*10) {
            let index = hovered + i
            const cell = document.querySelector('#player1-grid').querySelector('[data-index="'+index+'"')
            cell.classList.add('preview')
            }
        }
    }
}

function placeRandom() {
    $.ajax({
        async: false,
        method: 'GET',
        url: '/place/random'
    })
    updatePlayerGrid()
}

function clearShips() {
    $.ajax({
        async: false,
        method: 'GET',
        url: '/clear-ships'
    })
    updatePlayerGrid()
}

function placeShip(event) {
    const clicked = event.target.getAttribute('data-index')
    const isHorizontal = parseInt(document.querySelector('#direction-select').value)
    console.log(clicked)
    $.ajax({
        async: false,
        method: 'GET',
        url: '/place/' + clicked + "/" + isHorizontal,
    })
    getNextSize()
    updatePlayerGrid()
}

function attack(event) {
    const clicked = event.target.getAttribute('data-index')
    console.log(clicked)
}

function updatePlayerGrid() {
    $.ajax( {
        url: '/get-player-grid',
        method: 'GET',
        success: function(data) {
            document.querySelector('#player1-grid').querySelectorAll('.cell').forEach(element => {
                element.style.backgroundColor = '#fff'
            })
            let i = 0
            data.forEach(ship => {
                console.log(ship.nodes)
                ship.nodes.forEach(node => {
                    let index = node.position.posy*10
                    index += node.position.posx
                    document.querySelector('#player1-grid').querySelector('[data-index="'+index+'"').style.backgroundColor = possibleColors[i]
                    console.log(index)
                })
                i++
            })
            
        },
    })
}

$(document).ready(function() {
    document.querySelector('#randomize-button').addEventListener('click',placeRandom)
    document.querySelector('#clear-button').addEventListener('click',clearShips)
    createGrid('#player1-grid',false)
    createGrid('#player2-grid',true)
    updatePlayerGrid()
    getNextSize()
})