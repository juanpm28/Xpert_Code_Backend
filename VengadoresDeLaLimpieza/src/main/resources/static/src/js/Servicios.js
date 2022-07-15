let servicios;
// Aquí se debe cambiar el URL del servicio en el BackEnd
const URL_MAIN ='http://localhost:8080/api/servicios/';
function addItems(lista_items) {
    fetch(URL_MAIN, {
        method: 'get'
    }).then(function(response) {
        response.json().then(function (json) {
            console.log(json);
            console.log(json.length);
            servicios=json;
            Array.from(json).forEach((item) => {
                lista_items.innerHTML += `<div class="card-deck">
                <div class="card" style="width: 18rem;">
                <img class="cont-imagen" role="img" src="/src/imagenes/${item.url_imagen}" class="card-img-top"  alt="..." >
                <div class="card-body">
                <div id="cinco-estrellas">
                <!--5 estrellas-->
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="gold" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/></svg> 
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="gold" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/></svg> 
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="gold" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/></svg> 
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="gold" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/></svg> 
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="gold" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/></svg> 
                </div>
                <h5 class="card-title">${item.nombre}</h5>
                <div id="precio-sku-contador">
                <p class="card-precio">$${item.precio}</p>
                <hr class="precio-barra"/>
                <p class="card-sku">SKU: ${item.sku}</p>
                <p>Ingresa el Día de tu Evento<input type="date"></input></p>
                <p>Ingresa la Hora de Limpieza<input type="time"></input></p>
                <hr class="barraFecha"/>
                </div>
                <a href="https://www.paypal.com/webapps/shoppingcart/error?flowlogging_id=f116914a394fa&code=GENERIC_ERROR&mfid=1656979172865_f116914a394fa" onclick="mostrar()"><button type="button" class="btn btn-primary btn-lg btn-block btnAgregar" onclick="mostrar()">Comprar</button></a>
                </div>
            </div>
            </div>
            `;
            }); // foreach
        });//then
    }).catch(function(err) {
        console.log(err);
    });
    console.log(document.getElementById("lista_items"));
   
}// addItems

window.addEventListener("load", function (){
    let div = document.getElementById("lista_items");
    addItems(div);
   
});
