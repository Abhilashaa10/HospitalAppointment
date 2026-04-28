import AppointmentCard from "./AppointmentCard";

function AppointmentList({ appointments, onEdit, onDelete }) {
  if (appointments.length === 0) {
    return <p>No appointments found</p>;
  }

  return (
    <div className="list">
      {appointments.map((a) => (
        <AppointmentCard
          key={a.id}
          appointment={a}
          onEdit={onEdit}
          onDelete={onDelete}
        />
      ))}
    </div>
  );
}

export default AppointmentList;