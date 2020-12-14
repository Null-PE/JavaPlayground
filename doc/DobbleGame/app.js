function apendImage($targetCard,imageResourceArray){
    imageResourceArray.forEach(element => {
        $appendImage = $('<img>',element);
        $appendImage.addClass('character-image');
        $targetCard.append($appendImage);
    });
}

const numberOfImagesInCard = 8;

function pickUpAndRemoveRandomImages(targetImageRersourceArray){
    let returnArray = [];
    for(let i=0;i<numberOfImagesInCard -1;i++){
        let randomIndex = Math.floor( (Math.random() * targetImageRersourceArray.length));
        returnArray.push(targetImageRersourceArray[randomIndex]);
        targetImageRersourceArray.splice(randomIndex,1);
    }
    return returnArray;
}


let imageResources =  [{'src':'img/black-circle.png'},
{'src':'img/black-square.png'},
{'src':'img/black-triangle.png'},
{'src':'img/red-circle.png'},
{'src':'img/red-square.png'},
{'src':'img/red-triangle.png'},
{'src':'img/yellow-circle.png'},
{'src':'img/yellow-square.png'},
{'src':'img/yellow-triangle.png'},
{'src':'img/green-circle.png'},
{'src':'img/green-square.png'},
{'src':'img/green-triangle.png'},
{'src':'img/blue-circle.png'},
{'src':'img/blue-square.png'},
{'src':'img/blue-triangle.png'}
];

let $card1 = $("#card1");
let $card2 = $("#card2");
apendImage($card1,pickUpAndRemoveRandomImages(imageResources));
apendImage($card2,pickUpAndRemoveRandomImages(imageResources));

