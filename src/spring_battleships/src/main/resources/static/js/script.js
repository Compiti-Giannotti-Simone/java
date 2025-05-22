let nextShipSize
let gameInProgress
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
        if(enemy) gridItem.addEventListener("click",playerAttack);
        else {
            gridItem.addEventListener("click",placeShip);
            gridItem.addEventListener("mouseover",previewShip);
            gridItem.addEventListener("mouseout",unpreviewShip);
        }
        gridContainer.appendChild(gridItem)
    }
}

function unpreviewShip(event) {
    if(gameInProgress == 0) {
        const hovered = parseInt(event.target.getAttribute('data-index'))
        const isHorizontal = parseInt(document.querySelector('#direction-select').value)
        if (isHorizontal == 0) {
            for (let i = 0; i < nextShipSize + 1; i++) {
                if (hovered + ((nextShipSize - 1) * 10) < 100) {
                    let index = hovered + (i * 10)
                    const cell = document.querySelector('#player1-grid').querySelector('[data-index="' + index + '"')
                    cell.classList.remove('preview')
                }
            }
        } else {
            for (let i = 0; i < nextShipSize + 1; i++) {
                const row = Math.floor(hovered / 10)
                if (hovered + (nextShipSize - 1) < (row + 1) * 10) {
                    let index = hovered + i
                    const cell = document.querySelector('#player1-grid').querySelector('[data-index="' + index + '"')
                    cell.classList.remove('preview')
                }
            }
        }
    }
}

function previewShip(event) {
    if(gameInProgress == 0) {
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
}

function placeRandom() {
    if(gameInProgress == 0) {
        nextShipSize = 0
        $.ajax({
            method: 'POST',
            url: '/place/random',
            success: function () {
                updatePlayerGrid()
                //document.querySelector('#randomize-button').setAttribute('disabled', true)
            }
        })
    }
}

function clearShips() {
    if(gameInProgress == 0) {
        nextShipSize = 4
        $.ajax({
            method: 'POST',
            url: '/clear-ships',
            success: function () {
                updatePlayerGrid()
                //document.querySelector('#randomize-button').removeAttribute('disabled')
            }
        })
    }
}

function placeShip(event) {
    if(gameInProgress == 0) {
        //document.querySelector('#randomize-button').setAttribute('disabled', true)
        const clicked = event.target.getAttribute('data-index')
        const isHorizontal = parseInt(document.querySelector('#direction-select').value)
        $.ajax({
            method: 'POST',
            url: '/place/' + clicked + "/" + isHorizontal,
            success: function () {
                getNextSize()
                updatePlayerGrid()
            }
        })
    }
}

function playerAttack(event) {
    const clicked = event.target.getAttribute('data-index')
    $.ajax( {
        url: '/p1-attack/' + clicked,
        method: 'GET',
        success: function(data) {
            updateEnemyGrid()
            switch (data) {
                case 0:
                    document.querySelector('#player-result').innerHTML = "Missed!"
                    break;
                case 1:
                    document.querySelector('#player-result').innerHTML = "Hit!"
                    break;
                case 2:
                    document.querySelector('#player-result').innerHTML = "Hit and sunk!"
                    break;
                case 3:
                    showWinScreen(1)
                    break;
                default:
                    break;
            }
            if(data != 3) enemyAttack()
        },
        error: function() {
        }
    })
}

function enemyAttack() {
    $.ajax( {
        url: '/p2-attack',
        method: 'GET',
        success: function(data) {
            updatePlayerGrid()
            switch (data) {
                case 0:
                    document.querySelector('#enemy-result').innerHTML = "Missed!"
                    break;
                case 1:
                    document.querySelector('#enemy-result').innerHTML = "Hit!"
                    break;
                case 2:
                    document.querySelector('#enemy-result').innerHTML = "Hit and sunk!"
                    break;
                case 3:
                    showWinScreen(2)
                    break;
                default:
                    break;
            }
        },
    })
}

function updatePlayerGrid() {
    $.ajax( {
        url: '/get-player-board',
        method: 'GET',
        success: function(data) {
            let ships = data.ships
            let attacks = data.attackedList
            document.querySelector('#player1-grid').querySelectorAll('.cell').forEach(element => {
                element.classList.remove('preview')
                element.style.backgroundColor = '#ffffff'
            })
            let i = 0
            ships.forEach(ship => {
                ship.nodes.forEach(node => {
                    let index = node.position.posy*10
                    index += node.position.posx
                    document.querySelector('#player1-grid').querySelector('[data-index="'+index+'"').style.backgroundColor = possibleColors[i]
                })
                i++
            })
            document.querySelector('#player1-grid').querySelectorAll('.cell').forEach(element => {
                element.innerHTML = ""
            })
            attacks.forEach(node => {
                let index = node.position.posx + node.position.posy * 10
                const cellHit = document.querySelector('#player1-grid').querySelector('[data-index="' + index + '"]')
                if(node.hit) {
                    cellHit.innerHTML = "X"
                }
                else {
                    cellHit.innerHTML = "~"
                }
            })
        },
    })
}

function updateEnemyGrid() {
    $.ajax( {
        url: '/get-player-hits',
        method: 'GET',
        success: function(data) {
            document.querySelector('#player2-grid').querySelectorAll('.cell').forEach(element => {
                element.innerHTML = ""
            })
            data.forEach(node => {
                let index = node.position.posx + node.position.posy * 10
                const cellHit = document.querySelector('#player2-grid').querySelector('[data-index="' + index + '"]')
                if(node.hit) {
                    cellHit.innerHTML = "X"
                }
                else {
                    cellHit.innerHTML = "~"
                }
            })
        },
    })
}

function startGame() {
    $.ajax( {
        url: '/start-game',
        method: 'POST',
        success: showMidGame(),
    })
}

function restartGame() {
    $.ajax( {
        url: '/reset',
        method: 'POST',
        success: function() {
            showSetupElements()
            updateEnemyGrid()
            updatePlayerGrid()
        },
    })
}

function showSetupElements() {
    //document.querySelector('#randomize-button').removeAttribute('disabled')
    document.querySelector('#pregame-container').classList.remove('d-none')
    document.querySelector('#attack-results').classList.add('d-none')
    document.querySelector('#postgame-container').classList.add('d-none')
    document.querySelector('#subtitle').innerHTML = "Place your ships!"
}

function showWinScreen(winner) {
    document.querySelector('#pregame-container').classList.add('d-none')
    document.querySelector('#attack-results').classList.add('d-none')
    document.querySelector('#postgame-container').classList.remove('d-none')
    document.querySelector('#subtitle').innerHTML = "Game over!"
    if(winner == 1) {
        document.querySelector('#winner-field').innerHTML = "You win!"
    }
    else if(winner == 2) {
        document.querySelector('#winner-field').innerHTML = "You lose!"
    }
    else {
    }
}

function showMidGame() {
    document.querySelector('#pregame-container').classList.add('d-none')
    document.querySelector('#attack-results').classList.remove('d-none')
    document.querySelector('#postgame-container').classList.add('d-none')
    document.querySelector('#subtitle').innerHTML = "Attack your opponent!"
}

function checkGameProgress() {
    $.ajax({
        url: '/check-progress',
        method: 'GET',
        success: function (data) {
            gameInProgress = data
            switch (data) {
                case 0:
                    showSetupElements()
                    break;
                case 1:
                    showMidGame()
                    break;
                case 2:
                    showWinScreen(0)
                    break;
                default:
                    break;
            }
        }
    })
}

$(document).ready(function() {
    document.querySelector('#pregame-container').classList.add('d-none')
    document.querySelector('#attack-results').classList.add('d-none')
    document.querySelector('#postgame-container').classList.add('d-none')
    document.querySelector('#randomize-button').addEventListener('click',placeRandom)
    document.querySelector('#clear-button').addEventListener('click',clearShips)
    document.querySelector('#start-button').addEventListener('click',startGame)
    document.querySelector('#restart-button').addEventListener('click',restartGame)
    createGrid('#player1-grid',false)
    createGrid('#player2-grid',true)
    checkGameProgress()
    updatePlayerGrid()
    updateEnemyGrid()
    getNextSize()
})