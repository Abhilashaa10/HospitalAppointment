import { useEffect, useState } from "react";

function AppointmentForm({ onSubmit, editing, cancelEdit }) {
  const [form, setForm] = useState({
    patientName: "",
    doctorName: "",
    appointmentTime: "",
  });

  useEffect(() => {
    if (editing) {
      setForm(editing);
    } else {
      setForm({
        patientName: "",
        doctorName: "",
        appointmentTime: "",
      });
    }
  }, [editing]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(form);
    setForm({
      patientName: "",
      doctorName: "",
      appointmentTime: "",
    });
  };

  return (
    <div className="form-box">
      <h2>{editing ? "Update Appointment" : "Create Appointment"}</h2>

      <form onSubmit={handleSubmit}>
        <input
          name="patientName"
          placeholder="Patient Name"
          value={form.patientName}
          onChange={handleChange}
          required
        />

        <input
          name="doctorName"
          placeholder="Doctor Name"
          value={form.doctorName}
          onChange={handleChange}
          required
        />

        <input
          name="appointmentTime"
          placeholder="yyyy-MM-dd HH:mm:ss"
          value={form.appointmentTime}
          onChange={handleChange}
          required
        />

        <div className="btn-group">
          <button type="submit">
            {editing ? "Update" : "Create"}
          </button>

          {editing && (
            <button type="button" onClick={cancelEdit}>
              Cancel
            </button>
          )}
        </div>
      </form>
    </div>
  );
}

export default AppointmentForm;