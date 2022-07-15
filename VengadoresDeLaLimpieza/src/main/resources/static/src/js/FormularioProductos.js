let nombreImg = "";
const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
const expresiones = {
	nombre: /^[a-zA-Z0-9-ZÀ-ÿ-.\s]{3,60}$/, // nombre=producto Letras, números y espacios, pueden llevar acentos.
	sku: /^[A-Z0-9-ZÀ-ÿ\s]{8,12}$/, // SKU Letras, numeros, guion y guion_bajo
    precio : /^[0-9.\s]{1,6}$/, // Precio núemros y punto . 
}
const campos = {
	nombre: false,
    sku: false,
    precio : false
}
const validarFormulario = (e) => {
	switch (e.target.name) {
		case "nombre":
			validarCampo(expresiones.nombre, e.target, 'nombre');
		break;
        case "sku":
			validarCampo(expresiones.sku, e.target, 'sku');
		break;
        case "precio":
			validarCampo(expresiones.precio , e.target, 'precio');
		break;
	}
}
const validarCampo = (expresion, input, campo) => {
	if(expresion.test(input.value.trim())){
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos[campo] = true;
	} else {
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
		campos[campo] = false;
	}
} //puntero del mouse
inputs.forEach((input) => {
	input.addEventListener('keyup', validarFormulario);
	input.addEventListener('blur', validarFormulario);
});

let nombre = document.getElementById("nombre");
let sku = document.getElementById("sku");
let precio = document.getElementById("precio");
let imagen = document.getElementById("inputFile");
let vis = document.getElementById("imageFile");
let botonEnviar=document.getElementById("botonEnviar");

botonEnviar.addEventListener("click", (event)=> {
event.preventDefault();
if(campos.nombre && campos.sku && campos.precio){
	


	/*
const imageFormulario = document.getElementById("imageForm");
const fileImage = document.getElementById("fileImage");

imageFormulario.addEventListener("submit", e => {
e.preventDefault();

const formData = new FormData();

console.log(fileImage.files);

formData.append("fileImage", fileImage.files[0]);

fetch(URL_MAIN, {
	method: 'post',
	body: formData
}).catch((error) => {
console.error('Error:', error);
})

})*/

const URL_MAIN ='http://localhost:8080/api/productoslimpieza/';
///// El siguiente código agrega un nuevo producto mediante un POST
const data =     {nombre: nombre.value,
precio: precio.value,
sku: sku.value,
url_imagen: nombreImg
};

fetch(URL_MAIN, {
method: 'POST', // or 'PUT'
headers: {
'Content-Type': 'application/json',
},
body: JSON.stringify(data),
})
.then(response => response.json())
.catch((error) => {
console.error('Error:', error);
})
.then(data => {
console.log('Success:', data);
})

	
	Swal.fire({
		icon: 'success',
		title: '¡REGISTRO EXITOSO!',
		showConfirmButton: false,
		timer: 2000
	  })

	  // formulario de productos



// let registro = `
// {"nombre" : "${nombre.value}",
// "img" : "${imagen.value}",
// "precio" : "${precio.value}",
// "sku" : "${sku.value}"}`;
// //DEl JSON a Productos De Limpieza
// tmp = JSON.parse(localStorage.getItem("productosLimpieza"));
// tmp.push(JSON.parse(registro));
// // Crear de nuevo el JSON
// localStorage.setItem("productosLimpieza", JSON.stringify(tmp));

}else { 
	Swal.fire({
		icon: 'error',
		title: 'Por favor rellena los campos correctamente',
		text: 'Intenta de nuevo',
		
	  });
	  setTimeout (function(){
	  window.location.reload();
	  }, 2000
	  )
	}
});

botonEnviar.addEventListener("click", (event) =>{
	nombre.value = "";
	sku.value = "";
	precio.value = "";
	imagen.value = "";
	vis.src = "/src/imagenes/pix_white.png";
	nombre.focus();
})



//******************************Imagen*********************************


let fileImage = document.getElementById('fileImage');
	let btnFake = document.getElementById('btnFake');
	let imageFile = document.getElementById('imageFile');
	let selectImages = document.getElementById('selectImages');
	let store = {'names':[], 'data': []};

	window.addEventListener('load', function(e){
		console.log("store.data:" + store.data);
		console.log(localStorage.getItem("imgsData"));
		if ( JSON.parse(localStorage.getItem("imgsData"))!=null)
			store = JSON.parse(localStorage.getItem("imgsData"));
		
//		fillSelect();
	});
//Imagen
/*	function fillSelect(){
		if (store.data.length>0) {
			selectImages.options.length = 0; // clear Select
			let optiontmp = document.createElement("option");
				optiontmp.text = "Selecciona una imagen para visualizar:"
				optiontmp.value = -1;
				selectImages.add(optiontmp); 
			for (let i=0; i < store.data.length; i ++){
				let option = document.createElement("option");
				option.text = store.names[i];
				option.value = i;
				selectImages.add(option); 
			}//for i
		}//if store != null
		console.log(store);
	}//fillSelect

**/

	btnFake.addEventListener('click', function(){
		fileImage.click();
    });
    fileImage.addEventListener('change', function(){
        previewFile('imageFile', 'fileImage', 'inputFile' )
        //previewFile(id imagen, input type file , textArea);
    });

		//previewFile(id imagen, input type file , textArea);
		function previewFile(img, inputFile, input) {
			let preview = document.getElementById(img);
			let file    = document.getElementById(inputFile).files[0];
			let reader  = new FileReader();

			reader.addEventListener("load", function () {
				console.log(store.data.length);
				store.data[store.data.length] = reader.result;
				store.names[store.names.length] =file.name;
				nombreImg = file.name;
				console.log(nombreImg);
				console.table(store);
				document.getElementById(input).value = reader.result;
		  		preview.src = reader.result;
				localStorage.setItem("imgsData", JSON.stringify(store));
				fillSelect();
		  	}, false);
			
		  	if (file) {
		    	reader.readAsDataURL(file);
		  	}// file
		}// previewFile 


//		selectImages.addEventListener("change", function(){
//			imageFile.src = store.data[selectImages.options[selectImages.selectedIndex].value];
//		});
//******************************Imagen*********************************


		
