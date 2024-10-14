const seats = document.querySelectorAll('.seat');
const selectedSeatsCount = document.getElementById('selected-seats');

let selectedSeats = [];

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

document.getElementById('reserve-btn').addEventListener('click', () => {
    if (selectedSeats.length > 0) {
        // Logica por implementar
        alert('Reservando asientos: ' + selectedSeats.join(', '));
        // Marcar como reservados
        selectedSeats.forEach(seatNumber => {
            const seat = Array.from(seats).find(seat => seat.getAttribute('data-seat') === seatNumber);
            if (seat) {
                seat.classList.remove('selected');
                seat.classList.add('reserved');
            }
        });
        selectedSeats = [];
        selectedSeatsCount.textContent = 0;
    } else {
        alert('No has seleccionado ningún asiento.');
    }
});
