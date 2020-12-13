function apendImage($targetCard,imageResource){
    $targetCard.append($('<img>',imageResource));
}

let $card1 = $("#card1");
let imageResource = {'src' : 'img/black-circle.png'};
apendImage($card1,imageResource);

