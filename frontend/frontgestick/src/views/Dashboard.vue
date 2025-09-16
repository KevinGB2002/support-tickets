<template>
  <div class="p-6">
    <!-- Header -->
    <div class="flex justify-between items-center mb-6">
      <h1 class="text-2xl font-bold">Dashboard de Tickets</h1>
      <button
        @click="logoutUser"
        class="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600"
      >
        Cerrar sesión
      </button>
    </div>

    <!-- Estadísticas -->
    <StatsCards :tickets="tickets" />

    <!-- Filtros -->
    <div class="flex items-center gap-4 my-6">
      <input
        v-model="searchQuery"
        type="text"
        placeholder="Buscar por título..."
        class="border px-3 py-2 rounded-lg w-1/3"
      />
      <select
        v-model="statusFilter"
        class="border px-3 py-2 rounded-lg"
      >
        <option value="">Todos</option>
        <option value="OPEN">Abiertos</option>
        <option value="CLOSED">Cerrados</option>
      </select>
    </div>

    <!-- Tabla de Tickets -->
    <TicketsList
      :tickets="filteredTickets"
      @refresh="loadTickets"
    />
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from "vue";
import { useRouter } from "vue-router";
import { useAuth } from "../composables/useAuth";
import { getTickets } from "../services/ticketService";
import TicketsList from "../components/tickets/TicketsList.vue";
import StatsCards from "../components/tickets/StatsCards.vue";

const router = useRouter();
const { handleLogout } = useAuth();

const tickets = ref([]);
const searchQuery = ref("");
const statusFilter = ref("");

function logoutUser() {
  handleLogout();
  router.push("/login");
}

async function loadTickets() {
  try {
    const { data } = await getTickets();
    tickets.value = data;
  } catch (err) {
    console.error("Error cargando tickets", err);
  }
}

const filteredTickets = computed(() => {
  return tickets.value.filter((t) => {
    const matchesSearch = t.title
      .toLowerCase()
      .includes(searchQuery.value.toLowerCase());
    const matchesStatus = statusFilter.value
      ? t.status === statusFilter.value
      : true;
    return matchesSearch && matchesStatus;
  });
});

onMounted(() => {
  loadTickets();
});
</script>
