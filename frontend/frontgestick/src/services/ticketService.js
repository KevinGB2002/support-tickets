import axios from "axios";

const API_URL = "http://localhost:8080/api/tickets";

export const getTickets = () => axios.get(API_URL);
export const getTicketById = (id) => axios.get(`${API_URL}/${id}`);
export const createTicket = (ticket) => axios.post(API_URL, ticket);
export const updateTicket = (id, ticket) => axios.put(`${API_URL}/${id}`, ticket);
export const deleteTicket = (id) => axios.delete(`${API_URL}/${id}`);
