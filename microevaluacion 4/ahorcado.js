const palabraClave = "platano";
let erroresAcumulados = 0; // contador persistente

document.addEventListener("DOMContentLoaded", () => {
  const formulario = document.getElementById("formulario");
  formulario.addEventListener("submit", (event) => {
    event.preventDefault();
    verificar();
  });

  // Boton nuevo → limpiar juego
  document.getElementById("nuevo").addEventListener("click", limpiar);
});

function verificar() {
  let letras = []; //arreglo vacio para guardar las letras que el jugador ingresa
  for (let i = 1; i <= 7; i++) { //recorre los 7 campos
    let campo = document.getElementById("letra" + i); //obtenemos el campo de texto por su ID
    //tomamos el valor del campo, elmiminamos espacios y lo convertimos a minuscula
    let valor = campo.value.trim().toLowerCase(); // ignorar espacios
    letras.push(valor); //guardamos esa letra en el arreglo letras
  }

  let resultado = ""; //inicializamos la variable resultado como cadena vacia

  //recorremos cada letra de la palabra clave
  for (let i = 0; i < palabraClave.length; i++) {
    if (letras[i] === "") { //si el campo esta vacio dejamos _
      resultado += "_ ";
    } else if (letras[i] === palabraClave[i]) { //si la letra ingresada coincide con la letra de la palabra clave se agrega la letra correcta al resultado
      resultado += letras[i] + " ";
    } else {
      resultado += "_ "; //mostramos guion bajo en el resultado
      document.getElementById("letra" + (i+1)).value = ""; // borramos la letra incorrecta
      erroresAcumulados++; //sumamos un error al contador
    }
  }

  document.getElementById("resultado").innerText = resultado.trim();

  // Marcar partes del cuerpo segun errores acumulados
  if (erroresAcumulados >= 1) document.getElementById("cabeza").value = "X";
  if (erroresAcumulados >= 2) document.getElementById("brazos").value = "X";
  if (erroresAcumulados >= 3) document.getElementById("cuerpo").value = "X";
  if (erroresAcumulados >= 4) document.getElementById("piernas").value = "X";
  if (erroresAcumulados >= 5) document.getElementById("pies").value = "X";

  // Si ya perdio (todas las partes con X), limpiar automaticamente
  if (erroresAcumulados >= 5) {
    alert("¡Perdiste! Se reinicia el juego.");
    limpiar();
  }
}

function limpiar() {
  // Reiniciar contador
  erroresAcumulados = 0;

  // Limpiar partes del cuerpo
  document.getElementById("cabeza").value = "";
  document.getElementById("brazos").value = "";
  document.getElementById("cuerpo").value = "";
  document.getElementById("piernas").value = "";
  document.getElementById("pies").value = "";

  // Limpiar letras
  for (let i = 1; i <= 7; i++) {
    document.getElementById("letra" + i).value = "";
  }

  // Reiniciar resultado
  document.getElementById("resultado").innerText = "_ _ _ _ _ _ _";
}
