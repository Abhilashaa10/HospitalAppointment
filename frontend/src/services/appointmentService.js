import axios from "axios";

const BASE_URL = "http://localhost:8080/appointments";

// GET ALL
export const getAllAppointments = () => {
  return axios.get(BASE_URL);
};

// CREATE (IMPORTANT: backend expects ARRAY)
export const createAppointment = (data) => {
  return axios.post(BASE_URL, [data]);
};

// UPDATE
export const updateAppointment = (id, data) => {
  return axios.put(`${BASE_URL}/${id}`, data);
};

// DELETE
export const deleteAppointment = (id) => {
  return axios.delete(`${BASE_URL}/${id}`);
};