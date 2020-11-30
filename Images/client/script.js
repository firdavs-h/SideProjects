
//functions
const waterInput = document.getElementById('wminput');
function showInput() {
    waterInput.classList.remove('hide');
}
function hideInput() {
    waterInput.classList.add('hide');
}


function upload() {
    const inputFile = document.getElementById('file').files[0];
    const effectType = document.querySelector('input[name="effect-type"]:checked').value;
    const watermark = document.getElementById('watermark').value;


    let formData = new FormData();
    formData.append('file', inputFile);
    formData.append('effect-type', effectType);
    if (watermark) {
        formData.append('watermark', watermark);
    }


    const requestOptions = {
        method: 'POST',
        body: formData
    };
    fetch('http://localhost:8080/upload', requestOptions)
        .then((response) => {
            addResponse(response.blob());
        })
        .catch((error) => {

        });
}
function addResponse(resBlob) {
    const response = document.getElementById('response');
    let image = document.createElement('img')
    let objectURL = URL.createObjectURL(resBlob);
    image.src = objectURL;
    response.appendChild(image);
}

//event handlers

const water = document.getElementById('water');
water.addEventListener('click', (ev) => {
    ev.stopPropagation();
    showInput();
});

const radios = document.getElementById('radios');
radios.addEventListener('click', () => {
    hideInput();
});

const sbmt = document.getElementById('submit');
sbmt.addEventListener('click', (ev) => {
    ev.preventDefault();
    upload();
});



