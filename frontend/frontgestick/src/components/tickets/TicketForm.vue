<!-- src/components/tickets/TicketForm.vue -->
<template>
  <div class="fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center z-50">
    <div class="bg-white rounded-lg shadow-lg w-96 p-6 relative">
      <h2 class="text-xl font-bold mb-4">
        {{ ticket?.id ? "Editar Ticket" : "Crear Ticket" }}
      </h2>

      <form @submit.prevent="submitForm">
        <div class="mb-4">
          <label class="block text-sm font-medium mb-1">Título</label>
          <input
            v-model="form.title"
            type="text"
            class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
            required
          />
        </div>

        <div class="mb-4">
          <label class="block text-sm font-medium mb-1">Descripción</label>
          <textarea
            v-model="form.description"
            class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
            rows="3"
            required
          ></textarea>
        </div>

        <div class="mb-4">
          <label class="block text-sm font-medium mb-1">Estado</label>
          <select
            v-model="form.status"
            class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
          >
            <option value="OPEN">OPEN</option>
            <option value="IN_PROGRESS">IN_PROGRESS</option>
            <option value="CLOSED">CLOSED</option>
          </select>
        </div>

        <div class="mb-4">
          <label class="block text-sm font-medium mb-1">Solicitante (ID)</label>
          <input
            v-model.number="form.requesterId"
            type="number"
            class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
            required
          />
        </div>

        <div class="mb-4">
          <label class="block text-sm font-medium mb-1">Asignado a (ID)</label>
          <input
            v-model.number="form.assigneeId"
            type="number"
            class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>

        <div class="flex justify-end space-x-2">
          <button
            type="button"
            @click="$emit('close')"
            class="px-4 py-2 rounded bg-gray-300 hover:bg-gray-400"
          >
            Cancelar
          </button>
          <button
            type="submit"
            class="px-4 py-2 rounded bg-blue-500 text-white hover:bg-blue-600"
          >
            {{ ticket?.id ? "Actualizar" : "Crear" }}
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import { ref, watch, reactive } from "vue";
import { createTicket, updateTicket } from "../../services/ticketService";

export default {
  props: {
    ticket: Object, // ticket a editar o null para crear
  },
  setup(props, { emit }) {
    const form = reactive({
      title: "",
      description: "",
      status: "OPEN",
      requesterId: null,
      assigneeId: null,
    });

    // Si ticket cambia (editar), llenamos el formulario
    watch(
      () => props.ticket,
      (newTicket) => {
        if (newTicket) {
          form.title = newTicket.title;
          form.description = newTicket.description;
          form.status = newTicket.status;
          form.requesterId = newTicket.requester?.id || null;
          form.assigneeId = newTicket.assignee?.id || null;
        } else {
          form.title = "";
          form.description = "";
          form.status = "OPEN";
          form.requesterId = null;
          form.assigneeId = null;
        }
      },
      { immediate: true }
    );

    const submitForm = async () => {
      try {
        const payload = {
          title: form.title,
          description: form.description,
          status: form.status,
          requester: { id: form.requesterId },
          assignee: form.assigneeId ? { id: form.assigneeId } : null,
        };

        if (props.ticket?.id) {
          await updateTicket(props.ticket.id, payload);
          alert("Ticket actualizado correctamente!");
        } else {
          await createTicket(payload);
          alert("Ticket creado correctamente!");
        }

        emit("refresh"); // Para actualizar lista en TicketsList.vue
        emit("close");   // Cierra el modal
      } catch (error) {
        console.error(error);
        alert("Error al guardar ticket.");
      }
    };

    return { form, submitForm };
  },
};
</script>

<style scoped>
/* Solo opcional: para que el modal se vea mejor */
</style>