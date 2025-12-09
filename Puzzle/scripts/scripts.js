let grid; 
let size; 
let imageSrc; 
let isGameActive = false; 
let firstClickedTile = null; 
let isHintActive = false;

// MODIFIÉ : Largeur maximale d'affichage du puzzle (pour éviter qu'il soit trop grand)
const PUZZLE_MAX_WIDTH = 600; 
let imageDimensions = { width: 0, height: 0, display_width: 0, display_height: 0 }; 

function showSelector() {
    document.getElementById('level-selector').classList.add('active');
    document.getElementById('game-screen').classList.remove('active');
    isGameActive = false;
    isHintActive = false;
}

function initGame(s, src, difficultyName) {
    size = s;
    imageSrc = src;
    
    document.getElementById('current-difficulty').textContent = `Difficulté : ${difficultyName} (${size}x${size})`;
    
    document.getElementById('hint-image').src = imageSrc;
    document.getElementById('hint-image-container').classList.add('hidden');
    document.getElementById('help-button').textContent = "Afficher l'Image d'Aide";
    isHintActive = false;
    document.getElementById('puzzle-grid').classList.remove('disabled-for-hint');
    
    document.getElementById('level-selector').classList.remove('active');
    document.getElementById('game-screen').classList.add('active');

    loadImageAndCreateTiles();
}

function loadImageAndCreateTiles() {
    const img = new Image();
    img.onload = function() {
        imageDimensions.width = img.width;
        imageDimensions.height = img.height;
        
        let puzzleWidth, puzzleHeight;
        
        const aspectRatio = imageDimensions.width / imageDimensions.height;
        
        if (imageDimensions.width > PUZZLE_MAX_WIDTH) {
            puzzleWidth = PUZZLE_MAX_WIDTH;
            puzzleHeight = puzzleWidth / aspectRatio;
        } else {
            puzzleWidth = imageDimensions.width;
            puzzleHeight = imageDimensions.height;
        }
        
        const puzzleGrid = document.getElementById('puzzle-grid');
        puzzleGrid.style.width = `${puzzleWidth}px`;
        puzzleGrid.style.height = `${puzzleHeight}px`;

        imageDimensions.display_width = puzzleWidth;
        imageDimensions.display_height = puzzleHeight;
        
        puzzleGrid.style.gridTemplateColumns = `repeat(${size}, 1fr)`;
        puzzleGrid.style.gridTemplateRows = `repeat(${size}, 1fr)`;
        
        createTiles();
        isGameActive = true;
    };
    img.onerror = function() {
        alert("Erreur de chargement de l'image. Assurez-vous que le chemin est correct.");
        showSelector();
    };
    img.src = imageSrc;
}

function createTiles() {
    const puzzleGrid = document.getElementById('puzzle-grid');
    puzzleGrid.innerHTML = ''; 

    const totalTiles = size * size;
    let tiles = [];
    grid = []; 
    
    const puzzleWidth = imageDimensions.display_width;
    const puzzleHeight = imageDimensions.display_height;
    
    const tileWidth = puzzleWidth / size;
    const tileHeight = puzzleHeight / size; 

    for (let i = 0; i < totalTiles; i++) {
        const tile = document.createElement('div');
        tile.classList.add('tile');
        
        tile.dataset.correctId = i; 
        
        const col = i % size;
        const row = Math.floor(i / size);
        
        tile.style.width = `${tileWidth}px`;
        tile.style.height = `${tileHeight}px`;
        
        tile.style.backgroundSize = `${puzzleWidth}px ${puzzleHeight}px`;

        const backgroundX = -col * tileWidth;
        const backgroundY = -row * tileHeight;
        
        tile.style.backgroundImage = `url(${imageSrc})`;
        tile.style.backgroundPosition = `${backgroundX}px ${backgroundY}px`;
        
        tile.addEventListener('click', handleTileClick);
        tiles.push(tile);
    }
    
    shuffleArray(tiles); 

    for (let i = 0; i < totalTiles; i++) {
        const tile = tiles[i];
        puzzleGrid.appendChild(tile);
        
        const row = Math.floor(i / size);
        const col = i % size;
        
        if (!grid[row]) grid[row] = [];
        grid[row][col] = tile;
        
        tile.dataset.row = row;
        tile.dataset.col = col;
    }
    
    checkWin(); 
}

function shuffleArray(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
}

function handleTileClick(event) {
    if (!isGameActive || isHintActive) return;

    const clickedTile = event.currentTarget;
    
    if (clickedTile.classList.contains('locked-tile')) {
        return; 
    }
    
    if (firstClickedTile === null) {
        
        clickedTile.style.border = '3px solid #FFC107'; 
        firstClickedTile = clickedTile;
        
    } else if (firstClickedTile === clickedTile) {
        
        clickedTile.style.border = '1px solid #ccc'; 
        firstClickedTile = null;
        
    } else {
        
        const secondClickedTile = clickedTile;

        swapTilesInGrid(firstClickedTile, secondClickedTile);
        
        const tempRow = firstClickedTile.dataset.row;
        const tempCol = firstClickedTile.dataset.col;

        firstClickedTile.dataset.row = secondClickedTile.dataset.row;
        firstClickedTile.dataset.col = secondClickedTile.dataset.col;

        secondClickedTile.dataset.row = tempRow;
        secondClickedTile.dataset.col = tempCol;
        
        firstClickedTile.style.border = '1px solid #ccc';
        firstClickedTile = null;
        
        updateLockedTileBorders();
        checkWin();
    }
}

function swapTilesInGrid(tileA, tileB) {
    const parent = tileA.parentNode;
    const temp = document.createElement('div');
    
    parent.insertBefore(temp, tileA);
    parent.insertBefore(tileA, tileB);
    parent.insertBefore(tileB, temp);
    parent.removeChild(temp);
}

function checkWin() {
    const puzzleGrid = document.getElementById('puzzle-grid');
    const tiles = Array.from(puzzleGrid.children); 

    let isWin = true;
    for (let i = 0; i < tiles.length; i++) {
        const tile = tiles[i];
        const isCorrectlyPlaced = (parseInt(tile.dataset.correctId) === i);
        
        if (isCorrectlyPlaced) {
            if (!tile.classList.contains('locked-tile')) {
                tile.classList.add('locked-tile');
                tile.removeEventListener('click', handleTileClick); 
            }
        } else {
            isWin = false;
            if (tile.classList.contains('locked-tile')) {
                 tile.classList.remove('locked-tile');
                 tile.addEventListener('click', handleTileClick);
            }
        }
    }

    updateLockedTileBorders();

    if (isWin) {
        isGameActive = false;
        
        setTimeout(() => {
            alert(`Félicitations ! Vous avez résolu le puzzle ${size}x${size} !`);
            showSelector();
        }, 300);
    }
}

function updateLockedTileBorders() {
    const tiles = Array.from(document.getElementById('puzzle-grid').children);
    
    if (tiles.length === 0) return;
    
    const size = Math.sqrt(tiles.length); 

    tiles.forEach((tile, index) => {
        const row = Math.floor(index / size);
        const col = index % size;

        tile.classList.remove('border-top-locked', 'border-bottom-locked', 'border-left-locked', 'border-right-locked', 'border-default');

        if (tile.classList.contains('locked-tile')) {
            
            const neighbors = {
                top: row > 0 ? tiles[(row - 1) * size + col] : null,
                bottom: row < size - 1 ? tiles[(row + 1) * size + col] : null,
                left: col > 0 ? tiles[row * size + (col - 1)] : null,
                right: col < size - 1 ? tiles[row * size + (col + 1)] : null
            };

            if (!neighbors.top || !neighbors.top.classList.contains('locked-tile')) {
                tile.classList.add('border-top-locked');
            }

            if (!neighbors.bottom || !neighbors.bottom.classList.contains('locked-tile')) {
                tile.classList.add('border-bottom-locked');
            }
            
            if (!neighbors.left || !neighbors.left.classList.contains('locked-tile')) {
                tile.classList.add('border-left-locked');
            }

            if (!neighbors.right || !neighbors.right.classList.contains('locked-tile')) {
                tile.classList.add('border-right-locked');
            }
        } else {
            tile.classList.add('border-default');
        }
    });
}

function toggleHint() {
    const hintContainer = document.getElementById('hint-image-container');
    const puzzleGrid = document.getElementById('puzzle-grid');
    const button = document.getElementById('help-button');
    
    if (hintContainer.classList.contains('hidden')) {
        hintContainer.classList.remove('hidden');
        button.textContent = "Masquer l'Image d'Aide (Jeu Suspendu)";
        
        isHintActive = true;
        puzzleGrid.classList.add('disabled-for-hint');
    } else {
        hintContainer.classList.add('hidden');
        button.textContent = "Afficher l'Image d'Aide";
        
        isHintActive = false;
        puzzleGrid.classList.remove('disabled-for-hint');
    }
}


document.addEventListener('DOMContentLoaded', showSelector);