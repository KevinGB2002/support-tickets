import { ref } from "vue";
import { getCurrentUser, login, logout, isAuthenticated } from "../services/authService";

const currentUser = ref(getCurrentUser());

export function useAuth() {
  function handleLogin(username, password) {
    const user = login(username, password);
    currentUser.value = user;
    return user;
  }

  function handleLogout() {
    logout();
    currentUser.value = null;
  }

  return {
    currentUser,
    isAuthenticated,
    handleLogin,
    handleLogout,
  };
}
