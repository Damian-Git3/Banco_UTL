// Función para retiro local
function retiroLocal() {
  // Realizar la petición de retiro local
  let numeroTarjeta = document.getElementById('numeroTarjeta').value;
  let nip = document.getElementById('nip').value;
  let cantidadRetiro = document.getElementById('cantidadRetiro').value;

  const url = "http://localhost:8080/Banco_UTL/api/cajero/retiro";
  const data = {
    numTarjeta: numeroTarjeta,
    nip: nip,
    cantidadRetiro: parseInt(cantidadRetiro)
  };

  console.log("Datos de Retiro: " , data);
  fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
    .then(response => response.json())
    .then(responseData => {
      limpiarCampos();
      console.log(responseData);
    })
    .catch(error => {
      console.error('Error:', error);
    });
}

// Función para retiro externo
function retiroExterno(banco) {
  let numeroTarjeta = document.getElementById('numeroTarjeta').value;
  let nip = document.getElementById('nip').value;
  let cantidadRetiro = document.getElementById('cantidadRetiro').value;
  
  // Arreglo con los links de petición de cada banco
  const linksPeticion = {
    bancoA: 'https://www.bancoA.com/peticion',
    bancoB: 'https://www.bancoB.com/peticion',
    bancoC: 'https://www.bancoC.com/peticion'
    // Agrega más bancos y sus respectivos links de petición aquí
  };

  // Obtener el link de petición según el banco recibido como parámetro
  const linkPeticion = linksPeticion[banco];

  // Realizar la petición de retiro externo usando el link correspondiente
  // Código para realizar la petición aquí
  const data = {
    numeroTarjeta: numeroTarjeta,
    nip: nip,
    cantidadRetiro: cantidadRetiro
  };

  fetch(linkPeticion, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
    .then(response => response.json())
    .then(responseData => {
      limpiarCampos();
      console.log(responseData);
    })
    .catch(error => {
      console.error('Error:', error);
    });
}

// Obtener el elemento select del banco
const selectBanco = document.getElementById('bancoSeleccionado');

// Obtener el botón de retiro
const botonRetiro = document.getElementById('botonRetiro');

// Función para cambiar la función del botón de retiro según el banco seleccionado
function cambiarFuncionRetiro() {
  console.log('Cambiando función de retiro');
  const bancoSeleccionado = selectBanco.value;
  console.log('Banco seleccionado: ', bancoSeleccionado);

  if (bancoSeleccionado === '1') {
    botonRetiro.onclick = retiroLocal;
  } else if (bancoSeleccionado === '2' || bancoSeleccionado === '3') {
    botonRetiro.onclick = function() {
      retiroExterno(bancoSeleccionado);
    };
  }
}

// Llamar a la función cambiarFuncionRetiro cuando se cambie la opción del select
selectBanco.addEventListener('change', cambiarFuncionRetiro);

function limpiarCampos() {
  document.getElementById('numeroTarjeta').value = '';
  document.getElementById('nip').value = '';
  document.getElementById('cantidadRetiro').value = '';
}