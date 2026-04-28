import { useEffect, useState } from "react";
import AppointmentForm from "./components/AppointmentForm";
import AppointmentList from "./components/AppointmentList";

import {
  getAllAppointments,
  createAppointment,
  updateAppointment,
  deleteAppointment,
} from "./services/appointmentService";

import "./App.css";

function App() {
  const [appointments, setAppointments] = useState([]);
  const [editing, setEditing] = useState(null);

  // FETCH DATA FROM BACKEND
  const loadAppointments = async () => {
    try {
      const res = await getAllAppointments();
      setAppointments(res.data);
    } catch (err) {
      console.log(err);
      alert("Failed to load appointments");
    }
  };

  useEffect(() => {
    loadAppointments();
  }, []);

  // CREATE / UPDATE
  const handleSubmit = async (formData) => {
    try {
      if (editing) {
        await updateAppointment(editing.id, formData);
        setEditing(null);
      } else {
        await createAppointment(formData);
      }

      loadAppointments();
    } catch (err) {
      console.log(err);
      alert("Operation failed");
    }
  };

  // EDIT
  const handleEdit = (appointment) => {
    setEditing(appointment);
  };

  // DELETE
  const handleDelete = async (id) => {
    try {
      await deleteAppointment(id);
      loadAppointments();
    } catch (err) {
      console.log(err);
      alert("Delete failed");
    }
  };

  return (
    <div className="container">
      <h1>🏥 Hospital Appointment System</h1>

      <AppointmentForm
        onSubmit={handleSubmit}
        editing={editing}
        cancelEdit={() => setEditing(null)}
      />

      <AppointmentList
        appointments={appointments}
        onEdit={handleEdit}
        onDelete={handleDelete}
      />
    </div>
  );
}

export default App;