<template>
  <div class="flex items-center justify-center h-screen bg-gray-100">
    <div class="bg-white p-8 rounded-lg shadow-lg w-full max-w-sm">
      <h2 class="text-2xl font-bold mb-6 text-center">Iniciar Sesión</h2>

      <form @submit.prevent="onSubmit">
        <div class="mb-4">
          <label class="block text-gray-700">Usuario</label>
          <input
            v-model="username"
            type="text"
            class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:ring-blue-200"
            required
          />
        </div>

        <div class="mb-4">
          <label class="block text-gray-700">Contraseña</label>
          <input
            v-model="password"
            type="password"
            class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:ring-blue-200"
            required
          />
        </div>

        <button
          type="submit"
          class="w-full bg-blue-500 text-white py-2 rounded-lg hover:bg-blue-600 transition"
        >
          Entrar
        </button>

        <p v-if="errorMessage" class="text-red-500 text-sm mt-2">{{ errorMessage }}</p>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useAuth } from "../composables/useAuth";

const router = useRouter();
const { handleLogin } = useAuth();

const username = ref("");
const password = ref("");
const errorMessage = ref("");

function onSubmit() {
  try {
    handleLogin(username.value, password.value);
    router.push("/");
  } catch (err) {
    errorMessage.value = err.message;
  }
}
</script>
