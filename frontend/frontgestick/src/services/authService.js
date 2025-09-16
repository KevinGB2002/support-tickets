import axios from "axios";

const API_URL = "http://localhost:8080/api/auth";

export async function login(username, password) {
  try {
    const response = await axios.post(`${API_URL}/login`, {
      auth: { username, password },
      withCredentials: true, // necesario si usas allowCredentials
    });
    const user = response.data;
    localStorage.setItem("user", JSON.stringify(user));
    return user;
  } catch (error) {
    throw new Error("Credenciales inválidas");
  }
}

export function logout() {
  localStorage.removeItem("user");
}

export function getCurrentUser() {
  const user = localStorage.getItem("user");
  return user ? JSON.parse(user) : null;
}

export function isAuthenticated() {
  return !!getCurrentUser();
}
