const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
	nombre: /^[a-zA-ZÀ-ÿ\s]{3,60}$/, // Letras y espacios, pueden llevar acentos.
	correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	telefono: /^\d{10,10}$/, // 10 a 10 numeros.
    mensaje: /^[a-zA-Z0-9-ZÀ-ÿ_.:=$+-?¿¡!/%#"*())\s]{10,250}$/, // Letras, numeros, guion y guion_bajo
}
const campos = {
	nombre: false,
	correo: false,
	telefono: false,
    mensaje: false
}
const validarFormulario = (e) => {
	switch (e.target.name) {
		case "nombre":
			validarCampo(expresiones.nombre, e.target, 'nombre');
		break;
		case "correo":
			validarCampo(expresiones.correo, e.target, 'correo');
		break;
		case "telefono":
			validarCampo(expresiones.telefono, e.target, 'telefono');
		break;
        case "mensaje":
			validarCampo(expresiones.mensaje, e.target, 'mensaje');
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
/* let input = document.querySelectorAll('input');
input.addEventListener('input',function(){
     this.value = this.value.trim();
}) */

inputs.forEach((input) => {
	input.addEventListener('keyup', validarFormulario);
	input.addEventListener('blur', validarFormulario);
});

let btnContacto = document.getElementById("btnContacto");

btnContacto.addEventListener("click", (event)=> {
    event.preventDefault();
    if(campos.nombre && campos.correo && campos.telefono && campos.mensaje){
        Swal.fire({
            icon: 'success',
            title: '¡Tu mensaje ha sido enviado a nuestros Vengadores!',
            showConfirmButton: false,
            timer: 3500
          })
       window.location='../pages/Contactanos.html';
       return;
    }
    else{ 
    Swal.fire({
        icon: 'error',
        title: 'Por favor, rellena los campos correctamente',
        text: 'Intenta de nuevo',

      });
      return;
    }
}); 