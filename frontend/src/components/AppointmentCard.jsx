function AppointmentCard({ appointment, onEdit, onDelete }) {
  return (
    <div className="card">
      <h3>{appointment.patientName}</h3>
      <p>Doctor: {appointment.doctorName}</p>
      <p>Time: {appointment.appointmentTime}</p>
      <p>Status: {appointment.status}</p>

      <button onClick={() => onEdit(appointment)}>Edit</button>
      <button onClick={() => onDelete(appointment.id)}>
        Delete
      </button>
    </div>
  );
}

export default AppointmentCard;