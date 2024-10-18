const seats = document.querySelectorAll('.seat');
const selectedSeatsCount = document.getElementById('selected-seats');
const totalElement = document.getElementById('total');

// Elementos para los boletos
const adultTicketInput = document.getElementById('adultCount');
const childTicketInput = document.getElementById('childCount');
const adultTicketPrice = 20;
const childTicketPrice = 15;

let selectedSeats = [];
let total = 0;

// Función para actualizar el total
function updateTotal() {
    const adultTickets = parseInt(adultTicketInput.value, 10) || 0;
    const childTickets = parseInt(childTicketInput.value, 10) || 0;
    total = (adultTickets * adultTicketPrice) + (childTickets * childTicketPrice);
    totalElement.textContent = total.toFixed(2);
}

// Inicializar el total al cargar
updateTotal();

// Lógica de selección de asientos
seats.forEach(seat => {
    seat.addEventListener('click', () => {
        if (seat.classList.contains('available')) {
            seat.classList.toggle('selected');

            const seatNumber = seat.getAttribute('data-seat');
            if (selectedSeats.includes(seatNumber)) {
                selectedSeats = selectedSeats.filter(seat => seat !== seatNumber);
            } else {
                selectedSeats.push(seatNumber);
            }

            selectedSeatsCount.textContent = selectedSeats.length;
        }
    });
});

// Lógica de los botones de más/menos para las entradas
document.querySelectorAll('.btn-decrement, .btn-increment').forEach((button) => {
    button.addEventListener('click', (event) => {
        const input = event.target.parentNode.querySelector('input');
        let value = parseInt(input.value, 10) || 0;

        if (event.target.classList.contains('btn-increment')) {
            input.value = value + 1;
        } else if (event.target.classList.contains('btn-decrement') && value > 0) {
            input.value = value - 1;
        }

        updateTotal(); // Actualizar el total cuando cambien los boletos
    });
});

// Lógica de reserva de asientos
document.getElementById('reserve-btn').addEventListener('click', () => {
    if (selectedSeats.length > 0) {
        const reserva = {
            pelicula: "Nombre de la película", // Esto lo puedes hacer dinámico si tienes la información
            usuario: "Nombre del usuario",    // Esto debería venir del login o ser dinámico
            asientos: selectedSeats.join(','), // Convertimos los asientos en una cadena
            fecha: "20/12/2024", // Puedes cambiar esto o hacerlo dinámico
            hora: "8:00 PM", // Esto también puede ser dinámico
            total: total.toFixed(2) // Añadimos el total a la reserva
        };

        // Enviar la reserva al servidor
        fetch('/reserva', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(reserva)
        })
        .then(response => response.text())
        .then(data => {
            alert(data); // Mostrar la respuesta del servidor
            // Aquí podrías redirigir al usuario o resetear los asientos seleccionados
            selectedSeats.forEach(seatNumber => {
                const seat = Array.from(seats).find(seat => seat.getAttribute('data-seat') === seatNumber);
                if (seat) {
                    seat.classList.remove('selected');
                    seat.classList.add('reserved');
                }
            });
            selectedSeats = [];
            selectedSeatsCount.textContent = 0;
            updateTotal(); // Reiniciar el total después de la reserva
        })
        .catch(error => console.error('Error:', error));
    } else {
        alert('No has seleccionado ningún asiento.');
    }
});
