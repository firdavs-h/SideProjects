
//functions
const waterInput = document.getElementById('wminput');
function showInput() {
    waterInput.classList.remove('hide');
};
function hideInput() {
    waterInput.classList.add('hide');
};


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
    fetch('http://localhost:8080/upload', requestOptions).then((response) => response).then((response) => {
        addResponse(response);
        return;
    });

};

function addResponse(resp) {
    const imgR = document.getElementById('img1');
    const saveLink = document.getElementById('save');
    let image = document.createElement('img')
    resp.arrayBuffer().then((buffer) => {
        let base64Flag = 'data:image/jpeg;base64,';
        let imageStr = arrayBufferToBase64(buffer);

        const link = base64Flag + imageStr;
        imgR.src = link;
        saveLink.href = link;
        saveLink.innerText = "Save Image";

    });


};
function arrayBufferToBase64(buffer) {
    let binary = '';
    let bytes = [].slice.call(new Uint8Array(buffer));
    bytes.forEach((b) => binary += String.fromCharCode(b));

    return window.btoa(binary);
};

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



